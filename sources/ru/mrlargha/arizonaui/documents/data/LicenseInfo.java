package ru.mrlargha.arizonaui.documents.data;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DocumentsData.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lru/mrlargha/arizonaui/documents/data/LicenseInfo;", "", "type", "", "info", "", "Lru/mrlargha/arizonaui/documents/data/LicenseItem;", "<init>", "(ILjava/util/List;)V", "getType", "()I", "getInfo", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class LicenseInfo {
    private final List<LicenseItem> info;
    private final int type;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LicenseInfo copy$default(LicenseInfo licenseInfo, int i, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = licenseInfo.type;
        }
        if ((i2 & 2) != 0) {
            list = licenseInfo.info;
        }
        return licenseInfo.copy(i, list);
    }

    public final int component1() {
        return this.type;
    }

    public final List<LicenseItem> component2() {
        return this.info;
    }

    public final LicenseInfo copy(int i, List<LicenseItem> info) {
        Intrinsics.checkNotNullParameter(info, "info");
        return new LicenseInfo(i, info);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LicenseInfo) {
            LicenseInfo licenseInfo = (LicenseInfo) obj;
            return this.type == licenseInfo.type && Intrinsics.areEqual(this.info, licenseInfo.info);
        }
        return false;
    }

    public int hashCode() {
        return (Integer.hashCode(this.type) * 31) + this.info.hashCode();
    }

    public String toString() {
        int i = this.type;
        return "LicenseInfo(type=" + i + ", info=" + this.info + ")";
    }

    public LicenseInfo(int i, List<LicenseItem> info) {
        Intrinsics.checkNotNullParameter(info, "info");
        this.type = i;
        this.info = info;
    }

    public final int getType() {
        return this.type;
    }

    public final List<LicenseItem> getInfo() {
        return this.info;
    }
}
