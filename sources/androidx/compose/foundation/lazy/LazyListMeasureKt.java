package androidx.compose.foundation.lazy;

import androidx.compose.foundation.ComposeFoundationFlags;
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
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\f\u001a\u009a\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\u0006\u0010\u001c\u001a\u00020\u00032\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u001e2\u0006\u0010\u001f\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\u00112\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010)\u001a\u00020\u00112/\u0010*\u001a+\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020.0,¢\u0006\u0002\b/\u0012\u0004\u0012\u0002000+H\u0000¢\u0006\u0004\b1\u00102\u001aB\u00103\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001e2\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u001b052\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00032\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u001eH\u0002\u001a4\u00106\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001e2\u0006\u00107\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00032\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00030\u001eH\u0002\u001a\u008c\u0001\u00108\u001a\b\u0012\u0004\u0012\u00020\u001b052\f\u00109\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001e2\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001e2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001e2\u0006\u0010<\u001a\u00020\u00032\u0006\u0010=\u001a\u00020\u00032\u0006\u0010>\u001a\u00020\u00032\u0006\u0010?\u001a\u00020\u00032\u0006\u0010@\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0018H\u0002¨\u0006A"}, d2 = {"measureLazyList", "Landroidx/compose/foundation/lazy/LazyListMeasureResult;", "itemsCount", "", "measuredItemProvider", "Landroidx/compose/foundation/lazy/LazyListMeasuredItemProvider;", "mainAxisAvailableSize", "beforeContentPadding", "afterContentPadding", "spaceBetweenItems", "firstVisibleItemIndex", "firstVisibleItemScrollOffset", "scrollToBeConsumed", "", "constraints", "Landroidx/compose/ui/unit/Constraints;", "isVertical", "", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "horizontalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "reverseLayout", "density", "Landroidx/compose/ui/unit/Density;", "itemAnimator", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "Landroidx/compose/foundation/lazy/LazyListMeasuredItem;", "beyondBoundsItemCount", "pinnedItems", "", "hasLookaheadOccurred", "isLookingAhead", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "placementScopeInvalidator", "Landroidx/compose/foundation/lazy/layout/ObservableScopeInvalidator;", "graphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "stickyItemsPlacement", "Landroidx/compose/foundation/lazy/layout/StickyItemsPlacement;", "shouldRunItemAnimation", "layout", "Lkotlin/Function3;", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "", "Lkotlin/ExtensionFunctionType;", "Landroidx/compose/ui/layout/MeasureResult;", "measureLazyList-pIk1_oM", "(ILandroidx/compose/foundation/lazy/LazyListMeasuredItemProvider;IIIIIIFJZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;ZLandroidx/compose/ui/unit/Density;Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;ILjava/util/List;ZZLkotlinx/coroutines/CoroutineScope;Landroidx/compose/runtime/MutableState;Landroidx/compose/ui/graphics/GraphicsContext;Landroidx/compose/foundation/lazy/layout/StickyItemsPlacement;ZLkotlin/jvm/functions/Function3;)Landroidx/compose/foundation/lazy/LazyListMeasureResult;", "createItemsAfterList", "visibleItems", "", "createItemsBeforeList", "currentFirstItemIndex", "calculateItemsOffsets", "items", "extraItemsBefore", "extraItemsAfter", "layoutWidth", "layoutHeight", "finalMainAxisOffset", "maxOffset", "itemsScrollOffset", "foundation"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LazyListMeasureKt {
    private static final int calculateItemsOffsets$reverseAware(int i, boolean z, int i2) {
        return !z ? i : (i2 - i) - 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:156:0x03df  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x03e4  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x03ee  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x03f3  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x040e  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x041f  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0433  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0444  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x047b  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0480  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0484  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0489  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0491  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0494  */
    /* renamed from: measureLazyList-pIk1_oM  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final LazyListMeasureResult m1179measureLazyListpIk1_oM(int i, final LazyListMeasuredItemProvider lazyListMeasuredItemProvider, int i2, int i3, int i4, int i5, int i6, int i7, float f, long j, boolean z, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, boolean z2, Density density, LazyLayoutItemAnimator<LazyListMeasuredItem> lazyLayoutItemAnimator, int i8, List<Integer> list, boolean z3, boolean z4, CoroutineScope coroutineScope, final MutableState<Unit> mutableState, GraphicsContext graphicsContext, StickyItemsPlacement stickyItemsPlacement, boolean z5, Function3<? super Integer, ? super Integer, ? super Function1<? super Placeable.PlacementScope, Unit>, ? extends MeasureResult> function3) {
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
        final boolean z6;
        int i21;
        int i22;
        Integer valueOf;
        int i23 = i3;
        if (!(i23 >= 0)) {
            InlineClassHelperKt.throwIllegalArgumentException("invalid beforeContentPadding");
        }
        if (!(i4 >= 0)) {
            InlineClassHelperKt.throwIllegalArgumentException("invalid afterContentPadding");
        }
        if (i <= 0) {
            int m8115getMinWidthimpl = Constraints.m8115getMinWidthimpl(j);
            int m8114getMinHeightimpl = Constraints.m8114getMinHeightimpl(j);
            lazyLayoutItemAnimator.onMeasured(0, m8115getMinWidthimpl, m8114getMinHeightimpl, new ArrayList(), lazyListMeasuredItemProvider.getKeyIndexMap(), lazyListMeasuredItemProvider, z, z4, 1, z3, 0, 0, coroutineScope, graphicsContext);
            if (!z4) {
                long m1240getMinSizeToFitDisappearingItemsYbymL2g = lazyLayoutItemAnimator.m1240getMinSizeToFitDisappearingItemsYbymL2g();
                if (!IntSize.m8329equalsimpl0(m1240getMinSizeToFitDisappearingItemsYbymL2g, IntSize.Companion.m8336getZeroYbymL2g())) {
                    m8115getMinWidthimpl = ConstraintsKt.m8130constrainWidthK40F9xA(j, (int) (m1240getMinSizeToFitDisappearingItemsYbymL2g >> 32));
                    m8114getMinHeightimpl = ConstraintsKt.m8129constrainHeightK40F9xA(j, (int) (m1240getMinSizeToFitDisappearingItemsYbymL2g & 4294967295L));
                }
            }
            return new LazyListMeasureResult(null, 0, false, 0.0f, function3.invoke(Integer.valueOf(m8115getMinWidthimpl), Integer.valueOf(m8114getMinHeightimpl), new Function1() { // from class: androidx.compose.foundation.lazy.LazyListMeasureKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit unit;
                    Placeable.PlacementScope placementScope = (Placeable.PlacementScope) obj;
                    unit = Unit.INSTANCE;
                    return unit;
                }
            }), 0.0f, false, coroutineScope, density, lazyListMeasuredItemProvider.m1188getChildConstraintsmsEJaDk(), CollectionsKt.emptyList(), -i23, i2 + i4, 0, z2, z ? Orientation.Vertical : Orientation.Horizontal, i4, i5, null);
        }
        int i24 = i6;
        if (i24 >= i) {
            i24 = i - 1;
            i9 = 0;
        } else {
            i9 = i7;
        }
        int round = Math.round(f);
        int i25 = i9 - round;
        if (i24 == 0 && i25 < 0) {
            round += i25;
            i25 = 0;
        }
        int i26 = round;
        ArrayDeque arrayDeque = new ArrayDeque();
        int i27 = -i23;
        int i28 = (i5 < 0 ? i5 : 0) + i27;
        int i29 = i25 + i28;
        int i30 = 0;
        while (i29 < 0 && i24 > 0) {
            int i31 = i24 - 1;
            ArrayDeque arrayDeque2 = arrayDeque;
            LazyListMeasuredItem m1185getAndMeasure0kLqBqw$default = LazyListMeasuredItemProvider.m1185getAndMeasure0kLqBqw$default(lazyListMeasuredItemProvider, i31, 0L, 2, null);
            arrayDeque2.add(0, m1185getAndMeasure0kLqBqw$default);
            i30 = Math.max(i30, m1185getAndMeasure0kLqBqw$default.getCrossAxisSize());
            i29 = m1185getAndMeasure0kLqBqw$default.getMainAxisSizeWithSpacings() + i29;
            i24 = i31;
            arrayDeque = arrayDeque2;
            i28 = i28;
            i27 = i27;
        }
        int i32 = i29;
        ArrayDeque arrayDeque3 = arrayDeque;
        int i33 = i27;
        int i34 = i28;
        int i35 = i30;
        if (i32 < i34) {
            i26 -= i34 - i32;
            i10 = i34;
        } else {
            i10 = i32;
        }
        int i36 = i26;
        int i37 = i10 - i34;
        int i38 = i2 + i4;
        int coerceAtLeast = RangesKt.coerceAtLeast(i38, 0);
        int i39 = -i37;
        int i40 = i24;
        int i41 = 0;
        boolean z7 = false;
        while (i41 < arrayDeque3.size()) {
            if (i39 >= coerceAtLeast) {
                arrayDeque3.remove(i41);
                Unit unit = Unit.INSTANCE;
                z7 = true;
            } else {
                i40++;
                i39 += ((LazyListMeasuredItem) arrayDeque3.get(i41)).getMainAxisSizeWithSpacings();
                Integer.valueOf(i41);
                i41++;
            }
        }
        int i42 = i39;
        int i43 = i35;
        boolean z8 = z7;
        int i44 = i24;
        int i45 = i38;
        int i46 = i40;
        int i47 = i37;
        while (i46 < i && (i42 < coerceAtLeast || i42 <= 0 || arrayDeque3.isEmpty())) {
            int i48 = i43;
            int i49 = coerceAtLeast;
            int i50 = i45;
            int i51 = i44;
            LazyListMeasuredItem m1185getAndMeasure0kLqBqw$default2 = LazyListMeasuredItemProvider.m1185getAndMeasure0kLqBqw$default(lazyListMeasuredItemProvider, i46, 0L, 2, null);
            int i52 = i46;
            i42 += m1185getAndMeasure0kLqBqw$default2.getMainAxisSizeWithSpacings();
            if (i42 <= i34 && i52 != i - 1) {
                i47 -= m1185getAndMeasure0kLqBqw$default2.getMainAxisSizeWithSpacings();
                Unit unit2 = Unit.INSTANCE;
                i43 = i48;
                z8 = true;
                i44 = i52 + 1;
            } else {
                int max = Math.max(i48, m1185getAndMeasure0kLqBqw$default2.getCrossAxisSize());
                Boolean.valueOf(arrayDeque3.add(m1185getAndMeasure0kLqBqw$default2));
                i44 = i51;
                i43 = max;
            }
            i46 = i52 + 1;
            coerceAtLeast = i49;
            i45 = i50;
        }
        int i53 = i45;
        int i54 = i46;
        int i55 = i44;
        int i56 = i43;
        if (i42 < i2) {
            int i57 = i2 - i42;
            int i58 = i42 + i57;
            int i59 = i55;
            int i60 = i47 - i57;
            while (i60 < i23 && i59 > 0) {
                i59--;
                int i61 = i60;
                LazyListMeasuredItem m1185getAndMeasure0kLqBqw$default3 = LazyListMeasuredItemProvider.m1185getAndMeasure0kLqBqw$default(lazyListMeasuredItemProvider, i59, 0L, 2, null);
                arrayDeque3.add(0, m1185getAndMeasure0kLqBqw$default3);
                i56 = Math.max(i56, m1185getAndMeasure0kLqBqw$default3.getCrossAxisSize());
                i60 = i61 + m1185getAndMeasure0kLqBqw$default3.getMainAxisSizeWithSpacings();
                i54 = i54;
                i23 = i3;
            }
            i11 = i54;
            int i62 = i60;
            i12 = 0;
            lazyListMeasuredItemProvider2 = lazyListMeasuredItemProvider;
            i13 = i57 + i36;
            if (i62 < 0) {
                i13 += i62;
                i14 = i56;
                i15 = i58 + i62;
                i17 = i59;
                i16 = 0;
            } else {
                i14 = i56;
                i15 = i58;
                i17 = i59;
                i16 = i62;
            }
        } else {
            i11 = i54;
            i12 = 0;
            lazyListMeasuredItemProvider2 = lazyListMeasuredItemProvider;
            i13 = i36;
            i14 = i56;
            i15 = i42;
            i16 = i47;
            i17 = i55;
        }
        float f2 = (MathKt.getSign(Math.round(f)) != MathKt.getSign(i13) || Math.abs(Math.round(f)) < Math.abs(i13)) ? f : i13;
        float f3 = f - f2;
        float f4 = 0.0f;
        if (z4 && i13 > i36 && f3 <= 0.0f) {
            f4 = (i13 - i36) + f3;
        }
        float f5 = f4;
        if ((i16 >= 0 ? 1 : i12) == 0) {
            InlineClassHelperKt.throwIllegalArgumentException("negative currentFirstItemScrollOffset");
        }
        int i63 = -i16;
        LazyListMeasuredItem lazyListMeasuredItem = (LazyListMeasuredItem) arrayDeque3.first();
        if (i3 > 0 || i5 < 0) {
            int size = arrayDeque3.size();
            while (true) {
                if (i12 >= size) {
                    i18 = i16;
                    i19 = i63;
                    break;
                }
                i19 = i63;
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
                i63 = i19;
            }
            i18 = i16;
            i20 = i18;
        } else {
            i20 = i16;
            i19 = i63;
        }
        LazyListMeasuredItem lazyListMeasuredItem2 = lazyListMeasuredItem;
        List<LazyListMeasuredItem> createItemsBeforeList = createItemsBeforeList(i17, lazyListMeasuredItemProvider2, i8, list);
        int size2 = createItemsBeforeList.size();
        for (int i64 = 0; i64 < size2; i64++) {
            i14 = Math.max(i14, createItemsBeforeList.get(i64).getCrossAxisSize());
        }
        ArrayDeque arrayDeque4 = arrayDeque3;
        List<LazyListMeasuredItem> createItemsAfterList = createItemsAfterList(arrayDeque4, lazyListMeasuredItemProvider2, i, i8, list);
        int size3 = createItemsAfterList.size();
        for (int i65 = 0; i65 < size3; i65++) {
            i14 = Math.max(i14, createItemsAfterList.get(i65).getCrossAxisSize());
        }
        boolean z9 = Intrinsics.areEqual(lazyListMeasuredItem2, arrayDeque3.first()) && createItemsBeforeList.isEmpty() && createItemsAfterList.isEmpty();
        int m8130constrainWidthK40F9xA = ConstraintsKt.m8130constrainWidthK40F9xA(j, z ? i14 : i15);
        if (z) {
            i14 = i15;
        }
        int m8129constrainHeightK40F9xA = ConstraintsKt.m8129constrainHeightK40F9xA(j, i14);
        float f6 = f2;
        int i66 = i11;
        int i67 = i15;
        final List<LazyListMeasuredItem> calculateItemsOffsets = calculateItemsOffsets(arrayDeque4, createItemsBeforeList, createItemsAfterList, m8130constrainWidthK40F9xA, m8129constrainHeightK40F9xA, i67, i2, i19, z, vertical, horizontal, z2, density);
        if (!ComposeFoundationFlags.isSkipItemPlacementAnimationFixEnabled || z5) {
            lazyLayoutItemAnimator.onMeasured((int) f6, m8130constrainWidthK40F9xA, m8129constrainHeightK40F9xA, calculateItemsOffsets, lazyListMeasuredItemProvider.getKeyIndexMap(), lazyListMeasuredItemProvider, z, z4, 1, z3, i20, i67, coroutineScope, graphicsContext);
            z6 = z4;
            i21 = i67;
        } else {
            z6 = z4;
            i21 = i67;
        }
        int i68 = m8130constrainWidthK40F9xA;
        if (!z6) {
            long m1240getMinSizeToFitDisappearingItemsYbymL2g2 = lazyLayoutItemAnimator.m1240getMinSizeToFitDisappearingItemsYbymL2g();
            if (!IntSize.m8329equalsimpl0(m1240getMinSizeToFitDisappearingItemsYbymL2g2, IntSize.Companion.m8336getZeroYbymL2g())) {
                int i69 = z ? m8129constrainHeightK40F9xA : i68;
                i68 = ConstraintsKt.m8130constrainWidthK40F9xA(j, Math.max(i68, (int) (m1240getMinSizeToFitDisappearingItemsYbymL2g2 >> 32)));
                int m8129constrainHeightK40F9xA2 = ConstraintsKt.m8129constrainHeightK40F9xA(j, Math.max(m8129constrainHeightK40F9xA, (int) (m1240getMinSizeToFitDisappearingItemsYbymL2g2 & 4294967295L)));
                int i70 = z ? m8129constrainHeightK40F9xA2 : i68;
                if (i70 != i69) {
                    int size4 = calculateItemsOffsets.size();
                    for (int i71 = 0; i71 < size4; i71++) {
                        calculateItemsOffsets.get(i71).updateMainAxisLayoutSize(i70);
                    }
                }
                i22 = m8129constrainHeightK40F9xA2;
                int i72 = i68;
                LazyListMeasuredItem lazyListMeasuredItem3 = (LazyListMeasuredItem) arrayDeque3.firstOrNull();
                int index = lazyListMeasuredItem3 == null ? lazyListMeasuredItem3.getIndex() : 0;
                LazyListMeasuredItem lazyListMeasuredItem4 = (LazyListMeasuredItem) arrayDeque3.lastOrNull();
                final List applyStickyItems = LazyLayoutStickyItemsKt.applyStickyItems(stickyItemsPlacement, index, lazyListMeasuredItem4 == null ? lazyListMeasuredItem4.getIndex() : 0, calculateItemsOffsets, lazyListMeasuredItemProvider.getHeaderIndexes(), i3, i4, i72, i22, new Function1() { // from class: androidx.compose.foundation.lazy.LazyListMeasureKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        LazyListMeasuredItem m1185getAndMeasure0kLqBqw$default4;
                        m1185getAndMeasure0kLqBqw$default4 = LazyListMeasuredItemProvider.m1185getAndMeasure0kLqBqw$default(LazyListMeasuredItemProvider.this, ((Integer) obj).intValue(), 0L, 2, null);
                        return m1185getAndMeasure0kLqBqw$default4;
                    }
                });
                Integer num = null;
                if (!z9) {
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
                if (!z9) {
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
                return new LazyListMeasureResult(lazyListMeasuredItem2, i20, i66 >= i || i21 > i2, f6, function3.invoke(Integer.valueOf(i72), Integer.valueOf(i22), new Function1() { // from class: androidx.compose.foundation.lazy.LazyListMeasureKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return LazyListMeasureKt.measureLazyList_pIk1_oM$lambda$8(MutableState.this, calculateItemsOffsets, applyStickyItems, z6, (Placeable.PlacementScope) obj);
                    }
                }), f5, z8, coroutineScope, density, lazyListMeasuredItemProvider.m1188getChildConstraintsmsEJaDk(), LazyLayoutMeasuredItemKt.updatedVisibleItems(valueOf == null ? valueOf.intValue() : 0, num == null ? num.intValue() : 0, calculateItemsOffsets, applyStickyItems), i33, i53, i, z2, !z ? Orientation.Vertical : Orientation.Horizontal, i4, i5, null);
            }
        }
        i22 = m8129constrainHeightK40F9xA;
        int i722 = i68;
        LazyListMeasuredItem lazyListMeasuredItem32 = (LazyListMeasuredItem) arrayDeque3.firstOrNull();
        if (lazyListMeasuredItem32 == null) {
        }
        LazyListMeasuredItem lazyListMeasuredItem42 = (LazyListMeasuredItem) arrayDeque3.lastOrNull();
        final List applyStickyItems2 = LazyLayoutStickyItemsKt.applyStickyItems(stickyItemsPlacement, index, lazyListMeasuredItem42 == null ? lazyListMeasuredItem42.getIndex() : 0, calculateItemsOffsets, lazyListMeasuredItemProvider.getHeaderIndexes(), i3, i4, i722, i22, new Function1() { // from class: androidx.compose.foundation.lazy.LazyListMeasureKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                LazyListMeasuredItem m1185getAndMeasure0kLqBqw$default4;
                m1185getAndMeasure0kLqBqw$default4 = LazyListMeasuredItemProvider.m1185getAndMeasure0kLqBqw$default(LazyListMeasuredItemProvider.this, ((Integer) obj).intValue(), 0L, 2, null);
                return m1185getAndMeasure0kLqBqw$default4;
            }
        });
        Integer num2 = null;
        if (!z9) {
        }
        if (!z9) {
        }
        if (i66 >= i) {
        }
        if (!z) {
        }
        return new LazyListMeasureResult(lazyListMeasuredItem2, i20, i66 >= i || i21 > i2, f6, function3.invoke(Integer.valueOf(i722), Integer.valueOf(i22), new Function1() { // from class: androidx.compose.foundation.lazy.LazyListMeasureKt$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LazyListMeasureKt.measureLazyList_pIk1_oM$lambda$8(MutableState.this, calculateItemsOffsets, applyStickyItems2, z6, (Placeable.PlacementScope) obj);
            }
        }), f5, z8, coroutineScope, density, lazyListMeasuredItemProvider.m1188getChildConstraintsmsEJaDk(), LazyLayoutMeasuredItemKt.updatedVisibleItems(valueOf == null ? valueOf.intValue() : 0, num2 == null ? num2.intValue() : 0, calculateItemsOffsets, applyStickyItems2), i33, i53, i, z2, !z ? Orientation.Vertical : Orientation.Horizontal, i4, i5, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit measureLazyList_pIk1_oM$lambda$8(MutableState mutableState, final List list, final List list2, final boolean z, Placeable.PlacementScope placementScope) {
        placementScope.withMotionFrameOfReferencePlacement(new Function1() { // from class: androidx.compose.foundation.lazy.LazyListMeasureKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit measureLazyList_pIk1_oM$lambda$8$0;
                measureLazyList_pIk1_oM$lambda$8$0 = LazyListMeasureKt.measureLazyList_pIk1_oM$lambda$8$0(list, list2, z, (Placeable.PlacementScope) obj);
                return measureLazyList_pIk1_oM$lambda$8$0;
            }
        });
        ObservableScopeInvalidator.m1258attachToScopeimpl(mutableState);
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
                arrayList.add(LazyListMeasuredItemProvider.m1185getAndMeasure0kLqBqw$default(lazyListMeasuredItemProvider2, i3, 0L, 2, null));
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
                arrayList.add(LazyListMeasuredItemProvider.m1185getAndMeasure0kLqBqw$default(lazyListMeasuredItemProvider3, intValue, 0L, 2, null));
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
                arrayList.add(LazyListMeasuredItemProvider.m1185getAndMeasure0kLqBqw$default(lazyListMeasuredItemProvider2, i4, 0L, 2, null));
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
                    arrayList.add(LazyListMeasuredItemProvider.m1185getAndMeasure0kLqBqw$default(lazyListMeasuredItemProvider2, intValue, 0L, 2, null));
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
    public static final Unit measureLazyList_pIk1_oM$lambda$8$0(List list, List list2, boolean z, Placeable.PlacementScope placementScope) {
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
