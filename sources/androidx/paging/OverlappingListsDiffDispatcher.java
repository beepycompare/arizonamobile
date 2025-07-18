package androidx.paging;

import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.ListUpdateCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
/* compiled from: PlaceholderPaddedListDiffHelper.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\rB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J8\u0010\u0003\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00050\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f¨\u0006\u000e"}, d2 = {"Landroidx/paging/OverlappingListsDiffDispatcher;", "", "()V", "dispatchDiff", "", ExifInterface.GPS_DIRECTION_TRUE, "oldList", "Landroidx/paging/PlaceholderPaddedList;", "newList", "callback", "Landroidx/recyclerview/widget/ListUpdateCallback;", "diffResult", "Landroidx/paging/PlaceholderPaddedDiffResult;", "PlaceholderUsingUpdateCallback", "paging-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class OverlappingListsDiffDispatcher {
    public static final OverlappingListsDiffDispatcher INSTANCE = new OverlappingListsDiffDispatcher();

    private OverlappingListsDiffDispatcher() {
    }

    public final <T> void dispatchDiff(PlaceholderPaddedList<T> oldList, PlaceholderPaddedList<T> newList, ListUpdateCallback callback, PlaceholderPaddedDiffResult diffResult) {
        Intrinsics.checkNotNullParameter(oldList, "oldList");
        Intrinsics.checkNotNullParameter(newList, "newList");
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(diffResult, "diffResult");
        PlaceholderUsingUpdateCallback placeholderUsingUpdateCallback = new PlaceholderUsingUpdateCallback(oldList, newList, callback);
        diffResult.getDiff().dispatchUpdatesTo(placeholderUsingUpdateCallback);
        placeholderUsingUpdateCallback.fixPlaceholders();
    }

    /* compiled from: PlaceholderPaddedListDiffHelper.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\b\b\u0002\u0018\u0000 \"*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\"B)\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0002\u0010\u0007J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\tH\u0002J\u0018\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\tH\u0002J\u0018\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\tH\u0002J\u0018\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\tH\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\u0006\u0010\u0017\u001a\u00020\u0016J\b\u0010\u0018\u001a\u00020\u0016H\u0002J\"\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0018\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\tH\u0016J\u0018\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\tH\u0016J\u0018\u0010 \u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\tH\u0016J\r\u0010!\u001a\u00020\t*\u00020\tH\u0082\bR\u000e\u0010\u0006\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Landroidx/paging/OverlappingListsDiffDispatcher$PlaceholderUsingUpdateCallback;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/recyclerview/widget/ListUpdateCallback;", "oldList", "Landroidx/paging/PlaceholderPaddedList;", "newList", "callback", "(Landroidx/paging/PlaceholderPaddedList;Landroidx/paging/PlaceholderPaddedList;Landroidx/recyclerview/widget/ListUpdateCallback;)V", "placeholdersAfter", "", "placeholdersAfterState", "placeholdersBefore", "placeholdersBeforeState", "storageCount", "dispatchInsertAsPlaceholderAfter", "", "position", "count", "dispatchInsertAsPlaceholderBefore", "dispatchRemovalAsPlaceholdersAfter", "dispatchRemovalAsPlaceholdersBefore", "fixLeadingPlaceholders", "", "fixPlaceholders", "fixTrailingPlaceholders", "onChanged", "payload", "", "onInserted", "onMoved", "fromPosition", "toPosition", "onRemoved", "offsetForDispatch", "Companion", "paging-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes3.dex */
    private static final class PlaceholderUsingUpdateCallback<T> implements ListUpdateCallback {
        public static final Companion Companion = new Companion(null);
        private static final int UNUSED = 1;
        private static final int USED_FOR_ADDITION = 3;
        private static final int USED_FOR_REMOVAL = 2;
        private final ListUpdateCallback callback;
        private final PlaceholderPaddedList<T> newList;
        private final PlaceholderPaddedList<T> oldList;
        private int placeholdersAfter;
        private int placeholdersAfterState;
        private int placeholdersBefore;
        private int placeholdersBeforeState;
        private int storageCount;

        public PlaceholderUsingUpdateCallback(PlaceholderPaddedList<T> oldList, PlaceholderPaddedList<T> newList, ListUpdateCallback callback) {
            Intrinsics.checkNotNullParameter(oldList, "oldList");
            Intrinsics.checkNotNullParameter(newList, "newList");
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.oldList = oldList;
            this.newList = newList;
            this.callback = callback;
            this.placeholdersBefore = oldList.getPlaceholdersBefore();
            this.placeholdersAfter = oldList.getPlaceholdersAfter();
            this.storageCount = oldList.getDataCount();
            this.placeholdersBeforeState = 1;
            this.placeholdersAfterState = 1;
        }

        private final int offsetForDispatch(int i) {
            return i + this.placeholdersBefore;
        }

        public final void fixPlaceholders() {
            fixLeadingPlaceholders();
            fixTrailingPlaceholders();
        }

        private final void fixTrailingPlaceholders() {
            int min = Math.min(this.oldList.getPlaceholdersAfter(), this.placeholdersAfter);
            int placeholdersAfter = this.newList.getPlaceholdersAfter();
            int i = this.placeholdersAfter;
            int i2 = placeholdersAfter - i;
            int i3 = this.placeholdersBefore + this.storageCount + i;
            int i4 = i3 - min;
            boolean z = i4 != this.oldList.getSize() - min;
            if (i2 > 0) {
                this.callback.onInserted(i3, i2);
            } else if (i2 < 0) {
                this.callback.onRemoved(i3 + i2, -i2);
                min += i2;
            }
            if (min > 0 && z) {
                this.callback.onChanged(i4, min, DiffingChangePayload.PLACEHOLDER_POSITION_CHANGE);
            }
            this.placeholdersAfter = this.newList.getPlaceholdersAfter();
        }

        private final void fixLeadingPlaceholders() {
            int min = Math.min(this.oldList.getPlaceholdersBefore(), this.placeholdersBefore);
            int placeholdersBefore = this.newList.getPlaceholdersBefore() - this.placeholdersBefore;
            if (placeholdersBefore > 0) {
                if (min > 0) {
                    this.callback.onChanged(0, min, DiffingChangePayload.PLACEHOLDER_POSITION_CHANGE);
                }
                this.callback.onInserted(0, placeholdersBefore);
            } else if (placeholdersBefore < 0) {
                this.callback.onRemoved(0, -placeholdersBefore);
                int i = min + placeholdersBefore;
                if (i > 0) {
                    this.callback.onChanged(0, i, DiffingChangePayload.PLACEHOLDER_POSITION_CHANGE);
                }
            }
            this.placeholdersBefore = this.newList.getPlaceholdersBefore();
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onInserted(int i, int i2) {
            if (!dispatchInsertAsPlaceholderAfter(i, i2) && !dispatchInsertAsPlaceholderBefore(i, i2)) {
                this.callback.onInserted(i + this.placeholdersBefore, i2);
            }
            this.storageCount += i2;
        }

        private final boolean dispatchInsertAsPlaceholderBefore(int i, int i2) {
            if (i <= 0 && this.placeholdersBeforeState != 2) {
                int min = Math.min(i2, this.placeholdersBefore);
                if (min > 0) {
                    this.placeholdersBeforeState = 3;
                    this.callback.onChanged((0 - min) + this.placeholdersBefore, min, DiffingChangePayload.PLACEHOLDER_TO_ITEM);
                    this.placeholdersBefore -= min;
                }
                int i3 = i2 - min;
                if (i3 > 0) {
                    this.callback.onInserted(this.placeholdersBefore, i3);
                    return true;
                }
                return true;
            }
            return false;
        }

        private final boolean dispatchInsertAsPlaceholderAfter(int i, int i2) {
            if (i >= this.storageCount && this.placeholdersAfterState != 2) {
                int min = Math.min(i2, this.placeholdersAfter);
                if (min > 0) {
                    this.placeholdersAfterState = 3;
                    this.callback.onChanged(this.placeholdersBefore + i, min, DiffingChangePayload.PLACEHOLDER_TO_ITEM);
                    this.placeholdersAfter -= min;
                }
                int i3 = i2 - min;
                if (i3 > 0) {
                    this.callback.onInserted(i + min + this.placeholdersBefore, i3);
                    return true;
                }
                return true;
            }
            return false;
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onRemoved(int i, int i2) {
            if (!dispatchRemovalAsPlaceholdersAfter(i, i2) && !dispatchRemovalAsPlaceholdersBefore(i, i2)) {
                this.callback.onRemoved(i + this.placeholdersBefore, i2);
            }
            this.storageCount -= i2;
        }

        private final boolean dispatchRemovalAsPlaceholdersBefore(int i, int i2) {
            if (i <= 0 && this.placeholdersBeforeState != 3) {
                int coerceAtLeast = RangesKt.coerceAtLeast(Math.min(this.newList.getPlaceholdersBefore() - this.placeholdersBefore, i2), 0);
                int i3 = i2 - coerceAtLeast;
                if (i3 > 0) {
                    this.callback.onRemoved(this.placeholdersBefore, i3);
                }
                if (coerceAtLeast > 0) {
                    this.placeholdersBeforeState = 2;
                    this.callback.onChanged(this.placeholdersBefore, coerceAtLeast, DiffingChangePayload.ITEM_TO_PLACEHOLDER);
                    this.placeholdersBefore += coerceAtLeast;
                    return true;
                }
                return true;
            }
            return false;
        }

        private final boolean dispatchRemovalAsPlaceholdersAfter(int i, int i2) {
            if (i + i2 >= this.storageCount && this.placeholdersAfterState != 3) {
                int coerceAtLeast = RangesKt.coerceAtLeast(Math.min(this.newList.getPlaceholdersAfter() - this.placeholdersAfter, i2), 0);
                int i3 = i2 - coerceAtLeast;
                if (coerceAtLeast > 0) {
                    this.placeholdersAfterState = 2;
                    this.callback.onChanged(this.placeholdersBefore + i, coerceAtLeast, DiffingChangePayload.ITEM_TO_PLACEHOLDER);
                    this.placeholdersAfter += coerceAtLeast;
                }
                if (i3 > 0) {
                    this.callback.onRemoved(i + coerceAtLeast + this.placeholdersBefore, i3);
                    return true;
                }
                return true;
            }
            return false;
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onMoved(int i, int i2) {
            ListUpdateCallback listUpdateCallback = this.callback;
            int i3 = this.placeholdersBefore;
            listUpdateCallback.onMoved(i + i3, i2 + i3);
        }

        @Override // androidx.recyclerview.widget.ListUpdateCallback
        public void onChanged(int i, int i2, Object obj) {
            this.callback.onChanged(i + this.placeholdersBefore, i2, obj);
        }

        /* compiled from: PlaceholderPaddedListDiffHelper.kt */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Landroidx/paging/OverlappingListsDiffDispatcher$PlaceholderUsingUpdateCallback$Companion;", "", "()V", "UNUSED", "", "USED_FOR_ADDITION", "USED_FOR_REMOVAL", "paging-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }
}
