package ru.mrlargha.commonui.elements.inventory.presentation.dialog;

import kotlin.Metadata;
/* compiled from: SelectorDialog.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lru/mrlargha/commonui/elements/inventory/presentation/dialog/SendSelectedData;", "", "type", "", "slot", "action", "id", "<init>", "(IIII)V", "getType", "()I", "getSlot", "getAction", "getId", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SendSelectedData {
    private final int action;
    private final int id;
    private final int slot;
    private final int type;

    public static /* synthetic */ SendSelectedData copy$default(SendSelectedData sendSelectedData, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = sendSelectedData.type;
        }
        if ((i5 & 2) != 0) {
            i2 = sendSelectedData.slot;
        }
        if ((i5 & 4) != 0) {
            i3 = sendSelectedData.action;
        }
        if ((i5 & 8) != 0) {
            i4 = sendSelectedData.id;
        }
        return sendSelectedData.copy(i, i2, i3, i4);
    }

    public final int component1() {
        return this.type;
    }

    public final int component2() {
        return this.slot;
    }

    public final int component3() {
        return this.action;
    }

    public final int component4() {
        return this.id;
    }

    public final SendSelectedData copy(int i, int i2, int i3, int i4) {
        return new SendSelectedData(i, i2, i3, i4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SendSelectedData) {
            SendSelectedData sendSelectedData = (SendSelectedData) obj;
            return this.type == sendSelectedData.type && this.slot == sendSelectedData.slot && this.action == sendSelectedData.action && this.id == sendSelectedData.id;
        }
        return false;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.type) * 31) + Integer.hashCode(this.slot)) * 31) + Integer.hashCode(this.action)) * 31) + Integer.hashCode(this.id);
    }

    public String toString() {
        int i = this.type;
        int i2 = this.slot;
        int i3 = this.action;
        return "SendSelectedData(type=" + i + ", slot=" + i2 + ", action=" + i3 + ", id=" + this.id + ")";
    }

    public SendSelectedData(int i, int i2, int i3, int i4) {
        this.type = i;
        this.slot = i2;
        this.action = i3;
        this.id = i4;
    }

    public final int getAction() {
        return this.action;
    }

    public final int getId() {
        return this.id;
    }

    public final int getSlot() {
        return this.slot;
    }

    public final int getType() {
        return this.type;
    }
}
