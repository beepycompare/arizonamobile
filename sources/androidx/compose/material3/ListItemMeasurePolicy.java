package androidx.compose.material3;

import androidx.compose.material3.internal.LayoutUtilKt;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.MultiContentMeasurePolicy;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ListItem.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J/\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ(\u0010\u000e\u001a\u00020\u000f*\u00020\u00102\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\b0\b2\u0006\u0010\u0012\u001a\u00020\u000fH\u0016J(\u0010\u0013\u001a\u00020\u000f*\u00020\u00102\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\b0\b2\u0006\u0010\u0014\u001a\u00020\u000fH\u0016J(\u0010\u0015\u001a\u00020\u000f*\u00020\u00102\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\b0\b2\u0006\u0010\u0012\u001a\u00020\u000fH\u0016J(\u0010\u0016\u001a\u00020\u000f*\u00020\u00102\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\b0\b2\u0006\u0010\u0014\u001a\u00020\u000fH\u0016JV\u0010\u0017\u001a\u00020\u000f*\u00020\u00102\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\b0\b2\u0006\u0010\u0014\u001a\u00020\u000f2,\u0010\u0018\u001a(\u0012\u0004\u0012\u00020\u0011\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u000f0\u0019¢\u0006\u0002\b\u001cH\u0002JV\u0010\u001d\u001a\u00020\u000f*\u00020\u00102\u0012\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\b0\b2\u0006\u0010\u0012\u001a\u00020\u000f2,\u0010\u0018\u001a(\u0012\u0004\u0012\u00020\u0011\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u000f0\u0019¢\u0006\u0002\b\u001cH\u0002¨\u0006\u001e"}, d2 = {"Landroidx/compose/material3/ListItemMeasurePolicy;", "Landroidx/compose/ui/layout/MultiContentMeasurePolicy;", "<init>", "()V", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "minIntrinsicHeight", "minIntrinsicWidth", "calculateIntrinsicWidth", "intrinsicMeasure", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "Lkotlin/ExtensionFunctionType;", "calculateIntrinsicHeight", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ListItemMeasurePolicy implements MultiContentMeasurePolicy {
    @Override // androidx.compose.ui.layout.MultiContentMeasurePolicy
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo762measure3p2s80s(MeasureScope measureScope, List<? extends List<? extends Measurable>> list, long j) {
        boolean isSupportingMultilineHeuristic;
        float m2220verticalPaddingyh95HIg;
        long j2;
        Placeable placeable;
        List<? extends Measurable> list2;
        long j3;
        Placeable placeable2;
        float f;
        Placeable placeable3;
        float m2220verticalPaddingyh95HIg2;
        int m2219calculateWidthyeHjK3Y;
        int m2218calculateHeightN4Jib3Y;
        MeasureResult place;
        List<? extends Measurable> list3 = list.get(0);
        List<? extends Measurable> list4 = list.get(1);
        List<? extends Measurable> list5 = list.get(2);
        List<? extends Measurable> list6 = list.get(3);
        List<? extends Measurable> list7 = list.get(4);
        long m7498copyZbe2FdA$default = Constraints.m7498copyZbe2FdA$default(j, 0, 0, 0, 0, 10, null);
        float listItemStartPadding = ListItemKt.getListItemStartPadding();
        float listItemEndPadding = ListItemKt.getListItemEndPadding();
        int i = measureScope.mo399roundToPx0680j_4(Dp.m7555constructorimpl(listItemStartPadding + listItemEndPadding));
        Measurable measurable = (Measurable) CollectionsKt.firstOrNull((List<? extends Object>) list6);
        int minIntrinsicWidth = measurable != null ? measurable.minIntrinsicWidth(Constraints.m7507getMaxHeightimpl(j)) : 0;
        Measurable measurable2 = (Measurable) CollectionsKt.firstOrNull((List<? extends Object>) list7);
        int subtractConstraintSafely = LayoutUtilKt.subtractConstraintSafely(Constraints.m7508getMaxWidthimpl(m7498copyZbe2FdA$default), minIntrinsicWidth + (measurable2 != null ? measurable2.minIntrinsicWidth(Constraints.m7507getMaxHeightimpl(j)) : 0) + i);
        Measurable measurable3 = (Measurable) CollectionsKt.firstOrNull((List<? extends Object>) list5);
        isSupportingMultilineHeuristic = ListItemKt.isSupportingMultilineHeuristic(measureScope, measurable3 != null ? measurable3.minIntrinsicHeight(subtractConstraintSafely) : 0);
        m2220verticalPaddingyh95HIg = ListItemKt.m2220verticalPaddingyh95HIg(ListItemType.Companion.m2233invokeZLSjz4$material3(CollectionsKt.firstOrNull((List<? extends Object>) list4) != null, CollectionsKt.firstOrNull((List<? extends Object>) list5) != null, isSupportingMultilineHeuristic));
        long m7527offsetNN6EwU = ConstraintsKt.m7527offsetNN6EwU(m7498copyZbe2FdA$default, -i, -measureScope.mo399roundToPx0680j_4(Dp.m7555constructorimpl(m2220verticalPaddingyh95HIg * 2.0f)));
        Measurable measurable4 = (Measurable) CollectionsKt.firstOrNull((List<? extends Object>) list6);
        Placeable mo6216measureBRTryo0 = measurable4 != null ? measurable4.mo6216measureBRTryo0(m7527offsetNN6EwU) : null;
        int widthOrZero = LayoutUtilKt.getWidthOrZero(mo6216measureBRTryo0);
        Measurable measurable5 = (Measurable) CollectionsKt.firstOrNull((List<? extends Object>) list7);
        if (measurable5 != null) {
            j2 = m7527offsetNN6EwU;
            placeable = measurable5.mo6216measureBRTryo0(ConstraintsKt.m7528offsetNN6EwU$default(j2, -widthOrZero, 0, 2, null));
        } else {
            j2 = m7527offsetNN6EwU;
            placeable = null;
        }
        int widthOrZero2 = widthOrZero + LayoutUtilKt.getWidthOrZero(placeable);
        Measurable measurable6 = (Measurable) CollectionsKt.firstOrNull((List<? extends Object>) list3);
        if (measurable6 != null) {
            list2 = list4;
            j3 = j2;
            placeable2 = measurable6.mo6216measureBRTryo0(ConstraintsKt.m7528offsetNN6EwU$default(j2, -widthOrZero2, 0, 2, null));
        } else {
            list2 = list4;
            j3 = j2;
            placeable2 = null;
        }
        int heightOrZero = LayoutUtilKt.getHeightOrZero(placeable2);
        Measurable measurable7 = (Measurable) CollectionsKt.firstOrNull((List<? extends Object>) list5);
        if (measurable7 != null) {
            f = listItemStartPadding;
            placeable3 = measurable7.mo6216measureBRTryo0(ConstraintsKt.m7527offsetNN6EwU(j3, -widthOrZero2, -heightOrZero));
        } else {
            f = listItemStartPadding;
            placeable3 = null;
        }
        int heightOrZero2 = heightOrZero + LayoutUtilKt.getHeightOrZero(placeable3);
        boolean z = (placeable3 == null || placeable3.get(AlignmentLineKt.getFirstBaseline()) == placeable3.get(AlignmentLineKt.getLastBaseline())) ? false : true;
        Measurable measurable8 = (Measurable) CollectionsKt.firstOrNull((List<? extends Object>) list2);
        Placeable mo6216measureBRTryo02 = measurable8 != null ? measurable8.mo6216measureBRTryo0(ConstraintsKt.m7527offsetNN6EwU(j3, -widthOrZero2, -heightOrZero2)) : null;
        int m2233invokeZLSjz4$material3 = ListItemType.Companion.m2233invokeZLSjz4$material3(mo6216measureBRTryo02 != null, placeable3 != null, z);
        m2220verticalPaddingyh95HIg2 = ListItemKt.m2220verticalPaddingyh95HIg(m2233invokeZLSjz4$material3);
        float m7555constructorimpl = Dp.m7555constructorimpl(2.0f * m2220verticalPaddingyh95HIg2);
        MeasureScope measureScope2 = measureScope;
        m2219calculateWidthyeHjK3Y = ListItemKt.m2219calculateWidthyeHjK3Y(measureScope2, LayoutUtilKt.getWidthOrZero(mo6216measureBRTryo0), LayoutUtilKt.getWidthOrZero(placeable), LayoutUtilKt.getWidthOrZero(placeable2), LayoutUtilKt.getWidthOrZero(mo6216measureBRTryo02), LayoutUtilKt.getWidthOrZero(placeable3), i, j);
        m2218calculateHeightN4Jib3Y = ListItemKt.m2218calculateHeightN4Jib3Y(measureScope2, LayoutUtilKt.getHeightOrZero(mo6216measureBRTryo0), LayoutUtilKt.getHeightOrZero(placeable), LayoutUtilKt.getHeightOrZero(placeable2), LayoutUtilKt.getHeightOrZero(mo6216measureBRTryo02), LayoutUtilKt.getHeightOrZero(placeable3), m2233invokeZLSjz4$material3, measureScope.mo399roundToPx0680j_4(m7555constructorimpl), j);
        Placeable placeable4 = placeable2;
        place = ListItemKt.place(measureScope, m2219calculateWidthyeHjK3Y, m2218calculateHeightN4Jib3Y, mo6216measureBRTryo0, placeable, placeable4, mo6216measureBRTryo02, placeable3, ListItemType.m2225equalsimpl0(m2233invokeZLSjz4$material3, ListItemType.Companion.m2231getThreeLineAlXitO8()), measureScope.mo399roundToPx0680j_4(f), measureScope.mo399roundToPx0680j_4(listItemEndPadding), measureScope.mo399roundToPx0680j_4(m2220verticalPaddingyh95HIg2));
        return place;
    }

    @Override // androidx.compose.ui.layout.MultiContentMeasurePolicy
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends List<? extends IntrinsicMeasurable>> list, int i) {
        return calculateIntrinsicHeight(intrinsicMeasureScope, list, i, ListItemMeasurePolicy$maxIntrinsicHeight$1.INSTANCE);
    }

    @Override // androidx.compose.ui.layout.MultiContentMeasurePolicy
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends List<? extends IntrinsicMeasurable>> list, int i) {
        return calculateIntrinsicWidth(intrinsicMeasureScope, list, i, ListItemMeasurePolicy$maxIntrinsicWidth$1.INSTANCE);
    }

    @Override // androidx.compose.ui.layout.MultiContentMeasurePolicy
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends List<? extends IntrinsicMeasurable>> list, int i) {
        return calculateIntrinsicHeight(intrinsicMeasureScope, list, i, ListItemMeasurePolicy$minIntrinsicHeight$1.INSTANCE);
    }

    @Override // androidx.compose.ui.layout.MultiContentMeasurePolicy
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends List<? extends IntrinsicMeasurable>> list, int i) {
        return calculateIntrinsicWidth(intrinsicMeasureScope, list, i, ListItemMeasurePolicy$minIntrinsicWidth$1.INSTANCE);
    }

    private final int calculateIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends List<? extends IntrinsicMeasurable>> list, int i, Function2<? super IntrinsicMeasurable, ? super Integer, Integer> function2) {
        int m2219calculateWidthyeHjK3Y;
        List<? extends IntrinsicMeasurable> list2 = list.get(0);
        List<? extends IntrinsicMeasurable> list3 = list.get(1);
        List<? extends IntrinsicMeasurable> list4 = list.get(2);
        List<? extends IntrinsicMeasurable> list5 = list.get(4);
        IntrinsicMeasurable intrinsicMeasurable = (IntrinsicMeasurable) CollectionsKt.firstOrNull((List<? extends Object>) list.get(3));
        int intValue = intrinsicMeasurable != null ? function2.invoke(intrinsicMeasurable, Integer.valueOf(i)).intValue() : 0;
        IntrinsicMeasurable intrinsicMeasurable2 = (IntrinsicMeasurable) CollectionsKt.firstOrNull((List<? extends Object>) list5);
        int intValue2 = intrinsicMeasurable2 != null ? function2.invoke(intrinsicMeasurable2, Integer.valueOf(i)).intValue() : 0;
        IntrinsicMeasurable intrinsicMeasurable3 = (IntrinsicMeasurable) CollectionsKt.firstOrNull((List<? extends Object>) list2);
        int intValue3 = intrinsicMeasurable3 != null ? function2.invoke(intrinsicMeasurable3, Integer.valueOf(i)).intValue() : 0;
        IntrinsicMeasurable intrinsicMeasurable4 = (IntrinsicMeasurable) CollectionsKt.firstOrNull((List<? extends Object>) list3);
        int intValue4 = intrinsicMeasurable4 != null ? function2.invoke(intrinsicMeasurable4, Integer.valueOf(i)).intValue() : 0;
        IntrinsicMeasurable intrinsicMeasurable5 = (IntrinsicMeasurable) CollectionsKt.firstOrNull((List<? extends Object>) list4);
        m2219calculateWidthyeHjK3Y = ListItemKt.m2219calculateWidthyeHjK3Y(intrinsicMeasureScope, intValue, intValue2, intValue3, intValue4, intrinsicMeasurable5 != null ? function2.invoke(intrinsicMeasurable5, Integer.valueOf(i)).intValue() : 0, intrinsicMeasureScope.mo399roundToPx0680j_4(Dp.m7555constructorimpl(ListItemKt.getListItemStartPadding() + ListItemKt.getListItemEndPadding())), ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, null));
        return m2219calculateWidthyeHjK3Y;
    }

    private final int calculateIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends List<? extends IntrinsicMeasurable>> list, int i, Function2<? super IntrinsicMeasurable, ? super Integer, Integer> function2) {
        int i2;
        int i3;
        boolean isSupportingMultilineHeuristic;
        float m2220verticalPaddingyh95HIg;
        int m2218calculateHeightN4Jib3Y;
        List<? extends IntrinsicMeasurable> list2 = list.get(0);
        List<? extends IntrinsicMeasurable> list3 = list.get(1);
        List<? extends IntrinsicMeasurable> list4 = list.get(2);
        List<? extends IntrinsicMeasurable> list5 = list.get(4);
        int subtractConstraintSafely = LayoutUtilKt.subtractConstraintSafely(i, intrinsicMeasureScope.mo399roundToPx0680j_4(Dp.m7555constructorimpl(ListItemKt.getListItemStartPadding() + ListItemKt.getListItemEndPadding())));
        IntrinsicMeasurable intrinsicMeasurable = (IntrinsicMeasurable) CollectionsKt.firstOrNull((List<? extends Object>) list.get(3));
        if (intrinsicMeasurable != null) {
            i2 = function2.invoke(intrinsicMeasurable, Integer.valueOf(subtractConstraintSafely)).intValue();
            subtractConstraintSafely = LayoutUtilKt.subtractConstraintSafely(subtractConstraintSafely, intrinsicMeasurable.maxIntrinsicWidth(Integer.MAX_VALUE));
        } else {
            i2 = 0;
        }
        IntrinsicMeasurable intrinsicMeasurable2 = (IntrinsicMeasurable) CollectionsKt.firstOrNull((List<? extends Object>) list5);
        if (intrinsicMeasurable2 != null) {
            i3 = function2.invoke(intrinsicMeasurable2, Integer.valueOf(subtractConstraintSafely)).intValue();
            subtractConstraintSafely = LayoutUtilKt.subtractConstraintSafely(subtractConstraintSafely, intrinsicMeasurable2.maxIntrinsicWidth(Integer.MAX_VALUE));
        } else {
            i3 = 0;
        }
        IntrinsicMeasurable intrinsicMeasurable3 = (IntrinsicMeasurable) CollectionsKt.firstOrNull((List<? extends Object>) list3);
        int intValue = intrinsicMeasurable3 != null ? function2.invoke(intrinsicMeasurable3, Integer.valueOf(subtractConstraintSafely)).intValue() : 0;
        IntrinsicMeasurable intrinsicMeasurable4 = (IntrinsicMeasurable) CollectionsKt.firstOrNull((List<? extends Object>) list2);
        int intValue2 = intrinsicMeasurable4 != null ? function2.invoke(intrinsicMeasurable4, Integer.valueOf(subtractConstraintSafely)).intValue() : 0;
        IntrinsicMeasurable intrinsicMeasurable5 = (IntrinsicMeasurable) CollectionsKt.firstOrNull((List<? extends Object>) list4);
        int intValue3 = intrinsicMeasurable5 != null ? function2.invoke(intrinsicMeasurable5, Integer.valueOf(subtractConstraintSafely)).intValue() : 0;
        isSupportingMultilineHeuristic = ListItemKt.isSupportingMultilineHeuristic(intrinsicMeasureScope, intValue3);
        int m2233invokeZLSjz4$material3 = ListItemType.Companion.m2233invokeZLSjz4$material3(intValue > 0, intValue3 > 0, isSupportingMultilineHeuristic);
        m2220verticalPaddingyh95HIg = ListItemKt.m2220verticalPaddingyh95HIg(m2233invokeZLSjz4$material3);
        int i4 = intValue2;
        int i5 = intValue;
        m2218calculateHeightN4Jib3Y = ListItemKt.m2218calculateHeightN4Jib3Y(intrinsicMeasureScope, i2, i3, i4, i5, intValue3, m2233invokeZLSjz4$material3, intrinsicMeasureScope.mo399roundToPx0680j_4(Dp.m7555constructorimpl(m2220verticalPaddingyh95HIg * 2.0f)), ConstraintsKt.Constraints$default(0, 0, 0, 0, 15, null));
        return m2218calculateHeightN4Jib3Y;
    }
}
