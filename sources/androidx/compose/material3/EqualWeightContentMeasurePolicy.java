package androidx.compose.material3;

import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.RangesKt;
/* compiled from: ExpressiveNavigationBar.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J,\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\t\u001a\u00020\nH\u0016ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\r"}, d2 = {"Landroidx/compose/material3/EqualWeightContentMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "()V", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class EqualWeightContentMeasurePolicy implements MeasurePolicy {
    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo42measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        final ArrayList arrayList;
        int m6637getMaxWidthimpl = Constraints.m6637getMaxWidthimpl(j);
        int m6638getMinHeightimpl = Constraints.m6638getMinHeightimpl(j);
        int size = list.size();
        if (size < 1) {
            return MeasureScope.layout$default(measureScope, m6637getMaxWidthimpl, m6638getMinHeightimpl, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.EqualWeightContentMeasurePolicy$measure$1
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(Placeable.PlacementScope placementScope) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                    invoke2(placementScope);
                    return Unit.INSTANCE;
                }
            }, 4, null);
        }
        int i = 0;
        if (Constraints.m6633getHasBoundedWidthimpl(j)) {
            int i2 = m6637getMaxWidthimpl / size;
            int size2 = list.size();
            for (int i3 = 0; i3 < size2; i3++) {
                int maxIntrinsicHeight = list.get(i3).maxIntrinsicHeight(i2);
                if (m6638getMinHeightimpl < maxIntrinsicHeight) {
                    m6638getMinHeightimpl = RangesKt.coerceAtMost(maxIntrinsicHeight, Constraints.m6636getMaxHeightimpl(j));
                }
            }
            ArrayList arrayList2 = new ArrayList(list.size());
            int size3 = list.size();
            while (i < size3) {
                arrayList2.add(list.get(i).mo5438measureBRTryo0(ConstraintsKt.m6652constrainN9IONVI(j, Constraints.Companion.m6647fixedJhjzzOo(i2, m6638getMinHeightimpl))));
                i++;
            }
            arrayList = arrayList2;
        } else {
            ArrayList arrayList3 = new ArrayList(list.size());
            int size4 = list.size();
            while (i < size4) {
                arrayList3.add(list.get(i).mo5438measureBRTryo0(ConstraintsKt.m6652constrainN9IONVI(j, Constraints.Companion.m6648fixedHeightOenEA2s(m6638getMinHeightimpl))));
                i++;
            }
            arrayList = arrayList3;
        }
        return MeasureScope.layout$default(measureScope, m6637getMaxWidthimpl, m6638getMinHeightimpl, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material3.EqualWeightContentMeasurePolicy$measure$5
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
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
                List<Placeable> list2 = arrayList;
                int size5 = list2.size();
                int i4 = 0;
                int i5 = 0;
                while (i4 < size5) {
                    Placeable placeable = list2.get(i4);
                    Placeable.PlacementScope placementScope2 = placementScope;
                    Placeable.PlacementScope.placeRelative$default(placementScope2, placeable, i5, 0, 0.0f, 4, null);
                    i5 += placeable.getWidth();
                    i4++;
                    placementScope = placementScope2;
                }
            }
        }, 4, null);
    }
}
