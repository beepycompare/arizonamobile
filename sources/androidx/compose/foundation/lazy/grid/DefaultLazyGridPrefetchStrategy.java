package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.snapping.LazyGridSnapLayoutInfoProviderKt;
import androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState;
import androidx.compose.foundation.lazy.layout.NestedPrefetchScope;
import androidx.compose.runtime.collection.MutableVector;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: LazyGridPrefetchStrategy.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010\u000b\u001a\u00020\f*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0003H\u0016J\u001c\u0010\u000f\u001a\u00020\f*\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0014\u0010\u0015\u001a\u00020\f*\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Landroidx/compose/foundation/lazy/grid/DefaultLazyGridPrefetchStrategy;", "Landroidx/compose/foundation/lazy/grid/LazyGridPrefetchStrategy;", "nestedPrefetchItemCount", "", "(I)V", "currentLinePrefetchHandles", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutPrefetchState$PrefetchHandle;", "lineToPrefetch", "wasScrollingForward", "", "onNestedPrefetch", "", "Landroidx/compose/foundation/lazy/layout/NestedPrefetchScope;", "firstVisibleItemIndex", "onScroll", "Landroidx/compose/foundation/lazy/grid/LazyGridPrefetchScope;", "delta", "", "layoutInfo", "Landroidx/compose/foundation/lazy/grid/LazyGridLayoutInfo;", "onVisibleItemsUpdated", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
final class DefaultLazyGridPrefetchStrategy implements LazyGridPrefetchStrategy {
    private final MutableVector<LazyLayoutPrefetchState.PrefetchHandle> currentLinePrefetchHandles;
    private int lineToPrefetch;
    private final int nestedPrefetchItemCount;
    private boolean wasScrollingForward;

    public DefaultLazyGridPrefetchStrategy() {
        this(0, 1, null);
    }

    public DefaultLazyGridPrefetchStrategy(int i) {
        this.nestedPrefetchItemCount = i;
        this.lineToPrefetch = -1;
        this.currentLinePrefetchHandles = new MutableVector<>(new LazyLayoutPrefetchState.PrefetchHandle[16], 0);
    }

