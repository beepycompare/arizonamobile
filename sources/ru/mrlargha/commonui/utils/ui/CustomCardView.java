package ru.mrlargha.commonui.utils.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ru.mrlargha.commonui.R;
/* compiled from: CustomCardView.kt */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001UB\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u00106\u001a\u000207H\u0002J\b\u00108\u001a\u00020\rH\u0002J\u0014\u00109\u001a\u0002072\f\b\u0001\u0010:\u001a\u00020\u0017:\u0002\b;J?\u00109\u001a\u0002072\f\b\u0001\u0010:\u001a\u00020\u0017:\u0002\b;2\f\b\u0001\u0010<\u001a\u00020\u0017:\u0002\b;2\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010>¢\u0006\u0002\u0010?J+\u00109\u001a\u0002072\u0006\u0010@\u001a\u0002042\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010>¢\u0006\u0002\u0010AJ\u000e\u0010B\u001a\u0002072\u0006\u0010C\u001a\u00020\u0017J\u0014\u0010D\u001a\u0002072\f\b\u0001\u0010:\u001a\u00020\u0017:\u0002\b;J3\u0010D\u001a\u0002072\f\b\u0001\u0010:\u001a\u00020\u0017:\u0002\b;2\f\b\u0001\u0010<\u001a\u00020\u0017:\u0002\b;2\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u0017¢\u0006\u0002\u0010EJ\u000e\u0010F\u001a\u0002072\u0006\u0010C\u001a\u00020\u0017J\u000e\u0010G\u001a\u0002072\u0006\u0010H\u001a\u00020\u0011J\u0006\u0010I\u001a\u000207J\u0018\u0010J\u001a\u0002072\u0006\u0010K\u001a\u00020)2\b\b\u0002\u0010L\u001a\u00020\u0011J\u0010\u0010M\u001a\u0002072\u0006\u0010N\u001a\u00020OH\u0016J\u0010\u0010P\u001a\u0002072\u0006\u0010N\u001a\u00020OH\u0014J\b\u0010Q\u001a\u000207H\u0002J\b\u0010R\u001a\u000207H\u0002J\u0010\u0010S\u001a\u0002072\u0006\u0010T\u001a\u00020\tH\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010 \u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u000e\u0010%\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u00101\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0004\n\u0002\u00102R\u000e\u00103\u001a\u000204X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006V"}, d2 = {"Lru/mrlargha/commonui/utils/ui/CustomCardView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "paint", "Landroid/graphics/Paint;", "path", "Landroid/graphics/Path;", "radii", "", "typedArray", "Landroid/content/res/TypedArray;", "topLeft", "", "topRight", "bottomRight", "bottomLeft", "corners", "bgMainColor", "", "bgSecondColor", "gradientAngle", "bgTransparency", "gradientType", "gradientRadius", "gradientList", "", "borderWidth", "borderMainColor", "getBorderMainColor", "()I", "setBorderMainColor", "(I)V", "borderSecondColor", "borderGradientAngle", "borderTransparency", "hasBorderSecondColor", "", "hasSecondColor", "hasGradientList", "hasTopLeft", "hasTopRight", "hasBottomLeft", "hasBottomRight", "hasBorder", "percentWidth", "Ljava/lang/Float;", "gradientColorList", "", "isAlphaSet", "setGradientColorList", "", "getFloatGradient", "setBackground", "mainColor", "Landroidx/annotation/ColorInt;", "secondColor", "angle", "Lru/mrlargha/commonui/utils/ui/CustomCardView$GradientType;", "(IILjava/lang/Integer;Lru/mrlargha/commonui/utils/ui/CustomCardView$GradientType;)V", "colorList", "([ILjava/lang/Integer;Lru/mrlargha/commonui/utils/ui/CustomCardView$GradientType;)V", "setBackgroundAlpha", "alpha", "setBorder", "(IILjava/lang/Integer;)V", "setBorderAlpha", "setPercentWidth", "percent", "resetPercentWidth", "changeValidate", "isValidate", "inValidateAlpha", "draw", "canvas", "Landroid/graphics/Canvas;", "onDraw", "setGradient", "setLinearGradientType", "setBorderGradient", "borderGradient", "GradientType", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
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
    private int[] gradientColorList;
    private String gradientList;
    private float gradientRadius;
    private int gradientType;
    private final boolean hasBorder;
    private boolean hasBorderSecondColor;
    private final boolean hasBottomLeft;
    private final boolean hasBottomRight;
    private boolean hasGradientList;
    private boolean hasSecondColor;
    private final boolean hasTopLeft;
    private final boolean hasTopRight;
    private boolean isAlphaSet;
    private final Paint paint;
    private final Path path;
    private Float percentWidth;
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
        this.gradientList = obtainStyledAttributes.getString(R.styleable.CustomCardView_gradientList);
        this.borderWidth = obtainStyledAttributes.getDimension(R.styleable.CustomCardView_borderWidth, 0.0f);
        this.borderMainColor = obtainStyledAttributes.getColor(R.styleable.CustomCardView_borderMainColor, 0);
        this.borderSecondColor = obtainStyledAttributes.getColor(R.styleable.CustomCardView_borderSecondColor, 0);
        this.borderGradientAngle = obtainStyledAttributes.getInteger(R.styleable.CustomCardView_borderGradientAngle, 0);
        this.borderTransparency = obtainStyledAttributes.getInteger(R.styleable.CustomCardView_borderTransparency, 100);
        this.hasBorderSecondColor = obtainStyledAttributes.hasValue(R.styleable.CustomCardView_borderSecondColor);
        this.hasSecondColor = obtainStyledAttributes.hasValue(R.styleable.CustomCardView_backgroundSecondColor);
        this.hasGradientList = obtainStyledAttributes.hasValue(R.styleable.CustomCardView_gradientList);
        boolean hasValue = obtainStyledAttributes.hasValue(R.styleable.CustomCardView_cornerTopLeft);
        this.hasTopLeft = hasValue;
        boolean hasValue2 = obtainStyledAttributes.hasValue(R.styleable.CustomCardView_cornerTopRight);
        this.hasTopRight = hasValue2;
        boolean hasValue3 = obtainStyledAttributes.hasValue(R.styleable.CustomCardView_cornerBottomLeft);
        this.hasBottomLeft = hasValue3;
        boolean hasValue4 = obtainStyledAttributes.hasValue(R.styleable.CustomCardView_cornerBottomRight);
        this.hasBottomRight = hasValue4;
        this.hasBorder = obtainStyledAttributes.hasValue(R.styleable.CustomCardView_borderWidth);
        this.gradientColorList = new int[0];
        setWillNotDraw(false);
        setGradientColorList();
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

    public final int getBorderMainColor() {
        return this.borderMainColor;
    }

    public final void setBorderMainColor(int i) {
        this.borderMainColor = i;
    }

    private final void setGradientColorList() {
        List split$default;
        if (this.hasGradientList) {
            String str = this.gradientList;
            int[] iArr = null;
            String replace$default = str != null ? StringsKt.replace$default(str, " ", "", false, 4, (Object) null) : null;
            if (replace$default != null && (split$default = StringsKt.split$default((CharSequence) replace$default, new String[]{StringUtils.COMMA}, false, 0, 6, (Object) null)) != null) {
                List<String> list = split$default;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                for (String str2 : list) {
                    arrayList.add(Integer.valueOf(Color.parseColor(str2)));
                }
                iArr = CollectionsKt.toIntArray(arrayList);
            }
            if (iArr != null) {
                this.gradientColorList = iArr;
            }
        }
    }

    private final float[] getFloatGradient() {
        int i = 0;
        if (this.gradientColorList.length == 0) {
            return new float[0];
        }
        ArrayList arrayList = new ArrayList();
        int[] iArr = this.gradientColorList;
        int length = iArr.length - 1;
        int length2 = iArr.length;
        int i2 = 0;
        while (i < length2) {
            int i3 = iArr[i];
            arrayList.add(Float.valueOf(i2 / length));
            i++;
            i2++;
        }
        return CollectionsKt.toFloatArray(arrayList);
    }

    public final void setBackground(int i) {
        this.hasGradientList = false;
        this.bgMainColor = i;
        this.hasSecondColor = false;
        invalidate();
    }

    public static /* synthetic */ void setBackground$default(CustomCardView customCardView, int i, int i2, Integer num, GradientType gradientType, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            num = null;
        }
        if ((i3 & 8) != 0) {
            gradientType = null;
        }
        customCardView.setBackground(i, i2, num, gradientType);
    }

    public final void setBackground(int i, int i2, Integer num, GradientType gradientType) {
        this.hasGradientList = false;
        this.bgMainColor = i;
        this.bgSecondColor = i2;
        this.hasSecondColor = true;
        if (num != null) {
            this.gradientAngle = num.intValue();
        }
        if (gradientType != null) {
            this.gradientType = gradientType.getValue();
        }
        invalidate();
    }

    public static /* synthetic */ void setBackground$default(CustomCardView customCardView, int[] iArr, Integer num, GradientType gradientType, int i, Object obj) {
        if ((i & 2) != 0) {
            num = null;
        }
        if ((i & 4) != 0) {
            gradientType = null;
        }
        customCardView.setBackground(iArr, num, gradientType);
    }

    public final void setBackground(int[] colorList, Integer num, GradientType gradientType) {
        Intrinsics.checkNotNullParameter(colorList, "colorList");
        this.gradientColorList = colorList;
        this.hasGradientList = true;
        if (num != null) {
            this.gradientAngle = num.intValue();
        }
        if (gradientType != null) {
            this.gradientType = gradientType.getValue();
        }
        invalidate();
    }

    public final void setBackgroundAlpha(int i) {
        this.bgTransparency = i;
        this.isAlphaSet = true;
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
        this.hasBorderSecondColor = true;
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

    public final void setPercentWidth(float f) {
        if (0.0f > f || f > 1.0f) {
            throw new IllegalArgumentException("percent must be between 0f and 1f".toString());
        }
        this.percentWidth = Float.valueOf(f);
        invalidate();
    }

    public final void resetPercentWidth() {
        this.percentWidth = null;
        invalidate();
    }

    public static /* synthetic */ void changeValidate$default(CustomCardView customCardView, boolean z, float f, int i, Object obj) {
        if ((i & 2) != 0) {
            f = 0.5f;
        }
        customCardView.changeValidate(z, f);
    }

    public final void changeValidate(boolean z, float f) {
        if (z) {
            f = 1.0f;
        }
        setAlpha(f);
        setEnabled(z);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        int save = canvas.save();
        RectF rectF = new RectF(1.0f, 1.0f, getWidth() - 1.0f, getHeight() - 1.0f);
        this.path.reset();
        this.path.addRoundRect(rectF, this.radii, Path.Direction.CW);
        canvas.clipPath(this.path);
        super.draw(canvas);
        canvas.restoreToCount(save);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        RectF rectF;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        float f = this.borderWidth / 3.0f;
        if (this.hasBorder) {
            rectF = new RectF(f, f, getWidth() - f, getHeight() - f);
        } else {
            rectF = new RectF(0.0f, 0.0f, getWidth(), getHeight());
        }
        Float f2 = this.percentWidth;
        if (f2 != null) {
            rectF = new RectF(rectF.left, rectF.top, rectF.left + (rectF.width() * f2.floatValue()), rectF.bottom);
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
        float f3 = this.borderWidth;
        RectF rectF2 = new RectF(f3 / 2.0f, f3 / 2.0f, getWidth() - (this.borderWidth / 2.0f), getHeight() - (this.borderWidth / 2.0f));
        path.reset();
        path.addRoundRect(rectF2, this.radii, Path.Direction.CW);
        canvas.drawPath(path, paint);
    }

    private final void setGradient() {
        this.paint.setAlpha((this.bgTransparency * 255) / 100);
        if (this.hasGradientList) {
            if (!(this.gradientColorList.length == 0)) {
                setLinearGradientType();
                return;
            }
        }
        if (!this.hasSecondColor) {
            this.paint.setShader(null);
            this.paint.setColor(this.bgMainColor);
            if (this.isAlphaSet) {
                this.paint.setAlpha((this.bgTransparency * 255) / 100);
                return;
            }
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

    private final void setLinearGradientType() {
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
        this.paint.setShader(new LinearGradient(f - f3, f2 - f4, f + f3, f2 + f4, this.gradientColorList, getFloatGradient(), Shader.TileMode.CLAMP));
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

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: CustomCardView.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lru/mrlargha/commonui/utils/ui/CustomCardView$GradientType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "LINEAR", "RADIAL", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class GradientType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ GradientType[] $VALUES;
        public static final GradientType LINEAR = new GradientType("LINEAR", 0, 0);
        public static final GradientType RADIAL = new GradientType("RADIAL", 1, 1);
        private final int value;

        private static final /* synthetic */ GradientType[] $values() {
            return new GradientType[]{LINEAR, RADIAL};
        }

        public static EnumEntries<GradientType> getEntries() {
            return $ENTRIES;
        }

        public static GradientType valueOf(String str) {
            return (GradientType) Enum.valueOf(GradientType.class, str);
        }

        public static GradientType[] values() {
            return (GradientType[]) $VALUES.clone();
        }

        private GradientType(String str, int i, int i2) {
            this.value = i2;
        }

        public final int getValue() {
            return this.value;
        }

        static {
            GradientType[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }
    }
}
