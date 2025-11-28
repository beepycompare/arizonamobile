package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.CheckScrollableContainerConstraintsKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.grid.LazyGridSpanLayoutProvider;
import androidx.compose.foundation.lazy.layout.CacheWindowLogic;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsStateKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasurePolicy;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.foundation.lazy.layout.ObservableScopeInvalidator;
import androidx.compose.foundation.lazy.layout.StickyItemsPlacement;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import java.util.ArrayList;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LazyGrid.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LazyGridKt$rememberLazyGridMeasurePolicy$1$1 implements LazyLayoutMeasurePolicy {
    final /* synthetic */ PaddingValues $contentPadding;
    final /* synthetic */ CoroutineScope $coroutineScope;
    final /* synthetic */ GraphicsContext $graphicsContext;
    final /* synthetic */ Arrangement.Horizontal $horizontalArrangement;
    final /* synthetic */ boolean $isVertical;
    final /* synthetic */ Function0<LazyGridItemProvider> $itemProviderLambda;
    final /* synthetic */ boolean $reverseLayout;
    final /* synthetic */ LazyGridSlotsProvider $slots;
    final /* synthetic */ LazyGridState $state;
    final /* synthetic */ StickyItemsPlacement $stickyItemsScrollBehavior;
    final /* synthetic */ Arrangement.Vertical $verticalArrangement;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public LazyGridKt$rememberLazyGridMeasurePolicy$1$1(LazyGridState lazyGridState, boolean z, PaddingValues paddingValues, boolean z2, Function0<? extends LazyGridItemProvider> function0, LazyGridSlotsProvider lazyGridSlotsProvider, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, CoroutineScope coroutineScope, GraphicsContext graphicsContext, StickyItemsPlacement stickyItemsPlacement) {
        this.$state = lazyGridState;
        this.$isVertical = z;
        this.$contentPadding = paddingValues;
        this.$reverseLayout = z2;
        this.$itemProviderLambda = function0;
        this.$slots = lazyGridSlotsProvider;
        this.$verticalArrangement = vertical;
        this.$horizontalArrangement = horizontal;
        this.$coroutineScope = coroutineScope;
        this.$graphicsContext = graphicsContext;
        this.$stickyItemsScrollBehavior = stickyItemsPlacement;
    }

    /* JADX WARN: Removed duplicated region for block: B:84:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x027c  */
    /* JADX WARN: Type inference failed for: r22v1, types: [androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1] */
    /* JADX WARN: Type inference failed for: r27v0, types: [androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1] */
    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasurePolicy
    /* renamed from: measure-0kLqBqw */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final MeasureResult mo960measure0kLqBqw(final LazyLayoutMeasureScope lazyLayoutMeasureScope, final long j) {
        int i;
        int i2;
        int i3;
        float mo709getSpacingD9Ej5fM;
        int m7949getMaxWidthimpl;
        LazyGridItemProvider lazyGridItemProvider;
        long m8118constructorimpl;
        int lineIndexOfItem;
        int firstVisibleItemScrollOffset;
        float scrollToBeConsumed$foundation_release;
        CacheWindowLogic cacheWindowLogic;
        ObservableScopeInvalidator.m1072attachToScopeimpl(this.$state.m1014getMeasurementScopeInvalidatorzYiylxw$foundation_release());
        boolean z = this.$state.getHasLookaheadOccurred$foundation_release() || lazyLayoutMeasureScope.isLookingAhead();
        CheckScrollableContainerConstraintsKt.m300checkScrollableContainerConstraintsK40F9xA(j, this.$isVertical ? Orientation.Vertical : Orientation.Horizontal);
        if (this.$isVertical) {
            i = lazyLayoutMeasureScope.mo424roundToPx0680j_4(this.$contentPadding.mo787calculateLeftPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection()));
        } else {
            i = lazyLayoutMeasureScope.mo424roundToPx0680j_4(PaddingKt.calculateStartPadding(this.$contentPadding, lazyLayoutMeasureScope.getLayoutDirection()));
        }
        if (this.$isVertical) {
            i2 = lazyLayoutMeasureScope.mo424roundToPx0680j_4(this.$contentPadding.mo788calculateRightPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection()));
        } else {
            i2 = lazyLayoutMeasureScope.mo424roundToPx0680j_4(PaddingKt.calculateEndPadding(this.$contentPadding, lazyLayoutMeasureScope.getLayoutDirection()));
        }
        int i4 = lazyLayoutMeasureScope.mo424roundToPx0680j_4(this.$contentPadding.mo789calculateTopPaddingD9Ej5fM());
        int i5 = lazyLayoutMeasureScope.mo424roundToPx0680j_4(this.$contentPadding.mo786calculateBottomPaddingD9Ej5fM());
        final int i6 = i4 + i5;
        final int i7 = i + i2;
        boolean z2 = this.$isVertical;
        int i8 = z2 ? i6 : i7;
        if (z2 && !this.$reverseLayout) {
            i3 = i4;
        } else if (z2 && this.$reverseLayout) {
            i3 = i5;
        } else {
            i3 = (z2 || this.$reverseLayout) ? i2 : i;
        }
        final int i9 = i8 - i3;
        long m7968offsetNN6EwU = ConstraintsKt.m7968offsetNN6EwU(j, -i7, -i6);
        LazyGridItemProvider invoke = this.$itemProviderLambda.invoke();
        final LazyGridSpanLayoutProvider spanLayoutProvider = invoke.getSpanLayoutProvider();
        LazyLayoutMeasureScope lazyLayoutMeasureScope2 = lazyLayoutMeasureScope;
        final LazyGridSlots mo991invoke0kLqBqw = this.$slots.mo991invoke0kLqBqw(lazyLayoutMeasureScope2, m7968offsetNN6EwU);
        int length = mo991invoke0kLqBqw.getSizes().length;
        spanLayoutProvider.setSlotsPerLine(length);
        if (this.$isVertical) {
            Arrangement.Vertical vertical = this.$verticalArrangement;
            if (vertical != null) {
                mo709getSpacingD9Ej5fM = vertical.mo709getSpacingD9Ej5fM();
            } else {
                InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("null verticalArrangement when isVertical == true");
                throw new KotlinNothingValueException();
            }
        } else {
            Arrangement.Horizontal horizontal = this.$horizontalArrangement;
            if (horizontal != null) {
                mo709getSpacingD9Ej5fM = horizontal.mo709getSpacingD9Ej5fM();
            } else {
                InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("null horizontalArrangement when isVertical == false");
                throw new KotlinNothingValueException();
            }
        }
        final int i10 = lazyLayoutMeasureScope.mo424roundToPx0680j_4(mo709getSpacingD9Ej5fM);
        final int itemCount = invoke.getItemCount();
        if (this.$isVertical) {
            m7949getMaxWidthimpl = Constraints.m7948getMaxHeightimpl(j) - i6;
        } else {
            m7949getMaxWidthimpl = Constraints.m7949getMaxWidthimpl(j) - i7;
        }
        int i11 = m7949getMaxWidthimpl;
        if (this.$reverseLayout && i11 <= 0) {
            boolean z3 = this.$isVertical;
            if (!z3) {
                i += i11;
            }
            if (z3) {
                i4 += i11;
            }
            lazyGridItemProvider = invoke;
            m8118constructorimpl = IntOffset.m8118constructorimpl((i << 32) | (i4 & 4294967295L));
        } else {
            lazyGridItemProvider = invoke;
            m8118constructorimpl = IntOffset.m8118constructorimpl((i << 32) | (i4 & 4294967295L));
        }
        final LazyGridState lazyGridState = this.$state;
        final boolean z4 = this.$isVertical;
        final boolean z5 = this.$reverseLayout;
        final int i12 = i3;
        final long j2 = m8118constructorimpl;
        final LazyGridItemProvider lazyGridItemProvider2 = lazyGridItemProvider;
        final ?? r27 = new LazyGridMeasuredItemProvider(lazyGridItemProvider2, lazyLayoutMeasureScope, i10, lazyGridState, z4, z5, i12, i9, j2) { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1
            final /* synthetic */ int $afterContentPadding;
            final /* synthetic */ int $beforeContentPadding;
            final /* synthetic */ boolean $isVertical;
            final /* synthetic */ boolean $reverseLayout;
            final /* synthetic */ LazyGridState $state;
            final /* synthetic */ LazyLayoutMeasureScope $this_LazyLayoutMeasurePolicy;
            final /* synthetic */ long $visualItemOffset;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.$this_LazyLayoutMeasurePolicy = lazyLayoutMeasureScope;
                this.$state = lazyGridState;
                this.$isVertical = z4;
                this.$reverseLayout = z5;
                this.$beforeContentPadding = i12;
                this.$afterContentPadding = i9;
                this.$visualItemOffset = j2;
            }

            @Override // androidx.compose.foundation.lazy.grid.LazyGridMeasuredItemProvider
            /* renamed from: createItem-O3s9Psw  reason: not valid java name */
            public LazyGridMeasuredItem mo1005createItemO3s9Psw(int i13, Object obj, Object obj2, int i14, int i15, List<? extends Placeable> list, long j3, int i16, int i17) {
                return new LazyGridMeasuredItem(i13, obj, this.$isVertical, i14, i15, this.$reverseLayout, this.$this_LazyLayoutMeasurePolicy.getLayoutDirection(), this.$beforeContentPadding, this.$afterContentPadding, list, this.$visualItemOffset, obj2, this.$state.getItemAnimator$foundation_release(), j3, i16, i17, null);
            }
        };
        final boolean z6 = this.$isVertical;
        final ?? r22 = new LazyGridMeasuredLineProvider(z6, mo991invoke0kLqBqw, itemCount, i10, r27, spanLayoutProvider) { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1
            final /* synthetic */ boolean $isVertical;
            final /* synthetic */ LazyGridSlots $resolvedSlots;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(z6, mo991invoke0kLqBqw, itemCount, i10, r27, spanLayoutProvider);
                this.$isVertical = z6;
                this.$resolvedSlots = mo991invoke0kLqBqw;
            }

            @Override // androidx.compose.foundation.lazy.grid.LazyGridMeasuredLineProvider
            public LazyGridMeasuredLine createLine(int i13, LazyGridMeasuredItem[] lazyGridMeasuredItemArr, List<GridItemSpan> list, int i14) {
                return new LazyGridMeasuredLine(i13, lazyGridMeasuredItemArr, this.$resolvedSlots, list, this.$isVertical, i14);
            }
        };
        Function1 function1 = new Function1() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                ArrayList measure_0kLqBqw$lambda$3;
                measure_0kLqBqw$lambda$3 = LazyGridKt$rememberLazyGridMeasurePolicy$1$1.measure_0kLqBqw$lambda$3(LazyGridSpanLayoutProvider.this, r22, ((Integer) obj).intValue());
                return measure_0kLqBqw$lambda$3;
            }
        };
        Function1 function12 = new Function1() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                int lineIndexOfItem2;
                lineIndexOfItem2 = LazyGridSpanLayoutProvider.this.getLineIndexOfItem(((Integer) obj).intValue());
                return Integer.valueOf(lineIndexOfItem2);
            }
        };
        Snapshot.Companion companion = Snapshot.Companion;
        LazyGridState lazyGridState2 = this.$state;
        Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
        Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
        Snapshot makeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
        try {
            int updateScrollPositionIfTheFirstItemWasMoved$foundation_release = lazyGridState2.updateScrollPositionIfTheFirstItemWasMoved$foundation_release(lazyGridItemProvider2, lazyGridState2.getFirstVisibleItemIndex());
            if (updateScrollPositionIfTheFirstItemWasMoved$foundation_release >= itemCount && itemCount > 0) {
                lineIndexOfItem = spanLayoutProvider.getLineIndexOfItem(itemCount - 1);
                firstVisibleItemScrollOffset = 0;
                Unit unit = Unit.INSTANCE;
                companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
                List<Integer> calculateLazyLayoutPinnedIndices = LazyLayoutBeyondBoundsStateKt.calculateLazyLayoutPinnedIndices(lazyGridItemProvider2, this.$state.getPinnedItems$foundation_release(), this.$state.getBeyondBoundsInfo$foundation_release());
                if (!lazyLayoutMeasureScope.isLookingAhead() || !z) {
                    scrollToBeConsumed$foundation_release = this.$state.getScrollToBeConsumed$foundation_release();
                } else {
                    scrollToBeConsumed$foundation_release = this.$state.getScrollDeltaBetweenPasses$foundation_release();
                }
                LazyGridMeasuredLineProvider lazyGridMeasuredLineProvider = (LazyGridMeasuredLineProvider) r22;
                LazyGridMeasureResult m1008measureLazyGridt1x4au0 = LazyGridMeasureKt.m1008measureLazyGridt1x4au0(itemCount, lazyGridMeasuredLineProvider, (LazyGridMeasuredItemProvider) r27, i11, i12, i9, i10, lineIndexOfItem, firstVisibleItemScrollOffset, scrollToBeConsumed$foundation_release, m7968offsetNN6EwU, this.$isVertical, this.$verticalArrangement, this.$horizontalArrangement, this.$reverseLayout, lazyLayoutMeasureScope2, this.$state.getItemAnimator$foundation_release(), length, calculateLazyLayoutPinnedIndices, z, lazyLayoutMeasureScope.isLookingAhead(), this.$state.getApproachLayoutInfo$foundation_release(), this.$coroutineScope, this.$state.m1015getPlacementScopeInvalidatorzYiylxw$foundation_release(), this.$graphicsContext, function1, function12, this.$stickyItemsScrollBehavior, new Function3() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        MeasureResult measure_0kLqBqw$lambda$6;
                        measure_0kLqBqw$lambda$6 = LazyGridKt$rememberLazyGridMeasurePolicy$1$1.measure_0kLqBqw$lambda$6(LazyLayoutMeasureScope.this, j, i7, i6, ((Integer) obj).intValue(), ((Integer) obj2).intValue(), (Function1) obj3);
                        return measure_0kLqBqw$lambda$6;
                    }
                });
                LazyGridState.applyMeasureResult$foundation_release$default(this.$state, m1008measureLazyGridt1x4au0, lazyLayoutMeasureScope.isLookingAhead(), false, 4, null);
                LazyGridPrefetchStrategy prefetchStrategy$foundation_release = this.$state.getPrefetchStrategy$foundation_release();
                cacheWindowLogic = prefetchStrategy$foundation_release instanceof CacheWindowLogic ? (CacheWindowLogic) prefetchStrategy$foundation_release : null;
                if (cacheWindowLogic != null) {
                    LazyGridKt.keepAroundItems(cacheWindowLogic, m1008measureLazyGridt1x4au0.getOrientation(), m1008measureLazyGridt1x4au0.getVisibleItemsInfo(), lazyGridMeasuredLineProvider);
                }
                return m1008measureLazyGridt1x4au0;
            }
            lineIndexOfItem = spanLayoutProvider.getLineIndexOfItem(updateScrollPositionIfTheFirstItemWasMoved$foundation_release);
            firstVisibleItemScrollOffset = lazyGridState2.getFirstVisibleItemScrollOffset();
            Unit unit2 = Unit.INSTANCE;
            companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
            List<Integer> calculateLazyLayoutPinnedIndices2 = LazyLayoutBeyondBoundsStateKt.calculateLazyLayoutPinnedIndices(lazyGridItemProvider2, this.$state.getPinnedItems$foundation_release(), this.$state.getBeyondBoundsInfo$foundation_release());
            if (!lazyLayoutMeasureScope.isLookingAhead()) {
            }
            scrollToBeConsumed$foundation_release = this.$state.getScrollToBeConsumed$foundation_release();
            LazyGridMeasuredLineProvider lazyGridMeasuredLineProvider2 = (LazyGridMeasuredLineProvider) r22;
            LazyGridMeasureResult m1008measureLazyGridt1x4au02 = LazyGridMeasureKt.m1008measureLazyGridt1x4au0(itemCount, lazyGridMeasuredLineProvider2, (LazyGridMeasuredItemProvider) r27, i11, i12, i9, i10, lineIndexOfItem, firstVisibleItemScrollOffset, scrollToBeConsumed$foundation_release, m7968offsetNN6EwU, this.$isVertical, this.$verticalArrangement, this.$horizontalArrangement, this.$reverseLayout, lazyLayoutMeasureScope2, this.$state.getItemAnimator$foundation_release(), length, calculateLazyLayoutPinnedIndices2, z, lazyLayoutMeasureScope.isLookingAhead(), this.$state.getApproachLayoutInfo$foundation_release(), this.$coroutineScope, this.$state.m1015getPlacementScopeInvalidatorzYiylxw$foundation_release(), this.$graphicsContext, function1, function12, this.$stickyItemsScrollBehavior, new Function3() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    MeasureResult measure_0kLqBqw$lambda$6;
                    measure_0kLqBqw$lambda$6 = LazyGridKt$rememberLazyGridMeasurePolicy$1$1.measure_0kLqBqw$lambda$6(LazyLayoutMeasureScope.this, j, i7, i6, ((Integer) obj).intValue(), ((Integer) obj2).intValue(), (Function1) obj3);
                    return measure_0kLqBqw$lambda$6;
                }
            });
            LazyGridState.applyMeasureResult$foundation_release$default(this.$state, m1008measureLazyGridt1x4au02, lazyLayoutMeasureScope.isLookingAhead(), false, 4, null);
            LazyGridPrefetchStrategy prefetchStrategy$foundation_release2 = this.$state.getPrefetchStrategy$foundation_release();
            cacheWindowLogic = prefetchStrategy$foundation_release2 instanceof CacheWindowLogic ? (CacheWindowLogic) prefetchStrategy$foundation_release2 : null;
            if (cacheWindowLogic != null) {
            }
            return m1008measureLazyGridt1x4au02;
        } catch (Throwable th) {
            companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ArrayList measure_0kLqBqw$lambda$3(LazyGridSpanLayoutProvider lazyGridSpanLayoutProvider, LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1 lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1, int i) {
        LazyGridSpanLayoutProvider.LineConfiguration lineConfiguration = lazyGridSpanLayoutProvider.getLineConfiguration(i);
        int firstItemIndex = lineConfiguration.getFirstItemIndex();
        ArrayList arrayList = new ArrayList(lineConfiguration.getSpans().size());
        List<GridItemSpan> spans = lineConfiguration.getSpans();
        int size = spans.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            int m987getCurrentLineSpanimpl = GridItemSpan.m987getCurrentLineSpanimpl(spans.get(i3).m990unboximpl());
            arrayList.add(TuplesKt.to(Integer.valueOf(firstItemIndex), Constraints.m7936boximpl(lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1.m1012childConstraintsJhjzzOo$foundation_release(i2, m987getCurrentLineSpanimpl))));
            firstItemIndex++;
            i2 += m987getCurrentLineSpanimpl;
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MeasureResult measure_0kLqBqw$lambda$6(LazyLayoutMeasureScope lazyLayoutMeasureScope, long j, int i, int i2, int i3, int i4, Function1 function1) {
        return lazyLayoutMeasureScope.layout(ConstraintsKt.m7966constrainWidthK40F9xA(j, i3 + i), ConstraintsKt.m7965constrainHeightK40F9xA(j, i4 + i2), MapsKt.emptyMap(), function1);
    }
}
