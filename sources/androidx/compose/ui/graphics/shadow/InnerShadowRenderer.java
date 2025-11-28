package androidx.compose.ui.graphics.shadow;

import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.CanvasKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.CompositeShaderBrush;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.ImageBitmapConfig;
import androidx.compose.ui.graphics.ImageBitmapKt;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.PaintingStyle;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.ShaderBrush;
import androidx.compose.ui.graphics.ShaderKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.DpOffset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: InnerShadowPainter.kt */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\u0011\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J-\u0010\u0014\u001a\u00020\u0015*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0014¢\u0006\u0004\b\u001d\u0010\u001eJ\u0018\u0010\u001f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020!H\u0002JQ\u0010\"\u001a\u00020\u0015*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010'\u001a\u00020(H\u0014¢\u0006\u0004\b)\u0010*J?\u0010+\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010,\u001a\u00020$2\u0006\u0010-\u001a\u00020$2\u0006\u0010.\u001a\u00020$2\u0006\u0010/\u001a\u00020$H\u0002¢\u0006\u0004\b0\u00101J?\u00102\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010,\u001a\u00020$2\u0006\u0010-\u001a\u00020$2\u0006\u0010.\u001a\u00020$2\u0006\u0010/\u001a\u00020$2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002¢\u0006\u0004\b3\u00104R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0010¨\u00065"}, d2 = {"Landroidx/compose/ui/graphics/shadow/InnerShadowRenderer;", "Landroidx/compose/ui/graphics/shadow/ShadowRenderer;", "shadow", "Landroidx/compose/ui/graphics/shadow/Shadow;", "outline", "Landroidx/compose/ui/graphics/Outline;", "<init>", "(Landroidx/compose/ui/graphics/shadow/Shadow;Landroidx/compose/ui/graphics/Outline;)V", "paint", "Landroidx/compose/ui/graphics/Paint;", "shadowMask", "Landroidx/compose/ui/graphics/ShaderBrush;", "compositeShader", "Landroidx/compose/ui/graphics/CompositeShaderBrush;", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "[F", "obtainMatrix", "obtainMatrix-sQKQjiQ", "()[F", "buildShadow", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "size", "Landroidx/compose/ui/geometry/Size;", "cornerRadius", "Landroidx/compose/ui/geometry/CornerRadius;", "path", "Landroidx/compose/ui/graphics/Path;", "buildShadow-_SMYjrA", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JJLandroidx/compose/ui/graphics/Path;)V", "obtainCompositeBrush", "brush", "Landroidx/compose/ui/graphics/Brush;", "onDrawShadow", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "onDrawShadow-MLmccfk", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JJLandroidx/compose/ui/graphics/Path;FLandroidx/compose/ui/graphics/ColorFilter;Landroidx/compose/ui/graphics/Brush;I)V", "createInnerPathShadowBrush", "radius", "spread", "offsetX", "offsetY", "createInnerPathShadowBrush-LjSzlW0", "(JLandroidx/compose/ui/graphics/Path;FFFF)Landroidx/compose/ui/graphics/ShaderBrush;", "createInnerShadowBrush", "createInnerShadowBrush-u1Psq-8", "(JFFFFJ)Landroidx/compose/ui/graphics/ShaderBrush;", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class InnerShadowRenderer extends ShadowRenderer {
    private CompositeShaderBrush compositeShader;
    private float[] matrix;
    private final Paint paint;
    private final Shadow shadow;
    private ShaderBrush shadowMask;

    public InnerShadowRenderer(Shadow shadow, Outline outline) {
        super(outline);
        this.shadow = shadow;
        this.paint = AndroidPaint_androidKt.Paint();
    }

    /* renamed from: obtainMatrix-sQKQjiQ  reason: not valid java name */
    private final float[] m6001obtainMatrixsQKQjiQ() {
        float[] fArr = this.matrix;
        if (fArr == null) {
            float[] m5522constructorimpl$default = Matrix.m5522constructorimpl$default(null, 1, null);
            this.matrix = m5522constructorimpl$default;
            return m5522constructorimpl$default;
        }
        return fArr;
    }

    @Override // androidx.compose.ui.graphics.shadow.ShadowRenderer
    /* renamed from: buildShadow-_SMYjrA */
    protected void mo5997buildShadow_SMYjrA(DrawScope drawScope, long j, long j2, Path path) {
        ShaderBrush m6000createInnerShadowBrushu1Psq8;
        float f = drawScope.mo430toPx0680j_4(this.shadow.m6005getRadiusD9Ej5fM());
        float f2 = drawScope.mo430toPx0680j_4(this.shadow.m6006getSpreadD9Ej5fM());
        float f3 = drawScope.mo430toPx0680j_4(DpOffset.m8057getXD9Ej5fM(this.shadow.m6004getOffsetRKDOV3M()));
        float f4 = drawScope.mo430toPx0680j_4(DpOffset.m8059getYD9Ej5fM(this.shadow.m6004getOffsetRKDOV3M()));
        if (path != null) {
            m6000createInnerShadowBrushu1Psq8 = m5999createInnerPathShadowBrushLjSzlW0(j, path, f, f2, f3, f4);
        } else {
            m6000createInnerShadowBrushu1Psq8 = m6000createInnerShadowBrushu1Psq8(j, f, f2, f3, f4, j2);
        }
        this.shadowMask = m6000createInnerShadowBrushu1Psq8;
    }

    private final CompositeShaderBrush obtainCompositeBrush(ShaderBrush shaderBrush, Brush brush) {
        CompositeShaderBrush compositeShaderBrush = this.compositeShader;
        if (compositeShaderBrush == null || !Intrinsics.areEqual(compositeShaderBrush.getSrcBrush(), brush)) {
            CompositeShaderBrush compositeShaderBrush2 = new CompositeShaderBrush(BrushKt.toShaderBrush(shaderBrush), BrushKt.toShaderBrush(brush), BlendMode.Companion.m5219getSrcIn0nO6VwU(), null);
            this.compositeShader = compositeShaderBrush2;
            return compositeShaderBrush2;
        }
        return compositeShaderBrush;
    }

    @Override // androidx.compose.ui.graphics.shadow.ShadowRenderer
    /* renamed from: onDrawShadow-MLmccfk */
    protected void mo5998onDrawShadowMLmccfk(DrawScope drawScope, long j, long j2, Path path, float f, ColorFilter colorFilter, Brush brush, int i) {
        CompositeShaderBrush compositeShaderBrush = this.shadowMask;
        if (compositeShaderBrush != null) {
            if (this.shadow.getBrush() instanceof ShaderBrush) {
                compositeShaderBrush = obtainCompositeBrush(compositeShaderBrush, this.shadow.getBrush());
            }
            if (path != null) {
                DrawScope.m5848drawPathGBMwjPU$default(drawScope, path, compositeShaderBrush, f, null, colorFilter, i, 8, null);
            } else if (CornerRadius.m4995equalsimpl0(j2, CornerRadius.Companion.m5008getZerokKHJgLs())) {
                DrawScope.m5852drawRectAsUm42w$default(drawScope, compositeShaderBrush, 0L, 0L, f, null, colorFilter, i, 22, null);
            } else {
                DrawScope.m5854drawRoundRectZuiqVtQ$default(drawScope, compositeShaderBrush, 0L, 0L, j2, f, null, colorFilter, this.shadow.m6002getBlendMode0nO6VwU(), 38, null);
            }
        }
    }

    /* renamed from: createInnerPathShadowBrush-LjSzlW0  reason: not valid java name */
    private final ShaderBrush m5999createInnerPathShadowBrushLjSzlW0(long j, Path path, float f, float f2, float f3, float f4) {
        ImageBitmap imageBitmap;
        int ceil = (int) Math.ceil(Float.intBitsToFloat((int) (j >> 32)));
        int ceil2 = (int) Math.ceil(Float.intBitsToFloat((int) (j & 4294967295L)));
        if (f2 > 0.0f) {
            Rect bounds = path.getBounds();
            float right = bounds.getRight() - bounds.getLeft();
            float bottom = bounds.getBottom() - bounds.getTop();
            imageBitmap = ImageBitmapKt.m5517ImageBitmapx__hDU$default((int) Math.ceil(right), (int) Math.ceil(bottom), ImageBitmapConfig.Companion.m5511getAlpha8_sVssgQ(), false, null, 24, null);
            Canvas Canvas = CanvasKt.Canvas(imageBitmap);
            Canvas.drawPath(path, this.paint);
            Canvas.m5252clipRectN_I0leg$default(Canvas, 0.0f, 0.0f, right, bottom, 0, 16, null);
            Paint m5994configureShadowFoewPVk$default = BlurKt.m5994configureShadowFoewPVk$default(this.paint, 0L, BlendMode.Companion.m5194getClear0nO6VwU(), null, PaintingStyle.Companion.m5560getStrokeTiuSbCo(), 5, null);
            m5994configureShadowFoewPVk$default.setStrokeWidth(2.0f * f2);
            Unit unit = Unit.INSTANCE;
            Canvas.drawPath(path, m5994configureShadowFoewPVk$default);
        } else {
            imageBitmap = null;
        }
        int ceil3 = ((int) Math.ceil(f)) * 2;
        ImageBitmap m5517ImageBitmapx__hDU$default = ImageBitmapKt.m5517ImageBitmapx__hDU$default(ceil + ceil3, ceil2 + ceil3, ImageBitmapConfig.Companion.m5511getAlpha8_sVssgQ(), false, null, 24, null);
        Canvas Canvas2 = CanvasKt.Canvas(m5517ImageBitmapx__hDU$default);
        if (imageBitmap != null) {
            Canvas2.drawRect(0.0f, 0.0f, m5517ImageBitmapx__hDU$default.getWidth(), m5517ImageBitmapx__hDU$default.getHeight(), BlurKt.m5994configureShadowFoewPVk$default(this.paint, 0L, 0, null, 0, 15, null));
            Canvas2.mo5134drawImaged4ec7I(imageBitmap, Offset.m5028constructorimpl((4294967295L & Float.floatToRawIntBits(f4)) | (Float.floatToRawIntBits(f3) << 32)), BlurKt.m5994configureShadowFoewPVk$default(this.paint, 0L, BlendMode.Companion.m5222getXor0nO6VwU(), f > 0.0f ? Blur_androidKt.BlurFilter(f) : null, 0, 9, null));
            return BrushKt.ShaderBrush(ShaderKt.m5609ImageShaderF49vj9s$default(m5517ImageBitmapx__hDU$default, 0, 0, 6, null));
        }
        Canvas2.save();
        Canvas2.translate(f3, f4);
        Canvas2.drawPath(path, BlurKt.m5994configureShadowFoewPVk$default(this.paint, 0L, 0, f > 0.0f ? Blur_androidKt.BlurFilter(f) : null, 0, 11, null));
        Canvas2.restore();
        Canvas2.drawRect(0.0f, 0.0f, m5517ImageBitmapx__hDU$default.getWidth(), m5517ImageBitmapx__hDU$default.getHeight(), BlurKt.m5994configureShadowFoewPVk$default(this.paint, 0L, BlendMode.Companion.m5222getXor0nO6VwU(), null, 0, 13, null));
        return BrushKt.ShaderBrush(ShaderKt.m5609ImageShaderF49vj9s$default(m5517ImageBitmapx__hDU$default, 0, 0, 6, null));
    }

    /* renamed from: createInnerShadowBrush-u1Psq-8  reason: not valid java name */
    private final ShaderBrush m6000createInnerShadowBrushu1Psq8(long j, float f, float f2, float f3, float f4, long j2) {
        int i = (int) (j >> 32);
        int i2 = (int) (j & 4294967295L);
        ImageBitmap m5517ImageBitmapx__hDU$default = ImageBitmapKt.m5517ImageBitmapx__hDU$default((int) Math.ceil(Float.intBitsToFloat(i)), (int) Math.ceil(Float.intBitsToFloat(i2)), ImageBitmapConfig.Companion.m5511getAlpha8_sVssgQ(), false, null, 24, null);
        Canvas Canvas = CanvasKt.Canvas(m5517ImageBitmapx__hDU$default);
        float f5 = f3 + f2;
        float f6 = f4 + f2;
        Canvas.drawRoundRect(f5, f6, Math.max(f5, (f3 + Float.intBitsToFloat(i)) - f2), Math.max(f6, (f4 + Float.intBitsToFloat(i2)) - f2), Float.intBitsToFloat((int) (j2 >> 32)), Float.intBitsToFloat((int) (j2 & 4294967295L)), BlurKt.m5994configureShadowFoewPVk$default(this.paint, 0L, 0, f > 0.0f ? Blur_androidKt.BlurFilter(f) : null, 0, 11, null));
        Canvas.drawRect(0.0f, 0.0f, m5517ImageBitmapx__hDU$default.getWidth(), m5517ImageBitmapx__hDU$default.getHeight(), BlurKt.m5994configureShadowFoewPVk$default(this.paint, 0L, BlendMode.Companion.m5222getXor0nO6VwU(), null, 0, 13, null));
        return BrushKt.ShaderBrush(ShaderKt.m5609ImageShaderF49vj9s$default(m5517ImageBitmapx__hDU$default, 0, 0, 6, null));
    }
}
