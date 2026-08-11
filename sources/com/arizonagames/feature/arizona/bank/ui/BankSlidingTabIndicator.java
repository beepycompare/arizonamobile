package com.arizonagames.feature.arizona.bank.ui;

import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.DecelerateInterpolator;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
/* compiled from: BankSlidingTabIndicator.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0000\u0018\u0000 \u001f2\u00020\u0001:\u0002\u001e\u001fB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\tJ\u0006\u0010\u0013\u001a\u00020\u0010J\u0014\u0010\u0014\u001a\u00020\u0015*\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0003H\u0002J\u0014\u0010\u0017\u001a\u00020\t*\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0018H\u0002J\u0010\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u0015H\u0002J\u001c\u0010\u001b\u001a\u00020\u0015*\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001dH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/arizonagames/feature/arizona/bank/ui/BankSlidingTabIndicator;", "", "indicator", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "animator", "Landroid/animation/ValueAnimator;", "hasPosition", "", "indicatorParentLocation", "", "targetLocation", "targetBoundsInParent", "Landroid/graphics/Rect;", "moveTo", "", TypedValues.AttributesType.S_TARGET, "animate", "hide", "boundsIn", "Lcom/arizonagames/feature/arizona/bank/ui/BankSlidingTabIndicator$IndicatorBounds;", "parent", "isDescendantOf", "Landroid/view/ViewGroup;", "applyBounds", "bounds", "interpolate", "progress", "", "IndicatorBounds", "Companion", "bank"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BankSlidingTabIndicator {
    @Deprecated
    public static final long ANIMATION_DURATION_MS = 180;
    private static final Companion Companion = new Companion(null);
    private ValueAnimator animator;
    private boolean hasPosition;
    private final View indicator;
    private final int[] indicatorParentLocation;
    private final Rect targetBoundsInParent;
    private final int[] targetLocation;

    public BankSlidingTabIndicator(View indicator) {
        Intrinsics.checkNotNullParameter(indicator, "indicator");
        this.indicator = indicator;
        this.indicatorParentLocation = new int[2];
        this.targetLocation = new int[2];
        this.targetBoundsInParent = new Rect();
    }

    public static /* synthetic */ void moveTo$default(BankSlidingTabIndicator bankSlidingTabIndicator, View view, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = bankSlidingTabIndicator.hasPosition;
        }
        bankSlidingTabIndicator.moveTo(view, z);
    }

    public final void moveTo(final View target, final boolean z) {
        Intrinsics.checkNotNullParameter(target, "target");
        if (target.getWidth() == 0 || target.getHeight() == 0 || this.indicator.getWidth() == 0) {
            target.post(new Runnable() { // from class: com.arizonagames.feature.arizona.bank.ui.BankSlidingTabIndicator$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    BankSlidingTabIndicator.this.moveTo(target, z);
                }
            });
            return;
        }
        ViewParent parent = this.indicator.getParent();
        View view = parent instanceof View ? (View) parent : null;
        if (view == null) {
            return;
        }
        final IndicatorBounds boundsIn = boundsIn(target, view);
        if (boundsIn.getWidth() <= 0 || boundsIn.getHeight() <= 0) {
            return;
        }
        this.indicator.setVisibility(0);
        if (!this.hasPosition || !z) {
            ValueAnimator valueAnimator = this.animator;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            applyBounds(boundsIn);
            this.hasPosition = true;
            return;
        }
        final IndicatorBounds indicatorBounds = new IndicatorBounds(this.indicator.getX(), this.indicator.getY(), this.indicator.getWidth(), this.indicator.getHeight());
        ValueAnimator valueAnimator2 = this.animator;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(180L);
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.arizonagames.feature.arizona.bank.ui.BankSlidingTabIndicator$$ExternalSyntheticLambda1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator3) {
                BankSlidingTabIndicator.moveTo$lambda$1$0(BankSlidingTabIndicator.this, indicatorBounds, boundsIn, valueAnimator3);
            }
        });
        ofFloat.start();
        this.animator = ofFloat;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void moveTo$lambda$1$0(BankSlidingTabIndicator bankSlidingTabIndicator, IndicatorBounds indicatorBounds, IndicatorBounds indicatorBounds2, ValueAnimator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        bankSlidingTabIndicator.applyBounds(bankSlidingTabIndicator.interpolate(indicatorBounds, indicatorBounds2, ((Float) animatedValue).floatValue()));
    }

    public final void hide() {
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.indicator.setVisibility(4);
        this.hasPosition = false;
    }

    private final IndicatorBounds boundsIn(View view, View view2) {
        if (view2 instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view2;
            if (isDescendantOf(view, viewGroup)) {
                this.targetBoundsInParent.set(0, 0, view.getWidth(), view.getHeight());
                viewGroup.offsetDescendantRectToMyCoords(view, this.targetBoundsInParent);
                return new IndicatorBounds(this.targetBoundsInParent.left, this.targetBoundsInParent.top, this.targetBoundsInParent.width(), this.targetBoundsInParent.height());
            }
        }
        view.getLocationInWindow(this.targetLocation);
        view2.getLocationInWindow(this.indicatorParentLocation);
        int[] iArr = this.targetLocation;
        int i = iArr[0];
        int[] iArr2 = this.indicatorParentLocation;
        return new IndicatorBounds(i - iArr2[0], iArr[1] - iArr2[1], view.getWidth(), view.getHeight());
    }

    private final boolean isDescendantOf(View view, ViewGroup viewGroup) {
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = ((View) parent).getParent()) {
            if (parent == viewGroup) {
                return true;
            }
        }
        return false;
    }

    private final void applyBounds(IndicatorBounds indicatorBounds) {
        ViewGroup.LayoutParams layoutParams = this.indicator.getLayoutParams();
        if (layoutParams.width != indicatorBounds.getWidth() || layoutParams.height != indicatorBounds.getHeight()) {
            layoutParams.width = indicatorBounds.getWidth();
            layoutParams.height = indicatorBounds.getHeight();
            this.indicator.setLayoutParams(layoutParams);
        }
        this.indicator.setX(indicatorBounds.getX());
        this.indicator.setY(indicatorBounds.getY());
    }

    private final IndicatorBounds interpolate(IndicatorBounds indicatorBounds, IndicatorBounds indicatorBounds2, float f) {
        return new IndicatorBounds(indicatorBounds.getX() + ((indicatorBounds2.getX() - indicatorBounds.getX()) * f), indicatorBounds.getY() + ((indicatorBounds2.getY() - indicatorBounds.getY()) * f), MathKt.roundToInt(indicatorBounds.getWidth() + ((indicatorBounds2.getWidth() - indicatorBounds.getWidth()) * f)), MathKt.roundToInt(indicatorBounds.getHeight() + ((indicatorBounds2.getHeight() - indicatorBounds.getHeight()) * f)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: BankSlidingTabIndicator.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0014\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0018\u001a\u00020\u0006HÖ\u0081\u0004J\n\u0010\u0019\u001a\u00020\u001aHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/arizonagames/feature/arizona/bank/ui/BankSlidingTabIndicator$IndicatorBounds;", "", "x", "", "y", "width", "", "height", "<init>", "(FFII)V", "getX", "()F", "getY", "getWidth", "()I", "getHeight", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "bank"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class IndicatorBounds {
        private final int height;
        private final int width;
        private final float x;
        private final float y;

        public static /* synthetic */ IndicatorBounds copy$default(IndicatorBounds indicatorBounds, float f, float f2, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                f = indicatorBounds.x;
            }
            if ((i3 & 2) != 0) {
                f2 = indicatorBounds.y;
            }
            if ((i3 & 4) != 0) {
                i = indicatorBounds.width;
            }
            if ((i3 & 8) != 0) {
                i2 = indicatorBounds.height;
            }
            return indicatorBounds.copy(f, f2, i, i2);
        }

        public final float component1() {
            return this.x;
        }

        public final float component2() {
            return this.y;
        }

        public final int component3() {
            return this.width;
        }

        public final int component4() {
            return this.height;
        }

        public final IndicatorBounds copy(float f, float f2, int i, int i2) {
            return new IndicatorBounds(f, f2, i, i2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof IndicatorBounds) {
                IndicatorBounds indicatorBounds = (IndicatorBounds) obj;
                return Float.compare(this.x, indicatorBounds.x) == 0 && Float.compare(this.y, indicatorBounds.y) == 0 && this.width == indicatorBounds.width && this.height == indicatorBounds.height;
            }
            return false;
        }

        public int hashCode() {
            return (((((Float.hashCode(this.x) * 31) + Float.hashCode(this.y)) * 31) + Integer.hashCode(this.width)) * 31) + Integer.hashCode(this.height);
        }

        public String toString() {
            float f = this.x;
            float f2 = this.y;
            int i = this.width;
            return "IndicatorBounds(x=" + f + ", y=" + f2 + ", width=" + i + ", height=" + this.height + ")";
        }

        public IndicatorBounds(float f, float f2, int i, int i2) {
            this.x = f;
            this.y = f2;
            this.width = i;
            this.height = i2;
        }

        public final float getX() {
            return this.x;
        }

        public final float getY() {
            return this.y;
        }

        public final int getWidth() {
            return this.width;
        }

        public final int getHeight() {
            return this.height;
        }
    }

    /* compiled from: BankSlidingTabIndicator.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/arizonagames/feature/arizona/bank/ui/BankSlidingTabIndicator$Companion;", "", "<init>", "()V", "ANIMATION_DURATION_MS", "", "bank"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
