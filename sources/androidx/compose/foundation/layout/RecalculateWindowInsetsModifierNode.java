package androidx.compose.foundation.layout;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.modifier.ModifierLocalMap;
import androidx.compose.ui.modifier.ModifierLocalModifierNode;
import androidx.compose.ui.modifier.ModifierLocalModifierNodeKt;
import androidx.compose.ui.node.GlobalPositionAwareModifierNode;
import androidx.compose.ui.node.LayoutModifierNode;
import androidx.compose.ui.node.LayoutModifierNodeKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WindowInsetsPadding.kt */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\u001a\u001a\u00020\u001b*\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016¢\u0006\u0004\b!\u0010\"J\u001c\u0010#\u001a\u00020$*\u00020%2\u0006\u0010\u001d\u001a\u00020&2\u0006\u0010'\u001a\u00020$H\u0016J\u001c\u0010(\u001a\u00020$*\u00020%2\u0006\u0010\u001d\u001a\u00020&2\u0006\u0010)\u001a\u00020$H\u0016J\u001c\u0010*\u001a\u00020$*\u00020%2\u0006\u0010\u001d\u001a\u00020&2\u0006\u0010'\u001a\u00020$H\u0016J\u001c\u0010+\u001a\u00020$*\u00020%2\u0006\u0010\u001d\u001a\u00020&2\u0006\u0010)\u001a\u00020$H\u0016J\u0010\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00178VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u00060"}, d2 = {"Landroidx/compose/foundation/layout/RecalculateWindowInsetsModifierNode;", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/modifier/ModifierLocalModifierNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/node/GlobalPositionAwareModifierNode;", "<init>", "()V", "insets", "Landroidx/compose/foundation/layout/ValueInsets;", "getInsets", "()Landroidx/compose/foundation/layout/ValueInsets;", "oldPosition", "Landroidx/compose/ui/unit/IntOffset;", "getOldPosition-nOcc-ac", "()J", "setOldPosition--gyyYBs", "(J)V", "J", "providedValues", "Landroidx/compose/ui/modifier/ModifierLocalMap;", "getProvidedValues", "()Landroidx/compose/ui/modifier/ModifierLocalMap;", "shouldAutoInvalidate", "", "getShouldAutoInvalidate", "()Z", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "minIntrinsicWidth", "height", "maxIntrinsicHeight", "maxIntrinsicWidth", "onGloballyPositioned", "", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "foundation-layout"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class RecalculateWindowInsetsModifierNode extends Modifier.Node implements ModifierLocalModifierNode, LayoutModifierNode, GlobalPositionAwareModifierNode {
    private final ValueInsets insets;
    private long oldPosition;
    private final ModifierLocalMap providedValues;

    @Override // androidx.compose.ui.Modifier.Node
    public boolean getShouldAutoInvalidate() {
        return false;
    }

    public RecalculateWindowInsetsModifierNode() {
        ValueInsets valueInsets = new ValueInsets(new InsetsValues(0, 0, 0, 0), "reset");
        this.insets = valueInsets;
        this.oldPosition = IntOffset.Companion.m8135getZeronOccac();
        this.providedValues = ModifierLocalModifierNodeKt.modifierLocalMapOf(TuplesKt.to(WindowInsetsPaddingKt.getModifierLocalConsumedWindowInsets(), valueInsets));
    }

    public final ValueInsets getInsets() {
        return this.insets;
    }

    /* renamed from: getOldPosition-nOcc-ac  reason: not valid java name */
    public final long m871getOldPositionnOccac() {
        return this.oldPosition;
    }

    /* renamed from: setOldPosition--gyyYBs  reason: not valid java name */
    public final void m872setOldPositiongyyYBs(long j) {
        this.oldPosition = j;
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalModifierNode
    public ModifierLocalMap getProvidedValues() {
        return this.providedValues;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo81measure3p2s80s(MeasureScope measureScope, final Measurable measurable, long j) {
        if (!Constraints.m7947getHasFixedWidthimpl(j) || !Constraints.m7946getHasFixedHeightimpl(j)) {
            provide(WindowInsetsPaddingKt.getModifierLocalConsumedWindowInsets(), getCurrent(WindowInsetsPaddingKt.getModifierLocalConsumedWindowInsets()));
            final Placeable mo6698measureBRTryo0 = measurable.mo6698measureBRTryo0(j);
            return MeasureScope.layout$default(measureScope, mo6698measureBRTryo0.getWidth(), mo6698measureBRTryo0.getHeight(), null, new Function1() { // from class: androidx.compose.foundation.layout.RecalculateWindowInsetsModifierNode$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit measure_3p2s80s$lambda$0;
                    measure_3p2s80s$lambda$0 = RecalculateWindowInsetsModifierNode.measure_3p2s80s$lambda$0(Placeable.this, (Placeable.PlacementScope) obj);
                    return measure_3p2s80s$lambda$0;
                }
            }, 4, null);
        }
        final int m7949getMaxWidthimpl = Constraints.m7949getMaxWidthimpl(j);
        final int m7948getMaxHeightimpl = Constraints.m7948getMaxHeightimpl(j);
        return MeasureScope.layout$default(measureScope, m7949getMaxWidthimpl, m7948getMaxHeightimpl, null, new Function1() { // from class: androidx.compose.foundation.layout.RecalculateWindowInsetsModifierNode$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit measure_3p2s80s$lambda$2;
                measure_3p2s80s$lambda$2 = RecalculateWindowInsetsModifierNode.measure_3p2s80s$lambda$2(RecalculateWindowInsetsModifierNode.this, measurable, m7949getMaxWidthimpl, m7948getMaxHeightimpl, (Placeable.PlacementScope) obj);
                return measure_3p2s80s$lambda$2;
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$0(Placeable placeable, Placeable.PlacementScope placementScope) {
        Placeable.PlacementScope.place$default(placementScope, placeable, 0, 0, 0.0f, 4, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$2(RecalculateWindowInsetsModifierNode recalculateWindowInsetsModifierNode, Measurable measurable, int i, int i2, Placeable.PlacementScope placementScope) {
        WindowInsets windowInsets;
        LayoutCoordinates coordinates = placementScope.getCoordinates();
        if (coordinates != null) {
            recalculateWindowInsetsModifierNode.oldPosition = IntOffsetKt.m8141roundk4lQ0M(LayoutCoordinatesKt.positionInRoot(coordinates));
        }
        if (coordinates == null) {
            windowInsets = (WindowInsets) recalculateWindowInsetsModifierNode.getCurrent(WindowInsetsPaddingKt.getModifierLocalConsumedWindowInsets());
        } else {
            long positionInRoot = LayoutCoordinatesKt.positionInRoot(coordinates);
            long mo6706getSizeYbymL2g = coordinates.mo6706getSizeYbymL2g();
            long mo6709localToRootMKHz9U = coordinates.mo6709localToRootMKHz9U(Offset.m5028constructorimpl((Float.floatToRawIntBits((int) (mo6706getSizeYbymL2g & 4294967295L)) & 4294967295L) | (Float.floatToRawIntBits((int) (mo6706getSizeYbymL2g >> 32)) << 32)));
            long mo6706getSizeYbymL2g2 = LayoutCoordinatesKt.findRootCoordinates(coordinates).mo6706getSizeYbymL2g();
            int round = Math.round(Float.intBitsToFloat((int) (positionInRoot >> 32)));
            int round2 = Math.round(Float.intBitsToFloat((int) (positionInRoot & 4294967295L)));
            int round3 = ((int) (mo6706getSizeYbymL2g2 >> 32)) - Math.round(Float.intBitsToFloat((int) (mo6709localToRootMKHz9U >> 32)));
            int round4 = ((int) (mo6706getSizeYbymL2g2 & 4294967295L)) - Math.round(Float.intBitsToFloat((int) (mo6709localToRootMKHz9U & 4294967295L)));
            InsetsValues value$foundation_layout = recalculateWindowInsetsModifierNode.insets.getValue$foundation_layout();
            if (value$foundation_layout.getLeft() != round || value$foundation_layout.getTop() != round2 || value$foundation_layout.getRight() != round3 || value$foundation_layout.getBottom() != round4) {
                recalculateWindowInsetsModifierNode.insets.setValue$foundation_layout(new InsetsValues(round, round2, round3, round4));
            }
            windowInsets = recalculateWindowInsetsModifierNode.insets;
        }
        recalculateWindowInsetsModifierNode.provide(WindowInsetsPaddingKt.getModifierLocalConsumedWindowInsets(), windowInsets);
        Placeable.PlacementScope.place$default(placementScope, measurable.mo6698measureBRTryo0(Constraints.Companion.m7959fixedJhjzzOo(i, i2)), 0, 0, 0.0f, 4, null);
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return intrinsicMeasurable.minIntrinsicHeight(i);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return intrinsicMeasurable.minIntrinsicWidth(i);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return intrinsicMeasurable.maxIntrinsicHeight(i);
    }

    @Override // androidx.compose.ui.node.LayoutModifierNode
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        return intrinsicMeasurable.maxIntrinsicWidth(i);
    }

    @Override // androidx.compose.ui.node.GlobalPositionAwareModifierNode
    public void onGloballyPositioned(LayoutCoordinates layoutCoordinates) {
        long m8141roundk4lQ0M = IntOffsetKt.m8141roundk4lQ0M(LayoutCoordinatesKt.positionInRoot(layoutCoordinates));
        boolean m8123equalsimpl0 = IntOffset.m8123equalsimpl0(this.oldPosition, m8141roundk4lQ0M);
        this.oldPosition = m8141roundk4lQ0M;
        if (m8123equalsimpl0) {
            return;
        }
        LayoutModifierNodeKt.invalidatePlacement(this);
    }
}
