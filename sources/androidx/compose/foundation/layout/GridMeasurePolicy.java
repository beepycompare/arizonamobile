package androidx.compose.foundation.layout;

import androidx.collection.MutableLongList;
import androidx.collection.MutableObjectList;
import androidx.compose.runtime.State;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.ConstraintsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
/* compiled from: Grid.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B&\u0012\u001d\u0010\u0002\u001a\u0019\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u00070\u0003¢\u0006\u0004\b\b\u0010\tJ)\u0010\n\u001a\u00020\u000b*\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R%\u0010\u0002\u001a\u0019\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0002\b\u00070\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Landroidx/compose/foundation/layout/GridMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "configState", "Landroidx/compose/runtime/State;", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/GridConfigurationScope;", "", "Lkotlin/ExtensionFunctionType;", "<init>", "(Landroidx/compose/runtime/State;)V", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "foundation-layout"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class GridMeasurePolicy implements MeasurePolicy {
    public static final int $stable = 0;
    private final State<Function1<GridConfigurationScope, Unit>> configState;

    /* JADX WARN: Multi-variable type inference failed */
    public GridMeasurePolicy(State<? extends Function1<? super GridConfigurationScope, Unit>> state) {
        this.configState = state;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo41measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        final ResolvedGridItemIndicesResult m977resolveGridItemIndicespclAfdo;
        final GridTrackSizes m974calculateGridTrackSizescMe430U;
        MeasureScope measureScope2 = measureScope;
        GridConfigurationScopeImpl gridConfigurationScopeImpl = new GridConfigurationScopeImpl(measureScope2, j, null);
        this.configState.getValue().invoke(gridConfigurationScopeImpl);
        m977resolveGridItemIndicespclAfdo = GridKt.m977resolveGridItemIndicespclAfdo(list, gridConfigurationScopeImpl.getColumnSpecs(), gridConfigurationScopeImpl.getRowSpecs(), gridConfigurationScopeImpl.mo946getFlowITJdzs4());
        MutableObjectList<GridItem> gridItems = m977resolveGridItemIndicespclAfdo.getGridItems();
        MutableLongList columnSpecs = gridConfigurationScopeImpl.getColumnSpecs();
        m974calculateGridTrackSizescMe430U = GridKt.m974calculateGridTrackSizescMe430U(measureScope2, gridItems, columnSpecs, gridConfigurationScopeImpl.getRowSpecs(), (int) (m977resolveGridItemIndicespclAfdo.m1095getGridSizeYbymL2g() >> 32), (int) (m977resolveGridItemIndicespclAfdo.m1095getGridSizeYbymL2g() & 4294967295L), j, gridConfigurationScopeImpl.m956getColumnGapD9Ej5fM(), gridConfigurationScopeImpl.m957getRowGapD9Ej5fM());
        GridKt.measureItems(m977resolveGridItemIndicespclAfdo.getGridItems(), m974calculateGridTrackSizescMe430U, measureScope.getLayoutDirection());
        return MeasureScope.layout$default(measureScope, ConstraintsKt.m8130constrainWidthK40F9xA(j, m974calculateGridTrackSizescMe430U.getTotalWidth()), ConstraintsKt.m8129constrainHeightK40F9xA(j, m974calculateGridTrackSizescMe430U.getTotalHeight()), null, new Function1() { // from class: androidx.compose.foundation.layout.GridMeasurePolicy$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return GridMeasurePolicy.measure_3p2s80s$lambda$0(GridTrackSizes.this, m977resolveGridItemIndicespclAfdo, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit measure_3p2s80s$lambda$0(GridTrackSizes gridTrackSizes, ResolvedGridItemIndicesResult resolvedGridItemIndicesResult, Placeable.PlacementScope placementScope) {
        int[] calculateTrackOffsets;
        int[] calculateTrackOffsets2;
        Placeable.PlacementScope placementScope2;
        calculateTrackOffsets = GridKt.calculateTrackOffsets(gridTrackSizes.getColumnWidths(), gridTrackSizes.getColumnGapPx());
        calculateTrackOffsets2 = GridKt.calculateTrackOffsets(gridTrackSizes.getRowHeights(), gridTrackSizes.getRowGapPx());
        MutableObjectList<GridItem> gridItems = resolvedGridItemIndicesResult.getGridItems();
        Object[] objArr = gridItems.content;
        int i = gridItems._size;
        int i2 = 0;
        while (i2 < i) {
            GridItem gridItem = (GridItem) objArr[i2];
            Placeable placeable = gridItem.getPlaceable();
            if (placeable != null) {
                placementScope2 = placementScope;
                Placeable.PlacementScope.place$default(placementScope2, placeable, gridItem.getOffsetX() + calculateTrackOffsets[gridItem.getColumn()], calculateTrackOffsets2[gridItem.getRow()] + gridItem.getOffsetY(), 0.0f, 4, null);
            } else {
                placementScope2 = placementScope;
            }
            i2++;
            placementScope = placementScope2;
        }
        return Unit.INSTANCE;
    }
}
