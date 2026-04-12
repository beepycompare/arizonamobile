package ru.mrlargha.commonui.elements.inventory.domain;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.elements.inventory.domain.models.InventoryItem;
/* compiled from: InventoryResponse.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J-\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0017\u001a\u00020\u0018HÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0007\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000b¨\u0006\u0019"}, d2 = {"Lru/mrlargha/commonui/elements/inventory/domain/InventoryResponse;", "", "type", "", "items", "", "Lru/mrlargha/commonui/elements/inventory/domain/models/InventoryItem;", "maxSlot", "<init>", "(ILjava/util/List;I)V", "getType", "()I", "getItems", "()Ljava/util/List;", "getMaxSlot", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "CommonUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class InventoryResponse {
    @SerializedName("items")
    private final List<InventoryItem> items;
    @SerializedName("max_slot")
    private final int maxSlot;
    @SerializedName("type")
    private final int type;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ InventoryResponse copy$default(InventoryResponse inventoryResponse, int i, List list, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = inventoryResponse.type;
        }
        if ((i3 & 2) != 0) {
            list = inventoryResponse.items;
        }
        if ((i3 & 4) != 0) {
            i2 = inventoryResponse.maxSlot;
        }
        return inventoryResponse.copy(i, list, i2);
    }

    public final int component1() {
        return this.type;
    }

    public final List<InventoryItem> component2() {
        return this.items;
    }

    public final int component3() {
        return this.maxSlot;
    }

    public final InventoryResponse copy(int i, List<InventoryItem> items, int i2) {
        Intrinsics.checkNotNullParameter(items, "items");
        return new InventoryResponse(i, items, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof InventoryResponse) {
            InventoryResponse inventoryResponse = (InventoryResponse) obj;
            return this.type == inventoryResponse.type && Intrinsics.areEqual(this.items, inventoryResponse.items) && this.maxSlot == inventoryResponse.maxSlot;
        }
        return false;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.type) * 31) + this.items.hashCode()) * 31) + Integer.hashCode(this.maxSlot);
    }

    public String toString() {
        int i = this.type;
        List<InventoryItem> list = this.items;
        return "InventoryResponse(type=" + i + ", items=" + list + ", maxSlot=" + this.maxSlot + ")";
    }

    public InventoryResponse(int i, List<InventoryItem> items, int i2) {
        Intrinsics.checkNotNullParameter(items, "items");
        this.type = i;
        this.items = items;
        this.maxSlot = i2;
    }

    public /* synthetic */ InventoryResponse(int i, List list, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, list, (i3 & 4) != 0 ? -1 : i2);
    }

    public final int getType() {
        return this.type;
    }

    public final List<InventoryItem> getItems() {
        return this.items;
    }

    public final int getMaxSlot() {
        return this.maxSlot;
    }
}
