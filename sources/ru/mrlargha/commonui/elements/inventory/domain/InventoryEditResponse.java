package ru.mrlargha.commonui.elements.inventory.domain;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.elements.inventory.domain.models.InventoryItem;
/* compiled from: InventoryResponse.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J9\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0019\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u001a\u001a\u00020\u001bHÖ\u0081\u0004R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0016\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\f¨\u0006\u001c"}, d2 = {"Lru/mrlargha/commonui/elements/inventory/domain/InventoryEditResponse;", "", "type", "", "items", "", "Lru/mrlargha/commonui/elements/inventory/domain/models/InventoryItem;", "money", "maxSlot", "<init>", "(ILjava/util/List;II)V", "getType", "()I", "getItems", "()Ljava/util/List;", "getMoney", "getMaxSlot", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "CommonUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class InventoryEditResponse {
    @SerializedName("items")
    private final List<InventoryItem> items;
    @SerializedName("max_slot")
    private final int maxSlot;
    private final int money;
    @SerializedName("type")
    private final int type;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ InventoryEditResponse copy$default(InventoryEditResponse inventoryEditResponse, int i, List list, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = inventoryEditResponse.type;
        }
        if ((i4 & 2) != 0) {
            list = inventoryEditResponse.items;
        }
        if ((i4 & 4) != 0) {
            i2 = inventoryEditResponse.money;
        }
        if ((i4 & 8) != 0) {
            i3 = inventoryEditResponse.maxSlot;
        }
        return inventoryEditResponse.copy(i, list, i2, i3);
    }

    public final int component1() {
        return this.type;
    }

    public final List<InventoryItem> component2() {
        return this.items;
    }

    public final int component3() {
        return this.money;
    }

    public final int component4() {
        return this.maxSlot;
    }

    public final InventoryEditResponse copy(int i, List<InventoryItem> list, int i2, int i3) {
        return new InventoryEditResponse(i, list, i2, i3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof InventoryEditResponse) {
            InventoryEditResponse inventoryEditResponse = (InventoryEditResponse) obj;
            return this.type == inventoryEditResponse.type && Intrinsics.areEqual(this.items, inventoryEditResponse.items) && this.money == inventoryEditResponse.money && this.maxSlot == inventoryEditResponse.maxSlot;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = Integer.hashCode(this.type) * 31;
        List<InventoryItem> list = this.items;
        return ((((hashCode + (list == null ? 0 : list.hashCode())) * 31) + Integer.hashCode(this.money)) * 31) + Integer.hashCode(this.maxSlot);
    }

    public String toString() {
        int i = this.type;
        List<InventoryItem> list = this.items;
        int i2 = this.money;
        return "InventoryEditResponse(type=" + i + ", items=" + list + ", money=" + i2 + ", maxSlot=" + this.maxSlot + ")";
    }

    public InventoryEditResponse(int i, List<InventoryItem> list, int i2, int i3) {
        this.type = i;
        this.items = list;
        this.money = i2;
        this.maxSlot = i3;
    }

    public /* synthetic */ InventoryEditResponse(int i, List list, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, list, i2, (i4 & 8) != 0 ? -1 : i3);
    }

    public final int getType() {
        return this.type;
    }

    public final List<InventoryItem> getItems() {
        return this.items;
    }

    public final int getMoney() {
        return this.money;
    }

    public final int getMaxSlot() {
        return this.maxSlot;
    }
}
