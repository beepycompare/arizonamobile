package ru.mrlargha.arizonaui.documents.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DocumentsData.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lru/mrlargha/arizonaui/documents/data/LicenseItem;", "", "license", "", "date_text", "available", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;I)V", "getLicense", "()Ljava/lang/String;", "getDate_text", "getAvailable", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class LicenseItem {
    private final int available;
    private final String date_text;
    private final String license;

    public static /* synthetic */ LicenseItem copy$default(LicenseItem licenseItem, String str, String str2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = licenseItem.license;
        }
        if ((i2 & 2) != 0) {
            str2 = licenseItem.date_text;
        }
        if ((i2 & 4) != 0) {
            i = licenseItem.available;
        }
        return licenseItem.copy(str, str2, i);
    }

    public final String component1() {
        return this.license;
    }

    public final String component2() {
        return this.date_text;
    }

    public final int component3() {
        return this.available;
    }

    public final LicenseItem copy(String license, String date_text, int i) {
        Intrinsics.checkNotNullParameter(license, "license");
        Intrinsics.checkNotNullParameter(date_text, "date_text");
        return new LicenseItem(license, date_text, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LicenseItem) {
            LicenseItem licenseItem = (LicenseItem) obj;
            return Intrinsics.areEqual(this.license, licenseItem.license) && Intrinsics.areEqual(this.date_text, licenseItem.date_text) && this.available == licenseItem.available;
        }
        return false;
    }

    public int hashCode() {
        return (((this.license.hashCode() * 31) + this.date_text.hashCode()) * 31) + Integer.hashCode(this.available);
    }

    public String toString() {
        String str = this.license;
        String str2 = this.date_text;
        return "LicenseItem(license=" + str + ", date_text=" + str2 + ", available=" + this.available + ")";
    }

    public LicenseItem(String license, String date_text, int i) {
        Intrinsics.checkNotNullParameter(license, "license");
        Intrinsics.checkNotNullParameter(date_text, "date_text");
        this.license = license;
        this.date_text = date_text;
        this.available = i;
    }

    public final String getLicense() {
        return this.license;
    }

    public final String getDate_text() {
        return this.date_text;
    }

    public final int getAvailable() {
        return this.available;
    }
}
