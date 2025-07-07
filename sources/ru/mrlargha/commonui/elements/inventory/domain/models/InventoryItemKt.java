package ru.mrlargha.commonui.elements.inventory.domain.models;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.domain.db.inventory.InventoryItemEntity;
/* compiled from: InventoryItem.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0002*\u00020\u0001¨\u0006\u0004"}, d2 = {"toEntity", "Lru/mrlargha/commonui/domain/db/inventory/InventoryItemEntity;", "Lru/mrlargha/commonui/elements/inventory/domain/models/InventoryItem;", "toUi", "CommonUI_release_web"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class InventoryItemKt {
    public static final InventoryItemEntity toEntity(InventoryItem inventoryItem) {
        Intrinsics.checkNotNullParameter(inventoryItem, "<this>");
        return new InventoryItemEntity(inventoryItem.getSlot(), inventoryItem.getItem(), inventoryItem.getId(), inventoryItem.getText(), inventoryItem.getItem_type(), inventoryItem.getAmount(), inventoryItem.getBackground(), inventoryItem.getColor(), inventoryItem.getBits(), inventoryItem.getAvailable(), inventoryItem.getEnchant(), inventoryItem.getBreaks(), inventoryItem.isActive(), inventoryItem.getItemStrength(), inventoryItem.getBlackout(), inventoryItem.getTime(), inventoryItem.getAcsSlot(), inventoryItem.getInventoryType(), inventoryItem.isColored(), inventoryItem.isLocked());
    }

    public static final InventoryItem toUi(InventoryItemEntity inventoryItemEntity) {
        Intrinsics.checkNotNullParameter(inventoryItemEntity, "<this>");
        int slot = inventoryItemEntity.getSlot();
        Integer item = inventoryItemEntity.getItem();
        int id = inventoryItemEntity.getId();
        String text = inventoryItemEntity.getText();
        Integer item_type = inventoryItemEntity.getItem_type();
        Integer amount = inventoryItemEntity.getAmount();
        Integer background = inventoryItemEntity.getBackground();
        Integer color = inventoryItemEntity.getColor();
        Integer bits = inventoryItemEntity.getBits();
        Integer available = inventoryItemEntity.getAvailable();
        Integer acsSlot = inventoryItemEntity.getAcsSlot();
        int inventoryType = inventoryItemEntity.getInventoryType();
        boolean isColored = inventoryItemEntity.isColored();
        boolean isLocked = inventoryItemEntity.isLocked();
        Integer enchant = inventoryItemEntity.getEnchant();
        Integer breaks = inventoryItemEntity.getBreaks();
        Integer isActive = inventoryItemEntity.isActive();
        return new InventoryItem(slot, item, id, text, item_type, amount, background, color, bits, available, enchant, inventoryItemEntity.getBlackout(), inventoryItemEntity.getTime(), inventoryItemEntity.getItemStrength(), isActive, breaks, inventoryType, acsSlot, null, isColored, isLocked);
    }
}
