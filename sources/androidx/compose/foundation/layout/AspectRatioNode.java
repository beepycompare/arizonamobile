package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
/* compiled from: AspectRatio.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0016\u0010\u0010\u001a\u00020\u0011*\u00020\u0012H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\u001c\u0010\u0015\u001a\u00020\u0016*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0016H\u0016J\u001c\u0010\u001b\u001a\u00020\u0016*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u0016H\u0016J&\u0010\u001d\u001a\u00020\u001e*\u00020\u001f2\u0006\u0010\u0018\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0012H\u0016ø\u0001\u0000¢\u0006\u0004\b\"\u0010#J\u001c\u0010$\u001a\u00020\u0016*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0016H\u0016J\u001c\u0010%\u001a\u00020\u0016*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u0016H\u0016J\u001e\u0010&\u001a\u00020\u0011*\u00020\u00122\u0006\u0010'\u001a\u00020\u0006H\u0002ø\u0001\u0000¢\u0006\u0004\b(\u0010)J\u001e\u0010*\u001a\u00020\u0011*\u00020\u00122\u0006\u0010'\u001a\u00020\u0006H\u0002ø\u0001\u0000¢\u0006\u0004\b+\u0010)J\u001e\u0010,\u001a\u00020\u0011*\u00020\u00122\u0006\u0010'\u001a\u00020\u0006H\u0002ø\u0001\u0000¢\u0006\u0004\b-\u0010)J\u001e\u0010.\u001a\u00020\u0011*\u00020\u00122\u0006\u0010'\u001a\u00020\u0006H\u0002ø\u0001\u0000¢\u0006\u0004\b/\u0010)R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00060"}, d2 = {"Landroidx/compose/foundation/layout/AspectRatioNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "aspectRatio", "", "matchHeightConstraintsFirst", "", "(FZ)V", "getAspectRatio", "()F", "setAspectRatio", "(F)V", "getMatchHeightConstraintsFirst", "()Z", "setMatchHeightConstraintsFirst", "(Z)V", "findSize", "Landroidx/compose/ui/unit/IntSize;", "Landroidx/compose/ui/unit/Constraints;", "findSize-ToXhtMw", "(J)J", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "tryMaxHeight", "enforceConstraints", "tryMaxHeight-JN-0ABg", "(JZ)J", "tryMaxWidth", "tryMaxWidth-JN-0ABg", "tryMinHeight", "tryMinHeight-JN-0ABg", "tryMinWidth", "tryMinWidth-JN-0ABg", "foundation-layout_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
final class AspectRatioNode extends Modifier.Node implements LayoutModifierNode {
    private float aspectRatio;
    private boolean matchHeightConstraintsFirst;

    public final float getAspectRatio() {
        return this.aspectRatio;
    }

    public final void setAspectRatio(float f) {
        this.aspectRatio = f;
    }

    public final boolean getMatchHeightConstraintsFirst() {
        return this.matchHeightConstraintsFirst;
    }

    public final void setMatchHeightConstraintsFirst(boolean z) {
        this.matchHeightConstraintsFirst = z;
    }

    public AspectRatioNode(float f, boolean z) {
        this.aspectRatio = f;
        this.matchHeightConstraintsFirst = z;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo70measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        long m637findSizeToXhtMw = m637findSizeToXhtMw(j);
        if (!IntSize.m6853equalsimpl0(m637findSizeToXhtMw, IntSize.Companion.m6860getZeroYbymL2g())) {
            j = Constraints.Companion.m6647fixedJhjzzOo((int) (m637findSizeToXhtMw >> 32), (int) (m637findSizeToXhtMw & 4294967295L));
        }
        final Placeable mo5438measureBRTryo0 = measurable.mo5438measureBRTryo0(j);
        return MeasureScope.layout$default(measureScope, mo5438measureBRTryo0.getWidth(), mo5438measureBRTryo0.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.AspectRatioNode$measure$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                invoke2(placementScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Placeable.PlacementScope placementScope) {
                Placeable.PlacementScope.placeRelative$default(placementScope, Placeable.this, 0, 0, 0.0f, 4, null);
            }
        }, 4, null);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (i == Integer.MAX_VALUE) {
            return intrinsicMeasurable.minIntrinsicWidth(i);
        }
        return Math.round(i * this.aspectRatio);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (i == Integer.MAX_VALUE) {
            return intrinsicMeasurable.maxIntrinsicWidth(i);
        }
        return Math.round(i * this.aspectRatio);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (i == Integer.MAX_VALUE) {
            return intrinsicMeasurable.minIntrinsicHeight(i);
        }
        return Math.round(i / this.aspectRatio);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (i == Integer.MAX_VALUE) {
            return intrinsicMeasurable.maxIntrinsicHeight(i);
        }
        return Math.round(i / this.aspectRatio);
    }

    /* renamed from: findSize-ToXhtMw  reason: not valid java name */
    private final long m637findSizeToXhtMw(long j) {
        if (!this.matchHeightConstraintsFirst) {
            long m639tryMaxWidthJN0ABg = m639tryMaxWidthJN0ABg(j, true);
            if (!IntSize.m6853equalsimpl0(m639tryMaxWidthJN0ABg, IntSize.Companion.m6860getZeroYbymL2g())) {
                return m639tryMaxWidthJN0ABg;
            }
            long m638tryMaxHeightJN0ABg = m638tryMaxHeightJN0ABg(j, true);
            if (!IntSize.m6853equalsimpl0(m638tryMaxHeightJN0ABg, IntSize.Companion.m6860getZeroYbymL2g())) {
                return m638tryMaxHeightJN0ABg;
            }
            long m641tryMinWidthJN0ABg = m641tryMinWidthJN0ABg(j, true);
            if (!IntSize.m6853equalsimpl0(m641tryMinWidthJN0ABg, IntSize.Companion.m6860getZeroYbymL2g())) {
                return m641tryMinWidthJN0ABg;
            }
            long m640tryMinHeightJN0ABg = m640tryMinHeightJN0ABg(j, true);
            if (!IntSize.m6853equalsimpl0(m640tryMinHeightJN0ABg, IntSize.Companion.m6860getZeroYbymL2g())) {
                return m640tryMinHeightJN0ABg;
            }
            long m639tryMaxWidthJN0ABg2 = m639tryMaxWidthJN0ABg(j, false);
            if (!IntSize.m6853equalsimpl0(m639tryMaxWidthJN0ABg2, IntSize.Companion.m6860getZeroYbymL2g())) {
                return m639tryMaxWidthJN0ABg2;
            }
            long m638tryMaxHeightJN0ABg2 = m638tryMaxHeightJN0ABg(j, false);
            if (!IntSize.m6853equalsimpl0(m638tryMaxHeightJN0ABg2, IntSize.Companion.m6860getZeroYbymL2g())) {
                return m638tryMaxHeightJN0ABg2;
            }
            long m641tryMinWidthJN0ABg2 = m641tryMinWidthJN0ABg(j, false);
            if (!IntSize.m6853equalsimpl0(m641tryMinWidthJN0ABg2, IntSize.Companion.m6860getZeroYbymL2g())) {
                return m641tryMinWidthJN0ABg2;
            }
            long m640tryMinHeightJN0ABg2 = m640tryMinHeightJN0ABg(j, false);
            if (!IntSize.m6853equalsimpl0(m640tryMinHeightJN0ABg2, IntSize.Companion.m6860getZeroYbymL2g())) {
                return m640tryMinHeightJN0ABg2;
            }
        } else {
            long m638tryMaxHeightJN0ABg3 = m638tryMaxHeightJN0ABg(j, true);
            if (!IntSize.m6853equalsimpl0(m638tryMaxHeightJN0ABg3, IntSize.Companion.m6860getZeroYbymL2g())) {
                return m638tryMaxHeightJN0ABg3;
            }
            long m639tryMaxWidthJN0ABg3 = m639tryMaxWidthJN0ABg(j, true);
            if (!IntSize.m6853equalsimpl0(m639tryMaxWidthJN0ABg3, IntSize.Companion.m6860getZeroYbymL2g())) {
                return m639tryMaxWidthJN0ABg3;
            }
            long m640tryMinHeightJN0ABg3 = m640tryMinHeightJN0ABg(j, true);
            if (!IntSize.m6853equalsimpl0(m640tryMinHeightJN0ABg3, IntSize.Companion.m6860getZeroYbymL2g())) {
                return m640tryMinHeightJN0ABg3;
            }
            long m641tryMinWidthJN0ABg3 = m641tryMinWidthJN0ABg(j, true);
            if (!IntSize.m6853equalsimpl0(m641tryMinWidthJN0ABg3, IntSize.Companion.m6860getZeroYbymL2g())) {
                return m641tryMinWidthJN0ABg3;
            }
            long m638tryMaxHeightJN0ABg4 = m638tryMaxHeightJN0ABg(j, false);
            if (!IntSize.m6853equalsimpl0(m638tryMaxHeightJN0ABg4, IntSize.Companion.m6860getZeroYbymL2g())) {
                return m638tryMaxHeightJN0ABg4;
            }
            long m639tryMaxWidthJN0ABg4 = m639tryMaxWidthJN0ABg(j, false);
            if (!IntSize.m6853equalsimpl0(m639tryMaxWidthJN0ABg4, IntSize.Companion.m6860getZeroYbymL2g())) {
                return m639tryMaxWidthJN0ABg4;
            }
            long m640tryMinHeightJN0ABg4 = m640tryMinHeightJN0ABg(j, false);
            if (!IntSize.m6853equalsimpl0(m640tryMinHeightJN0ABg4, IntSize.Companion.m6860getZeroYbymL2g())) {
                return m640tryMinHeightJN0ABg4;
            }
            long m641tryMinWidthJN0ABg4 = m641tryMinWidthJN0ABg(j, false);
            if (!IntSize.m6853equalsimpl0(m641tryMinWidthJN0ABg4, IntSize.Companion.m6860getZeroYbymL2g())) {
                return m641tryMinWidthJN0ABg4;
            }
        }
        return IntSize.Companion.m6860getZeroYbymL2g();
    }

    /* renamed from: tryMaxWidth-JN-0ABg  reason: not valid java name */
    private final long m639tryMaxWidthJN0ABg(long j, boolean z) {
        int round;
        int m6637getMaxWidthimpl = Constraints.m6637getMaxWidthimpl(j);
        if (m6637getMaxWidthimpl == Integer.MAX_VALUE || (round = Math.round(m6637getMaxWidthimpl / this.aspectRatio)) <= 0 || (z && !AspectRatioKt.m636isSatisfiedByNN6EwU(j, m6637getMaxWidthimpl, round))) {
            return IntSize.Companion.m6860getZeroYbymL2g();
        }
        return IntSize.m6850constructorimpl((m6637getMaxWidthimpl << 32) | (round & 4294967295L));
    }

    /* renamed from: tryMaxHeight-JN-0ABg  reason: not valid java name */
    private final long m638tryMaxHeightJN0ABg(long j, boolean z) {
        int round;
        int m6636getMaxHeightimpl = Constraints.m6636getMaxHeightimpl(j);
        if (m6636getMaxHeightimpl == Integer.MAX_VALUE || (round = Math.round(m6636getMaxHeightimpl * this.aspectRatio)) <= 0 || (z && !AspectRatioKt.m636isSatisfiedByNN6EwU(j, round, m6636getMaxHeightimpl))) {
            return IntSize.Companion.m6860getZeroYbymL2g();
        }
        return IntSize.m6850constructorimpl((round << 32) | (m6636getMaxHeightimpl & 4294967295L));
    }

    /* renamed from: tryMinWidth-JN-0ABg  reason: not valid java name */
    private final long m641tryMinWidthJN0ABg(long j, boolean z) {
        int m6639getMinWidthimpl = Constraints.m6639getMinWidthimpl(j);
        int round = Math.round(m6639getMinWidthimpl / this.aspectRatio);
        if (round <= 0 || (z && !AspectRatioKt.m636isSatisfiedByNN6EwU(j, m6639getMinWidthimpl, round))) {
            return IntSize.Companion.m6860getZeroYbymL2g();
        }
        return IntSize.m6850constructorimpl((m6639getMinWidthimpl << 32) | (round & 4294967295L));
    }

    /* renamed from: tryMinHeight-JN-0ABg  reason: not valid java name */
    private final long m640tryMinHeightJN0ABg(long j, boolean z) {
        int m6638getMinHeightimpl = Constraints.m6638getMinHeightimpl(j);
        int round = Math.round(m6638getMinHeightimpl * this.aspectRatio);
        if (round <= 0 || (z && !AspectRatioKt.m636isSatisfiedByNN6EwU(j, round, m6638getMinHeightimpl))) {
            return IntSize.Companion.m6860getZeroYbymL2g();
        }
        return IntSize.m6850constructorimpl((round << 32) | (m6638getMinHeightimpl & 4294967295L));
    }
}
