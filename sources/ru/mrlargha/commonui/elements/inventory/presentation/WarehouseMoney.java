package ru.mrlargha.commonui.elements.inventory.presentation;

import kotlin.Metadata;
/* compiled from: InventoryScreen.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lru/mrlargha/commonui/elements/inventory/presentation/WarehouseMoney;", "", "type", "", "money", "", "<init>", "(IJ)V", "getType", "()I", "getMoney", "()J", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class WarehouseMoney {
    private final long money;
    private final int type;

    public static /* synthetic */ WarehouseMoney copy$default(WarehouseMoney warehouseMoney, int i, long j, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = warehouseMoney.type;
        }
        if ((i2 & 2) != 0) {
            j = warehouseMoney.money;
        }
        return warehouseMoney.copy(i, j);
    }

    public final int component1() {
        return this.type;
    }

    public final long component2() {
        return this.money;
    }

    public final WarehouseMoney copy(int i, long j) {
        return new WarehouseMoney(i, j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof WarehouseMoney) {
            WarehouseMoney warehouseMoney = (WarehouseMoney) obj;
            return this.type == warehouseMoney.type && this.money == warehouseMoney.money;
        }
        return false;
    }

    public int hashCode() {
        return (Integer.hashCode(this.type) * 31) + Long.hashCode(this.money);
    }

    public String toString() {
        int i = this.type;
        return "WarehouseMoney(type=" + i + ", money=" + this.money + ")";
    }

    public WarehouseMoney(int i, long j) {
        this.type = i;
        this.money = j;
    }

    public final long getMoney() {
        return this.money;
    }

    public final int getType() {
        return this.type;
    }
}
