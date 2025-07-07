package ru.mrlargha.commonui.elements.inventory.domain;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.elements.inventory.domain.models.InventoryItem;
/* compiled from: InventoryResponse.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lru/mrlargha/commonui/elements/inventory/domain/InventoryResponse;", "", "type", "", FirebaseAnalytics.Param.ITEMS, "", "Lru/mrlargha/commonui/elements/inventory/domain/models/InventoryItem;", "<init>", "(ILjava/util/List;)V", "getType", "()I", "getItems", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class InventoryResponse {
    @SerializedName(FirebaseAnalytics.Param.ITEMS)
    private final List<InventoryItem> items;
    @SerializedName("type")
    private final int type;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ InventoryResponse copy$default(InventoryResponse inventoryResponse, int i, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = inventoryResponse.type;
        }
        if ((i2 & 2) != 0) {
            list = inventoryResponse.items;
        }
        return inventoryResponse.copy(i, list);
    }

    public final int component1() {
        return this.type;
    }

    public final List<InventoryItem> component2() {
        return this.items;
    }

    public final InventoryResponse copy(int i, List<InventoryItem> items) {
        Intrinsics.checkNotNullParameter(items, "items");
        return new InventoryResponse(i, items);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof InventoryResponse) {
            InventoryResponse inventoryResponse = (InventoryResponse) obj;
            return this.type == inventoryResponse.type && Intrinsics.areEqual(this.items, inventoryResponse.items);
        }
        return false;
    }

    public int hashCode() {
        return (Integer.hashCode(this.type) * 31) + this.items.hashCode();
    }

    public String toString() {
        int i = this.type;
        return "InventoryResponse(type=" + i + ", items=" + this.items + ")";
    }

    public InventoryResponse(int i, List<InventoryItem> items) {
        Intrinsics.checkNotNullParameter(items, "items");
        this.type = i;
        this.items = items;
    }

    public final int getType() {
        return this.type;
    }

    public final List<InventoryItem> getItems() {
        return this.items;
    }
}
