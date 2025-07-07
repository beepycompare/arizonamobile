package ru.mrlargha.commonui.elements.inventory.domain;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: InventorySendRequest.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lru/mrlargha/commonui/elements/inventory/domain/GuardInventorySendRequest;", "", "fromSlot", "Lru/mrlargha/commonui/elements/inventory/domain/ChangeFromSlot;", "toSlot", "Lru/mrlargha/commonui/elements/inventory/domain/ChangeToSlotGuard;", "<init>", "(Lru/mrlargha/commonui/elements/inventory/domain/ChangeFromSlot;Lru/mrlargha/commonui/elements/inventory/domain/ChangeToSlotGuard;)V", "getFromSlot", "()Lru/mrlargha/commonui/elements/inventory/domain/ChangeFromSlot;", "getToSlot", "()Lru/mrlargha/commonui/elements/inventory/domain/ChangeToSlotGuard;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GuardInventorySendRequest {
    @SerializedName("from")
    private final ChangeFromSlot fromSlot;
    @SerializedName(TypedValues.TransitionType.S_TO)
    private final ChangeToSlotGuard toSlot;

    public static /* synthetic */ GuardInventorySendRequest copy$default(GuardInventorySendRequest guardInventorySendRequest, ChangeFromSlot changeFromSlot, ChangeToSlotGuard changeToSlotGuard, int i, Object obj) {
        if ((i & 1) != 0) {
            changeFromSlot = guardInventorySendRequest.fromSlot;
        }
        if ((i & 2) != 0) {
            changeToSlotGuard = guardInventorySendRequest.toSlot;
        }
        return guardInventorySendRequest.copy(changeFromSlot, changeToSlotGuard);
    }

    public final ChangeFromSlot component1() {
        return this.fromSlot;
    }

    public final ChangeToSlotGuard component2() {
        return this.toSlot;
    }

    public final GuardInventorySendRequest copy(ChangeFromSlot fromSlot, ChangeToSlotGuard toSlot) {
        Intrinsics.checkNotNullParameter(fromSlot, "fromSlot");
        Intrinsics.checkNotNullParameter(toSlot, "toSlot");
        return new GuardInventorySendRequest(fromSlot, toSlot);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof GuardInventorySendRequest) {
            GuardInventorySendRequest guardInventorySendRequest = (GuardInventorySendRequest) obj;
            return Intrinsics.areEqual(this.fromSlot, guardInventorySendRequest.fromSlot) && Intrinsics.areEqual(this.toSlot, guardInventorySendRequest.toSlot);
        }
        return false;
    }

    public int hashCode() {
        return (this.fromSlot.hashCode() * 31) + this.toSlot.hashCode();
    }

    public String toString() {
        ChangeFromSlot changeFromSlot = this.fromSlot;
        return "GuardInventorySendRequest(fromSlot=" + changeFromSlot + ", toSlot=" + this.toSlot + ")";
    }

    public GuardInventorySendRequest(ChangeFromSlot fromSlot, ChangeToSlotGuard toSlot) {
        Intrinsics.checkNotNullParameter(fromSlot, "fromSlot");
        Intrinsics.checkNotNullParameter(toSlot, "toSlot");
        this.fromSlot = fromSlot;
        this.toSlot = toSlot;
    }

    public final ChangeFromSlot getFromSlot() {
        return this.fromSlot;
    }

    public final ChangeToSlotGuard getToSlot() {
        return this.toSlot;
    }
}
