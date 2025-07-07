package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.gestures.Orientation;
import java.util.List;
import kotlin.Metadata;
/* compiled from: LazyGridLayoutInfo.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"visibleLinesAverageMainAxisSize", "", "Landroidx/compose/foundation/lazy/grid/LazyGridLayoutInfo;", "foundation_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LazyGridLayoutInfoKt {
    public static final int visibleLinesAverageMainAxisSize(LazyGridLayoutInfo lazyGridLayoutInfo) {
        long mo878getSizeYbymL2g;
        boolean z = lazyGridLayoutInfo.getOrientation() == Orientation.Vertical;
        List<LazyGridItemInfo> visibleItemsInfo = lazyGridLayoutInfo.getVisibleItemsInfo();
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
                        mo878getSizeYbymL2g = visibleItemsInfo.get(i).mo878getSizeYbymL2g() & 4294967295L;
                    } else {
                        mo878getSizeYbymL2g = visibleItemsInfo.get(i).mo878getSizeYbymL2g() >> 32;
                    }
                    i4 = Math.max(i4, (int) mo878getSizeYbymL2g);
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
}
