package com.arizona.game.core;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.arizona.game.core.DualSenseTouchpad;
import com.arizona.game.natives;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.atomic.AtomicLong;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class DualSenseTouchpad {
    private static final Handler UI = new Handler(Looper.getMainLooper());
    private long downTime;
    private boolean lastClicked;
    private Snapshot lastProduced;
    private boolean posted;
    private boolean producedClick;
    private int producedSignature;
    private final TouchpadJitterFilter[] filters = {new TouchpadJitterFilter(), new TouchpadJitterFilter()};
    private final TouchpadClickStabilizer clickStabilizer = new TouchpadClickStabilizer();
    private final DualSenseTouchpadIndicator indicator = new DualSenseTouchpadIndicator();
    private final TouchpadNativeStreamState nativeStream = new TouchpadNativeStreamState();
    private final ArrayDeque<Snapshot> pending = new ArrayDeque<>();
    private final AtomicLong generation = new AtomicLong();
    private Point[] gesture = new Point[0];

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class Point {
        final int id;
        final float nx;
        final float ny;
        final int pointerId;

        Point(int i, float f, float f2) {
            this(i, -1, f, f2);
        }

        Point(int i, int i2, float f, float f2) {
            this.id = i;
            this.pointerId = i2;
            this.nx = f;
            this.ny = f2;
        }

        Point withPointerId(int i) {
            return new Point(this.id, i, this.nx, this.ny);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class Snapshot {
        final boolean cancel;
        final boolean clicked;
        boolean coalescible;
        final long generation;
        final Point[] points;

        Snapshot(boolean z, long j, Point[] pointArr) {
            this(z, false, j, pointArr);
        }

        Snapshot(boolean z, boolean z2, long j, Point[] pointArr) {
            this.clicked = z;
            this.cancel = z2;
            this.generation = j;
            this.points = pointArr;
        }

        int signature() {
            Point[] pointArr = this.points;
            int length = pointArr.length;
            for (Point point : pointArr) {
                length = (length * 131) + point.id;
            }
            return length;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void update(SonyUsbInput sonyUsbInput) {
        float[] fArr;
        boolean z = this.lastClicked;
        if (sonyUsbInput.touchpadClicked && !z) {
            this.clickStabilizer.begin(this.filters, sonyUsbInput.touchMaxY());
        }
        if (sonyUsbInput.touchDataFresh) {
            int i = 0;
            while (true) {
                TouchpadJitterFilter[] touchpadJitterFilterArr = this.filters;
                if (i >= touchpadJitterFilterArr.length) {
                    break;
                }
                touchpadJitterFilterArr[i].update(sonyUsbInput.touch[i].active, sonyUsbInput.touch[i].id, sonyUsbInput.touch[i].x, sonyUsbInput.touch[i].y);
                i++;
            }
        }
        if (sonyUsbInput.touchpadClicked || z) {
            this.clickStabilizer.retain(this.filters);
        }
        Point[] pointArr = new Point[(this.filters[0].active ? 1 : 0) + (this.filters[1].active ? 1 : 0)];
        int i2 = 0;
        int i3 = 0;
        while (true) {
            TouchpadJitterFilter[] touchpadJitterFilterArr2 = this.filters;
            if (i2 >= touchpadJitterFilterArr2.length) {
                break;
            }
            TouchpadJitterFilter touchpadJitterFilter = touchpadJitterFilterArr2[i2];
            if (touchpadJitterFilter.active) {
                float[] fArr2 = {touchpadJitterFilter.x, touchpadJitterFilter.y};
                if (sonyUsbInput.touchpadClicked || z) {
                    fArr = fArr2;
                    this.clickStabilizer.apply(touchpadJitterFilter.id, touchpadJitterFilter.x, touchpadJitterFilter.y, sonyUsbInput.touchMaxY(), fArr);
                } else {
                    fArr = fArr2;
                }
                pointArr[i3] = new Point(touchpadJitterFilter.id, TouchpadCoordinateMapper.x(fArr[0], sonyUsbInput.touchMaxX()), TouchpadCoordinateMapper.y(fArr[1], sonyUsbInput.touchMaxY()));
                i3++;
            }
            i2++;
        }
        Arrays.sort(pointArr, new Comparator() { // from class: com.arizona.game.core.DualSenseTouchpad$$ExternalSyntheticLambda1
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int compare;
                compare = Integer.compare(((DualSenseTouchpad.Point) obj).id, ((DualSenseTouchpad.Point) obj2).id);
                return compare;
            }
        });
        enqueue(new Snapshot(sonyUsbInput.touchpadClicked, this.generation.get(), pointArr));
        boolean z2 = sonyUsbInput.touchpadClicked;
        this.lastClicked = z2;
        if (z2 || !z) {
            return;
        }
        this.clickStabilizer.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void reset() {
        for (TouchpadJitterFilter touchpadJitterFilter : this.filters) {
            touchpadJitterFilter.active = false;
        }
        this.clickStabilizer.clear();
        this.lastClicked = false;
        this.indicator.requestDetach();
        enqueue(new Snapshot(false, true, this.generation.incrementAndGet(), new Point[0]));
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x006a A[Catch: all -> 0x007a, DONT_GENERATE, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0007, B:11:0x001b, B:13:0x0023, B:15:0x0025, B:17:0x0030, B:22:0x0038, B:24:0x0044, B:26:0x0054, B:27:0x0059, B:29:0x006a, B:31:0x006c, B:32:0x006e, B:7:0x000d, B:9:0x0019), top: B:38:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x006c A[Catch: all -> 0x007a, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0007, B:11:0x001b, B:13:0x0023, B:15:0x0025, B:17:0x0030, B:22:0x0038, B:24:0x0044, B:26:0x0054, B:27:0x0059, B:29:0x006a, B:31:0x006c, B:32:0x006e, B:7:0x000d, B:9:0x0019), top: B:38:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void enqueue(Snapshot snapshot) {
        boolean z;
        synchronized (this.pending) {
            if (snapshot.cancel) {
                this.pending.clear();
            } else if (snapshot.generation != this.generation.get()) {
                return;
            }
            if (sameSnapshot(this.lastProduced, snapshot)) {
                return;
            }
            int signature = snapshot.signature();
            if (snapshot.clicked == this.producedClick && signature == this.producedSignature) {
                z = false;
                snapshot.coalescible = !z;
                if (!this.pending.isEmpty() && TouchpadQueuePolicy.shouldReplaceLast(z, this.pending.peekLast().coalescible)) {
                    this.pending.removeLast();
                }
                this.pending.addLast(snapshot);
                this.producedClick = snapshot.clicked;
                this.producedSignature = signature;
                this.lastProduced = snapshot;
                if (this.posted) {
                    this.posted = true;
                    UI.post(new Runnable() { // from class: com.arizona.game.core.DualSenseTouchpad$$ExternalSyntheticLambda0
                        @Override // java.lang.Runnable
                        public final void run() {
                            DualSenseTouchpad.this.drain();
                        }
                    });
                    return;
                }
                return;
            }
            z = true;
            snapshot.coalescible = !z;
            if (!this.pending.isEmpty()) {
                this.pending.removeLast();
            }
            this.pending.addLast(snapshot);
            this.producedClick = snapshot.clicked;
            this.producedSignature = signature;
            this.lastProduced = snapshot;
            if (this.posted) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void drain() {
        Snapshot pollFirst;
        while (true) {
            synchronized (this.pending) {
                pollFirst = this.pending.pollFirst();
                if (pollFirst == null) {
                    this.posted = false;
                    return;
                }
            }
            dispatch(pollFirst);
        }
    }

    private void dispatch(Snapshot snapshot) {
        float f;
        float f2;
        float f3;
        float f4;
        if (snapshot.generation != this.generation.get()) {
            return;
        }
        if (snapshot.cancel) {
            this.indicator.detach();
            cancelGesture();
            return;
        }
        int i = 0;
        if (snapshot.points.length > 0) {
            f = snapshot.points[0].nx;
            f2 = snapshot.points[0].ny;
            i = 1;
        } else {
            f = 0.0f;
            f2 = 0.0f;
        }
        if (snapshot.points.length > 1) {
            i |= 2;
            float f5 = snapshot.points[1].nx;
            f4 = snapshot.points[1].ny;
            f3 = f5;
        } else {
            f3 = 0.0f;
            f4 = 0.0f;
        }
        this.indicator.update(JNIActivity.getContext(), i, f, f2, f3, f4);
        if (!snapshot.clicked) {
            refreshGesture(snapshot.points);
            finishGesture();
            return;
        }
        reconcileGesture(snapshot.points);
    }

    private void refreshGesture(Point[] pointArr) {
        int i = 0;
        while (true) {
            Point[] pointArr2 = this.gesture;
            if (i >= pointArr2.length) {
                return;
            }
            Point find = find(pointArr, pointArr2[i].id);
            if (find != null) {
                this.gesture[i] = new Point(find.id, this.gesture[i].pointerId, find.nx, find.ny);
            }
            i++;
        }
    }

    private void reconcileGesture(Point[] pointArr) {
        Point point;
        int length = this.gesture.length;
        Point[] pointArr2 = new Point[length];
        int i = 0;
        while (true) {
            Point[] pointArr3 = this.gesture;
            if (i >= pointArr3.length) {
                break;
            }
            Point find = find(pointArr, pointArr3[i].id);
            if (find == null) {
                point = this.gesture[i];
            } else {
                point = new Point(find.id, this.gesture[i].pointerId, find.nx, find.ny);
            }
            pointArr2[i] = point;
            i++;
        }
        int i2 = length - 1;
        boolean z = false;
        while (i2 >= 0) {
            if (find(pointArr, pointArr2[i2].id) == null) {
                if (pointArr2.length == 1) {
                    send(1, pointArr2, 0);
                } else {
                    send(6, pointArr2, i2);
                }
                pointArr2 = remove(pointArr2, i2);
                z = true;
            }
            i2--;
            z = z;
        }
        int length2 = pointArr.length;
        int i3 = 0;
        boolean z2 = z;
        while (i3 < length2) {
            Point point2 = pointArr[i3];
            if (find(pointArr2, point2.id) == null) {
                Point withPointerId = point2.withPointerId(usedPointerId(pointArr2, 0) ? 1 : 0);
                Point[] pointArr4 = (Point[]) Arrays.copyOf(pointArr2, pointArr2.length + 1);
                pointArr4[pointArr2.length] = withPointerId;
                if (pointArr2.length == 0) {
                    this.downTime = SystemClock.uptimeMillis();
                    if (!send(0, pointArr4, 0)) {
                        return;
                    }
                } else {
                    send(5, pointArr4, pointArr2.length);
                }
                z2 = true;
                pointArr2 = pointArr4;
            }
            i3++;
            z2 = z2;
        }
        this.gesture = pointArr2;
        if (z2 || pointArr2.length == 0) {
            return;
        }
        send(2, pointArr2, -1);
    }

    private void finishGesture() {
        Point[] pointArr = this.gesture;
        if (pointArr.length == 2) {
            send(6, pointArr, 1);
        }
        Point[] pointArr2 = this.gesture;
        if (pointArr2.length != 0) {
            send(1, new Point[]{pointArr2[0]}, 0);
        }
        this.gesture = new Point[0];
    }

    private void cancelGesture() {
        boolean isActive = this.nativeStream.isActive();
        Point[] pointArr = this.gesture;
        if (pointArr.length != 0) {
            send(3, pointArr, 0, isActive);
        }
        this.gesture = new Point[0];
        if (this.nativeStream.takeCancel()) {
            natives.GamepadMultiTouch(3, 0, 0, 0, 0, 0, 0, 0);
        }
    }

    private boolean send(int i, Point[] pointArr, int i2) {
        return send(i, pointArr, i2, true);
    }

    private boolean send(int i, Point[] pointArr, int i2, boolean z) {
        JNIActivity context = JNIActivity.getContext();
        if (context != null && pointArr.length != 0) {
            View decorView = context.getWindow().getDecorView();
            int width = decorView.getWidth();
            int height = decorView.getHeight();
            if (width > 0 && height > 0) {
                MotionEvent.PointerProperties[] pointerPropertiesArr = new MotionEvent.PointerProperties[pointArr.length];
                MotionEvent.PointerCoords[] pointerCoordsArr = new MotionEvent.PointerCoords[pointArr.length];
                for (int i3 = 0; i3 < pointArr.length; i3++) {
                    MotionEvent.PointerProperties pointerProperties = new MotionEvent.PointerProperties();
                    pointerProperties.id = pointArr[i3].pointerId;
                    pointerProperties.toolType = 1;
                    pointerPropertiesArr[i3] = pointerProperties;
                    MotionEvent.PointerCoords pointerCoords = new MotionEvent.PointerCoords();
                    pointerCoords.x = pointArr[i3].nx * (width - 1);
                    pointerCoords.y = pointArr[i3].ny * (height - 1);
                    pointerCoords.pressure = 1.0f;
                    pointerCoords.size = 1.0f;
                    pointerCoordsArr[i3] = pointerCoords;
                }
                MotionEvent obtain = MotionEvent.obtain(this.downTime, SystemClock.uptimeMillis(), (i == 5 || i == 6) ? (i2 << 8) | i : i, pointArr.length, pointerPropertiesArr, pointerCoordsArr, 0, 0, 1.0f, 1.0f, 0, 0, InputDeviceCompat.SOURCE_TOUCHSCREEN, 0);
                try {
                    if (context.dispatchGamepadTouchEvent(obtain, z)) {
                        this.nativeStream.forwarded(i, (i2 < 0 || i2 >= pointArr.length) ? -1 : pointArr[i2].pointerId);
                    }
                    return true;
                } finally {
                    obtain.recycle();
                }
            }
        }
        return false;
    }

    private static boolean sameIds(Point[] pointArr, Point[] pointArr2) {
        if (pointArr.length != pointArr2.length) {
            return false;
        }
        for (int i = 0; i < pointArr.length; i++) {
            if (pointArr[i].id != pointArr2[i].id) {
                return false;
            }
        }
        return true;
    }

    private static Point find(Point[] pointArr, int i) {
        for (Point point : pointArr) {
            if (point.id == i) {
                return point;
            }
        }
        return null;
    }

    private static Point[] remove(Point[] pointArr, int i) {
        Point[] pointArr2 = new Point[pointArr.length - 1];
        System.arraycopy(pointArr, 0, pointArr2, 0, i);
        System.arraycopy(pointArr, i + 1, pointArr2, i, (pointArr.length - i) - 1);
        return pointArr2;
    }

    private static boolean usedPointerId(Point[] pointArr, int i) {
        for (Point point : pointArr) {
            if (point.pointerId == i) {
                return true;
            }
        }
        return false;
    }

    private static boolean sameSnapshot(Snapshot snapshot, Snapshot snapshot2) {
        if (snapshot != null && snapshot.clicked == snapshot2.clicked && snapshot.cancel == snapshot2.cancel && snapshot.generation == snapshot2.generation && sameIds(snapshot.points, snapshot2.points)) {
            for (int i = 0; i < snapshot.points.length; i++) {
                if (snapshot.points[i].nx != snapshot2.points[i].nx || snapshot.points[i].ny != snapshot2.points[i].ny) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
