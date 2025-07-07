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
import androidx.media3.extractor.text.ttml.TtmlNode;
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
@Metadata(d1 = {"\u0000´\u0001\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0002\u001aA\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\nH\u0082\b\u001a\u008c\u0001\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002\u001aF\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00012\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\u000b2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00012\b\u0010$\u001a\u0004\u0018\u00010%H\u0002\u001aÜ\u0002\u0010&\u001a\u00020'2\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\u00042\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u0010\u0017\u001a\u00020\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001e2\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u0002032\u0006\u00104\u001a\u00020\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00040\u00012\u0006\u00105\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u000b2\b\u00106\u001a\u0004\u0018\u00010%2\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<23\u0010=\u001a/\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b>\u0012\b\b?\u0012\u0004\b\b(@\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u0002010A0\u00010\n2\b\u0010B\u001a\u0004\u0018\u00010C2/\u0010D\u001a+\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020F\u0012\u0004\u0012\u00020G0\n¢\u0006\u0002\bH\u0012\u0004\u0012\u00020I0EH\u0000ø\u0001\u0000¢\u0006\u0004\bJ\u0010K\u001a+\u0010L\u001a\u00020G\"\u0004\b\u0000\u0010M*\b\u0012\u0004\u0012\u0002HM0\r2\f\u0010N\u001a\b\u0012\u0004\u0012\u0002HM0OH\u0002¢\u0006\u0002\u0010P\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006Q"}, d2 = {"calculateExtraItems", "", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;", "pinnedItems", "", "measuredItemProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItemProvider;", "measuredLineProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredLineProvider;", "filter", "Lkotlin/Function1;", "", "calculateItemsOffsets", "", "lines", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredLine;", "itemsBefore", "itemsAfter", "layoutWidth", "layoutHeight", "finalMainAxisOffset", "maxOffset", "firstLineScrollOffset", "isVertical", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "reverseLayout", "density", "Landroidx/compose/ui/unit/Density;", "linesRetainedForLookahead", "lastVisibleItemIndex", "itemsCount", "isLookingAhead", "visibleLines", "lastApproachLayoutInfo", "Landroidx/compose/foundation/lazy/grid/LazyGridLayoutInfo;", "measureLazyGrid", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasureResult;", "mainAxisAvailableSize", "beforeContentPadding", "afterContentPadding", "spaceBetweenLines", "firstVisibleLineIndex", "firstVisibleLineScrollOffset", "scrollToBeConsumed", "", "constraints", "Landroidx/compose/ui/unit/Constraints;", "itemAnimator", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "slotsPerLine", "isInLookaheadScope", "approachLayoutInfo", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "placementScopeInvalidator", "Landroidx/compose/foundation/lazy/layout/ObservableScopeInvalidator;", "graphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "prefetchInfoRetriever", "Lkotlin/ParameterName;", "name", "line", "Lkotlin/Pair;", "stickyItemsScrollBehavior", "Landroidx/compose/foundation/lazy/layout/StickyItemsPlacement;", TtmlNode.TAG_LAYOUT, "Lkotlin/Function3;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "", "Lkotlin/ExtensionFunctionType;", "Landroidx/compose/ui/layout/MeasureResult;", "measureLazyGrid-GyuLg2I", "(ILandroidx/compose/foundation/lazy/grid/LazyGridMeasuredLineProvider;Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItemProvider;IIIIIIFJZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;ZLandroidx/compose/ui/unit/Density;Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;ILjava/util/List;ZZLandroidx/compose/foundation/lazy/grid/LazyGridLayoutInfo;Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/runtime/MutableState;Landroidx/compose/ui/graphics/GraphicsContext;Lkotlin/jvm/functions/Function1;Landroidx/compose/foundation/lazy/layout/StickyItemsPlacement;Lkotlin/jvm/functions/Function3;)Landroidx/compose/foundation/lazy/grid/LazyGridMeasureResult;", "addAllFromArray", ExifInterface.GPS_DIRECTION_TRUE, "arr", "", "(Ljava/util/List;[Ljava/lang/Object;)V", "foundation_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LazyGridMeasureKt {
    private static final int calculateItemsOffsets$reverseAware(int i, boolean z, int i2) {
        return !z ? i : (i2 - i) - 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x0236  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x02a4  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x02ca  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x035b  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0376  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0398  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x039d  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x03a4  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x03a9  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x03b4  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x03b7  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0408  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0495  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0498  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x01e3  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01e6  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0205  */
    /* renamed from: measureLazyGrid-GyuLg2I  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final LazyGridMeasureResult m882measureLazyGridGyuLg2I(int i, final LazyGridMeasuredLineProvider lazyGridMeasuredLineProvider, final LazyGridMeasuredItemProvider lazyGridMeasuredItemProvider, int i2, int i3, int i4, int i5, int i6, int i7, float f, long j, boolean z, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, boolean z2, Density density, LazyLayoutItemAnimator<LazyGridMeasuredItem> lazyLayoutItemAnimator, int i8, List<Integer> list, boolean z3, final boolean z4, LazyGridLayoutInfo lazyGridLayoutInfo, CoroutineScope coroutineScope, final MutableState<Unit> mutableState, GraphicsContext graphicsContext, Function1<? super Integer, ? extends List<Pair<Integer, Constraints>>> function1, StickyItemsPlacement stickyItemsPlacement, Function3<? super Integer, ? super Integer, ? super Function1<? super Placeable.PlacementScope, Unit>, ? extends MeasureResult> function3) {
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
        ArrayDeque arrayDeque;
        int size2;
        int i16;
        int i17;
        int size3;
        int i18;
        int m6654constrainWidthK40F9xA;
        int m6636getMaxHeightimpl;
        int i19;
        int i20;
        int i21;
        float f4;
        ArrayDeque arrayDeque2;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        LazyGridMeasuredItem[] items;
        LazyGridMeasuredItem lazyGridMeasuredItem;
        int i27;
        int i28;
        boolean z5 = true;
        if (!(i3 >= 0)) {
            InlineClassHelperKt.throwIllegalArgumentException("negative beforeContentPadding");
        }
        if (!(i4 >= 0)) {
            InlineClassHelperKt.throwIllegalArgumentException("negative afterContentPadding");
        }
        if (i <= 0) {
            int m6639getMinWidthimpl = Constraints.m6639getMinWidthimpl(j);
            int m6638getMinHeightimpl = Constraints.m6638getMinHeightimpl(j);
            lazyLayoutItemAnimator.onMeasured(0, m6639getMinWidthimpl, m6638getMinHeightimpl, new ArrayList(), lazyGridMeasuredItemProvider.getKeyIndexMap(), lazyGridMeasuredItemProvider, z, z4, i8, z3, 0, 0, coroutineScope, graphicsContext);
            if (!z4) {
                long m906getMinSizeToFitDisappearingItemsYbymL2g = lazyLayoutItemAnimator.m906getMinSizeToFitDisappearingItemsYbymL2g();
                if (!IntSize.m6853equalsimpl0(m906getMinSizeToFitDisappearingItemsYbymL2g, IntSize.Companion.m6860getZeroYbymL2g())) {
                    m6639getMinWidthimpl = ConstraintsKt.m6654constrainWidthK40F9xA(j, (int) (m906getMinSizeToFitDisappearingItemsYbymL2g >> 32));
                    m6638getMinHeightimpl = ConstraintsKt.m6653constrainHeightK40F9xA(j, (int) (m906getMinSizeToFitDisappearingItemsYbymL2g & 4294967295L));
                }
            }
            return new LazyGridMeasureResult(null, 0, false, 0.0f, function3.invoke(Integer.valueOf(m6639getMinWidthimpl), Integer.valueOf(m6638getMinHeightimpl), new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridMeasureKt$measureLazyGrid$3
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2(Placeable.PlacementScope placementScope) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                    invoke2(placementScope);
                    return Unit.INSTANCE;
                }
            }), 0.0f, false, coroutineScope, density, i8, function1, CollectionsKt.emptyList(), -i3, i2 + i4, 0, z2, z ? Orientation.Vertical : Orientation.Horizontal, i4, i5);
        }
        int round = Math.round(f);
        int i29 = i7 - round;
        if (i6 == 0 && i29 < 0) {
            round += i29;
            i29 = 0;
        }
        ArrayDeque arrayDeque3 = new ArrayDeque();
        int i30 = -i3;
        int i31 = (i5 < 0 ? i5 : 0) + i30;
        int i32 = i29 + i31;
        int i33 = i6;
        while (i32 < 0 && i33 > 0) {
            i33--;
            LazyGridMeasuredLine andMeasure = lazyGridMeasuredLineProvider.getAndMeasure(i33);
            arrayDeque3.add(0, andMeasure);
            i32 += andMeasure.getMainAxisSizeWithSpacings();
        }
        if (i32 < i31) {
            round -= i31 - i32;
            i32 = i31;
        }
        int i34 = i32 - i31;
        int i35 = i2 + i4;
        int coerceAtLeast = RangesKt.coerceAtLeast(i35, 0);
        int i36 = -i34;
        int i37 = i33;
        int i38 = i37;
        int i39 = i30;
        int i40 = 0;
        boolean z6 = false;
        while (i40 < arrayDeque3.size()) {
            if (i36 >= coerceAtLeast) {
                arrayDeque3.remove(i40);
                z6 = true;
            } else {
                i38++;
                i36 += ((LazyGridMeasuredLine) arrayDeque3.get(i40)).getMainAxisSizeWithSpacings();
                i40++;
            }
        }
        int i41 = i37;
        boolean z7 = z6;
        int i42 = i38;
        while (i42 < i && (i36 < coerceAtLeast || i36 <= 0 || arrayDeque3.isEmpty())) {
            int i43 = coerceAtLeast;
            LazyGridMeasuredLine andMeasure2 = lazyGridMeasuredLineProvider.getAndMeasure(i42);
            if (andMeasure2.isEmpty()) {
                break;
            }
            i36 += andMeasure2.getMainAxisSizeWithSpacings();
            if (i36 <= i31) {
                i27 = i41;
                i28 = i42;
                if (((LazyGridMeasuredItem) ArraysKt.last(andMeasure2.getItems())).getIndex() != i - 1) {
                    i34 -= andMeasure2.getMainAxisSizeWithSpacings();
                    i41 = i28 + 1;
                    z7 = true;
                    i42 = i28 + 1;
                    coerceAtLeast = i43;
                }
            } else {
                i27 = i41;
                i28 = i42;
            }
            arrayDeque3.add(andMeasure2);
            i41 = i27;
            i42 = i28 + 1;
            coerceAtLeast = i43;
        }
        int i44 = i41;
        if (i36 < i2) {
            int i45 = i2 - i36;
            i34 -= i45;
            i36 += i45;
            int i46 = i44;
            while (i34 < i3 && i46 > 0) {
                i46--;
                LazyGridMeasuredLine andMeasure3 = lazyGridMeasuredLineProvider.getAndMeasure(i46);
                arrayDeque3.add(0, andMeasure3);
                i34 += andMeasure3.getMainAxisSizeWithSpacings();
            }
            i9 = i45 + round;
            if (i34 < 0) {
                i9 += i34;
                i10 = i36 + i34;
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
                LazyGridMeasuredLine lazyGridMeasuredLine2 = (LazyGridMeasuredLine) arrayDeque3.first();
                LazyGridMeasuredItem lazyGridMeasuredItem2 = (LazyGridMeasuredItem) ArraysKt.firstOrNull(lazyGridMeasuredLine2.getItems());
                int index = lazyGridMeasuredItem2 == null ? lazyGridMeasuredItem2.getIndex() : 0;
                lazyGridMeasuredLine = (LazyGridMeasuredLine) arrayDeque3.lastOrNull();
                if (lazyGridMeasuredLine != null || (items = lazyGridMeasuredLine.getItems()) == null || (lazyGridMeasuredItem = (LazyGridMeasuredItem) ArraysKt.lastOrNull(items)) == null) {
                    i13 = i12;
                    i14 = 0;
                } else {
                    i13 = i12;
                    i14 = lazyGridMeasuredItem.getIndex();
                }
                List<Integer> list3 = list;
                size = list3.size();
                arrayList = null;
                list2 = null;
                i15 = 0;
                while (i15 < size) {
                    int i47 = i14;
                    int intValue = list.get(i15).intValue();
                    if (intValue < 0 || intValue >= index) {
                        f4 = f5;
                        arrayDeque2 = arrayDeque3;
                        i22 = i10;
                        i23 = size;
                        i24 = i15;
                        i25 = i35;
                        i26 = i39;
                    } else {
                        i23 = size;
                        int spanOf = lazyGridMeasuredLineProvider.spanOf(intValue);
                        i24 = i15;
                        f4 = f5;
                        arrayDeque2 = arrayDeque3;
                        i25 = i35;
                        i22 = i10;
                        i26 = i39;
                        LazyGridMeasuredItem mo854getAndMeasurehBUhpc = lazyGridMeasuredItemProvider.mo854getAndMeasurehBUhpc(intValue, 0, spanOf, lazyGridMeasuredLineProvider.m886childConstraintsJhjzzOo$foundation_release(0, spanOf));
                        ArrayList arrayList2 = list2 == null ? new ArrayList() : list2;
                        arrayList2.add(mo854getAndMeasurehBUhpc);
                        list2 = arrayList2;
                    }
                    i15 = i24 + 1;
                    i39 = i26;
                    arrayDeque3 = arrayDeque2;
                    i10 = i22;
                    f5 = f4;
                    size = i23;
                    i35 = i25;
                    i14 = i47;
                }
                int i48 = i14;
                float f7 = f5;
                arrayDeque = arrayDeque3;
                int i49 = i10;
                int i50 = i35;
                int i51 = i39;
                if (list2 == null) {
                    list2 = CollectionsKt.emptyList();
                }
                ArrayDeque arrayDeque4 = arrayDeque;
                int i52 = index;
                int i53 = i13;
                List<LazyGridMeasuredLine> linesRetainedForLookahead = linesRetainedForLookahead(i48, i, lazyGridMeasuredLineProvider, z4, arrayDeque4, lazyGridLayoutInfo);
                int i54 = i48;
                int i55 = i;
                LazyGridMeasuredLineProvider lazyGridMeasuredLineProvider2 = lazyGridMeasuredLineProvider;
                size2 = list3.size();
                i16 = 0;
                while (i16 < size2) {
                    int intValue2 = list.get(i16).intValue();
                    int i56 = i54;
                    if (i56 + 1 <= intValue2 && intValue2 < i55) {
                        if (z4) {
                            int size4 = linesRetainedForLookahead.size();
                            int i57 = 0;
                            while (i57 < size4) {
                                int i58 = i57;
                                LazyGridMeasuredItem[] items2 = linesRetainedForLookahead.get(i57).getItems();
                                int i59 = size4;
                                int length = items2.length;
                                int i60 = 0;
                                while (i60 < length) {
                                    int i61 = i60;
                                    if (items2[i60].getIndex() != intValue2) {
                                        i60 = i61 + 1;
                                    }
                                }
                                i57 = i58 + 1;
                                size4 = i59;
                            }
                        }
                        int i62 = size2;
                        int spanOf2 = lazyGridMeasuredLineProvider2.spanOf(intValue2);
                        i19 = i56;
                        i21 = i16;
                        i20 = i62;
                        LazyGridMeasuredItem mo854getAndMeasurehBUhpc2 = lazyGridMeasuredItemProvider.mo854getAndMeasurehBUhpc(intValue2, 0, spanOf2, lazyGridMeasuredLineProvider2.m886childConstraintsJhjzzOo$foundation_release(0, spanOf2));
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        List list4 = arrayList;
                        list4.add(mo854getAndMeasurehBUhpc2);
                        arrayList = list4;
                        i16 = i21 + 1;
                        i55 = i;
                        lazyGridMeasuredLineProvider2 = lazyGridMeasuredLineProvider;
                        size2 = i20;
                        i54 = i19;
                    }
                    i19 = i56;
                    i20 = size2;
                    i21 = i16;
                    i16 = i21 + 1;
                    i55 = i;
                    lazyGridMeasuredLineProvider2 = lazyGridMeasuredLineProvider;
                    size2 = i20;
                    i54 = i19;
                }
                i17 = i54;
                if (arrayList == null) {
                    arrayList = CollectionsKt.emptyList();
                }
                List list5 = arrayList;
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
                int i63 = i11;
                LazyGridMeasuredLine lazyGridMeasuredLine3 = lazyGridMeasuredLine2;
                if (!z) {
                    m6654constrainWidthK40F9xA = Constraints.m6637getMaxWidthimpl(j);
                } else {
                    m6654constrainWidthK40F9xA = ConstraintsKt.m6654constrainWidthK40F9xA(j, i49);
                }
                int i64 = m6654constrainWidthK40F9xA;
                if (!z) {
                    m6636getMaxHeightimpl = ConstraintsKt.m6653constrainHeightK40F9xA(j, i49);
                } else {
                    m6636getMaxHeightimpl = Constraints.m6636getMaxHeightimpl(j);
                }
                int i65 = m6636getMaxHeightimpl;
                final List<LazyGridMeasuredItem> calculateItemsOffsets = calculateItemsOffsets(!linesRetainedForLookahead.isEmpty() ? arrayDeque4 : CollectionsKt.plus((Collection) arrayDeque, (Iterable) linesRetainedForLookahead), list2, list5, i64, i65, i49, i2, i53, z, vertical, horizontal, z2, density);
                lazyLayoutItemAnimator.onMeasured((int) f7, i64, i65, calculateItemsOffsets, lazyGridMeasuredItemProvider.getKeyIndexMap(), lazyGridMeasuredItemProvider, z, z4, i8, z3, i63, i49, coroutineScope, graphicsContext);
                int i66 = i64;
                if (!z4) {
                    long m906getMinSizeToFitDisappearingItemsYbymL2g2 = lazyLayoutItemAnimator.m906getMinSizeToFitDisappearingItemsYbymL2g();
                    if (!IntSize.m6853equalsimpl0(m906getMinSizeToFitDisappearingItemsYbymL2g2, IntSize.Companion.m6860getZeroYbymL2g())) {
                        int i67 = z ? i65 : i66;
                        i66 = ConstraintsKt.m6654constrainWidthK40F9xA(j, Math.max(i66, (int) (m906getMinSizeToFitDisappearingItemsYbymL2g2 >> 32)));
                        i65 = ConstraintsKt.m6653constrainHeightK40F9xA(j, Math.max(i65, (int) (m906getMinSizeToFitDisappearingItemsYbymL2g2 & 4294967295L)));
                        int i68 = z ? i65 : i66;
                        if (i68 != i67) {
                            int size5 = calculateItemsOffsets.size();
                            for (int i69 = 0; i69 < size5; i69++) {
                                calculateItemsOffsets.get(i69).updateMainAxisLayoutSize(i68);
                            }
                        }
                    }
                }
                int i70 = i66;
                int i71 = i65;
                final List applyStickyItems = LazyLayoutStickyItemsKt.applyStickyItems(stickyItemsPlacement, calculateItemsOffsets, lazyGridMeasuredItemProvider.getHeaderIndices(), i3, i4, i70, i71, new Function1<Integer, LazyGridMeasuredItem>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridMeasureKt$measureLazyGrid$stickingItems$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ LazyGridMeasuredItem invoke(Integer num) {
                        return invoke(num.intValue());
                    }

                    public final LazyGridMeasuredItem invoke(int i72) {
                        int spanOf3 = LazyGridMeasuredLineProvider.this.spanOf(i72);
                        return lazyGridMeasuredItemProvider.mo854getAndMeasurehBUhpc(i72, 0, spanOf3, LazyGridMeasuredLineProvider.this.m886childConstraintsJhjzzOo$foundation_release(0, spanOf3));
                    }
                });
                if (i17 == i - 1 && i49 <= i2) {
                    z5 = false;
                }
                return new LazyGridMeasureResult(lazyGridMeasuredLine3, i63, z5, f7, function3.invoke(Integer.valueOf(i70), Integer.valueOf(i71), new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridMeasureKt$measureLazyGrid$6
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
                        final List<LazyGridMeasuredItem> list6 = calculateItemsOffsets;
                        final List<LazyGridMeasuredItem> list7 = applyStickyItems;
                        final boolean z8 = z4;
                        placementScope.withMotionFrameOfReferencePlacement(new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridMeasureKt$measureLazyGrid$6.1
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
                                List<LazyGridMeasuredItem> list8 = list6;
                                boolean z9 = z8;
                                int size6 = list8.size();
                                for (int i72 = 0; i72 < size6; i72++) {
                                    list8.get(i72).place(placementScope2, z9);
                                }
                                List<LazyGridMeasuredItem> list9 = list7;
                                boolean z10 = z8;
                                int size7 = list9.size();
                                for (int i73 = 0; i73 < size7; i73++) {
                                    list9.get(i73).place(placementScope2, z10);
                                }
                            }
                        });
                        ObservableScopeInvalidator.m918attachToScopeimpl(mutableState);
                    }
                }), f6, z7, coroutineScope, density, i8, function1, LazyLayoutMeasuredItemKt.updatedVisibleItems(i52, i17, calculateItemsOffsets, applyStickyItems), i51, i50, i, z2, !z ? Orientation.Vertical : Orientation.Horizontal, i4, i5);
            }
        } else {
            i9 = round;
        }
        i10 = i36;
        i11 = i34;
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
        LazyGridMeasuredLine lazyGridMeasuredLine22 = (LazyGridMeasuredLine) arrayDeque3.first();
        LazyGridMeasuredItem lazyGridMeasuredItem22 = (LazyGridMeasuredItem) ArraysKt.firstOrNull(lazyGridMeasuredLine22.getItems());
        if (lazyGridMeasuredItem22 == null) {
        }
        lazyGridMeasuredLine = (LazyGridMeasuredLine) arrayDeque3.lastOrNull();
        if (lazyGridMeasuredLine != null) {
        }
        i13 = i12;
        i14 = 0;
        List<Integer> list32 = list;
        size = list32.size();
        arrayList = null;
        list2 = null;
        i15 = 0;
        while (i15 < size) {
        }
        int i482 = i14;
        float f72 = f5;
        arrayDeque = arrayDeque3;
        int i492 = i10;
        int i502 = i35;
        int i512 = i39;
        if (list2 == null) {
        }
        ArrayDeque arrayDeque42 = arrayDeque;
        int i522 = index;
        int i532 = i13;
        List<LazyGridMeasuredLine> linesRetainedForLookahead2 = linesRetainedForLookahead(i482, i, lazyGridMeasuredLineProvider, z4, arrayDeque42, lazyGridLayoutInfo);
        int i542 = i482;
        int i552 = i;
        LazyGridMeasuredLineProvider lazyGridMeasuredLineProvider22 = lazyGridMeasuredLineProvider;
        size2 = list32.size();
        i16 = 0;
        while (i16 < size2) {
        }
        i17 = i542;
        if (arrayList == null) {
        }
        List list52 = arrayList;
        if (i3 <= 0) {
        }
        size3 = arrayDeque.size();
        i18 = 0;
        while (i18 < size3) {
        }
        int i632 = i11;
        LazyGridMeasuredLine lazyGridMeasuredLine32 = lazyGridMeasuredLine22;
        if (!z) {
        }
        int i642 = m6654constrainWidthK40F9xA;
        if (!z) {
        }
        int i652 = m6636getMaxHeightimpl;
        final List<LazyGridMeasuredItem> calculateItemsOffsets2 = calculateItemsOffsets(!linesRetainedForLookahead2.isEmpty() ? arrayDeque42 : CollectionsKt.plus((Collection) arrayDeque, (Iterable) linesRetainedForLookahead2), list2, list52, i642, i652, i492, i2, i532, z, vertical, horizontal, z2, density);
        lazyLayoutItemAnimator.onMeasured((int) f72, i642, i652, calculateItemsOffsets2, lazyGridMeasuredItemProvider.getKeyIndexMap(), lazyGridMeasuredItemProvider, z, z4, i8, z3, i632, i492, coroutineScope, graphicsContext);
        int i662 = i642;
        if (!z4) {
        }
        int i702 = i662;
        int i712 = i652;
        final List<LazyGridMeasuredItem> applyStickyItems2 = LazyLayoutStickyItemsKt.applyStickyItems(stickyItemsPlacement, calculateItemsOffsets2, lazyGridMeasuredItemProvider.getHeaderIndices(), i3, i4, i702, i712, new Function1<Integer, LazyGridMeasuredItem>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridMeasureKt$measureLazyGrid$stickingItems$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ LazyGridMeasuredItem invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final LazyGridMeasuredItem invoke(int i72) {
                int spanOf3 = LazyGridMeasuredLineProvider.this.spanOf(i72);
                return lazyGridMeasuredItemProvider.mo854getAndMeasurehBUhpc(i72, 0, spanOf3, LazyGridMeasuredLineProvider.this.m886childConstraintsJhjzzOo$foundation_release(0, spanOf3));
            }
        });
        if (i17 == i - 1) {
            z5 = false;
        }
        return new LazyGridMeasureResult(lazyGridMeasuredLine32, i632, z5, f72, function3.invoke(Integer.valueOf(i702), Integer.valueOf(i712), new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridMeasureKt$measureLazyGrid$6
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
                final List<LazyGridMeasuredItem> list6 = calculateItemsOffsets2;
                final List<LazyGridMeasuredItem> list7 = applyStickyItems2;
                final boolean z8 = z4;
                placementScope.withMotionFrameOfReferencePlacement(new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridMeasureKt$measureLazyGrid$6.1
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
                        List<LazyGridMeasuredItem> list8 = list6;
                        boolean z9 = z8;
                        int size6 = list8.size();
                        for (int i72 = 0; i72 < size6; i72++) {
                            list8.get(i72).place(placementScope2, z9);
                        }
                        List<LazyGridMeasuredItem> list9 = list7;
                        boolean z10 = z8;
                        int size7 = list9.size();
                        for (int i73 = 0; i73 < size7; i73++) {
                            list9.get(i73).place(placementScope2, z10);
                        }
                    }
                });
                ObservableScopeInvalidator.m918attachToScopeimpl(mutableState);
            }
        }), f62, z7, coroutineScope, density, i8, function1, LazyLayoutMeasuredItemKt.updatedVisibleItems(i522, i17, calculateItemsOffsets2, applyStickyItems2), i512, i502, i, z2, !z ? Orientation.Vertical : Orientation.Horizontal, i4, i5);
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
                LazyGridMeasuredItem mo854getAndMeasurehBUhpc = lazyGridMeasuredItemProvider2.mo854getAndMeasurehBUhpc(intValue, 0, spanOf, lazyGridMeasuredLineProvider.m886childConstraintsJhjzzOo$foundation_release(0, spanOf));
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(mo854getAndMeasurehBUhpc);
            } else {
                lazyGridMeasuredItemProvider2 = lazyGridMeasuredItemProvider;
            }
            i++;
            lazyGridMeasuredItemProvider = lazyGridMeasuredItemProvider2;
        }
        return arrayList == null ? CollectionsKt.emptyList() : arrayList;
    }
}