    public /* synthetic */ DefaultLazyGridPrefetchStrategy(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 2 : i);
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridPrefetchStrategy
    public void onScroll(LazyGridPrefetchScope lazyGridPrefetchScope, float f, LazyGridLayoutInfo lazyGridLayoutInfo) {
        int row;
        int index;
        if (lazyGridLayoutInfo.getVisibleItemsInfo().isEmpty()) {
            return;
        }
        int i = 0;
        boolean z = f < 0.0f;
        if (z) {
            LazyGridItemInfo lazyGridItemInfo = (LazyGridItemInfo) CollectionsKt.last((List<? extends Object>) lazyGridLayoutInfo.getVisibleItemsInfo());
            row = (lazyGridLayoutInfo.getOrientation() == Orientation.Vertical ? lazyGridItemInfo.getRow() : lazyGridItemInfo.getColumn()) + 1;
            index = ((LazyGridItemInfo) CollectionsKt.last((List<? extends Object>) lazyGridLayoutInfo.getVisibleItemsInfo())).getIndex() + 1;
        } else {
            LazyGridItemInfo lazyGridItemInfo2 = (LazyGridItemInfo) CollectionsKt.first((List<? extends Object>) lazyGridLayoutInfo.getVisibleItemsInfo());
            row = (lazyGridLayoutInfo.getOrientation() == Orientation.Vertical ? lazyGridItemInfo2.getRow() : lazyGridItemInfo2.getColumn()) - 1;
            index = ((LazyGridItemInfo) CollectionsKt.first((List<? extends Object>) lazyGridLayoutInfo.getVisibleItemsInfo())).getIndex() - 1;
        }
        if (index < 0 || index >= lazyGridLayoutInfo.getTotalItemsCount()) {
            return;
        }
        if (row != this.lineToPrefetch && row >= 0) {
            if (this.wasScrollingForward != z) {
                MutableVector<LazyLayoutPrefetchState.PrefetchHandle> mutableVector = this.currentLinePrefetchHandles;
                LazyLayoutPrefetchState.PrefetchHandle[] prefetchHandleArr = mutableVector.content;
                int size = mutableVector.getSize();
                for (int i2 = 0; i2 < size; i2++) {
                    prefetchHandleArr[i2].cancel();
                }
            }
            this.wasScrollingForward = z;
            this.lineToPrefetch = row;
            this.currentLinePrefetchHandles.clear();
            MutableVector<LazyLayoutPrefetchState.PrefetchHandle> mutableVector2 = this.currentLinePrefetchHandles;
            mutableVector2.addAll(mutableVector2.getSize(), (List<? extends LazyLayoutPrefetchState.PrefetchHandle>) lazyGridPrefetchScope.scheduleLinePrefetch(row));
        }
        if (z) {
            LazyGridItemInfo lazyGridItemInfo3 = (LazyGridItemInfo) CollectionsKt.last((List<? extends Object>) lazyGridLayoutInfo.getVisibleItemsInfo());
            if (((LazyGridSnapLayoutInfoProviderKt.offsetOnMainAxis(lazyGridItemInfo3, lazyGridLayoutInfo.getOrientation()) + LazyGridSnapLayoutInfoProviderKt.sizeOnMainAxis(lazyGridItemInfo3, lazyGridLayoutInfo.getOrientation())) + lazyGridLayoutInfo.getMainAxisItemSpacing()) - lazyGridLayoutInfo.getViewportEndOffset() < (-f)) {
                MutableVector<LazyLayoutPrefetchState.PrefetchHandle> mutableVector3 = this.currentLinePrefetchHandles;
                LazyLayoutPrefetchState.PrefetchHandle[] prefetchHandleArr2 = mutableVector3.content;
                int size2 = mutableVector3.getSize();
                while (i < size2) {
                    prefetchHandleArr2[i].markAsUrgent();
                    i++;
                }
            }
        } else if (lazyGridLayoutInfo.getViewportStartOffset() - LazyGridSnapLayoutInfoProviderKt.offsetOnMainAxis((LazyGridItemInfo) CollectionsKt.first((List<? extends Object>) lazyGridLayoutInfo.getVisibleItemsInfo()), lazyGridLayoutInfo.getOrientation()) < f) {
            MutableVector<LazyLayoutPrefetchState.PrefetchHandle> mutableVector4 = this.currentLinePrefetchHandles;
            LazyLayoutPrefetchState.PrefetchHandle[] prefetchHandleArr3 = mutableVector4.content;
            int size3 = mutableVector4.getSize();
            while (i < size3) {
                prefetchHandleArr3[i].markAsUrgent();
                i++;
            }
        }
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridPrefetchStrategy
    public void onVisibleItemsUpdated(LazyGridPrefetchScope lazyGridPrefetchScope, LazyGridLayoutInfo lazyGridLayoutInfo) {
        int row;
        if (this.lineToPrefetch == -1 || lazyGridLayoutInfo.getVisibleItemsInfo().isEmpty()) {
            return;
        }
        if (this.wasScrollingForward) {
            LazyGridItemInfo lazyGridItemInfo = (LazyGridItemInfo) CollectionsKt.last((List<? extends Object>) lazyGridLayoutInfo.getVisibleItemsInfo());
            row = (lazyGridLayoutInfo.getOrientation() == Orientation.Vertical ? lazyGridItemInfo.getRow() : lazyGridItemInfo.getColumn()) + 1;
        } else {
            LazyGridItemInfo lazyGridItemInfo2 = (LazyGridItemInfo) CollectionsKt.first((List<? extends Object>) lazyGridLayoutInfo.getVisibleItemsInfo());
            row = (lazyGridLayoutInfo.getOrientation() == Orientation.Vertical ? lazyGridItemInfo2.getRow() : lazyGridItemInfo2.getColumn()) - 1;
        }
        if (this.lineToPrefetch != row) {
            this.lineToPrefetch = -1;
            MutableVector<LazyLayoutPrefetchState.PrefetchHandle> mutableVector = this.currentLinePrefetchHandles;
            LazyLayoutPrefetchState.PrefetchHandle[] prefetchHandleArr = mutableVector.content;
            int size = mutableVector.getSize();
            for (int i = 0; i < size; i++) {
                prefetchHandleArr[i].cancel();
            }
            this.currentLinePrefetchHandles.clear();
        }
    }

    @Override // androidx.compose.foundation.lazy.grid.LazyGridPrefetchStrategy
    public void onNestedPrefetch(NestedPrefetchScope nestedPrefetchScope, int i) {
        int i2 = this.nestedPrefetchItemCount;
        for (int i3 = 0; i3 < i2; i3++) {
            nestedPrefetchScope.schedulePrefetch(i + i3);
        }
    }
}
