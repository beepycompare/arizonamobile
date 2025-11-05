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
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010!\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0016J\u0010\u0010&\u001a\u00020\u00052\u0006\u0010'\u001a\u00020%H\u0002J\u0010\u0010(\u001a\u00020\u00052\u0006\u0010'\u001a\u00020%H\u0002J\u0010\u0010)\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\u0005H\u0002J\u0010\u0010+\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\u0005H\u0002J \u0010-\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u00052\u0006\u0010/\u001a\u00020\u00052\u0006\u00100\u001a\u00020\u0005H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lru/mrlargha/commonui/elements/items3d/ModelRotationTouchListener;", "Landroid/view/View$OnTouchListener;", "modelId", "", "sensitivityDegPerPx", "", "smoothing", "scene", "Lru/mrlargha/commonui/elements/items3d/ItemScene;", "rotationX", "rotationY", "rotationZ", "zoom", "mainAxis", "", "<init>", "(IFFLru/mrlargha/commonui/elements/items3d/ItemScene;FFFFLjava/lang/String;)V", "rotX", "rotY", "rotZ", "lastX", "lastY", "vx", "vy", "vz", "pinching", "", "pinchStartDist", "pinchStartScale", "currentScale", "minScale", "maxScale", "scaleSmoothing", "onTouch", "v", "Landroid/view/View;", NotificationCompat.CATEGORY_EVENT, "Landroid/view/MotionEvent;", "distanceBetweenPointers", "ev", "angleBetweenPointers", "normalizeDeltaAngle", "d", "wrapAngle", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "lerp", "from", TypedValues.TransitionType.S_TO, "t", "CommonUI_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ModelRotationTouchListener implements View.OnTouchListener {
    private float currentScale;
    private float lastX;
    private float lastY;
    private final String mainAxis;
    private final float maxScale;
    private final float minScale;
    private final int modelId;
    private float pinchStartDist;
    private float pinchStartScale;
    private boolean pinching;
    private float rotX;
    private float rotY;
    private float rotZ;
    private final float rotationX;
    private final float rotationY;
    private final float rotationZ;
    private final float scaleSmoothing;
    private final ItemScene scene;
    private final float sensitivityDegPerPx;
    private final float smoothing;
    private float vx;
    private float vy;
    private float vz;
    private final float zoom;

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

    public ModelRotationTouchListener(int i, float f, float f2, ItemScene scene, float f3, float f4, float f5, float f6, String mainAxis) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        Intrinsics.checkNotNullParameter(mainAxis, "mainAxis");
        this.modelId = i;
        this.sensitivityDegPerPx = f;
        this.smoothing = f2;
        this.scene = scene;
        this.rotationX = f3;
        this.rotationY = f4;
        this.rotationZ = f5;
        this.zoom = f6;
        this.mainAxis = mainAxis;
        this.rotX = wrapAngle(f3);
        this.rotY = wrapAngle(f4);
        this.rotZ = wrapAngle(f5);
        this.pinchStartScale = 1.0f;
        this.currentScale = 1.5f * f6;
        this.minScale = 0.5f * f6;
        this.maxScale = f6 * 2.5f;
        this.scaleSmoothing = 0.2f;
    }

    public /* synthetic */ ModelRotationTouchListener(int i, float f, float f2, ItemScene itemScene, float f3, float f4, float f5, float f6, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? 0.25f : f, (i2 & 4) != 0 ? 0.15f : f2, itemScene, (i2 & 16) != 0 ? 0.0f : f3, (i2 & 32) != 0 ? 0.0f : f4, (i2 & 64) != 0 ? 0.0f : f5, (i2 & 128) != 0 ? 1.5f : f6, (i2 & 256) != 0 ? "y" : str);
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
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
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
                } else if (this.pinching && event.getPointerCount() >= 2) {
                    float lerp = lerp(this.currentScale, RangesKt.coerceIn(this.pinchStartScale * (RangesKt.coerceAtLeast(distanceBetweenPointers(event), 1.0f) / this.pinchStartDist), this.minScale, this.maxScale), this.scaleSmoothing);
                    this.currentScale = lerp;
                    this.scene.scaleModel(this.modelId, (this.maxScale + this.minScale) - lerp);
                } else if (this.rotationY == 0.0f) {
                    float x = event.getX();
                    float y = event.getY();
                    float f = x - this.lastX;
                    this.lastX = x;
                    this.lastY = y;
                    float f2 = this.sensitivityDegPerPx;
                    this.vx = lerp(this.vx, (y - this.lastY) * f2, this.smoothing);
                    float lerp2 = lerp(this.vy, f * f2, this.smoothing);
                    this.vy = lerp2;
                    float f3 = this.rotX - this.vx;
                    this.rotX = f3;
                    this.rotZ += lerp2;
                    this.rotX = wrapAngle(f3);
                    float wrapAngle = wrapAngle(this.rotZ);
                    this.rotZ = wrapAngle;
                    this.scene.rotateModel(this.modelId, this.rotX, this.rotY, wrapAngle);
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
