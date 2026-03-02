package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.gestures.Orientation;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
/* compiled from: LazyGridLayoutInfo.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\b\u001a\u00020\u0001*\u00020\u0002H\u0000\"\u0018\u0010\u0003\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\"\u0018\u0010\u0006\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005¨\u0006\t"}, d2 = {"visibleLinesAverageMainAxisSize", "", "Landroidx/compose/foundation/lazy/grid/LazyGridLayoutInfo;", "singleAxisViewportSize", "getSingleAxisViewportSize", "(Landroidx/compose/foundation/lazy/grid/LazyGridLayoutInfo;)I", "firstVisibleItemLineIndex", "getFirstVisibleItemLineIndex", "calculateContentSize", "foundation"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LazyGridLayoutInfoKt {
    public static final int visibleLinesAverageMainAxisSize(LazyGridLayoutInfo lazyGridLayoutInfo) {
        long mo952getSizeYbymL2g;
        boolean z = lazyGridLayoutInfo.getOrientation() == Orientation.Vertical;
        List<LazyGridItemInfo> visibleItemsInfo = lazyGridLayoutInfo.getVisibleItemsInfo();
        if (visibleItemsInfo.isEmpty()) {
            return 0;
        }
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < visibleItemsInfo.size()) {
            int visibleLinesAverageMainAxisSize$lineOf = visibleLinesAverageMainAxisSize$lineOf(z, lazyGridLayoutInfo, i);
            if (visibleLinesAverageMainAxisSize$lineOf == -1) {
                i++;
            } else {
                int i4 = 0;
                while (i < visibleItemsInfo.size() && visibleLinesAverageMainAxisSize$lineOf(z, lazyGridLayoutInfo, i) == visibleLinesAverageMainAxisSize$lineOf) {
                    if (z) {
                        mo952getSizeYbymL2g = visibleItemsInfo.get(i).mo952getSizeYbymL2g() & 4294967295L;
                    } else {
                        mo952getSizeYbymL2g = visibleItemsInfo.get(i).mo952getSizeYbymL2g() >> 32;
                    }
                    i4 = Math.max(i4, (int) mo952getSizeYbymL2g);
                    i++;
                }
                i2 += i4;
                i3++;
            }
        }
        return (i2 / i3) + lazyGridLayoutInfo.getMainAxisItemSpacing();
    }

    private static final int visibleLinesAverageMainAxisSize$lineOf(boolean z, LazyGridLayoutInfo lazyGridLayoutInfo, int i) {
        return z ? lazyGridLayoutInfo.getVisibleItemsInfo().get(i).getRow() : lazyGridLayoutInfo.getVisibleItemsInfo().get(i).getColumn();
    }

    public static final int getSingleAxisViewportSize(LazyGridLayoutInfo lazyGridLayoutInfo) {
        return (int) (lazyGridLayoutInfo.getOrientation() == Orientation.Vertical ? lazyGridLayoutInfo.mo956getViewportSizeYbymL2g() & 4294967295L : lazyGridLayoutInfo.mo956getViewportSizeYbymL2g() >> 32);
    }

    public static final int getFirstVisibleItemLineIndex(LazyGridLayoutInfo lazyGridLayoutInfo) {
        List<LazyGridItemInfo> visibleItemsInfo = lazyGridLayoutInfo.getVisibleItemsInfo();
        if (visibleItemsInfo.isEmpty()) {
            return 0;
        }
        if (lazyGridLayoutInfo.getOrientation() == Orientation.Vertical) {
            return ((LazyGridItemInfo) CollectionsKt.first((List<? extends Object>) visibleItemsInfo)).getRow();
        }
        return ((LazyGridItemInfo) CollectionsKt.first((List<? extends Object>) visibleItemsInfo)).getColumn();
    }

    public static final int calculateContentSize(LazyGridLayoutInfo lazyGridLayoutInfo) {
        int beforeContentPadding = lazyGridLayoutInfo.getBeforeContentPadding() + lazyGridLayoutInfo.getAfterContentPadding();
        if (lazyGridLayoutInfo.getTotalItemsCount() == 0) {
            return beforeContentPadding;
        }
        int ceil = (int) Math.ceil(lazyGridLayoutInfo.getTotalItemsCount() / lazyGridLayoutInfo.getMaxSpan());
        return ((visibleLinesAverageMainAxisSize(lazyGridLayoutInfo) - lazyGridLayoutInfo.getMainAxisItemSpacing()) * ceil) + ((ceil - 1) * lazyGridLayoutInfo.getMainAxisItemSpacing()) + beforeContentPadding;
    }
}
