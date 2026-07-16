package ru.mrlargha.commonui.utils.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.media3.exoplayer.upstream.CmcdData;
import io.appmetrica.analytics.coreutils.internal.StringUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import ru.mrlargha.commonui.R;
/* compiled from: CustomCardView.kt */
@Metadata(d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u0000 \u008f\u00012\u00020\u0001:\u0006\u008d\u0001\u008e\u0001\u008f\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010J\u001a\u00020KH\u0002J\b\u0010L\u001a\u00020\u0010H\u0002J\u0014\u0010M\u001a\u00020K2\f\b\u0001\u0010N\u001a\u00020\u001a:\u0002\bOJ?\u0010M\u001a\u00020K2\f\b\u0001\u0010N\u001a\u00020\u001a:\u0002\bO2\f\b\u0001\u0010P\u001a\u00020\u001a:\u0002\bO2\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010R¢\u0006\u0002\u0010SJ+\u0010M\u001a\u00020K2\u0006\u0010T\u001a\u00020D2\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010R¢\u0006\u0002\u0010UJ\u000e\u0010V\u001a\u00020K2\u0006\u0010W\u001a\u00020\u001aJ\u0014\u0010X\u001a\u00020K2\f\b\u0001\u0010N\u001a\u00020\u001a:\u0002\bOJ3\u0010X\u001a\u00020K2\f\b\u0001\u0010N\u001a\u00020\u001a:\u0002\bO2\f\b\u0001\u0010P\u001a\u00020\u001a:\u0002\bO2\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010\u001a¢\u0006\u0002\u0010YJ\u000e\u0010Z\u001a\u00020K2\u0006\u0010W\u001a\u00020\u001aJ\u0010\u0010[\u001a\u00020K2\b\u0010\\\u001a\u0004\u0018\u000100J\u0014\u0010]\u001a\u00020K2\f\b\u0001\u0010^\u001a\u00020\u001a:\u0002\b_J\u0006\u0010`\u001a\u00020KJ\u000e\u0010a\u001a\u00020K2\u0006\u0010W\u001a\u00020\u001aJ\u000e\u0010b\u001a\u00020K2\u0006\u0010c\u001a\u00020\u0014J\u0016\u0010b\u001a\u00020K2\u0006\u0010d\u001a\u00020\u00142\u0006\u0010e\u001a\u00020\u0014J\u0016\u0010f\u001a\u00020K2\u0006\u0010g\u001a\u00020\u00142\u0006\u0010h\u001a\u00020\u0014J\u000e\u0010i\u001a\u00020K2\u0006\u0010j\u001a\u00020\u0014J\u0014\u0010k\u001a\u00020K2\f\b\u0001\u0010l\u001a\u00020\u001a:\u0002\bOJ\u0006\u0010m\u001a\u00020KJ\u000e\u0010n\u001a\u00020K2\u0006\u0010o\u001a\u00020pJ\u000e\u0010q\u001a\u00020K2\u0006\u0010r\u001a\u00020\u0014J\u0006\u0010s\u001a\u00020KJ\u000e\u0010t\u001a\u00020K2\u0006\u0010u\u001a\u00020\u0014J\u0018\u0010v\u001a\u00020K2\u0006\u0010w\u001a\u00020,2\b\b\u0002\u0010x\u001a\u00020\u0014J\u0010\u0010y\u001a\u00020K2\u0006\u0010z\u001a\u00020{H\u0016J\u0010\u0010|\u001a\u00020K2\u0006\u0010z\u001a\u00020{H\u0014J*\u0010}\u001a\u00020K2\u0006\u0010~\u001a\u00020\u001a2\u0006\u0010\u007f\u001a\u00020\u001a2\u0007\u0010\u0080\u0001\u001a\u00020\u001a2\u0007\u0010\u0081\u0001\u001a\u00020\u001aH\u0014J\t\u0010\u0082\u0001\u001a\u00020KH\u0002J\t\u0010\u0083\u0001\u001a\u00020KH\u0002J\u0012\u0010\u0084\u0001\u001a\u00020K2\u0007\u0010\u0085\u0001\u001a\u00020\tH\u0002J\u001a\u0010\u0086\u0001\u001a\u00020K2\u0006\u0010z\u001a\u00020{2\u0007\u0010\u0087\u0001\u001a\u00020\fH\u0002J\u000b\u0010\u0088\u0001\u001a\u0004\u0018\u00010IH\u0002J\u000b\u0010\u0089\u0001\u001a\u0004\u0018\u00010GH\u0002J\t\u0010\u008a\u0001\u001a\u00020KH\u0002J\r\u0010\u008b\u0001\u001a\u00020,*\u000200H\u0002J\r\u0010\u008c\u0001\u001a\u00020;*\u00020\u001aH\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010#\u001a\u00020\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u000e\u0010(\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020,X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020,X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020,X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020;X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020,X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020,X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020,X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020,X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020,X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010A\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0004\n\u0002\u0010BR\u000e\u0010C\u001a\u00020DX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020,X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010F\u001a\u0004\u0018\u00010GX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010H\u001a\u0004\u0018\u00010IX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0090\u0001"}, d2 = {"Lru/mrlargha/commonui/utils/ui/CustomCardView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "paint", "Landroid/graphics/Paint;", "patternPaint", "path", "Landroid/graphics/Path;", "patternMatrix", "Landroid/graphics/Matrix;", "radii", "", "typedArray", "Landroid/content/res/TypedArray;", "topLeft", "", "topRight", "bottomRight", "bottomLeft", "corners", "bgMainColor", "", "bgSecondColor", "gradientAngle", "bgTransparency", "gradientType", "gradientRadius", "gradientList", "", "borderWidth", "borderMainColor", "getBorderMainColor", "()I", "setBorderMainColor", "(I)V", "borderSecondColor", "borderGradientAngle", "borderTransparency", "hasBorderSecondColor", "", "hasSecondColor", "hasGradientList", "patternDrawable", "Landroid/graphics/drawable/Drawable;", "patternTransparency", "initialPatternScale", "patternScaleX", "patternScaleY", "patternOffsetX", "patternOffsetY", "patternRotation", "patternTintColor", "hasPatternTintColor", "patternTileMode", "Landroid/graphics/Shader$TileMode;", "hasTopLeft", "hasTopRight", "hasBottomLeft", "hasBottomRight", "hasBorder", "percentWidth", "Ljava/lang/Float;", "gradientColorList", "", "isAlphaSet", "patternBitmap", "Landroid/graphics/Bitmap;", "patternShader", "Landroid/graphics/BitmapShader;", "setGradientColorList", "", "getFloatGradient", "setBackground", "mainColor", "Landroidx/annotation/ColorInt;", "secondColor", "angle", "Lru/mrlargha/commonui/utils/ui/CustomCardView$GradientType;", "(IILjava/lang/Integer;Lru/mrlargha/commonui/utils/ui/CustomCardView$GradientType;)V", "colorList", "([ILjava/lang/Integer;Lru/mrlargha/commonui/utils/ui/CustomCardView$GradientType;)V", "setBackgroundAlpha", "alpha", "setBorder", "(IILjava/lang/Integer;)V", "setBorderAlpha", "setPattern", "drawable", "setPatternResource", "drawableRes", "Landroidx/annotation/DrawableRes;", "clearPattern", "setPatternAlpha", "setPatternScale", "scale", "scaleX", "scaleY", "setPatternOffset", "offsetX", "offsetY", "setPatternRotation", Key.ROTATION, "setPatternTint", "tintColor", "clearPatternTint", "setPatternTileMode", "tileMode", "Lru/mrlargha/commonui/utils/ui/CustomCardView$PatternTileMode;", "setPercentWidth", "percent", "resetPercentWidth", "setCorners", "radius", "changeValidate", "isValidate", "inValidateAlpha", "draw", "canvas", "Landroid/graphics/Canvas;", "onDraw", "onSizeChanged", "w", CmcdData.STREAMING_FORMAT_HLS, "oldw", "oldh", "setGradient", "setLinearGradientType", "setBorderGradient", "borderGradient", "drawPattern", "shapePath", "getPatternShader", "createPatternBitmap", "invalidatePatternCache", "hasIntrinsicSize", "toPatternTileMode", "GradientType", "PatternTileMode", "Companion", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class CustomCardView extends FrameLayout {
    public static final Companion Companion = new Companion(null);
    private static final int MIN_PATTERN_BITMAP_SIZE = 1;
    private static final float MIN_PATTERN_SCALE = 0.01f;
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
    private boolean hasPatternTintColor;
    private boolean hasSecondColor;
    private final boolean hasTopLeft;
    private final boolean hasTopRight;
    private final float initialPatternScale;
    private boolean isAlphaSet;
    private final Paint paint;
    private final Path path;
    private Bitmap patternBitmap;
    private Drawable patternDrawable;
    private final Matrix patternMatrix;
    private float patternOffsetX;
    private float patternOffsetY;
    private final Paint patternPaint;
    private float patternRotation;
    private float patternScaleX;
    private float patternScaleY;
    private BitmapShader patternShader;
    private Shader.TileMode patternTileMode;
    private int patternTintColor;
    private int patternTransparency;
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
        this.patternPaint = new Paint(1);
        this.path = new Path();
        this.patternMatrix = new Matrix();
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
        this.patternDrawable = obtainStyledAttributes.getDrawable(R.styleable.CustomCardView_patternDrawable);
        this.patternTransparency = RangesKt.coerceIn(obtainStyledAttributes.getInteger(R.styleable.CustomCardView_patternTransparency, 100), 0, 100);
        float coerceAtLeast = RangesKt.coerceAtLeast(obtainStyledAttributes.getFloat(R.styleable.CustomCardView_patternScale, 1.0f), 0.01f);
        this.initialPatternScale = coerceAtLeast;
        this.patternScaleX = RangesKt.coerceAtLeast(obtainStyledAttributes.getFloat(R.styleable.CustomCardView_patternScaleX, coerceAtLeast), 0.01f);
        this.patternScaleY = RangesKt.coerceAtLeast(obtainStyledAttributes.getFloat(R.styleable.CustomCardView_patternScaleY, coerceAtLeast), 0.01f);
        this.patternOffsetX = obtainStyledAttributes.getDimension(R.styleable.CustomCardView_patternOffsetX, 0.0f);
        this.patternOffsetY = obtainStyledAttributes.getDimension(R.styleable.CustomCardView_patternOffsetY, 0.0f);
        this.patternRotation = obtainStyledAttributes.getFloat(R.styleable.CustomCardView_patternRotation, 0.0f);
        this.patternTintColor = obtainStyledAttributes.getColor(R.styleable.CustomCardView_patternTintColor, 0);
        this.hasPatternTintColor = obtainStyledAttributes.hasValue(R.styleable.CustomCardView_patternTintColor);
        this.patternTileMode = toPatternTileMode(obtainStyledAttributes.getInteger(R.styleable.CustomCardView_patternTileMode, 0));
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

    public final void setPattern(Drawable drawable) {
        this.patternDrawable = drawable;
        invalidatePatternCache();
        invalidate();
    }

    public final void setPatternResource(int i) {
        setPattern(ContextCompat.getDrawable(getContext(), i));
    }

    public final void clearPattern() {
        setPattern(null);
    }

    public final void setPatternAlpha(int i) {
        this.patternTransparency = RangesKt.coerceIn(i, 0, 100);
        invalidate();
    }

    public final void setPatternScale(float f) {
        float coerceAtLeast = RangesKt.coerceAtLeast(f, 0.01f);
        setPatternScale(coerceAtLeast, coerceAtLeast);
    }

    public final void setPatternScale(float f, float f2) {
        this.patternScaleX = RangesKt.coerceAtLeast(f, 0.01f);
        this.patternScaleY = RangesKt.coerceAtLeast(f2, 0.01f);
        invalidate();
    }

    public final void setPatternOffset(float f, float f2) {
        this.patternOffsetX = f;
        this.patternOffsetY = f2;
        invalidate();
    }

    public final void setPatternRotation(float f) {
        this.patternRotation = f;
        invalidate();
    }

    public final void setPatternTint(int i) {
        this.hasPatternTintColor = true;
        this.patternTintColor = i;
        invalidatePatternCache();
        invalidate();
    }

    public final void clearPatternTint() {
        this.hasPatternTintColor = false;
        invalidatePatternCache();
        invalidate();
    }

    public final void setPatternTileMode(PatternTileMode tileMode) {
        Intrinsics.checkNotNullParameter(tileMode, "tileMode");
        this.patternTileMode = tileMode.getShaderTileMode();
        invalidatePatternCache();
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

    public final void setCorners(float f) {
        ArraysKt.fill$default(this.radii, f, 0, 0, 6, (Object) null);
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
        drawPattern(canvas, this.path);
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

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        Drawable drawable = this.patternDrawable;
        if (drawable == null || hasIntrinsicSize(drawable)) {
            return;
        }
        invalidatePatternCache();
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

    private final void drawPattern(Canvas canvas, Path path) {
        BitmapShader patternShader = getPatternShader();
        if (patternShader == null) {
            return;
        }
        this.patternMatrix.reset();
        this.patternMatrix.setScale(this.patternScaleX, this.patternScaleY);
        float f = this.patternRotation;
        if (f != 0.0f) {
            this.patternMatrix.postRotate(f, getWidth() / 2.0f, getHeight() / 2.0f);
        }
        this.patternMatrix.postTranslate(this.patternOffsetX, this.patternOffsetY);
        patternShader.setLocalMatrix(this.patternMatrix);
        this.patternPaint.setShader(patternShader);
        this.patternPaint.setAlpha((this.patternTransparency * 255) / 100);
        this.patternPaint.setStyle(Paint.Style.FILL);
        canvas.drawPath(path, this.patternPaint);
    }

    private final BitmapShader getPatternShader() {
        Bitmap bitmap = this.patternBitmap;
        if (bitmap == null) {
            bitmap = createPatternBitmap();
            if (bitmap != null) {
                this.patternBitmap = bitmap;
            } else {
                bitmap = null;
            }
        }
        if (bitmap == null || bitmap.isRecycled()) {
            return null;
        }
        BitmapShader bitmapShader = this.patternShader;
        if (bitmapShader == null) {
            Shader.TileMode tileMode = this.patternTileMode;
            BitmapShader bitmapShader2 = new BitmapShader(bitmap, tileMode, tileMode);
            this.patternShader = bitmapShader2;
            return bitmapShader2;
        }
        return bitmapShader;
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0097  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Bitmap createPatternBitmap() {
        Drawable mutate;
        int i;
        Integer valueOf;
        Drawable newDrawable;
        Bitmap bitmap;
        Drawable drawable = this.patternDrawable;
        if (drawable == null) {
            return null;
        }
        if (!this.hasPatternTintColor && (drawable instanceof BitmapDrawable) && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null) {
            if (bitmap.isRecycled()) {
                bitmap = null;
            }
            if (bitmap != null) {
                return bitmap;
            }
        }
        Drawable.ConstantState constantState = drawable.getConstantState();
        if (constantState == null || (newDrawable = constantState.newDrawable(getResources())) == null || (mutate = newDrawable.mutate()) == null) {
            mutate = drawable.mutate();
            Intrinsics.checkNotNullExpressionValue(mutate, "mutate(...)");
        }
        if (this.hasPatternTintColor) {
            DrawableCompat.setTint(mutate, this.patternTintColor);
        }
        Integer valueOf2 = Integer.valueOf(mutate.getIntrinsicWidth());
        if (valueOf2.intValue() <= 0) {
            valueOf2 = null;
        }
        int i2 = 1;
        if (valueOf2 == null) {
            valueOf2 = Integer.valueOf(getWidth());
            if (valueOf2.intValue() <= 0) {
                valueOf2 = null;
            }
            if (valueOf2 == null) {
                i = 1;
                valueOf = Integer.valueOf(mutate.getIntrinsicHeight());
                if (valueOf.intValue() <= 0) {
                    valueOf = null;
                }
                if (valueOf == null) {
                    i2 = valueOf.intValue();
                } else {
                    Integer valueOf3 = Integer.valueOf(getHeight());
                    Integer num = valueOf3.intValue() > 0 ? valueOf3 : null;
                    if (num != null) {
                        i2 = num.intValue();
                    }
                }
                Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
                Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(...)");
                Canvas canvas = new Canvas(createBitmap);
                mutate.setBounds(0, 0, i, i2);
                mutate.draw(canvas);
                return createBitmap;
            }
        }
        i = valueOf2.intValue();
        valueOf = Integer.valueOf(mutate.getIntrinsicHeight());
        if (valueOf.intValue() <= 0) {
        }
        if (valueOf == null) {
        }
        Bitmap createBitmap2 = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(createBitmap2, "createBitmap(...)");
        Canvas canvas2 = new Canvas(createBitmap2);
        mutate.setBounds(0, 0, i, i2);
        mutate.draw(canvas2);
        return createBitmap2;
    }

    private final void invalidatePatternCache() {
        this.patternBitmap = null;
        this.patternShader = null;
    }

    private final boolean hasIntrinsicSize(Drawable drawable) {
        return drawable.getIntrinsicWidth() > 0 && drawable.getIntrinsicHeight() > 0;
    }

    private final Shader.TileMode toPatternTileMode(int i) {
        if (i != 1) {
            if (i == 2) {
                return Shader.TileMode.CLAMP;
            }
            return Shader.TileMode.REPEAT;
        }
        return Shader.TileMode.MIRROR;
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

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: CustomCardView.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lru/mrlargha/commonui/utils/ui/CustomCardView$PatternTileMode;", "", "shaderTileMode", "Landroid/graphics/Shader$TileMode;", "<init>", "(Ljava/lang/String;ILandroid/graphics/Shader$TileMode;)V", "getShaderTileMode", "()Landroid/graphics/Shader$TileMode;", "REPEAT", "MIRROR", "CLAMP", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class PatternTileMode {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ PatternTileMode[] $VALUES;
        private final Shader.TileMode shaderTileMode;
        public static final PatternTileMode REPEAT = new PatternTileMode("REPEAT", 0, Shader.TileMode.REPEAT);
        public static final PatternTileMode MIRROR = new PatternTileMode("MIRROR", 1, Shader.TileMode.MIRROR);
        public static final PatternTileMode CLAMP = new PatternTileMode("CLAMP", 2, Shader.TileMode.CLAMP);

        private static final /* synthetic */ PatternTileMode[] $values() {
            return new PatternTileMode[]{REPEAT, MIRROR, CLAMP};
        }

        public static EnumEntries<PatternTileMode> getEntries() {
            return $ENTRIES;
        }

        public static PatternTileMode valueOf(String str) {
            return (PatternTileMode) Enum.valueOf(PatternTileMode.class, str);
        }

        public static PatternTileMode[] values() {
            return (PatternTileMode[]) $VALUES.clone();
        }

        private PatternTileMode(String str, int i, Shader.TileMode tileMode) {
            this.shaderTileMode = tileMode;
        }

        public final Shader.TileMode getShaderTileMode() {
            return this.shaderTileMode;
        }

        static {
            PatternTileMode[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }
    }

    /* compiled from: CustomCardView.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lru/mrlargha/commonui/utils/ui/CustomCardView$Companion;", "", "<init>", "()V", "MIN_PATTERN_SCALE", "", "MIN_PATTERN_BITMAP_SIZE", "", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
