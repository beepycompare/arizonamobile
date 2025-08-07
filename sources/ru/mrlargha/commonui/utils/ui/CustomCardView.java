package ru.mrlargha.commonui.utils.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.R;
/* compiled from: CustomCardView.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010*\u001a\u00020+2\b\b\u0001\u0010,\u001a\u00020\u0017J+\u0010*\u001a\u00020+2\b\b\u0001\u0010,\u001a\u00020\u00172\b\b\u0001\u0010-\u001a\u00020\u00172\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0017¢\u0006\u0002\u0010/J\u000e\u00100\u001a\u00020+2\u0006\u00101\u001a\u00020\u0017J\u0010\u00102\u001a\u00020+2\b\b\u0001\u0010,\u001a\u00020\u0017J+\u00102\u001a\u00020+2\b\b\u0001\u0010,\u001a\u00020\u00172\b\b\u0001\u0010-\u001a\u00020\u00172\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u0017¢\u0006\u0002\u0010/J\u000e\u00103\u001a\u00020+2\u0006\u00101\u001a\u00020\u0017J\u0010\u00104\u001a\u00020+2\u0006\u00105\u001a\u000206H\u0014J\u0010\u00107\u001a\u00020+2\u0006\u00105\u001a\u000206H\u0014J\b\u00108\u001a\u00020+H\u0002J\u0010\u00109\u001a\u00020+2\u0006\u0010:\u001a\u00020\tH\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lru/mrlargha/commonui/utils/ui/CustomCardView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "paint", "Landroid/graphics/Paint;", "path", "Landroid/graphics/Path;", "radii", "", "typedArray", "Landroid/content/res/TypedArray;", "topLeft", "", "topRight", "bottomRight", "bottomLeft", "corners", "bgMainColor", "", "bgSecondColor", "gradientAngle", "bgTransparency", "gradientType", "gradientRadius", "borderWidth", "borderMainColor", "borderSecondColor", "borderGradientAngle", "borderTransparency", "hasBorderSecondColor", "", "hasSecondColor", "hasTopLeft", "hasTopRight", "hasBottomLeft", "hasBottomRight", "hasBorder", "setBackground", "", "mainColor", "secondColor", "angle", "(IILjava/lang/Integer;)V", "setBackgroundAlpha", "alpha", "setBorder", "setBorderAlpha", "onDraw", "canvas", "Landroid/graphics/Canvas;", "dispatchDraw", "setGradient", "setBorderGradient", "borderGradient", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CustomCardView extends FrameLayout {
    private int bgMainColor;
    private int bgSecondColor;
    private int bgTransparency;
    private int borderGradientAngle;
    private int borderMainColor;
    private int borderSecondColor;
    private int borderTransparency;
    private final float borderWidth;
    private final float bottomLeft;
    private final float bottomRight;
    private final float corners;
    private int gradientAngle;
    private float gradientRadius;
    private int gradientType;
    private final boolean hasBorder;
    private boolean hasBorderSecondColor;
    private final boolean hasBottomLeft;
    private final boolean hasBottomRight;
    private boolean hasSecondColor;
    private final boolean hasTopLeft;
    private final boolean hasTopRight;
    private final Paint paint;
    private final Path path;
    private final float[] radii;
    private final float topLeft;
    private final float topRight;
    private final TypedArray typedArray;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.paint = new Paint(1);
        this.path = new Path();
        float[] fArr = new float[8];
        this.radii = fArr;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.CustomCardView);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "obtainStyledAttributes(...)");
        this.typedArray = obtainStyledAttributes;
        float dimension = obtainStyledAttributes.getDimension(R.styleable.CustomCardView_cornerTopLeft, 0.0f);
        this.topLeft = dimension;
        float dimension2 = obtainStyledAttributes.getDimension(R.styleable.CustomCardView_cornerTopRight, 0.0f);
        this.topRight = dimension2;
        float dimension3 = obtainStyledAttributes.getDimension(R.styleable.CustomCardView_cornerBottomRight, 0.0f);
        this.bottomRight = dimension3;
        float dimension4 = obtainStyledAttributes.getDimension(R.styleable.CustomCardView_cornerBottomLeft, 0.0f);
        this.bottomLeft = dimension4;
        float dimension5 = obtainStyledAttributes.getDimension(R.styleable.CustomCardView_corners, 0.0f);
        this.corners = dimension5;
        this.bgMainColor = obtainStyledAttributes.getColor(R.styleable.CustomCardView_backgroundMainColor, 0);
        this.bgSecondColor = obtainStyledAttributes.getColor(R.styleable.CustomCardView_backgroundSecondColor, 0);
        this.gradientAngle = obtainStyledAttributes.getInteger(R.styleable.CustomCardView_gradientAngle, 0);
        this.bgTransparency = obtainStyledAttributes.getInteger(R.styleable.CustomCardView_backgroundTransparency, 100);
        this.gradientType = obtainStyledAttributes.getInteger(R.styleable.CustomCardView_gradientType, 0);
        this.gradientRadius = obtainStyledAttributes.getDimension(R.styleable.CustomCardView_radialGradientRadius, 0.0f);
        this.borderWidth = obtainStyledAttributes.getDimension(R.styleable.CustomCardView_borderWidth, 0.0f);
        this.borderMainColor = obtainStyledAttributes.getColor(R.styleable.CustomCardView_borderMainColor, 0);
        this.borderSecondColor = obtainStyledAttributes.getColor(R.styleable.CustomCardView_borderSecondColor, 0);
        this.borderGradientAngle = obtainStyledAttributes.getInteger(R.styleable.CustomCardView_borderGradientAngle, 0);
        this.borderTransparency = obtainStyledAttributes.getInteger(R.styleable.CustomCardView_borderTransparency, 100);
        this.hasBorderSecondColor = obtainStyledAttributes.hasValue(R.styleable.CustomCardView_borderSecondColor);
        this.hasSecondColor = obtainStyledAttributes.hasValue(R.styleable.CustomCardView_backgroundSecondColor);
        boolean hasValue = obtainStyledAttributes.hasValue(R.styleable.CustomCardView_cornerTopLeft);
        this.hasTopLeft = hasValue;
        boolean hasValue2 = obtainStyledAttributes.hasValue(R.styleable.CustomCardView_cornerTopRight);
        this.hasTopRight = hasValue2;
        boolean hasValue3 = obtainStyledAttributes.hasValue(R.styleable.CustomCardView_cornerBottomLeft);
        this.hasBottomLeft = hasValue3;
        boolean hasValue4 = obtainStyledAttributes.hasValue(R.styleable.CustomCardView_cornerBottomRight);
        this.hasBottomRight = hasValue4;
        this.hasBorder = obtainStyledAttributes.hasValue(R.styleable.CustomCardView_borderWidth);
        setWillNotDraw(false);
        obtainStyledAttributes.recycle();
        fArr[0] = hasValue ? dimension : dimension5;
        fArr[1] = hasValue ? dimension : dimension5;
        fArr[2] = hasValue2 ? dimension2 : dimension5;
        fArr[3] = hasValue2 ? dimension2 : dimension5;
        fArr[4] = hasValue4 ? dimension3 : dimension5;
        fArr[5] = hasValue4 ? dimension3 : dimension5;
        fArr[6] = hasValue3 ? dimension4 : dimension5;
        fArr[7] = hasValue3 ? dimension4 : dimension5;
    }

    public final void setBackground(int i) {
        this.bgMainColor = i;
        this.hasSecondColor = false;
        invalidate();
    }

    public static /* synthetic */ void setBackground$default(CustomCardView customCardView, int i, int i2, Integer num, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            num = null;
        }
        customCardView.setBackground(i, i2, num);
    }

    public final void setBackground(int i, int i2, Integer num) {
        this.bgMainColor = i;
        this.bgSecondColor = i2;
        if (num != null) {
            this.gradientAngle = num.intValue();
        }
        invalidate();
    }

    public final void setBackgroundAlpha(int i) {
        this.bgTransparency = i;
        invalidate();
    }

    public final void setBorder(int i) {
        this.borderMainColor = i;
        this.hasBorderSecondColor = false;
        invalidate();
    }

    public static /* synthetic */ void setBorder$default(CustomCardView customCardView, int i, int i2, Integer num, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            num = null;
        }
        customCardView.setBorder(i, i2, num);
    }

    public final void setBorder(int i, int i2, Integer num) {
        this.borderMainColor = i;
        this.borderSecondColor = i2;
        if (num != null) {
            this.borderGradientAngle = num.intValue();
        }
        invalidate();
    }

    public final void setBorderAlpha(int i) {
        this.borderTransparency = i;
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        RectF rectF;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        float f = this.borderWidth / 3;
        if (this.hasBorder) {
            rectF = new RectF(f, f, getWidth() - f, getHeight() - f);
        } else {
            rectF = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        }
        this.path.reset();
        setGradient();
        this.path.addRoundRect(rectF, this.radii, Path.Direction.CW);
        canvas.drawPath(this.path, this.paint);
        Paint paint = new Paint(1);
        paint.setAlpha((this.borderTransparency * 255) / 100);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(this.borderWidth);
        setBorderGradient(paint);
        Path path = this.path;
        float f2 = this.borderWidth;
        float f3 = 2;
        RectF rectF2 = new RectF(f2 / f3, f2 / f3, getWidth() - (this.borderWidth / f3), getHeight() - (this.borderWidth / f3));
        path.reset();
        path.addRoundRect(rectF2, this.radii, Path.Direction.CW);
        canvas.drawPath(path, paint);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        RectF rectF = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        this.path.reset();
        this.path.addRoundRect(rectF, this.radii, Path.Direction.CW);
        canvas.save();
        canvas.clipPath(this.path);
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    private final void setGradient() {
        this.paint.setAlpha((this.bgTransparency * 255) / 100);
        if (!this.hasSecondColor) {
            this.paint.setColor(this.bgMainColor);
            return;
        }
        int i = this.gradientType;
        if (i != 0) {
            if (i != 1) {
                return;
            }
            this.paint.setShader(new RadialGradient(getWidth() / 2.0f, getHeight() / 2.0f, this.gradientRadius, this.bgMainColor, this.bgSecondColor, Shader.TileMode.CLAMP));
            return;
        }
        double radians = Math.toRadians(this.gradientAngle);
        float width = getWidth();
        float height = getHeight();
        float f = width / 2.0f;
        float f2 = height / 2.0f;
        float cos = (float) Math.cos(radians);
        float sin = (float) Math.sin(radians);
        float abs = (Math.abs(width * cos) + Math.abs(height * sin)) / 2.0f;
        float f3 = cos * abs;
        float f4 = sin * abs;
        this.paint.setShader(new LinearGradient(f - f3, f2 - f4, f + f3, f2 + f4, this.bgMainColor, this.bgSecondColor, Shader.TileMode.CLAMP));
    }

    private final void setBorderGradient(Paint paint) {
        if (!this.hasBorderSecondColor) {
            paint.setColor(this.borderMainColor);
            return;
        }
        double radians = Math.toRadians(this.borderGradientAngle);
        float width = getWidth();
        float height = getHeight();
        float f = width / 2.0f;
        float f2 = height / 2.0f;
        float cos = (float) Math.cos(radians);
        float sin = (float) Math.sin(radians);
        float abs = (Math.abs(width * cos) + Math.abs(height * sin)) / 2.0f;
        float f3 = cos * abs;
        float f4 = sin * abs;
        paint.setShader(new LinearGradient(f - f3, f2 - f4, f + f3, f2 + f4, this.borderMainColor, this.borderSecondColor, Shader.TileMode.CLAMP));
    }
}
