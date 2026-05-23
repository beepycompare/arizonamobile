package androidx.compose.foundation.pager;

import androidx.collection.IntObjectMapKt;
import androidx.compose.foundation.CheckScrollableContainerConstraintsKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.snapping.SnapPosition;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsStateKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasurePolicy;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.foundation.lazy.layout.ObservableScopeInvalidator;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PagerMeasurePolicy.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PagerMeasurePolicyKt$rememberPagerMeasurePolicy$1$1 implements LazyLayoutMeasurePolicy {
    final /* synthetic */ int $beyondViewportPageCount;
    final /* synthetic */ PaddingValues $contentPadding;
    final /* synthetic */ CoroutineScope $coroutineScope;
    final /* synthetic */ Alignment.Horizontal $horizontalAlignment;
    final /* synthetic */ Function0<PagerLazyLayoutItemProvider> $itemProviderLambda;
    final /* synthetic */ Orientation $orientation;
    final /* synthetic */ Function0<Integer> $pageCount;
    final /* synthetic */ PageSize $pageSize;
    final /* synthetic */ float $pageSpacing;
    final /* synthetic */ boolean $reverseLayout;
    final /* synthetic */ SnapPosition $snapPosition;
    final /* synthetic */ PagerState $state;
    final /* synthetic */ Alignment.Vertical $verticalAlignment;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PagerMeasurePolicyKt$rememberPagerMeasurePolicy$1$1(PagerState pagerState, Orientation orientation, PaddingValues paddingValues, boolean z, float f, PageSize pageSize, Function0<PagerLazyLayoutItemProvider> function0, Function0<Integer> function02, Alignment.Vertical vertical, Alignment.Horizontal horizontal, int i, SnapPosition snapPosition, CoroutineScope coroutineScope) {
        this.$state = pagerState;
        this.$orientation = orientation;
        this.$contentPadding = paddingValues;
        this.$reverseLayout = z;
        this.$pageSpacing = f;
        this.$pageSize = pageSize;
        this.$itemProviderLambda = function0;
        this.$pageCount = function02;
        this.$verticalAlignment = vertical;
        this.$horizontalAlignment = horizontal;
        this.$beyondViewportPageCount = i;
        this.$snapPosition = snapPosition;
        this.$coroutineScope = coroutineScope;
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasurePolicy
    /* renamed from: measure-0kLqBqw */
    public final MeasureResult mo1174measure0kLqBqw(final LazyLayoutMeasureScope lazyLayoutMeasureScope, final long j) {
        int i;
        int i2;
        int i3;
        int m8113getMaxWidthimpl;
        int i4;
        long m8282constructorimpl;
        ObservableScopeInvalidator.m1258attachToScopeimpl(this.$state.m1335getMeasurementScopeInvalidatorzYiylxw$foundation());
        boolean z = this.$orientation == Orientation.Vertical;
        CheckScrollableContainerConstraintsKt.m315checkScrollableContainerConstraintsK40F9xA(j, z ? Orientation.Vertical : Orientation.Horizontal);
        PaddingValues paddingValues = this.$contentPadding;
        if (z) {
            i = lazyLayoutMeasureScope.mo428roundToPx0680j_4(paddingValues.mo1000calculateLeftPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection()));
        } else {
            i = lazyLayoutMeasureScope.mo428roundToPx0680j_4(PaddingKt.calculateStartPadding(paddingValues, lazyLayoutMeasureScope.getLayoutDirection()));
        }
        PaddingValues paddingValues2 = this.$contentPadding;
        if (z) {
            i2 = lazyLayoutMeasureScope.mo428roundToPx0680j_4(paddingValues2.mo1001calculateRightPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection()));
        } else {
            i2 = lazyLayoutMeasureScope.mo428roundToPx0680j_4(PaddingKt.calculateEndPadding(paddingValues2, lazyLayoutMeasureScope.getLayoutDirection()));
        }
        int i5 = lazyLayoutMeasureScope.mo428roundToPx0680j_4(this.$contentPadding.mo1002calculateTopPaddingD9Ej5fM());
        int i6 = lazyLayoutMeasureScope.mo428roundToPx0680j_4(this.$contentPadding.mo999calculateBottomPaddingD9Ej5fM());
        final int i7 = i5 + i6;
        final int i8 = i + i2;
        int i9 = z ? i7 : i8;
        if (z && !this.$reverseLayout) {
            i3 = i5;
        } else if (z && this.$reverseLayout) {
            i3 = i6;
        } else {
            i3 = (z || this.$reverseLayout) ? i2 : i;
        }
        int i10 = i9 - i3;
        long m8132offsetNN6EwU = ConstraintsKt.m8132offsetNN6EwU(j, -i8, -i7);
        LazyLayoutMeasureScope lazyLayoutMeasureScope2 = lazyLayoutMeasureScope;
        this.$state.setDensity$foundation(lazyLayoutMeasureScope2);
        int i11 = lazyLayoutMeasureScope.mo428roundToPx0680j_4(this.$pageSpacing);
        if (z) {
            m8113getMaxWidthimpl = Constraints.m8112getMaxHeightimpl(j) - i7;
        } else {
            m8113getMaxWidthimpl = Constraints.m8113getMaxWidthimpl(j) - i8;
        }
        if (!this.$reverseLayout || m8113getMaxWidthimpl > 0) {
            i4 = i11;
            m8282constructorimpl = IntOffset.m8282constructorimpl((i << 32) | (i5 & 4294967295L));
        } else {
            if (!z) {
                i += m8113getMaxWidthimpl;
            }
            if (z) {
                i5 += m8113getMaxWidthimpl;
            }
            i4 = i11;
            m8282constructorimpl = IntOffset.m8282constructorimpl((i5 & 4294967295L) | (i << 32));
        }
        long j2 = m8282constructorimpl;
        int coerceAtLeast = RangesKt.coerceAtLeast(this.$pageSize.calculateMainAxisPageSize(lazyLayoutMeasureScope2, m8113getMaxWidthimpl, i4), 0);
        this.$state.m1339setPremeasureConstraintsBRTryo0$foundation(ConstraintsKt.Constraints$default(0, this.$orientation == Orientation.Vertical ? Constraints.m8113getMaxWidthimpl(m8132offsetNN6EwU) : coerceAtLeast, 0, this.$orientation != Orientation.Vertical ? Constraints.m8112getMaxHeightimpl(m8132offsetNN6EwU) : coerceAtLeast, 5, null));
        PagerLazyLayoutItemProvider invoke = this.$itemProviderLambda.invoke();
        int i12 = m8113getMaxWidthimpl + i3 + i10;
        Snapshot.Companion companion = Snapshot.Companion;
        PagerState pagerState = this.$state;
        SnapPosition snapPosition = this.$snapPosition;
        Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
        Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
        Snapshot makeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
        try {
            int matchScrollPositionWithKey$foundation = pagerState.matchScrollPositionWithKey$foundation(invoke, pagerState.getCurrentPage());
            int i13 = i4;
            int currentPageOffset = PagerKt.currentPageOffset(snapPosition, i12, coerceAtLeast, i13, i3, i10, pagerState.getCurrentPage(), pagerState.getCurrentPageOffsetFraction(), pagerState.getPageCount());
            Unit unit = Unit.INSTANCE;
            companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
            int i14 = m8113getMaxWidthimpl;
            int i15 = i3;
            PagerMeasureResult m1332measurePager7L1iB3k = PagerMeasureKt.m1332measurePager7L1iB3k(lazyLayoutMeasureScope, this.$pageCount.invoke().intValue(), invoke, i14, i15, i10, i13, matchScrollPositionWithKey$foundation, currentPageOffset, m8132offsetNN6EwU, this.$orientation, this.$verticalAlignment, this.$horizontalAlignment, this.$reverseLayout, j2, coerceAtLeast, this.$beyondViewportPageCount, LazyLayoutBeyondBoundsStateKt.calculateLazyLayoutPinnedIndices(invoke, this.$state.getPinnedPages$foundation(), this.$state.getBeyondBoundsInfo$foundation()), this.$snapPosition, this.$state.m1336getPlacementScopeInvalidatorzYiylxw$foundation(), this.$coroutineScope, lazyLayoutMeasureScope2, new Function3() { // from class: androidx.compose.foundation.pager.PagerMeasurePolicyKt$rememberPagerMeasurePolicy$1$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    MeasureResult layout;
                    Function1 function1 = (Function1) obj3;
                    layout = LazyLayoutMeasureScope.this.layout(ConstraintsKt.m8130constrainWidthK40F9xA(r1, ((Integer) obj).intValue() + i8), ConstraintsKt.m8129constrainHeightK40F9xA(j, ((Integer) obj2).intValue() + i7), MapsKt.emptyMap(), function1);
                    return layout;
                }
            }, IntObjectMapKt.mutableIntObjectMapOf());
            PagerState.applyMeasureResult$foundation$default(this.$state, m1332measurePager7L1iB3k, lazyLayoutMeasureScope.isLookingAhead(), false, 4, null);
            PagerMeasurePolicyKt.keepAroundItems(lazyLayoutMeasureScope, this.$state.getCacheWindowLogic$foundation(), m1332measurePager7L1iB3k.getVisiblePagesInfo());
            return m1332measurePager7L1iB3k;
        } catch (Throwable th) {
            companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
            throw th;
        }
    }
}
