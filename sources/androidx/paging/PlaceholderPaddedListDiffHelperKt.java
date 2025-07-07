package androidx.paging;

import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListUpdateCallback;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedRange;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
/* compiled from: PlaceholderPaddedListDiffHelper.kt */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u001a8\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007H\u0000\u001a:\u0010\b\u001a\u00020\t\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\f\u001a\u00020\u0001H\u0000\u001a,\u0010\r\u001a\u00020\u000e*\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\f\u001a\u00020\u00012\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0000¨\u0006\u0010"}, d2 = {"computeDiff", "Landroidx/paging/PlaceholderPaddedDiffResult;", ExifInterface.GPS_DIRECTION_TRUE, "", "Landroidx/paging/PlaceholderPaddedList;", "newList", "diffCallback", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "dispatchDiff", "", "callback", "Landroidx/recyclerview/widget/ListUpdateCallback;", "diffResult", "transformAnchorIndex", "", "oldPosition", "paging-runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PlaceholderPaddedListDiffHelperKt {
    public static final <T> PlaceholderPaddedDiffResult computeDiff(final PlaceholderPaddedList<T> placeholderPaddedList, final PlaceholderPaddedList<T> newList, final DiffUtil.ItemCallback<T> diffCallback) {
        Intrinsics.checkNotNullParameter(placeholderPaddedList, "<this>");
        Intrinsics.checkNotNullParameter(newList, "newList");
        Intrinsics.checkNotNullParameter(diffCallback, "diffCallback");
        final int dataCount = placeholderPaddedList.getDataCount();
        final int dataCount2 = newList.getDataCount();
        boolean z = true;
        DiffUtil.DiffResult calculateDiff = DiffUtil.calculateDiff(new DiffUtil.Callback() { // from class: androidx.paging.PlaceholderPaddedListDiffHelperKt$computeDiff$diffResult$1
            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public Object getChangePayload(int i, int i2) {
                Object item = placeholderPaddedList.getItem(i);
                Object item2 = newList.getItem(i2);
                if (item == item2) {
                    return true;
                }
                return diffCallback.getChangePayload(item, item2);
            }

            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public int getOldListSize() {
                return dataCount;
            }

            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public int getNewListSize() {
                return dataCount2;
            }

            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public boolean areItemsTheSame(int i, int i2) {
                Object item = placeholderPaddedList.getItem(i);
                Object item2 = newList.getItem(i2);
                if (item == item2) {
                    return true;
                }
                return diffCallback.areItemsTheSame(item, item2);
            }

            @Override // androidx.recyclerview.widget.DiffUtil.Callback
            public boolean areContentsTheSame(int i, int i2) {
                Object item = placeholderPaddedList.getItem(i);
                Object item2 = newList.getItem(i2);
                if (item == item2) {
                    return true;
                }
                return diffCallback.areContentsTheSame(item, item2);
            }
        }, true);
        Intrinsics.checkNotNullExpressionValue(calculateDiff, "PlaceholderPaddedList<T>…    },\n        true\n    )");
        IntRange until = RangesKt.until(0, placeholderPaddedList.getDataCount());
        if (!(until instanceof Collection) || !((Collection) until).isEmpty()) {
            Iterator<Integer> it = until.iterator();
            while (it.hasNext()) {
                if (calculateDiff.convertOldPositionToNew(((IntIterator) it).nextInt()) != -1) {
                    break;
                }
            }
        }
        z = false;
        return new PlaceholderPaddedDiffResult(calculateDiff, z);
    }

    public static final <T> void dispatchDiff(PlaceholderPaddedList<T> placeholderPaddedList, ListUpdateCallback callback, PlaceholderPaddedList<T> newList, PlaceholderPaddedDiffResult diffResult) {
        Intrinsics.checkNotNullParameter(placeholderPaddedList, "<this>");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(newList, "newList");
        Intrinsics.checkNotNullParameter(diffResult, "diffResult");
        if (diffResult.getHasOverlap()) {
            OverlappingListsDiffDispatcher.INSTANCE.dispatchDiff(placeholderPaddedList, newList, callback, diffResult);
        } else {
            DistinctListsDiffDispatcher.INSTANCE.dispatchDiff(callback, placeholderPaddedList, newList);
        }
    }

    public static final int transformAnchorIndex(PlaceholderPaddedList<?> placeholderPaddedList, PlaceholderPaddedDiffResult diffResult, PlaceholderPaddedList<?> newList, int i) {
        int convertOldPositionToNew;
        Intrinsics.checkNotNullParameter(placeholderPaddedList, "<this>");
        Intrinsics.checkNotNullParameter(diffResult, "diffResult");
        Intrinsics.checkNotNullParameter(newList, "newList");
        if (!diffResult.getHasOverlap()) {
            return RangesKt.coerceIn(i, (ClosedRange<Integer>) RangesKt.until(0, newList.getSize()));
        }
        int placeholdersBefore = i - placeholderPaddedList.getPlaceholdersBefore();
        int dataCount = placeholderPaddedList.getDataCount();
        if (placeholdersBefore >= 0 && placeholdersBefore < dataCount) {
            for (int i2 = 0; i2 < 30; i2++) {
                int i3 = ((i2 / 2) * (i2 % 2 == 1 ? -1 : 1)) + placeholdersBefore;
                if (i3 >= 0 && i3 < placeholderPaddedList.getDataCount() && (convertOldPositionToNew = diffResult.getDiff().convertOldPositionToNew(i3)) != -1) {
                    return convertOldPositionToNew + newList.getPlaceholdersBefore();
                }
            }
        }
        return RangesKt.coerceIn(i, (ClosedRange<Integer>) RangesKt.until(0, newList.getSize()));
    }
}
