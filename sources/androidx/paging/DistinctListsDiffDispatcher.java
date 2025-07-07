package androidx.paging;

import androidx.exifinterface.media.ExifInterface;
import androidx.media3.extractor.text.ttml.TtmlNode;
import androidx.recyclerview.widget.ListUpdateCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
/* compiled from: PlaceholderPaddedListDiffHelper.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J8\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0001H\u0002J4\u0010\r\u001a\u00020\u0004\"\b\b\u0000\u0010\u000e*\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u0010¨\u0006\u0012"}, d2 = {"Landroidx/paging/DistinctListsDiffDispatcher;", "", "()V", "dispatchChange", "", "callback", "Landroidx/recyclerview/widget/ListUpdateCallback;", "startBoundary", "", "endBoundary", TtmlNode.START, TtmlNode.END, "payload", "dispatchDiff", ExifInterface.GPS_DIRECTION_TRUE, "oldList", "Landroidx/paging/PlaceholderPaddedList;", "newList", "paging-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class DistinctListsDiffDispatcher {
    public static final DistinctListsDiffDispatcher INSTANCE = new DistinctListsDiffDispatcher();

    private DistinctListsDiffDispatcher() {
    }

    public final <T> void dispatchDiff(ListUpdateCallback callback, PlaceholderPaddedList<T> oldList, PlaceholderPaddedList<T> newList) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(oldList, "oldList");
        Intrinsics.checkNotNullParameter(newList, "newList");
        int max = Math.max(oldList.getPlaceholdersBefore(), newList.getPlaceholdersBefore());
        int min = Math.min(oldList.getPlaceholdersBefore() + oldList.getDataCount(), newList.getPlaceholdersBefore() + newList.getDataCount());
        int i = min - max;
        if (i > 0) {
            callback.onRemoved(max, i);
            callback.onInserted(max, i);
        }
        int min2 = Math.min(max, min);
        int max2 = Math.max(max, min);
        dispatchChange(callback, min2, max2, RangesKt.coerceAtMost(oldList.getPlaceholdersBefore(), newList.getSize()), RangesKt.coerceAtMost(oldList.getPlaceholdersBefore() + oldList.getDataCount(), newList.getSize()), DiffingChangePayload.ITEM_TO_PLACEHOLDER);
        dispatchChange(callback, min2, max2, RangesKt.coerceAtMost(newList.getPlaceholdersBefore(), oldList.getSize()), RangesKt.coerceAtMost(newList.getPlaceholdersBefore() + newList.getDataCount(), oldList.getSize()), DiffingChangePayload.PLACEHOLDER_TO_ITEM);
        int size = newList.getSize() - oldList.getSize();
        if (size > 0) {
            callback.onInserted(oldList.getSize(), size);
        } else if (size < 0) {
            callback.onRemoved(oldList.getSize() + size, -size);
        }
    }

    private final void dispatchChange(ListUpdateCallback listUpdateCallback, int i, int i2, int i3, int i4, Object obj) {
        int i5 = i - i3;
        if (i5 > 0) {
            listUpdateCallback.onChanged(i3, i5, obj);
        }
        int i6 = i4 - i2;
        if (i6 > 0) {
            listUpdateCallback.onChanged(i2, i6, obj);
        }
    }
}
