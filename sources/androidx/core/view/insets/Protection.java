package androidx.core.view.insets;

import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import androidx.core.graphics.Insets;
/* loaded from: classes2.dex */
public abstract class Protection {
    private static final long DEFAULT_DURATION_IN = 333;
    private static final long DEFAULT_DURATION_OUT = 166;
    private final int mSide;
    private static final Interpolator DEFAULT_INTERPOLATOR_MOVE_IN = new PathInterpolator(0.0f, 0.0f, 0.0f, 1.0f);
    private static final Interpolator DEFAULT_INTERPOLATOR_MOVE_OUT = new PathInterpolator(0.6f, 0.0f, 1.0f, 1.0f);
    private static final Interpolator DEFAULT_INTERPOLATOR_FADE_IN = new PathInterpolator(0.0f, 0.0f, 0.2f, 1.0f);
    private static final Interpolator DEFAULT_INTERPOLATOR_FADE_OUT = new PathInterpolator(0.4f, 0.0f, 1.0f, 1.0f);
    private final Attributes mAttributes = new Attributes();
    private Insets mInsets = Insets.NONE;
    private Insets mInsetsIgnoringVisibility = Insets.NONE;
    private float mSystemAlpha = 1.0f;
    private float mUserAlpha = 1.0f;
    private float mSystemInsetAmount = 1.0f;
    private float mUserInsetAmount = 1.0f;
    private Object mController = null;
    private ValueAnimator mUserAlphaAnimator = null;
    private ValueAnimator mUserInsetAmountAnimator = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dispatchColorHint(int i) {
    }

