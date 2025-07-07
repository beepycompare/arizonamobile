package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.snapping.SnapPosition;
import androidx.compose.foundation.gestures.snapping.SnapPositionKt;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.foundation.lazy.layout.ObservableScopeInvalidator;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.media3.extractor.text.ttml.TtmlNode;
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
@Metadata(d1 = {"\u0000¬\u0001\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aH\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006H\u0002\u001aH\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\u0015H\u0002\u001a@\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00040\u0015H\u0002\u001a\u0017\u0010\u0018\u001a\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0082\b\u001a\u008c\u0001\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00040\u001e*\u00020\u001f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00040\b2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\u0006\u0010#\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u00062\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u00062\u0006\u0010/\u001a\u00020\u0006H\u0002\u001aj\u0010\u0014\u001a\u00020\u0004*\u00020\u001f2\u0006\u00100\u001a\u00020\u00062\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u0002062\u0006\u0010(\u001a\u00020)2\b\u00107\u001a\u0004\u0018\u0001082\b\u00109\u001a\u0004\u0018\u00010:2\u0006\u0010;\u001a\u00020<2\u0006\u0010*\u001a\u00020+2\u0006\u0010/\u001a\u00020\u0006H\u0002ø\u0001\u0000¢\u0006\u0004\b=\u0010>\u001añ\u0001\u0010?\u001a\u00020@*\u00020\u001f2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u00103\u001a\u0002042\u0006\u0010A\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u00062\u0006\u0010B\u001a\u00020\u00062\u0006\u0010C\u001a\u00020\u00062\u0006\u0010D\u001a\u0002022\u0006\u0010(\u001a\u00020)2\b\u00109\u001a\u0004\u0018\u00010:2\b\u00107\u001a\u0004\u0018\u0001082\u0006\u0010*\u001a\u00020+2\u0006\u00105\u001a\u0002062\u0006\u0010/\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00062\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020H2/\u0010I\u001a+\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020K\u0012\u0004\u0012\u00020\u00190\u0015¢\u0006\u0002\bL\u0012\u0004\u0012\u00020M0JH\u0000ø\u0001\u0000¢\u0006\u0004\bN\u0010O\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006P"}, d2 = {"MaxPageOffset", "", "MinPageOffset", "calculateNewCurrentPage", "Landroidx/compose/foundation/pager/MeasuredPage;", "viewportSize", "", "visiblePagesInfo", "", "beforeContentPadding", "afterContentPadding", "itemSize", "snapPosition", "Landroidx/compose/foundation/gestures/snapping/SnapPosition;", "pageCount", "createPagesAfterList", "currentLastPage", "pagesCount", "beyondViewportPageCount", "pinnedPages", "getAndMeasure", "Lkotlin/Function1;", "createPagesBeforeList", "currentFirstPage", "debugLog", "", "generateMsg", "Lkotlin/Function0;", "", "calculatePagesOffsets", "", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "pages", "extraPagesBefore", "extraPagesAfter", "layoutWidth", "layoutHeight", "finalMainAxisOffset", "maxOffset", "pagesScrollOffset", "orientation", "Landroidx/compose/foundation/gestures/Orientation;", "reverseLayout", "", "density", "Landroidx/compose/ui/unit/Density;", "spaceBetweenPages", "pageAvailableSize", FirebaseAnalytics.Param.INDEX, "childConstraints", "Landroidx/compose/ui/unit/Constraints;", "pagerItemProvider", "Landroidx/compose/foundation/pager/PagerLazyLayoutItemProvider;", "visualPageOffset", "Landroidx/compose/ui/unit/IntOffset;", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getAndMeasure-SGf7dI0", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;IJLandroidx/compose/foundation/pager/PagerLazyLayoutItemProvider;JLandroidx/compose/foundation/gestures/Orientation;Landroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/ui/unit/LayoutDirection;ZI)Landroidx/compose/foundation/pager/MeasuredPage;", "measurePager", "Landroidx/compose/foundation/pager/PagerMeasureResult;", "mainAxisAvailableSize", "currentPage", "currentPageOffset", "constraints", "placementScopeInvalidator", "Landroidx/compose/foundation/lazy/layout/ObservableScopeInvalidator;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", TtmlNode.TAG_LAYOUT, "Lkotlin/Function3;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "Lkotlin/ExtensionFunctionType;", "Landroidx/compose/ui/layout/MeasureResult;", "measurePager-bmk8ZPk", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;ILandroidx/compose/foundation/pager/PagerLazyLayoutItemProvider;IIIIIIJLandroidx/compose/foundation/gestures/Orientation;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/ui/Alignment$Horizontal;ZJIILjava/util/List;Landroidx/compose/foundation/gestures/snapping/SnapPosition;Landroidx/compose/runtime/MutableState;Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function3;)Landroidx/compose/foundation/pager/PagerMeasureResult;", "foundation_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PagerMeasureKt {
    public static final float MaxPageOffset = 0.5f;
    public static final float MinPageOffset = -0.5f;

    private static final int calculatePagesOffsets$reverseAware(int i, boolean z, int i2) {
        return !z ? i : (i2 - i) - 1;
    }

    private static final void debugLog(Function0<String> function0) {
    }

    /* renamed from: measurePager-bmk8ZPk  reason: not valid java name */
    public static final PagerMeasureResult m990measurePagerbmk8ZPk(final LazyLayoutMeasureScope lazyLayoutMeasureScope, int i, final PagerLazyLayoutItemProvider pagerLazyLayoutItemProvider, int i2, int i3, int i4, int i5, int i6, int i7, long j, final Orientation orientation, final Alignment.Vertical vertical, final Alignment.Horizontal horizontal, final boolean z, final long j2, final int i8, int i9, List<Integer> list, SnapPosition snapPosition, final MutableState<Unit> mutableState, CoroutineScope coroutineScope, Function3<? super Integer, ? super Integer, ? super Function1<? super Placeable.PlacementScope, Unit>, ? extends MeasureResult> function3) {
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
        if (i <= 0) {
            return new PagerMeasureResult(CollectionsKt.emptyList(), i8, i5, i4, orientation, -i3, i2 + i4, false, i9, null, null, 0.0f, 0, false, snapPosition, function3.invoke(Integer.valueOf(Constraints.m6639getMinWidthimpl(j)), Integer.valueOf(Constraints.m6638getMinHeightimpl(j)), new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.pager.PagerMeasureKt$measurePager$4
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(Placeable.PlacementScope placementScope) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                    invoke2(placementScope);
                    return Unit.INSTANCE;
                }
            }), false, null, null, coroutineScope, 393216, null);
        }
        Orientation orientation2 = orientation;
        final long Constraints$default = ConstraintsKt.Constraints$default(0, orientation2 == Orientation.Vertical ? Constraints.m6637getMaxWidthimpl(j) : i8, 0, orientation2 != Orientation.Vertical ? Constraints.m6636getMaxHeightimpl(j) : i8, 5, null);
        int i17 = i6;
        int i18 = i7;
        while (i17 > 0 && i18 > 0) {
            i17--;
            i18 -= coerceAtLeast;
        }
        int i19 = i18 * (-1);
        if (i17 >= i) {
            i17 = i - 1;
            i19 = 0;
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        int i20 = -i3;
        int i21 = (i5 < 0 ? i5 : 0) + i20;
        int i22 = i19 + i21;
        int i23 = 0;
        while (i22 < 0 && i17 > 0) {
            int i24 = i17 - 1;
            MeasuredPage m989getAndMeasureSGf7dI0 = m989getAndMeasureSGf7dI0(lazyLayoutMeasureScope, i24, Constraints$default, pagerLazyLayoutItemProvider, j2, orientation2, horizontal, vertical, lazyLayoutMeasureScope.getLayoutDirection(), z, i8);
            arrayDeque.add(0, m989getAndMeasureSGf7dI0);
            i23 = Math.max(i23, m989getAndMeasureSGf7dI0.getCrossAxisSize());
            i22 += coerceAtLeast;
            i21 = i21;
            i17 = i24;
            orientation2 = orientation;
        }
        int i25 = i21;
        int i26 = i23;
        if (i22 < i25) {
            i22 = i25;
        }
        int i27 = i22 - i25;
        int i28 = i2 + i4;
        int i29 = i17;
        int coerceAtLeast2 = RangesKt.coerceAtLeast(i28, 0);
        int i30 = -i27;
        int i31 = i29;
        int i32 = 0;
        boolean z3 = false;
        while (i32 < arrayDeque.size()) {
            if (i30 >= coerceAtLeast2) {
                arrayDeque.remove(i32);
                z3 = true;
            } else {
                i31++;
                i30 += coerceAtLeast;
                i32++;
            }
        }
        int i33 = i26;
        int i34 = i31;
        boolean z4 = z3;
        int i35 = i27;
        while (i34 < i && (i30 < coerceAtLeast2 || i30 <= 0 || arrayDeque.isEmpty())) {
            int i36 = coerceAtLeast2;
            int i37 = i34;
            MeasuredPage m989getAndMeasureSGf7dI02 = m989getAndMeasureSGf7dI0(lazyLayoutMeasureScope, i37, Constraints$default, pagerLazyLayoutItemProvider, j2, orientation, horizontal, vertical, lazyLayoutMeasureScope.getLayoutDirection(), z, i8);
            int i38 = i35;
            int i39 = i - 1;
            i30 += i37 == i39 ? i8 : coerceAtLeast;
            if (i30 > i25 || i37 == i39) {
                i33 = Math.max(i33, m989getAndMeasureSGf7dI02.getCrossAxisSize());
                arrayDeque.add(m989getAndMeasureSGf7dI02);
                i16 = i29;
                i35 = i38;
            } else {
                i16 = i37 + 1;
                i35 = i38 - coerceAtLeast;
                z4 = true;
            }
            i34 = i37 + 1;
            i29 = i16;
            coerceAtLeast2 = i36;
        }
        int i40 = i35;
        if (i30 < i2) {
            int i41 = i2 - i30;
            i12 = i40 - i41;
            i30 += i41;
            i11 = i33;
            i13 = i29;
            while (i12 < i3 && i13 > 0) {
                int i42 = i13 - 1;
                MeasuredPage m989getAndMeasureSGf7dI03 = m989getAndMeasureSGf7dI0(lazyLayoutMeasureScope, i42, Constraints$default, pagerLazyLayoutItemProvider, j2, orientation, horizontal, vertical, lazyLayoutMeasureScope.getLayoutDirection(), z, i8);
                arrayDeque.add(0, m989getAndMeasureSGf7dI03);
                i11 = Math.max(i11, m989getAndMeasureSGf7dI03.getCrossAxisSize());
                i12 += coerceAtLeast;
                i34 = i34;
                i13 = i42;
            }
            i10 = i34;
            z2 = false;
            if (i12 < 0) {
                i30 += i12;
                i12 = 0;
            }
        } else {
            i10 = i34;
            z2 = false;
            i11 = i33;
            i12 = i40;
            i13 = i29;
        }
        if (!(i12 >= 0 ? true : z2)) {
            InlineClassHelperKt.throwIllegalArgumentException("invalid currentFirstPageScrollOffset");
        }
        int i43 = i11;
        int i44 = -i12;
        MeasuredPage measuredPage2 = (MeasuredPage) arrayDeque.first();
        if (i3 > 0 || i5 < 0) {
            int size = arrayDeque.size();
            i14 = i44;
            int i45 = 0;
            while (i45 < size && i12 != 0 && coerceAtLeast <= i12 && i45 != CollectionsKt.getLastIndex(arrayDeque)) {
                i12 -= coerceAtLeast;
                i45++;
                measuredPage2 = (MeasuredPage) arrayDeque.get(i45);
            }
        } else {
            i14 = i44;
        }
        int i46 = i12;
        MeasuredPage measuredPage3 = measuredPage2;
        List<MeasuredPage> createPagesBeforeList = createPagesBeforeList(i13, i9, list, new Function1<Integer, MeasuredPage>() { // from class: androidx.compose.foundation.pager.PagerMeasureKt$measurePager$extraPagesBefore$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ MeasuredPage invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final MeasuredPage invoke(int i47) {
                MeasuredPage m989getAndMeasureSGf7dI04;
                LazyLayoutMeasureScope lazyLayoutMeasureScope2 = LazyLayoutMeasureScope.this;
                m989getAndMeasureSGf7dI04 = PagerMeasureKt.m989getAndMeasureSGf7dI0(lazyLayoutMeasureScope2, i47, Constraints$default, pagerLazyLayoutItemProvider, j2, orientation, horizontal, vertical, lazyLayoutMeasureScope2.getLayoutDirection(), z, i8);
                return m989getAndMeasureSGf7dI04;
            }
        });
        int size2 = createPagesBeforeList.size();
        int i47 = i43;
        int i48 = 0;
        while (i48 < size2) {
            i47 = Math.max(i47, createPagesBeforeList.get(i48).getCrossAxisSize());
            i48++;
            createPagesBeforeList = createPagesBeforeList;
        }
        List<MeasuredPage> list2 = createPagesBeforeList;
        List<MeasuredPage> createPagesAfterList = createPagesAfterList(((MeasuredPage) arrayDeque.last()).getIndex(), i, i9, list, new Function1<Integer, MeasuredPage>() { // from class: androidx.compose.foundation.pager.PagerMeasureKt$measurePager$extraPagesAfter$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ MeasuredPage invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final MeasuredPage invoke(int i49) {
                MeasuredPage m989getAndMeasureSGf7dI04;
                LazyLayoutMeasureScope lazyLayoutMeasureScope2 = LazyLayoutMeasureScope.this;
                m989getAndMeasureSGf7dI04 = PagerMeasureKt.m989getAndMeasureSGf7dI0(lazyLayoutMeasureScope2, i49, Constraints$default, pagerLazyLayoutItemProvider, j2, orientation, horizontal, vertical, lazyLayoutMeasureScope2.getLayoutDirection(), z, i8);
                return m989getAndMeasureSGf7dI04;
            }
        });
        int size3 = createPagesAfterList.size();
        for (int i49 = 0; i49 < size3; i49++) {
            i47 = Math.max(i47, createPagesAfterList.get(i49).getCrossAxisSize());
        }
        boolean z5 = Intrinsics.areEqual(measuredPage3, arrayDeque.first()) && list2.isEmpty() && createPagesAfterList.isEmpty();
        int m6654constrainWidthK40F9xA = ConstraintsKt.m6654constrainWidthK40F9xA(j, orientation == Orientation.Vertical ? i47 : i30);
        if (orientation == Orientation.Vertical) {
            i47 = i30;
        }
        int m6653constrainHeightK40F9xA = ConstraintsKt.m6653constrainHeightK40F9xA(j, i47);
        int i50 = i10;
        int i51 = i30;
        final List<MeasuredPage> calculatePagesOffsets = calculatePagesOffsets(lazyLayoutMeasureScope, arrayDeque, list2, createPagesAfterList, m6654constrainWidthK40F9xA, m6653constrainHeightK40F9xA, i51, i2, i14, orientation, z, lazyLayoutMeasureScope, i5, i8);
        if (z5) {
            measuredPage = measuredPage3;
            arrayList = calculatePagesOffsets;
        } else {
            ArrayList arrayList4 = new ArrayList(calculatePagesOffsets.size());
            int size4 = calculatePagesOffsets.size();
            int i52 = 0;
            while (i52 < size4) {
                MeasuredPage measuredPage4 = calculatePagesOffsets.get(i52);
                MeasuredPage measuredPage5 = measuredPage4;
                MeasuredPage measuredPage6 = measuredPage3;
                ArrayList arrayList5 = arrayList4;
                if (measuredPage5.getIndex() >= ((MeasuredPage) arrayDeque.first()).getIndex() && measuredPage5.getIndex() <= ((MeasuredPage) arrayDeque.last()).getIndex()) {
                    arrayList5.add(measuredPage4);
                }
                i52++;
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
            int i53 = 0;
            while (i53 < size5) {
                MeasuredPage measuredPage7 = calculatePagesOffsets.get(i53);
                ArrayList arrayList7 = arrayList6;
                if (measuredPage7.getIndex() < ((MeasuredPage) arrayDeque.first()).getIndex()) {
                    arrayList7.add(measuredPage7);
                }
                i53++;
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
            for (int i54 = 0; i54 < size6; i54++) {
                MeasuredPage measuredPage8 = calculatePagesOffsets.get(i54);
                if (measuredPage8.getIndex() > ((MeasuredPage) arrayDeque.last()).getIndex()) {
                    arrayList8.add(measuredPage8);
                }
            }
            arrayList3 = arrayList8;
        }
        List list4 = arrayList3;
        MeasuredPage calculateNewCurrentPage = calculateNewCurrentPage(i2 + i3 + i4, arrayList, i3, i4, coerceAtLeast, snapPosition, i);
        return new PagerMeasureResult(arrayList, i8, i5, i4, orientation, i20, i28, z, i9, measuredPage, calculateNewCurrentPage, coerceAtLeast == 0 ? 0.0f : RangesKt.coerceIn((snapPosition.position(i15, i8, i3, i4, calculateNewCurrentPage != null ? calculateNewCurrentPage.getIndex() : 0, i) - (calculateNewCurrentPage != null ? calculateNewCurrentPage.getOffset() : 0)) / coerceAtLeast, -0.5f, 0.5f), i46, i50 < i || i51 > i2, snapPosition, function3.invoke(Integer.valueOf(m6654constrainWidthK40F9xA), Integer.valueOf(m6653constrainHeightK40F9xA), new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.pager.PagerMeasureKt$measurePager$14
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                invoke2(placementScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Placeable.PlacementScope placementScope) {
                final List<MeasuredPage> list5 = calculatePagesOffsets;
                placementScope.withMotionFrameOfReferencePlacement(new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.pager.PagerMeasureKt$measurePager$14.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope2) {
                        invoke2(placementScope2);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2(Placeable.PlacementScope placementScope2) {
                        List<MeasuredPage> list6 = list5;
                        int size7 = list6.size();
                        for (int i55 = 0; i55 < size7; i55++) {
                            list6.get(i55).place(placementScope2);
                        }
                    }
                });
                ObservableScopeInvalidator.m918attachToScopeimpl(mutableState);
            }
        }), z4, list3, list4, coroutineScope);
    }

    private static final List<MeasuredPage> createPagesAfterList(int i, int i2, int i3, List<Integer> list, Function1<? super Integer, MeasuredPage> function1) {
        int min = Math.min(i3 + i, i2 - 1);
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
    /* renamed from: getAndMeasure-SGf7dI0  reason: not valid java name */
    public static final MeasuredPage m989getAndMeasureSGf7dI0(LazyLayoutMeasureScope lazyLayoutMeasureScope, int i, long j, PagerLazyLayoutItemProvider pagerLazyLayoutItemProvider, long j2, Orientation orientation, Alignment.Horizontal horizontal, Alignment.Vertical vertical, LayoutDirection layoutDirection, boolean z, int i2) {
        return new MeasuredPage(i, i2, lazyLayoutMeasureScope.mo912measure0kLqBqw(i, j), j2, pagerLazyLayoutItemProvider.getKey(i), orientation, horizontal, vertical, layoutDirection, z, null);
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
            Arrangement.HorizontalOrVertical m622spacedBy0680j_4 = Arrangement.Absolute.INSTANCE.m622spacedBy0680j_4(lazyLayoutMeasureScope.mo386toDpu2uoSUM(i6));
            if (orientation == Orientation.Vertical) {
                m622spacedBy0680j_4.arrange(density, i10, iArr, iArr2);
                arrayList = arrayList2;
            } else {
                arrayList = arrayList2;
                m622spacedBy0680j_4.arrange(density, i10, iArr, LayoutDirection.Ltr, iArr2);
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
}
