package androidx.compose.foundation;

import androidx.compose.ui.draw.CacheDrawModifierNode;
import androidx.compose.ui.draw.CacheDrawScope;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.draw.DrawResult;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.ImageBitmapConfig;
import androidx.compose.ui.graphics.ImageBitmapKt;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathOperation;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
/* compiled from: Border.kt */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ,\u0010%\u001a\u00020&*\u00020'2\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\f2\u0006\u0010+\u001a\u00020,H\u0002JC\u0010-\u001a\u00020&*\u00020'2\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010(\u001a\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\u0006\u0010*\u001a\u00020\f2\u0006\u0010+\u001a\u00020,H\u0002¢\u0006\u0004\b3\u00104J\f\u00105\u001a\u000206*\u000207H\u0016R\u0014\u0010\u000b\u001a\u00020\fX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\fX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004@FX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0006@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\u001e\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u000e\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Landroidx/compose/foundation/BorderModifierNode;", "Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "widthParameter", "Landroidx/compose/ui/unit/Dp;", "brushParameter", "Landroidx/compose/ui/graphics/Brush;", "shapeParameter", "Landroidx/compose/ui/graphics/Shape;", "<init>", "(FLandroidx/compose/ui/graphics/Brush;Landroidx/compose/ui/graphics/Shape;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "shouldAutoInvalidate", "", "getShouldAutoInvalidate", "()Z", "isImportantForBounds", "borderCache", "Landroidx/compose/foundation/BorderCache;", "value", "width", "getWidth-D9Ej5fM", "()F", "setWidth-0680j_4", "(F)V", "F", "brush", "getBrush", "()Landroidx/compose/ui/graphics/Brush;", "setBrush", "(Landroidx/compose/ui/graphics/Brush;)V", "shape", "getShape", "()Landroidx/compose/ui/graphics/Shape;", "setShape", "(Landroidx/compose/ui/graphics/Shape;)V", "drawWithCacheModifierNode", "Landroidx/compose/ui/draw/CacheDrawModifierNode;", "drawGenericBorder", "Landroidx/compose/ui/draw/DrawResult;", "Landroidx/compose/ui/draw/CacheDrawScope;", "outline", "Landroidx/compose/ui/graphics/Outline$Generic;", "fillArea", "strokeWidth", "", "drawRoundRectBorder", "Landroidx/compose/ui/graphics/Outline$Rounded;", "topLeft", "Landroidx/compose/ui/geometry/Offset;", "borderSize", "Landroidx/compose/ui/geometry/Size;", "drawRoundRectBorder-JqoCqck", "(Landroidx/compose/ui/draw/CacheDrawScope;Landroidx/compose/ui/graphics/Brush;Landroidx/compose/ui/graphics/Outline$Rounded;JJZF)Landroidx/compose/ui/draw/DrawResult;", "applySemantics", "", "Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "foundation_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class BorderModifierNode extends DelegatingNode implements SemanticsModifierNode {
    public static final int $stable = 8;
    private BorderCache borderCache;
    private Brush brush;
    private final CacheDrawModifierNode drawWithCacheModifierNode;
    private final boolean isImportantForBounds;
    private Shape shape;
    private final boolean shouldAutoInvalidate;
    private float width;

    public /* synthetic */ BorderModifierNode(float f, Brush brush, Shape shape, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, brush, shape);
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public void applySemantics(SemanticsPropertyReceiver semanticsPropertyReceiver) {
    }

    private BorderModifierNode(float f, Brush brush, Shape shape) {
        this.width = f;
        this.brush = brush;
        this.shape = shape;
        this.drawWithCacheModifierNode = (CacheDrawModifierNode) delegate(DrawModifierKt.CacheDrawModifierNode(new Function1() { // from class: androidx.compose.foundation.BorderModifierNode$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                DrawResult drawWithCacheModifierNode$lambda$0;
                drawWithCacheModifierNode$lambda$0 = BorderModifierNode.drawWithCacheModifierNode$lambda$0(BorderModifierNode.this, (CacheDrawScope) obj);
                return drawWithCacheModifierNode$lambda$0;
            }
        }));
    }

    @Override // androidx.compose.ui.Modifier.Node
    public boolean getShouldAutoInvalidate() {
        return this.shouldAutoInvalidate;
    }

    @Override // androidx.compose.ui.node.SemanticsModifierNode
    public boolean isImportantForBounds() {
        return this.isImportantForBounds;
    }

    /* renamed from: getWidth-D9Ej5fM  reason: not valid java name */
    public final float m289getWidthD9Ej5fM() {
        return this.width;
    }

    /* renamed from: setWidth-0680j_4  reason: not valid java name */
    public final void m290setWidth0680j_4(float f) {
        if (Dp.m8001equalsimpl0(this.width, f)) {
            return;
        }
        this.width = f;
        this.drawWithCacheModifierNode.invalidateDrawCache();
    }

    public final Brush getBrush() {
        return this.brush;
    }

    public final void setBrush(Brush brush) {
        if (Intrinsics.areEqual(this.brush, brush)) {
            return;
        }
        this.brush = brush;
        this.drawWithCacheModifierNode.invalidateDrawCache();
    }

    public final Shape getShape() {
        return this.shape;
    }

    public final void setShape(Shape shape) {
        if (Intrinsics.areEqual(this.shape, shape)) {
            return;
        }
        this.shape = shape;
        this.drawWithCacheModifierNode.invalidateDrawCache();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DrawResult drawWithCacheModifierNode$lambda$0(BorderModifierNode borderModifierNode, CacheDrawScope cacheDrawScope) {
        DrawResult drawContentWithoutBorder;
        DrawResult m283drawRectBorderNsqcLGU;
        if (cacheDrawScope.mo430toPx0680j_4(borderModifierNode.width) < 0.0f || Size.m5104getMinDimensionimpl(cacheDrawScope.m4820getSizeNHjbRc()) <= 0.0f) {
            drawContentWithoutBorder = BorderKt.drawContentWithoutBorder(cacheDrawScope);
            return drawContentWithoutBorder;
        }
        float f = 2;
        float min = Math.min(Dp.m8001equalsimpl0(borderModifierNode.width, Dp.Companion.m8014getHairlineD9Ej5fM()) ? 1.0f : (float) Math.ceil(cacheDrawScope.mo430toPx0680j_4(borderModifierNode.width)), (float) Math.ceil(Size.m5104getMinDimensionimpl(cacheDrawScope.m4820getSizeNHjbRc()) / f));
        float f2 = min / f;
        long m5028constructorimpl = Offset.m5028constructorimpl((Float.floatToRawIntBits(f2) & 4294967295L) | (Float.floatToRawIntBits(f2) << 32));
        long m5096constructorimpl = Size.m5096constructorimpl((Float.floatToRawIntBits(Float.intBitsToFloat((int) (cacheDrawScope.m4820getSizeNHjbRc() & 4294967295L)) - min) & 4294967295L) | (Float.floatToRawIntBits(Float.intBitsToFloat((int) (cacheDrawScope.m4820getSizeNHjbRc() >> 32)) - min) << 32));
        boolean z = f * min > Size.m5104getMinDimensionimpl(cacheDrawScope.m4820getSizeNHjbRc());
        Outline mo332createOutlinePq9zytI = borderModifierNode.shape.mo332createOutlinePq9zytI(cacheDrawScope.m4820getSizeNHjbRc(), cacheDrawScope.getLayoutDirection(), cacheDrawScope);
        if (mo332createOutlinePq9zytI instanceof Outline.Generic) {
            return borderModifierNode.drawGenericBorder(cacheDrawScope, borderModifierNode.brush, (Outline.Generic) mo332createOutlinePq9zytI, z, min);
        }
        if (mo332createOutlinePq9zytI instanceof Outline.Rounded) {
            return borderModifierNode.m288drawRoundRectBorderJqoCqck(cacheDrawScope, borderModifierNode.brush, (Outline.Rounded) mo332createOutlinePq9zytI, m5028constructorimpl, m5096constructorimpl, z, min);
        } else if (mo332createOutlinePq9zytI instanceof Outline.Rectangle) {
            m283drawRectBorderNsqcLGU = BorderKt.m283drawRectBorderNsqcLGU(cacheDrawScope, borderModifierNode.brush, m5028constructorimpl, m5096constructorimpl, z, min);
            return m283drawRectBorderNsqcLGU;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x00f8, code lost:
        if (androidx.compose.ui.graphics.ImageBitmapConfig.m5506equalsimpl(r8, r7 != null ? androidx.compose.ui.graphics.ImageBitmapConfig.m5504boximpl(r7.mo5145getConfig_sVssgQ()) : null) != false) goto L64;
     */
    /* JADX WARN: Removed duplicated region for block: B:40:0x015e  */
    /* JADX WARN: Type inference failed for: r24v3, types: [T, androidx.compose.ui.graphics.ImageBitmap] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final DrawResult drawGenericBorder(CacheDrawScope cacheDrawScope, final Brush brush, final Outline.Generic generic, boolean z, float f) {
        int m5512getArgb8888_sVssgQ;
        ColorFilter colorFilter;
        Rect rect;
        BorderCache borderCache;
        Ref.ObjectRef objectRef;
        ImageBitmap imageBitmap;
        Canvas canvas;
        CanvasDrawScope canvasDrawScope;
        CanvasDrawScope canvasDrawScope2;
        float f2;
        float f3;
        float f4;
        DrawContext drawContext;
        long mo5780getSizeNHjbRc;
        DrawContext drawContext2;
        long j;
        if (z) {
            return cacheDrawScope.onDrawWithContent(new Function1() { // from class: androidx.compose.foundation.BorderModifierNode$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit drawGenericBorder$lambda$1;
                    drawGenericBorder$lambda$1 = BorderModifierNode.drawGenericBorder$lambda$1(Outline.Generic.this, brush, (ContentDrawScope) obj);
                    return drawGenericBorder$lambda$1;
                }
            });
        }
        if (brush instanceof SolidColor) {
            m5512getArgb8888_sVssgQ = ImageBitmapConfig.Companion.m5511getAlpha8_sVssgQ();
            colorFilter = ColorFilter.Companion.m5321tintxETnrds$default(ColorFilter.Companion, Color.m5279copywmQWz5c$default(((SolidColor) brush).m5632getValue0d7_KjU(), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), 0, 2, null);
        } else {
            m5512getArgb8888_sVssgQ = ImageBitmapConfig.Companion.m5512getArgb8888_sVssgQ();
            colorFilter = null;
        }
        int i = m5512getArgb8888_sVssgQ;
        Rect bounds = generic.getPath().getBounds();
        if (this.borderCache == null) {
            this.borderCache = new BorderCache(null, null, null, null, 15, null);
        }
        BorderCache borderCache2 = this.borderCache;
        Intrinsics.checkNotNull(borderCache2);
        Path obtainPath = borderCache2.obtainPath();
        obtainPath.reset();
        Path.addRect$default(obtainPath, bounds, null, 2, null);
        obtainPath.mo5170opN5in7k0(obtainPath, generic.getPath(), PathOperation.Companion.m5584getDifferenceb3I0S0c());
        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        final long m8162constructorimpl = IntSize.m8162constructorimpl((((int) Math.ceil(bounds.getBottom() - bounds.getTop())) & 4294967295L) | (((int) Math.ceil(bounds.getRight() - bounds.getLeft())) << 32));
        BorderCache borderCache3 = this.borderCache;
        Intrinsics.checkNotNull(borderCache3);
        ImageBitmap imageBitmap2 = borderCache3.imageBitmap;
        Canvas canvas2 = borderCache3.canvas;
        ImageBitmapConfig m5504boximpl = imageBitmap2 != null ? ImageBitmapConfig.m5504boximpl(imageBitmap2.mo5145getConfig_sVssgQ()) : null;
        boolean z2 = false;
        if (!(m5504boximpl == null ? false : ImageBitmapConfig.m5507equalsimpl0(m5504boximpl.m5510unboximpl(), ImageBitmapConfig.Companion.m5512getArgb8888_sVssgQ()))) {
        }
        z2 = true;
        try {
            try {
                try {
                    try {
                        if (imageBitmap2 == null || canvas2 == null) {
                            rect = bounds;
                        } else {
                            rect = bounds;
                            if (Float.intBitsToFloat((int) (cacheDrawScope.m4820getSizeNHjbRc() >> 32)) <= imageBitmap2.getWidth() && Float.intBitsToFloat((int) (cacheDrawScope.m4820getSizeNHjbRc() & 4294967295L)) <= imageBitmap2.getHeight() && z2) {
                                borderCache = borderCache3;
                                objectRef = objectRef2;
                                canvas = canvas2;
                                imageBitmap = imageBitmap2;
                                canvasDrawScope = borderCache.canvasDrawScope;
                                if (canvasDrawScope == null) {
                                    canvasDrawScope = new CanvasDrawScope();
                                    borderCache.canvasDrawScope = canvasDrawScope;
                                }
                                CanvasDrawScope canvasDrawScope3 = canvasDrawScope;
                                long m8179toSizeozmzZPI = IntSizeKt.m8179toSizeozmzZPI(m8162constructorimpl);
                                LayoutDirection layoutDirection = cacheDrawScope.getLayoutDirection();
                                CanvasDrawScope.DrawParams drawParams = canvasDrawScope3.getDrawParams();
                                Density component1 = drawParams.component1();
                                LayoutDirection component2 = drawParams.component2();
                                Canvas component3 = drawParams.component3();
                                long m5776component4NHjbRc = drawParams.m5776component4NHjbRc();
                                CanvasDrawScope.DrawParams drawParams2 = canvasDrawScope3.getDrawParams();
                                drawParams2.setDensity(cacheDrawScope);
                                drawParams2.setLayoutDirection(layoutDirection);
                                drawParams2.setCanvas(canvas);
                                drawParams2.m5779setSizeuvyYCjk(m8179toSizeozmzZPI);
                                canvas.save();
                                canvasDrawScope2 = canvasDrawScope3;
                                DrawScope.m5853drawRectnJ9OG0$default(canvasDrawScope2, Color.Companion.m5306getBlack0d7_KjU(), 0L, m8179toSizeozmzZPI, 0.0f, null, null, BlendMode.Companion.m5194getClear0nO6VwU(), 58, null);
                                f2 = -rect.getLeft();
                                f3 = -rect.getTop();
                                canvasDrawScope2.getDrawContext().getTransform().translate(f2, f3);
                                ?? r24 = imageBitmap;
                                f4 = f3;
                                final ColorFilter colorFilter2 = colorFilter;
                                Canvas canvas3 = canvas;
                                DrawScope.m5848drawPathGBMwjPU$default(canvasDrawScope2, generic.getPath(), brush, 0.0f, new Stroke(f * 2, 0.0f, 0, 0, null, 30, null), null, 0, 52, null);
                                float f5 = 1;
                                float intBitsToFloat = (Float.intBitsToFloat((int) (canvasDrawScope2.mo5859getSizeNHjbRc() >> 32)) + f5) / Float.intBitsToFloat((int) (canvasDrawScope2.mo5859getSizeNHjbRc() >> 32));
                                float intBitsToFloat2 = (Float.intBitsToFloat((int) (canvasDrawScope2.mo5859getSizeNHjbRc() & 4294967295L)) + f5) / Float.intBitsToFloat((int) (canvasDrawScope2.mo5859getSizeNHjbRc() & 4294967295L));
                                long mo5858getCenterF1C5BW0 = canvasDrawScope2.mo5858getCenterF1C5BW0();
                                drawContext = canvasDrawScope2.getDrawContext();
                                mo5780getSizeNHjbRc = drawContext.mo5780getSizeNHjbRc();
                                drawContext.getCanvas().save();
                                drawContext.getTransform().mo5787scale0AR0LA0(intBitsToFloat, intBitsToFloat2, mo5858getCenterF1C5BW0);
                                final Ref.ObjectRef objectRef3 = objectRef;
                                j = mo5780getSizeNHjbRc;
                                DrawScope.m5848drawPathGBMwjPU$default(canvasDrawScope2, obtainPath, brush, 0.0f, null, null, BlendMode.Companion.m5194getClear0nO6VwU(), 28, null);
                                drawContext.getCanvas().restore();
                                drawContext.mo5781setSizeuvyYCjk(j);
                                canvasDrawScope2.getDrawContext().getTransform().translate(-f2, -f4);
                                canvas3.restore();
                                CanvasDrawScope.DrawParams drawParams3 = canvasDrawScope3.getDrawParams();
                                drawParams3.setDensity(component1);
                                drawParams3.setLayoutDirection(component2);
                                drawParams3.setCanvas(component3);
                                drawParams3.m5779setSizeuvyYCjk(m5776component4NHjbRc);
                                r24.prepareToDraw();
                                objectRef3.element = r24;
                                final Rect rect2 = rect;
                                return cacheDrawScope.onDrawWithContent(new Function1() { // from class: androidx.compose.foundation.BorderModifierNode$$ExternalSyntheticLambda3
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        Unit drawGenericBorder$lambda$8;
                                        drawGenericBorder$lambda$8 = BorderModifierNode.drawGenericBorder$lambda$8(Rect.this, objectRef3, m8162constructorimpl, colorFilter2, (ContentDrawScope) obj);
                                        return drawGenericBorder$lambda$8;
                                    }
                                });
                            }
                        }
                        DrawScope.m5848drawPathGBMwjPU$default(canvasDrawScope2, obtainPath, brush, 0.0f, null, null, BlendMode.Companion.m5194getClear0nO6VwU(), 28, null);
                        drawContext.getCanvas().restore();
                        drawContext.mo5781setSizeuvyYCjk(j);
                        canvasDrawScope2.getDrawContext().getTransform().translate(-f2, -f4);
                        canvas3.restore();
                        CanvasDrawScope.DrawParams drawParams32 = canvasDrawScope3.getDrawParams();
                        drawParams32.setDensity(component1);
                        drawParams32.setLayoutDirection(component2);
                        drawParams32.setCanvas(component3);
                        drawParams32.m5779setSizeuvyYCjk(m5776component4NHjbRc);
                        r24.prepareToDraw();
                        objectRef3.element = r24;
                        final Rect rect22 = rect;
                        return cacheDrawScope.onDrawWithContent(new Function1() { // from class: androidx.compose.foundation.BorderModifierNode$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                Unit drawGenericBorder$lambda$8;
                                drawGenericBorder$lambda$8 = BorderModifierNode.drawGenericBorder$lambda$8(Rect.this, objectRef3, m8162constructorimpl, colorFilter2, (ContentDrawScope) obj);
                                return drawGenericBorder$lambda$8;
                            }
                        });
                    } catch (Throwable th) {
                        th = th;
                        drawContext2 = drawContext;
                        drawContext2.getCanvas().restore();
                        drawContext2.mo5781setSizeuvyYCjk(j);
                        throw th;
                    }
                    drawContext.getTransform().mo5787scale0AR0LA0(intBitsToFloat, intBitsToFloat2, mo5858getCenterF1C5BW0);
                    final Ref.ObjectRef objectRef32 = objectRef;
                    j = mo5780getSizeNHjbRc;
                } catch (Throwable th2) {
                    th = th2;
                    drawContext2 = drawContext;
                    j = mo5780getSizeNHjbRc;
                }
                DrawScope.m5848drawPathGBMwjPU$default(canvasDrawScope2, generic.getPath(), brush, 0.0f, new Stroke(f * 2, 0.0f, 0, 0, null, 30, null), null, 0, 52, null);
                float f52 = 1;
                float intBitsToFloat3 = (Float.intBitsToFloat((int) (canvasDrawScope2.mo5859getSizeNHjbRc() >> 32)) + f52) / Float.intBitsToFloat((int) (canvasDrawScope2.mo5859getSizeNHjbRc() >> 32));
                float intBitsToFloat22 = (Float.intBitsToFloat((int) (canvasDrawScope2.mo5859getSizeNHjbRc() & 4294967295L)) + f52) / Float.intBitsToFloat((int) (canvasDrawScope2.mo5859getSizeNHjbRc() & 4294967295L));
                long mo5858getCenterF1C5BW02 = canvasDrawScope2.mo5858getCenterF1C5BW0();
                drawContext = canvasDrawScope2.getDrawContext();
                mo5780getSizeNHjbRc = drawContext.mo5780getSizeNHjbRc();
                drawContext.getCanvas().save();
            } catch (Throwable th3) {
                th = th3;
                canvasDrawScope2.getDrawContext().getTransform().translate(-f2, -f4);
                throw th;
            }
            ?? r242 = imageBitmap;
            f4 = f3;
            final ColorFilter colorFilter22 = colorFilter;
            Canvas canvas32 = canvas;
        } catch (Throwable th4) {
            th = th4;
            f4 = f3;
        }
        borderCache = borderCache3;
        objectRef = objectRef2;
        ImageBitmap m5517ImageBitmapx__hDU$default = ImageBitmapKt.m5517ImageBitmapx__hDU$default((int) (m8162constructorimpl >> 32), (int) (m8162constructorimpl & 4294967295L), i, false, null, 24, null);
        borderCache.imageBitmap = m5517ImageBitmapx__hDU$default;
        Canvas Canvas = androidx.compose.ui.graphics.CanvasKt.Canvas(m5517ImageBitmapx__hDU$default);
        borderCache.canvas = Canvas;
        imageBitmap = m5517ImageBitmapx__hDU$default;
        canvas = Canvas;
        canvasDrawScope = borderCache.canvasDrawScope;
        if (canvasDrawScope == null) {
        }
        CanvasDrawScope canvasDrawScope32 = canvasDrawScope;
        long m8179toSizeozmzZPI2 = IntSizeKt.m8179toSizeozmzZPI(m8162constructorimpl);
        LayoutDirection layoutDirection2 = cacheDrawScope.getLayoutDirection();
        CanvasDrawScope.DrawParams drawParams4 = canvasDrawScope32.getDrawParams();
        Density component12 = drawParams4.component1();
        LayoutDirection component22 = drawParams4.component2();
        Canvas component32 = drawParams4.component3();
        long m5776component4NHjbRc2 = drawParams4.m5776component4NHjbRc();
        CanvasDrawScope.DrawParams drawParams22 = canvasDrawScope32.getDrawParams();
        drawParams22.setDensity(cacheDrawScope);
        drawParams22.setLayoutDirection(layoutDirection2);
        drawParams22.setCanvas(canvas);
        drawParams22.m5779setSizeuvyYCjk(m8179toSizeozmzZPI2);
        canvas.save();
        canvasDrawScope2 = canvasDrawScope32;
        DrawScope.m5853drawRectnJ9OG0$default(canvasDrawScope2, Color.Companion.m5306getBlack0d7_KjU(), 0L, m8179toSizeozmzZPI2, 0.0f, null, null, BlendMode.Companion.m5194getClear0nO6VwU(), 58, null);
        f2 = -rect.getLeft();
        f3 = -rect.getTop();
        canvasDrawScope2.getDrawContext().getTransform().translate(f2, f3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit drawGenericBorder$lambda$1(Outline.Generic generic, Brush brush, ContentDrawScope contentDrawScope) {
        contentDrawScope.drawContent();
        DrawScope.m5848drawPathGBMwjPU$default(contentDrawScope, generic.getPath(), brush, 0.0f, null, null, 0, 60, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit drawGenericBorder$lambda$8(Rect rect, Ref.ObjectRef objectRef, long j, ColorFilter colorFilter, ContentDrawScope contentDrawScope) {
        float f;
        contentDrawScope.drawContent();
        ContentDrawScope contentDrawScope2 = contentDrawScope;
        float left = rect.getLeft();
        float top = rect.getTop();
        contentDrawScope2.getDrawContext().getTransform().translate(left, top);
        try {
        } catch (Throwable th) {
            th = th;
            f = top;
        }
        try {
            DrawScope.m5842drawImageAZ2fEMs$default(contentDrawScope2, (ImageBitmap) objectRef.element, 0L, j, 0L, 0L, 0.0f, null, colorFilter, 0, 0, 890, null);
            contentDrawScope2.getDrawContext().getTransform().translate(-left, -top);
            return Unit.INSTANCE;
        } catch (Throwable th2) {
            th = th2;
            left = left;
            f = top;
            contentDrawScope2.getDrawContext().getTransform().translate(-left, -f);
            throw th;
        }
    }

    /* renamed from: drawRoundRectBorder-JqoCqck  reason: not valid java name */
    private final DrawResult m288drawRoundRectBorderJqoCqck(CacheDrawScope cacheDrawScope, final Brush brush, Outline.Rounded rounded, final long j, final long j2, final boolean z, final float f) {
        final Path createRoundRectPath;
        if (RoundRectKt.isSimple(rounded.getRoundRect())) {
            final long m5086getTopLeftCornerRadiuskKHJgLs = rounded.getRoundRect().m5086getTopLeftCornerRadiuskKHJgLs();
            final float f2 = f / 2;
            final Stroke stroke = new Stroke(f, 0.0f, 0, 0, null, 30, null);
            return cacheDrawScope.onDrawWithContent(new Function1() { // from class: androidx.compose.foundation.BorderModifierNode$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit drawRoundRectBorder_JqoCqck$lambda$10;
                    drawRoundRectBorder_JqoCqck$lambda$10 = BorderModifierNode.drawRoundRectBorder_JqoCqck$lambda$10(z, brush, m5086getTopLeftCornerRadiuskKHJgLs, f2, f, j, j2, stroke, (ContentDrawScope) obj);
                    return drawRoundRectBorder_JqoCqck$lambda$10;
                }
            });
        }
        if (this.borderCache == null) {
            this.borderCache = new BorderCache(null, null, null, null, 15, null);
        }
        BorderCache borderCache = this.borderCache;
        Intrinsics.checkNotNull(borderCache);
        createRoundRectPath = BorderKt.createRoundRectPath(borderCache.obtainPath(), rounded.getRoundRect(), f, z);
        return cacheDrawScope.onDrawWithContent(new Function1() { // from class: androidx.compose.foundation.BorderModifierNode$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit drawRoundRectBorder_JqoCqck$lambda$11;
                drawRoundRectBorder_JqoCqck$lambda$11 = BorderModifierNode.drawRoundRectBorder_JqoCqck$lambda$11(Path.this, brush, (ContentDrawScope) obj);
                return drawRoundRectBorder_JqoCqck$lambda$11;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit drawRoundRectBorder_JqoCqck$lambda$10(boolean z, Brush brush, long j, float f, float f2, long j2, long j3, Stroke stroke, ContentDrawScope contentDrawScope) {
        long m284shrinkKibmq7A;
        contentDrawScope.drawContent();
        if (z) {
            DrawScope.m5854drawRoundRectZuiqVtQ$default(contentDrawScope, brush, 0L, 0L, j, 0.0f, null, null, 0, 246, null);
        } else if (Float.intBitsToFloat((int) (j >> 32)) >= f) {
            m284shrinkKibmq7A = BorderKt.m284shrinkKibmq7A(j, f);
            DrawScope.m5854drawRoundRectZuiqVtQ$default(contentDrawScope, brush, j2, j3, m284shrinkKibmq7A, 0.0f, stroke, null, 0, 208, null);
        } else {
            ContentDrawScope contentDrawScope2 = contentDrawScope;
            float intBitsToFloat = Float.intBitsToFloat((int) (contentDrawScope.mo5859getSizeNHjbRc() >> 32)) - f2;
            float intBitsToFloat2 = Float.intBitsToFloat((int) (contentDrawScope.mo5859getSizeNHjbRc() & 4294967295L)) - f2;
            int m5268getDifferencertfAjoo = ClipOp.Companion.m5268getDifferencertfAjoo();
            DrawContext drawContext = contentDrawScope2.getDrawContext();
            long mo5780getSizeNHjbRc = drawContext.mo5780getSizeNHjbRc();
            drawContext.getCanvas().save();
            try {
                drawContext.getTransform().mo5783clipRectN_I0leg(f2, f2, intBitsToFloat, intBitsToFloat2, m5268getDifferencertfAjoo);
                DrawScope.m5854drawRoundRectZuiqVtQ$default(contentDrawScope2, brush, 0L, 0L, j, 0.0f, null, null, 0, 246, null);
            } finally {
                drawContext.getCanvas().restore();
                drawContext.mo5781setSizeuvyYCjk(mo5780getSizeNHjbRc);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit drawRoundRectBorder_JqoCqck$lambda$11(Path path, Brush brush, ContentDrawScope contentDrawScope) {
        contentDrawScope.drawContent();
        DrawScope.m5848drawPathGBMwjPU$default(contentDrawScope, path, brush, 0.0f, null, null, 0, 60, null);
        return Unit.INSTANCE;
    }
}
