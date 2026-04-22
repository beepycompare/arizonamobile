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
    public final MeasureResult mo762measure3p2s80s(MeasureScope measureScope, List<? extends List<? extends Measurable>> list, long j) {
        IntRect collapsedBounds;
        Integer valueOf;
        Integer valueOf2;
        Integer valueOf3;
        Integer num;
        List<? extends Measurable> list2 = list.get(0);
        int i = 1;
        List<? extends Measurable> list3 = list.get(1);
        collapsedBounds = SearchBarKt.getCollapsedBounds(this.$state);
        int lerp = MathHelpersKt.lerp(collapsedBounds.getHeight(), measureScope.mo399roundToPx0680j_4(this.$maxHeight), this.$state.getProgress());
        long m7523constrainN9IONVI = ConstraintsKt.m7523constrainN9IONVI(j, ConstraintsKt.Constraints$default(0, 0, RangesKt.coerceAtMost(measureScope.mo399roundToPx0680j_4(this.$minHeight), lerp), lerp, 3, null));
        long m7498copyZbe2FdA$default = Constraints.m7498copyZbe2FdA$default(m7523constrainN9IONVI, 0, 0, 0, 0, 10, null);
        ArrayList arrayList = new ArrayList(list2.size());
        int size = list2.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(list2.get(i2).mo6216measureBRTryo0(m7498copyZbe2FdA$default));
        }
        final ArrayList arrayList2 = arrayList;
        if (arrayList2.isEmpty()) {
            valueOf = null;
        } else {
            valueOf = Integer.valueOf(((Placeable) arrayList2.get(0)).getWidth());
            int lastIndex = CollectionsKt.getLastIndex(arrayList2);
            if (1 <= lastIndex) {
                int i3 = 1;
                while (true) {
                    Integer valueOf4 = Integer.valueOf(((Placeable) arrayList2.get(i3)).getWidth());
                    if (valueOf4.compareTo(valueOf) > 0) {
                        valueOf = valueOf4;
                    }
                    if (i3 == lastIndex) {
                        break;
                    }
                    i3++;
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
                int i4 = 1;
                while (true) {
                    Integer valueOf5 = Integer.valueOf(((Placeable) arrayList2.get(i4)).getHeight());
                    if (valueOf5.compareTo(valueOf2) > 0) {
                        valueOf2 = valueOf5;
                    }
                    if (i4 == lastIndex2) {
                        break;
                    }
                    i4++;
                }
            }
        }
        Integer num3 = valueOf2;
        final int intValue2 = num3 != null ? num3.intValue() : 0;
        long m7498copyZbe2FdA$default2 = Constraints.m7498copyZbe2FdA$default(ConstraintsKt.m7528offsetNN6EwU$default(m7498copyZbe2FdA$default, 0, -intValue2, 1, null), 0, intValue, 0, 0, 13, null);
        ArrayList arrayList3 = new ArrayList(list3.size());
        int size2 = list3.size();
        for (int i5 = 0; i5 < size2; i5++) {
            arrayList3.add(list3.get(i5).mo6216measureBRTryo0(m7498copyZbe2FdA$default2));
        }
        final ArrayList arrayList4 = arrayList3;
        if (arrayList4.isEmpty()) {
            valueOf3 = null;
        } else {
            valueOf3 = Integer.valueOf(((Placeable) arrayList4.get(0)).getHeight());
            int lastIndex3 = CollectionsKt.getLastIndex(arrayList4);
            if (1 <= lastIndex3) {
                int i6 = 1;
                while (true) {
                    Integer valueOf6 = Integer.valueOf(((Placeable) arrayList4.get(i6)).getHeight());
                    if (valueOf6.compareTo(valueOf3) > 0) {
                        valueOf3 = valueOf6;
                    }
                    if (i6 == lastIndex3) {
                        break;
                    }
                    i6++;
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
                while (true) {
                    Integer valueOf8 = Integer.valueOf(((Placeable) arrayList4.get(i)).getWidth());
                    if (valueOf8.compareTo(valueOf7) > 0) {
                        valueOf7 = valueOf8;
                    }
                    if (i == lastIndex4) {
                        break;
                    }
                    i++;
                }
            }
            num = valueOf7;
        }
        Integer num5 = num;
        return MeasureScope.layout$default(measureScope, ConstraintsKt.m7525constrainWidthK40F9xA(m7523constrainN9IONVI, Math.max(intValue, num5 != null ? num5.intValue() : 0)), ConstraintsKt.m7524constrainHeightK40F9xA(m7523constrainN9IONVI, intValue3), null, new Function1() { // from class: androidx.compose.material3.SearchBarKt$DockedSearchBarLayout$2$2$1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SearchBarKt$DockedSearchBarLayout$2$2$1.measure_3p2s80s$lambda$8(arrayList2, arrayList4, intValue2, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
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
