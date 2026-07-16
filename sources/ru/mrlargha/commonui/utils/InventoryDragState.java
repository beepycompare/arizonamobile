package ru.mrlargha.commonui.utils;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ru.mrlargha.commonui.elements.inventory.domain.models.InventoryItem;
/* compiled from: Utils.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lru/mrlargha/commonui/utils/InventoryDragState;", "", "item", "Lru/mrlargha/commonui/elements/inventory/domain/models/InventoryItem;", "sourceView", "Landroid/view/View;", "<init>", "(Lru/mrlargha/commonui/elements/inventory/domain/models/InventoryItem;Landroid/view/View;)V", "getItem", "()Lru/mrlargha/commonui/elements/inventory/domain/models/InventoryItem;", "getSourceView", "()Landroid/view/View;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class InventoryDragState {
    private final InventoryItem item;
    private final View sourceView;

    public static /* synthetic */ InventoryDragState copy$default(InventoryDragState inventoryDragState, InventoryItem inventoryItem, View view, int i, Object obj) {
        if ((i & 1) != 0) {
            inventoryItem = inventoryDragState.item;
        }
        if ((i & 2) != 0) {
            view = inventoryDragState.sourceView;
        }
        return inventoryDragState.copy(inventoryItem, view);
    }

    public final InventoryItem component1() {
        return this.item;
    }

    public final View component2() {
        return this.sourceView;
    }

    public final InventoryDragState copy(InventoryItem item, View sourceView) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(sourceView, "sourceView");
        return new InventoryDragState(item, sourceView);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof InventoryDragState) {
            InventoryDragState inventoryDragState = (InventoryDragState) obj;
            return Intrinsics.areEqual(this.item, inventoryDragState.item) && Intrinsics.areEqual(this.sourceView, inventoryDragState.sourceView);
        }
        return false;
    }

    public int hashCode() {
        return (this.item.hashCode() * 31) + this.sourceView.hashCode();
    }

    public String toString() {
        InventoryItem inventoryItem = this.item;
        return "InventoryDragState(item=" + inventoryItem + ", sourceView=" + this.sourceView + ")";
    }

    public InventoryDragState(InventoryItem item, View sourceView) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(sourceView, "sourceView");
        this.item = item;
        this.sourceView = sourceView;
    }

    public final InventoryItem getItem() {
        return this.item;
    }

    public final View getSourceView() {
        return this.sourceView;
    }
}
