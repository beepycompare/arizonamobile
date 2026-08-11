package ru.mrlargha.commonui.elements.inventory.presentation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;
import ru.mrlargha.commonui.elements.inventory.domain.models.InventoryItem;
import ru.mrlargha.commonui.utils.ArizonaBlockType;
import ru.mrlargha.commonui.utils.ItemTypes;
import ru.mrlargha.commonui.utils.ItemsInfo;
/* compiled from: InventorySlotHighlight.kt */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\u001a%\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0000¢\u0006\u0002\u0010\n\u001a3\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\b\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\u000fH\u0000¢\u0006\u0002\u0010\u0010\u001a%\u0010\u0011\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0000¢\u0006\u0002\u0010\n\u001a3\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\u000fH\u0000¢\u0006\u0002\u0010\u0010\u001a\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0004H\u0000¢\u0006\u0002\u0010\u0016\u001a3\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\u000fH\u0000¢\u0006\u0002\u0010\u0010\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"GUN_SKIN_SLOT_RANGE", "Lkotlin/ranges/IntRange;", "ACCESSORY_SLOT_RANGE", "resolveGunSkinSlot", "", "item", "Lru/mrlargha/commonui/elements/inventory/domain/models/InventoryItem;", "itemCatalog", "", "Lru/mrlargha/commonui/utils/ItemsInfo;", "(Lru/mrlargha/commonui/elements/inventory/domain/models/InventoryItem;Ljava/util/List;)Ljava/lang/Integer;", "highlightGunSkinSlot", "slots", "gunSlot", "isHighlighted", "", "(Ljava/util/List;Ljava/lang/Integer;Z)Ljava/util/List;", "resolveAccessorySlot", "highlightAccessorySlot", "accessorySlot", "resolveArizonaVehicleBlockType", "itemType", "(Ljava/lang/Integer;)Ljava/lang/Integer;", "highlightArizonaVehicleSlot", "CommonUI"}, k = 2, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class InventorySlotHighlightKt {
    private static final IntRange GUN_SKIN_SLOT_RANGE = new IntRange(0, 5);
    private static final IntRange ACCESSORY_SLOT_RANGE = RangesKt.until(0, 9);

    public static final Integer resolveGunSkinSlot(InventoryItem item, List<ItemsInfo> itemCatalog) {
        Object obj;
        Object obj2;
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(itemCatalog, "itemCatalog");
        Iterator<T> it = itemCatalog.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                obj2 = null;
                break;
            }
            obj2 = it.next();
            int id = ((ItemsInfo) obj2).getId();
            Integer item2 = item.getItem();
            if (item2 != null && id == item2.intValue()) {
                break;
            }
        }
        ItemsInfo itemsInfo = (ItemsInfo) obj2;
        Integer[] numArr = new Integer[4];
        numArr[0] = item.getGunSlot();
        numArr[1] = itemsInfo != null ? itemsInfo.getGun_slot() : null;
        numArr[2] = item.getAcsSlot();
        numArr[3] = itemsInfo != null ? Integer.valueOf(itemsInfo.getAcs_slot()) : null;
        Iterator it2 = SequencesKt.filterNotNull(SequencesKt.sequenceOf((Object[]) numArr)).iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Object next = it2.next();
            int intValue = ((Number) next).intValue();
            IntRange intRange = GUN_SKIN_SLOT_RANGE;
            int first = intRange.getFirst();
            if (intValue <= intRange.getLast() && first <= intValue) {
                obj = next;
                break;
            }
        }
        return (Integer) obj;
    }

    public static final List<InventoryItem> highlightGunSkinSlot(List<InventoryItem> slots, Integer num, boolean z) {
        boolean z2;
        Intrinsics.checkNotNullParameter(slots, "slots");
        Integer num2 = null;
        if (num != null) {
            int intValue = num.intValue();
            IntRange intRange = GUN_SKIN_SLOT_RANGE;
            int first = intRange.getFirst();
            if (intValue <= intRange.getLast() && first <= intValue) {
                num2 = num;
            }
        }
        List<InventoryItem> list = slots;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (InventoryItem inventoryItem : list) {
            if (z) {
                int slot = inventoryItem.getSlot();
                if (num2 != null && slot == num2.intValue()) {
                    z2 = true;
                    arrayList.add(InventoryItem.copy$default(inventoryItem, 0, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, z2, false, null, null, null, null, null, null, 133693439, null));
                }
            }
            z2 = false;
            arrayList.add(InventoryItem.copy$default(inventoryItem, 0, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, z2, false, null, null, null, null, null, null, 133693439, null));
        }
        return arrayList;
    }

    public static final Integer resolveAccessorySlot(InventoryItem item, List<ItemsInfo> itemCatalog) {
        Object obj;
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(itemCatalog, "itemCatalog");
        Integer acsSlot = item.getAcsSlot();
        if (acsSlot != null) {
            int intValue = acsSlot.intValue();
            IntRange intRange = ACCESSORY_SLOT_RANGE;
            int first = intRange.getFirst();
            if (intValue > intRange.getLast() || first > intValue) {
                acsSlot = null;
            }
            if (acsSlot != null) {
                return acsSlot;
            }
        }
        Iterator<T> it = itemCatalog.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            int id = ((ItemsInfo) obj).getId();
            Integer item2 = item.getItem();
            if (item2 != null && id == item2.intValue()) {
                break;
            }
        }
        ItemsInfo itemsInfo = (ItemsInfo) obj;
        if (itemsInfo != null) {
            Integer valueOf = Integer.valueOf(itemsInfo.getAcs_slot());
            int intValue2 = valueOf.intValue();
            IntRange intRange2 = ACCESSORY_SLOT_RANGE;
            int first2 = intRange2.getFirst();
            if (intValue2 <= intRange2.getLast() && first2 <= intValue2) {
                return valueOf;
            }
        }
        return null;
    }

    public static final List<InventoryItem> highlightAccessorySlot(List<InventoryItem> slots, Integer num, boolean z) {
        boolean z2;
        Intrinsics.checkNotNullParameter(slots, "slots");
        Integer num2 = null;
        if (num != null && num.intValue() >= 0) {
            num2 = num;
        }
        List<InventoryItem> list = slots;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (InventoryItem inventoryItem : list) {
            if (z) {
                int slot = inventoryItem.getSlot();
                if (num2 != null && slot == num2.intValue()) {
                    z2 = true;
                    arrayList.add(InventoryItem.copy$default(inventoryItem, 0, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, z2, false, null, null, null, null, null, null, 133693439, null));
                }
            }
            z2 = false;
            arrayList.add(InventoryItem.copy$default(inventoryItem, 0, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, z2, false, null, null, null, null, null, null, 133693439, null));
        }
        return arrayList;
    }

    public static final Integer resolveArizonaVehicleBlockType(Integer num) {
        int id = ItemTypes.ITEM_TYPE_VEH_SKIN.getId();
        if (num == null || num.intValue() != id) {
            int id2 = ItemTypes.ITEM_TYPE_VEH_NUMBER_FRAME.getId();
            if (num == null || num.intValue() != id2) {
                int id3 = ItemTypes.ITEM_TYPE_VEH_MODIFICATION.getId();
                if (num != null && num.intValue() == id3) {
                    return Integer.valueOf(ArizonaBlockType.BLOCK_TYPE_VEH_MODIFICATION.getId());
                }
                int id4 = ItemTypes.ITEM_TYPE_VEH_NUMBER.getId();
                if (num != null && num.intValue() == id4) {
                    return Integer.valueOf(ArizonaBlockType.BLOCK_TYPE_VEH_NUMBER.getId());
                }
                return null;
            }
        }
        return Integer.valueOf(ArizonaBlockType.BLOCK_TYPE_VEH_SKIN.getId());
    }

    public static final List<InventoryItem> highlightArizonaVehicleSlot(List<InventoryItem> slots, Integer num, boolean z) {
        boolean z2;
        Intrinsics.checkNotNullParameter(slots, "slots");
        Integer resolveArizonaVehicleBlockType = resolveArizonaVehicleBlockType(num);
        List<InventoryItem> list = slots;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (InventoryItem inventoryItem : list) {
            if (z) {
                int inventoryType = inventoryItem.getInventoryType();
                if (resolveArizonaVehicleBlockType != null && inventoryType == resolveArizonaVehicleBlockType.intValue()) {
                    z2 = true;
                    arrayList.add(InventoryItem.copy$default(inventoryItem, 0, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, z2, false, null, null, null, null, null, null, 133693439, null));
                }
            }
            z2 = false;
            arrayList.add(InventoryItem.copy$default(inventoryItem, 0, null, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, 0, null, null, z2, false, null, null, null, null, null, null, 133693439, null));
        }
        return arrayList;
    }
}
