package ru.mrlargha.commonui.elements.inventory.domain;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: InventorySendRequest.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lru/mrlargha/commonui/elements/inventory/domain/GuardItemRequest;", "", "fromSlot", "Lru/mrlargha/commonui/elements/inventory/domain/ChangeFromSlot;", "id", "", "<init>", "(Lru/mrlargha/commonui/elements/inventory/domain/ChangeFromSlot;I)V", "getFromSlot", "()Lru/mrlargha/commonui/elements/inventory/domain/ChangeFromSlot;", "getId", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GuardItemRequest {
    @SerializedName("from")
    private final ChangeFromSlot fromSlot;
    private final int id;

    public static /* synthetic */ GuardItemRequest copy$default(GuardItemRequest guardItemRequest, ChangeFromSlot changeFromSlot, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            changeFromSlot = guardItemRequest.fromSlot;
        }
        if ((i2 & 2) != 0) {
            i = guardItemRequest.id;
        }
        return guardItemRequest.copy(changeFromSlot, i);
    }

    public final ChangeFromSlot component1() {
        return this.fromSlot;
    }

    public final int component2() {
        return this.id;
    }

    public final GuardItemRequest copy(ChangeFromSlot fromSlot, int i) {
        Intrinsics.checkNotNullParameter(fromSlot, "fromSlot");
        return new GuardItemRequest(fromSlot, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof GuardItemRequest) {
            GuardItemRequest guardItemRequest = (GuardItemRequest) obj;
            return Intrinsics.areEqual(this.fromSlot, guardItemRequest.fromSlot) && this.id == guardItemRequest.id;
        }
        return false;
    }

    public int hashCode() {
        return (this.fromSlot.hashCode() * 31) + Integer.hashCode(this.id);
    }

    public String toString() {
        ChangeFromSlot changeFromSlot = this.fromSlot;
        return "GuardItemRequest(fromSlot=" + changeFromSlot + ", id=" + this.id + ")";
    }

    public GuardItemRequest(ChangeFromSlot fromSlot, int i) {
        Intrinsics.checkNotNullParameter(fromSlot, "fromSlot");
        this.fromSlot = fromSlot;
        this.id = i;
    }

    public final ChangeFromSlot getFromSlot() {
        return this.fromSlot;
    }

    public final int getId() {
        return this.id;
    }
}
