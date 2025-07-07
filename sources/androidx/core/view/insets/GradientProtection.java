package androidx.core.view.insets;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.animation.PathInterpolator;
/* loaded from: classes2.dex */
public class GradientProtection extends Protection {
    private static final float[] ALPHAS;
    private int mColor;
    private final int[] mColors;
    private final GradientDrawable mDrawable;
    private boolean mHasColor;
    private float mScale;

    static {
        float[] fArr = new float[100];
        ALPHAS = fArr;
        PathInterpolator pathInterpolator = new PathInterpolator(0.42f, 0.0f, 0.58f, 1.0f);
        int length = fArr.length - 1;
        for (int i = length; i >= 0; i--) {
            ALPHAS[i] = pathInterpolator.getInterpolation((length - i) / length);
        }
    }

    public GradientProtection(int i) {
        super(i);
        GradientDrawable gradientDrawable = new GradientDrawable();
        this.mDrawable = gradientDrawable;
        this.mColors = new int[ALPHAS.length];
        this.mColor = 0;
        this.mScale = 1.2f;
        if (i == 1) {
            gradientDrawable.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        } else if (i == 2) {
            gradientDrawable.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
        } else if (i == 4) {
            gradientDrawable.setOrientation(GradientDrawable.Orientation.RIGHT_LEFT);
        } else if (i != 8) {
        } else {
            gradientDrawable.setOrientation(GradientDrawable.Orientation.BOTTOM_TOP);
        }
    }

    public GradientProtection(int i, int i2) {
        this(i);
        setColor(i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.core.view.insets.Protection
    public void dispatchColorHint(int i) {
        if (this.mHasColor) {
            return;
        }
        setColorInner(i);
    }

    private void setColorInner(int i) {
        if (this.mColor != i) {
            this.mColor = i;
            toColors(i, this.mColors);
            this.mDrawable.setColors(this.mColors);
            setDrawable(this.mDrawable);
        }
    }

    public void setColor(int i) {
        this.mHasColor = true;
        setColorInner(i);
    }

    public int getColor() {
        return this.mColor;
    }

    private static void toColors(int i, int[] iArr) {
        for (int length = iArr.length - 1; length >= 0; length--) {
            iArr[length] = Color.argb((int) (ALPHAS[length] * Color.alpha(i)), Color.red(i), Color.green(i), Color.blue(i));
        }
    }

    @Override // androidx.core.view.insets.Protection
    int getThickness(int i) {
        return (int) (this.mScale * i);
    }

    public void setScale(float f) {
        if (f < 0.0f) {
            throw new IllegalArgumentException("Scale must not be negative.");
        }
        this.mScale = f;
        updateLayout();
    }

    public float getScale() {
        return this.mScale;
    }
}
