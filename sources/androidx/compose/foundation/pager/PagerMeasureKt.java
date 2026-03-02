package androidx.compose.foundation.pager;

import androidx.collection.MutableIntObjectMap;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.snapping.SnapPosition;
import androidx.compose.foundation.gestures.snapping.SnapPositionKt;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.foundation.lazy.layout.ObservableScopeInvalidator;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
/* compiled from: PagerMeasure.kt */
@Metadata(d1 = {"\u0000®\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u001a\u008a\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00042\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2/\u0010%\u001a+\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020)0'¢\u0006\u0002\b*\u0012\u0004\u0012\u00020+0&2\u0012\u0010,\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020.0\u001c0-H\u0000¢\u0006\u0004\b/\u00100\u001aH\u00101\u001a\b\u0012\u0004\u0012\u0002020\u001c2\u0006\u00103\u001a\u00020\u00042\u0006\u00104\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00042\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\u001c2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u0002020'H\u0002\u001a@\u00106\u001a\b\u0012\u0004\u0012\u0002020\u001c2\u0006\u00107\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00042\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\u001c2\u0012\u00105\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u0002020'H\u0002\u001aH\u00108\u001a\u0004\u0018\u0001022\u0006\u00109\u001a\u00020\u00042\f\u0010:\u001a\b\u0012\u0004\u0012\u0002020\u001c2\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010;\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002\u001a{\u00105\u001a\u000202*\u00020\u00022\u0006\u0010<\u001a\u00020\u00042\u0006\u0010=\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010>\u001a\u00020?2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u00042\u0012\u0010,\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020.0\u001c0-H\u0002¢\u0006\u0004\b@\u0010A\u001a\u008c\u0001\u0010B\u001a\b\u0012\u0004\u0012\u0002020C*\u00020\u00022\f\u0010D\u001a\b\u0012\u0004\u0012\u0002020\u001c2\f\u0010E\u001a\b\u0012\u0004\u0012\u0002020\u001c2\f\u0010F\u001a\b\u0012\u0004\u0012\u0002020\u001c2\u0006\u0010G\u001a\u00020\u00042\u0006\u0010H\u001a\u00020\u00042\u0006\u0010I\u001a\u00020\u00042\u0006\u0010J\u001a\u00020\u00042\u0006\u0010K\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010#\u001a\u00020$2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0004H\u0002\u001a\u0017\u0010O\u001a\u00020)2\f\u0010P\u001a\b\u0012\u0004\u0012\u00020R0QH\u0082\b\"\u000e\u0010L\u001a\u00020MX\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010N\u001a\u00020MX\u0080T¢\u0006\u0002\n\u0000¨\u0006S"}, d2 = {"measurePager", "Landroidx/compose/foundation/pager/PagerMeasureResult;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "pageCount", "", "pagerItemProvider", "Landroidx/compose/foundation/pager/PagerLazyLayoutItemProvider;", "mainAxisAvailableSize", "beforeContentPadding", "afterContentPadding", "spaceBetweenPages", "currentPage", "currentPageOffset", "constraints", "Landroidx/compose/ui/unit/Constraints;", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "reverseLayout", "", "visualPageOffset", "Landroidx/compose/ui/unit/IntOffset;", "pageAvailableSize", "beyondViewportPageCount", "pinnedPages", "", "snapPosition", "Landroidx/compose/foundation/gestures/snapping/SnapPosition;", "placementScopeInvalidator", "Landroidx/compose/foundation/lazy/layout/ObservableScopeInvalidator;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "density", "Landroidx/compose/ui/unit/Density;", "layout", "Lkotlin/Function3;", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "", "Lkotlin/ExtensionFunctionType;", "Landroidx/compose/ui/layout/MeasureResult;", "placeablesCache", "Landroidx/collection/MutableIntObjectMap;", "Landroidx/compose/ui/layout/Placeable;", "measurePager-7L1iB3k", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;ILandroidx/compose/foundation/pager/PagerLazyLayoutItemProvider;IIIIIIJLandroidx/compose/foundation/gestures/Orientation;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/ui/Alignment$Horizontal;ZJIILjava/util/List;Landroidx/compose/foundation/gestures/snapping/SnapPosition;Landroidx/compose/runtime/MutableState;Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/ui/unit/Density;Lkotlin/jvm/functions/Function3;Landroidx/collection/MutableIntObjectMap;)Landroidx/compose/foundation/pager/PagerMeasureResult;", "createPagesAfterList", "Landroidx/compose/foundation/pager/MeasuredPage;", "currentLastPage", "pagesCount", "getAndMeasure", "createPagesBeforeList", "currentFirstPage", "calculateNewCurrentPage", "viewportSize", "visiblePagesInfo", "itemSize", FirebaseAnalytics.Param.INDEX, "childConstraints", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getAndMeasure-G5IdpRk", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;IJLandroidx/compose/foundation/pager/PagerLazyLayoutItemProvider;JLandroidx/compose/foundation/gestures/Orientation;Landroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/ui/unit/LayoutDirection;ZILandroidx/collection/MutableIntObjectMap;)Landroidx/compose/foundation/pager/MeasuredPage;", "calculatePagesOffsets", "", "pages", "extraPagesBefore", "extraPagesAfter", "layoutWidth", "layoutHeight", "finalMainAxisOffset", "maxOffset", "pagesScrollOffset", "MinPageOffset", "", "MaxPageOffset", "debugLog", "generateMsg", "Lkotlin/Function0;", "", "foundation"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PagerMeasureKt {
    public static final float MaxPageOffset = 0.5f;
    public static final float MinPageOffset = -0.5f;

    private static final int calculatePagesOffsets$reverseAware(int i, boolean z, int i2) {
        return !z ? i : (i2 - i) - 1;
    }

    private static final void debugLog(Function0<String> function0) {
    }

    /* renamed from: measurePager-7L1iB3k  reason: not valid java name */
    public static final PagerMeasureResult m1078measurePager7L1iB3k(final LazyLayoutMeasureScope lazyLayoutMeasureScope, int i, final PagerLazyLayoutItemProvider pagerLazyLayoutItemProvider, int i2, int i3, int i4, int i5, int i6, int i7, long j, final Orientation orientation, final Alignment.Vertical vertical, final Alignment.Horizontal horizontal, final boolean z, final long j2, final int i8, int i9, List<Integer> list, SnapPosition snapPosition, final MutableState<Unit> mutableState, CoroutineScope coroutineScope, Density density, Function3<? super Integer, ? super Integer, ? super Function1<? super Placeable.PlacementScope, Unit>, ? extends MeasureResult> function3, final MutableIntObjectMap<List<Placeable>> mutableIntObjectMap) {
        int i10;
        boolean z2;
        int i11;
        int i12;
        int i13;
        int i14;
        MeasuredPage measuredPage;
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        int i15;
        int i16;
        if (!(i3 >= 0)) {
            InlineClassHelperKt.throwIllegalArgumentException("negative beforeContentPadding");
        }
        if (!(i4 >= 0)) {
            InlineClassHelperKt.throwIllegalArgumentException("negative afterContentPadding");
        }
        int coerceAtLeast = RangesKt.coerceAtLeast(i8 + i5, 0);
        int coerceAtMost = RangesKt.coerceAtMost(i9, i);
        final long Constraints$default = ConstraintsKt.Constraints$default(0, orientation == Orientation.Vertical ? Constraints.m7508getMaxWidthimpl(j) : i8, 0, orientation != Orientation.Vertical ? Constraints.m7507getMaxHeightimpl(j) : i8, 5, null);
        if (i <= 0) {
            return new PagerMeasureResult(CollectionsKt.emptyList(), i8, i5, i4, orientation, -i3, i2 + i4, false, coerceAtMost, null, null, 0.0f, 0, false, snapPosition, function3.invoke(Integer.valueOf(Constraints.m7510getMinWidthimpl(j)), Integer.valueOf(Constraints.m7509getMinHeightimpl(j)), new Function1() { // from class: androidx.compose.foundation.pager.PagerMeasureKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit unit;
                    Placeable.PlacementScope placementScope = (Placeable.PlacementScope) obj;
                    unit = Unit.INSTANCE;
                    return unit;
                }
            }), false, null, null, coroutineScope, density, Constraints$default, 393216, null);
        }
        int i17 = coerceAtMost;
        int i18 = i6;
        int i19 = i7;
        while (i18 > 0 && i19 > 0) {
            i18--;
            i19 -= coerceAtLeast;
        }
        int i20 = i19 * (-1);
        if (i18 >= i) {
            i18 = i - 1;
            i20 = 0;
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        int i21 = -i3;
        int i22 = (i5 < 0 ? i5 : 0) + i21;
        int i23 = i20 + i22;
        int i24 = 0;
        while (i23 < 0 && i18 > 0) {
            int i25 = i18 - 1;
            MeasuredPage m1077getAndMeasureG5IdpRk = m1077getAndMeasureG5IdpRk(lazyLayoutMeasureScope, i25, Constraints$default, pagerLazyLayoutItemProvider, j2, orientation, horizontal, vertical, lazyLayoutMeasureScope.getLayoutDirection(), z, i8, mutableIntObjectMap);
            arrayDeque.add(0, m1077getAndMeasureG5IdpRk);
            i24 = Math.max(i24, m1077getAndMeasureG5IdpRk.getCrossAxisSize());
            i23 += coerceAtLeast;
            i18 = i25;
        }
        if (i23 < i22) {
            i23 = i22;
        }
        int i26 = i23 - i22;
        int i27 = i2 + i4;
        int i28 = i18;
        int coerceAtLeast2 = RangesKt.coerceAtLeast(i27, 0);
        int i29 = -i26;
        int i30 = i28;
        int i31 = 0;
        boolean z3 = false;
        while (i31 < arrayDeque.size()) {
            if (i29 >= coerceAtLeast2) {
                arrayDeque.remove(i31);
                Unit unit = Unit.INSTANCE;
                z3 = true;
            } else {
                i30++;
                i29 += coerceAtLeast;
                Integer.valueOf(i31);
                i31++;
            }
        }
        int i32 = i26;
        int i33 = i30;
        boolean z4 = z3;
        while (i33 < i && (i29 < coerceAtLeast2 || i29 <= 0 || arrayDeque.isEmpty())) {
            int i34 = coerceAtLeast2;
            int i35 = i33;
            int i36 = i24;
            MeasuredPage m1077getAndMeasureG5IdpRk2 = m1077getAndMeasureG5IdpRk(lazyLayoutMeasureScope, i35, Constraints$default, pagerLazyLayoutItemProvider, j2, orientation, horizontal, vertical, lazyLayoutMeasureScope.getLayoutDirection(), z, i8, mutableIntObjectMap);
            int i37 = i32;
            int i38 = i - 1;
            i29 += i35 == i38 ? i8 : coerceAtLeast;
            if (i29 <= i22 && i35 != i38) {
                i16 = i35 + 1;
                i32 = i37 - coerceAtLeast;
                Unit unit2 = Unit.INSTANCE;
                z4 = true;
            } else {
                i36 = Math.max(i36, m1077getAndMeasureG5IdpRk2.getCrossAxisSize());
                Boolean.valueOf(arrayDeque.add(m1077getAndMeasureG5IdpRk2));
                i16 = i28;
                i32 = i37;
            }
            i24 = i36;
            i33 = i35 + 1;
            i28 = i16;
            coerceAtLeast2 = i34;
        }
        int i39 = i24;
        int i40 = i33;
        int i41 = i32;
        if (i29 < i2) {
            int i42 = i2 - i29;
            i12 = i41 - i42;
            i29 += i42;
            i11 = i39;
            i13 = i28;
            while (i12 < i3 && i13 > 0) {
                int i43 = i13 - 1;
                MeasuredPage m1077getAndMeasureG5IdpRk3 = m1077getAndMeasureG5IdpRk(lazyLayoutMeasureScope, i43, Constraints$default, pagerLazyLayoutItemProvider, j2, orientation, horizontal, vertical, lazyLayoutMeasureScope.getLayoutDirection(), z, i8, mutableIntObjectMap);
                arrayDeque.add(0, m1077getAndMeasureG5IdpRk3);
                i11 = Math.max(i11, m1077getAndMeasureG5IdpRk3.getCrossAxisSize());
                i12 += coerceAtLeast;
                i40 = i40;
                i13 = i43;
            }
            i10 = i40;
            z2 = false;
            if (i12 < 0) {
                i29 += i12;
                i12 = 0;
            }
        } else {
            i10 = i40;
            z2 = false;
            i11 = i39;
            i12 = i41;
            i13 = i28;
        }
        if (!(i12 >= 0 ? true : z2)) {
            InlineClassHelperKt.throwIllegalArgumentException("invalid currentFirstPageScrollOffset");
        }
        int i44 = i11;
        int i45 = -i12;
        MeasuredPage measuredPage2 = (MeasuredPage) arrayDeque.first();
        if (i3 > 0 || i5 < 0) {
            int size = arrayDeque.size();
            i14 = i45;
            int i46 = 0;
            while (i46 < size && i12 != 0 && coerceAtLeast <= i12 && i46 != CollectionsKt.getLastIndex(arrayDeque)) {
                i12 -= coerceAtLeast;
                i46++;
                measuredPage2 = (MeasuredPage) arrayDeque.get(i46);
            }
        } else {
            i14 = i45;
        }
        int i47 = i12;
        MeasuredPage measuredPage3 = measuredPage2;
        List<MeasuredPage> createPagesBeforeList = createPagesBeforeList(i13, i17, list, new Function1() { // from class: androidx.compose.foundation.pager.PagerMeasureKt$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                MeasuredPage m1077getAndMeasureG5IdpRk4;
                m1077getAndMeasureG5IdpRk4 = PagerMeasureKt.m1077getAndMeasureG5IdpRk(r0, ((Integer) obj).intValue(), Constraints$default, pagerLazyLayoutItemProvider, j2, orientation, horizontal, vertical, LazyLayoutMeasureScope.this.getLayoutDirection(), z, i8, mutableIntObjectMap);
                return m1077getAndMeasureG5IdpRk4;
            }
        });
        int size2 = createPagesBeforeList.size();
        int i48 = i44;
        int i49 = 0;
        while (i49 < size2) {
            i48 = Math.max(i48, createPagesBeforeList.get(i49).getCrossAxisSize());
            i49++;
            createPagesBeforeList = createPagesBeforeList;
        }
        List<MeasuredPage> list2 = createPagesBeforeList;
        List<MeasuredPage> createPagesAfterList = createPagesAfterList(((MeasuredPage) arrayDeque.last()).getIndex(), i, i17, list, new Function1() { // from class: androidx.compose.foundation.pager.PagerMeasureKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                MeasuredPage m1077getAndMeasureG5IdpRk4;
                m1077getAndMeasureG5IdpRk4 = PagerMeasureKt.m1077getAndMeasureG5IdpRk(r0, ((Integer) obj).intValue(), Constraints$default, pagerLazyLayoutItemProvider, j2, orientation, horizontal, vertical, LazyLayoutMeasureScope.this.getLayoutDirection(), z, i8, mutableIntObjectMap);
                return m1077getAndMeasureG5IdpRk4;
            }
        });
        int size3 = createPagesAfterList.size();
        int i50 = 0;
        while (i50 < size3) {
            i48 = Math.max(i48, createPagesAfterList.get(i50).getCrossAxisSize());
            i50++;
            i17 = i17;
        }
        int i51 = i17;
        boolean z5 = Intrinsics.areEqual(measuredPage3, arrayDeque.first()) && list2.isEmpty() && createPagesAfterList.isEmpty();
        int m7525constrainWidthK40F9xA = ConstraintsKt.m7525constrainWidthK40F9xA(j, orientation == Orientation.Vertical ? i48 : i29);
        if (orientation == Orientation.Vertical) {
            i48 = i29;
        }
        int m7524constrainHeightK40F9xA = ConstraintsKt.m7524constrainHeightK40F9xA(j, i48);
        int i52 = i10;
        int i53 = i29;
        final List<MeasuredPage> calculatePagesOffsets = calculatePagesOffsets(lazyLayoutMeasureScope, arrayDeque, list2, createPagesAfterList, m7525constrainWidthK40F9xA, m7524constrainHeightK40F9xA, i53, i2, i14, orientation, z, lazyLayoutMeasureScope, i5, i8);
        if (z5) {
            measuredPage = measuredPage3;
            arrayList = calculatePagesOffsets;
        } else {
            ArrayList arrayList4 = new ArrayList(calculatePagesOffsets.size());
            int size4 = calculatePagesOffsets.size();
            int i54 = 0;
            while (i54 < size4) {
                MeasuredPage measuredPage4 = calculatePagesOffsets.get(i54);
                MeasuredPage measuredPage5 = measuredPage4;
                ArrayList arrayList5 = arrayList4;
                MeasuredPage measuredPage6 = measuredPage3;
                if (measuredPage5.getIndex() >= ((MeasuredPage) arrayDeque.first()).getIndex() && measuredPage5.getIndex() <= ((MeasuredPage) arrayDeque.last()).getIndex()) {
                    arrayList5.add(measuredPage4);
                }
                i54++;
                arrayList4 = arrayList5;
                measuredPage3 = measuredPage6;
            }
            measuredPage = measuredPage3;
            arrayList = arrayList4;
        }
        if (list2.isEmpty()) {
            arrayList2 = CollectionsKt.emptyList();
        } else {
            ArrayList arrayList6 = new ArrayList(calculatePagesOffsets.size());
            int size5 = calculatePagesOffsets.size();
            int i55 = 0;
            while (i55 < size5) {
                MeasuredPage measuredPage7 = calculatePagesOffsets.get(i55);
                ArrayList arrayList7 = arrayList6;
                if (measuredPage7.getIndex() < ((MeasuredPage) arrayDeque.first()).getIndex()) {
                    arrayList7.add(measuredPage7);
                }
                i55++;
                arrayList6 = arrayList7;
            }
            arrayList2 = arrayList6;
        }
        List list3 = arrayList2;
        if (createPagesAfterList.isEmpty()) {
            arrayList3 = CollectionsKt.emptyList();
        } else {
            ArrayList arrayList8 = new ArrayList(calculatePagesOffsets.size());
            int size6 = calculatePagesOffsets.size();
            int i56 = 0;
            while (i56 < size6) {
                MeasuredPage measuredPage8 = calculatePagesOffsets.get(i56);
                ArrayList arrayList9 = arrayList8;
                if (measuredPage8.getIndex() > ((MeasuredPage) arrayDeque.last()).getIndex()) {
                    arrayList9.add(measuredPage8);
                }
                i56++;
                arrayList8 = arrayList9;
            }
            arrayList3 = arrayList8;
        }
        List list4 = arrayList3;
        MeasuredPage measuredPage9 = measuredPage;
        MeasuredPage calculateNewCurrentPage = calculateNewCurrentPage(i2 + i3 + i4, arrayList, i3, i4, i8, snapPosition, i);
        return new PagerMeasureResult(arrayList, i8, i5, i4, orientation, i21, i27, z, i51, measuredPage9, calculateNewCurrentPage, coerceAtLeast == 0 ? 0.0f : RangesKt.coerceIn((snapPosition.position(i15, i8, i3, i4, calculateNewCurrentPage != null ? calculateNewCurrentPage.getIndex() : 0, i) - (calculateNewCurrentPage != null ? calculateNewCurrentPage.getOffset() : 0)) / coerceAtLeast, -0.5f, 0.5f), i47, i52 < i || i53 > i2, snapPosition, function3.invoke(Integer.valueOf(m7525constrainWidthK40F9xA), Integer.valueOf(m7524constrainHeightK40F9xA), new Function1() { // from class: androidx.compose.foundation.pager.PagerMeasureKt$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return PagerMeasureKt.measurePager_7L1iB3k$lambda$18(MutableState.this, calculatePagesOffsets, (Placeable.PlacementScope) obj);
            }
        }), z4, list3, list4, coroutineScope, density, Constraints$default, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit measurePager_7L1iB3k$lambda$18(MutableState mutableState, final List list, Placeable.PlacementScope placementScope) {
        placementScope.withMotionFrameOfReferencePlacement(new Function1() { // from class: androidx.compose.foundation.pager.PagerMeasureKt$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit measurePager_7L1iB3k$lambda$18$0;
                measurePager_7L1iB3k$lambda$18$0 = PagerMeasureKt.measurePager_7L1iB3k$lambda$18$0(list, (Placeable.PlacementScope) obj);
                return measurePager_7L1iB3k$lambda$18$0;
            }
        });
        ObservableScopeInvalidator.m1005attachToScopeimpl(mutableState);
        return Unit.INSTANCE;
    }

    private static final List<MeasuredPage> createPagesAfterList(int i, int i2, int i3, List<Integer> list, Function1<? super Integer, MeasuredPage> function1) {
        int min = Math.min(i3, (i2 - i) - 1) + i;
        int i4 = i + 1;
        ArrayList arrayList = null;
        if (i4 <= min) {
            while (true) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(function1.invoke(Integer.valueOf(i4)));
                if (i4 == min) {
                    break;
                }
                i4++;
            }
        }
        int size = list.size();
        for (int i5 = 0; i5 < size; i5++) {
            int intValue = list.get(i5).intValue();
            if (min + 1 <= intValue && intValue < i2) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(function1.invoke(Integer.valueOf(intValue)));
            }
        }
        return arrayList == null ? CollectionsKt.emptyList() : arrayList;
    }

    private static final List<MeasuredPage> createPagesBeforeList(int i, int i2, List<Integer> list, Function1<? super Integer, MeasuredPage> function1) {
        int max = Math.max(0, i - i2);
        int i3 = i - 1;
        ArrayList arrayList = null;
        if (max <= i3) {
            while (true) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(function1.invoke(Integer.valueOf(i3)));
                if (i3 == max) {
                    break;
                }
                i3--;
            }
        }
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            int intValue = list.get(i4).intValue();
            if (intValue < max) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(function1.invoke(Integer.valueOf(intValue)));
            }
        }
        return arrayList == null ? CollectionsKt.emptyList() : arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getAndMeasure-G5IdpRk  reason: not valid java name */
    public static final MeasuredPage m1077getAndMeasureG5IdpRk(LazyLayoutMeasureScope lazyLayoutMeasureScope, int i, long j, PagerLazyLayoutItemProvider pagerLazyLayoutItemProvider, long j2, Orientation orientation, Alignment.Horizontal horizontal, Alignment.Vertical vertical, LayoutDirection layoutDirection, boolean z, int i2, MutableIntObjectMap<List<Placeable>> mutableIntObjectMap) {
        Object key = pagerLazyLayoutItemProvider.getKey(i);
        ArrayList arrayList = mutableIntObjectMap.get(i);
        if (arrayList == null) {
            List<Measurable> compose = lazyLayoutMeasureScope.compose(i);
            int size = compose.size();
            ArrayList arrayList2 = new ArrayList(size);
            for (int i3 = 0; i3 < size; i3++) {
                arrayList2.add(compose.get(i3).mo6216measureBRTryo0(j));
            }
            arrayList = arrayList2;
            mutableIntObjectMap.set(i, arrayList);
        }
        return new MeasuredPage(i, i2, arrayList, j2, key, orientation, horizontal, vertical, layoutDirection, z, null);
    }

    private static final List<MeasuredPage> calculatePagesOffsets(LazyLayoutMeasureScope lazyLayoutMeasureScope, List<MeasuredPage> list, List<MeasuredPage> list2, List<MeasuredPage> list3, int i, int i2, int i3, int i4, int i5, Orientation orientation, boolean z, Density density, int i6, int i7) {
        ArrayList arrayList;
        int i8 = i5;
        int i9 = i7 + i6;
        int i10 = orientation == Orientation.Vertical ? i2 : i;
        boolean z2 = true;
        boolean z3 = i3 < Math.min(i10, i4);
        if (z3) {
            if (!(i8 == 0)) {
                InlineClassHelperKt.throwIllegalStateException("non-zero pagesScrollOffset=" + i8);
            }
        }
        ArrayList arrayList2 = new ArrayList(list.size() + list2.size() + list3.size());
        if (z3) {
            if (!((list2.isEmpty() && list3.isEmpty()) ? false : false)) {
                InlineClassHelperKt.throwIllegalArgumentException("No extra pages");
            }
            int size = list.size();
            int[] iArr = new int[size];
            for (int i11 = 0; i11 < size; i11++) {
                iArr[i11] = i7;
            }
            int[] iArr2 = new int[size];
            Arrangement.HorizontalOrVertical m691spacedBy0680j_4 = Arrangement.Absolute.INSTANCE.m691spacedBy0680j_4(lazyLayoutMeasureScope.mo402toDpu2uoSUM(i6));
            if (orientation == Orientation.Vertical) {
                m691spacedBy0680j_4.arrange(density, i10, iArr, iArr2);
                arrayList = arrayList2;
            } else {
                arrayList = arrayList2;
                m691spacedBy0680j_4.arrange(density, i10, iArr, LayoutDirection.Ltr, iArr2);
            }
            IntRange indices = ArraysKt.getIndices(iArr2);
            if (z) {
                indices = RangesKt.reversed(indices);
            }
            int first = indices.getFirst();
            int last = indices.getLast();
            int step = indices.getStep();
            if ((step > 0 && first <= last) || (step < 0 && last <= first)) {
                while (true) {
                    int i12 = iArr2[first];
                    MeasuredPage measuredPage = list.get(calculatePagesOffsets$reverseAware(first, z, size));
                    if (z) {
                        i12 = (i10 - i12) - measuredPage.getSize();
                    }
                    measuredPage.position(i12, i, i2);
                    arrayList.add(measuredPage);
                    if (first == last) {
                        break;
                    }
                    first += step;
                }
            }
        } else {
            arrayList = arrayList2;
            int size2 = list2.size();
            int i13 = i8;
            for (int i14 = 0; i14 < size2; i14++) {
                MeasuredPage measuredPage2 = list2.get(i14);
                i13 -= i9;
                measuredPage2.position(i13, i, i2);
                arrayList.add(measuredPage2);
            }
            int size3 = list.size();
            for (int i15 = 0; i15 < size3; i15++) {
                MeasuredPage measuredPage3 = list.get(i15);
                measuredPage3.position(i8, i, i2);
                arrayList.add(measuredPage3);
                i8 += i9;
            }
            int size4 = list3.size();
            for (int i16 = 0; i16 < size4; i16++) {
                MeasuredPage measuredPage4 = list3.get(i16);
                measuredPage4.position(i8, i, i2);
                arrayList.add(measuredPage4);
                i8 += i9;
            }
        }
        return arrayList;
    }

    private static final MeasuredPage calculateNewCurrentPage(int i, List<MeasuredPage> list, int i2, int i3, int i4, SnapPosition snapPosition, int i5) {
        MeasuredPage measuredPage;
        if (list.isEmpty()) {
            measuredPage = null;
        } else {
            MeasuredPage measuredPage2 = list.get(0);
            MeasuredPage measuredPage3 = measuredPage2;
            float f = -Math.abs(SnapPositionKt.calculateDistanceToDesiredSnapPosition(i, i2, i3, i4, measuredPage3.getOffset(), measuredPage3.getIndex(), snapPosition, i5));
            int lastIndex = CollectionsKt.getLastIndex(list);
            if (1 <= lastIndex) {
                int i6 = 1;
                while (true) {
                    MeasuredPage measuredPage4 = list.get(i6);
                    MeasuredPage measuredPage5 = measuredPage4;
                    float f2 = -Math.abs(SnapPositionKt.calculateDistanceToDesiredSnapPosition(i, i2, i3, i4, measuredPage5.getOffset(), measuredPage5.getIndex(), snapPosition, i5));
                    if (Float.compare(f, f2) < 0) {
                        f = f2;
                        measuredPage2 = measuredPage4;
                    }
                    if (i6 == lastIndex) {
                        break;
                    }
                    i6++;
                }
            }
            measuredPage = measuredPage2;
        }
        return measuredPage;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measurePager_7L1iB3k$lambda$18$0(List list, Placeable.PlacementScope placementScope) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            ((MeasuredPage) list.get(i)).place(placementScope);
        }
        return Unit.INSTANCE;
    }
}
