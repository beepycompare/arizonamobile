package ru.mrlargha.commonui.utils;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Utils.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\r\u001a\u00020\u000eHÖ\u0081\u0004J\n\u0010\u000f\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lru/mrlargha/commonui/utils/InventoryIconRequest;", "", "entryName", "", "<init>", "(Ljava/lang/String;)V", "getEntryName", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class InventoryIconRequest {
    private final String entryName;

    public static /* synthetic */ InventoryIconRequest copy$default(InventoryIconRequest inventoryIconRequest, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = inventoryIconRequest.entryName;
        }
        return inventoryIconRequest.copy(str);
    }

    public final String component1() {
        return this.entryName;
    }

    public final InventoryIconRequest copy(String entryName) {
        Intrinsics.checkNotNullParameter(entryName, "entryName");
        return new InventoryIconRequest(entryName);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof InventoryIconRequest) && Intrinsics.areEqual(this.entryName, ((InventoryIconRequest) obj).entryName);
    }

    public int hashCode() {
        return this.entryName.hashCode();
    }

    public String toString() {
        return "InventoryIconRequest(entryName=" + this.entryName + ")";
    }

    public InventoryIconRequest(String entryName) {
        Intrinsics.checkNotNullParameter(entryName, "entryName");
        this.entryName = entryName;
    }

    public final String getEntryName() {
        return this.entryName;
    }
}
