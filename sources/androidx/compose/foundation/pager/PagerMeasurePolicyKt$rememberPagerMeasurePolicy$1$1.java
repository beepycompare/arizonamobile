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
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PagerMeasurePolicyKt$rememberPagerMeasurePolicy$1$1 implements LazyLayoutMeasurePolicy {

    /* renamed from: $$v$c$androidx-compose-ui-unit-Dp$-pageSpacing$0  reason: not valid java name */
    final /* synthetic */ float f53$$v$c$androidxcomposeuiunitDp$pageSpacing$0;
    final /* synthetic */ int $beyondViewportPageCount;
    final /* synthetic */ PaddingValues $contentPadding;
    final /* synthetic */ CoroutineScope $coroutineScope;
    final /* synthetic */ Alignment.Horizontal $horizontalAlignment;
    final /* synthetic */ Function0<PagerLazyLayoutItemProvider> $itemProviderLambda;
    final /* synthetic */ Orientation $orientation;
    final /* synthetic */ Function0<Integer> $pageCount;
    final /* synthetic */ PageSize $pageSize;
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
        this.f53$$v$c$androidxcomposeuiunitDp$pageSpacing$0 = f;
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
    public final MeasureResult mo920measure0kLqBqw(final LazyLayoutMeasureScope lazyLayoutMeasureScope, final long j) {
        int i;
        int i2;
        int i3;
        int m7508getMaxWidthimpl;
        int i4;
        long m7677constructorimpl;
        ObservableScopeInvalidator.m1005attachToScopeimpl(this.$state.m1081getMeasurementScopeInvalidatorzYiylxw$foundation());
        boolean z = this.$orientation == Orientation.Vertical;
        CheckScrollableContainerConstraintsKt.m291checkScrollableContainerConstraintsK40F9xA(j, z ? Orientation.Vertical : Orientation.Horizontal);
        PaddingValues paddingValues = this.$contentPadding;
        if (z) {
            i = lazyLayoutMeasureScope.mo399roundToPx0680j_4(paddingValues.mo768calculateLeftPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection()));
        } else {
            i = lazyLayoutMeasureScope.mo399roundToPx0680j_4(PaddingKt.calculateStartPadding(paddingValues, lazyLayoutMeasureScope.getLayoutDirection()));
        }
        PaddingValues paddingValues2 = this.$contentPadding;
        if (z) {
            i2 = lazyLayoutMeasureScope.mo399roundToPx0680j_4(paddingValues2.mo769calculateRightPaddingu2uoSUM(lazyLayoutMeasureScope.getLayoutDirection()));
        } else {
            i2 = lazyLayoutMeasureScope.mo399roundToPx0680j_4(PaddingKt.calculateEndPadding(paddingValues2, lazyLayoutMeasureScope.getLayoutDirection()));
        }
        int i5 = lazyLayoutMeasureScope.mo399roundToPx0680j_4(this.$contentPadding.mo770calculateTopPaddingD9Ej5fM());
        int i6 = lazyLayoutMeasureScope.mo399roundToPx0680j_4(this.$contentPadding.mo767calculateBottomPaddingD9Ej5fM());
        int i7 = i2;
        int i8 = i5 + i6;
        final int i9 = i + i7;
        int i10 = z ? i8 : i9;
        if (z && !this.$reverseLayout) {
            i3 = i5;
        } else if (z && this.$reverseLayout) {
            i3 = i6;
        } else {
            i3 = (z || this.$reverseLayout) ? i7 : i;
        }
        int i11 = i10 - i3;
        long m7527offsetNN6EwU = ConstraintsKt.m7527offsetNN6EwU(j, -i9, -i8);
        LazyLayoutMeasureScope lazyLayoutMeasureScope2 = lazyLayoutMeasureScope;
        this.$state.setDensity$foundation(lazyLayoutMeasureScope2);
        int i12 = lazyLayoutMeasureScope.mo399roundToPx0680j_4(this.f53$$v$c$androidxcomposeuiunitDp$pageSpacing$0);
        if (z) {
            m7508getMaxWidthimpl = Constraints.m7507getMaxHeightimpl(j) - i8;
        } else {
            m7508getMaxWidthimpl = Constraints.m7508getMaxWidthimpl(j) - i9;
        }
        if (!this.$reverseLayout || m7508getMaxWidthimpl > 0) {
            i4 = i8;
            m7677constructorimpl = IntOffset.m7677constructorimpl((i << 32) | (i5 & 4294967295L));
        } else {
            if (!z) {
                i += m7508getMaxWidthimpl;
            }
            if (z) {
                i5 += m7508getMaxWidthimpl;
            }
            i4 = i8;
            m7677constructorimpl = IntOffset.m7677constructorimpl((i5 & 4294967295L) | (i << 32));
        }
        int coerceAtLeast = RangesKt.coerceAtLeast(this.$pageSize.calculateMainAxisPageSize(lazyLayoutMeasureScope2, m7508getMaxWidthimpl, i12), 0);
        this.$state.m1085setPremeasureConstraintsBRTryo0$foundation(ConstraintsKt.Constraints$default(0, this.$orientation == Orientation.Vertical ? Constraints.m7508getMaxWidthimpl(m7527offsetNN6EwU) : coerceAtLeast, 0, this.$orientation != Orientation.Vertical ? Constraints.m7507getMaxHeightimpl(m7527offsetNN6EwU) : coerceAtLeast, 5, null));
        PagerLazyLayoutItemProvider invoke = this.$itemProviderLambda.invoke();
        int i13 = m7508getMaxWidthimpl + i3 + i11;
        Snapshot.Companion companion = Snapshot.Companion;
        long j2 = m7677constructorimpl;
        PagerState pagerState = this.$state;
        SnapPosition snapPosition = this.$snapPosition;
        Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
        Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
        Snapshot makeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
        try {
            int matchScrollPositionWithKey$foundation = pagerState.matchScrollPositionWithKey$foundation(invoke, pagerState.getCurrentPage());
            int currentPage = pagerState.getCurrentPage();
            float currentPageOffsetFraction = pagerState.getCurrentPageOffsetFraction();
            int pageCount = pagerState.getPageCount();
            int i14 = m7508getMaxWidthimpl;
            int currentPageOffset = PagerKt.currentPageOffset(snapPosition, i13, coerceAtLeast, i12, i3, i11, currentPage, currentPageOffsetFraction, pageCount);
            Unit unit = Unit.INSTANCE;
            companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
            final int i15 = i4;
            PagerMeasureResult m1078measurePager7L1iB3k = PagerMeasureKt.m1078measurePager7L1iB3k(lazyLayoutMeasureScope, this.$pageCount.invoke().intValue(), invoke, i14, i3, i11, i12, matchScrollPositionWithKey$foundation, currentPageOffset, m7527offsetNN6EwU, this.$orientation, this.$verticalAlignment, this.$horizontalAlignment, this.$reverseLayout, j2, coerceAtLeast, this.$beyondViewportPageCount, LazyLayoutBeyondBoundsStateKt.calculateLazyLayoutPinnedIndices(invoke, this.$state.getPinnedPages$foundation(), this.$state.getBeyondBoundsInfo$foundation()), this.$snapPosition, this.$state.m1082getPlacementScopeInvalidatorzYiylxw$foundation(), this.$coroutineScope, lazyLayoutMeasureScope2, new Function3() { // from class: androidx.compose.foundation.pager.PagerMeasurePolicyKt$rememberPagerMeasurePolicy$1$1$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    MeasureResult layout;
                    Function1 function1 = (Function1) obj3;
                    layout = LazyLayoutMeasureScope.this.layout(ConstraintsKt.m7525constrainWidthK40F9xA(r1, ((Integer) obj).intValue() + i9), ConstraintsKt.m7524constrainHeightK40F9xA(j, ((Integer) obj2).intValue() + i15), MapsKt.emptyMap(), function1);
                    return layout;
                }
            }, IntObjectMapKt.mutableIntObjectMapOf());
            PagerState.applyMeasureResult$foundation$default(this.$state, m1078measurePager7L1iB3k, lazyLayoutMeasureScope.isLookingAhead(), false, 4, null);
            PagerMeasurePolicyKt.keepAroundItems(lazyLayoutMeasureScope, this.$state.getCacheWindowLogic$foundation(), m1078measurePager7L1iB3k.getVisiblePagesInfo());
            return m1078measurePager7L1iB3k;
        } catch (Throwable th) {
            companion.restoreNonObservable(currentThreadSnapshot, makeCurrentNonObservable, readObserver);
            throw th;
        }
    }
}
