package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.layout.Placeable;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;
/* compiled from: LazyStaggeredGridMeasure.kt */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B\u009d\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0006\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0006\u0012\u0006\u0010\u0015\u001a\u00020\u0006\u0012\u0006\u0010\u0016\u001a\u00020\u000e\u0012\u0006\u0010\u0017\u001a\u00020\u0006\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0006\u0010\u001a\u001a\u00020\u000e\u0012\u0006\u0010\u001b\u001a\u00020\u000e\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d\u0012\u0006\u0010\u001e\u001a\u00020\u001f¢\u0006\u0002\u0010 J'\u0010L\u001a\u00020G*\u00020\b2\u0006\u0010M\u001a\u00020\u00062\u0006\u0010N\u001a\u00020\u0006ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bO\u0010PJ\u0012\u0010F\u001a\u00020\u000e*\u00020\b2\u0006\u0010M\u001a\u00020\u0006R\u0011\u0010\u0015\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u001d¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u0014\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\"R\u0019\u0010\u000b\u001a\u00020\fø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010(\u001a\u0004\b&\u0010'R\u0019\u0010\u0012\u001a\u00020\u0013ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010(\u001a\u0004\b)\u0010'R\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010\u001e\u001a\u00020\u001f¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010\u001a\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010.R\u0011\u0010\u001b\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010.R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010.R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0011\u00101\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\"R\u0011\u00103\u001a\u000204¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0011\u0010\u0011\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b7\u0010\"R\u0011\u0010\u0017\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b8\u0010\"R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u0011\u0010;\u001a\u00020<¢\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\bA\u0010BR\u0011\u0010\u0016\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bC\u0010.R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bD\u0010ER\u0016\u0010F\u001a\u00020\u000e*\u00020G8Æ\u0002¢\u0006\u0006\u001a\u0004\bH\u0010IR\u0016\u00103\u001a\u00020\u0006*\u00020G8Æ\u0002¢\u0006\u0006\u001a\u0004\bJ\u0010K\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006Q"}, d2 = {"Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureContext;", "", RemoteConfigConstants.ResponseFieldKey.STATE, "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "pinnedItems", "", "", "itemProvider", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemProvider;", "resolvedSlots", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSlots;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "isVertical", "", "measureScope", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "mainAxisAvailableSize", "contentOffset", "Landroidx/compose/ui/unit/IntOffset;", "beforeContentPadding", "afterContentPadding", "reverseLayout", "mainAxisSpacing", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "isInLookaheadScope", "isLookingAhead", "approachLayoutInfo", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridLayoutInfo;", "graphicsContext", "Landroidx/compose/ui/graphics/GraphicsContext;", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;Ljava/util/List;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemProvider;Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSlots;JZLandroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;IJIIZILkotlinx/coroutines/CoroutineScope;ZZLandroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridLayoutInfo;Landroidx/compose/ui/graphics/GraphicsContext;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAfterContentPadding", "()I", "getApproachLayoutInfo", "()Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridLayoutInfo;", "getBeforeContentPadding", "getConstraints-msEJaDk", "()J", "J", "getContentOffset-nOcc-ac", "getCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "getGraphicsContext", "()Landroidx/compose/ui/graphics/GraphicsContext;", "()Z", "getItemProvider", "()Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemProvider;", "laneCount", "getLaneCount", "laneInfo", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridLaneInfo;", "getLaneInfo", "()Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridLaneInfo;", "getMainAxisAvailableSize", "getMainAxisSpacing", "getMeasureScope", "()Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "measuredItemProvider", "Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureProvider;", "getMeasuredItemProvider", "()Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridMeasureProvider;", "getPinnedItems", "()Ljava/util/List;", "getResolvedSlots", "()Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridSlots;", "getReverseLayout", "getState", "()Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState;", "isFullSpan", "Landroidx/compose/foundation/lazy/staggeredgrid/SpanRange;", "isFullSpan-SZVOQXA", "(J)Z", "getLaneInfo-SZVOQXA", "(J)I", "getSpanRange", "itemIndex", "lane", "getSpanRange-lOCCd4c", "(Landroidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridItemProvider;II)J", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LazyStaggeredGridMeasureContext {
    public static final int $stable = 8;
    private final int afterContentPadding;
    private final LazyStaggeredGridLayoutInfo approachLayoutInfo;
    private final int beforeContentPadding;
    private final long constraints;
    private final long contentOffset;
    private final CoroutineScope coroutineScope;
    private final GraphicsContext graphicsContext;
    private final boolean isInLookaheadScope;
    private final boolean isLookingAhead;
    private final boolean isVertical;
    private final LazyStaggeredGridItemProvider itemProvider;
    private final int laneCount;
    private final LazyStaggeredGridLaneInfo laneInfo;
    private final int mainAxisAvailableSize;
    private final int mainAxisSpacing;
    private final LazyLayoutMeasureScope measureScope;
    private final LazyStaggeredGridMeasureProvider measuredItemProvider;
    private final List<Integer> pinnedItems;
    private final LazyStaggeredGridSlots resolvedSlots;
    private final boolean reverseLayout;
    private final LazyStaggeredGridState state;

    public /* synthetic */ LazyStaggeredGridMeasureContext(LazyStaggeredGridState lazyStaggeredGridState, List list, LazyStaggeredGridItemProvider lazyStaggeredGridItemProvider, LazyStaggeredGridSlots lazyStaggeredGridSlots, long j, boolean z, LazyLayoutMeasureScope lazyLayoutMeasureScope, int i, long j2, int i2, int i3, boolean z2, int i4, CoroutineScope coroutineScope, boolean z3, boolean z4, LazyStaggeredGridLayoutInfo lazyStaggeredGridLayoutInfo, GraphicsContext graphicsContext, DefaultConstructorMarker defaultConstructorMarker) {
        this(lazyStaggeredGridState, list, lazyStaggeredGridItemProvider, lazyStaggeredGridSlots, j, z, lazyLayoutMeasureScope, i, j2, i2, i3, z2, i4, coroutineScope, z3, z4, lazyStaggeredGridLayoutInfo, graphicsContext);
    }

    /* renamed from: getLaneInfo-SZVOQXA  reason: not valid java name */
    public final int m951getLaneInfoSZVOQXA(long j) {
        int i = (int) (j >> 32);
        if (((int) (4294967295L & j)) - i != 1) {
            return -2;
        }
        return i;
    }

    /* renamed from: isFullSpan-SZVOQXA  reason: not valid java name */
    public final boolean m953isFullSpanSZVOQXA(long j) {
        return ((int) (4294967295L & j)) - ((int) (j >> 32)) != 1;
    }

    private LazyStaggeredGridMeasureContext(LazyStaggeredGridState lazyStaggeredGridState, List<Integer> list, final LazyStaggeredGridItemProvider lazyStaggeredGridItemProvider, final LazyStaggeredGridSlots lazyStaggeredGridSlots, long j, final boolean z, final LazyLayoutMeasureScope lazyLayoutMeasureScope, int i, long j2, int i2, int i3, boolean z2, int i4, CoroutineScope coroutineScope, boolean z3, boolean z4, LazyStaggeredGridLayoutInfo lazyStaggeredGridLayoutInfo, GraphicsContext graphicsContext) {
        this.state = lazyStaggeredGridState;
        this.pinnedItems = list;
        this.itemProvider = lazyStaggeredGridItemProvider;
        this.resolvedSlots = lazyStaggeredGridSlots;
        this.constraints = j;
        this.isVertical = z;
        this.measureScope = lazyLayoutMeasureScope;
        this.mainAxisAvailableSize = i;
        this.contentOffset = j2;
        this.beforeContentPadding = i2;
        this.afterContentPadding = i3;
        this.reverseLayout = z2;
        this.mainAxisSpacing = i4;
        this.coroutineScope = coroutineScope;
        this.isInLookaheadScope = z3;
        this.isLookingAhead = z4;
        this.approachLayoutInfo = lazyStaggeredGridLayoutInfo;
        this.graphicsContext = graphicsContext;
        this.measuredItemProvider = new LazyStaggeredGridMeasureProvider(z, lazyStaggeredGridItemProvider, lazyLayoutMeasureScope, lazyStaggeredGridSlots) { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureContext$measuredItemProvider$1
            @Override // androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridMeasureProvider
            /* renamed from: createItem-pitSLOA  reason: not valid java name */
            public LazyStaggeredGridMeasuredItem mo954createItempitSLOA(int i5, int i6, int i7, Object obj, Object obj2, List<? extends Placeable> list2, long j3) {
                return new LazyStaggeredGridMeasuredItem(i5, obj, list2, LazyStaggeredGridMeasureContext.this.isVertical(), LazyStaggeredGridMeasureContext.this.getMainAxisSpacing(), i6, i7, LazyStaggeredGridMeasureContext.this.getBeforeContentPadding(), LazyStaggeredGridMeasureContext.this.getAfterContentPadding(), obj2, LazyStaggeredGridMeasureContext.this.getState().getItemAnimator$foundation_release(), j3, null);
            }
        };
        this.laneInfo = lazyStaggeredGridState.getLaneInfo$foundation_release();
        this.laneCount = lazyStaggeredGridSlots.getSizes().length;
    }

    public final LazyStaggeredGridState getState() {
        return this.state;
    }

    public final List<Integer> getPinnedItems() {
        return this.pinnedItems;
    }

    public final LazyStaggeredGridItemProvider getItemProvider() {
        return this.itemProvider;
    }

    public final LazyStaggeredGridSlots getResolvedSlots() {
        return this.resolvedSlots;
    }

    /* renamed from: getConstraints-msEJaDk  reason: not valid java name */
    public final long m949getConstraintsmsEJaDk() {
        return this.constraints;
    }

    public final boolean isVertical() {
        return this.isVertical;
    }

    public final LazyLayoutMeasureScope getMeasureScope() {
        return this.measureScope;
    }

    public final int getMainAxisAvailableSize() {
        return this.mainAxisAvailableSize;
    }

    /* renamed from: getContentOffset-nOcc-ac  reason: not valid java name */
    public final long m950getContentOffsetnOccac() {
        return this.contentOffset;
    }

    public final int getBeforeContentPadding() {
        return this.beforeContentPadding;
    }

    public final int getAfterContentPadding() {
        return this.afterContentPadding;
    }

    public final boolean getReverseLayout() {
        return this.reverseLayout;
    }

    public final int getMainAxisSpacing() {
        return this.mainAxisSpacing;
    }

    public final CoroutineScope getCoroutineScope() {
        return this.coroutineScope;
    }

    public final boolean isInLookaheadScope() {
        return this.isInLookaheadScope;
    }

    public final boolean isLookingAhead() {
        return this.isLookingAhead;
    }

    public final LazyStaggeredGridLayoutInfo getApproachLayoutInfo() {
        return this.approachLayoutInfo;
    }

    public final GraphicsContext getGraphicsContext() {
        return this.graphicsContext;
    }

    public final LazyStaggeredGridMeasureProvider getMeasuredItemProvider() {
        return this.measuredItemProvider;
    }

    public final LazyStaggeredGridLaneInfo getLaneInfo() {
        return this.laneInfo;
    }

    public final int getLaneCount() {
        return this.laneCount;
    }

    public final boolean isFullSpan(LazyStaggeredGridItemProvider lazyStaggeredGridItemProvider, int i) {
        return lazyStaggeredGridItemProvider.getSpanProvider().isFullSpan(i);
    }

    /* renamed from: getSpanRange-lOCCd4c  reason: not valid java name */
    public final long m952getSpanRangelOCCd4c(LazyStaggeredGridItemProvider lazyStaggeredGridItemProvider, int i, int i2) {
        boolean isFullSpan = lazyStaggeredGridItemProvider.getSpanProvider().isFullSpan(i);
        int i3 = isFullSpan ? this.laneCount : 1;
        if (isFullSpan) {
            i2 = 0;
        }
        return SpanRange.m967constructorimpl(i2, i3);
    }
}
