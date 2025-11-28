package androidx.compose.foundation.lazy;

import androidx.compose.foundation.CheckScrollableContainerConstraintsKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.layout.CacheWindowLogic;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsStateKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasurePolicy;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.foundation.lazy.layout.ObservableScopeInvalidator;
import androidx.compose.foundation.lazy.layout.StickyItemsPlacement;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LazyList.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LazyListKt$rememberLazyListMeasurePolicy$1$1 implements LazyLayoutMeasurePolicy {
    final /* synthetic */ int $beyondBoundsItemCount;
    final /* synthetic */ PaddingValues $contentPadding;
    final /* synthetic */ CoroutineScope $coroutineScope;
    final /* synthetic */ GraphicsContext $graphicsContext;
    final /* synthetic */ Alignment.Horizontal $horizontalAlignment;
    final /* synthetic */ Arrangement.Horizontal $horizontalArrangement;
    final /* synthetic */ boolean $isVertical;
    final /* synthetic */ Function0<LazyListItemProvider> $itemProviderLambda;
    final /* synthetic */ boolean $reverseLayout;
    final /* synthetic */ LazyListState $state;
    final /* synthetic */ StickyItemsPlacement $stickyItemsPlacement;
    final /* synthetic */ Alignment.Vertical $verticalAlignment;
    final /* synthetic */ Arrangement.Vertical $verticalArrangement;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public LazyListKt$rememberLazyListMeasurePolicy$1$1(LazyListState lazyListState, boolean z, PaddingValues paddingValues, boolean z2, Function0<? extends LazyListItemProvider> function0, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, int i, CoroutineScope coroutineScope, GraphicsContext graphicsContext, StickyItemsPlacement stickyItemsPlacement, Alignment.Horizontal horizontal2, Alignment.Vertical vertical2) {
        this.$state = lazyListState;
        this.$isVertical = z;
        this.$contentPadding = paddingValues;
        this.$reverseLayout = z2;
        this.$itemProviderLambda = function0;
        this.$verticalArrangement = vertical;
        this.$horizontalArrangement = horizontal;
        this.$beyondBoundsItemCount = i;
        this.$coroutineScope = coroutineScope;
        this.$graphicsContext = graphicsContext;
        this.$stickyItemsPlacement = stickyItemsPlacement;
        this.$horizontalAlignment = horizontal2;
        this.$verticalAlignment = vertical2;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasurePolicy
    /* renamed from: measure-0kLqBqw  reason: not valid java name */
    public final MeasureResult mo960measure0kLqBqw(final LazyLayoutMeasureScope lazyLayoutMeasureScope, final long j) {
        int i;
        int i2;
        final int i3;
        float mo709getSpacingD9Ej5fM;
        int m7949getMaxWidthimpl;
        LazyListItemProvider lazyListItemProvider;
        long m8118constructorimpl;
        float scrollToBeConsumed$foundation_release;
        ObservableScopeInvalidator.m1072attachToScopeimpl(this.$state.m980getMeasurementScopeInvalidatorzYiylxw$foundation_release());
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
        final long m7968offsetNN6EwU = ConstraintsKt.m7968offsetNN6EwU(j, -i7, -i6);
        LazyListItemProvider invoke = this.$itemProviderLambda.invoke();
        invoke.getItemScope().setMaxSize(Constraints.m7949getMaxWidthimpl(m7968offsetNN6EwU), Constraints.m7948getMaxHeightimpl(m7968offsetNN6EwU));
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
                InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("null horizontalAlignment when isVertical == false");
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
            lazyListItemProvider = invoke;
            m8118constructorimpl = IntOffset.m8118constructorimpl((i << 32) | (i4 & 4294967295L));
        } else {
            lazyListItemProvider = invoke;
            m8118constructorimpl = IntOffset.m8118constructorimpl((i << 32) | (i4 & 4294967295L));
        }
        final boolean z4 = this.$isVertical;
        final Alignment.Horizontal horizontal2 = this.$horizontalAlignment;
        final long j2 = m8118constructorimpl;
        final LazyListItemProvider lazyListItemProvider2 = lazyListItemProvider;
        final Alignment.Vertical vertical2 = this.$verticalAlignment;
        final boolean z5 = this.$reverseLayout;
        final LazyListState lazyListState = this.$state;
        LazyListMeasuredItemProvider lazyListMeasuredItemProvider = new LazyListMeasuredItemProvider(m7968offsetNN6EwU, z4, lazyListItemProvider2, lazyLayoutMeasureScope, itemCount, i10, horizontal2, vertical2, z5, i3, i9, j2, lazyListState) { // from class: androidx.compose.foundation.lazy.LazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1
            final /* synthetic */ int $afterContentPadding;
            final /* synthetic */ int $beforeContentPadding;
            final /* synthetic */ Alignment.Horizontal $horizontalAlignment;
            final /* synthetic */ boolean $isVertical;
            final /* synthetic */ int $itemsCount;
            final /* synthetic */ boolean $reverseLayout;
            final /* synthetic */ int $spaceBetweenItems;
            final /* synthetic */ LazyListState $state;
            final /* synthetic */ LazyLayoutMeasureScope $this_LazyLayoutMeasurePolicy;
            final /* synthetic */ Alignment.Vertical $verticalAlignment;
            final /* synthetic */ long $visualItemOffset;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.$isVertical = z4;
                this.$this_LazyLayoutMeasurePolicy = lazyLayoutMeasureScope;
                this.$itemsCount = itemCount;
                this.$spaceBetweenItems = i10;
                this.$horizontalAlignment = horizontal2;
                this.$verticalAlignment = vertical2;
                this.$reverseLayout = z5;
                this.$beforeContentPadding = i3;
                this.$afterContentPadding = i9;
                this.$visualItemOffset = j2;
                this.$state = lazyListState;
            }

            @Override // androidx.compose.foundation.lazy.LazyListMeasuredItemProvider
            /* renamed from: createItem-X9ElhV4  reason: not valid java name */
            public LazyListMeasuredItem mo961createItemX9ElhV4(int i12, Object obj, Object obj2, List<? extends Placeable> list, long j3) {
                return new LazyListMeasuredItem(i12, list, this.$isVertical, this.$horizontalAlignment, this.$verticalAlignment, this.$this_LazyLayoutMeasurePolicy.getLayoutDirection(), this.$reverseLayout, this.$beforeContentPadding, this.$afterContentPadding, i12 == this.$itemsCount + (-1) ? 0 : this.$spaceBetweenItems, this.$visualItemOffset, obj, obj2, this.$state.getItemAnimator$foundation_release(), j3, null);
            }
        };
        Snapshot.Companion companion = Snapshot.Companion;
        LazyListState lazyListState2 = this.$state;
        Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
        Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
        Snapshot makeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
        try {
            int updateScrollPositionIfTheFirstItemWasMoved$foundation_release = lazyListState2.updateScrollPositionIfTheFirstItemWasMoved$foundation_release(lazyListItemProvider2, lazyListState2.getFirstVisibleItemIndex());
            int firstVisibleItemScrollOffset = lazyListState2.getFirstVisibleItemScrollOffset();
            Unit unit = Unit.INSTANCE;
            companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
            List<Integer> calculateLazyLayoutPinnedIndices = LazyLayoutBeyondBoundsStateKt.calculateLazyLayoutPinnedIndices(lazyListItemProvider2, this.$state.getPinnedItems$foundation_release(), this.$state.getBeyondBoundsInfo$foundation_release());
            if (lazyLayoutMeasureScope.isLookingAhead() || !z) {
                scrollToBeConsumed$foundation_release = this.$state.getScrollToBeConsumed$foundation_release();
            } else {
                scrollToBeConsumed$foundation_release = this.$state.getScrollDeltaBetweenPasses$foundation_release();
            }
            LazyListMeasuredItemProvider lazyListMeasuredItemProvider2 = lazyListMeasuredItemProvider;
            LazyListMeasureResult m967measureLazyListLCrQqZ4 = LazyListMeasureKt.m967measureLazyListLCrQqZ4(itemCount, lazyListMeasuredItemProvider2, i11, i3, i9, i10, updateScrollPositionIfTheFirstItemWasMoved$foundation_release, firstVisibleItemScrollOffset, scrollToBeConsumed$foundation_release, m7968offsetNN6EwU, this.$isVertical, this.$verticalArrangement, this.$horizontalArrangement, this.$reverseLayout, lazyLayoutMeasureScope, this.$state.getItemAnimator$foundation_release(), this.$beyondBoundsItemCount, calculateLazyLayoutPinnedIndices, z, lazyLayoutMeasureScope.isLookingAhead(), this.$state.getApproachLayoutInfo$foundation_release(), this.$coroutineScope, this.$state.m981getPlacementScopeInvalidatorzYiylxw$foundation_release(), this.$graphicsContext, this.$stickyItemsPlacement, new Function3() { // from class: androidx.compose.foundation.lazy.LazyListKt$rememberLazyListMeasurePolicy$1$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    MeasureResult measure_0kLqBqw$lambda$3;
                    measure_0kLqBqw$lambda$3 = LazyListKt$rememberLazyListMeasurePolicy$1$1.measure_0kLqBqw$lambda$3(LazyLayoutMeasureScope.this, j, i7, i6, ((Integer) obj).intValue(), ((Integer) obj2).intValue(), (Function1) obj3);
                    return measure_0kLqBqw$lambda$3;
                }
            });
            LazyListState.applyMeasureResult$foundation_release$default(this.$state, m967measureLazyListLCrQqZ4, lazyLayoutMeasureScope.isLookingAhead(), false, 4, null);
            LazyListPrefetchStrategy prefetchStrategy$foundation_release = this.$state.getPrefetchStrategy$foundation_release();
            CacheWindowLogic cacheWindowLogic = prefetchStrategy$foundation_release instanceof CacheWindowLogic ? (CacheWindowLogic) prefetchStrategy$foundation_release : null;
            if (cacheWindowLogic != null) {
                LazyListKt.keepAroundItems(cacheWindowLogic, m967measureLazyListLCrQqZ4.getVisibleItemsInfo(), lazyListMeasuredItemProvider2);
            }
            return m967measureLazyListLCrQqZ4;
        } catch (Throwable th) {
            companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MeasureResult measure_0kLqBqw$lambda$3(LazyLayoutMeasureScope lazyLayoutMeasureScope, long j, int i, int i2, int i3, int i4, Function1 function1) {
        return lazyLayoutMeasureScope.layout(ConstraintsKt.m7966constrainWidthK40F9xA(j, i3 + i), ConstraintsKt.m7965constrainHeightK40F9xA(j, i4 + i2), MapsKt.emptyMap(), function1);
    }
}
