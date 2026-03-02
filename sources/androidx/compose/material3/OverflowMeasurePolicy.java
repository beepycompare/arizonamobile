package androidx.compose.material3;

import androidx.compose.material3.internal.LayoutUtilKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.MultiContentMeasurePolicy;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: AppBarDsl.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ/\u0010\f\u001a\u00020\r*\u00020\u000e2\u0012\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Landroidx/compose/material3/OverflowMeasurePolicy;", "Landroidx/compose/ui/layout/MultiContentMeasurePolicy;", "overflowState", "Landroidx/compose/material3/AppBarOverflowState;", "maxItemCount", "", "isVertical", "", "<init>", "(Landroidx/compose/material3/AppBarOverflowState;IZ)V", "getMaxItemCount", "()I", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class OverflowMeasurePolicy implements MultiContentMeasurePolicy {
    public static final int $stable = 0;
    private final boolean isVertical;
    private final int maxItemCount;
    private final AppBarOverflowState overflowState;

    public OverflowMeasurePolicy(AppBarOverflowState appBarOverflowState, int i, boolean z) {
        this.overflowState = appBarOverflowState;
        this.maxItemCount = i;
        this.isVertical = z;
    }

    public /* synthetic */ OverflowMeasurePolicy(AppBarOverflowState appBarOverflowState, int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(appBarOverflowState, i, (i2 & 4) != 0 ? false : z);
    }

    public final int getMaxItemCount() {
        return this.maxItemCount;
    }

    @Override // androidx.compose.ui.layout.MultiContentMeasurePolicy
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo762measure3p2s80s(MeasureScope measureScope, List<? extends List<? extends Measurable>> list, long j) {
        Integer valueOf;
        int intValue;
        int i;
        final ArrayList arrayList;
        final ArrayList arrayList2;
        Integer valueOf2;
        int intValue2;
        Integer valueOf3;
        int max;
        Integer valueOf4;
        Integer valueOf5;
        Integer valueOf6;
        Integer valueOf7;
        long m7498copyZbe2FdA$default;
        Integer valueOf8;
        int i2 = 0;
        long m7498copyZbe2FdA$default2 = Constraints.m7498copyZbe2FdA$default(j, 0, 0, 0, 0, 10, null);
        List<? extends Measurable> list2 = list.get(0);
        int i3 = 1;
        List<? extends Measurable> list3 = list.get(1);
        this.overflowState.setTotalItemCount(list2.size());
        if (this.isVertical) {
            if (list3.isEmpty()) {
                valueOf8 = null;
            } else {
                valueOf8 = Integer.valueOf(list3.get(0).maxIntrinsicHeight(Constraints.m7508getMaxWidthimpl(j)));
                int lastIndex = CollectionsKt.getLastIndex(list3);
                if (1 <= lastIndex) {
                    int i4 = 1;
                    while (true) {
                        Integer valueOf9 = Integer.valueOf(list3.get(i4).maxIntrinsicHeight(Constraints.m7508getMaxWidthimpl(j)));
                        if (valueOf9.compareTo(valueOf8) > 0) {
                            valueOf8 = valueOf9;
                        }
                        if (i4 == lastIndex) {
                            break;
                        }
                        i4++;
                    }
                }
            }
            Integer num = valueOf8;
            if (num != null) {
                intValue = num.intValue();
            }
            intValue = 0;
        } else {
            if (list3.isEmpty()) {
                valueOf = null;
            } else {
                valueOf = Integer.valueOf(list3.get(0).maxIntrinsicWidth(Constraints.m7507getMaxHeightimpl(j)));
                int lastIndex2 = CollectionsKt.getLastIndex(list3);
                if (1 <= lastIndex2) {
                    int i5 = 1;
                    while (true) {
                        Integer valueOf10 = Integer.valueOf(list3.get(i5).maxIntrinsicWidth(Constraints.m7507getMaxHeightimpl(j)));
                        if (valueOf10.compareTo(valueOf) > 0) {
                            valueOf = valueOf10;
                        }
                        if (i5 == lastIndex2) {
                            break;
                        }
                        i5++;
                    }
                }
            }
            Integer num2 = valueOf;
            if (num2 != null) {
                intValue = num2.intValue();
            }
            intValue = 0;
        }
        int subtractConstraintSafely = LayoutUtilKt.subtractConstraintSafely(this.isVertical ? Constraints.m7507getMaxHeightimpl(j) : Constraints.m7508getMaxWidthimpl(j), intValue);
        ArrayList arrayList3 = new ArrayList();
        int size = list2.size();
        int i6 = 0;
        int i7 = 0;
        while (true) {
            if (i6 >= size) {
                i = i3;
                break;
            }
            Placeable mo6216measureBRTryo0 = list2.get(i6).mo6216measureBRTryo0(m7498copyZbe2FdA$default2);
            int i8 = i6 == CollectionsKt.getLastIndex(list2) ? i3 : 0;
            i = i3;
            if (i8 == 0 && i6 == this.maxItemCount - 1) {
                break;
            }
            int height = this.isVertical ? mo6216measureBRTryo0.getHeight() : mo6216measureBRTryo0.getWidth();
            if (height > subtractConstraintSafely && (i8 == 0 || height > subtractConstraintSafely + intValue)) {
                break;
            }
            arrayList3.add(mo6216measureBRTryo0);
            i7 += height;
            subtractConstraintSafely = LayoutUtilKt.subtractConstraintSafely(subtractConstraintSafely, height);
            i6++;
            i3 = i;
        }
        this.overflowState.setVisibleItemCount(arrayList3.size());
        if (arrayList3.size() != list2.size()) {
            if (this.isVertical) {
                arrayList = arrayList3;
                m7498copyZbe2FdA$default = Constraints.m7498copyZbe2FdA$default(m7498copyZbe2FdA$default2, 0, 0, 0, subtractConstraintSafely + intValue, 7, null);
            } else {
                arrayList = arrayList3;
                m7498copyZbe2FdA$default = Constraints.m7498copyZbe2FdA$default(m7498copyZbe2FdA$default2, 0, subtractConstraintSafely + intValue, 0, 0, 13, null);
            }
            ArrayList arrayList4 = new ArrayList(list3.size());
            int size2 = list3.size();
            for (int i9 = 0; i9 < size2; i9++) {
                arrayList4.add(list3.get(i9).mo6216measureBRTryo0(m7498copyZbe2FdA$default));
            }
            arrayList2 = arrayList4;
        } else {
            arrayList = arrayList3;
            arrayList2 = null;
        }
        if (this.isVertical) {
            if (arrayList2 != null) {
                if (arrayList2.isEmpty()) {
                    valueOf7 = null;
                } else {
                    valueOf7 = Integer.valueOf(((Placeable) arrayList2.get(0)).getHeight());
                    int lastIndex3 = CollectionsKt.getLastIndex(arrayList2);
                    if (i <= lastIndex3) {
                        int i10 = 1;
                        while (true) {
                            Integer valueOf11 = Integer.valueOf(((Placeable) arrayList2.get(i10)).getHeight());
                            if (valueOf11.compareTo(valueOf7) > 0) {
                                valueOf7 = valueOf11;
                            }
                            if (i10 == lastIndex3) {
                                break;
                            }
                            i10++;
                        }
                    }
                }
                Integer num3 = valueOf7;
                if (num3 != null) {
                    intValue2 = num3.intValue();
                }
            }
            intValue2 = 0;
        } else {
            if (arrayList2 != null) {
                if (arrayList2.isEmpty()) {
                    valueOf2 = null;
                } else {
                    valueOf2 = Integer.valueOf(((Placeable) arrayList2.get(0)).getWidth());
                    int lastIndex4 = CollectionsKt.getLastIndex(arrayList2);
                    if (1 <= lastIndex4) {
                        int i11 = 1;
                        while (true) {
                            Integer valueOf12 = Integer.valueOf(((Placeable) arrayList2.get(i11)).getWidth());
                            if (valueOf12.compareTo(valueOf2) > 0) {
                                valueOf2 = valueOf12;
                            }
                            if (i11 == lastIndex4) {
                                break;
                            }
                            i11++;
                        }
                    }
                }
                Integer num4 = valueOf2;
                if (num4 != null) {
                    intValue2 = num4.intValue();
                }
            }
            intValue2 = 0;
        }
        int i12 = i7 + intValue2;
        if (this.isVertical) {
            if (arrayList.isEmpty()) {
                valueOf5 = null;
            } else {
                valueOf5 = Integer.valueOf(((Placeable) arrayList.get(0)).getWidth());
                int lastIndex5 = CollectionsKt.getLastIndex(arrayList);
                if (1 <= lastIndex5) {
                    int i13 = 1;
                    while (true) {
                        Integer valueOf13 = Integer.valueOf(((Placeable) arrayList.get(i13)).getWidth());
                        if (valueOf13.compareTo(valueOf5) > 0) {
                            valueOf5 = valueOf13;
                        }
                        if (i13 == lastIndex5) {
                            break;
                        }
                        i13++;
                    }
                }
            }
            Integer num5 = valueOf5;
            int intValue3 = num5 != null ? num5.intValue() : 0;
            if (arrayList2 != null) {
                if (arrayList2.isEmpty()) {
                    valueOf6 = null;
                } else {
                    valueOf6 = Integer.valueOf(((Placeable) arrayList2.get(0)).getWidth());
                    int lastIndex6 = CollectionsKt.getLastIndex(arrayList2);
                    if (1 <= lastIndex6) {
                        Integer num6 = valueOf6;
                        int i14 = 1;
                        while (true) {
                            Integer valueOf14 = Integer.valueOf(((Placeable) arrayList2.get(i14)).getWidth());
                            if (valueOf14.compareTo(num6) > 0) {
                                num6 = valueOf14;
                            }
                            if (i14 == lastIndex6) {
                                break;
                            }
                            i14++;
                        }
                        valueOf6 = num6;
                    }
                }
                Integer num7 = valueOf6;
                if (num7 != null) {
                    i2 = num7.intValue();
                }
            }
            max = Math.max(intValue3, i2);
        } else {
            if (arrayList.isEmpty()) {
                valueOf3 = null;
            } else {
                valueOf3 = Integer.valueOf(((Placeable) arrayList.get(0)).getHeight());
                int lastIndex7 = CollectionsKt.getLastIndex(arrayList);
                if (1 <= lastIndex7) {
                    int i15 = 1;
                    while (true) {
                        Integer valueOf15 = Integer.valueOf(((Placeable) arrayList.get(i15)).getHeight());
                        if (valueOf15.compareTo(valueOf3) > 0) {
                            valueOf3 = valueOf15;
                        }
                        if (i15 == lastIndex7) {
                            break;
                        }
                        i15++;
                    }
                }
            }
            Integer num8 = valueOf3;
            int intValue4 = num8 != null ? num8.intValue() : 0;
            if (arrayList2 != null) {
                if (arrayList2.isEmpty()) {
                    valueOf4 = null;
                } else {
                    valueOf4 = Integer.valueOf(((Placeable) arrayList2.get(0)).getHeight());
                    int lastIndex8 = CollectionsKt.getLastIndex(arrayList2);
                    int i16 = 1;
                    if (1 <= lastIndex8) {
                        while (true) {
                            Integer valueOf16 = Integer.valueOf(((Placeable) arrayList2.get(i16)).getHeight());
                            if (valueOf16.compareTo(valueOf4) > 0) {
                                valueOf4 = valueOf16;
                            }
                            if (i16 == lastIndex8) {
                                break;
                            }
                            i16++;
                        }
                    }
                }
                Integer num9 = valueOf4;
                if (num9 != null) {
                    i2 = num9.intValue();
                }
            }
            max = Math.max(intValue4, i2);
        }
        if (this.isVertical) {
            return MeasureScope.layout$default(measureScope, ConstraintsKt.m7525constrainWidthK40F9xA(j, max), ConstraintsKt.m7524constrainHeightK40F9xA(j, i12), null, new Function1() { // from class: androidx.compose.material3.OverflowMeasurePolicy$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return OverflowMeasurePolicy.measure_3p2s80s$lambda$11(arrayList, arrayList2, (Placeable.PlacementScope) obj);
                }
            }, 4, null);
        }
        return MeasureScope.layout$default(measureScope, ConstraintsKt.m7525constrainWidthK40F9xA(j, i12), ConstraintsKt.m7524constrainHeightK40F9xA(j, max), null, new Function1() { // from class: androidx.compose.material3.OverflowMeasurePolicy$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return OverflowMeasurePolicy.measure_3p2s80s$lambda$14(arrayList, arrayList2, (Placeable.PlacementScope) obj);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit measure_3p2s80s$lambda$11(List list, List list2, Placeable.PlacementScope placementScope) {
        int size = list.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            Placeable placeable = (Placeable) list.get(i);
            Placeable.PlacementScope placementScope2 = placementScope;
            Placeable.PlacementScope.placeRelative$default(placementScope2, placeable, 0, i2, 0.0f, 4, null);
            i2 += placeable.getHeight();
            i++;
            placementScope = placementScope2;
        }
        Placeable.PlacementScope placementScope3 = placementScope;
        if (list2 != null) {
            int size2 = list2.size();
            for (int i3 = 0; i3 < size2; i3++) {
                Placeable.PlacementScope.placeRelative$default(placementScope3, (Placeable) list2.get(i3), 0, i2, 0.0f, 4, null);
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit measure_3p2s80s$lambda$14(List list, List list2, Placeable.PlacementScope placementScope) {
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
        Placeable.PlacementScope placementScope3 = placementScope;
        if (list2 != null) {
            int size2 = list2.size();
            for (int i3 = 0; i3 < size2; i3++) {
                Placeable.PlacementScope.placeRelative$default(placementScope3, (Placeable) list2.get(i3), i2, 0, 0.0f, 4, null);
            }
        }
        return Unit.INSTANCE;
    }
}
