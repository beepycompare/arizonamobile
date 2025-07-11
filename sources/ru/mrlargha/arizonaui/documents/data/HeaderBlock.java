package ru.mrlargha.arizonaui.documents.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DocumentsData.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J)\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lru/mrlargha/arizonaui/documents/data/HeaderBlock;", "", "type_vip", "", "vip_date", "add_vip_date", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getType_vip", "()Ljava/lang/String;", "getVip_date", "getAdd_vip_date", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class HeaderBlock {
    private final String add_vip_date;
    private final String type_vip;
    private final String vip_date;

    public static /* synthetic */ HeaderBlock copy$default(HeaderBlock headerBlock, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = headerBlock.type_vip;
        }
        if ((i & 2) != 0) {
            str2 = headerBlock.vip_date;
        }
        if ((i & 4) != 0) {
            str3 = headerBlock.add_vip_date;
        }
        return headerBlock.copy(str, str2, str3);
    }

    public final String component1() {
        return this.type_vip;
    }

    public final String component2() {
        return this.vip_date;
    }

    public final String component3() {
        return this.add_vip_date;
    }

    public final HeaderBlock copy(String type_vip, String vip_date, String str) {
        Intrinsics.checkNotNullParameter(type_vip, "type_vip");
        Intrinsics.checkNotNullParameter(vip_date, "vip_date");
        return new HeaderBlock(type_vip, vip_date, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof HeaderBlock) {
            HeaderBlock headerBlock = (HeaderBlock) obj;
            return Intrinsics.areEqual(this.type_vip, headerBlock.type_vip) && Intrinsics.areEqual(this.vip_date, headerBlock.vip_date) && Intrinsics.areEqual(this.add_vip_date, headerBlock.add_vip_date);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((this.type_vip.hashCode() * 31) + this.vip_date.hashCode()) * 31;
        String str = this.add_vip_date;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        String str = this.type_vip;
        String str2 = this.vip_date;
        return "HeaderBlock(type_vip=" + str + ", vip_date=" + str2 + ", add_vip_date=" + this.add_vip_date + ")";
    }

    public HeaderBlock(String type_vip, String vip_date, String str) {
        Intrinsics.checkNotNullParameter(type_vip, "type_vip");
        Intrinsics.checkNotNullParameter(vip_date, "vip_date");
        this.type_vip = type_vip;
        this.vip_date = vip_date;
        this.add_vip_date = str;
    }

    public final String getType_vip() {
        return this.type_vip;
    }

    public final String getVip_date() {
        return this.vip_date;
    }

    public final String getAdd_vip_date() {
        return this.add_vip_date;
    }
}
