package ru.mrlargha.commonui.elements.inventory.presentation.adapter;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.elements.inventory.domain.models.InventoryItem;
/* compiled from: MainInventoryAdapter.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lru/mrlargha/commonui/elements/inventory/presentation/adapter/DraggedItem;", "", "itemInfo", "Lru/mrlargha/commonui/elements/inventory/domain/models/InventoryItem;", "position", "", "<init>", "(Lru/mrlargha/commonui/elements/inventory/domain/models/InventoryItem;I)V", "getItemInfo", "()Lru/mrlargha/commonui/elements/inventory/domain/models/InventoryItem;", "getPosition", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DraggedItem {
    private final InventoryItem itemInfo;
    private final int position;

    public static /* synthetic */ DraggedItem copy$default(DraggedItem draggedItem, InventoryItem inventoryItem, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            inventoryItem = draggedItem.itemInfo;
        }
        if ((i2 & 2) != 0) {
            i = draggedItem.position;
        }
        return draggedItem.copy(inventoryItem, i);
    }

    public final InventoryItem component1() {
        return this.itemInfo;
    }

    public final int component2() {
        return this.position;
    }

    public final DraggedItem copy(InventoryItem itemInfo, int i) {
        Intrinsics.checkNotNullParameter(itemInfo, "itemInfo");
        return new DraggedItem(itemInfo, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DraggedItem) {
            DraggedItem draggedItem = (DraggedItem) obj;
            return Intrinsics.areEqual(this.itemInfo, draggedItem.itemInfo) && this.position == draggedItem.position;
        }
        return false;
    }

    public int hashCode() {
        return (this.itemInfo.hashCode() * 31) + Integer.hashCode(this.position);
    }

    public String toString() {
        InventoryItem inventoryItem = this.itemInfo;
        return "DraggedItem(itemInfo=" + inventoryItem + ", position=" + this.position + ")";
    }

    public DraggedItem(InventoryItem itemInfo, int i) {
        Intrinsics.checkNotNullParameter(itemInfo, "itemInfo");
        this.itemInfo = itemInfo;
        this.position = i;
    }

    public final InventoryItem getItemInfo() {
        return this.itemInfo;
    }

    public final int getPosition() {
        return this.position;
    }
}
