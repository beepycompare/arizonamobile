package androidx.compose.material3;

import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.MultiContentMeasurePolicy;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.math.MathKt;
/* compiled from: BottomSheetScaffold.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
final class BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1 implements MultiContentMeasurePolicy {
    final /* synthetic */ Function0<Float> $sheetOffset;
    final /* synthetic */ SheetState $sheetState;

    /* compiled from: BottomSheetScaffold.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SheetValue.values().length];
            try {
                iArr[SheetValue.PartiallyExpanded.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SheetValue.Expanded.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SheetValue.Hidden.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1(SheetState sheetState, Function0<Float> function0) {
        this.$sheetState = sheetState;
        this.$sheetOffset = function0;
    }

    @Override // androidx.compose.ui.layout.MultiContentMeasurePolicy
    /* renamed from: measure-3p2s80s */
    public final MeasureResult mo762measure3p2s80s(MeasureScope measureScope, List<? extends List<? extends Measurable>> list, long j) {
        Integer valueOf;
        List<? extends Measurable> list2 = list.get(0);
        int i = 1;
        List<? extends Measurable> list3 = list.get(1);
        List<? extends Measurable> list4 = list.get(2);
        List<? extends Measurable> list5 = list.get(3);
        final int m7508getMaxWidthimpl = Constraints.m7508getMaxWidthimpl(j);
        final int m7507getMaxHeightimpl = Constraints.m7507getMaxHeightimpl(j);
        long m7498copyZbe2FdA$default = Constraints.m7498copyZbe2FdA$default(j, 0, 0, 0, 0, 10, null);
        ArrayList arrayList = new ArrayList(list4.size());
        int size = list4.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(list4.get(i2).mo6216measureBRTryo0(m7498copyZbe2FdA$default));
        }
        final ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(list2.size());
        int size2 = list2.size();
        for (int i3 = 0; i3 < size2; i3++) {
            arrayList3.add(list2.get(i3).mo6216measureBRTryo0(m7498copyZbe2FdA$default));
        }
        final ArrayList arrayList4 = arrayList3;
        if (arrayList4.isEmpty()) {
            valueOf = null;
        } else {
            valueOf = Integer.valueOf(((Placeable) arrayList4.get(0)).getHeight());
            int lastIndex = CollectionsKt.getLastIndex(arrayList4);
            if (1 <= lastIndex) {
                while (true) {
                    Integer valueOf2 = Integer.valueOf(((Placeable) arrayList4.get(i)).getHeight());
                    if (valueOf2.compareTo(valueOf) > 0) {
                        valueOf = valueOf2;
                    }
                    if (i == lastIndex) {
                        break;
                    }
                    i++;
                }
            }
        }
        Integer num = valueOf;
        final int intValue = num != null ? num.intValue() : 0;
        long m7498copyZbe2FdA$default2 = Constraints.m7498copyZbe2FdA$default(m7498copyZbe2FdA$default, 0, 0, 0, m7507getMaxHeightimpl - intValue, 7, null);
        ArrayList arrayList5 = new ArrayList(list3.size());
        int size3 = list3.size();
        for (int i4 = 0; i4 < size3; i4++) {
            arrayList5.add(list3.get(i4).mo6216measureBRTryo0(m7498copyZbe2FdA$default2));
        }
        final ArrayList arrayList6 = arrayList5;
        ArrayList arrayList7 = new ArrayList(list5.size());
        int size4 = list5.size();
        for (int i5 = 0; i5 < size4; i5++) {
            arrayList7.add(list5.get(i5).mo6216measureBRTryo0(m7498copyZbe2FdA$default));
        }
        final ArrayList arrayList8 = arrayList7;
        final SheetState sheetState = this.$sheetState;
        final Function0<Float> function0 = this.$sheetOffset;
        return MeasureScope.layout$default(measureScope, m7508getMaxWidthimpl, m7507getMaxHeightimpl, null, new Function1() { // from class: androidx.compose.material3.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1.measure_3p2s80s$lambda$12(arrayList2, m7508getMaxWidthimpl, arrayList8, sheetState, function0, m7507getMaxHeightimpl, arrayList6, arrayList4, intValue, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit measure_3p2s80s$lambda$12(List list, int i, List list2, SheetState sheetState, Function0 function0, int i2, List list3, List list4, int i3, Placeable.PlacementScope placementScope) {
        Integer valueOf;
        Integer valueOf2;
        int roundToInt;
        Integer num = null;
        if (list.isEmpty()) {
            valueOf = null;
        } else {
            valueOf = Integer.valueOf(((Placeable) list.get(0)).getWidth());
            int lastIndex = CollectionsKt.getLastIndex(list);
            if (1 <= lastIndex) {
                int i4 = 1;
                while (true) {
                    Integer valueOf3 = Integer.valueOf(((Placeable) list.get(i4)).getWidth());
                    if (valueOf3.compareTo(valueOf) > 0) {
                        valueOf = valueOf3;
                    }
                    if (i4 == lastIndex) {
                        break;
                    }
                    i4++;
                }
            }
        }
        Integer num2 = valueOf;
        int max = Math.max(0, (i - (num2 != null ? num2.intValue() : 0)) / 2);
        if (list2.isEmpty()) {
            valueOf2 = null;
        } else {
            valueOf2 = Integer.valueOf(((Placeable) list2.get(0)).getWidth());
            int lastIndex2 = CollectionsKt.getLastIndex(list2);
            if (1 <= lastIndex2) {
                int i5 = 1;
                while (true) {
                    Integer valueOf4 = Integer.valueOf(((Placeable) list2.get(i5)).getWidth());
                    if (valueOf4.compareTo(valueOf2) > 0) {
                        valueOf2 = valueOf4;
                    }
                    if (i5 == lastIndex2) {
                        break;
                    }
                    i5++;
                }
            }
        }
        Integer num3 = valueOf2;
        int intValue = num3 != null ? num3.intValue() : 0;
        if (!list2.isEmpty()) {
            num = Integer.valueOf(((Placeable) list2.get(0)).getHeight());
            int lastIndex3 = CollectionsKt.getLastIndex(list2);
            if (1 <= lastIndex3) {
                int i6 = 1;
                while (true) {
                    Integer valueOf5 = Integer.valueOf(((Placeable) list2.get(i6)).getHeight());
                    if (valueOf5.compareTo(num) > 0) {
                        num = valueOf5;
                    }
                    if (i6 == lastIndex3) {
                        break;
                    }
                    i6++;
                }
            }
        }
        Integer num4 = num;
        int intValue2 = num4 != null ? num4.intValue() : 0;
        int i7 = (i - intValue) / 2;
        int i8 = WhenMappings.$EnumSwitchMapping$0[sheetState.getCurrentValue().ordinal()];
        if (i8 == 1) {
            roundToInt = MathKt.roundToInt(((Number) function0.invoke()).floatValue()) - intValue2;
        } else if (i8 != 2 && i8 != 3) {
            throw new NoWhenBranchMatchedException();
        } else {
            roundToInt = i2 - intValue2;
        }
        int size = list3.size();
        for (int i9 = 0; i9 < size; i9++) {
            Placeable.PlacementScope.placeRelative$default(placementScope, (Placeable) list3.get(i9), 0, i3, 0.0f, 4, null);
        }
        int size2 = list4.size();
        for (int i10 = 0; i10 < size2; i10++) {
            Placeable.PlacementScope.placeRelative$default(placementScope, (Placeable) list4.get(i10), 0, 0, 0.0f, 4, null);
        }
        int size3 = list.size();
        for (int i11 = 0; i11 < size3; i11++) {
            Placeable.PlacementScope.placeRelative$default(placementScope, (Placeable) list.get(i11), max, 0, 0.0f, 4, null);
        }
        int size4 = list2.size();
        for (int i12 = 0; i12 < size4; i12++) {
            Placeable.PlacementScope.placeRelative$default(placementScope, (Placeable) list2.get(i12), i7, roundToInt, 0.0f, 4, null);
        }
        return Unit.INSTANCE;
    }
}
