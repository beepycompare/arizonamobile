package androidx.compose.foundation.lazy;

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
import java.util.ArrayList;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
/* compiled from: LazyListMeasure.kt */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\f\u001a\u0092\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\u0006\u0010\u001c\u001a\u00020\u00032\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u001e2\u0006\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u00112\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(2/\u0010)\u001a+\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020-0+¢\u0006\u0002\b.\u0012\u0004\u0012\u00020/0*H\u0000¢\u0006\u0004\b0\u00101\u001aB\u00102\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001e2\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u001b042\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00032\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u001eH\u0002\u001a4\u00105\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001e2\u0006\u00106\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00032\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u001eH\u0002\u001a\u008c\u0001\u00107\u001a\b\u0012\u0004\u0012\u00020\u001b042\f\u00108\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001e2\f\u00109\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001e2\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001e2\u0006\u0010;\u001a\u00020\u00032\u0006\u0010<\u001a\u00020\u00032\u0006\u0010=\u001a\u00020\u00032\u0006\u0010>\u001a\u00020\u00032\u0006\u0010?\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0018H\u0002¨\u0006@"}, d2 = {"measureLazyList", "Landroidx/compose/foundation/lazy/LazyListMeasureResult;", "itemsCount", "", "measuredItemProvider", "Landroidx/compose/foundation/lazy/LazyListMeasuredItemProvider;", "mainAxisAvailableSize", "beforeContentPadding", "afterContentPadding", "spaceBetweenItems", "firstVisibleItemIndex", "firstVisibleItemScrollOffset", "scrollToBeConsumed", "", "constraints", "Landroidx/compose/ui/unit/Constraints;", "isVertical", "", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "reverseLayout", "density", "Landroidx/compose/ui/unit/Density;", "itemAnimator", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "Landroidx/compose/foundation/lazy/LazyListMeasuredItem;", "beyondBoundsItemCount", "pinnedItems", "", "hasLookaheadOccurred", "isLookingAhead", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "placementScopeInvalidator", "Landroidx/compose/foundation/lazy/layout/ObservableScopeInvalidator;", "graphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "stickyItemsPlacement", "Landroidx/compose/foundation/lazy/layout/StickyItemsPlacement;", "layout", "Lkotlin/Function3;", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "", "Lkotlin/ExtensionFunctionType;", "Landroidx/compose/ui/layout/MeasureResult;", "measureLazyList-_s_dbAc", "(ILandroidx/compose/foundation/lazy/LazyListMeasuredItemProvider;IIIIIIFJZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;ZLandroidx/compose/ui/unit/Density;Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;ILjava/util/List;ZZLkotlinx/coroutines/CoroutineScope;Landroidx/compose/runtime/MutableState;Landroidx/compose/ui/graphics/GraphicsContext;Landroidx/compose/foundation/lazy/layout/StickyItemsPlacement;Lkotlin/jvm/functions/Function3;)Landroidx/compose/foundation/lazy/LazyListMeasureResult;", "createItemsAfterList", "visibleItems", "", "createItemsBeforeList", "currentFirstItemIndex", "calculateItemsOffsets", "items", "extraItemsBefore", "extraItemsAfter", "layoutWidth", "layoutHeight", "finalMainAxisOffset", "maxOffset", "itemsScrollOffset", "foundation"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LazyListMeasureKt {
    private static final int calculateItemsOffsets$reverseAware(int i, boolean z, int i2) {
        return !z ? i : (i2 - i) - 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:150:0x03ce  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x03d3  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x03dd  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x03e2  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x03fd  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x040e  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0422  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0433  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x046a  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x046f  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0473  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0478  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0480  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0483  */
    /* renamed from: measureLazyList-_s_dbAc  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final LazyListMeasureResult m926measureLazyList_s_dbAc(int i, final LazyListMeasuredItemProvider lazyListMeasuredItemProvider, int i2, int i3, int i4, int i5, int i6, int i7, float f, long j, boolean z, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, boolean z2, Density density, LazyLayoutItemAnimator<LazyListMeasuredItem> lazyLayoutItemAnimator, int i8, List<Integer> list, boolean z3, final boolean z4, CoroutineScope coroutineScope, final MutableState<Unit> mutableState, GraphicsContext graphicsContext, StickyItemsPlacement stickyItemsPlacement, Function3<? super Integer, ? super Integer, ? super Function1<? super Placeable.PlacementScope, Unit>, ? extends MeasureResult> function3) {
        int i9;
        int i10;
        int i11;
        int i12;
        LazyListMeasuredItemProvider lazyListMeasuredItemProvider2;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        Integer valueOf;
        int i22 = i3;
        if (!(i22 >= 0)) {
            InlineClassHelperKt.throwIllegalArgumentException("invalid beforeContentPadding");
        }
        if (!(i4 >= 0)) {
            InlineClassHelperKt.throwIllegalArgumentException("invalid afterContentPadding");
        }
        if (i <= 0) {
            int m7510getMinWidthimpl = Constraints.m7510getMinWidthimpl(j);
            int m7509getMinHeightimpl = Constraints.m7509getMinHeightimpl(j);
            lazyLayoutItemAnimator.onMeasured(0, m7510getMinWidthimpl, m7509getMinHeightimpl, new ArrayList(), lazyListMeasuredItemProvider.getKeyIndexMap(), lazyListMeasuredItemProvider, z, z4, 1, z3, 0, 0, coroutineScope, graphicsContext);
            if (!z4) {
                long m987getMinSizeToFitDisappearingItemsYbymL2g = lazyLayoutItemAnimator.m987getMinSizeToFitDisappearingItemsYbymL2g();
                if (!IntSize.m7724equalsimpl0(m987getMinSizeToFitDisappearingItemsYbymL2g, IntSize.Companion.m7731getZeroYbymL2g())) {
                    m7510getMinWidthimpl = ConstraintsKt.m7525constrainWidthK40F9xA(j, (int) (m987getMinSizeToFitDisappearingItemsYbymL2g >> 32));
                    m7509getMinHeightimpl = ConstraintsKt.m7524constrainHeightK40F9xA(j, (int) (m987getMinSizeToFitDisappearingItemsYbymL2g & 4294967295L));
                }
            }
            return new LazyListMeasureResult(null, 0, false, 0.0f, function3.invoke(Integer.valueOf(m7510getMinWidthimpl), Integer.valueOf(m7509getMinHeightimpl), new Function1() { // from class: androidx.compose.foundation.lazy.LazyListMeasureKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit unit;
                    Placeable.PlacementScope placementScope = (Placeable.PlacementScope) obj;
                    unit = Unit.INSTANCE;
                    return unit;
                }
            }), 0.0f, false, coroutineScope, density, lazyListMeasuredItemProvider.m935getChildConstraintsmsEJaDk(), CollectionsKt.emptyList(), -i22, i2 + i4, 0, z2, z ? Orientation.Vertical : Orientation.Horizontal, i4, i5, null);
        }
        int i23 = i6;
        if (i23 >= i) {
            i23 = i - 1;
            i9 = 0;
        } else {
            i9 = i7;
        }
        int round = Math.round(f);
        int i24 = i9 - round;
        if (i23 == 0 && i24 < 0) {
            round += i24;
            i24 = 0;
        }
        int i25 = round;
        ArrayDeque arrayDeque = new ArrayDeque();
        int i26 = -i22;
        int i27 = (i5 < 0 ? i5 : 0) + i26;
        int i28 = i24 + i27;
        int i29 = 0;
        while (i28 < 0 && i23 > 0) {
            int i30 = i23 - 1;
            ArrayDeque arrayDeque2 = arrayDeque;
            LazyListMeasuredItem m932getAndMeasure0kLqBqw$default = LazyListMeasuredItemProvider.m932getAndMeasure0kLqBqw$default(lazyListMeasuredItemProvider, i30, 0L, 2, null);
            arrayDeque2.add(0, m932getAndMeasure0kLqBqw$default);
            i29 = Math.max(i29, m932getAndMeasure0kLqBqw$default.getCrossAxisSize());
            i28 = m932getAndMeasure0kLqBqw$default.getMainAxisSizeWithSpacings() + i28;
            i23 = i30;
            arrayDeque = arrayDeque2;
            i27 = i27;
            i26 = i26;
        }
        int i31 = i28;
        ArrayDeque arrayDeque3 = arrayDeque;
        int i32 = i26;
        int i33 = i27;
        int i34 = i29;
        if (i31 < i33) {
            i25 -= i33 - i31;
            i10 = i33;
        } else {
            i10 = i31;
        }
        int i35 = i25;
        int i36 = i10 - i33;
        int i37 = i2 + i4;
        int coerceAtLeast = RangesKt.coerceAtLeast(i37, 0);
        int i38 = -i36;
        int i39 = i23;
        int i40 = 0;
        boolean z5 = false;
        while (i40 < arrayDeque3.size()) {
            if (i38 >= coerceAtLeast) {
                arrayDeque3.remove(i40);
                Unit unit = Unit.INSTANCE;
                z5 = true;
            } else {
                i39++;
                i38 += ((LazyListMeasuredItem) arrayDeque3.get(i40)).getMainAxisSizeWithSpacings();
                Integer.valueOf(i40);
                i40++;
            }
        }
        int i41 = i38;
        int i42 = i34;
        boolean z6 = z5;
        int i43 = i23;
        int i44 = i37;
        int i45 = i39;
        int i46 = i36;
        while (i45 < i && (i41 < coerceAtLeast || i41 <= 0 || arrayDeque3.isEmpty())) {
            int i47 = i42;
            int i48 = coerceAtLeast;
            int i49 = i44;
            int i50 = i43;
            LazyListMeasuredItem m932getAndMeasure0kLqBqw$default2 = LazyListMeasuredItemProvider.m932getAndMeasure0kLqBqw$default(lazyListMeasuredItemProvider, i45, 0L, 2, null);
            int i51 = i45;
            i41 += m932getAndMeasure0kLqBqw$default2.getMainAxisSizeWithSpacings();
            if (i41 <= i33 && i51 != i - 1) {
                i46 -= m932getAndMeasure0kLqBqw$default2.getMainAxisSizeWithSpacings();
                Unit unit2 = Unit.INSTANCE;
                i42 = i47;
                z6 = true;
                i43 = i51 + 1;
            } else {
                int max = Math.max(i47, m932getAndMeasure0kLqBqw$default2.getCrossAxisSize());
                Boolean.valueOf(arrayDeque3.add(m932getAndMeasure0kLqBqw$default2));
                i43 = i50;
                i42 = max;
            }
            i45 = i51 + 1;
            coerceAtLeast = i48;
            i44 = i49;
        }
        int i52 = i44;
        int i53 = i45;
        int i54 = i43;
        int i55 = i42;
        if (i41 < i2) {
            int i56 = i2 - i41;
            int i57 = i41 + i56;
            int i58 = i54;
            int i59 = i46 - i56;
            while (i59 < i22 && i58 > 0) {
                i58--;
                int i60 = i59;
                LazyListMeasuredItem m932getAndMeasure0kLqBqw$default3 = LazyListMeasuredItemProvider.m932getAndMeasure0kLqBqw$default(lazyListMeasuredItemProvider, i58, 0L, 2, null);
                arrayDeque3.add(0, m932getAndMeasure0kLqBqw$default3);
                i55 = Math.max(i55, m932getAndMeasure0kLqBqw$default3.getCrossAxisSize());
                i59 = i60 + m932getAndMeasure0kLqBqw$default3.getMainAxisSizeWithSpacings();
                i53 = i53;
                i22 = i3;
            }
            i11 = i53;
            int i61 = i59;
            i12 = 0;
            lazyListMeasuredItemProvider2 = lazyListMeasuredItemProvider;
            i13 = i56 + i35;
            if (i61 < 0) {
                i13 += i61;
                i14 = i55;
                i15 = i57 + i61;
                i17 = i58;
                i16 = 0;
            } else {
                i14 = i55;
                i15 = i57;
                i17 = i58;
                i16 = i61;
            }
        } else {
            i11 = i53;
            i12 = 0;
            lazyListMeasuredItemProvider2 = lazyListMeasuredItemProvider;
            i13 = i35;
            i14 = i55;
            i15 = i41;
            i16 = i46;
            i17 = i54;
        }
        float f2 = (MathKt.getSign(Math.round(f)) != MathKt.getSign(i13) || Math.abs(Math.round(f)) < Math.abs(i13)) ? f : i13;
        float f3 = f - f2;
        float f4 = 0.0f;
        if (z4 && i13 > i35 && f3 <= 0.0f) {
            f4 = (i13 - i35) + f3;
        }
        float f5 = f4;
        if ((i16 >= 0 ? 1 : i12) == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("negative currentFirstItemScrollOffset");
        }
        int i62 = -i16;
        LazyListMeasuredItem lazyListMeasuredItem = (LazyListMeasuredItem) arrayDeque3.first();
        if (i3 > 0 || i5 < 0) {
            int size = arrayDeque3.size();
            while (true) {
                if (i12 >= size) {
                    i18 = i16;
                    i19 = i62;
                    break;
                }
                i19 = i62;
                int mainAxisSizeWithSpacings = ((LazyListMeasuredItem) arrayDeque3.get(i12)).getMainAxisSizeWithSpacings();
                if (i16 == 0 || mainAxisSizeWithSpacings > i16) {
                    break;
                }
                i18 = i16;
                if (i12 == CollectionsKt.getLastIndex(arrayDeque3)) {
                    break;
                }
                i16 = i18 - mainAxisSizeWithSpacings;
                i12++;
                lazyListMeasuredItem = (LazyListMeasuredItem) arrayDeque3.get(i12);
                i62 = i19;
            }
            i18 = i16;
            i20 = i18;
        } else {
            i20 = i16;
            i19 = i62;
        }
        LazyListMeasuredItem lazyListMeasuredItem2 = lazyListMeasuredItem;
        List<LazyListMeasuredItem> createItemsBeforeList = createItemsBeforeList(i17, lazyListMeasuredItemProvider2, i8, list);
        int size2 = createItemsBeforeList.size();
        for (int i63 = 0; i63 < size2; i63++) {
            i14 = Math.max(i14, createItemsBeforeList.get(i63).getCrossAxisSize());
        }
        ArrayDeque arrayDeque4 = arrayDeque3;
        List<LazyListMeasuredItem> createItemsAfterList = createItemsAfterList(arrayDeque4, lazyListMeasuredItemProvider2, i, i8, list);
        int size3 = createItemsAfterList.size();
        for (int i64 = 0; i64 < size3; i64++) {
            i14 = Math.max(i14, createItemsAfterList.get(i64).getCrossAxisSize());
        }
        boolean z7 = Intrinsics.areEqual(lazyListMeasuredItem2, arrayDeque3.first()) && createItemsBeforeList.isEmpty() && createItemsAfterList.isEmpty();
        int m7525constrainWidthK40F9xA = ConstraintsKt.m7525constrainWidthK40F9xA(j, z ? i14 : i15);
        if (z) {
            i14 = i15;
        }
        int m7524constrainHeightK40F9xA = ConstraintsKt.m7524constrainHeightK40F9xA(j, i14);
        float f6 = f2;
        int i65 = m7525constrainWidthK40F9xA;
        int i66 = i11;
        final List<LazyListMeasuredItem> calculateItemsOffsets = calculateItemsOffsets(arrayDeque4, createItemsBeforeList, createItemsAfterList, i65, m7524constrainHeightK40F9xA, i15, i2, i19, z, vertical, horizontal, z2, density);
        lazyLayoutItemAnimator.onMeasured((int) f6, i65, m7524constrainHeightK40F9xA, calculateItemsOffsets, lazyListMeasuredItemProvider.getKeyIndexMap(), lazyListMeasuredItemProvider, z, z4, 1, z3, i20, i15, coroutineScope, graphicsContext);
        int i67 = i15;
        if (!z4) {
            long m987getMinSizeToFitDisappearingItemsYbymL2g2 = lazyLayoutItemAnimator.m987getMinSizeToFitDisappearingItemsYbymL2g();
            if (!IntSize.m7724equalsimpl0(m987getMinSizeToFitDisappearingItemsYbymL2g2, IntSize.Companion.m7731getZeroYbymL2g())) {
                int i68 = z ? m7524constrainHeightK40F9xA : i65;
                i65 = ConstraintsKt.m7525constrainWidthK40F9xA(j, Math.max(i65, (int) (m987getMinSizeToFitDisappearingItemsYbymL2g2 >> 32)));
                int m7524constrainHeightK40F9xA2 = ConstraintsKt.m7524constrainHeightK40F9xA(j, Math.max(m7524constrainHeightK40F9xA, (int) (m987getMinSizeToFitDisappearingItemsYbymL2g2 & 4294967295L)));
                int i69 = z ? m7524constrainHeightK40F9xA2 : i65;
                if (i69 != i68) {
                    int size4 = calculateItemsOffsets.size();
                    for (int i70 = 0; i70 < size4; i70++) {
                        calculateItemsOffsets.get(i70).updateMainAxisLayoutSize(i69);
                    }
                }
                i21 = m7524constrainHeightK40F9xA2;
                int i71 = i65;
                LazyListMeasuredItem lazyListMeasuredItem3 = (LazyListMeasuredItem) arrayDeque3.firstOrNull();
                int index = lazyListMeasuredItem3 == null ? lazyListMeasuredItem3.getIndex() : 0;
                LazyListMeasuredItem lazyListMeasuredItem4 = (LazyListMeasuredItem) arrayDeque3.lastOrNull();
                final List applyStickyItems = LazyLayoutStickyItemsKt.applyStickyItems(stickyItemsPlacement, index, lazyListMeasuredItem4 == null ? lazyListMeasuredItem4.getIndex() : 0, calculateItemsOffsets, lazyListMeasuredItemProvider.getHeaderIndexes(), i3, i4, i71, i21, new Function1() { // from class: androidx.compose.foundation.lazy.LazyListMeasureKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        LazyListMeasuredItem m932getAndMeasure0kLqBqw$default4;
                        m932getAndMeasure0kLqBqw$default4 = LazyListMeasuredItemProvider.m932getAndMeasure0kLqBqw$default(LazyListMeasuredItemProvider.this, ((Integer) obj).intValue(), 0L, 2, null);
                        return m932getAndMeasure0kLqBqw$default4;
                    }
                });
                Integer num = null;
                if (!z7) {
                    LazyListMeasuredItem lazyListMeasuredItem5 = (LazyListMeasuredItem) CollectionsKt.firstOrNull((List<? extends Object>) calculateItemsOffsets);
                    if (lazyListMeasuredItem5 != null) {
                        valueOf = Integer.valueOf(lazyListMeasuredItem5.getIndex());
                    }
                    valueOf = null;
                } else {
                    LazyListMeasuredItem lazyListMeasuredItem6 = (LazyListMeasuredItem) arrayDeque3.firstOrNull();
                    if (lazyListMeasuredItem6 != null) {
                        valueOf = Integer.valueOf(lazyListMeasuredItem6.getIndex());
                    }
                    valueOf = null;
                }
                if (!z7) {
                    LazyListMeasuredItem lazyListMeasuredItem7 = (LazyListMeasuredItem) CollectionsKt.lastOrNull((List<? extends Object>) calculateItemsOffsets);
                    if (lazyListMeasuredItem7 != null) {
                        num = Integer.valueOf(lazyListMeasuredItem7.getIndex());
                    }
                } else {
                    LazyListMeasuredItem lazyListMeasuredItem8 = (LazyListMeasuredItem) arrayDeque3.lastOrNull();
                    if (lazyListMeasuredItem8 != null) {
                        num = Integer.valueOf(lazyListMeasuredItem8.getIndex());
                    }
                }
                return new LazyListMeasureResult(lazyListMeasuredItem2, i20, i66 >= i || i67 > i2, f6, function3.invoke(Integer.valueOf(i71), Integer.valueOf(i21), new Function1() { // from class: androidx.compose.foundation.lazy.LazyListMeasureKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return LazyListMeasureKt.measureLazyList__s_dbAc$lambda$8(MutableState.this, calculateItemsOffsets, applyStickyItems, z4, (Placeable.PlacementScope) obj);
                    }
                }), f5, z6, coroutineScope, density, lazyListMeasuredItemProvider.m935getChildConstraintsmsEJaDk(), LazyLayoutMeasuredItemKt.updatedVisibleItems(valueOf == null ? valueOf.intValue() : 0, num == null ? num.intValue() : 0, calculateItemsOffsets, applyStickyItems), i32, i52, i, z2, !z ? Orientation.Vertical : Orientation.Horizontal, i4, i5, null);
            }
        }
        i21 = m7524constrainHeightK40F9xA;
        int i712 = i65;
        LazyListMeasuredItem lazyListMeasuredItem32 = (LazyListMeasuredItem) arrayDeque3.firstOrNull();
        if (lazyListMeasuredItem32 == null) {
        }
        LazyListMeasuredItem lazyListMeasuredItem42 = (LazyListMeasuredItem) arrayDeque3.lastOrNull();
        final List applyStickyItems2 = LazyLayoutStickyItemsKt.applyStickyItems(stickyItemsPlacement, index, lazyListMeasuredItem42 == null ? lazyListMeasuredItem42.getIndex() : 0, calculateItemsOffsets, lazyListMeasuredItemProvider.getHeaderIndexes(), i3, i4, i712, i21, new Function1() { // from class: androidx.compose.foundation.lazy.LazyListMeasureKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                LazyListMeasuredItem m932getAndMeasure0kLqBqw$default4;
                m932getAndMeasure0kLqBqw$default4 = LazyListMeasuredItemProvider.m932getAndMeasure0kLqBqw$default(LazyListMeasuredItemProvider.this, ((Integer) obj).intValue(), 0L, 2, null);
                return m932getAndMeasure0kLqBqw$default4;
            }
        });
        Integer num2 = null;
        if (!z7) {
        }
        if (!z7) {
        }
        if (i66 >= i) {
        }
        if (!z) {
        }
        return new LazyListMeasureResult(lazyListMeasuredItem2, i20, i66 >= i || i67 > i2, f6, function3.invoke(Integer.valueOf(i712), Integer.valueOf(i21), new Function1() { // from class: androidx.compose.foundation.lazy.LazyListMeasureKt$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LazyListMeasureKt.measureLazyList__s_dbAc$lambda$8(MutableState.this, calculateItemsOffsets, applyStickyItems2, z4, (Placeable.PlacementScope) obj);
            }
        }), f5, z6, coroutineScope, density, lazyListMeasuredItemProvider.m935getChildConstraintsmsEJaDk(), LazyLayoutMeasuredItemKt.updatedVisibleItems(valueOf == null ? valueOf.intValue() : 0, num2 == null ? num2.intValue() : 0, calculateItemsOffsets, applyStickyItems2), i32, i52, i, z2, !z ? Orientation.Vertical : Orientation.Horizontal, i4, i5, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit measureLazyList__s_dbAc$lambda$8(MutableState mutableState, final List list, final List list2, final boolean z, Placeable.PlacementScope placementScope) {
        placementScope.withMotionFrameOfReferencePlacement(new Function1() { // from class: androidx.compose.foundation.lazy.LazyListMeasureKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit measureLazyList__s_dbAc$lambda$8$0;
                measureLazyList__s_dbAc$lambda$8$0 = LazyListMeasureKt.measureLazyList__s_dbAc$lambda$8$0(list, list2, z, (Placeable.PlacementScope) obj);
                return measureLazyList__s_dbAc$lambda$8$0;
            }
        });
        ObservableScopeInvalidator.m1005attachToScopeimpl(mutableState);
        return Unit.INSTANCE;
    }

    private static final List<LazyListMeasuredItem> createItemsAfterList(List<LazyListMeasuredItem> list, LazyListMeasuredItemProvider lazyListMeasuredItemProvider, int i, int i2, List<Integer> list2) {
        LazyListMeasuredItemProvider lazyListMeasuredItemProvider2;
        LazyListMeasuredItemProvider lazyListMeasuredItemProvider3;
        int min = Math.min(((LazyListMeasuredItem) CollectionsKt.last((List<? extends Object>) list)).getIndex() + i2, i - 1);
        int index = ((LazyListMeasuredItem) CollectionsKt.last((List<? extends Object>) list)).getIndex() + 1;
        ArrayList arrayList = null;
        if (index <= min) {
            int i3 = index;
            while (true) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                lazyListMeasuredItemProvider2 = lazyListMeasuredItemProvider;
                arrayList.add(LazyListMeasuredItemProvider.m932getAndMeasure0kLqBqw$default(lazyListMeasuredItemProvider2, i3, 0L, 2, null));
                if (i3 == min) {
                    break;
                }
                i3++;
                lazyListMeasuredItemProvider = lazyListMeasuredItemProvider2;
            }
        } else {
            lazyListMeasuredItemProvider2 = lazyListMeasuredItemProvider;
        }
        if (arrayList != null && ((LazyListMeasuredItem) CollectionsKt.last((List<? extends Object>) arrayList)).getIndex() > min) {
            min = ((LazyListMeasuredItem) CollectionsKt.last((List<? extends Object>) arrayList)).getIndex();
        }
        int size = list2.size();
        int i4 = 0;
        while (i4 < size) {
            int intValue = list2.get(i4).intValue();
            if (intValue > min) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                lazyListMeasuredItemProvider3 = lazyListMeasuredItemProvider2;
                arrayList.add(LazyListMeasuredItemProvider.m932getAndMeasure0kLqBqw$default(lazyListMeasuredItemProvider3, intValue, 0L, 2, null));
            } else {
                lazyListMeasuredItemProvider3 = lazyListMeasuredItemProvider2;
            }
            i4++;
            lazyListMeasuredItemProvider2 = lazyListMeasuredItemProvider3;
        }
        return arrayList == null ? CollectionsKt.emptyList() : arrayList;
    }

    private static final List<LazyListMeasuredItem> createItemsBeforeList(int i, LazyListMeasuredItemProvider lazyListMeasuredItemProvider, int i2, List<Integer> list) {
        LazyListMeasuredItemProvider lazyListMeasuredItemProvider2;
        int max = Math.max(0, i - i2);
        int i3 = i - 1;
        ArrayList arrayList = null;
        if (max <= i3) {
            int i4 = i3;
            while (true) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                lazyListMeasuredItemProvider2 = lazyListMeasuredItemProvider;
                arrayList.add(LazyListMeasuredItemProvider.m932getAndMeasure0kLqBqw$default(lazyListMeasuredItemProvider2, i4, 0L, 2, null));
                if (i4 == max) {
                    break;
                }
                i4--;
                lazyListMeasuredItemProvider = lazyListMeasuredItemProvider2;
            }
        } else {
            lazyListMeasuredItemProvider2 = lazyListMeasuredItemProvider;
        }
        int size = list.size() - 1;
        if (size >= 0) {
            while (true) {
                int i5 = size - 1;
                int intValue = list.get(size).intValue();
                if (intValue < max) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(LazyListMeasuredItemProvider.m932getAndMeasure0kLqBqw$default(lazyListMeasuredItemProvider2, intValue, 0L, 2, null));
                }
                if (i5 < 0) {
                    break;
                }
                size = i5;
            }
        }
        return arrayList == null ? CollectionsKt.emptyList() : arrayList;
    }

    private static final List<LazyListMeasuredItem> calculateItemsOffsets(List<LazyListMeasuredItem> list, List<LazyListMeasuredItem> list2, List<LazyListMeasuredItem> list3, int i, int i2, int i3, int i4, int i5, boolean z, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, boolean z2, Density density) {
        int i6 = z ? i2 : i;
        boolean z3 = true;
        boolean z4 = i3 < Math.min(i6, i4);
        if (z4) {
            if (!(i5 == 0)) {
                InlineClassHelperKt.throwIllegalStateException("non-zero itemsScrollOffset");
            }
        }
        ArrayList arrayList = new ArrayList(list.size() + list2.size() + list3.size());
        if (z4) {
            if (!((list2.isEmpty() && list3.isEmpty()) ? false : false)) {
                InlineClassHelperKt.throwIllegalArgumentException("no extra items");
            }
            int size = list.size();
            int[] iArr = new int[size];
            for (int i7 = 0; i7 < size; i7++) {
                iArr[i7] = list.get(calculateItemsOffsets$reverseAware(i7, z2, size)).getSize();
            }
            int[] iArr2 = new int[size];
            if (z) {
                if (vertical != null) {
                    vertical.arrange(density, i6, iArr, iArr2);
                } else {
                    InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("null verticalArrangement when isVertical == true");
                    throw new KotlinNothingValueException();
                }
            } else if (horizontal != null) {
                horizontal.arrange(density, i6, iArr, LayoutDirection.Ltr, iArr2);
            } else {
                InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("null horizontalArrangement when isVertical == false");
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
                    int i8 = iArr2[first];
                    LazyListMeasuredItem lazyListMeasuredItem = list.get(calculateItemsOffsets$reverseAware(first, z2, size));
                    if (z2) {
                        i8 = (i6 - i8) - lazyListMeasuredItem.getSize();
                    }
                    lazyListMeasuredItem.position(i8, i, i2);
                    arrayList.add(lazyListMeasuredItem);
                    if (first == last) {
                        break;
                    }
                    first += step;
                }
            }
        } else {
            int size2 = list2.size();
            int i9 = i5;
            for (int i10 = 0; i10 < size2; i10++) {
                LazyListMeasuredItem lazyListMeasuredItem2 = list2.get(i10);
                i9 -= lazyListMeasuredItem2.getMainAxisSizeWithSpacings();
                lazyListMeasuredItem2.position(i9, i, i2);
                arrayList.add(lazyListMeasuredItem2);
            }
            int size3 = list.size();
            int i11 = i5;
            for (int i12 = 0; i12 < size3; i12++) {
                LazyListMeasuredItem lazyListMeasuredItem3 = list.get(i12);
                lazyListMeasuredItem3.position(i11, i, i2);
                arrayList.add(lazyListMeasuredItem3);
                i11 += lazyListMeasuredItem3.getMainAxisSizeWithSpacings();
            }
            int size4 = list3.size();
            for (int i13 = 0; i13 < size4; i13++) {
                LazyListMeasuredItem lazyListMeasuredItem4 = list3.get(i13);
                lazyListMeasuredItem4.position(i11, i, i2);
                arrayList.add(lazyListMeasuredItem4);
                i11 += lazyListMeasuredItem4.getMainAxisSizeWithSpacings();
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit measureLazyList__s_dbAc$lambda$8$0(List list, List list2, boolean z, Placeable.PlacementScope placementScope) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            ((LazyListMeasuredItem) list.get(i)).place(placementScope, z);
        }
        int size2 = list2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            ((LazyListMeasuredItem) list2.get(i2)).place(placementScope, z);
        }
        return Unit.INSTANCE;
    }
}
