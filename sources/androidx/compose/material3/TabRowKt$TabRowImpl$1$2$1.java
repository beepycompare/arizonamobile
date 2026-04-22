package androidx.compose.material3;

import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.MultiContentMeasurePolicy;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;
/* compiled from: TabRow.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
final class TabRowKt$TabRowImpl$1$2$1 implements MultiContentMeasurePolicy {
    final /* synthetic */ TabRowKt$TabRowImpl$1$scope$1$1 $scope;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TabRowKt$TabRowImpl$1$2$1(TabRowKt$TabRowImpl$1$scope$1$1 tabRowKt$TabRowImpl$1$scope$1$1) {
        this.$scope = tabRowKt$TabRowImpl$1$scope$1$1;
    }

    @Override // androidx.compose.ui.layout.MultiContentMeasurePolicy
    /* renamed from: measure-3p2s80s */
    public final MeasureResult mo762measure3p2s80s(MeasureScope measureScope, List<? extends List<? extends Measurable>> list, long j) {
        MeasureScope measureScope2 = measureScope;
        List<? extends Measurable> list2 = list.get(0);
        List<? extends Measurable> list3 = list.get(1);
        List<? extends Measurable> list4 = list.get(2);
        int m7508getMaxWidthimpl = Constraints.m7508getMaxWidthimpl(j);
        int size = list2.size();
        final Ref.IntRef intRef = new Ref.IntRef();
        if (size > 0) {
            intRef.element = m7508getMaxWidthimpl / size;
        }
        int i = 0;
        List<? extends Measurable> list5 = list2;
        int size2 = list5.size();
        for (int i2 = 0; i2 < size2; i2++) {
            i = Integer.valueOf(Math.max(list2.get(i2).maxIntrinsicHeight(intRef.element), i.intValue()));
        }
        final int intValue = i.intValue();
        TabRowKt$TabRowImpl$1$scope$1$1 tabRowKt$TabRowImpl$1$scope$1$1 = this.$scope;
        ArrayList arrayList = new ArrayList(size);
        int i3 = 0;
        while (i3 < size) {
            arrayList.add(new TabPosition(Dp.m7555constructorimpl(measureScope2.mo402toDpu2uoSUM(intRef.element) * i3), measureScope2.mo402toDpu2uoSUM(intRef.element), ((Dp) ComparisonsKt.maxOf(Dp.m7553boximpl(Dp.m7555constructorimpl(measureScope2.mo402toDpu2uoSUM(Math.min(list2.get(i3).maxIntrinsicWidth(intValue), intRef.element)) - Dp.m7555constructorimpl(TabKt.getHorizontalTextPadding() * 2.0f))), Dp.m7553boximpl(Dp.m7555constructorimpl(24.0f)))).m7569unboximpl(), null));
            i3++;
            measureScope2 = measureScope;
        }
        tabRowKt$TabRowImpl$1$scope$1$1.setTabPositions(arrayList);
        ArrayList arrayList2 = new ArrayList(list2.size());
        int size3 = list5.size();
        for (int i4 = 0; i4 < size3; i4++) {
            int i5 = intValue;
            intValue = i5;
            arrayList2.add(list2.get(i4).mo6216measureBRTryo0(Constraints.m7497copyZbe2FdA(j, intRef.element, intRef.element, i5, intValue)));
        }
        final ArrayList arrayList3 = arrayList2;
        ArrayList arrayList4 = new ArrayList(list3.size());
        int size4 = list3.size();
        for (int i6 = 0; i6 < size4; i6++) {
            arrayList4.add(list3.get(i6).mo6216measureBRTryo0(Constraints.m7498copyZbe2FdA$default(j, 0, 0, 0, 0, 11, null)));
        }
        final ArrayList arrayList5 = arrayList4;
        ArrayList arrayList6 = new ArrayList(list4.size());
        int size5 = list4.size();
        for (int i7 = 0; i7 < size5; i7++) {
            int i8 = intValue;
            intValue = i8;
            arrayList6.add(list4.get(i7).mo6216measureBRTryo0(Constraints.m7497copyZbe2FdA(j, intRef.element, intRef.element, 0, i8)));
        }
        final ArrayList arrayList7 = arrayList6;
        return MeasureScope.layout$default(measureScope, m7508getMaxWidthimpl, intValue, null, new Function1() { // from class: androidx.compose.material3.TabRowKt$TabRowImpl$1$2$1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return TabRowKt$TabRowImpl$1$2$1.measure_3p2s80s$lambda$8(arrayList3, arrayList5, arrayList7, intRef, intValue, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit measure_3p2s80s$lambda$8(List list, List list2, List list3, Ref.IntRef intRef, int i, Placeable.PlacementScope placementScope) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            Placeable.PlacementScope.placeRelative$default(placementScope, (Placeable) list.get(i2), i2 * intRef.element, 0, 0.0f, 4, null);
        }
        int size2 = list2.size();
        for (int i3 = 0; i3 < size2; i3++) {
            Placeable placeable = (Placeable) list2.get(i3);
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable, 0, i - placeable.getHeight(), 0.0f, 4, null);
        }
        int size3 = list3.size();
        for (int i4 = 0; i4 < size3; i4++) {
            Placeable placeable2 = (Placeable) list3.get(i4);
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, 0, i - placeable2.getHeight(), 0.0f, 4, null);
        }
        return Unit.INSTANCE;
    }
}
