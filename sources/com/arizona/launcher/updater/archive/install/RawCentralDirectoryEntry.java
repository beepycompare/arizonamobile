package com.arizona.launcher.updater.archive.install;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
/* compiled from: SafeZipExtractor.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/arizona/launcher/updater/archive/install/RawCentralDirectoryEntry;", "", "generalPurposeFlags", "", FirebaseAnalytics.Param.METHOD, "externalAttributes", "", "<init>", "(IIJ)V", "getGeneralPurposeFlags", "()I", "getMethod", "getExternalAttributes", "()J", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
final class RawCentralDirectoryEntry {
    private final long externalAttributes;
    private final int generalPurposeFlags;
    private final int method;

    public static /* synthetic */ RawCentralDirectoryEntry copy$default(RawCentralDirectoryEntry rawCentralDirectoryEntry, int i, int i2, long j, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = rawCentralDirectoryEntry.generalPurposeFlags;
        }
        if ((i3 & 2) != 0) {
            i2 = rawCentralDirectoryEntry.method;
        }
        if ((i3 & 4) != 0) {
            j = rawCentralDirectoryEntry.externalAttributes;
        }
        return rawCentralDirectoryEntry.copy(i, i2, j);
    }

    public final int component1() {
        return this.generalPurposeFlags;
    }

    public final int component2() {
        return this.method;
    }

    public final long component3() {
        return this.externalAttributes;
    }

    public final RawCentralDirectoryEntry copy(int i, int i2, long j) {
        return new RawCentralDirectoryEntry(i, i2, j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RawCentralDirectoryEntry) {
            RawCentralDirectoryEntry rawCentralDirectoryEntry = (RawCentralDirectoryEntry) obj;
            return this.generalPurposeFlags == rawCentralDirectoryEntry.generalPurposeFlags && this.method == rawCentralDirectoryEntry.method && this.externalAttributes == rawCentralDirectoryEntry.externalAttributes;
        }
        return false;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.generalPurposeFlags) * 31) + Integer.hashCode(this.method)) * 31) + Long.hashCode(this.externalAttributes);
    }

    public String toString() {
        int i = this.generalPurposeFlags;
        int i2 = this.method;
        return "RawCentralDirectoryEntry(generalPurposeFlags=" + i + ", method=" + i2 + ", externalAttributes=" + this.externalAttributes + ")";
    }

    public RawCentralDirectoryEntry(int i, int i2, long j) {
        this.generalPurposeFlags = i;
        this.method = i2;
        this.externalAttributes = j;
    }

    public final int getGeneralPurposeFlags() {
        return this.generalPurposeFlags;
    }

    public final int getMethod() {
        return this.method;
    }

    public final long getExternalAttributes() {
        return this.externalAttributes;
    }
}
