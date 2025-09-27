package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
/* compiled from: Size.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\u0011\u001a\u00020\u0012*\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, d2 = {"Landroidx/compose/foundation/layout/FillNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "direction", "Landroidx/compose/foundation/layout/Direction;", "fraction", "", "<init>", "(Landroidx/compose/foundation/layout/Direction;F)V", "getDirection", "()Landroidx/compose/foundation/layout/Direction;", "setDirection", "(Landroidx/compose/foundation/layout/Direction;)V", "getFraction", "()F", "setFraction", "(F)V", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
final class FillNode extends Modifier.Node implements LayoutModifierNode {
    private Direction direction;
    private float fraction;

    public final Direction getDirection() {
        return this.direction;
    }

    public final float getFraction() {
        return this.fraction;
    }

    public final void setDirection(Direction direction) {
        this.direction = direction;
    }

    public final void setFraction(float f) {
        this.fraction = f;
    }

    public FillNode(Direction direction, float f) {
        this.direction = direction;
        this.fraction = f;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo80measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        int m7219getMinWidthimpl;
        int m7217getMaxWidthimpl;
        int m7216getMaxHeightimpl;
        int i;
        if (!Constraints.m7213getHasBoundedWidthimpl(j) || this.direction == Direction.Vertical) {
            m7219getMinWidthimpl = Constraints.m7219getMinWidthimpl(j);
            m7217getMaxWidthimpl = Constraints.m7217getMaxWidthimpl(j);
        } else {
            int round = Math.round(Constraints.m7217getMaxWidthimpl(j) * this.fraction);
            int m7219getMinWidthimpl2 = Constraints.m7219getMinWidthimpl(j);
            m7219getMinWidthimpl = Constraints.m7217getMaxWidthimpl(j);
            if (round < m7219getMinWidthimpl2) {
                round = m7219getMinWidthimpl2;
            }
            if (round <= m7219getMinWidthimpl) {
                m7219getMinWidthimpl = round;
            }
            m7217getMaxWidthimpl = m7219getMinWidthimpl;
        }
        if (!Constraints.m7212getHasBoundedHeightimpl(j) || this.direction == Direction.Horizontal) {
            int m7218getMinHeightimpl = Constraints.m7218getMinHeightimpl(j);
            m7216getMaxHeightimpl = Constraints.m7216getMaxHeightimpl(j);
            i = m7218getMinHeightimpl;
        } else {
            int round2 = Math.round(Constraints.m7216getMaxHeightimpl(j) * this.fraction);
            int m7218getMinHeightimpl2 = Constraints.m7218getMinHeightimpl(j);
            i = Constraints.m7216getMaxHeightimpl(j);
            if (round2 < m7218getMinHeightimpl2) {
                round2 = m7218getMinHeightimpl2;
            }
            if (round2 <= i) {
                i = round2;
            }
            m7216getMaxHeightimpl = i;
        }
        final Placeable mo5967measureBRTryo0 = measurable.mo5967measureBRTryo0(ConstraintsKt.Constraints(m7219getMinWidthimpl, m7217getMaxWidthimpl, i, m7216getMaxHeightimpl));
        return MeasureScope.layout$default(measureScope, mo5967measureBRTryo0.getWidth(), mo5967measureBRTryo0.getHeight(), null, new Function1() { // from class: androidx.compose.foundation.layout.FillNode$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit measure_3p2s80s$lambda$0;
                measure_3p2s80s$lambda$0 = FillNode.measure_3p2s80s$lambda$0(Placeable.this, (Placeable.PlacementScope) obj);
                return measure_3p2s80s$lambda$0;
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$0(Placeable placeable, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, 0, 0, 0.0f, 4, null);
        return Unit.INSTANCE;
    }
}
