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
/* compiled from: ShortNavigationBar.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Landroidx/compose/material3/EqualWeightContentMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "<init>", "()V", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
final class EqualWeightContentMeasurePolicy implements MeasurePolicy {
    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo41measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        final ArrayList arrayList;
        int m7508getMaxWidthimpl = Constraints.m7508getMaxWidthimpl(j);
        int m7509getMinHeightimpl = Constraints.m7509getMinHeightimpl(j);
        int size = list.size();
        if (size < 1) {
            return MeasureScope.layout$default(measureScope, m7508getMaxWidthimpl, m7509getMinHeightimpl, null, new Function1() { // from class: androidx.compose.material3.EqualWeightContentMeasurePolicy$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit unit;
                    Placeable.PlacementScope placementScope = (Placeable.PlacementScope) obj;
                    unit = Unit.INSTANCE;
                    return unit;
                }
            }, 4, null);
        }
        int i = 0;
        if (Constraints.m7504getHasBoundedWidthimpl(j)) {
            int i2 = m7508getMaxWidthimpl / size;
            List<? extends Measurable> list2 = list;
            int size2 = list2.size();
            for (int i3 = 0; i3 < size2; i3++) {
                int maxIntrinsicHeight = list.get(i3).maxIntrinsicHeight(i2);
                if (m7509getMinHeightimpl < maxIntrinsicHeight) {
                    m7509getMinHeightimpl = RangesKt.coerceAtMost(maxIntrinsicHeight, Constraints.m7507getMaxHeightimpl(j));
                }
            }
            ArrayList arrayList2 = new ArrayList(list.size());
            int size3 = list2.size();
            while (i < size3) {
                arrayList2.add(list.get(i).mo6216measureBRTryo0(ConstraintsKt.m7523constrainN9IONVI(j, Constraints.Companion.m7518fixedJhjzzOo(i2, m7509getMinHeightimpl))));
                i++;
            }
            arrayList = arrayList2;
        } else {
            ArrayList arrayList3 = new ArrayList(list.size());
            int size4 = list.size();
            while (i < size4) {
                arrayList3.add(list.get(i).mo6216measureBRTryo0(ConstraintsKt.m7523constrainN9IONVI(j, Constraints.Companion.m7519fixedHeightOenEA2s(m7509getMinHeightimpl))));
                i++;
            }
            arrayList = arrayList3;
        }
        return MeasureScope.layout$default(measureScope, m7508getMaxWidthimpl, m7509getMinHeightimpl, null, new Function1() { // from class: androidx.compose.material3.EqualWeightContentMeasurePolicy$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return EqualWeightContentMeasurePolicy.measure_3p2s80s$lambda$5(arrayList, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit measure_3p2s80s$lambda$5(List list, Placeable.PlacementScope placementScope) {
        int size = list.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            Placeable placeable = (Placeable) list.get(i);
            Placeable.PlacementScope placementScope2 = placementScope;
            Placeable.PlacementScope.placeRelative$default(placementScope2, placeable, i2, 0, 0.0f, 4, null);
            i2 += placeable.getWidth();
            i++;
            placementScope = placementScope2;
        }
        return Unit.INSTANCE;
    }
}
