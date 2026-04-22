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

    /* JADX WARN: Removed duplicated region for block: B:84:0x0252  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0256  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0259  */
    /* JADX WARN: Type inference failed for: r21v1, types: [androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1] */
    /* JADX WARN: Type inference failed for: r26v0, types: [androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1] */
    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasurePolicy
    /* renamed from: measure-0kLqBqw */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final MeasureResult mo920measure0kLqBqw(final LazyLayoutMeasureScope lazyLayoutMeasureScope, final long j) {
        int i;
        int i2;
        int i3;
        float mo694getSpacingD9Ej5fM;
        int m7508getMaxWidthimpl;
        int i4;
        long m7677constructorimpl;
        int lineIndexOfItem;
        int firstVisibleItemScrollOffset;
        float scrollToBeConsumed$foundation;
        CacheWindowLogic cacheWindowLogic;
        ObservableScopeInvalidator.m1005attachToScopeimpl(this.$state.m963getMeasurementScopeInvalidatorzYiylxw$foundation());
        boolean z = this.$state.getHasLookaheadOccurred$foundation() || lazyLayoutMeasureScope.isLookingAhead();
        CheckScrollableContainerConstraintsKt.m291checkScrollableContainerConstraintsK40F9xA(j, this.$isVertical ? Orientation.Vertical : Orientation.Horizontal);
        boolean z2 = this.$isVertical;
        PaddingValues paddingValues = this.$contentPadding;
        if (z2) {
            i = lazyLayoutMeasureScope.mo399roundToPx0680j_4(paddingValues.mo768calculateLeftPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection()));
        } else {
            i = lazyLayoutMeasureScope.mo399roundToPx0680j_4(PaddingKt.calculateStartPadding(paddingValues, lazyLayoutMeasureScope.getLayoutDirection()));
        }
        boolean z3 = this.$isVertical;
        PaddingValues paddingValues2 = this.$contentPadding;
        if (z3) {
            i2 = lazyLayoutMeasureScope.mo399roundToPx0680j_4(paddingValues2.mo769calculateRightPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection()));
        } else {
            i2 = lazyLayoutMeasureScope.mo399roundToPx0680j_4(PaddingKt.calculateEndPadding(paddingValues2, lazyLayoutMeasureScope.getLayoutDirection()));
        }
        int i5 = lazyLayoutMeasureScope.mo399roundToPx0680j_4(this.$contentPadding.mo770calculateTopPaddingD9Ej5fM());
        int i6 = lazyLayoutMeasureScope.mo399roundToPx0680j_4(this.$contentPadding.mo767calculateBottomPaddingD9Ej5fM());
        int i7 = i5 + i6;
        final int i8 = i + i2;
        boolean z4 = this.$isVertical;
        int i9 = z4 ? i7 : i8;
        if (z4 && !this.$reverseLayout) {
            i3 = i5;
        } else if (z4 && this.$reverseLayout) {
            i3 = i6;
        } else {
            i3 = (z4 || this.$reverseLayout) ? i2 : i;
        }
        final int i10 = i9 - i3;
        long m7527offsetNN6EwU = ConstraintsKt.m7527offsetNN6EwU(j, -i8, -i7);
        final LazyGridItemProvider invoke = this.$itemProviderLambda.invoke();
        final LazyGridSpanLayoutProvider spanLayoutProvider = invoke.getSpanLayoutProvider();
        LazyLayoutMeasureScope lazyLayoutMeasureScope2 = lazyLayoutMeasureScope;
        final LazyGridSlots mo946invoke0kLqBqw = this.$slots.mo946invoke0kLqBqw(lazyLayoutMeasureScope2, m7527offsetNN6EwU);
        int length = mo946invoke0kLqBqw.getSizes().length;
        spanLayoutProvider.setSlotsPerLine(length);
        if (this.$isVertical) {
            Arrangement.Vertical vertical = this.$verticalArrangement;
            if (vertical != null) {
                mo694getSpacingD9Ej5fM = vertical.mo694getSpacingD9Ej5fM();
            } else {
                InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("null verticalArrangement when isVertical == true");
                throw new KotlinNothingValueException();
            }
        } else {
            Arrangement.Horizontal horizontal = this.$horizontalArrangement;
            if (horizontal != null) {
                mo694getSpacingD9Ej5fM = horizontal.mo694getSpacingD9Ej5fM();
            } else {
                InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("null horizontalArrangement when isVertical == false");
                throw new KotlinNothingValueException();
            }
        }
        final int i11 = lazyLayoutMeasureScope.mo399roundToPx0680j_4(mo694getSpacingD9Ej5fM);
        final int itemCount = invoke.getItemCount();
        if (this.$isVertical) {
            m7508getMaxWidthimpl = Constraints.m7507getMaxHeightimpl(j) - i7;
        } else {
            m7508getMaxWidthimpl = Constraints.m7508getMaxWidthimpl(j) - i8;
        }
        int i12 = m7508getMaxWidthimpl;
        if (this.$reverseLayout && i12 <= 0) {
            boolean z5 = this.$isVertical;
            if (!z5) {
                i += i12;
            }
            if (z5) {
                i5 += i12;
            }
            i4 = i7;
            m7677constructorimpl = IntOffset.m7677constructorimpl((i5 & 4294967295L) | (i << 32));
        } else {
            i4 = i7;
            m7677constructorimpl = IntOffset.m7677constructorimpl((i << 32) | (i5 & 4294967295L));
        }
        final LazyGridState lazyGridState = this.$state;
        final boolean z6 = this.$isVertical;
        final boolean z7 = this.$reverseLayout;
        final int i13 = i3;
        final long j2 = m7677constructorimpl;
        final ?? r26 = new LazyGridMeasuredItemProvider(invoke, lazyLayoutMeasureScope, i11, lazyGridState, z6, z7, i13, i10, j2) { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredItemProvider$1
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
                this.$isVertical = z6;
                this.$reverseLayout = z7;
                this.$beforeContentPadding = i13;
                this.$afterContentPadding = i10;
                this.$visualItemOffset = j2;
            }

            @Override // androidx.compose.foundation.lazy.grid.LazyGridMeasuredItemProvider
            /* renamed from: createItem-O3s9Psw  reason: not valid java name */
            public LazyGridMeasuredItem mo955createItemO3s9Psw(int i14, Object obj, Object obj2, int i15, int i16, List<? extends Placeable> list, long j3, int i17, int i18) {
                return new LazyGridMeasuredItem(i14, obj, this.$isVertical, i15, i16, this.$reverseLayout, this.$this_LazyLayoutMeasurePolicy.getLayoutDirection(), this.$beforeContentPadding, this.$afterContentPadding, list, this.$visualItemOffset, obj2, this.$state.getItemAnimator$foundation(), j3, i17, i18, null);
            }
        };
        final boolean z8 = this.$isVertical;
        final ?? r21 = new LazyGridMeasuredLineProvider(z8, mo946invoke0kLqBqw, itemCount, i11, r26, spanLayoutProvider) { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1
            final /* synthetic */ boolean $isVertical;
            final /* synthetic */ LazyGridSlots $resolvedSlots;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(z8, mo946invoke0kLqBqw, itemCount, i11, r26, spanLayoutProvider);
                this.$isVertical = z8;
                this.$resolvedSlots = mo946invoke0kLqBqw;
            }

            @Override // androidx.compose.foundation.lazy.grid.LazyGridMeasuredLineProvider
            public LazyGridMeasuredLine createLine(int i14, LazyGridMeasuredItem[] lazyGridMeasuredItemArr, List<GridItemSpan> list, int i15) {
                return new LazyGridMeasuredLine(i14, lazyGridMeasuredItemArr, this.$resolvedSlots, list, this.$isVertical, i15);
            }
        };
        Function1 function1 = new Function1() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LazyGridKt$rememberLazyGridMeasurePolicy$1$1.measure_0kLqBqw$lambda$2(LazyGridSpanLayoutProvider.this, r21, ((Integer) obj).intValue());
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
            int updateScrollPositionIfTheFirstItemWasMoved$foundation = lazyGridState2.updateScrollPositionIfTheFirstItemWasMoved$foundation(invoke, lazyGridState2.getFirstVisibleItemIndex());
            if (updateScrollPositionIfTheFirstItemWasMoved$foundation >= itemCount && itemCount > 0) {
                lineIndexOfItem = spanLayoutProvider.getLineIndexOfItem(itemCount - 1);
                firstVisibleItemScrollOffset = 0;
                int i14 = lineIndexOfItem;
                Unit unit = Unit.INSTANCE;
                companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
                List<Integer> calculateLazyLayoutPinnedIndices = LazyLayoutBeyondBoundsStateKt.calculateLazyLayoutPinnedIndices(invoke, this.$state.getPinnedItems$foundation(), this.$state.getBeyondBoundsInfo$foundation());
                if (!lazyLayoutMeasureScope.isLookingAhead() || !z) {
                    scrollToBeConsumed$foundation = this.$state.getScrollToBeConsumed$foundation();
                } else {
                    scrollToBeConsumed$foundation = this.$state.getScrollDeltaBetweenPasses$foundation();
                }
                LazyGridMeasuredLineProvider lazyGridMeasuredLineProvider = (LazyGridMeasuredLineProvider) r21;
                final int i15 = i4;
                LazyGridMeasureResult m958measureLazyGridt1x4au0 = LazyGridMeasureKt.m958measureLazyGridt1x4au0(itemCount, lazyGridMeasuredLineProvider, (LazyGridMeasuredItemProvider) r26, i12, i3, i10, i11, i14, firstVisibleItemScrollOffset, scrollToBeConsumed$foundation, m7527offsetNN6EwU, this.$isVertical, this.$verticalArrangement, this.$horizontalArrangement, this.$reverseLayout, lazyLayoutMeasureScope2, this.$state.getItemAnimator$foundation(), length, calculateLazyLayoutPinnedIndices, z, lazyLayoutMeasureScope.isLookingAhead(), this.$state.getApproachLayoutInfo$foundation(), this.$coroutineScope, this.$state.m964getPlacementScopeInvalidatorzYiylxw$foundation(), this.$graphicsContext, function1, function12, this.$stickyItemsScrollBehavior, new Function3() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        MeasureResult layout;
                        Function1 function13 = (Function1) obj3;
                        layout = LazyLayoutMeasureScope.this.layout(ConstraintsKt.m7525constrainWidthK40F9xA(r1, ((Integer) obj).intValue() + i8), ConstraintsKt.m7524constrainHeightK40F9xA(j, ((Integer) obj2).intValue() + i15), MapsKt.emptyMap(), function13);
                        return layout;
                    }
                });
                LazyGridState.applyMeasureResult$foundation$default(this.$state, m958measureLazyGridt1x4au0, lazyLayoutMeasureScope.isLookingAhead(), false, 4, null);
                LazyGridPrefetchStrategy prefetchStrategy$foundation = this.$state.getPrefetchStrategy$foundation();
                cacheWindowLogic = !(prefetchStrategy$foundation instanceof CacheWindowLogic) ? (CacheWindowLogic) prefetchStrategy$foundation : null;
                if (cacheWindowLogic != null) {
                    LazyGridKt.keepAroundItems(cacheWindowLogic, m958measureLazyGridt1x4au0.getOrientation(), m958measureLazyGridt1x4au0.getVisibleItemsInfo(), lazyGridMeasuredLineProvider);
                }
                return m958measureLazyGridt1x4au0;
            }
            lineIndexOfItem = spanLayoutProvider.getLineIndexOfItem(updateScrollPositionIfTheFirstItemWasMoved$foundation);
            firstVisibleItemScrollOffset = lazyGridState2.getFirstVisibleItemScrollOffset();
            int i142 = lineIndexOfItem;
            Unit unit2 = Unit.INSTANCE;
            companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
            List<Integer> calculateLazyLayoutPinnedIndices2 = LazyLayoutBeyondBoundsStateKt.calculateLazyLayoutPinnedIndices(invoke, this.$state.getPinnedItems$foundation(), this.$state.getBeyondBoundsInfo$foundation());
            if (!lazyLayoutMeasureScope.isLookingAhead()) {
            }
            scrollToBeConsumed$foundation = this.$state.getScrollToBeConsumed$foundation();
            LazyGridMeasuredLineProvider lazyGridMeasuredLineProvider2 = (LazyGridMeasuredLineProvider) r21;
            final int i152 = i4;
            LazyGridMeasureResult m958measureLazyGridt1x4au02 = LazyGridMeasureKt.m958measureLazyGridt1x4au0(itemCount, lazyGridMeasuredLineProvider2, (LazyGridMeasuredItemProvider) r26, i12, i3, i10, i11, i142, firstVisibleItemScrollOffset, scrollToBeConsumed$foundation, m7527offsetNN6EwU, this.$isVertical, this.$verticalArrangement, this.$horizontalArrangement, this.$reverseLayout, lazyLayoutMeasureScope2, this.$state.getItemAnimator$foundation(), length, calculateLazyLayoutPinnedIndices2, z, lazyLayoutMeasureScope.isLookingAhead(), this.$state.getApproachLayoutInfo$foundation(), this.$coroutineScope, this.$state.m964getPlacementScopeInvalidatorzYiylxw$foundation(), this.$graphicsContext, function1, function12, this.$stickyItemsScrollBehavior, new Function3() { // from class: androidx.compose.foundation.lazy.grid.LazyGridKt$rememberLazyGridMeasurePolicy$1$1$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    MeasureResult layout;
                    Function1 function13 = (Function1) obj3;
                    layout = LazyLayoutMeasureScope.this.layout(ConstraintsKt.m7525constrainWidthK40F9xA(r1, ((Integer) obj).intValue() + i8), ConstraintsKt.m7524constrainHeightK40F9xA(j, ((Integer) obj2).intValue() + i152), MapsKt.emptyMap(), function13);
                    return layout;
                }
            });
            LazyGridState.applyMeasureResult$foundation$default(this.$state, m958measureLazyGridt1x4au02, lazyLayoutMeasureScope.isLookingAhead(), false, 4, null);
            LazyGridPrefetchStrategy prefetchStrategy$foundation2 = this.$state.getPrefetchStrategy$foundation();
            if (!(prefetchStrategy$foundation2 instanceof CacheWindowLogic)) {
            }
            if (cacheWindowLogic != null) {
            }
            return m958measureLazyGridt1x4au02;
        } catch (Throwable th) {
            companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final ArrayList measure_0kLqBqw$lambda$2(LazyGridSpanLayoutProvider lazyGridSpanLayoutProvider, LazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1 lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1, int i) {
        LazyGridSpanLayoutProvider.LineConfiguration lineConfiguration = lazyGridSpanLayoutProvider.getLineConfiguration(i);
        int firstItemIndex = lineConfiguration.getFirstItemIndex();
        ArrayList arrayList = new ArrayList(lineConfiguration.getSpans().size());
        List<GridItemSpan> spans = lineConfiguration.getSpans();
        int size = spans.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            int m942getCurrentLineSpanimpl = GridItemSpan.m942getCurrentLineSpanimpl(spans.get(i3).m945unboximpl());
            arrayList.add(TuplesKt.to(Integer.valueOf(firstItemIndex), Constraints.m7495boximpl(lazyGridKt$rememberLazyGridMeasurePolicy$1$1$measuredLineProvider$1.m962childConstraintsJhjzzOo$foundation(i2, m942getCurrentLineSpanimpl))));
            firstItemIndex++;
            i2 += m942getCurrentLineSpanimpl;
        }
        return arrayList;
    }
}
