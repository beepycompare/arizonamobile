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
    public final MeasureResult mo864measure3p2s80s(MeasureScope measureScope, List<? extends List<? extends Measurable>> list, long j) {
        MeasureScope measureScope2 = measureScope;
        List<? extends Measurable> list2 = list.get(0);
        List<? extends Measurable> list3 = list.get(1);
        int i = 2;
        List<? extends Measurable> list4 = list.get(2);
        int m8211getMaxWidthimpl = Constraints.m8211getMaxWidthimpl(j);
        int size = list2.size();
        final Ref.IntRef intRef = new Ref.IntRef();
        if (size > 0) {
            intRef.element = m8211getMaxWidthimpl / size;
        }
        int i2 = 0;
        List<? extends Measurable> list5 = list2;
        int size2 = list5.size();
        for (int i3 = 0; i3 < size2; i3++) {
            i2 = Integer.valueOf(Math.max(list2.get(i3).maxIntrinsicHeight(intRef.element), i2.intValue()));
        }
        final int intValue = i2.intValue();
        TabRowKt$TabRowImpl$1$scope$1$1 tabRowKt$TabRowImpl$1$scope$1$1 = this.$scope;
        ArrayList arrayList = new ArrayList(size);
        int i4 = 0;
        while (i4 < size) {
            arrayList.add(new TabPosition(Dp.m8258constructorimpl(i4 * measureScope2.mo461toDpu2uoSUM(intRef.element)), measureScope2.mo461toDpu2uoSUM(intRef.element), ((Dp) ComparisonsKt.maxOf(Dp.m8256boximpl(Dp.m8258constructorimpl(measureScope2.mo461toDpu2uoSUM(Math.min(list2.get(i4).maxIntrinsicWidth(intValue), intRef.element)) - Dp.m8258constructorimpl(TabKt.getHorizontalTextPadding() * i))), Dp.m8256boximpl(Dp.m8258constructorimpl(24)))).m8272unboximpl(), null));
            i4++;
            measureScope2 = measureScope;
            m8211getMaxWidthimpl = m8211getMaxWidthimpl;
            i = 2;
        }
        int i5 = m8211getMaxWidthimpl;
        tabRowKt$TabRowImpl$1$scope$1$1.setTabPositions(arrayList);
        ArrayList arrayList2 = new ArrayList(list2.size());
        int size3 = list5.size();
        for (int i6 = 0; i6 < size3; i6++) {
            int i7 = intValue;
            intValue = i7;
            arrayList2.add(list2.get(i6).mo6875measureBRTryo0(Constraints.m8200copyZbe2FdA(j, intRef.element, intRef.element, i7, intValue)));
        }
        final ArrayList arrayList3 = arrayList2;
        ArrayList arrayList4 = new ArrayList(list3.size());
        int size4 = list3.size();
        for (int i8 = 0; i8 < size4; i8++) {
            arrayList4.add(list3.get(i8).mo6875measureBRTryo0(Constraints.m8201copyZbe2FdA$default(j, 0, 0, 0, 0, 11, null)));
        }
        final ArrayList arrayList5 = arrayList4;
        ArrayList arrayList6 = new ArrayList(list4.size());
        int size5 = list4.size();
        for (int i9 = 0; i9 < size5; i9++) {
            int i10 = intValue;
            intValue = i10;
            arrayList6.add(list4.get(i9).mo6875measureBRTryo0(Constraints.m8200copyZbe2FdA(j, intRef.element, intRef.element, 0, i10)));
        }
        final ArrayList arrayList7 = arrayList6;
        return MeasureScope.layout$default(measureScope, i5, intValue, null, new Function1() { // from class: androidx.compose.material3.TabRowKt$TabRowImpl$1$2$1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit measure_3p2s80s$lambda$8;
                measure_3p2s80s$lambda$8 = TabRowKt$TabRowImpl$1$2$1.measure_3p2s80s$lambda$8(arrayList3, arrayList5, arrayList7, intRef, intValue, (Placeable.PlacementScope) obj);
                return measure_3p2s80s$lambda$8;
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
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
