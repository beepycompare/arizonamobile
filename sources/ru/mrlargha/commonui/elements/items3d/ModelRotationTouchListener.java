package ru.mrlargha.commonui.elements.items3d;

import android.view.MotionEvent;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
/* compiled from: listener.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u001fH\u0002J\u0010\u0010\"\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u001fH\u0002J\u0010\u0010#\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u0005H\u0002J\u0010\u0010%\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\u0005H\u0002J \u0010'\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u0005H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lru/mrlargha/commonui/elements/items3d/ModelRotationTouchListener;", "Landroid/view/View$OnTouchListener;", "modelId", "", "sensitivityDegPerPx", "", "smoothing", "scene", "Lru/mrlargha/commonui/elements/items3d/ItemScene;", "<init>", "(IFFLru/mrlargha/commonui/elements/items3d/ItemScene;)V", "rotX", "rotY", "rotZ", "lastX", "lastY", "vx", "vy", "vz", "pinching", "", "pinchStartDist", "pinchStartScale", "currentScale", "minScale", "maxScale", "scaleSmoothing", "onTouch", "v", "Landroid/view/View;", NotificationCompat.CATEGORY_EVENT, "Landroid/view/MotionEvent;", "distanceBetweenPointers", "ev", "angleBetweenPointers", "normalizeDeltaAngle", "d", "wrapAngle", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "lerp", "from", TypedValues.TransitionType.S_TO, "t", "CommonUI_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ModelRotationTouchListener implements View.OnTouchListener {
    private float currentScale;
    private float lastX;
    private float lastY;
    private final float maxScale;
    private final float minScale;
    private final int modelId;
    private float pinchStartDist;
    private float pinchStartScale;
    private boolean pinching;
    private float rotX;
    private float rotY;
    private float rotZ;
    private final float scaleSmoothing;
    private final ItemScene scene;
    private final float sensitivityDegPerPx;
    private final float smoothing;
    private float vx;
    private float vy;
    private float vz;

    private final float lerp(float f, float f2, float f3) {
        return f + ((f2 - f) * f3);
    }

    private final float normalizeDeltaAngle(float f) {
        while (f > 180.0f) {
            f -= 360.0f;
        }
        while (f < -180.0f) {
            f += 360.0f;
        }
        return f;
    }

    private final float wrapAngle(float f) {
        float f2 = f % 360.0f;
        if (f2 > 180.0f) {
            f2 -= 360.0f;
        }
        return f2 < -180.0f ? f2 + 360.0f : f2;
    }

    public ModelRotationTouchListener(int i, float f, float f2, ItemScene scene) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        this.modelId = i;
        this.sensitivityDegPerPx = f;
        this.smoothing = f2;
        this.scene = scene;
        this.pinchStartScale = 1.0f;
        this.currentScale = 1.0f;
        this.maxScale = 1.5f;
        this.scaleSmoothing = 0.2f;
    }

    public /* synthetic */ ModelRotationTouchListener(int i, float f, float f2, ItemScene itemScene, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? 0.25f : f, (i2 & 4) != 0 ? 0.15f : f2, itemScene);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View v, MotionEvent event) {
        Intrinsics.checkNotNullParameter(v, "v");
        Intrinsics.checkNotNullParameter(event, "event");
        int actionMasked = event.getActionMasked();
        if (actionMasked == 0) {
            this.lastX = event.getX();
            this.lastY = event.getY();
        } else {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    if (this.pinching && event.getPointerCount() >= 2) {
                        float lerp = lerp(this.currentScale, RangesKt.coerceIn(this.pinchStartScale * (RangesKt.coerceAtLeast(distanceBetweenPointers(event), 1.0f) / this.pinchStartDist), this.minScale, this.maxScale), this.scaleSmoothing);
                        this.currentScale = lerp;
                        this.scene.scaleModel(this.modelId, 2.0f - lerp);
                    } else {
                        float x = event.getX();
                        float y = event.getY();
                        float f = x - this.lastX;
                        this.lastX = x;
                        this.lastY = y;
                        float f2 = this.sensitivityDegPerPx;
                        this.vx = lerp(this.vx, (y - this.lastY) * f2, this.smoothing);
                        float lerp2 = lerp(this.vy, f * f2, this.smoothing);
                        this.vy = lerp2;
                        this.rotX += this.vx;
                        this.rotY += lerp2;
                    }
                    this.rotX = wrapAngle(this.rotX);
                    this.rotY = wrapAngle(this.rotY);
                    float wrapAngle = wrapAngle(this.rotZ);
                    this.rotZ = wrapAngle;
                    this.scene.rotateModel(this.modelId, -this.rotX, wrapAngle, this.rotY);
                } else if (actionMasked != 3) {
                    if (actionMasked == 5) {
                        if (event.getPointerCount() >= 2) {
                            this.pinching = true;
                            this.pinchStartDist = RangesKt.coerceAtLeast(distanceBetweenPointers(event), 1.0f);
                            this.pinchStartScale = this.currentScale;
                        }
                    } else if (actionMasked == 6 && event.getPointerCount() - 1 < 2) {
                        this.pinching = false;
                        this.vz = 0.0f;
                    }
                }
            }
            this.pinching = false;
            this.vx = 0.0f;
            this.vy = 0.0f;
            this.vz = 0.0f;
        }
        return true;
    }

    private final float distanceBetweenPointers(MotionEvent motionEvent) {
        float x = motionEvent.getX(0);
        float y = motionEvent.getY(0);
        float x2 = motionEvent.getX(1) - x;
        float y2 = motionEvent.getY(1) - y;
        return (float) Math.sqrt((x2 * x2) + (y2 * y2));
    }

    private final float angleBetweenPointers(MotionEvent motionEvent) {
        float x = motionEvent.getX(0);
        return (float) Math.toDegrees((float) Math.atan2(motionEvent.getY(1) - motionEvent.getY(0), motionEvent.getX(1) - x));
    }
}
