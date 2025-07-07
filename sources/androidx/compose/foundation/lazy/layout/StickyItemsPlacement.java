package androidx.compose.foundation.lazy.layout;

import androidx.collection.IntList;
import androidx.collection.IntListKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
/* compiled from: LazyLayoutStickyItems.kt */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b`\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013JN\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0003H&J \u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u000fH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0014À\u0006\u0001"}, d2 = {"Landroidx/compose/foundation/lazy/layout/StickyItemsPlacement;", "", "calculateStickingItemOffset", "", "visibleStickyItems", "", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;", "itemIndex", "itemSize", "itemOffset", "beforeContentPadding", "afterContentPadding", "layoutWidth", "layoutHeight", "getStickingIndices", "Landroidx/collection/IntList;", "firstVisibleItemIndex", "lastVisibleItemIndex", "stickyItems", "Companion", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public interface StickyItemsPlacement {
    public static final Companion Companion = Companion.$$INSTANCE;

    int calculateStickingItemOffset(List<? extends LazyLayoutMeasuredItem> list, int i, int i2, int i3, int i4, int i5, int i6, int i7);

    IntList getStickingIndices(int i, int i2, IntList intList);

    /* compiled from: LazyLayoutStickyItems.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/foundation/lazy/layout/StickyItemsPlacement$Companion;", "", "()V", "StickToTopPlacement", "Landroidx/compose/foundation/lazy/layout/StickyItemsPlacement;", "getStickToTopPlacement", "()Landroidx/compose/foundation/lazy/layout/StickyItemsPlacement;", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final StickyItemsPlacement StickToTopPlacement = new StickyItemsPlacement() { // from class: androidx.compose.foundation.lazy.layout.StickyItemsPlacement$Companion$StickToTopPlacement$1
            @Override // androidx.compose.foundation.lazy.layout.StickyItemsPlacement
            public int calculateStickingItemOffset(List<? extends LazyLayoutMeasuredItem> list, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
                LazyLayoutMeasuredItem lazyLayoutMeasuredItem;
                int size = list.size();
                int i8 = 0;
                while (true) {
                    if (i8 >= size) {
                        lazyLayoutMeasuredItem = null;
                        break;
                    }
                    lazyLayoutMeasuredItem = list.get(i8);
                    if (lazyLayoutMeasuredItem.getIndex() != i) {
                        break;
                    }
                    i8++;
                }
                LazyLayoutMeasuredItem lazyLayoutMeasuredItem2 = lazyLayoutMeasuredItem;
                int access$getMainAxisOffset = lazyLayoutMeasuredItem2 != null ? LazyLayoutStickyItemsKt.access$getMainAxisOffset(lazyLayoutMeasuredItem2) : Integer.MIN_VALUE;
                int max = i3 == Integer.MIN_VALUE ? -i4 : Math.max(-i4, i3);
                return access$getMainAxisOffset != Integer.MIN_VALUE ? Math.min(max, access$getMainAxisOffset - i2) : max;
            }

            @Override // androidx.compose.foundation.lazy.layout.StickyItemsPlacement
            public IntList getStickingIndices(int i, int i2, IntList intList) {
                if (i2 - i < 0 || intList._size == 0) {
                    return IntListKt.emptyIntList();
                }
                IntRange until = RangesKt.until(0, intList._size);
                int first = until.getFirst();
                int last = until.getLast();
                int i3 = -1;
                if (first <= last) {
                    while (intList.get(first) <= i) {
                        i3 = intList.get(first);
                        if (first == last) {
                            break;
                        }
                        first++;
                    }
                }
                if (i3 == -1) {
                    return IntListKt.emptyIntList();
                }
                return IntListKt.intListOf(i3);
            }
        };

        private Companion() {
        }

        public final StickyItemsPlacement getStickToTopPlacement() {
            return StickToTopPlacement;
        }
    }
}
