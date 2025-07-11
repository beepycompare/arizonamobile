package ru.mrlargha.commonui.elements.inventory.domain.models;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: InventoryDataType.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lru/mrlargha/commonui/elements/inventory/domain/models/InventoryDataType;", "", "<init>", "()V", "TitleItem", "UpgradesItem", "Lru/mrlargha/commonui/elements/inventory/domain/models/InventoryDataType$TitleItem;", "Lru/mrlargha/commonui/elements/inventory/domain/models/InventoryDataType$UpgradesItem;", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class InventoryDataType {
    public /* synthetic */ InventoryDataType(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* compiled from: InventoryDataType.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lru/mrlargha/commonui/elements/inventory/domain/models/InventoryDataType$TitleItem;", "Lru/mrlargha/commonui/elements/inventory/domain/models/InventoryDataType;", "item", "Lru/mrlargha/commonui/elements/inventory/domain/models/InventoryItem;", "<init>", "(Lru/mrlargha/commonui/elements/inventory/domain/models/InventoryItem;)V", "getItem", "()Lru/mrlargha/commonui/elements/inventory/domain/models/InventoryItem;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class TitleItem extends InventoryDataType {
        private final InventoryItem item;

        public static /* synthetic */ TitleItem copy$default(TitleItem titleItem, InventoryItem inventoryItem, int i, Object obj) {
            if ((i & 1) != 0) {
                inventoryItem = titleItem.item;
            }
            return titleItem.copy(inventoryItem);
        }

        public final InventoryItem component1() {
            return this.item;
        }

        public final TitleItem copy(InventoryItem item) {
            Intrinsics.checkNotNullParameter(item, "item");
            return new TitleItem(item);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof TitleItem) && Intrinsics.areEqual(this.item, ((TitleItem) obj).item);
        }

        public int hashCode() {
            return this.item.hashCode();
        }

        public String toString() {
            return "TitleItem(item=" + this.item + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TitleItem(InventoryItem item) {
            super(null);
            Intrinsics.checkNotNullParameter(item, "item");
            this.item = item;
        }

        public final InventoryItem getItem() {
            return this.item;
        }
    }

    private InventoryDataType() {
    }

    /* compiled from: InventoryDataType.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lru/mrlargha/commonui/elements/inventory/domain/models/InventoryDataType$UpgradesItem;", "Lru/mrlargha/commonui/elements/inventory/domain/models/InventoryDataType;", "item", "Lru/mrlargha/commonui/elements/inventory/domain/models/InventoryItem;", "<init>", "(Lru/mrlargha/commonui/elements/inventory/domain/models/InventoryItem;)V", "getItem", "()Lru/mrlargha/commonui/elements/inventory/domain/models/InventoryItem;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class UpgradesItem extends InventoryDataType {
        private final InventoryItem item;

        public static /* synthetic */ UpgradesItem copy$default(UpgradesItem upgradesItem, InventoryItem inventoryItem, int i, Object obj) {
            if ((i & 1) != 0) {
                inventoryItem = upgradesItem.item;
            }
            return upgradesItem.copy(inventoryItem);
        }

        public final InventoryItem component1() {
            return this.item;
        }

        public final UpgradesItem copy(InventoryItem item) {
            Intrinsics.checkNotNullParameter(item, "item");
            return new UpgradesItem(item);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof UpgradesItem) && Intrinsics.areEqual(this.item, ((UpgradesItem) obj).item);
        }

        public int hashCode() {
            return this.item.hashCode();
        }

        public String toString() {
            return "UpgradesItem(item=" + this.item + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UpgradesItem(InventoryItem item) {
            super(null);
            Intrinsics.checkNotNullParameter(item, "item");
            this.item = item;
        }

        public final InventoryItem getItem() {
            return this.item;
        }
    }
}
