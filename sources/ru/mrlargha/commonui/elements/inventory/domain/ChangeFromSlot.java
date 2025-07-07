package ru.mrlargha.commonui.elements.inventory.domain;

import kotlin.Metadata;
/* compiled from: InventorySendRequest.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lru/mrlargha/commonui/elements/inventory/domain/ChangeFromSlot;", "", "slot", "", "type", "amount", "id", "<init>", "(IIII)V", "getSlot", "()I", "getType", "getAmount", "getId", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ChangeFromSlot {
    private final int amount;
    private final int id;
    private final int slot;
    private final int type;

    public static /* synthetic */ ChangeFromSlot copy$default(ChangeFromSlot changeFromSlot, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = changeFromSlot.slot;
        }
        if ((i5 & 2) != 0) {
            i2 = changeFromSlot.type;
        }
        if ((i5 & 4) != 0) {
            i3 = changeFromSlot.amount;
        }
        if ((i5 & 8) != 0) {
            i4 = changeFromSlot.id;
        }
        return changeFromSlot.copy(i, i2, i3, i4);
    }

    public final int component1() {
        return this.slot;
    }

    public final int component2() {
        return this.type;
    }

    public final int component3() {
        return this.amount;
    }

    public final int component4() {
        return this.id;
    }

    public final ChangeFromSlot copy(int i, int i2, int i3, int i4) {
        return new ChangeFromSlot(i, i2, i3, i4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ChangeFromSlot) {
            ChangeFromSlot changeFromSlot = (ChangeFromSlot) obj;
            return this.slot == changeFromSlot.slot && this.type == changeFromSlot.type && this.amount == changeFromSlot.amount && this.id == changeFromSlot.id;
        }
        return false;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.slot) * 31) + Integer.hashCode(this.type)) * 31) + Integer.hashCode(this.amount)) * 31) + Integer.hashCode(this.id);
    }

    public String toString() {
        int i = this.slot;
        int i2 = this.type;
        int i3 = this.amount;
        return "ChangeFromSlot(slot=" + i + ", type=" + i2 + ", amount=" + i3 + ", id=" + this.id + ")";
    }

    public ChangeFromSlot(int i, int i2, int i3, int i4) {
        this.slot = i;
        this.type = i2;
        this.amount = i3;
        this.id = i4;
    }

    public final int getSlot() {
        return this.slot;
    }

    public final int getType() {
        return this.type;
    }

    public final int getAmount() {
        return this.amount;
    }

    public final int getId() {
        return this.id;
    }
}
