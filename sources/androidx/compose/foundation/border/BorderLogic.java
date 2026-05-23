package androidx.compose.foundation.border;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRect;
import androidx.compose.ui.geometry.RoundRectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.Outline;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathOperation;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Fill;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.graphics.layer.CompositingStrategy;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.graphics.layer.GraphicsLayerKt;
import androidx.compose.ui.unit.IntSize;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
/* compiled from: BorderLogic.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003JM\u0010\r\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u000f2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0014\u001a\u00020\n2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u00072\u0006\u0010\u0017\u001a\u00020\f2\b\b\u0002\u0010\u0018\u001a\u00020\u0019H\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\t\u0010\u001c\u001a\u00020\bH\u0082\bJ7\u0010\u001d\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\u0002\b\u00112\u0006\u0010\u0014\u001a\u00020\n2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u00072\u0006\u0010\u0017\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u0005H\u0002J)\u0010 \u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\u0002\b\u00112\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020!H\u0002J)\u0010\"\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00100\u000e¢\u0006\u0002\b\u00112\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020#H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R!\u0010\r\u001a\u0015\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000e¢\u0006\u0002\b\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Landroidx/compose/foundation/border/BorderLogic;", "", "<init>", "()V", "borderPath", "Landroidx/compose/ui/graphics/Path;", "borderWidth", "Lkotlin/Function0;", "", "lastBrush", "Landroidx/compose/ui/graphics/Brush;", "lastOutline", "Landroidx/compose/ui/graphics/Outline;", "drawBorder", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "", "Lkotlin/ExtensionFunctionType;", "drawScope", "width", "brush", "graphicsLayerProvider", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "outline", TypedValues.CycleType.S_WAVE_OFFSET, "Landroidx/compose/ui/geometry/Offset;", "drawBorder-2gY9BTk$foundation", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/graphics/Brush;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/graphics/Outline;J)V", "strokeWidthPx", "createDrawGenericBorder", "Landroidx/compose/ui/graphics/Outline$Generic;", "obtainPath", "createDrawRoundRectBorder", "Landroidx/compose/ui/graphics/Outline$Rounded;", "createDrawRectBorder", "Landroidx/compose/ui/graphics/Outline$Rectangle;", "foundation"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class BorderLogic {
    public static final int $stable = 8;
    private Path borderPath;
    private Function0<Float> borderWidth;
    private Function1<? super DrawScope, Unit> drawBorder;
    private Brush lastBrush;
    private Outline lastOutline;

    /* renamed from: drawBorder-2gY9BTk$foundation */
    public final void m380drawBorder2gY9BTk$foundation(DrawScope drawScope, Function0<Float> function0, Brush brush, Function0<GraphicsLayer> function02, Outline outline, long j) {
        Function1<DrawScope, Unit> createDrawRectBorder;
        this.borderWidth = function0;
        if (!Intrinsics.areEqual(brush, this.lastBrush) || !Intrinsics.areEqual(outline, this.lastOutline) || this.drawBorder == null) {
            this.lastBrush = brush;
            this.lastOutline = outline;
            if (outline instanceof Outline.Generic) {
                createDrawRectBorder = createDrawGenericBorder(brush, function02, (Outline.Generic) outline);
            } else if (outline instanceof Outline.Rounded) {
                createDrawRectBorder = createDrawRoundRectBorder(brush, (Outline.Rounded) outline);
            } else if (!(outline instanceof Outline.Rectangle)) {
                throw new NoWhenBranchMatchedException();
            } else {
                createDrawRectBorder = createDrawRectBorder(brush, (Outline.Rectangle) outline);
            }
            this.drawBorder = createDrawRectBorder;
        }
        if (Offset.m5100equalsimpl0(j, Offset.Companion.m5119getZeroF1C5BW0())) {
            Function1<? super DrawScope, Unit> function1 = this.drawBorder;
            Intrinsics.checkNotNull(function1);
            function1.invoke(drawScope);
            return;
        }
        float intBitsToFloat = Float.intBitsToFloat((int) (j >> 32));
        float intBitsToFloat2 = Float.intBitsToFloat((int) (4294967295L & j));
        drawScope.getDrawContext().getTransform().translate(intBitsToFloat, intBitsToFloat2);
        try {
            Function1<? super DrawScope, Unit> function12 = this.drawBorder;
            Intrinsics.checkNotNull(function12);
            function12.invoke(drawScope);
        } finally {
            drawScope.getDrawContext().getTransform().translate(-intBitsToFloat, -intBitsToFloat2);
        }
    }

    private final float strokeWidthPx() {
        Function0<Float> function0 = this.borderWidth;
        Intrinsics.checkNotNull(function0);
        return RangesKt.coerceAtLeast(function0.invoke().floatValue(), 0.0f);
    }

    private final Function1<DrawScope, Unit> createDrawGenericBorder(final Brush brush, final Function0<GraphicsLayer> function0, final Outline.Generic generic) {
        final Rect bounds = generic.getPath().getBounds();
        final float minDimension = bounds.getMinDimension();
        final Path obtainPath = obtainPath();
        obtainPath.reset();
        Path.addRect$default(obtainPath, bounds, null, 2, null);
        obtainPath.mo5237opN5in7k0(obtainPath, generic.getPath(), PathOperation.Companion.m5654getDifferenceb3I0S0c());
        final long m8326constructorimpl = IntSize.m8326constructorimpl((((int) Math.ceil(bounds.getBottom() - bounds.getTop())) & 4294967295L) | (((int) Math.ceil(bounds.getRight() - bounds.getLeft())) << 32));
        return new Function1() { // from class: androidx.compose.foundation.border.BorderLogic$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BorderLogic.createDrawGenericBorder$lambda$1(BorderLogic.this, minDimension, generic, brush, function0, bounds, m8326constructorimpl, obtainPath, (DrawScope) obj);
            }
        };
    }

    public static final Unit createDrawGenericBorder$lambda$1$0$0(Rect rect, Outline.Generic generic, Brush brush, float f, Path path, DrawScope drawScope) {
        float f2 = -rect.getLeft();
        float f3 = -rect.getTop();
        drawScope.getDrawContext().getTransform().translate(f2, f3);
        try {
            DrawScope.m5911drawPathGBMwjPU$default(drawScope, generic.getPath(), brush, 0.0f, new Stroke(f * 2.0f, 0.0f, 0, 0, null, 30, null), null, 0, 52, null);
            float intBitsToFloat = (Float.intBitsToFloat((int) (drawScope.mo5922getSizeNHjbRc() >> 32)) + 1.0f) / Float.intBitsToFloat((int) (drawScope.mo5922getSizeNHjbRc() >> 32));
            float intBitsToFloat2 = (Float.intBitsToFloat((int) (drawScope.mo5922getSizeNHjbRc() & 4294967295L)) + 1.0f) / Float.intBitsToFloat((int) (drawScope.mo5922getSizeNHjbRc() & 4294967295L));
            long mo5921getCenterF1C5BW0 = drawScope.mo5921getCenterF1C5BW0();
            DrawContext drawContext = drawScope.getDrawContext();
            long mo5843getSizeNHjbRc = drawContext.mo5843getSizeNHjbRc();
            drawContext.getCanvas().save();
            drawContext.getTransform().mo5850scale0AR0LA0(intBitsToFloat, intBitsToFloat2, mo5921getCenterF1C5BW0);
            DrawScope.m5911drawPathGBMwjPU$default(drawScope, path, brush, 0.0f, null, null, BlendMode.Companion.m5261getClear0nO6VwU(), 28, null);
            drawContext.getCanvas().restore();
            drawContext.mo5844setSizeuvyYCjk(mo5843getSizeNHjbRc);
            drawScope.getDrawContext().getTransform().translate(-f2, -f3);
            return Unit.INSTANCE;
        } catch (Throwable th) {
            drawScope.getDrawContext().getTransform().translate(-f2, -f3);
            throw th;
        }
    }

    private final Path obtainPath() {
        Path path = this.borderPath;
        if (path == null) {
            Path Path = AndroidPath_androidKt.Path();
            this.borderPath = Path;
            return Path;
        }
        return path;
    }

    private final Function1<DrawScope, Unit> createDrawRoundRectBorder(final Brush brush, Outline.Rounded rounded) {
        final RoundRect roundRect = rounded.getRoundRect();
        if (RoundRectKt.isSimple(roundRect)) {
            return new Function1() { // from class: androidx.compose.foundation.border.BorderLogic$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return BorderLogic.createDrawRoundRectBorder$lambda$0(BorderLogic.this, roundRect, brush, (DrawScope) obj);
                }
            };
        }
        final Path obtainPath = obtainPath();
        final Ref.FloatRef floatRef = new Ref.FloatRef();
        floatRef.element = Float.NaN;
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        return new Function1() { // from class: androidx.compose.foundation.border.BorderLogic$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BorderLogic.createDrawRoundRectBorder$lambda$1(BorderLogic.this, roundRect, floatRef, objectRef, obtainPath, brush, (DrawScope) obj);
            }
        };
    }

    private final Function1<DrawScope, Unit> createDrawRectBorder(final Brush brush, Outline.Rectangle rectangle) {
        final Rect rect = rectangle.getRect();
        return new Function1() { // from class: androidx.compose.foundation.border.BorderLogic$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BorderLogic.createDrawRectBorder$lambda$0(BorderLogic.this, rect, brush, (DrawScope) obj);
            }
        };
    }

    public static final Unit createDrawGenericBorder$lambda$1(BorderLogic borderLogic, float f, final Outline.Generic generic, final Brush brush, Function0 function0, final Rect rect, long j, final Path path, DrawScope drawScope) {
        Function0<Float> function02 = borderLogic.borderWidth;
        Intrinsics.checkNotNull(function02);
        final float coerceAtLeast = RangesKt.coerceAtLeast(function02.invoke().floatValue(), 0.0f);
        if (2.0f * coerceAtLeast > f) {
            DrawScope.m5911drawPathGBMwjPU$default(drawScope, generic.getPath(), brush, 0.0f, null, null, 0, 60, null);
        } else {
            GraphicsLayer graphicsLayer = (GraphicsLayer) function0.invoke();
            graphicsLayer.m6019setCompositingStrategyWpw9cng(CompositingStrategy.Companion.m6004getOffscreenke2Ky5w());
            float left = rect.getLeft();
            float top = rect.getTop();
            drawScope.getDrawContext().getTransform().translate(left, top);
            try {
                drawScope.mo5923recordJVtK1S4(graphicsLayer, j, new Function1() { // from class: androidx.compose.foundation.border.BorderLogic$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit createDrawGenericBorder$lambda$1$0$0;
                        createDrawGenericBorder$lambda$1$0$0 = BorderLogic.createDrawGenericBorder$lambda$1$0$0(Rect.this, generic, brush, coerceAtLeast, path, (DrawScope) obj);
                        return createDrawGenericBorder$lambda$1$0$0;
                    }
                });
                GraphicsLayerKt.drawLayer(drawScope, graphicsLayer);
            } finally {
                drawScope.getDrawContext().getTransform().translate(-left, -top);
            }
        }
        return Unit.INSTANCE;
    }

    public static final Unit createDrawRoundRectBorder$lambda$0(BorderLogic borderLogic, RoundRect roundRect, Brush brush, DrawScope drawScope) {
        long m382shrinkKibmq7A;
        Function0<Float> function0 = borderLogic.borderWidth;
        Intrinsics.checkNotNull(function0);
        float coerceAtLeast = RangesKt.coerceAtLeast(function0.invoke().floatValue(), 0.0f);
        float f = coerceAtLeast / 2.0f;
        boolean z = 2.0f * coerceAtLeast > RoundRectKt.getMinDimension(roundRect);
        long m5153getTopLeftCornerRadiuskKHJgLs = roundRect.m5153getTopLeftCornerRadiuskKHJgLs();
        Stroke stroke = new Stroke(coerceAtLeast, 0.0f, 0, 0, null, 30, null);
        if (z) {
            float left = roundRect.getLeft();
            long m5095constructorimpl = Offset.m5095constructorimpl((Float.floatToRawIntBits(roundRect.getTop()) & 4294967295L) | (Float.floatToRawIntBits(left) << 32));
            float width = roundRect.getWidth();
            DrawScope.m5917drawRoundRectZuiqVtQ$default(drawScope, brush, m5095constructorimpl, Size.m5163constructorimpl((Float.floatToRawIntBits(roundRect.getHeight()) & 4294967295L) | (Float.floatToRawIntBits(width) << 32)), m5153getTopLeftCornerRadiuskKHJgLs, 0.0f, null, null, 0, 240, null);
        } else if (Float.intBitsToFloat((int) (m5153getTopLeftCornerRadiuskKHJgLs >> 32)) < f) {
            float left2 = roundRect.getLeft() + coerceAtLeast;
            float top = roundRect.getTop() + coerceAtLeast;
            float right = roundRect.getRight() - coerceAtLeast;
            float bottom = roundRect.getBottom() - coerceAtLeast;
            int m5336getDifferencertfAjoo = ClipOp.Companion.m5336getDifferencertfAjoo();
            DrawContext drawContext = drawScope.getDrawContext();
            long mo5843getSizeNHjbRc = drawContext.mo5843getSizeNHjbRc();
            drawContext.getCanvas().save();
            try {
                drawContext.getTransform().mo5846clipRectN_I0leg(left2, top, right, bottom, m5336getDifferencertfAjoo);
                long m5095constructorimpl2 = Offset.m5095constructorimpl((Float.floatToRawIntBits(roundRect.getLeft()) << 32) | (Float.floatToRawIntBits(roundRect.getTop()) & 4294967295L));
                float width2 = roundRect.getWidth();
                DrawScope.m5917drawRoundRectZuiqVtQ$default(drawScope, brush, m5095constructorimpl2, Size.m5163constructorimpl((4294967295L & Float.floatToRawIntBits(roundRect.getHeight())) | (Float.floatToRawIntBits(width2) << 32)), m5153getTopLeftCornerRadiuskKHJgLs, 0.0f, null, null, 0, 240, null);
            } finally {
                drawContext.getCanvas().restore();
                drawContext.mo5844setSizeuvyYCjk(mo5843getSizeNHjbRc);
            }
        } else {
            long m5095constructorimpl3 = Offset.m5095constructorimpl((Float.floatToRawIntBits(roundRect.getLeft() + f) << 32) | (Float.floatToRawIntBits(roundRect.getTop() + f) & 4294967295L));
            long m5163constructorimpl = Size.m5163constructorimpl((Float.floatToRawIntBits(roundRect.getHeight() - coerceAtLeast) & 4294967295L) | (Float.floatToRawIntBits(roundRect.getWidth() - coerceAtLeast) << 32));
            m382shrinkKibmq7A = BorderLogicKt.m382shrinkKibmq7A(m5153getTopLeftCornerRadiuskKHJgLs, f);
            DrawScope.m5917drawRoundRectZuiqVtQ$default(drawScope, brush, m5095constructorimpl3, m5163constructorimpl, m382shrinkKibmq7A, 0.0f, stroke, null, 0, 208, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Type inference failed for: r10v1, types: [T, androidx.compose.ui.graphics.Path] */
    public static final Unit createDrawRoundRectBorder$lambda$1(BorderLogic borderLogic, RoundRect roundRect, Ref.FloatRef floatRef, Ref.ObjectRef objectRef, Path path, Brush brush, DrawScope drawScope) {
        ?? createRoundRectPath;
        Function0<Float> function0 = borderLogic.borderWidth;
        Intrinsics.checkNotNull(function0);
        float coerceAtLeast = RangesKt.coerceAtLeast(function0.invoke().floatValue(), 0.0f);
        boolean z = 2.0f * coerceAtLeast > RoundRectKt.getMinDimension(roundRect);
        if (floatRef.element != coerceAtLeast) {
            createRoundRectPath = BorderLogicKt.createRoundRectPath(path, roundRect, coerceAtLeast, z);
            objectRef.element = createRoundRectPath;
            floatRef.element = coerceAtLeast;
        }
        T t = objectRef.element;
        Intrinsics.checkNotNull(t);
        DrawScope.m5911drawPathGBMwjPU$default(drawScope, (Path) t, brush, 0.0f, null, null, 0, 60, null);
        return Unit.INSTANCE;
    }

    public static final Unit createDrawRectBorder$lambda$0(BorderLogic borderLogic, Rect rect, Brush brush, DrawScope drawScope) {
        long m5095constructorimpl;
        long m5163constructorimpl;
        Function0<Float> function0 = borderLogic.borderWidth;
        Intrinsics.checkNotNull(function0);
        float coerceAtLeast = RangesKt.coerceAtLeast(function0.invoke().floatValue(), 0.0f);
        boolean z = coerceAtLeast * 2.0f > rect.getMinDimension();
        if (z) {
            m5095constructorimpl = rect.m5138getTopLeftF1C5BW0();
        } else {
            float f = coerceAtLeast / 2.0f;
            m5095constructorimpl = Offset.m5095constructorimpl((Float.floatToRawIntBits(rect.getTop() + f) & 4294967295L) | (Float.floatToRawIntBits(rect.getLeft() + f) << 32));
        }
        long j = m5095constructorimpl;
        if (z) {
            m5163constructorimpl = rect.m5136getSizeNHjbRc();
        } else {
            m5163constructorimpl = Size.m5163constructorimpl((4294967295L & Float.floatToRawIntBits((rect.getBottom() - rect.getTop()) - coerceAtLeast)) | (Float.floatToRawIntBits((rect.getRight() - rect.getLeft()) - coerceAtLeast) << 32));
        }
        DrawScope.m5915drawRectAsUm42w$default(drawScope, brush, j, m5163constructorimpl, 0.0f, z ? Fill.INSTANCE : new Stroke(coerceAtLeast, 0.0f, 0, 0, null, 30, null), null, 0, 104, null);
        return Unit.INSTANCE;
    }
}
