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
    public final MeasureResult mo1043measure0kLqBqw(final LazyLayoutMeasureScope lazyLayoutMeasureScope, final long j) {
        int i;
        int i2;
        final int i3;
        float mo789getSpacingD9Ej5fM;
        int m8211getMaxWidthimpl;
        LazyListItemProvider lazyListItemProvider;
        long m8380constructorimpl;
        float scrollToBeConsumed$foundation;
        ObservableScopeInvalidator.m1146attachToScopeimpl(this.$state.m1061getMeasurementScopeInvalidatorzYiylxw$foundation());
        boolean z = this.$state.getHasLookaheadOccurred$foundation() || lazyLayoutMeasureScope.isLookingAhead();
        CheckScrollableContainerConstraintsKt.m333checkScrollableContainerConstraintsK40F9xA(j, this.$isVertical ? Orientation.Vertical : Orientation.Horizontal);
        if (this.$isVertical) {
            i = lazyLayoutMeasureScope.mo458roundToPx0680j_4(this.$contentPadding.mo873calculateLeftPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection()));
        } else {
            i = lazyLayoutMeasureScope.mo458roundToPx0680j_4(PaddingKt.calculateStartPadding(this.$contentPadding, lazyLayoutMeasureScope.getLayoutDirection()));
        }
        if (this.$isVertical) {
            i2 = lazyLayoutMeasureScope.mo458roundToPx0680j_4(this.$contentPadding.mo874calculateRightPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection()));
        } else {
            i2 = lazyLayoutMeasureScope.mo458roundToPx0680j_4(PaddingKt.calculateEndPadding(this.$contentPadding, lazyLayoutMeasureScope.getLayoutDirection()));
        }
        int i4 = lazyLayoutMeasureScope.mo458roundToPx0680j_4(this.$contentPadding.mo875calculateTopPaddingD9Ej5fM());
        int i5 = lazyLayoutMeasureScope.mo458roundToPx0680j_4(this.$contentPadding.mo872calculateBottomPaddingD9Ej5fM());
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
        final long m8230offsetNN6EwU = ConstraintsKt.m8230offsetNN6EwU(j, -i7, -i6);
        LazyListItemProvider invoke = this.$itemProviderLambda.invoke();
        invoke.getItemScope().setMaxSize(Constraints.m8211getMaxWidthimpl(m8230offsetNN6EwU), Constraints.m8210getMaxHeightimpl(m8230offsetNN6EwU));
        if (this.$isVertical) {
            Arrangement.Vertical vertical = this.$verticalArrangement;
            if (vertical != null) {
                mo789getSpacingD9Ej5fM = vertical.mo789getSpacingD9Ej5fM();
            } else {
                InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("null verticalArrangement when isVertical == true");
                throw new KotlinNothingValueException();
            }
        } else {
            Arrangement.Horizontal horizontal = this.$horizontalArrangement;
            if (horizontal != null) {
                mo789getSpacingD9Ej5fM = horizontal.mo789getSpacingD9Ej5fM();
            } else {
                InlineClassHelperKt.throwIllegalArgumentExceptionForNullCheck("null horizontalAlignment when isVertical == false");
                throw new KotlinNothingValueException();
            }
        }
        final int i10 = lazyLayoutMeasureScope.mo458roundToPx0680j_4(mo789getSpacingD9Ej5fM);
        final int itemCount = invoke.getItemCount();
        if (this.$isVertical) {
            m8211getMaxWidthimpl = Constraints.m8210getMaxHeightimpl(j) - i6;
        } else {
            m8211getMaxWidthimpl = Constraints.m8211getMaxWidthimpl(j) - i7;
        }
        int i11 = m8211getMaxWidthimpl;
        if (this.$reverseLayout && i11 <= 0) {
            boolean z3 = this.$isVertical;
            if (!z3) {
                i += i11;
            }
            if (z3) {
                i4 += i11;
            }
            lazyListItemProvider = invoke;
            m8380constructorimpl = IntOffset.m8380constructorimpl((i << 32) | (i4 & 4294967295L));
        } else {
            lazyListItemProvider = invoke;
            m8380constructorimpl = IntOffset.m8380constructorimpl((i << 32) | (i4 & 4294967295L));
        }
        final boolean z4 = this.$isVertical;
        final Alignment.Horizontal horizontal2 = this.$horizontalAlignment;
        final long j2 = m8380constructorimpl;
        final LazyListItemProvider lazyListItemProvider2 = lazyListItemProvider;
        final Alignment.Vertical vertical2 = this.$verticalAlignment;
        final boolean z5 = this.$reverseLayout;
        final LazyListState lazyListState = this.$state;
        LazyListMeasuredItemProvider lazyListMeasuredItemProvider = new LazyListMeasuredItemProvider(m8230offsetNN6EwU, z4, lazyListItemProvider2, lazyLayoutMeasureScope, itemCount, i10, horizontal2, vertical2, z5, i3, i9, j2, lazyListState) { // from class: androidx.compose.foundation.lazy.LazyListKt$rememberLazyListMeasurePolicy$1$1$measuredItemProvider$1
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
            public LazyListMeasuredItem mo1044createItemX9ElhV4(int i12, Object obj, Object obj2, List<? extends Placeable> list, long j3) {
                return new LazyListMeasuredItem(i12, list, this.$isVertical, this.$horizontalAlignment, this.$verticalAlignment, this.$this_LazyLayoutMeasurePolicy.getLayoutDirection(), this.$reverseLayout, this.$beforeContentPadding, this.$afterContentPadding, i12 == this.$itemsCount + (-1) ? 0 : this.$spaceBetweenItems, this.$visualItemOffset, obj, obj2, this.$state.getItemAnimator$foundation(), j3, null);
            }
        };
        Snapshot.Companion companion = Snapshot.Companion;
        LazyListState lazyListState2 = this.$state;
        Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
        Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
        Snapshot makeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
        try {
            int updateScrollPositionIfTheFirstItemWasMoved$foundation = lazyListState2.updateScrollPositionIfTheFirstItemWasMoved$foundation(lazyListItemProvider2, lazyListState2.getFirstVisibleItemIndex());
            int firstVisibleItemScrollOffset = lazyListState2.getFirstVisibleItemScrollOffset();
            Unit unit = Unit.INSTANCE;
            companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
            List<Integer> calculateLazyLayoutPinnedIndices = LazyLayoutBeyondBoundsStateKt.calculateLazyLayoutPinnedIndices(lazyListItemProvider2, this.$state.getPinnedItems$foundation(), this.$state.getBeyondBoundsInfo$foundation());
            if (lazyLayoutMeasureScope.isLookingAhead() || !z) {
                scrollToBeConsumed$foundation = this.$state.getScrollToBeConsumed$foundation();
            } else {
                scrollToBeConsumed$foundation = this.$state.getScrollDeltaBetweenPasses$foundation();
            }
            LazyListMeasuredItemProvider lazyListMeasuredItemProvider2 = lazyListMeasuredItemProvider;
            LazyListMeasureResult m1049measureLazyList_s_dbAc = LazyListMeasureKt.m1049measureLazyList_s_dbAc(itemCount, lazyListMeasuredItemProvider2, i11, i3, i9, i10, updateScrollPositionIfTheFirstItemWasMoved$foundation, firstVisibleItemScrollOffset, scrollToBeConsumed$foundation, m8230offsetNN6EwU, this.$isVertical, this.$verticalArrangement, this.$horizontalArrangement, this.$reverseLayout, lazyLayoutMeasureScope, this.$state.getItemAnimator$foundation(), this.$beyondBoundsItemCount, calculateLazyLayoutPinnedIndices, z, lazyLayoutMeasureScope.isLookingAhead(), this.$coroutineScope, this.$state.m1062getPlacementScopeInvalidatorzYiylxw$foundation(), this.$graphicsContext, this.$stickyItemsPlacement, new Function3() { // from class: androidx.compose.foundation.lazy.LazyListKt$rememberLazyListMeasurePolicy$1$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    MeasureResult measure_0kLqBqw$lambda$3;
                    measure_0kLqBqw$lambda$3 = LazyListKt$rememberLazyListMeasurePolicy$1$1.measure_0kLqBqw$lambda$3(LazyLayoutMeasureScope.this, j, i7, i6, ((Integer) obj).intValue(), ((Integer) obj2).intValue(), (Function1) obj3);
                    return measure_0kLqBqw$lambda$3;
                }
            });
            LazyListState.applyMeasureResult$foundation$default(this.$state, m1049measureLazyList_s_dbAc, lazyLayoutMeasureScope.isLookingAhead(), false, 4, null);
            LazyListPrefetchStrategy prefetchStrategy$foundation = this.$state.getPrefetchStrategy$foundation();
            CacheWindowLogic cacheWindowLogic = prefetchStrategy$foundation instanceof CacheWindowLogic ? (CacheWindowLogic) prefetchStrategy$foundation : null;
            if (cacheWindowLogic != null) {
                LazyListKt.keepAroundItems(cacheWindowLogic, m1049measureLazyList_s_dbAc.getVisibleItemsInfo(), lazyListMeasuredItemProvider2);
            }
            return m1049measureLazyList_s_dbAc;
        } catch (Throwable th) {
            companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MeasureResult measure_0kLqBqw$lambda$3(LazyLayoutMeasureScope lazyLayoutMeasureScope, long j, int i, int i2, int i3, int i4, Function1 function1) {
        return lazyLayoutMeasureScope.layout(ConstraintsKt.m8228constrainWidthK40F9xA(j, i3 + i), ConstraintsKt.m8227constrainHeightK40F9xA(j, i4 + i2), MapsKt.emptyMap(), function1);
    }
}
