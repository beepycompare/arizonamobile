package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasuredItemKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutStickyItemsKt;
import androidx.compose.foundation.lazy.layout.ObservableScopeInvalidator;
import androidx.compose.foundation.lazy.layout.StickyItemsPlacement;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.math.MathKt;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
/* compiled from: LazyGridMeasure.kt */
@Metadata(d1 = {"\u0000¸\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u000b\n\u0002\u0010\u0011\n\u0002\b\u0002\u001aü\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010\u001e\u001a\u00020\u00032\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00030 2\u0006\u0010!\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\u00132\b\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*23\u0010+\u001a/\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0011000 0,2!\u00101\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(2\u0012\u0004\u0012\u00020\u00030,2\b\u00103\u001a\u0004\u0018\u0001042/\u00105\u001a+\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u0002080,¢\u0006\u0002\b9\u0012\u0004\u0012\u00020:06H\u0000¢\u0006\u0004\b;\u0010<\u001aA\u0010=\u001a\b\u0012\u0004\u0012\u00020\u001d0 2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00030 2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010>\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00130,H\u0082\b\u001aF\u0010?\u001a\b\u0012\u0004\u0012\u00020@0 2\u0006\u0010A\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u00132\f\u0010B\u001a\b\u0012\u0004\u0012\u00020@0 2\b\u0010C\u001a\u0004\u0018\u00010$H\u0002\u001a\u008c\u0001\u0010D\u001a\b\u0012\u0004\u0012\u00020\u001d0E2\f\u0010F\u001a\b\u0012\u0004\u0012\u00020@0 2\f\u0010G\u001a\b\u0012\u0004\u0012\u00020\u001d0 2\f\u0010H\u001a\b\u0012\u0004\u0012\u00020\u001d0 2\u0006\u0010I\u001a\u00020\u00032\u0006\u0010J\u001a\u00020\u00032\u0006\u0010K\u001a\u00020\u00032\u0006\u0010L\u001a\u00020\u00032\u0006\u0010M\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001aH\u0002\u001a+\u0010N\u001a\u000208\"\u0004\b\u0000\u0010O*\b\u0012\u0004\u0012\u0002HO0E2\f\u0010P\u001a\b\u0012\u0004\u0012\u0002HO0QH\u0002¢\u0006\u0002\u0010R¨\u0006S"}, d2 = {"measureLazyGrid", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasureResult;", "itemsCount", "", "measuredLineProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredLineProvider;", "measuredItemProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItemProvider;", "mainAxisAvailableSize", "beforeContentPadding", "afterContentPadding", "spaceBetweenLines", "firstVisibleLineIndex", "firstVisibleLineScrollOffset", "scrollToBeConsumed", "", "constraints", "Landroidx/compose/ui/unit/Constraints;", "isVertical", "", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "reverseLayout", "density", "Landroidx/compose/ui/unit/Density;", "itemAnimator", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;", "slotsPerLine", "pinnedItems", "", "isInLookaheadScope", "isLookingAhead", "approachLayoutInfo", "Landroidx/compose/foundation/lazy/grid/LazyGridLayoutInfo;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "placementScopeInvalidator", "Landroidx/compose/foundation/lazy/layout/ObservableScopeInvalidator;", "graphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "prefetchInfoRetriever", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "line", "Lkotlin/Pair;", "lineIndexProvider", "itemIndex", "stickyItemsScrollBehavior", "Landroidx/compose/foundation/lazy/layout/StickyItemsPlacement;", "layout", "Lkotlin/Function3;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "", "Lkotlin/ExtensionFunctionType;", "Landroidx/compose/ui/layout/MeasureResult;", "measureLazyGrid-t1x4au0", "(ILandroidx/compose/foundation/lazy/grid/LazyGridMeasuredLineProvider;Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItemProvider;IIIIIIFJZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;ZLandroidx/compose/ui/unit/Density;Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;ILjava/util/List;ZZLandroidx/compose/foundation/lazy/grid/LazyGridLayoutInfo;Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/runtime/MutableState;Landroidx/compose/ui/graphics/GraphicsContext;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/lazy/layout/StickyItemsPlacement;Lkotlin/jvm/functions/Function3;)Landroidx/compose/foundation/lazy/grid/LazyGridMeasureResult;", "calculateExtraItems", "filter", "linesRetainedForLookahead", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredLine;", "lastVisibleItemIndex", "visibleLines", "lastApproachLayoutInfo", "calculateItemsOffsets", "", "lines", "itemsBefore", "itemsAfter", "layoutWidth", "layoutHeight", "finalMainAxisOffset", "maxOffset", "firstLineScrollOffset", "addAllFromArray", ExifInterface.GPS_DIRECTION_TRUE, "arr", "", "(Ljava/util/List;[Ljava/lang/Object;)V", "foundation"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LazyGridMeasureKt {
    private static final int calculateItemsOffsets$reverseAware(int i, boolean z, int i2) {
        return !z ? i : (i2 - i) - 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x024e  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x02bc  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x02de  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0369  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0384  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x03a6  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x03ab  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x03b3  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x03b8  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x03c3  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x03d9  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0429  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0499 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:195:0x04ba  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x04bd  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01fa  */
    /* renamed from: measureLazyGrid-t1x4au0  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final LazyGridMeasureResult m958measureLazyGridt1x4au0(int i, final LazyGridMeasuredLineProvider lazyGridMeasuredLineProvider, LazyGridMeasuredItemProvider lazyGridMeasuredItemProvider, int i2, int i3, int i4, int i5, int i6, int i7, float f, long j, boolean z, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, boolean z2, Density density, LazyLayoutItemAnimator<LazyGridMeasuredItem> lazyLayoutItemAnimator, int i8, List<Integer> list, boolean z3, final boolean z4, LazyGridLayoutInfo lazyGridLayoutInfo, CoroutineScope coroutineScope, final MutableState<Unit> mutableState, GraphicsContext graphicsContext, Function1<? super Integer, ? extends List<Pair<Integer, Constraints>>> function1, Function1<? super Integer, Integer> function12, StickyItemsPlacement stickyItemsPlacement, Function3<? super Integer, ? super Integer, ? super Function1<? super Placeable.PlacementScope, Unit>, ? extends MeasureResult> function3) {
        int i9;
        int i10;
        int i11;
        float f2;
        float f3;
        int i12;
        LazyGridMeasuredLine lazyGridMeasuredLine;
        int i13;
        int i14;
        int size;
        ArrayList arrayList;
        List list2;
        int i15;
        int i16;
        ArrayDeque arrayDeque;
        List<LazyGridMeasuredLine> linesRetainedForLookahead;
        int size2;
        int i17;
        int size3;
        int i18;
        int m7525constrainWidthK40F9xA;
        int m7507getMaxHeightimpl;
        List plus;
        final LazyGridMeasuredItemProvider lazyGridMeasuredItemProvider2;
        int i19;
        boolean z5;
        Arrangement.Horizontal horizontal2;
        Density density2;
        int i20;
        Function3<? super Integer, ? super Integer, ? super Function1<? super Placeable.PlacementScope, Unit>, ? extends MeasureResult> function32;
        int i21;
        int i22;
        int i23;
        List list3;
        int i24;
        int i25;
        int i26;
        float f4;
        ArrayDeque arrayDeque2;
        int i27;
        int i28;
        int i29;
        int i30;
        int i31;
        LazyGridMeasuredItem[] items;
        LazyGridMeasuredItem lazyGridMeasuredItem;
        LazyGridMeasuredItem[] items2;
        LazyGridMeasuredItem lazyGridMeasuredItem2;
        int i32;
        int i33;
        int i34;
        int i35 = i;
        int i36 = true;
        if (!(i3 >= 0)) {
            InlineClassHelperKt.throwIllegalArgumentException("negative beforeContentPadding");
        }
        if (!(i4 >= 0)) {
            InlineClassHelperKt.throwIllegalArgumentException("negative afterContentPadding");
        }
        if (i35 <= 0) {
            int m7510getMinWidthimpl = Constraints.m7510getMinWidthimpl(j);
            int m7509getMinHeightimpl = Constraints.m7509getMinHeightimpl(j);
            lazyLayoutItemAnimator.onMeasured(0, m7510getMinWidthimpl, m7509getMinHeightimpl, new ArrayList(), lazyGridMeasuredItemProvider.getKeyIndexMap(), lazyGridMeasuredItemProvider, z, z4, i8, z3, 0, 0, coroutineScope, graphicsContext);
            if (!z4) {
                long m987getMinSizeToFitDisappearingItemsYbymL2g = lazyLayoutItemAnimator.m987getMinSizeToFitDisappearingItemsYbymL2g();
                if (!IntSize.m7724equalsimpl0(m987getMinSizeToFitDisappearingItemsYbymL2g, IntSize.Companion.m7731getZeroYbymL2g())) {
                    m7510getMinWidthimpl = ConstraintsKt.m7525constrainWidthK40F9xA(j, (int) (m987getMinSizeToFitDisappearingItemsYbymL2g >> 32));
                    m7509getMinHeightimpl = ConstraintsKt.m7524constrainHeightK40F9xA(j, (int) (m987getMinSizeToFitDisappearingItemsYbymL2g & 4294967295L));
                }
            }
            return new LazyGridMeasureResult(null, 0, false, 0.0f, function3.invoke(Integer.valueOf(m7510getMinWidthimpl), Integer.valueOf(m7509getMinHeightimpl), new Function1() { // from class: androidx.compose.foundation.lazy.grid.LazyGridMeasureKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit unit;
                    Placeable.PlacementScope placementScope = (Placeable.PlacementScope) obj;
                    unit = Unit.INSTANCE;
                    return unit;
                }
            }), 0.0f, false, coroutineScope, density, i8, function1, function12, CollectionsKt.emptyList(), -i3, i2 + i4, 0, z2, z ? Orientation.Vertical : Orientation.Horizontal, i4, i5);
        }
        int round = Math.round(f);
        int i37 = i7 - round;
        if (i6 == 0 && i37 < 0) {
            round += i37;
            i37 = 0;
        }
        ArrayDeque arrayDeque3 = new ArrayDeque();
        int i38 = -i3;
        int i39 = (i5 < 0 ? i5 : 0) + i38;
        int i40 = i37 + i39;
        int i41 = i6;
        while (i40 < 0 && i41 > 0) {
            i41--;
            LazyGridMeasuredLine andMeasure = lazyGridMeasuredLineProvider.getAndMeasure(i41);
            arrayDeque3.add(0, andMeasure);
            i40 += andMeasure.getMainAxisSizeWithSpacings();
        }
        if (i40 < i39) {
            round -= i39 - i40;
            i40 = i39;
        }
        int i42 = i40 - i39;
        int i43 = i2 + i4;
        int i44 = i41;
        int coerceAtLeast = RangesKt.coerceAtLeast(i43, 0);
        int i45 = -i42;
        int i46 = i44;
        int i47 = i38;
        int i48 = 0;
        boolean z6 = false;
        while (i48 < arrayDeque3.size()) {
            if (i45 >= coerceAtLeast) {
                arrayDeque3.remove(i48);
                Unit unit = Unit.INSTANCE;
                z6 = true;
            } else {
                i46++;
                i45 += ((LazyGridMeasuredLine) arrayDeque3.get(i48)).getMainAxisSizeWithSpacings();
                Integer.valueOf(i48);
                i48++;
            }
        }
        int i49 = i42;
        boolean z7 = z6;
        int i50 = i46;
        while (i50 < i35 && (i45 < coerceAtLeast || i45 <= 0 || arrayDeque3.isEmpty())) {
            LazyGridMeasuredLine andMeasure2 = lazyGridMeasuredLineProvider.getAndMeasure(i50);
            if (andMeasure2.isEmpty()) {
                break;
            }
            i45 += andMeasure2.getMainAxisSizeWithSpacings();
            if (i45 <= i39) {
                i32 = coerceAtLeast;
                i33 = i50;
                if (((LazyGridMeasuredItem) ArraysKt.last(andMeasure2.getItems())).getIndex() != i - 1) {
                    i34 = i33 + 1;
                    i49 -= andMeasure2.getMainAxisSizeWithSpacings();
                    Unit unit2 = Unit.INSTANCE;
                    z7 = true;
                    coerceAtLeast = i32;
                    i44 = i34;
                    i50 = i33 + 1;
                    i35 = i;
                }
            } else {
                i32 = coerceAtLeast;
                i33 = i50;
            }
            Boolean.valueOf(arrayDeque3.add(andMeasure2));
            i34 = i44;
            coerceAtLeast = i32;
            i44 = i34;
            i50 = i33 + 1;
            i35 = i;
        }
        if (i45 < i2) {
            int i51 = i2 - i45;
            i49 -= i51;
            i45 += i51;
            int i52 = i44;
            while (i49 < i3 && i52 > 0) {
                i52--;
                LazyGridMeasuredLine andMeasure3 = lazyGridMeasuredLineProvider.getAndMeasure(i52);
                arrayDeque3.add(0, andMeasure3);
                i49 += andMeasure3.getMainAxisSizeWithSpacings();
            }
            i9 = i51 + round;
            if (i49 < 0) {
                i9 += i49;
                i10 = i45 + i49;
                i11 = 0;
                float f5 = (MathKt.getSign(Math.round(f)) == MathKt.getSign(i9) || Math.abs(Math.round(f)) < Math.abs(i9)) ? f : i9;
                f2 = f - f5;
                f3 = 0.0f;
                if (z4 && i9 > round && f2 <= 0.0f) {
                    f3 = (i9 - round) + f2;
                }
                float f6 = f3;
                if (!(i11 < 0)) {
                    InlineClassHelperKt.throwIllegalArgumentException("negative initial offset");
                }
                i12 = -i11;
                LazyGridMeasuredLine lazyGridMeasuredLine2 = (LazyGridMeasuredLine) arrayDeque3.firstOrNull();
                int index = (lazyGridMeasuredLine2 != null || (items2 = lazyGridMeasuredLine2.getItems()) == null || (lazyGridMeasuredItem2 = (LazyGridMeasuredItem) ArraysKt.firstOrNull(items2)) == null) ? 0 : lazyGridMeasuredItem2.getIndex();
                lazyGridMeasuredLine = (LazyGridMeasuredLine) arrayDeque3.lastOrNull();
                if (lazyGridMeasuredLine != null || (items = lazyGridMeasuredLine.getItems()) == null || (lazyGridMeasuredItem = (LazyGridMeasuredItem) ArraysKt.lastOrNull(items)) == null) {
                    i13 = i12;
                    i14 = 0;
                } else {
                    i13 = i12;
                    i14 = lazyGridMeasuredItem.getIndex();
                }
                List<Integer> list4 = list;
                size = list4.size();
                arrayList = null;
                list2 = null;
                i15 = 0;
                while (i15 < size) {
                    int i53 = i14;
                    int intValue = list.get(i15).intValue();
                    if (intValue < 0 || intValue >= index) {
                        f4 = f5;
                        arrayDeque2 = arrayDeque3;
                        i27 = i10;
                        i28 = size;
                        i29 = i15;
                        i30 = i43;
                        i31 = i47;
                    } else {
                        i28 = size;
                        int spanOf = lazyGridMeasuredLineProvider.spanOf(intValue);
                        i29 = i15;
                        f4 = f5;
                        arrayDeque2 = arrayDeque3;
                        i31 = i47;
                        i30 = i43;
                        i27 = i10;
                        LazyGridMeasuredItem mo933getAndMeasurehBUhpc = lazyGridMeasuredItemProvider.mo933getAndMeasurehBUhpc(intValue, 0, spanOf, lazyGridMeasuredLineProvider.m962childConstraintsJhjzzOo$foundation(0, spanOf));
                        ArrayList arrayList2 = list2 == null ? new ArrayList() : list2;
                        arrayList2.add(mo933getAndMeasurehBUhpc);
                        list2 = arrayList2;
                    }
                    i15 = i29 + 1;
                    arrayDeque3 = arrayDeque2;
                    i10 = i27;
                    f5 = f4;
                    size = i28;
                    i47 = i31;
                    i43 = i30;
                    i14 = i53;
                }
                i16 = i14;
                float f7 = f5;
                arrayDeque = arrayDeque3;
                int i54 = i10;
                int i55 = i43;
                int i56 = i47;
                if (list2 == null) {
                    list2 = CollectionsKt.emptyList();
                }
                ArrayDeque arrayDeque4 = arrayDeque;
                int i57 = index;
                linesRetainedForLookahead = linesRetainedForLookahead(i16, i, lazyGridMeasuredLineProvider, z4, arrayDeque4, lazyGridLayoutInfo);
                int i58 = i;
                LazyGridMeasuredLineProvider lazyGridMeasuredLineProvider2 = lazyGridMeasuredLineProvider;
                size2 = list4.size();
                i17 = 0;
                while (i17 < size2) {
                    int intValue2 = list.get(i17).intValue();
                    if (i16 + 1 > intValue2 || intValue2 >= i58) {
                        i25 = size2;
                    } else {
                        if (z4) {
                            int size4 = linesRetainedForLookahead.size();
                            int i59 = 0;
                            while (i59 < size4) {
                                int i60 = i59;
                                LazyGridMeasuredItem[] items3 = linesRetainedForLookahead.get(i59).getItems();
                                int i61 = size2;
                                int length = items3.length;
                                int i62 = 0;
                                while (i62 < length) {
                                    int i63 = i62;
                                    if (items3[i62].getIndex() == intValue2) {
                                        i25 = i61;
                                    } else {
                                        i62 = i63 + 1;
                                    }
                                }
                                i59 = i60 + 1;
                                size2 = i61;
                            }
                        }
                        int i64 = i17;
                        int spanOf2 = lazyGridMeasuredLineProvider2.spanOf(intValue2);
                        i25 = size2;
                        i26 = i64;
                        LazyGridMeasuredItem mo933getAndMeasurehBUhpc2 = lazyGridMeasuredItemProvider.mo933getAndMeasurehBUhpc(intValue2, 0, spanOf2, lazyGridMeasuredLineProvider2.m962childConstraintsJhjzzOo$foundation(0, spanOf2));
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        List list5 = arrayList;
                        list5.add(mo933getAndMeasurehBUhpc2);
                        arrayList = list5;
                        i17 = i26 + 1;
                        i58 = i;
                        lazyGridMeasuredLineProvider2 = lazyGridMeasuredLineProvider;
                        size2 = i25;
                    }
                    i26 = i17;
                    i17 = i26 + 1;
                    i58 = i;
                    lazyGridMeasuredLineProvider2 = lazyGridMeasuredLineProvider;
                    size2 = i25;
                }
                if (arrayList == null) {
                    arrayList = CollectionsKt.emptyList();
                }
                List list6 = arrayList;
                if (i3 <= 0 || i5 < 0) {
                    size3 = arrayDeque.size();
                    i18 = 0;
                    while (i18 < size3) {
                        int mainAxisSizeWithSpacings = ((LazyGridMeasuredLine) arrayDeque.get(i18)).getMainAxisSizeWithSpacings();
                        if (i11 == 0 || mainAxisSizeWithSpacings > i11 || i18 == CollectionsKt.getLastIndex(arrayDeque4)) {
                            break;
                        }
                        i11 -= mainAxisSizeWithSpacings;
                        i18++;
                        lazyGridMeasuredLine2 = (LazyGridMeasuredLine) arrayDeque.get(i18);
                    }
                }
                int i65 = i11;
                LazyGridMeasuredLine lazyGridMeasuredLine3 = lazyGridMeasuredLine2;
                if (!z) {
                    m7525constrainWidthK40F9xA = Constraints.m7508getMaxWidthimpl(j);
                } else {
                    m7525constrainWidthK40F9xA = ConstraintsKt.m7525constrainWidthK40F9xA(j, i54);
                }
                int i66 = m7525constrainWidthK40F9xA;
                if (!z) {
                    m7507getMaxHeightimpl = ConstraintsKt.m7524constrainHeightK40F9xA(j, i54);
                } else {
                    m7507getMaxHeightimpl = Constraints.m7507getMaxHeightimpl(j);
                }
                int i67 = m7507getMaxHeightimpl;
                if (linesRetainedForLookahead.isEmpty()) {
                    plus = CollectionsKt.plus((Collection) arrayDeque, (Iterable) linesRetainedForLookahead);
                    lazyGridMeasuredItemProvider2 = lazyGridMeasuredItemProvider;
                    i19 = i2;
                    z5 = z;
                    horizontal2 = horizontal;
                    density2 = density;
                    i20 = i54;
                    function32 = function3;
                    i21 = i66;
                    i22 = i13;
                    i23 = false;
                    list3 = list2;
                } else {
                    plus = arrayDeque4;
                    lazyGridMeasuredItemProvider2 = lazyGridMeasuredItemProvider;
                    i19 = i2;
                    horizontal2 = horizontal;
                    density2 = density;
                    i20 = i54;
                    function32 = function3;
                    i21 = i66;
                    i22 = i13;
                    i23 = false;
                    list3 = list2;
                    z5 = z;
                }
                final List<LazyGridMeasuredItem> calculateItemsOffsets = calculateItemsOffsets(plus, list3, list6, i21, i67, i20, i19, i22, z5, vertical, horizontal2, z2, density2);
                int i68 = i20;
                int i69 = i19;
                lazyLayoutItemAnimator.onMeasured((int) f7, i21, i67, calculateItemsOffsets, lazyGridMeasuredItemProvider2.getKeyIndexMap(), lazyGridMeasuredItemProvider2, z, z4, i8, z3, i65, i68, coroutineScope, graphicsContext);
                if (!z4) {
                    long m987getMinSizeToFitDisappearingItemsYbymL2g2 = lazyLayoutItemAnimator.m987getMinSizeToFitDisappearingItemsYbymL2g();
                    if (!IntSize.m7724equalsimpl0(m987getMinSizeToFitDisappearingItemsYbymL2g2, IntSize.Companion.m7731getZeroYbymL2g())) {
                        int i70 = z ? i67 : i21;
                        int m7525constrainWidthK40F9xA2 = ConstraintsKt.m7525constrainWidthK40F9xA(j, Math.max(i21, (int) (m987getMinSizeToFitDisappearingItemsYbymL2g2 >> 32)));
                        i67 = ConstraintsKt.m7524constrainHeightK40F9xA(j, Math.max(i67, (int) (m987getMinSizeToFitDisappearingItemsYbymL2g2 & 4294967295L)));
                        int i71 = z ? i67 : m7525constrainWidthK40F9xA2;
                        if (i71 != i70) {
                            int size5 = calculateItemsOffsets.size();
                            for (int i72 = i23; i72 < size5; i72++) {
                                calculateItemsOffsets.get(i72).updateMainAxisLayoutSize(i71);
                            }
                        }
                        i24 = m7525constrainWidthK40F9xA2;
                        int i73 = i67;
                        final List applyStickyItems = LazyLayoutStickyItemsKt.applyStickyItems(stickyItemsPlacement, i57, i16, calculateItemsOffsets, lazyGridMeasuredItemProvider2.getHeaderIndices(), i3, i4, i24, i73, new Function1() { // from class: androidx.compose.foundation.lazy.grid.LazyGridMeasureKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return LazyGridMeasureKt.measureLazyGrid_t1x4au0$lambda$7(LazyGridMeasuredLineProvider.this, lazyGridMeasuredItemProvider2, ((Integer) obj).intValue());
                            }
                        });
                        if (i16 == i - 1 && i68 <= i69) {
                            i36 = i23;
                        }
                        return new LazyGridMeasureResult(lazyGridMeasuredLine3, i65, i36, f7, function32.invoke(Integer.valueOf(i24), Integer.valueOf(i73), new Function1() { // from class: androidx.compose.foundation.lazy.grid.LazyGridMeasureKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return LazyGridMeasureKt.measureLazyGrid_t1x4au0$lambda$8(MutableState.this, calculateItemsOffsets, applyStickyItems, z4, (Placeable.PlacementScope) obj);
                            }
                        }), f6, z7, coroutineScope, density, i8, function1, function12, LazyLayoutMeasuredItemKt.updatedVisibleItems(i57, i16, calculateItemsOffsets, applyStickyItems), i56, i55, i, z2, z ? Orientation.Vertical : Orientation.Horizontal, i4, i5);
                    }
                }
                i24 = i21;
                int i732 = i67;
                final List applyStickyItems2 = LazyLayoutStickyItemsKt.applyStickyItems(stickyItemsPlacement, i57, i16, calculateItemsOffsets, lazyGridMeasuredItemProvider2.getHeaderIndices(), i3, i4, i24, i732, new Function1() { // from class: androidx.compose.foundation.lazy.grid.LazyGridMeasureKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return LazyGridMeasureKt.measureLazyGrid_t1x4au0$lambda$7(LazyGridMeasuredLineProvider.this, lazyGridMeasuredItemProvider2, ((Integer) obj).intValue());
                    }
                });
                if (i16 == i - 1) {
                    i36 = i23;
                }
                return new LazyGridMeasureResult(lazyGridMeasuredLine3, i65, i36, f7, function32.invoke(Integer.valueOf(i24), Integer.valueOf(i732), new Function1() { // from class: androidx.compose.foundation.lazy.grid.LazyGridMeasureKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return LazyGridMeasureKt.measureLazyGrid_t1x4au0$lambda$8(MutableState.this, calculateItemsOffsets, applyStickyItems2, z4, (Placeable.PlacementScope) obj);
                    }
                }), f6, z7, coroutineScope, density, i8, function1, function12, LazyLayoutMeasuredItemKt.updatedVisibleItems(i57, i16, calculateItemsOffsets, applyStickyItems2), i56, i55, i, z2, z ? Orientation.Vertical : Orientation.Horizontal, i4, i5);
            }
        } else {
            i9 = round;
        }
        i10 = i45;
        i11 = i49;
        if (MathKt.getSign(Math.round(f)) == MathKt.getSign(i9)) {
        }
        f2 = f - f5;
        f3 = 0.0f;
        if (z4) {
            f3 = (i9 - round) + f2;
        }
        float f62 = f3;
        if (!(i11 < 0)) {
        }
        i12 = -i11;
        LazyGridMeasuredLine lazyGridMeasuredLine22 = (LazyGridMeasuredLine) arrayDeque3.firstOrNull();
        if (lazyGridMeasuredLine22 != null) {
        }
        lazyGridMeasuredLine = (LazyGridMeasuredLine) arrayDeque3.lastOrNull();
        if (lazyGridMeasuredLine != null) {
        }
        i13 = i12;
        i14 = 0;
        List<Integer> list42 = list;
        size = list42.size();
        arrayList = null;
        list2 = null;
        i15 = 0;
        while (i15 < size) {
        }
        i16 = i14;
        float f72 = f5;
        arrayDeque = arrayDeque3;
        int i542 = i10;
        int i552 = i43;
        int i562 = i47;
        if (list2 == null) {
        }
        ArrayDeque arrayDeque42 = arrayDeque;
        int i572 = index;
        linesRetainedForLookahead = linesRetainedForLookahead(i16, i, lazyGridMeasuredLineProvider, z4, arrayDeque42, lazyGridLayoutInfo);
        int i582 = i;
        LazyGridMeasuredLineProvider lazyGridMeasuredLineProvider22 = lazyGridMeasuredLineProvider;
        size2 = list42.size();
        i17 = 0;
        while (i17 < size2) {
        }
        if (arrayList == null) {
        }
        List list62 = arrayList;
        if (i3 <= 0) {
        }
        size3 = arrayDeque.size();
        i18 = 0;
        while (i18 < size3) {
        }
        int i652 = i11;
        LazyGridMeasuredLine lazyGridMeasuredLine32 = lazyGridMeasuredLine22;
        if (!z) {
        }
        int i662 = m7525constrainWidthK40F9xA;
        if (!z) {
        }
        int i672 = m7507getMaxHeightimpl;
        if (linesRetainedForLookahead.isEmpty()) {
        }
        final List calculateItemsOffsets2 = calculateItemsOffsets(plus, list3, list62, i21, i672, i20, i19, i22, z5, vertical, horizontal2, z2, density2);
        int i682 = i20;
        int i692 = i19;
        lazyLayoutItemAnimator.onMeasured((int) f72, i21, i672, calculateItemsOffsets2, lazyGridMeasuredItemProvider2.getKeyIndexMap(), lazyGridMeasuredItemProvider2, z, z4, i8, z3, i652, i682, coroutineScope, graphicsContext);
        if (!z4) {
        }
        i24 = i21;
        int i7322 = i672;
        final List applyStickyItems22 = LazyLayoutStickyItemsKt.applyStickyItems(stickyItemsPlacement, i572, i16, calculateItemsOffsets2, lazyGridMeasuredItemProvider2.getHeaderIndices(), i3, i4, i24, i7322, new Function1() { // from class: androidx.compose.foundation.lazy.grid.LazyGridMeasureKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LazyGridMeasureKt.measureLazyGrid_t1x4au0$lambda$7(LazyGridMeasuredLineProvider.this, lazyGridMeasuredItemProvider2, ((Integer) obj).intValue());
            }
        });
        if (i16 == i - 1) {
        }
        return new LazyGridMeasureResult(lazyGridMeasuredLine32, i652, i36, f72, function32.invoke(Integer.valueOf(i24), Integer.valueOf(i7322), new Function1() { // from class: androidx.compose.foundation.lazy.grid.LazyGridMeasureKt$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LazyGridMeasureKt.measureLazyGrid_t1x4au0$lambda$8(MutableState.this, calculateItemsOffsets2, applyStickyItems22, z4, (Placeable.PlacementScope) obj);
            }
        }), f62, z7, coroutineScope, density, i8, function1, function12, LazyLayoutMeasuredItemKt.updatedVisibleItems(i572, i16, calculateItemsOffsets2, applyStickyItems22), i562, i552, i, z2, z ? Orientation.Vertical : Orientation.Horizontal, i4, i5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final LazyGridMeasuredItem measureLazyGrid_t1x4au0$lambda$7(LazyGridMeasuredLineProvider lazyGridMeasuredLineProvider, LazyGridMeasuredItemProvider lazyGridMeasuredItemProvider, int i) {
        int spanOf = lazyGridMeasuredLineProvider.spanOf(i);
        return lazyGridMeasuredItemProvider.mo933getAndMeasurehBUhpc(i, 0, spanOf, lazyGridMeasuredLineProvider.m962childConstraintsJhjzzOo$foundation(0, spanOf));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit measureLazyGrid_t1x4au0$lambda$8(MutableState mutableState, final List list, final List list2, final boolean z, Placeable.PlacementScope placementScope) {
        placementScope.withMotionFrameOfReferencePlacement(new Function1() { // from class: androidx.compose.foundation.lazy.grid.LazyGridMeasureKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit measureLazyGrid_t1x4au0$lambda$8$0;
                measureLazyGrid_t1x4au0$lambda$8$0 = LazyGridMeasureKt.measureLazyGrid_t1x4au0$lambda$8$0(list, list2, z, (Placeable.PlacementScope) obj);
                return measureLazyGrid_t1x4au0$lambda$8$0;
            }
        });
        ObservableScopeInvalidator.m1005attachToScopeimpl(mutableState);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x003a, code lost:
        r6 = r9.get(r1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final List<LazyGridMeasuredLine> linesRetainedForLookahead(int i, int i2, LazyGridMeasuredLineProvider lazyGridMeasuredLineProvider, boolean z, List<LazyGridMeasuredLine> list, LazyGridLayoutInfo lazyGridLayoutInfo) {
        LazyGridItemInfo lazyGridItemInfo;
        int index;
        int min;
        ArrayList arrayList = null;
        if (z && lazyGridLayoutInfo != null && !lazyGridLayoutInfo.getVisibleItemsInfo().isEmpty()) {
            List<LazyGridItemInfo> visibleItemsInfo = lazyGridLayoutInfo.getVisibleItemsInfo();
            int size = visibleItemsInfo.size();
            while (true) {
                size--;
                if (-1 >= size) {
                    lazyGridItemInfo = null;
                    break;
                } else if (visibleItemsInfo.get(size).getIndex() <= i || (size != 0 && visibleItemsInfo.get(size - 1).getIndex() > i)) {
                }
            }
            LazyGridItemInfo lazyGridItemInfo2 = (LazyGridItemInfo) CollectionsKt.last((List<? extends Object>) lazyGridLayoutInfo.getVisibleItemsInfo());
            LazyGridMeasuredLine lazyGridMeasuredLine = (LazyGridMeasuredLine) CollectionsKt.lastOrNull((List<? extends Object>) list);
            int index2 = lazyGridMeasuredLine != null ? lazyGridMeasuredLine.getIndex() + 1 : 0;
            if (lazyGridItemInfo != null && (index = lazyGridItemInfo.getIndex()) <= (min = Math.min(lazyGridItemInfo2.getIndex(), i2 - 1))) {
                while (true) {
                    if (arrayList != null) {
                        int size2 = arrayList.size();
                        for (int i3 = 0; i3 < size2; i3++) {
                            for (LazyGridMeasuredItem lazyGridMeasuredItem : arrayList.get(i3).getItems()) {
                                if (lazyGridMeasuredItem.getIndex() == index) {
                                    break;
                                }
                            }
                        }
                    }
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    LazyGridMeasuredLine andMeasure = lazyGridMeasuredLineProvider.getAndMeasure(index2);
                    index2++;
                    arrayList.add(andMeasure);
                    if (index == min) {
                        break;
                    }
                    index++;
                }
            }
        }
        return arrayList == null ? CollectionsKt.emptyList() : arrayList;
    }

    private static final List<LazyGridMeasuredItem> calculateItemsOffsets(List<LazyGridMeasuredLine> list, List<LazyGridMeasuredItem> list2, List<LazyGridMeasuredItem> list3, int i, int i2, int i3, int i4, int i5, boolean z, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, boolean z2, Density density) {
        int i6 = z ? i2 : i;
        boolean z3 = true;
        boolean z4 = i3 < Math.min(i6, i4);
        if (z4) {
            if (!(i5 == 0)) {
                InlineClassHelperKt.throwIllegalStateException("non-zero firstLineScrollOffset");
            }
        }
        List<LazyGridMeasuredLine> list4 = list;
        int size = list4.size();
        int i7 = 0;
        for (int i8 = 0; i8 < size; i8++) {
            i7 += list.get(i8).getItems().length;
        }
        ArrayList arrayList = new ArrayList(i7);
        if (z4) {
            if (!((list2.isEmpty() && list3.isEmpty()) ? false : false)) {
                InlineClassHelperKt.throwIllegalArgumentException("no items");
            }
            int size2 = list.size();
            int[] iArr = new int[size2];
            for (int i9 = 0; i9 < size2; i9++) {
                iArr[i9] = list.get(calculateItemsOffsets$reverseAware(i9, z2, size2)).getMainAxisSize();
            }
            int[] iArr2 = new int[size2];
            if (z) {
                if (vertical != null) {
                    vertical.arrange(density, i6, iArr, iArr2);
                } else {
                    InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("null verticalArrangement");
                    throw new KotlinNothingValueException();
                }
            } else if (horizontal != null) {
                horizontal.arrange(density, i6, iArr, LayoutDirection.Ltr, iArr2);
            } else {
                InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("null horizontalArrangement");
                throw new KotlinNothingValueException();
            }
            IntRange indices = ArraysKt.getIndices(iArr2);
            if (z2) {
                indices = RangesKt.reversed(indices);
            }
            int first = indices.getFirst();
            int last = indices.getLast();
            int step = indices.getStep();
            if ((step > 0 && first <= last) || (step < 0 && last <= first)) {
                while (true) {
                    int i10 = iArr2[first];
                    LazyGridMeasuredLine lazyGridMeasuredLine = list.get(calculateItemsOffsets$reverseAware(first, z2, size2));
                    if (z2) {
                        i10 = (i6 - i10) - lazyGridMeasuredLine.getMainAxisSize();
                    }
                    addAllFromArray(arrayList, lazyGridMeasuredLine.position(i10, i, i2));
                    if (first == last) {
                        break;
                    }
                    first += step;
                }
            }
        } else {
            int size3 = list2.size() - 1;
            if (size3 >= 0) {
                int i11 = i5;
                while (true) {
                    int i12 = size3 - 1;
                    LazyGridMeasuredItem lazyGridMeasuredItem = list2.get(size3);
                    i11 -= lazyGridMeasuredItem.getMainAxisSizeWithSpacings();
                    lazyGridMeasuredItem.position(i11, 0, i, i2);
                    arrayList.add(lazyGridMeasuredItem);
                    if (i12 < 0) {
                        break;
                    }
                    size3 = i12;
                }
            }
            int size4 = list4.size();
            int i13 = i5;
            for (int i14 = 0; i14 < size4; i14++) {
                LazyGridMeasuredLine lazyGridMeasuredLine2 = list.get(i14);
                addAllFromArray(arrayList, lazyGridMeasuredLine2.position(i13, i, i2));
                i13 += lazyGridMeasuredLine2.getMainAxisSizeWithSpacings();
            }
            int size5 = list3.size();
            for (int i15 = 0; i15 < size5; i15++) {
                LazyGridMeasuredItem lazyGridMeasuredItem2 = list3.get(i15);
                lazyGridMeasuredItem2.position(i13, 0, i, i2);
                arrayList.add(lazyGridMeasuredItem2);
                i13 += lazyGridMeasuredItem2.getMainAxisSizeWithSpacings();
            }
        }
        return arrayList;
    }

    private static final <T> void addAllFromArray(List<T> list, T[] tArr) {
        for (T t : tArr) {
            list.add(t);
        }
    }

    private static final List<LazyGridMeasuredItem> calculateExtraItems(List<Integer> list, LazyGridMeasuredItemProvider lazyGridMeasuredItemProvider, LazyGridMeasuredLineProvider lazyGridMeasuredLineProvider, Function1<? super Integer, Boolean> function1) {
        LazyGridMeasuredItemProvider lazyGridMeasuredItemProvider2;
        int size = list.size();
        ArrayList arrayList = null;
        int i = 0;
        while (i < size) {
            int intValue = list.get(i).intValue();
            if (function1.invoke(Integer.valueOf(intValue)).booleanValue()) {
                int spanOf = lazyGridMeasuredLineProvider.spanOf(intValue);
                lazyGridMeasuredItemProvider2 = lazyGridMeasuredItemProvider;
                LazyGridMeasuredItem mo933getAndMeasurehBUhpc = lazyGridMeasuredItemProvider2.mo933getAndMeasurehBUhpc(intValue, 0, spanOf, lazyGridMeasuredLineProvider.m962childConstraintsJhjzzOo$foundation(0, spanOf));
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(mo933getAndMeasurehBUhpc);
            } else {
                lazyGridMeasuredItemProvider2 = lazyGridMeasuredItemProvider;
            }
            i++;
            lazyGridMeasuredItemProvider = lazyGridMeasuredItemProvider2;
        }
        return arrayList == null ? CollectionsKt.emptyList() : arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measureLazyGrid_t1x4au0$lambda$8$0(List list, List list2, boolean z, Placeable.PlacementScope placementScope) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            ((LazyGridMeasuredItem) list.get(i)).place(placementScope, z);
        }
        int size2 = list2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            ((LazyGridMeasuredItem) list2.get(i2)).place(placementScope, z);
        }
        return Unit.INSTANCE;
    }
}