    int getThickness(int i) {
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean occupiesCorners() {
        return false;
    }

    public Protection(int i) {
        if (i != 1 && i != 2 && i != 4 && i != 8) {
            throw new IllegalArgumentException("Unexpected side: " + i);
        }
        this.mSide = i;
    }

    public int getSide() {
        return this.mSide;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Attributes getAttributes() {
        return this.mAttributes;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Insets dispatchInsets(Insets insets, Insets insets2, Insets insets3) {
        this.mInsets = insets;
        this.mInsetsIgnoringVisibility = insets2;
        this.mAttributes.setMargin(insets3);
        return updateLayout();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Insets updateLayout() {
        int i;
        Insets insets = Insets.NONE;
        int i2 = this.mSide;
        if (i2 == 1) {
            i = this.mInsets.left;
            this.mAttributes.setWidth(getThickness(this.mInsetsIgnoringVisibility.left));
            if (occupiesCorners()) {
                insets = Insets.of(getThickness(i), 0, 0, 0);
            }
        } else if (i2 == 2) {
            i = this.mInsets.top;
            this.mAttributes.setHeight(getThickness(this.mInsetsIgnoringVisibility.top));
            if (occupiesCorners()) {
                insets = Insets.of(0, getThickness(i), 0, 0);
            }
        } else if (i2 == 4) {
            i = this.mInsets.right;
            this.mAttributes.setWidth(getThickness(this.mInsetsIgnoringVisibility.right));
            if (occupiesCorners()) {
                insets = Insets.of(0, 0, getThickness(i), 0);
            }
        } else if (i2 != 8) {
            i = 0;
        } else {
            i = this.mInsets.bottom;
            this.mAttributes.setHeight(getThickness(this.mInsetsIgnoringVisibility.bottom));
            if (occupiesCorners()) {
                insets = Insets.of(0, 0, 0, getThickness(i));
            }
        }
        setSystemVisible(i > 0);
        setSystemAlpha(i > 0 ? 1.0f : 0.0f);
        setSystemInsetAmount(i <= 0 ? 0.0f : 1.0f);
        return insets;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object getController() {
        return this.mController;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setController(Object obj) {
        this.mController = obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setSystemVisible(boolean z) {
        this.mAttributes.setVisible(z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setSystemAlpha(float f) {
        this.mSystemAlpha = f;
        updateAlpha();
    }

    public void setAlpha(float f) {
        if (f < 0.0f || f > 1.0f) {
            throw new IllegalArgumentException("Alpha must in a range of [0, 1]. Got: " + f);
        }
        cancelUserAlphaAnimation();
        setAlphaInternal(f);
    }

    private void setAlphaInternal(float f) {
        this.mUserAlpha = f;
        updateAlpha();
    }

    public float getAlpha() {
        return this.mUserAlpha;
    }

    private void updateAlpha() {
        this.mAttributes.setAlpha(this.mSystemAlpha * this.mUserAlpha);
    }

    private void cancelUserAlphaAnimation() {
        ValueAnimator valueAnimator = this.mUserAlphaAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.mUserAlphaAnimator = null;
        }
    }

    public void animateAlpha(float f) {
        cancelUserAlphaAnimation();
        float f2 = this.mUserAlpha;
        if (f == f2) {
            return;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f2, f);
        this.mUserAlphaAnimator = ofFloat;
        if (this.mUserAlpha < f) {
            ofFloat.setDuration(DEFAULT_DURATION_IN);
            this.mUserAlphaAnimator.setInterpolator(DEFAULT_INTERPOLATOR_FADE_IN);
        } else {
            ofFloat.setDuration(DEFAULT_DURATION_OUT);
            this.mUserAlphaAnimator.setInterpolator(DEFAULT_INTERPOLATOR_FADE_OUT);
        }
        this.mUserAlphaAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: androidx.core.view.insets.Protection$$ExternalSyntheticLambda1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                Protection.this.m7202lambda$animateAlpha$0$androidxcoreviewinsetsProtection(valueAnimator);
            }
        });
        this.mUserAlphaAnimator.start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$animateAlpha$0$androidx-core-view-insets-Protection  reason: not valid java name */
    public /* synthetic */ void m7202lambda$animateAlpha$0$androidxcoreviewinsetsProtection(ValueAnimator valueAnimator) {
        setAlphaInternal(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setSystemInsetAmount(float f) {
        this.mSystemInsetAmount = f;
        updateInsetAmount();
    }

    public void setInsetAmount(float f) {
        if (f < 0.0f || f > 1.0f) {
            throw new IllegalArgumentException("Inset amount must in a range of [0, 1]. Got: " + f);
        }
        cancelUserInsetsAmountAnimation();
        setInsetAmountInternal(f);
    }

    private void setInsetAmountInternal(float f) {
        this.mUserInsetAmount = f;
        updateInsetAmount();
    }

    public float getInsetAmount() {
        return this.mUserInsetAmount;
    }

    private void updateInsetAmount() {
        float f = this.mUserInsetAmount * this.mSystemInsetAmount;
        int i = this.mSide;
        if (i == 1) {
            Attributes attributes = this.mAttributes;
            attributes.setTranslationX((-(1.0f - f)) * attributes.mWidth);
        } else if (i == 2) {
            Attributes attributes2 = this.mAttributes;
            attributes2.setTranslationY((-(1.0f - f)) * attributes2.mHeight);
        } else if (i == 4) {
            Attributes attributes3 = this.mAttributes;
            attributes3.setTranslationX((1.0f - f) * attributes3.mWidth);
        } else if (i != 8) {
        } else {
            Attributes attributes4 = this.mAttributes;
            attributes4.setTranslationY((1.0f - f) * attributes4.mHeight);
        }
    }

    private void cancelUserInsetsAmountAnimation() {
        ValueAnimator valueAnimator = this.mUserInsetAmountAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.mUserInsetAmountAnimator = null;
        }
    }

    public void animateInsetsAmount(float f) {
        cancelUserInsetsAmountAnimation();
        float f2 = this.mUserInsetAmount;
        if (f == f2) {
            return;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f2, f);
        this.mUserInsetAmountAnimator = ofFloat;
        if (this.mUserInsetAmount < f) {
            ofFloat.setDuration(DEFAULT_DURATION_IN);
            this.mUserInsetAmountAnimator.setInterpolator(DEFAULT_INTERPOLATOR_MOVE_IN);
        } else {
            ofFloat.setDuration(DEFAULT_DURATION_OUT);
            this.mUserInsetAmountAnimator.setInterpolator(DEFAULT_INTERPOLATOR_MOVE_OUT);
        }
        this.mUserInsetAmountAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: androidx.core.view.insets.Protection$$ExternalSyntheticLambda0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                Protection.this.m7203x124db077(valueAnimator);
            }
        });
        this.mUserInsetAmountAnimator.start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$animateInsetsAmount$1$androidx-core-view-insets-Protection  reason: not valid java name */
    public /* synthetic */ void m7203x124db077(ValueAnimator valueAnimator) {
        setAlphaInternal(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setDrawable(Drawable drawable) {
        this.mAttributes.setDrawable(drawable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class Attributes {
        private static final int UNSPECIFIED = -1;
        private Callback mCallback;
        private int mWidth = -1;
        private int mHeight = -1;
        private Insets mMargin = Insets.NONE;
        private boolean mVisible = false;
        private Drawable mDrawable = null;
        private float mTranslationX = 0.0f;
        private float mTranslationY = 0.0f;
        private float mAlpha = 1.0f;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes2.dex */
        public interface Callback {
            default void onAlphaChanged(float f) {
            }

            default void onDrawableChanged(Drawable drawable) {
            }

            default void onHeightChanged(int i) {
            }

            default void onMarginChanged(Insets insets) {
            }

            default void onTranslationXChanged(float f) {
            }

            default void onTranslationYChanged(float f) {
            }

            default void onVisibilityChanged(boolean z) {
            }

            default void onWidthChanged(int i) {
            }
        }

        Attributes() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int getWidth() {
            return this.mWidth;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int getHeight() {
            return this.mHeight;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Insets getMargin() {
            return this.mMargin;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean isVisible() {
            return this.mVisible;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Drawable getDrawable() {
            return this.mDrawable;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public float getTranslationX() {
            return this.mTranslationX;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public float getTranslationY() {
            return this.mTranslationY;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public float getAlpha() {
            return this.mAlpha;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setWidth(int i) {
            if (this.mWidth != i) {
                this.mWidth = i;
                Callback callback = this.mCallback;
                if (callback != null) {
                    callback.onWidthChanged(i);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setHeight(int i) {
            if (this.mHeight != i) {
                this.mHeight = i;
                Callback callback = this.mCallback;
                if (callback != null) {
                    callback.onHeightChanged(i);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMargin(Insets insets) {
            if (this.mMargin.equals(insets)) {
                return;
            }
            this.mMargin = insets;
            Callback callback = this.mCallback;
            if (callback != null) {
                callback.onMarginChanged(insets);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setVisible(boolean z) {
            if (this.mVisible != z) {
                this.mVisible = z;
                Callback callback = this.mCallback;
                if (callback != null) {
                    callback.onVisibilityChanged(z);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDrawable(Drawable drawable) {
            this.mDrawable = drawable;
            Callback callback = this.mCallback;
            if (callback != null) {
                callback.onDrawableChanged(drawable);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTranslationX(float f) {
            if (this.mTranslationX != f) {
                this.mTranslationX = f;
                Callback callback = this.mCallback;
                if (callback != null) {
                    callback.onTranslationXChanged(f);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTranslationY(float f) {
            if (this.mTranslationY != f) {
                this.mTranslationY = f;
                Callback callback = this.mCallback;
                if (callback != null) {
                    callback.onTranslationYChanged(f);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAlpha(float f) {
            if (this.mAlpha != f) {
                this.mAlpha = f;
                Callback callback = this.mCallback;
                if (callback != null) {
                    callback.onAlphaChanged(f);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void setCallback(Callback callback) {
            if (this.mCallback != null && callback != null) {
                throw new IllegalStateException("Trying to overwrite the existing callback. Did you send one protection to multiple ProtectionLayouts?");
            }
            this.mCallback = callback;
        }
    }
}
