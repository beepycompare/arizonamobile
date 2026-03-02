package ru.mrlargha.commonui.elements.hud.presentation.hud_screens.chicken_charge;

import android.animation.ValueAnimator;
import android.os.Handler;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;
import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
/* compiled from: ChickenCharge.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001bJ\u0006\u0010\u001c\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\fJ)\u0010\u001d\u001a\u00020\u00172!\u0010\u001e\u001a\u001d\u0012\u0013\u0012\u00110\f¢\u0006\f\b \u0012\b\b!\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u00170\u001fJ \u0010#\u001a\u00020\u00172\u0006\u0010$\u001a\u00020\f2\u0006\u0010%\u001a\u00020\f2\u0006\u0010&\u001a\u00020\u001bH\u0002J\u0010\u0010'\u001a\u00020\f2\u0006\u0010(\u001a\u00020\fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0015¨\u0006)"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/hud_screens/chicken_charge/PercentMover;", "", "track", "Landroid/view/View;", "marker", "<init>", "(Landroid/view/View;Landroid/view/View;)V", "handler", "Landroid/os/Handler;", "running", "", "maxX", "", "currentPercent", "getCurrentPercent", "()F", "setCurrentPercent", "(F)V", "tickAnimator", "Landroid/animation/ValueAnimator;", "lastTouchX", "Ljava/lang/Float;", TtmlNode.START, "", "speed", "", "tickMs", "", "stop", "attachStopOnClick", "onStop", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "percent", "animateBetweenPercents", "fromPercent", "toPercent", "durationMs", "computePercentFromTouch", "touchX", "CommonUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class PercentMover {
    private float currentPercent;
    private final Handler handler;
    private Float lastTouchX;
    private final View marker;
    private float maxX;
    private boolean running;
    private ValueAnimator tickAnimator;
    private final View track;

    public PercentMover(View track, View marker) {
        Intrinsics.checkNotNullParameter(track, "track");
        Intrinsics.checkNotNullParameter(marker, "marker");
        this.track = track;
        this.marker = marker;
        this.handler = new Handler(Looper.getMainLooper());
    }

    public final float getCurrentPercent() {
        return this.currentPercent;
    }

    public final void setCurrentPercent(float f) {
        this.currentPercent = f;
    }

    public static /* synthetic */ void start$default(PercentMover percentMover, int i, long j, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            j = 75;
        }
        percentMover.start(i, j);
    }

    public final void start(final int i, final long j) {
        stop();
        this.track.post(new Runnable() { // from class: ru.mrlargha.commonui.elements.hud.presentation.hud_screens.chicken_charge.PercentMover$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                PercentMover.start$lambda$0(PercentMover.this, i, j);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void start$lambda$0(final PercentMover percentMover, int i, final long j) {
        float coerceAtLeast = RangesKt.coerceAtLeast(percentMover.track.getWidth(), 0.0f);
        percentMover.maxX = coerceAtLeast;
        if (coerceAtLeast <= 0.0f) {
            return;
        }
        percentMover.running = true;
        final float f = i;
        percentMover.handler.post(new Runnable() { // from class: ru.mrlargha.commonui.elements.hud.presentation.hud_screens.chicken_charge.PercentMover$start$1$r$1
            @Override // java.lang.Runnable
            public void run() {
                boolean z;
                Handler handler;
                z = PercentMover.this.running;
                if (z) {
                    float currentPercent = PercentMover.this.getCurrentPercent();
                    float coerceIn = RangesKt.coerceIn(PercentMover.this.getCurrentPercent() + f, 0.0f, 100.0f);
                    PercentMover.this.setCurrentPercent(coerceIn);
                    PercentMover.this.animateBetweenPercents(currentPercent, coerceIn, j);
                    int i2 = (coerceIn > 100.0f ? 1 : (coerceIn == 100.0f ? 0 : -1));
                    PercentMover percentMover2 = PercentMover.this;
                    if (i2 < 0) {
                        handler = percentMover2.handler;
                        handler.postDelayed(this, j);
                        return;
                    }
                    percentMover2.stop();
                }
            }
        });
    }

    public final float stop() {
        this.running = false;
        this.handler.removeCallbacksAndMessages(null);
        ValueAnimator valueAnimator = this.tickAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.tickAnimator = null;
        float f = this.currentPercent;
        this.currentPercent = 0.0f;
        return f;
    }

    public final float currentPercent() {
        return this.currentPercent;
    }

    public final void attachStopOnClick(final Function1<? super Float, Unit> onStop) {
        Intrinsics.checkNotNullParameter(onStop, "onStop");
        this.track.setOnTouchListener(new View.OnTouchListener() { // from class: ru.mrlargha.commonui.elements.hud.presentation.hud_screens.chicken_charge.PercentMover$$ExternalSyntheticLambda1
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return PercentMover.attachStopOnClick$lambda$0(PercentMover.this, onStop, view, motionEvent);
            }
        });
        this.track.setOnClickListener(new View.OnClickListener() { // from class: ru.mrlargha.commonui.elements.hud.presentation.hud_screens.chicken_charge.PercentMover$$ExternalSyntheticLambda2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PercentMover.attachStopOnClick$lambda$1(PercentMover.this, onStop, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean attachStopOnClick$lambda$0(PercentMover percentMover, Function1 function1, View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            percentMover.lastTouchX = Float.valueOf(motionEvent.getX());
            percentMover.computePercentFromTouch(motionEvent.getX());
            percentMover.stop();
            function1.invoke(Float.valueOf(percentMover.currentPercent));
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void attachStopOnClick$lambda$1(PercentMover percentMover, Function1 function1, View view) {
        Float f = percentMover.lastTouchX;
        if (f != null) {
            percentMover.computePercentFromTouch(f.floatValue());
            percentMover.stop();
            function1.invoke(Float.valueOf(percentMover.currentPercent));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void animateBetweenPercents(float f, float f2, long j) {
        float f3 = this.maxX;
        float f4 = (f / 100.0f) * f3;
        float f5 = f3 * (f2 / 100.0f);
        if (Math.abs(f5 - f4) < 0.5f) {
            this.marker.setTranslationX(f5);
            return;
        }
        ValueAnimator valueAnimator = this.tickAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f4, f5);
        ofFloat.setDuration(j);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ru.mrlargha.commonui.elements.hud.presentation.hud_screens.chicken_charge.PercentMover$$ExternalSyntheticLambda3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                PercentMover.animateBetweenPercents$lambda$0$0(PercentMover.this, valueAnimator2);
            }
        });
        ofFloat.start();
        this.tickAnimator = ofFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void animateBetweenPercents$lambda$0$0(PercentMover percentMover, ValueAnimator va) {
        Intrinsics.checkNotNullParameter(va, "va");
        View view = percentMover.marker;
        Object animatedValue = va.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        view.setTranslationX(((Float) animatedValue).floatValue());
    }

    private final float computePercentFromTouch(float f) {
        float coerceAtLeast = RangesKt.coerceAtLeast(this.track.getWidth() - this.marker.getWidth(), 1.0f);
        float coerceIn = RangesKt.coerceIn(f / coerceAtLeast, 0.0f, 1.0f);
        this.currentPercent = 100.0f * coerceIn;
        this.marker.setTranslationX(coerceAtLeast * coerceIn);
        return this.currentPercent;
    }
}
