package androidx.compose.ui.graphics.shadow;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Size;
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
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.PaintingStyle;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.ShaderBrush;
import androidx.compose.ui.graphics.ShaderKt;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DropShadowPainter.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J-\u0010\u0010\u001a\u00020\u0011*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014¢\u0006\u0004\b\u0019\u0010\u001aJ\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002JQ\u0010\u001e\u001a\u00020\u0011*\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010#\u001a\u00020$H\u0014¢\u0006\u0004\b%\u0010&J/\u0010'\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010(\u001a\u00020 2\u0006\u0010)\u001a\u00020 H\u0002¢\u0006\u0004\b*\u0010+J/\u0010'\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010,\u001a\u00020 2\u0006\u0010)\u001a\u00020 2\u0006\u0010\u0015\u001a\u00020\u0016H\u0002¢\u0006\u0004\b-\u0010.R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Landroidx/compose/ui/graphics/shadow/DropShadowRenderer;", "Landroidx/compose/ui/graphics/shadow/ShadowRenderer;", "shadow", "Landroidx/compose/ui/graphics/shadow/Shadow;", "outline", "Landroidx/compose/ui/graphics/Outline;", "<init>", "(Landroidx/compose/ui/graphics/shadow/Shadow;Landroidx/compose/ui/graphics/Outline;)V", "getShadow", "()Landroidx/compose/ui/graphics/shadow/Shadow;", "paint", "Landroidx/compose/ui/graphics/Paint;", "shadowBitmap", "Landroidx/compose/ui/graphics/ImageBitmap;", "compositeShader", "Landroidx/compose/ui/graphics/CompositeShaderBrush;", "buildShadow", "", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "size", "Landroidx/compose/ui/geometry/Size;", "cornerRadius", "Landroidx/compose/ui/geometry/CornerRadius;", "path", "Landroidx/compose/ui/graphics/Path;", "buildShadow-_SMYjrA", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JJLandroidx/compose/ui/graphics/Path;)V", "obtainCompositeBrush", "Landroidx/compose/ui/graphics/Brush;", "brush", "onDrawShadow", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "onDrawShadow-MLmccfk", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JJLandroidx/compose/ui/graphics/Path;FLandroidx/compose/ui/graphics/ColorFilter;Landroidx/compose/ui/graphics/Brush;I)V", "createOuterShadowBitmap", "radius", "spread", "createOuterShadowBitmap-Cqks5Fs", "(JLandroidx/compose/ui/graphics/Path;FF)Landroidx/compose/ui/graphics/ImageBitmap;", "shadowRadius", "createOuterShadowBitmap-D_oqF2M", "(JFFJ)Landroidx/compose/ui/graphics/ImageBitmap;", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DropShadowRenderer extends ShadowRenderer {
    private CompositeShaderBrush compositeShader;
    private final Paint paint;
    private final Shadow shadow;
    private ImageBitmap shadowBitmap;

    public DropShadowRenderer(Shadow shadow, Outline outline) {
        super(outline);
        this.shadow = shadow;
        this.paint = AndroidPaint_androidKt.Paint();
    }

    public final Shadow getShadow() {
        return this.shadow;
    }

    @Override // androidx.compose.ui.graphics.shadow.ShadowRenderer
    /* renamed from: buildShadow-_SMYjrA  reason: not valid java name */
    protected void mo5997buildShadow_SMYjrA(DrawScope drawScope, long j, long j2, Path path) {
        DropShadowRenderer dropShadowRenderer;
        ImageBitmap m5996createOuterShadowBitmapD_oqF2M;
        float f = drawScope.mo430toPx0680j_4(this.shadow.m6005getRadiusD9Ej5fM());
        float f2 = drawScope.mo430toPx0680j_4(this.shadow.m6006getSpreadD9Ej5fM());
        if (path != null) {
            dropShadowRenderer = this;
            m5996createOuterShadowBitmapD_oqF2M = dropShadowRenderer.m5995createOuterShadowBitmapCqks5Fs(j, path, f, f2);
        } else {
            dropShadowRenderer = this;
            m5996createOuterShadowBitmapD_oqF2M = dropShadowRenderer.m5996createOuterShadowBitmapD_oqF2M(j, f, f2, j2);
        }
        dropShadowRenderer.shadowBitmap = m5996createOuterShadowBitmapD_oqF2M;
    }

    private final Brush obtainCompositeBrush(ImageBitmap imageBitmap, Brush brush) {
        CompositeShaderBrush compositeShaderBrush = this.compositeShader;
        if (compositeShaderBrush == null || !Intrinsics.areEqual(compositeShaderBrush.getSrcBrush(), brush)) {
            Brush.Companion companion = Brush.Companion;
            ShaderBrush ShaderBrush = BrushKt.ShaderBrush(ShaderKt.m5609ImageShaderF49vj9s$default(imageBitmap, 0, 0, 6, null));
            if (brush instanceof ShaderBrush) {
                brush = BrushKt.ShaderBrush(((ShaderBrush) brush).mo5249createShaderuvyYCjk(Size.m5096constructorimpl((Float.floatToRawIntBits(imageBitmap.getWidth()) << 32) | (Float.floatToRawIntBits(imageBitmap.getHeight()) & 4294967295L))));
            }
            Brush m5238composite7EN7VTw = companion.m5238composite7EN7VTw(ShaderBrush, brush, BlendMode.Companion.m5219getSrcIn0nO6VwU());
            Intrinsics.checkNotNull(m5238composite7EN7VTw, "null cannot be cast to non-null type androidx.compose.ui.graphics.CompositeShaderBrush");
            compositeShaderBrush = (CompositeShaderBrush) m5238composite7EN7VTw;
            this.compositeShader = compositeShaderBrush;
        }
        return compositeShaderBrush;
    }

    @Override // androidx.compose.ui.graphics.shadow.ShadowRenderer
    /* renamed from: onDrawShadow-MLmccfk  reason: not valid java name */
    protected void mo5998onDrawShadowMLmccfk(DrawScope drawScope, long j, long j2, Path path, float f, ColorFilter colorFilter, Brush brush, int i) {
        ImageBitmap imageBitmap = this.shadowBitmap;
        if (imageBitmap != null) {
            float f2 = -(drawScope.mo430toPx0680j_4(this.shadow.m6005getRadiusD9Ej5fM()) + drawScope.mo430toPx0680j_4(this.shadow.m6006getSpreadD9Ej5fM()));
            if (brush != null && colorFilter == null) {
                Brush obtainCompositeBrush = obtainCompositeBrush(imageBitmap, brush);
                drawScope.getDrawContext().getTransform().translate(f2, f2);
                try {
                    DrawScope.m5852drawRectAsUm42w$default(drawScope, obtainCompositeBrush, 0L, Size.m5096constructorimpl((Float.floatToRawIntBits(imageBitmap.getHeight()) & 4294967295L) | (Float.floatToRawIntBits(imageBitmap.getWidth()) << 32)), f, null, null, i, 50, null);
                    return;
                } finally {
                    float f3 = -f2;
                    drawScope.getDrawContext().getTransform().translate(f3, f3);
                }
            }
            DrawScope.m5843drawImagegbVJVH8$default(drawScope, imageBitmap, Offset.m5028constructorimpl((4294967295L & Float.floatToRawIntBits(f2)) | (Float.floatToRawIntBits(f2) << 32)), f, null, colorFilter, i, 8, null);
        }
    }

    /* renamed from: createOuterShadowBitmap-Cqks5Fs  reason: not valid java name */
    private final ImageBitmap m5995createOuterShadowBitmapCqks5Fs(long j, Path path, float f, float f2) {
        float f3 = 2;
        float f4 = (f * f3) + (f3 * f2);
        ImageBitmap m5517ImageBitmapx__hDU$default = ImageBitmapKt.m5517ImageBitmapx__hDU$default((int) Math.ceil(Float.intBitsToFloat((int) (j >> 32)) + f4), (int) Math.ceil(Float.intBitsToFloat((int) (j & 4294967295L)) + f4), ImageBitmapConfig.Companion.m5511getAlpha8_sVssgQ(), false, null, 24, null);
        Canvas Canvas = CanvasKt.Canvas(m5517ImageBitmapx__hDU$default);
        if (f2 > 0.0f) {
            float f5 = f + f2;
            Canvas.translate(f5, f5);
            Canvas.drawPath(path, this.paint);
            Paint m5994configureShadowFoewPVk$default = BlurKt.m5994configureShadowFoewPVk$default(this.paint, 0L, 0, f > 0.0f ? Blur_androidKt.BlurFilter(f) : null, PaintingStyle.Companion.m5560getStrokeTiuSbCo(), 3, null);
            m5994configureShadowFoewPVk$default.setStrokeWidth(2.0f * f2);
            Unit unit = Unit.INSTANCE;
            Canvas.drawPath(path, m5994configureShadowFoewPVk$default);
            return m5517ImageBitmapx__hDU$default;
        }
        BlurKt.m5994configureShadowFoewPVk$default(this.paint, 0L, 0, f > 0.0f ? Blur_androidKt.BlurFilter(f) : null, 0, 11, null);
        Canvas.translate(f, f);
        Canvas.drawPath(path, this.paint);
        return m5517ImageBitmapx__hDU$default;
    }

    /* renamed from: createOuterShadowBitmap-D_oqF2M  reason: not valid java name */
    private final ImageBitmap m5996createOuterShadowBitmapD_oqF2M(long j, float f, float f2, long j2) {
        float f3 = 2;
        float f4 = (f * f3) + (f3 * f2);
        float intBitsToFloat = Float.intBitsToFloat((int) (j >> 32)) + f4;
        float intBitsToFloat2 = Float.intBitsToFloat((int) (j & 4294967295L)) + f4;
        ImageBitmap m5517ImageBitmapx__hDU$default = ImageBitmapKt.m5517ImageBitmapx__hDU$default((int) Math.ceil(intBitsToFloat), (int) Math.ceil(intBitsToFloat2), ImageBitmapConfig.Companion.m5511getAlpha8_sVssgQ(), false, null, 24, null);
        CanvasKt.Canvas(m5517ImageBitmapx__hDU$default).drawRoundRect(f, f, intBitsToFloat - f, intBitsToFloat2 - f, Float.intBitsToFloat((int) (j2 >> 32)), Float.intBitsToFloat((int) (j2 & 4294967295L)), BlurKt.m5994configureShadowFoewPVk$default(this.paint, 0L, 0, f > 0.0f ? Blur_androidKt.BlurFilter(f) : null, 0, 11, null));
        return m5517ImageBitmapx__hDU$default;
    }
}
