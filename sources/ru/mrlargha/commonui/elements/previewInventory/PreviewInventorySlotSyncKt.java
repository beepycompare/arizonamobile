package ru.mrlargha.commonui.elements.previewInventory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import ru.mrlargha.commonui.elements.inventory.domain.models.InventoryItem;
import ru.mrlargha.commonui.utils.ConstantsKt;
/* compiled from: PreviewInventorySlotSync.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u001aB\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0001H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"ARIZONA_PREVIEW_GUN_SLOT_COUNT", "", "mergePreviewSlotItems", "", "Lru/mrlargha/commonui/elements/inventory/domain/models/InventoryItem;", "currentItems", "incomingItems", "inventoryType", "requiredSlotCount", "backendMaxSlot", "CommonUI"}, k = 2, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class PreviewInventorySlotSyncKt {
    public static final int ARIZONA_PREVIEW_GUN_SLOT_COUNT = 6;

    public static final List<InventoryItem> mergePreviewSlotItems(List<InventoryItem> currentItems, List<InventoryItem> incomingItems, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(currentItems, "currentItems");
        Intrinsics.checkNotNullParameter(incomingItems, "incomingItems");
        InventoryItem inventoryItem = (InventoryItem) CollectionsKt.firstOrNull((List<? extends Object>) incomingItems);
        List<InventoryItem> emptyList = (inventoryItem == null || inventoryItem.getSlot() != 0) ? currentItems : CollectionsKt.emptyList();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : emptyList) {
            linkedHashMap.put(Integer.valueOf(((InventoryItem) obj).getSlot()), obj);
        }
        LinkedHashMap linkedHashMap2 = linkedHashMap;
        for (InventoryItem inventoryItem2 : incomingItems) {
            if (inventoryItem2.getSlot() >= 0) {
                linkedHashMap2.put(Integer.valueOf(inventoryItem2.getSlot()), inventoryItem2);
            }
        }
        Set keySet = linkedHashMap2.keySet();
        Intrinsics.checkNotNullExpressionValue(keySet, "<get-keys>(...)");
        Integer num = (Integer) CollectionsKt.maxOrNull((Iterable<? extends Comparable>) keySet);
        IntRange until = RangesKt.until(0, Math.max(i2, Math.max(RangesKt.coerceAtLeast(i3, 0), (num != null ? num.intValue() : -1) + 1)));
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(until, 10));
        Iterator<Integer> it = until.iterator();
        while (it.hasNext()) {
            int nextInt = ((IntIterator) it).nextInt();
            InventoryItem inventoryItem3 = (InventoryItem) linkedHashMap2.get(Integer.valueOf(nextInt));
            if (inventoryItem3 == null) {
                inventoryItem3 = InventoryItem.copy$default(ConstantsKt.getEmptyInventoryItem(), nextInt, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, i, null, null, false, false, null, null, null, null, null, null, 134152190, null);
            }
            arrayList.add(inventoryItem3);
        }
        return arrayList;
    }
}
