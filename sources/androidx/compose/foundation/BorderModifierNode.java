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
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ,\u0010\u001e\u001a\u00020\u001f*\u00020 2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0002JF\u0010'\u001a\u00020\u001f*\u00020 2\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010!\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&H\u0002ø\u0001\u0000¢\u0006\u0004\b-\u0010.R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R,\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003@FX\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006/"}, d2 = {"Landroidx/compose/foundation/BorderModifierNode;", "Landroidx/compose/ui/node/DelegatingNode;", "widthParameter", "Landroidx/compose/ui/unit/Dp;", "brushParameter", "Landroidx/compose/ui/graphics/Brush;", "shapeParameter", "Landroidx/compose/ui/graphics/Shape;", "(FLandroidx/compose/ui/graphics/Brush;Landroidx/compose/ui/graphics/Shape;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "borderCache", "Landroidx/compose/foundation/BorderCache;", "value", "brush", "getBrush", "()Landroidx/compose/ui/graphics/Brush;", "setBrush", "(Landroidx/compose/ui/graphics/Brush;)V", "drawWithCacheModifierNode", "Landroidx/compose/ui/draw/CacheDrawModifierNode;", "shape", "getShape", "()Landroidx/compose/ui/graphics/Shape;", "setShape", "(Landroidx/compose/ui/graphics/Shape;)V", "width", "getWidth-D9Ej5fM", "()F", "setWidth-0680j_4", "(F)V", "F", "drawGenericBorder", "Landroidx/compose/ui/draw/DrawResult;", "Landroidx/compose/ui/draw/CacheDrawScope;", "outline", "Landroidx/compose/ui/graphics/Outline$Generic;", "fillArea", "", "strokeWidth", "", "drawRoundRectBorder", "Landroidx/compose/ui/graphics/Outline$Rounded;", "topLeft", "Landroidx/compose/ui/geometry/Offset;", "borderSize", "Landroidx/compose/ui/geometry/Size;", "drawRoundRectBorder-JqoCqck", "(Landroidx/compose/ui/draw/CacheDrawScope;Landroidx/compose/ui/graphics/Brush;Landroidx/compose/ui/graphics/Outline$Rounded;JJZF)Landroidx/compose/ui/draw/DrawResult;", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class BorderModifierNode extends DelegatingNode {
    public static final int $stable = 8;
    private BorderCache borderCache;
    private Brush brush;
    private final CacheDrawModifierNode drawWithCacheModifierNode;
    private Shape shape;
    private float width;

    public /* synthetic */ BorderModifierNode(float f, Brush brush, Shape shape, DefaultConstructorMarker defaultConstructorMarker) {
        this(f, brush, shape);
    }

    private BorderModifierNode(float f, Brush brush, Shape shape) {
        this.width = f;
        this.brush = brush;
        this.shape = shape;
        this.drawWithCacheModifierNode = (CacheDrawModifierNode) delegate(DrawModifierKt.CacheDrawModifierNode(new Function1<CacheDrawScope, DrawResult>() { // from class: androidx.compose.foundation.BorderModifierNode$drawWithCacheModifierNode$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final DrawResult invoke(CacheDrawScope cacheDrawScope) {
                DrawResult drawContentWithoutBorder;
                DrawResult m261drawRectBorderNsqcLGU;
                DrawResult m264drawRoundRectBorderJqoCqck;
                DrawResult drawGenericBorder;
                if (cacheDrawScope.mo389toPx0680j_4(BorderModifierNode.this.m265getWidthD9Ej5fM()) < 0.0f || Size.m3905getMinDimensionimpl(cacheDrawScope.m3698getSizeNHjbRc()) <= 0.0f) {
                    drawContentWithoutBorder = BorderKt.drawContentWithoutBorder(cacheDrawScope);
                    return drawContentWithoutBorder;
                }
                float f2 = 2;
                float min = Math.min(Dp.m6689equalsimpl0(BorderModifierNode.this.m265getWidthD9Ej5fM(), Dp.Companion.m6702getHairlineD9Ej5fM()) ? 1.0f : (float) Math.ceil(cacheDrawScope.mo389toPx0680j_4(BorderModifierNode.this.m265getWidthD9Ej5fM())), (float) Math.ceil(Size.m3905getMinDimensionimpl(cacheDrawScope.m3698getSizeNHjbRc()) / f2));
                float f3 = min / f2;
                long m3829constructorimpl = Offset.m3829constructorimpl((Float.floatToRawIntBits(f3) << 32) | (Float.floatToRawIntBits(f3) & 4294967295L));
                long m3897constructorimpl = Size.m3897constructorimpl((Float.floatToRawIntBits(Float.intBitsToFloat((int) (cacheDrawScope.m3698getSizeNHjbRc() >> 32)) - min) << 32) | (4294967295L & Float.floatToRawIntBits(Float.intBitsToFloat((int) (cacheDrawScope.m3698getSizeNHjbRc() & 4294967295L)) - min)));
                boolean z = f2 * min > Size.m3905getMinDimensionimpl(cacheDrawScope.m3698getSizeNHjbRc());
                Outline mo303createOutlinePq9zytI = BorderModifierNode.this.getShape().mo303createOutlinePq9zytI(cacheDrawScope.m3698getSizeNHjbRc(), cacheDrawScope.getLayoutDirection(), cacheDrawScope);
                if (mo303createOutlinePq9zytI instanceof Outline.Generic) {
                    BorderModifierNode borderModifierNode = BorderModifierNode.this;
                    drawGenericBorder = borderModifierNode.drawGenericBorder(cacheDrawScope, borderModifierNode.getBrush(), (Outline.Generic) mo303createOutlinePq9zytI, z, min);
                    return drawGenericBorder;
                } else if (mo303createOutlinePq9zytI instanceof Outline.Rounded) {
                    BorderModifierNode borderModifierNode2 = BorderModifierNode.this;
                    m264drawRoundRectBorderJqoCqck = borderModifierNode2.m264drawRoundRectBorderJqoCqck(cacheDrawScope, borderModifierNode2.getBrush(), (Outline.Rounded) mo303createOutlinePq9zytI, m3829constructorimpl, m3897constructorimpl, z, min);
                    return m264drawRoundRectBorderJqoCqck;
                } else if (mo303createOutlinePq9zytI instanceof Outline.Rectangle) {
                    m261drawRectBorderNsqcLGU = BorderKt.m261drawRectBorderNsqcLGU(cacheDrawScope, BorderModifierNode.this.getBrush(), m3829constructorimpl, m3897constructorimpl, z, min);
                    return m261drawRectBorderNsqcLGU;
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            }
        }));
    }

    /* renamed from: getWidth-D9Ej5fM  reason: not valid java name */
    public final float m265getWidthD9Ej5fM() {
        return this.width;
    }

    /* renamed from: setWidth-0680j_4  reason: not valid java name */
    public final void m266setWidth0680j_4(float f) {
        if (Dp.m6689equalsimpl0(this.width, f)) {
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
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00fa, code lost:
        if (androidx.compose.ui.graphics.ImageBitmapConfig.m4293equalsimpl(r8, r7 != null ? androidx.compose.ui.graphics.ImageBitmapConfig.m4291boximpl(r7.mo3945getConfig_sVssgQ()) : null) != false) goto L64;
     */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0160  */
    /* JADX WARN: Type inference failed for: r24v3, types: [T, androidx.compose.ui.graphics.ImageBitmap] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final DrawResult drawGenericBorder(CacheDrawScope cacheDrawScope, final Brush brush, final Outline.Generic generic, boolean z, float f) {
        int m4299getArgb8888_sVssgQ;
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
        long mo4561getSizeNHjbRc;
        DrawContext drawContext2;
        long j;
        if (z) {
            return cacheDrawScope.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.foundation.BorderModifierNode$drawGenericBorder$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ContentDrawScope contentDrawScope) {
                    invoke2(contentDrawScope);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(ContentDrawScope contentDrawScope) {
                    contentDrawScope.drawContent();
                    DrawScope.m4629drawPathGBMwjPU$default(contentDrawScope, Outline.Generic.this.getPath(), brush, 0.0f, null, null, 0, 60, null);
                }
            });
        }
        if (brush instanceof SolidColor) {
            m4299getArgb8888_sVssgQ = ImageBitmapConfig.Companion.m4298getAlpha8_sVssgQ();
            colorFilter = ColorFilter.Companion.m4119tintxETnrds$default(ColorFilter.Companion, Color.m4077copywmQWz5c$default(((SolidColor) brush).m4414getValue0d7_KjU(), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), 0, 2, null);
        } else {
            m4299getArgb8888_sVssgQ = ImageBitmapConfig.Companion.m4299getArgb8888_sVssgQ();
            colorFilter = null;
        }
        int i = m4299getArgb8888_sVssgQ;
        Rect bounds = generic.getPath().getBounds();
        if (this.borderCache == null) {
            this.borderCache = new BorderCache(null, null, null, null, 15, null);
        }
        BorderCache borderCache2 = this.borderCache;
        Intrinsics.checkNotNull(borderCache2);
        Path obtainPath = borderCache2.obtainPath();
        obtainPath.reset();
        Path.addRect$default(obtainPath, bounds, null, 2, null);
        obtainPath.mo3970opN5in7k0(obtainPath, generic.getPath(), PathOperation.Companion.m4371getDifferenceb3I0S0c());
        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        final long m6850constructorimpl = IntSize.m6850constructorimpl((((int) Math.ceil(bounds.getBottom() - bounds.getTop())) & 4294967295L) | (((int) Math.ceil(bounds.getRight() - bounds.getLeft())) << 32));
        BorderCache borderCache3 = this.borderCache;
        Intrinsics.checkNotNull(borderCache3);
        ImageBitmap imageBitmap2 = borderCache3.imageBitmap;
        Canvas canvas2 = borderCache3.canvas;
        ImageBitmapConfig m4291boximpl = imageBitmap2 != null ? ImageBitmapConfig.m4291boximpl(imageBitmap2.mo3945getConfig_sVssgQ()) : null;
        boolean z2 = false;
        if (!(m4291boximpl == null ? false : ImageBitmapConfig.m4294equalsimpl0(m4291boximpl.m4297unboximpl(), ImageBitmapConfig.Companion.m4299getArgb8888_sVssgQ()))) {
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
                            if (Float.intBitsToFloat((int) (cacheDrawScope.m3698getSizeNHjbRc() >> 32)) <= imageBitmap2.getWidth() && Float.intBitsToFloat((int) (cacheDrawScope.m3698getSizeNHjbRc() & 4294967295L)) <= imageBitmap2.getHeight() && z2) {
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
                                long m6867toSizeozmzZPI = IntSizeKt.m6867toSizeozmzZPI(m6850constructorimpl);
                                LayoutDirection layoutDirection = cacheDrawScope.getLayoutDirection();
                                CanvasDrawScope.DrawParams drawParams = canvasDrawScope3.getDrawParams();
                                Density component1 = drawParams.component1();
                                LayoutDirection component2 = drawParams.component2();
                                Canvas component3 = drawParams.component3();
                                long m4557component4NHjbRc = drawParams.m4557component4NHjbRc();
                                CanvasDrawScope.DrawParams drawParams2 = canvasDrawScope3.getDrawParams();
                                drawParams2.setDensity(cacheDrawScope);
                                drawParams2.setLayoutDirection(layoutDirection);
                                drawParams2.setCanvas(canvas);
                                drawParams2.m4560setSizeuvyYCjk(m6867toSizeozmzZPI);
                                canvas.save();
                                canvasDrawScope2 = canvasDrawScope3;
                                DrawScope.m4634drawRectnJ9OG0$default(canvasDrawScope2, Color.Companion.m4104getBlack0d7_KjU(), 0L, m6867toSizeozmzZPI, 0.0f, null, null, BlendMode.Companion.m3993getClear0nO6VwU(), 58, null);
                                f2 = -rect.getLeft();
                                f3 = -rect.getTop();
                                canvasDrawScope2.getDrawContext().getTransform().translate(f2, f3);
                                ?? r24 = imageBitmap;
                                f4 = f3;
                                final ColorFilter colorFilter2 = colorFilter;
                                Canvas canvas3 = canvas;
                                DrawScope.m4629drawPathGBMwjPU$default(canvasDrawScope2, generic.getPath(), brush, 0.0f, new Stroke(f * 2, 0.0f, 0, 0, null, 30, null), null, 0, 52, null);
                                float f5 = 1;
                                float intBitsToFloat = (Float.intBitsToFloat((int) (canvasDrawScope2.mo4640getSizeNHjbRc() >> 32)) + f5) / Float.intBitsToFloat((int) (canvasDrawScope2.mo4640getSizeNHjbRc() >> 32));
                                float intBitsToFloat2 = (Float.intBitsToFloat((int) (canvasDrawScope2.mo4640getSizeNHjbRc() & 4294967295L)) + f5) / Float.intBitsToFloat((int) (canvasDrawScope2.mo4640getSizeNHjbRc() & 4294967295L));
                                long mo4639getCenterF1C5BW0 = canvasDrawScope2.mo4639getCenterF1C5BW0();
                                drawContext = canvasDrawScope2.getDrawContext();
                                mo4561getSizeNHjbRc = drawContext.mo4561getSizeNHjbRc();
                                drawContext.getCanvas().save();
                                drawContext.getTransform().mo4568scale0AR0LA0(intBitsToFloat, intBitsToFloat2, mo4639getCenterF1C5BW0);
                                final Ref.ObjectRef objectRef3 = objectRef;
                                j = mo4561getSizeNHjbRc;
                                DrawScope.m4629drawPathGBMwjPU$default(canvasDrawScope2, obtainPath, brush, 0.0f, null, null, BlendMode.Companion.m3993getClear0nO6VwU(), 28, null);
                                drawContext.getCanvas().restore();
                                drawContext.mo4562setSizeuvyYCjk(j);
                                canvasDrawScope2.getDrawContext().getTransform().translate(-f2, -f4);
                                canvas3.restore();
                                CanvasDrawScope.DrawParams drawParams3 = canvasDrawScope3.getDrawParams();
                                drawParams3.setDensity(component1);
                                drawParams3.setLayoutDirection(component2);
                                drawParams3.setCanvas(component3);
                                drawParams3.m4560setSizeuvyYCjk(m4557component4NHjbRc);
                                r24.prepareToDraw();
                                objectRef3.element = r24;
                                final Rect rect2 = rect;
                                return cacheDrawScope.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.foundation.BorderModifierNode$drawGenericBorder$3
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(ContentDrawScope contentDrawScope) {
                                        invoke2(contentDrawScope);
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                                    public final void invoke2(ContentDrawScope contentDrawScope) {
                                        float f6;
                                        float f7;
                                        contentDrawScope.drawContent();
                                        ContentDrawScope contentDrawScope2 = contentDrawScope;
                                        float left = Rect.this.getLeft();
                                        float top = Rect.this.getTop();
                                        Ref.ObjectRef<ImageBitmap> objectRef4 = objectRef3;
                                        long j2 = m6850constructorimpl;
                                        ColorFilter colorFilter3 = colorFilter2;
                                        contentDrawScope2.getDrawContext().getTransform().translate(left, top);
                                        try {
                                            f6 = left;
                                            try {
                                                DrawScope.m4623drawImageAZ2fEMs$default(contentDrawScope2, objectRef4.element, 0L, j2, 0L, 0L, 0.0f, null, colorFilter3, 0, 0, 890, null);
                                                contentDrawScope2.getDrawContext().getTransform().translate(-f6, -top);
                                            } catch (Throwable th) {
                                                th = th;
                                                f7 = top;
                                                contentDrawScope2.getDrawContext().getTransform().translate(-f6, -f7);
                                                throw th;
                                            }
                                        } catch (Throwable th2) {
                                            th = th2;
                                            f6 = left;
                                            f7 = top;
                                        }
                                    }
                                });
                            }
                        }
                        DrawScope.m4629drawPathGBMwjPU$default(canvasDrawScope2, obtainPath, brush, 0.0f, null, null, BlendMode.Companion.m3993getClear0nO6VwU(), 28, null);
                        drawContext.getCanvas().restore();
                        drawContext.mo4562setSizeuvyYCjk(j);
                        canvasDrawScope2.getDrawContext().getTransform().translate(-f2, -f4);
                        canvas3.restore();
                        CanvasDrawScope.DrawParams drawParams32 = canvasDrawScope3.getDrawParams();
                        drawParams32.setDensity(component1);
                        drawParams32.setLayoutDirection(component2);
                        drawParams32.setCanvas(component3);
                        drawParams32.m4560setSizeuvyYCjk(m4557component4NHjbRc);
                        r24.prepareToDraw();
                        objectRef3.element = r24;
                        final Rect rect22 = rect;
                        return cacheDrawScope.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.foundation.BorderModifierNode$drawGenericBorder$3
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(ContentDrawScope contentDrawScope) {
                                invoke2(contentDrawScope);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke  reason: avoid collision after fix types in other method */
                            public final void invoke2(ContentDrawScope contentDrawScope) {
                                float f6;
                                float f7;
                                contentDrawScope.drawContent();
                                ContentDrawScope contentDrawScope2 = contentDrawScope;
                                float left = Rect.this.getLeft();
                                float top = Rect.this.getTop();
                                Ref.ObjectRef<ImageBitmap> objectRef4 = objectRef3;
                                long j2 = m6850constructorimpl;
                                ColorFilter colorFilter3 = colorFilter2;
                                contentDrawScope2.getDrawContext().getTransform().translate(left, top);
                                try {
                                    f6 = left;
                                    try {
                                        DrawScope.m4623drawImageAZ2fEMs$default(contentDrawScope2, objectRef4.element, 0L, j2, 0L, 0L, 0.0f, null, colorFilter3, 0, 0, 890, null);
                                        contentDrawScope2.getDrawContext().getTransform().translate(-f6, -top);
                                    } catch (Throwable th) {
                                        th = th;
                                        f7 = top;
                                        contentDrawScope2.getDrawContext().getTransform().translate(-f6, -f7);
                                        throw th;
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    f6 = left;
                                    f7 = top;
                                }
                            }
                        });
                    } catch (Throwable th) {
                        th = th;
                        drawContext2 = drawContext;
                        drawContext2.getCanvas().restore();
                        drawContext2.mo4562setSizeuvyYCjk(j);
                        throw th;
                    }
                    drawContext.getTransform().mo4568scale0AR0LA0(intBitsToFloat, intBitsToFloat2, mo4639getCenterF1C5BW0);
                    final Ref.ObjectRef<ImageBitmap> objectRef32 = objectRef;
                    j = mo4561getSizeNHjbRc;
                } catch (Throwable th2) {
                    th = th2;
                    drawContext2 = drawContext;
                    j = mo4561getSizeNHjbRc;
                }
                DrawScope.m4629drawPathGBMwjPU$default(canvasDrawScope2, generic.getPath(), brush, 0.0f, new Stroke(f * 2, 0.0f, 0, 0, null, 30, null), null, 0, 52, null);
                float f52 = 1;
                float intBitsToFloat3 = (Float.intBitsToFloat((int) (canvasDrawScope2.mo4640getSizeNHjbRc() >> 32)) + f52) / Float.intBitsToFloat((int) (canvasDrawScope2.mo4640getSizeNHjbRc() >> 32));
                float intBitsToFloat22 = (Float.intBitsToFloat((int) (canvasDrawScope2.mo4640getSizeNHjbRc() & 4294967295L)) + f52) / Float.intBitsToFloat((int) (canvasDrawScope2.mo4640getSizeNHjbRc() & 4294967295L));
                long mo4639getCenterF1C5BW02 = canvasDrawScope2.mo4639getCenterF1C5BW0();
                drawContext = canvasDrawScope2.getDrawContext();
                mo4561getSizeNHjbRc = drawContext.mo4561getSizeNHjbRc();
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
        ImageBitmap m4304ImageBitmapx__hDU$default = ImageBitmapKt.m4304ImageBitmapx__hDU$default((int) (m6850constructorimpl >> 32), (int) (m6850constructorimpl & 4294967295L), i, false, null, 24, null);
        borderCache.imageBitmap = m4304ImageBitmapx__hDU$default;
        Canvas Canvas = androidx.compose.ui.graphics.CanvasKt.Canvas(m4304ImageBitmapx__hDU$default);
        borderCache.canvas = Canvas;
        imageBitmap = m4304ImageBitmapx__hDU$default;
        canvas = Canvas;
        canvasDrawScope = borderCache.canvasDrawScope;
        if (canvasDrawScope == null) {
        }
        CanvasDrawScope canvasDrawScope32 = canvasDrawScope;
        long m6867toSizeozmzZPI2 = IntSizeKt.m6867toSizeozmzZPI(m6850constructorimpl);
        LayoutDirection layoutDirection2 = cacheDrawScope.getLayoutDirection();
        CanvasDrawScope.DrawParams drawParams4 = canvasDrawScope32.getDrawParams();
        Density component12 = drawParams4.component1();
        LayoutDirection component22 = drawParams4.component2();
        Canvas component32 = drawParams4.component3();
        long m4557component4NHjbRc2 = drawParams4.m4557component4NHjbRc();
        CanvasDrawScope.DrawParams drawParams22 = canvasDrawScope32.getDrawParams();
        drawParams22.setDensity(cacheDrawScope);
        drawParams22.setLayoutDirection(layoutDirection2);
        drawParams22.setCanvas(canvas);
        drawParams22.m4560setSizeuvyYCjk(m6867toSizeozmzZPI2);
        canvas.save();
        canvasDrawScope2 = canvasDrawScope32;
        DrawScope.m4634drawRectnJ9OG0$default(canvasDrawScope2, Color.Companion.m4104getBlack0d7_KjU(), 0L, m6867toSizeozmzZPI2, 0.0f, null, null, BlendMode.Companion.m3993getClear0nO6VwU(), 58, null);
        f2 = -rect.getLeft();
        f3 = -rect.getTop();
        canvasDrawScope2.getDrawContext().getTransform().translate(f2, f3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: drawRoundRectBorder-JqoCqck  reason: not valid java name */
    public final DrawResult m264drawRoundRectBorderJqoCqck(CacheDrawScope cacheDrawScope, final Brush brush, Outline.Rounded rounded, final long j, final long j2, final boolean z, final float f) {
        final Path createRoundRectPath;
        if (RoundRectKt.isSimple(rounded.getRoundRect())) {
            final long m3887getTopLeftCornerRadiuskKHJgLs = rounded.getRoundRect().m3887getTopLeftCornerRadiuskKHJgLs();
            final float f2 = f / 2;
            final Stroke stroke = new Stroke(f, 0.0f, 0, 0, null, 30, null);
            return cacheDrawScope.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.foundation.BorderModifierNode$drawRoundRectBorder$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ContentDrawScope contentDrawScope) {
                    invoke2(contentDrawScope);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(ContentDrawScope contentDrawScope) {
                    long m262shrinkKibmq7A;
                    DrawContext drawContext;
                    long j3;
                    contentDrawScope.drawContent();
                    if (z) {
                        DrawScope.m4635drawRoundRectZuiqVtQ$default(contentDrawScope, brush, 0L, 0L, m3887getTopLeftCornerRadiuskKHJgLs, 0.0f, null, null, 0, 246, null);
                        return;
                    }
                    float intBitsToFloat = Float.intBitsToFloat((int) (m3887getTopLeftCornerRadiuskKHJgLs >> 32));
                    float f3 = f2;
                    if (intBitsToFloat < f3) {
                        ContentDrawScope contentDrawScope2 = contentDrawScope;
                        float f4 = f;
                        float intBitsToFloat2 = Float.intBitsToFloat((int) (contentDrawScope.mo4640getSizeNHjbRc() >> 32)) - f;
                        float intBitsToFloat3 = Float.intBitsToFloat((int) (contentDrawScope.mo4640getSizeNHjbRc() & 4294967295L)) - f;
                        int m4066getDifferencertfAjoo = ClipOp.Companion.m4066getDifferencertfAjoo();
                        Brush brush2 = brush;
                        long j4 = m3887getTopLeftCornerRadiuskKHJgLs;
                        DrawContext drawContext2 = contentDrawScope2.getDrawContext();
                        long mo4561getSizeNHjbRc = drawContext2.mo4561getSizeNHjbRc();
                        drawContext2.getCanvas().save();
                        try {
                            drawContext2.getTransform().mo4564clipRectN_I0leg(f4, f4, intBitsToFloat2, intBitsToFloat3, m4066getDifferencertfAjoo);
                            drawContext = drawContext2;
                            try {
                                DrawScope.m4635drawRoundRectZuiqVtQ$default(contentDrawScope2, brush2, 0L, 0L, j4, 0.0f, null, null, 0, 246, null);
                                drawContext.getCanvas().restore();
                                drawContext.mo4562setSizeuvyYCjk(mo4561getSizeNHjbRc);
                            } catch (Throwable th) {
                                th = th;
                                j3 = mo4561getSizeNHjbRc;
                                drawContext.getCanvas().restore();
                                drawContext.mo4562setSizeuvyYCjk(j3);
                                throw th;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            drawContext = drawContext2;
                            j3 = mo4561getSizeNHjbRc;
                        }
                    } else {
                        Brush brush3 = brush;
                        long j5 = j;
                        long j6 = j2;
                        m262shrinkKibmq7A = BorderKt.m262shrinkKibmq7A(m3887getTopLeftCornerRadiuskKHJgLs, f3);
                        DrawScope.m4635drawRoundRectZuiqVtQ$default(contentDrawScope, brush3, j5, j6, m262shrinkKibmq7A, 0.0f, stroke, null, 0, 208, null);
                    }
                }
            });
        }
        if (this.borderCache == null) {
            this.borderCache = new BorderCache(null, null, null, null, 15, null);
        }
        BorderCache borderCache = this.borderCache;
        Intrinsics.checkNotNull(borderCache);
        createRoundRectPath = BorderKt.createRoundRectPath(borderCache.obtainPath(), rounded.getRoundRect(), f, z);
        return cacheDrawScope.onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.foundation.BorderModifierNode$drawRoundRectBorder$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ContentDrawScope contentDrawScope) {
                invoke2(contentDrawScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(ContentDrawScope contentDrawScope) {
                contentDrawScope.drawContent();
                DrawScope.m4629drawPathGBMwjPU$default(contentDrawScope, Path.this, brush, 0.0f, null, null, 0, 60, null);
            }
        });
    }
}
