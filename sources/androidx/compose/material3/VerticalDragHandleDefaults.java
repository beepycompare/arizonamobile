package androidx.compose.material3;

import androidx.compose.material3.tokens.DragHandleTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.geometry.InlineClassHelperKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.unit.DpSize;
import kotlin.Metadata;
/* compiled from: DragHandle.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006J-\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\bH\u0007¢\u0006\u0004\b\u000b\u0010\fJ\r\u0010\r\u001a\u00020\u000eH\u0007¢\u0006\u0002\u0010\u000fJ1\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0011H\u0007¢\u0006\u0002\u0010\u0014J\u0006\u0010\u0015\u001a\u00020\u0016J+\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u00182\b\b\u0002\u0010\u001a\u001a\u00020\u0018¢\u0006\u0004\b\u001b\u0010\u001cR\u0018\u0010\u0004\u001a\u00020\u0005*\u00020\u001d8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0018\u0010\r\u001a\u00020\u000e*\u00020 8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Landroidx/compose/material3/VerticalDragHandleDefaults;", "", "<init>", "()V", "colors", "Landroidx/compose/material3/DragHandleColors;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/DragHandleColors;", "color", "Landroidx/compose/ui/graphics/Color;", "pressedColor", "draggedColor", "colors-RGew2ao", "(JJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material3/DragHandleColors;", "shapes", "Landroidx/compose/material3/DragHandleShapes;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/DragHandleShapes;", "shape", "Landroidx/compose/ui/graphics/Shape;", "pressedShape", "draggedShape", "(Landroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material3/DragHandleShapes;", "sizes", "Landroidx/compose/material3/DragHandleSizes;", "size", "Landroidx/compose/ui/unit/DpSize;", "pressedSize", "draggedSize", "sizes-L9TjZb0", "(JJJ)Landroidx/compose/material3/DragHandleSizes;", "Landroidx/compose/material3/ColorScheme;", "getColors", "(Landroidx/compose/material3/ColorScheme;)Landroidx/compose/material3/DragHandleColors;", "Landroidx/compose/material3/Shapes;", "getShapes", "(Landroidx/compose/material3/Shapes;)Landroidx/compose/material3/DragHandleShapes;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class VerticalDragHandleDefaults {
    public static final int $stable = 0;
    public static final VerticalDragHandleDefaults INSTANCE = new VerticalDragHandleDefaults();
    private static final DragHandleSizes sizes = new DragHandleSizes(DpKt.m7577DpSizeYgX7TsA(DragHandleTokens.INSTANCE.m3346getWidthD9Ej5fM(), DragHandleTokens.INSTANCE.m3342getHeightD9Ej5fM()), DpKt.m7577DpSizeYgX7TsA(DragHandleTokens.INSTANCE.m3345getPressedWidthD9Ej5fM(), DragHandleTokens.INSTANCE.m3344getPressedHeightD9Ej5fM()), DpKt.m7577DpSizeYgX7TsA(DragHandleTokens.INSTANCE.m3340getDraggedWidthD9Ej5fM(), DragHandleTokens.INSTANCE.m3339getDraggedHeightD9Ej5fM()), null);

    private VerticalDragHandleDefaults() {
    }

    public final DragHandleColors colors(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1465068453, "C(colors)215@9367L11:DragHandle.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1465068453, i, -1, "androidx.compose.material3.VerticalDragHandleDefaults.colors (DragHandle.kt:215)");
        }
        DragHandleColors colors = getColors(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return colors;
    }

    /* renamed from: colors-RGew2ao  reason: not valid java name */
    public final DragHandleColors m2939colorsRGew2ao(long j, long j2, long j3, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -2062501640, "C(colors)N(color:c#ui.graphics.Color,pressedColor:c#ui.graphics.Color,draggedColor:c#ui.graphics.Color)234@10175L11:DragHandle.kt#uh7d8r");
        long m4808getUnspecified0d7_KjU = (i2 & 1) != 0 ? Color.Companion.m4808getUnspecified0d7_KjU() : j;
        long m4808getUnspecified0d7_KjU2 = (i2 & 2) != 0 ? Color.Companion.m4808getUnspecified0d7_KjU() : j2;
        long m4808getUnspecified0d7_KjU3 = (i2 & 4) != 0 ? Color.Companion.m4808getUnspecified0d7_KjU() : j3;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2062501640, i, -1, "androidx.compose.material3.VerticalDragHandleDefaults.colors (DragHandle.kt:234)");
        }
        DragHandleColors colors = getColors(MaterialTheme.INSTANCE.getColorScheme(composer, 6));
        if (m4808getUnspecified0d7_KjU == 16) {
            m4808getUnspecified0d7_KjU = colors.m2041getColor0d7_KjU();
        }
        long j4 = m4808getUnspecified0d7_KjU;
        if (m4808getUnspecified0d7_KjU2 == 16) {
            m4808getUnspecified0d7_KjU2 = colors.m2043getPressedColor0d7_KjU();
        }
        long j5 = m4808getUnspecified0d7_KjU2;
        if (m4808getUnspecified0d7_KjU3 == 16) {
            m4808getUnspecified0d7_KjU3 = colors.m2042getDraggedColor0d7_KjU();
        }
        DragHandleColors dragHandleColors = new DragHandleColors(j4, j5, m4808getUnspecified0d7_KjU3, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return dragHandleColors;
    }

    public final DragHandleShapes shapes(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1385335639, "C(shapes)246@10638L6:DragHandle.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1385335639, i, -1, "androidx.compose.material3.VerticalDragHandleDefaults.shapes (DragHandle.kt:246)");
        }
        DragHandleShapes shapes = getShapes(MaterialTheme.INSTANCE.getShapes(composer, 6));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return shapes;
    }

    public final DragHandleShapes shapes(Shape shape, Shape shape2, Shape shape3, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 650848370, "C(shapes)N(shape,pressedShape,draggedShape)265@11405L6:DragHandle.kt#uh7d8r");
        if ((i2 & 1) != 0) {
            shape = null;
        }
        if ((i2 & 2) != 0) {
            shape2 = null;
        }
        if ((i2 & 4) != 0) {
            shape3 = null;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(650848370, i, -1, "androidx.compose.material3.VerticalDragHandleDefaults.shapes (DragHandle.kt:265)");
        }
        DragHandleShapes shapes = getShapes(MaterialTheme.INSTANCE.getShapes(composer, 6));
        if (shape == null) {
            shape = shapes.getShape();
        }
        if (shape2 == null) {
            shape2 = shapes.getPressedShape();
        }
        if (shape3 == null) {
            shape3 = shapes.getDraggedShape();
        }
        DragHandleShapes dragHandleShapes = new DragHandleShapes(shape, shape2, shape3);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return dragHandleShapes;
    }

    public final DragHandleSizes sizes() {
        return sizes;
    }

    /* renamed from: sizes-L9TjZb0$default  reason: not valid java name */
    public static /* synthetic */ DragHandleSizes m2938sizesL9TjZb0$default(VerticalDragHandleDefaults verticalDragHandleDefaults, long j, long j2, long j3, int i, Object obj) {
        if ((i & 1) != 0) {
            j = DpSize.Companion.m7662getUnspecifiedMYxV2XQ();
        }
        long j4 = j;
        if ((i & 2) != 0) {
            j2 = DpSize.Companion.m7662getUnspecifiedMYxV2XQ();
        }
        long j5 = j2;
        if ((i & 4) != 0) {
            j3 = DpSize.Companion.m7662getUnspecifiedMYxV2XQ();
        }
        return verticalDragHandleDefaults.m2940sizesL9TjZb0(j4, j5, j3);
    }

    /* renamed from: sizes-L9TjZb0  reason: not valid java name */
    public final DragHandleSizes m2940sizesL9TjZb0(long j, long j2, long j3) {
        DragHandleSizes dragHandleSizes = sizes;
        if (j == InlineClassHelperKt.UnspecifiedPackedFloats) {
            j = dragHandleSizes.m2046getSizeMYxV2XQ();
        }
        if (j2 == InlineClassHelperKt.UnspecifiedPackedFloats) {
            j2 = dragHandleSizes.m2045getPressedSizeMYxV2XQ();
        }
        long j4 = j2;
        if (j3 == InlineClassHelperKt.UnspecifiedPackedFloats) {
            j3 = dragHandleSizes.m2044getDraggedSizeMYxV2XQ();
        }
        return new DragHandleSizes(j, j4, j3, null);
    }

    private final DragHandleColors getColors(ColorScheme colorScheme) {
        DragHandleColors defaultVerticalDragHandleColorsCached$material3 = colorScheme.getDefaultVerticalDragHandleColorsCached$material3();
        if (defaultVerticalDragHandleColorsCached$material3 == null) {
            DragHandleColors dragHandleColors = new DragHandleColors(ColorSchemeKt.fromToken(colorScheme, DragHandleTokens.INSTANCE.getColor()), ColorSchemeKt.fromToken(colorScheme, DragHandleTokens.INSTANCE.getPressedColor()), ColorSchemeKt.fromToken(colorScheme, DragHandleTokens.INSTANCE.getDraggedColor()), null);
            colorScheme.setDefaultVerticalDragHandleColorsCached$material3(dragHandleColors);
            return dragHandleColors;
        }
        return defaultVerticalDragHandleColorsCached$material3;
    }

    private final DragHandleShapes getShapes(Shapes shapes) {
        DragHandleShapes defaultVerticalDragHandleShapesCached$material3 = shapes.getDefaultVerticalDragHandleShapesCached$material3();
        if (defaultVerticalDragHandleShapesCached$material3 == null) {
            DragHandleShapes dragHandleShapes = new DragHandleShapes(ShapesKt.fromToken(shapes, DragHandleTokens.INSTANCE.getShape()), ShapesKt.fromToken(shapes, DragHandleTokens.INSTANCE.getPressedShape()), ShapesKt.fromToken(shapes, DragHandleTokens.INSTANCE.getDraggedShape()));
            shapes.setDefaultVerticalDragHandleShapesCached$material3(dragHandleShapes);
            return dragHandleShapes;
        }
        return defaultVerticalDragHandleShapesCached$material3;
    }
}
