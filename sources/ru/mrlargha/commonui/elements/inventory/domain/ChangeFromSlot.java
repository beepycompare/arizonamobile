package ru.mrlargha.commonui.elements.inventory.domain;

import kotlin.Metadata;
/* compiled from: InventorySendRequest.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0018\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0019\u001a\u00020\u001aHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001b"}, d2 = {"Lru/mrlargha/commonui/elements/inventory/domain/ChangeFromSlot;", "", "slot", "", "type", "amount", "", "id", "<init>", "(IIJI)V", "getSlot", "()I", "getType", "getAmount", "()J", "getId", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "CommonUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ChangeFromSlot {
    private final long amount;
    private final int id;
    private final int slot;
    private final int type;

    public static /* synthetic */ ChangeFromSlot copy$default(ChangeFromSlot changeFromSlot, int i, int i2, long j, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = changeFromSlot.slot;
        }
        if ((i4 & 2) != 0) {
            i2 = changeFromSlot.type;
        }
        if ((i4 & 4) != 0) {
            j = changeFromSlot.amount;
        }
        if ((i4 & 8) != 0) {
            i3 = changeFromSlot.id;
        }
        int i5 = i3;
        return changeFromSlot.copy(i, i2, j, i5);
    }

    public final int component1() {
        return this.slot;
    }

    public final int component2() {
        return this.type;
    }

    public final long component3() {
        return this.amount;
    }

    public final int component4() {
        return this.id;
    }

    public final ChangeFromSlot copy(int i, int i2, long j, int i3) {
        return new ChangeFromSlot(i, i2, j, i3);
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
        return (((((Integer.hashCode(this.slot) * 31) + Integer.hashCode(this.type)) * 31) + Long.hashCode(this.amount)) * 31) + Integer.hashCode(this.id);
    }

    public String toString() {
        int i = this.slot;
        int i2 = this.type;
        long j = this.amount;
        return "ChangeFromSlot(slot=" + i + ", type=" + i2 + ", amount=" + j + ", id=" + this.id + ")";
    }

    public ChangeFromSlot(int i, int i2, long j, int i3) {
        this.slot = i;
        this.type = i2;
        this.amount = j;
        this.id = i3;
    }

    public final int getSlot() {
        return this.slot;
    }

    public final int getType() {
        return this.type;
    }

    public final long getAmount() {
        return this.amount;
    }

    public final int getId() {
        return this.id;
    }
}
