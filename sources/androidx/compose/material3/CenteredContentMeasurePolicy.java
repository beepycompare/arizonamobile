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
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
/* compiled from: ShortNavigationBar.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Landroidx/compose/material3/CenteredContentMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "<init>", "()V", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
final class CenteredContentMeasurePolicy implements MeasurePolicy {
    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo41measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
        int calculateCenteredContentHorizontalPadding;
        final ArrayList arrayList;
        int i;
        int m7508getMaxWidthimpl = Constraints.m7508getMaxWidthimpl(j);
        int m7509getMinHeightimpl = Constraints.m7509getMinHeightimpl(j);
        int size = list.size();
        if (size < 1) {
            return MeasureScope.layout$default(measureScope, m7508getMaxWidthimpl, m7509getMinHeightimpl, null, new Function1() { // from class: androidx.compose.material3.CenteredContentMeasurePolicy$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit unit;
                    Placeable.PlacementScope placementScope = (Placeable.PlacementScope) obj;
                    unit = Unit.INSTANCE;
                    return unit;
                }
            }, 4, null);
        }
        final Ref.IntRef intRef = new Ref.IntRef();
        int i2 = 0;
        if (Constraints.m7504getHasBoundedWidthimpl(j)) {
            int i3 = m7508getMaxWidthimpl / size;
            calculateCenteredContentHorizontalPadding = ShortNavigationBarKt.calculateCenteredContentHorizontalPadding(size, m7508getMaxWidthimpl);
            intRef.element = calculateCenteredContentHorizontalPadding;
            int i4 = (m7508getMaxWidthimpl - (intRef.element * 2)) / size;
            List<? extends Measurable> list2 = list;
            int size2 = list2.size();
            for (int i5 = 0; i5 < size2; i5++) {
                int maxIntrinsicHeight = list.get(i5).maxIntrinsicHeight(i4);
                if (m7509getMinHeightimpl < maxIntrinsicHeight) {
                    m7509getMinHeightimpl = RangesKt.coerceAtMost(maxIntrinsicHeight, Constraints.m7507getMaxHeightimpl(j));
                }
            }
            ArrayList arrayList2 = new ArrayList(list.size());
            int size3 = list2.size();
            while (i2 < size3) {
                ArrayList arrayList3 = arrayList2;
                Measurable measurable = list.get(i2);
                int maxIntrinsicWidth = measurable.maxIntrinsicWidth(Constraints.m7509getMinHeightimpl(j));
                if (i4 < maxIntrinsicWidth) {
                    i = RangesKt.coerceAtMost(maxIntrinsicWidth, i3);
                    intRef.element -= (i - i4) / 2;
                } else {
                    i = i4;
                }
                arrayList3.add(measurable.mo6216measureBRTryo0(ConstraintsKt.m7523constrainN9IONVI(j, Constraints.Companion.m7518fixedJhjzzOo(i, m7509getMinHeightimpl))));
                i2++;
            }
            arrayList = arrayList2;
        } else {
            ArrayList arrayList4 = new ArrayList(list.size());
            int size4 = list.size();
            while (i2 < size4) {
                arrayList4.add(list.get(i2).mo6216measureBRTryo0(ConstraintsKt.m7523constrainN9IONVI(j, Constraints.Companion.m7519fixedHeightOenEA2s(m7509getMinHeightimpl))));
                i2++;
            }
            arrayList = arrayList4;
        }
        return MeasureScope.layout$default(measureScope, m7508getMaxWidthimpl, m7509getMinHeightimpl, null, new Function1() { // from class: androidx.compose.material3.CenteredContentMeasurePolicy$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return CenteredContentMeasurePolicy.measure_3p2s80s$lambda$5(Ref.IntRef.this, arrayList, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit measure_3p2s80s$lambda$5(Ref.IntRef intRef, List list, Placeable.PlacementScope placementScope) {
        int i = intRef.element;
        int size = list.size();
        int i2 = i;
        for (int i3 = 0; i3 < size; i3++) {
            Placeable placeable = (Placeable) list.get(i3);
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable, i2, 0, 0.0f, 4, null);
            i2 += placeable.getWidth();
        }
        return Unit.INSTANCE;
    }
}
