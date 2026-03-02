package androidx.compose.foundation.lazy;

import androidx.compose.foundation.gestures.Orientation;
import java.util.List;
import kotlin.Metadata;
/* compiled from: LazyListLayoutInfo.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0003\u001a\u00020\u0001*\u00020\u0002H\u0000\"\u0018\u0010\u0004\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"visibleItemsAverageSize", "", "Landroidx/compose/foundation/lazy/LazyListLayoutInfo;", "calculateContentSize", "singleAxisViewportSize", "getSingleAxisViewportSize", "(Landroidx/compose/foundation/lazy/LazyListLayoutInfo;)I", "foundation"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LazyListLayoutInfoKt {
    public static final int visibleItemsAverageSize(LazyListLayoutInfo lazyListLayoutInfo) {
        List<LazyListItemInfo> visibleItemsInfo = lazyListLayoutInfo.getVisibleItemsInfo();
        if (visibleItemsInfo.isEmpty()) {
            return 0;
        }
        int size = visibleItemsInfo.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i += visibleItemsInfo.get(i2).getSize();
        }
        return (i / visibleItemsInfo.size()) + lazyListLayoutInfo.getMainAxisItemSpacing();
    }

    public static final int calculateContentSize(LazyListLayoutInfo lazyListLayoutInfo) {
        int beforeContentPadding = lazyListLayoutInfo.getBeforeContentPadding() + lazyListLayoutInfo.getAfterContentPadding();
        return lazyListLayoutInfo.getTotalItemsCount() == 0 ? beforeContentPadding : ((visibleItemsAverageSize(lazyListLayoutInfo) - lazyListLayoutInfo.getMainAxisItemSpacing()) * lazyListLayoutInfo.getTotalItemsCount()) + ((lazyListLayoutInfo.getTotalItemsCount() - 1) * lazyListLayoutInfo.getMainAxisItemSpacing()) + beforeContentPadding;
    }

    public static final int getSingleAxisViewportSize(LazyListLayoutInfo lazyListLayoutInfo) {
        long mo923getViewportSizeYbymL2g;
        if (lazyListLayoutInfo.getOrientation() == Orientation.Vertical) {
            mo923getViewportSizeYbymL2g = lazyListLayoutInfo.mo923getViewportSizeYbymL2g() & 4294967295L;
        } else {
            mo923getViewportSizeYbymL2g = lazyListLayoutInfo.mo923getViewportSizeYbymL2g() >> 32;
        }
        return (int) mo923getViewportSizeYbymL2g;
    }
}
