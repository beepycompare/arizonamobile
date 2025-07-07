package androidx.compose.foundation.lazy.layout;

import androidx.collection.IntList;
import androidx.compose.ui.unit.IntOffset;
import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
/* compiled from: LazyLayoutStickyItems.kt */
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u001a\u0017\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0082\b\u001ah\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000e0\r\"\b\b\u0000\u0010\u000e*\u00020\u0004*\u0004\u0018\u00010\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00032\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u0002H\u000e0\u0019H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0018\u0010\u0002\u001a\u00020\u0003*\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u001a"}, d2 = {"Debug", "", "mainAxisOffset", "", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;", "getMainAxisOffset", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasuredItem;)I", "debugLog", "", "generateMsg", "Lkotlin/Function0;", "", "applyStickyItems", "", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/foundation/lazy/layout/StickyItemsPlacement;", "positionedItems", "", "stickyItems", "Landroidx/collection/IntList;", "beforeContentPadding", "afterContentPadding", "layoutWidth", "layoutHeight", "getAndMeasure", "Lkotlin/Function1;", "foundation_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LazyLayoutStickyItemsKt {
    private static final boolean Debug = false;

    public static final /* synthetic */ int access$getMainAxisOffset(LazyLayoutMeasuredItem lazyLayoutMeasuredItem) {
        return getMainAxisOffset(lazyLayoutMeasuredItem);
    }

    private static final void debugLog(Function0<String> function0) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int getMainAxisOffset(LazyLayoutMeasuredItem lazyLayoutMeasuredItem) {
        long mo852getOffsetBjo55l4 = lazyLayoutMeasuredItem.mo852getOffsetBjo55l4(0);
        return lazyLayoutMeasuredItem.isVertical() ? IntOffset.m6813getYimpl(mo852getOffsetBjo55l4) : IntOffset.m6812getXimpl(mo852getOffsetBjo55l4);
    }

    public static final <T extends LazyLayoutMeasuredItem> List<T> applyStickyItems(StickyItemsPlacement stickyItemsPlacement, List<T> list, IntList intList, int i, int i2, int i3, int i4, Function1<? super Integer, ? extends T> function1) {
        T remove;
        StickyItemsPlacement stickyItemsPlacement2 = stickyItemsPlacement;
        if (stickyItemsPlacement2 != null) {
            List<T> list2 = list;
            if (!list2.isEmpty() && intList._size != 0) {
                IntList stickingIndices = stickyItemsPlacement2.getStickingIndices(((LazyLayoutMeasuredItem) CollectionsKt.first((List<? extends Object>) list)).getIndex(), ((LazyLayoutMeasuredItem) CollectionsKt.last((List<? extends Object>) list)).getIndex(), intList);
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList(list.size());
                int size = list2.size();
                for (int i5 = 0; i5 < size; i5++) {
                    T t = list.get(i5);
                    if (intList.contains(t.getIndex())) {
                        arrayList2.add(t);
                    }
                }
                ArrayList arrayList3 = arrayList2;
                int[] iArr = stickingIndices.content;
                int i6 = stickingIndices._size;
                int i7 = 0;
                while (i7 < i6) {
                    int i8 = iArr[i7];
                    Iterator<T> it = list.iterator();
                    int i9 = 0;
                    while (true) {
                        if (!it.hasNext()) {
                            i9 = -1;
                            break;
                        } else if (it.next().getIndex() == i8) {
                            break;
                        } else {
                            i9++;
                        }
                    }
                    if (i9 == -1) {
                        remove = function1.invoke(Integer.valueOf(i8));
                    } else {
                        remove = list.remove(i9);
                    }
                    T t2 = remove;
                    int calculateStickingItemOffset = stickyItemsPlacement2.calculateStickingItemOffset(arrayList3, i8, remove.getMainAxisSizeWithSpacings(), i9 == -1 ? Integer.MIN_VALUE : getMainAxisOffset(remove), i, i2, i3, i4);
                    t2.setNonScrollableItem(true);
                    t2.position(calculateStickingItemOffset, 0, i3, i4);
                    arrayList.add(t2);
                    i7++;
                    stickyItemsPlacement2 = stickyItemsPlacement;
                }
                return arrayList;
            }
        }
        return CollectionsKt.emptyList();
    }
}
