package androidx.compose.material3;

import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.MultiContentMeasurePolicy;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntRect;
import androidx.compose.ui.util.MathHelpersKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.RangesKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SearchBar.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SearchBarKt$DockedSearchBarLayout$2$2$1 implements MultiContentMeasurePolicy {
    final /* synthetic */ float $maxHeight;
    final /* synthetic */ float $minHeight;
    final /* synthetic */ SearchBarState $state;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SearchBarKt$DockedSearchBarLayout$2$2$1(SearchBarState searchBarState, float f, float f2) {
        this.$state = searchBarState;
        this.$maxHeight = f;
        this.$minHeight = f2;
    }

    @Override // androidx.compose.ui.layout.MultiContentMeasurePolicy
    /* renamed from: measure-3p2s80s */
    public final MeasureResult mo864measure3p2s80s(MeasureScope measureScope, List<? extends List<? extends Measurable>> list, long j) {
        IntRect collapsedBounds;
        Integer valueOf;
        Integer valueOf2;
        Integer valueOf3;
        Integer num;
        List<? extends Measurable> list2 = list.get(0);
        List<? extends Measurable> list3 = list.get(1);
        collapsedBounds = SearchBarKt.getCollapsedBounds(this.$state);
        int lerp = MathHelpersKt.lerp(collapsedBounds.getHeight(), measureScope.mo458roundToPx0680j_4(this.$maxHeight), this.$state.getProgress());
        long m8226constrainN9IONVI = ConstraintsKt.m8226constrainN9IONVI(j, ConstraintsKt.Constraints$default(0, 0, RangesKt.coerceAtMost(measureScope.mo458roundToPx0680j_4(this.$minHeight), lerp), lerp, 3, null));
        long m8201copyZbe2FdA$default = Constraints.m8201copyZbe2FdA$default(m8226constrainN9IONVI, 0, 0, 0, 0, 10, null);
        ArrayList arrayList = new ArrayList(list2.size());
        int size = list2.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(list2.get(i).mo6875measureBRTryo0(m8201copyZbe2FdA$default));
        }
        final ArrayList arrayList2 = arrayList;
        if (arrayList2.isEmpty()) {
            valueOf = null;
        } else {
            valueOf = Integer.valueOf(((Placeable) arrayList2.get(0)).getWidth());
            int lastIndex = CollectionsKt.getLastIndex(arrayList2);
            if (1 <= lastIndex) {
                int i2 = 1;
                while (true) {
                    Integer valueOf4 = Integer.valueOf(((Placeable) arrayList2.get(i2)).getWidth());
                    if (valueOf4.compareTo(valueOf) > 0) {
                        valueOf = valueOf4;
                    }
                    if (i2 == lastIndex) {
                        break;
                    }
                    i2++;
                }
            }
        }
        Integer num2 = valueOf;
        int intValue = num2 != null ? num2.intValue() : 0;
        if (arrayList2.isEmpty()) {
            valueOf2 = null;
        } else {
            valueOf2 = Integer.valueOf(((Placeable) arrayList2.get(0)).getHeight());
            int lastIndex2 = CollectionsKt.getLastIndex(arrayList2);
            if (1 <= lastIndex2) {
                int i3 = 1;
                while (true) {
                    Integer valueOf5 = Integer.valueOf(((Placeable) arrayList2.get(i3)).getHeight());
                    if (valueOf5.compareTo(valueOf2) > 0) {
                        valueOf2 = valueOf5;
                    }
                    if (i3 == lastIndex2) {
                        break;
                    }
                    i3++;
                }
            }
        }
        Integer num3 = valueOf2;
        final int intValue2 = num3 != null ? num3.intValue() : 0;
        long m8201copyZbe2FdA$default2 = Constraints.m8201copyZbe2FdA$default(ConstraintsKt.m8231offsetNN6EwU$default(m8201copyZbe2FdA$default, 0, -intValue2, 1, null), 0, intValue, 0, 0, 13, null);
        ArrayList arrayList3 = new ArrayList(list3.size());
        int size2 = list3.size();
        for (int i4 = 0; i4 < size2; i4++) {
            arrayList3.add(list3.get(i4).mo6875measureBRTryo0(m8201copyZbe2FdA$default2));
        }
        final ArrayList arrayList4 = arrayList3;
        if (arrayList4.isEmpty()) {
            valueOf3 = null;
        } else {
            valueOf3 = Integer.valueOf(((Placeable) arrayList4.get(0)).getHeight());
            int lastIndex3 = CollectionsKt.getLastIndex(arrayList4);
            if (1 <= lastIndex3) {
                int i5 = 1;
                while (true) {
                    Integer valueOf6 = Integer.valueOf(((Placeable) arrayList4.get(i5)).getHeight());
                    if (valueOf6.compareTo(valueOf3) > 0) {
                        valueOf3 = valueOf6;
                    }
                    if (i5 == lastIndex3) {
                        break;
                    }
                    i5++;
                }
            }
        }
        Integer num4 = valueOf3;
        int intValue3 = (num4 != null ? num4.intValue() : 0) + intValue2;
        if (arrayList4.isEmpty()) {
            num = null;
        } else {
            Integer valueOf7 = Integer.valueOf(((Placeable) arrayList4.get(0)).getWidth());
            int lastIndex4 = CollectionsKt.getLastIndex(arrayList4);
            if (1 <= lastIndex4) {
                Integer num5 = valueOf7;
                int i6 = 1;
                while (true) {
                    Integer valueOf8 = Integer.valueOf(((Placeable) arrayList4.get(i6)).getWidth());
                    if (valueOf8.compareTo(num5) > 0) {
                        num5 = valueOf8;
                    }
                    if (i6 == lastIndex4) {
                        break;
                    }
                    i6++;
                }
                num = num5;
            } else {
                num = valueOf7;
            }
        }
        Integer num6 = num;
        return MeasureScope.layout$default(measureScope, ConstraintsKt.m8228constrainWidthK40F9xA(m8226constrainN9IONVI, Math.max(intValue, num6 != null ? num6.intValue() : 0)), ConstraintsKt.m8227constrainHeightK40F9xA(m8226constrainN9IONVI, intValue3), null, new Function1() { // from class: androidx.compose.material3.SearchBarKt$DockedSearchBarLayout$2$2$1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit measure_3p2s80s$lambda$8;
                measure_3p2s80s$lambda$8 = SearchBarKt$DockedSearchBarLayout$2$2$1.measure_3p2s80s$lambda$8(arrayList2, arrayList4, intValue2, (Placeable.PlacementScope) obj);
                return measure_3p2s80s$lambda$8;
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measure_3p2s80s$lambda$8(List list, List list2, int i, Placeable.PlacementScope placementScope) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            Placeable.PlacementScope.place$default(placementScope, (Placeable) list.get(i2), 0, 0, 0.0f, 4, null);
        }
        int size2 = list2.size();
        for (int i3 = 0; i3 < size2; i3++) {
            Placeable.PlacementScope.place$default(placementScope, (Placeable) list2.get(i3), 0, i, 0.0f, 4, null);
        }
        return Unit.INSTANCE;
    }
}
