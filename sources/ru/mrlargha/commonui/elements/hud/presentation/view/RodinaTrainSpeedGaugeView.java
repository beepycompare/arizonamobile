package ru.mrlargha.commonui.elements.hud.presentation.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import ru.mrlargha.commonui.R;
/* compiled from: RodinaTrainSpeedGaugeView.kt */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 /2\u00020\u0001:\u0001/B+\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u001a\u0002\b\n¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0007H\u0014J\b\u0010\u001d\u001a\u00020\u0019H\u0014J\u0010\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020 H\u0014J\u0010\u0010!\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020\u0007H\u0002J\u0010\u0010#\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020\u0007H\u0002J\b\u0010$\u001a\u00020%H\u0002JL\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120'2\u0006\u0010(\u001a\u00020\u00122\u0006\u0010)\u001a\u00020\u00122\u0006\u0010*\u001a\u00020\u00122\u0006\u0010+\u001a\u00020\u00122\u0006\u0010,\u001a\u00020\u00122\u0006\u0010-\u001a\u00020\u00122\u0006\u0010.\u001a\u00020\u0012H\u0002R$\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/view/RodinaTrainSpeedGaugeView;", "Lru/mrlargha/commonui/elements/hud/presentation/view/TrainSpeedGaugeView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Lkotlin/jvm/JvmOverloads;", "value", "speedKmh", "getSpeedKmh", "()I", "setSpeedKmh", "(I)V", "animatedSpeedKmh", "", "pinAnimator", "Landroid/animation/ValueAnimator;", "gaugeFaceDrawable", "Landroid/graphics/drawable/Drawable;", "pinDrawable", "onVisibilityChanged", "", "changedView", "Landroid/view/View;", "visibility", "onDetachedFromWindow", "onDraw", "canvas", "Landroid/graphics/Canvas;", "applyPinTarget", TypedValues.AttributesType.S_TARGET, "snapPinTo", "canAnimatePin", "", "clampPinCenter", "Lkotlin/Pair;", "centerX", "centerY", "angleDeg", "scaleX", "scaleY", "viewWidth", "viewHeight", "Companion", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class RodinaTrainSpeedGaugeView extends TrainSpeedGaugeView {
    @Deprecated
    public static final float ARC_CENTER_X = 187.8091f;
    @Deprecated
    public static final float ARC_CENTER_Y = 219.6874f;
    private static final Companion Companion = new Companion(null);
    @Deprecated
    public static final int MAX_SPEED_KMH = 160;
    @Deprecated
    public static final long PIN_ANIMATION_DURATION_MS = 250;
    @Deprecated
    public static final float PIN_ORBIT_SCALE = 0.934f;
    @Deprecated
    public static final float PIN_RADIUS = 211.8604f;
    @Deprecated
    public static final float PIN_ROTATION_OFFSET = 90.0f;
    @Deprecated
    public static final float PIN_ROUND_LOCAL_X = 12.5f;
    @Deprecated
    public static final float PIN_ROUND_LOCAL_Y = 7.827f;
    @Deprecated
    public static final float PIN_ROUND_RADIUS = 7.827f;
    @Deprecated
    public static final int PIN_ROUND_SAMPLES = 12;
    @Deprecated
    public static final float PIN_SIZE = 25.0f;
    @Deprecated
    public static final float START_ANGLE = -155.031f;
    @Deprecated
    public static final float SWEEP_ANGLE = 130.2335f;
    @Deprecated
    public static final float VIEWBOX_HEIGHT = 135.0f;
    @Deprecated
    public static final float VIEWBOX_WIDTH = 376.0f;
    private float animatedSpeedKmh;
    private final Drawable gaugeFaceDrawable;
    private ValueAnimator pinAnimator;
    private final Drawable pinDrawable;
    private int speedKmh;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RodinaTrainSpeedGaugeView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public RodinaTrainSpeedGaugeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RodinaTrainSpeedGaugeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Drawable drawable = AppCompatResources.getDrawable(context, R.drawable.ic_train_hud_speed_gauge_face);
        this.gaugeFaceDrawable = drawable != null ? drawable.mutate() : null;
        Drawable drawable2 = AppCompatResources.getDrawable(context, R.drawable.ic_train_hud_speed_pin);
        this.pinDrawable = drawable2 != null ? drawable2.mutate() : null;
    }

    public /* synthetic */ RodinaTrainSpeedGaugeView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    @Override // ru.mrlargha.commonui.elements.hud.presentation.view.TrainSpeedGaugeView
    public int getSpeedKmh() {
        return this.speedKmh;
    }

    @Override // ru.mrlargha.commonui.elements.hud.presentation.view.TrainSpeedGaugeView
    public void setSpeedKmh(int i) {
        int coerceIn = RangesKt.coerceIn(i, 0, (int) MAX_SPEED_KMH);
        if (this.speedKmh == coerceIn) {
            return;
        }
        this.speedKmh = coerceIn;
        applyPinTarget(coerceIn);
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View changedView, int i) {
        Intrinsics.checkNotNullParameter(changedView, "changedView");
        super.onVisibilityChanged(changedView, i);
        if (isShown()) {
            return;
        }
        snapPinTo(getSpeedKmh());
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        snapPinTo(getSpeedKmh());
        super.onDetachedFromWindow();
    }

    @Override // ru.mrlargha.commonui.elements.hud.presentation.view.TrainSpeedGaugeView, android.view.View
    protected void onDraw(Canvas canvas) {
        Drawable drawable;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (getWidth() == 0 || getHeight() == 0 || (drawable = this.gaugeFaceDrawable) == null) {
            return;
        }
        drawable.setBounds(0, 0, getWidth(), getHeight());
        drawable.draw(canvas);
        Drawable drawable2 = this.pinDrawable;
        if (drawable2 == null) {
            return;
        }
        float width = getWidth() / 376.0f;
        float height = getHeight() / 135.0f;
        float f = ((this.animatedSpeedKmh / 160.0f) * 130.2335f) - 155.031f;
        double radians = Math.toRadians(f);
        double radians2 = Math.toRadians(-89.91425323486328d);
        float cos = (((float) Math.cos(radians2)) * 211.8604f) + 187.8091f;
        float sin = (((float) Math.sin(radians2)) * 211.8604f) + 219.6874f;
        Pair<Float, Float> clampPinCenter = clampPinCenter((cos + ((((((float) Math.cos(radians)) * 211.8604f) + 187.8091f) - cos) * 0.934f)) * width, (sin + ((((((float) Math.sin(radians)) * 211.8604f) + 219.6874f) - sin) * 0.934f)) * height, f, width, height, getWidth(), getHeight());
        float floatValue = clampPinCenter.getFirst().floatValue();
        float floatValue2 = clampPinCenter.getSecond().floatValue();
        int coerceAtLeast = RangesKt.coerceAtLeast(MathKt.roundToInt(width * 25.0f), 1);
        int coerceAtLeast2 = RangesKt.coerceAtLeast(MathKt.roundToInt(25.0f * height), 1);
        canvas.save();
        canvas.translate(floatValue, floatValue2);
        canvas.rotate(f + 90.0f);
        canvas.translate(width * (-12.5f), height * (-7.827f));
        drawable2.setBounds(0, 0, coerceAtLeast, coerceAtLeast2);
        drawable2.draw(canvas);
        canvas.restore();
    }

    private final void applyPinTarget(int i) {
        if (!canAnimatePin()) {
            snapPinTo(i);
            return;
        }
        float f = this.animatedSpeedKmh;
        float f2 = i;
        if (f == f2) {
            snapPinTo(i);
            return;
        }
        ValueAnimator valueAnimator = this.pinAnimator;
        if (valueAnimator == null) {
            valueAnimator = new ValueAnimator();
            valueAnimator.setDuration(250L);
            valueAnimator.setInterpolator(new DecelerateInterpolator());
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ru.mrlargha.commonui.elements.hud.presentation.view.RodinaTrainSpeedGaugeView$$ExternalSyntheticLambda0
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    RodinaTrainSpeedGaugeView.applyPinTarget$lambda$0$0(RodinaTrainSpeedGaugeView.this, valueAnimator2);
                }
            });
            this.pinAnimator = valueAnimator;
        }
        valueAnimator.cancel();
        valueAnimator.setFloatValues(f, f2);
        valueAnimator.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void applyPinTarget$lambda$0$0(RodinaTrainSpeedGaugeView rodinaTrainSpeedGaugeView, ValueAnimator it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Object animatedValue = it.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        rodinaTrainSpeedGaugeView.animatedSpeedKmh = ((Float) animatedValue).floatValue();
        rodinaTrainSpeedGaugeView.invalidate();
    }

    private final void snapPinTo(int i) {
        ValueAnimator valueAnimator = this.pinAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.animatedSpeedKmh = i;
        invalidate();
    }

    private final boolean canAnimatePin() {
        if (isShown() && isAttachedToWindow()) {
            return Build.VERSION.SDK_INT < 26 || ValueAnimator.areAnimatorsEnabled();
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0098  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Pair<Float, Float> clampPinCenter(float f, float f2, float f3, float f4, float f5, float f6, float f7) {
        float f8;
        float f9;
        float f10;
        float f11;
        double radians = Math.toRadians(f3 + 90.0f);
        float cos = (float) Math.cos(radians);
        float sin = (float) Math.sin(radians);
        Ref.FloatRef floatRef = new Ref.FloatRef();
        floatRef.element = Float.POSITIVE_INFINITY;
        Ref.FloatRef floatRef2 = new Ref.FloatRef();
        floatRef2.element = Float.POSITIVE_INFINITY;
        Ref.FloatRef floatRef3 = new Ref.FloatRef();
        floatRef3.element = Float.NEGATIVE_INFINITY;
        Ref.FloatRef floatRef4 = new Ref.FloatRef();
        floatRef4.element = Float.NEGATIVE_INFINITY;
        for (int i = 0; i < 12; i++) {
            double d = (i * 6.283185307179586d) / 12.0d;
            clampPinCenter$includeLocal(f4, f5, f, cos, sin, f2, floatRef, floatRef2, floatRef3, floatRef4, (((float) Math.cos(d)) * 7.827f) + 12.5f, (((float) Math.sin(d)) * 7.827f) + 7.827f);
        }
        clampPinCenter$includeLocal(f4, f5, f, cos, sin, f2, floatRef, floatRef2, floatRef3, floatRef4, 12.5f, 25.0f);
        if (floatRef.element < 0.0f) {
            f9 = floatRef.element;
        } else if (floatRef3.element > f6) {
            f9 = floatRef3.element - f6;
        } else {
            f8 = f;
            if (floatRef2.element >= 0.0f) {
                f11 = floatRef2.element;
            } else if (floatRef4.element > f7) {
                f11 = floatRef4.element - f7;
            } else {
                f10 = f2;
                return TuplesKt.to(Float.valueOf(f8), Float.valueOf(f10));
            }
            f10 = f2 - f11;
            return TuplesKt.to(Float.valueOf(f8), Float.valueOf(f10));
        }
        f8 = f - f9;
        if (floatRef2.element >= 0.0f) {
        }
        f10 = f2 - f11;
        return TuplesKt.to(Float.valueOf(f8), Float.valueOf(f10));
    }

    private static final void clampPinCenter$includeLocal(float f, float f2, float f3, float f4, float f5, float f6, Ref.FloatRef floatRef, Ref.FloatRef floatRef2, Ref.FloatRef floatRef3, Ref.FloatRef floatRef4, float f7, float f8) {
        float f9 = (f7 - 12.5f) * f;
        float f10 = (f8 - 7.827f) * f2;
        float f11 = (f3 + (f9 * f4)) - (f10 * f5);
        float f12 = f6 + (f9 * f5) + (f10 * f4);
        if (f11 < floatRef.element) {
            floatRef.element = f11;
        }
        if (f12 < floatRef2.element) {
            floatRef2.element = f12;
        }
        if (f11 > floatRef3.element) {
            floatRef3.element = f11;
        }
        if (f12 > floatRef4.element) {
            floatRef4.element = f12;
        }
    }

    /* compiled from: RodinaTrainSpeedGaugeView.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0010\t\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/view/RodinaTrainSpeedGaugeView$Companion;", "", "<init>", "()V", "MAX_SPEED_KMH", "", "VIEWBOX_WIDTH", "", "VIEWBOX_HEIGHT", "ARC_CENTER_X", "ARC_CENTER_Y", "PIN_RADIUS", "PIN_ORBIT_SCALE", "PIN_SIZE", "PIN_ROUND_LOCAL_X", "PIN_ROUND_LOCAL_Y", "PIN_ROUND_RADIUS", "PIN_ROUND_SAMPLES", "START_ANGLE", "SWEEP_ANGLE", "PIN_ROTATION_OFFSET", "PIN_ANIMATION_DURATION_MS", "", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
