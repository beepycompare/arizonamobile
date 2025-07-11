package ru.mrlargha.commonui.elements.inventory.domain.models;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.elements.inventory.domain.models.InventoryDataType;
/* compiled from: InventoryDataType.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0017\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"id", "", "Lru/mrlargha/commonui/elements/inventory/domain/models/InventoryDataType;", "getId", "(Lru/mrlargha/commonui/elements/inventory/domain/models/InventoryDataType;)Ljava/lang/Object;", "CommonUI_release_web"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class InventoryDataTypeKt {
    public static final Object getId(InventoryDataType inventoryDataType) {
        InventoryItem item;
        InventoryItem item2;
        Intrinsics.checkNotNullParameter(inventoryDataType, "<this>");
        InventoryDataType.TitleItem titleItem = inventoryDataType instanceof InventoryDataType.TitleItem ? (InventoryDataType.TitleItem) inventoryDataType : null;
        if (titleItem == null || (item2 = titleItem.getItem()) == null) {
            InventoryDataType.UpgradesItem upgradesItem = inventoryDataType instanceof InventoryDataType.UpgradesItem ? (InventoryDataType.UpgradesItem) inventoryDataType : null;
            if (upgradesItem == null || (item = upgradesItem.getItem()) == null) {
                return null;
            }
            return Integer.valueOf(item.getSlot());
        }
        return Integer.valueOf(item2.getSlot());
    }
}
