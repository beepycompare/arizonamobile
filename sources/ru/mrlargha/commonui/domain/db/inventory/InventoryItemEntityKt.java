package ru.mrlargha.commonui.domain.db.inventory;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.elements.inventory.domain.models.InventoryItem;
/* compiled from: InventoryItemEntity.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"getEffect", "Lru/mrlargha/commonui/domain/db/inventory/InventoryItemEffectType;", "Lru/mrlargha/commonui/elements/inventory/domain/models/InventoryItem;", "CommonUI_release"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class InventoryItemEntityKt {
    public static final InventoryItemEffectType getEffect(InventoryItem inventoryItem) {
        Object obj;
        Intrinsics.checkNotNullParameter(inventoryItem, "<this>");
        Iterator<E> it = InventoryItemEffectType.getEntries().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((InventoryItemEffectType) obj).getEffectName(), inventoryItem.getEffect())) {
                break;
            }
        }
        InventoryItemEffectType inventoryItemEffectType = (InventoryItemEffectType) obj;
        return inventoryItemEffectType == null ? InventoryItemEffectType.NONE : inventoryItemEffectType;
    }
}
