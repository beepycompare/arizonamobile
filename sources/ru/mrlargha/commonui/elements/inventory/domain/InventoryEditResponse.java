package ru.mrlargha.commonui.elements.inventory.domain;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.elements.inventory.domain.models.InventoryItem;
/* compiled from: InventoryResponse.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J/\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000b¨\u0006\u0019"}, d2 = {"Lru/mrlargha/commonui/elements/inventory/domain/InventoryEditResponse;", "", "type", "", FirebaseAnalytics.Param.ITEMS, "", "Lru/mrlargha/commonui/elements/inventory/domain/models/InventoryItem;", "money", "<init>", "(ILjava/util/List;I)V", "getType", "()I", "getItems", "()Ljava/util/List;", "getMoney", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class InventoryEditResponse {
    @SerializedName(FirebaseAnalytics.Param.ITEMS)
    private final List<InventoryItem> items;
    private final int money;
    @SerializedName("type")
    private final int type;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ InventoryEditResponse copy$default(InventoryEditResponse inventoryEditResponse, int i, List list, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = inventoryEditResponse.type;
        }
        if ((i3 & 2) != 0) {
            list = inventoryEditResponse.items;
        }
        if ((i3 & 4) != 0) {
            i2 = inventoryEditResponse.money;
        }
        return inventoryEditResponse.copy(i, list, i2);
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

    public final InventoryEditResponse copy(int i, List<InventoryItem> list, int i2) {
        return new InventoryEditResponse(i, list, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof InventoryEditResponse) {
            InventoryEditResponse inventoryEditResponse = (InventoryEditResponse) obj;
            return this.type == inventoryEditResponse.type && Intrinsics.areEqual(this.items, inventoryEditResponse.items) && this.money == inventoryEditResponse.money;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = Integer.hashCode(this.type) * 31;
        List<InventoryItem> list = this.items;
        return ((hashCode + (list == null ? 0 : list.hashCode())) * 31) + Integer.hashCode(this.money);
    }

    public String toString() {
        int i = this.type;
        List<InventoryItem> list = this.items;
        return "InventoryEditResponse(type=" + i + ", items=" + list + ", money=" + this.money + ")";
    }

    public InventoryEditResponse(int i, List<InventoryItem> list, int i2) {
        this.type = i;
        this.items = list;
        this.money = i2;
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
}
