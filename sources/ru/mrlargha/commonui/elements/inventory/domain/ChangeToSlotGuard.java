package ru.mrlargha.commonui.elements.inventory.domain;

import kotlin.Metadata;
/* compiled from: InventorySendRequest.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lru/mrlargha/commonui/elements/inventory/domain/ChangeToSlotGuard;", "", "slot", "", "type", "id", "<init>", "(III)V", "getSlot", "()I", "getType", "getId", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ChangeToSlotGuard {
    private final int id;
    private final int slot;
    private final int type;

    public static /* synthetic */ ChangeToSlotGuard copy$default(ChangeToSlotGuard changeToSlotGuard, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = changeToSlotGuard.slot;
        }
        if ((i4 & 2) != 0) {
            i2 = changeToSlotGuard.type;
        }
        if ((i4 & 4) != 0) {
            i3 = changeToSlotGuard.id;
        }
        return changeToSlotGuard.copy(i, i2, i3);
    }

    public final int component1() {
        return this.slot;
    }

    public final int component2() {
        return this.type;
    }

    public final int component3() {
        return this.id;
    }

    public final ChangeToSlotGuard copy(int i, int i2, int i3) {
        return new ChangeToSlotGuard(i, i2, i3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ChangeToSlotGuard) {
            ChangeToSlotGuard changeToSlotGuard = (ChangeToSlotGuard) obj;
            return this.slot == changeToSlotGuard.slot && this.type == changeToSlotGuard.type && this.id == changeToSlotGuard.id;
        }
        return false;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.slot) * 31) + Integer.hashCode(this.type)) * 31) + Integer.hashCode(this.id);
    }

    public String toString() {
        int i = this.slot;
        int i2 = this.type;
        return "ChangeToSlotGuard(slot=" + i + ", type=" + i2 + ", id=" + this.id + ")";
    }

    public ChangeToSlotGuard(int i, int i2, int i3) {
        this.slot = i;
        this.type = i2;
        this.id = i3;
    }

    public final int getSlot() {
        return this.slot;
    }

    public final int getType() {
        return this.type;
    }

    public final int getId() {
        return this.id;
    }
}
