package androidx.compose.ui.draw;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.RenderEffectKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.TileMode;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
/* compiled from: Blur.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a(\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a0\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\f"}, d2 = {"blur", "Landroidx/compose/ui/Modifier;", "radius", "Landroidx/compose/ui/unit/Dp;", "edgeTreatment", "Landroidx/compose/ui/draw/BlurredEdgeTreatment;", "blur-F8QBwvs", "(Landroidx/compose/ui/Modifier;FLandroidx/compose/ui/graphics/Shape;)Landroidx/compose/ui/Modifier;", "radiusX", "radiusY", "blur-1fqS-gw", "(Landroidx/compose/ui/Modifier;FFLandroidx/compose/ui/graphics/Shape;)Landroidx/compose/ui/Modifier;", "ui_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class BlurKt {
    /* renamed from: blur-1fqS-gw$default  reason: not valid java name */
    public static /* synthetic */ Modifier m3684blur1fqSgw$default(Modifier modifier, float f, float f2, BlurredEdgeTreatment blurredEdgeTreatment, int i, Object obj) {
        if ((i & 4) != 0) {
            blurredEdgeTreatment = BlurredEdgeTreatment.m3687boximpl(BlurredEdgeTreatment.Companion.m3694getRectangleGoahg());
        }
        return m3683blur1fqSgw(modifier, f, f2, blurredEdgeTreatment.m3693unboximpl());
    }

    /* renamed from: blur-1fqS-gw  reason: not valid java name */
    public static final Modifier m3683blur1fqSgw(Modifier modifier, final float f, final float f2, final Shape shape) {
        int m4453getDecal3opZhB0;
        final boolean z;
        if (shape != null) {
            m4453getDecal3opZhB0 = TileMode.Companion.m4452getClamp3opZhB0();
            z = true;
        } else {
            m4453getDecal3opZhB0 = TileMode.Companion.m4453getDecal3opZhB0();
            z = false;
        }
        final int i = m4453getDecal3opZhB0;
        float f3 = 0;
        return ((Dp.m6683compareTo0680j_4(f, Dp.m6684constructorimpl(f3)) <= 0 || Dp.m6683compareTo0680j_4(f2, Dp.m6684constructorimpl(f3)) <= 0) && !z) ? modifier : GraphicsLayerModifierKt.graphicsLayer(modifier, new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.ui.draw.BlurKt$blur$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GraphicsLayerScope graphicsLayerScope) {
                invoke2(graphicsLayerScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(GraphicsLayerScope graphicsLayerScope) {
                float f4 = graphicsLayerScope.mo389toPx0680j_4(f);
                float f5 = graphicsLayerScope.mo389toPx0680j_4(f2);
                graphicsLayerScope.setRenderEffect((f4 <= 0.0f || f5 <= 0.0f) ? null : RenderEffectKt.m4387BlurEffect3YTHUZs(f4, f5, i));
                Shape shape2 = shape;
                if (shape2 == null) {
                    shape2 = RectangleShapeKt.getRectangleShape();
                }
                graphicsLayerScope.setShape(shape2);
                graphicsLayerScope.setClip(z);
            }
        });
    }

    /* renamed from: blur-F8QBwvs$default  reason: not valid java name */
    public static /* synthetic */ Modifier m3686blurF8QBwvs$default(Modifier modifier, float f, BlurredEdgeTreatment blurredEdgeTreatment, int i, Object obj) {
        if ((i & 2) != 0) {
            blurredEdgeTreatment = BlurredEdgeTreatment.m3687boximpl(BlurredEdgeTreatment.Companion.m3694getRectangleGoahg());
        }
        return m3685blurF8QBwvs(modifier, f, blurredEdgeTreatment.m3693unboximpl());
    }

    /* renamed from: blur-F8QBwvs  reason: not valid java name */
    public static final Modifier m3685blurF8QBwvs(Modifier modifier, float f, Shape shape) {
        return m3683blur1fqSgw(modifier, f, f, shape);
    }
}
