package ru.mrlargha.arizonaui.documents.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DocumentsData.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0017"}, d2 = {"Lru/mrlargha/arizonaui/documents/data/VipStatus;", "", "available", "", "type_vip", "", "date_vip", "<init>", "(ILjava/lang/String;Ljava/lang/String;)V", "getAvailable", "()I", "getType_vip", "()Ljava/lang/String;", "getDate_vip", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class VipStatus {
    private final int available;
    private final String date_vip;
    private final String type_vip;

    public static /* synthetic */ VipStatus copy$default(VipStatus vipStatus, int i, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = vipStatus.available;
        }
        if ((i2 & 2) != 0) {
            str = vipStatus.type_vip;
        }
        if ((i2 & 4) != 0) {
            str2 = vipStatus.date_vip;
        }
        return vipStatus.copy(i, str, str2);
    }

    public final int component1() {
        return this.available;
    }

    public final String component2() {
        return this.type_vip;
    }

    public final String component3() {
        return this.date_vip;
    }

    public final VipStatus copy(int i, String type_vip, String date_vip) {
        Intrinsics.checkNotNullParameter(type_vip, "type_vip");
        Intrinsics.checkNotNullParameter(date_vip, "date_vip");
        return new VipStatus(i, type_vip, date_vip);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof VipStatus) {
            VipStatus vipStatus = (VipStatus) obj;
            return this.available == vipStatus.available && Intrinsics.areEqual(this.type_vip, vipStatus.type_vip) && Intrinsics.areEqual(this.date_vip, vipStatus.date_vip);
        }
        return false;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.available) * 31) + this.type_vip.hashCode()) * 31) + this.date_vip.hashCode();
    }

    public String toString() {
        int i = this.available;
        String str = this.type_vip;
        return "VipStatus(available=" + i + ", type_vip=" + str + ", date_vip=" + this.date_vip + ")";
    }

    public VipStatus(int i, String type_vip, String date_vip) {
        Intrinsics.checkNotNullParameter(type_vip, "type_vip");
        Intrinsics.checkNotNullParameter(date_vip, "date_vip");
        this.available = i;
        this.type_vip = type_vip;
        this.date_vip = date_vip;
    }

    public final int getAvailable() {
        return this.available;
    }

    public final String getType_vip() {
        return this.type_vip;
    }

    public final String getDate_vip() {
        return this.date_vip;
    }
}
