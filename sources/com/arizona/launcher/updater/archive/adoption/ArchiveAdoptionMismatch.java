package com.arizona.launcher.updater.archive.adoption;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArchiveInstallAdopter.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J)\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004J\n\u0010\u0017\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rÊ\u0001\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0018"}, d2 = {"Lcom/arizona/launcher/updater/archive/adoption/ArchiveAdoptionMismatch;", "", "packageId", "", "relativePath", "reason", "Lcom/arizona/launcher/updater/archive/adoption/ArchiveAdoptionMismatchReason;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/arizona/launcher/updater/archive/adoption/ArchiveAdoptionMismatchReason;)V", "getPackageId", "()Ljava/lang/String;", "getRelativePath", "getReason", "()Lcom/arizona/launcher/updater/archive/adoption/ArchiveAdoptionMismatchReason;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveAdoptionMismatch {
    public static final int $stable = 0;
    private final String packageId;
    private final ArchiveAdoptionMismatchReason reason;
    private final String relativePath;

    public static /* synthetic */ ArchiveAdoptionMismatch copy$default(ArchiveAdoptionMismatch archiveAdoptionMismatch, String str, String str2, ArchiveAdoptionMismatchReason archiveAdoptionMismatchReason, int i, Object obj) {
        if ((i & 1) != 0) {
            str = archiveAdoptionMismatch.packageId;
        }
        if ((i & 2) != 0) {
            str2 = archiveAdoptionMismatch.relativePath;
        }
        if ((i & 4) != 0) {
            archiveAdoptionMismatchReason = archiveAdoptionMismatch.reason;
        }
        return archiveAdoptionMismatch.copy(str, str2, archiveAdoptionMismatchReason);
    }

    public final String component1() {
        return this.packageId;
    }

    public final String component2() {
        return this.relativePath;
    }

    public final ArchiveAdoptionMismatchReason component3() {
        return this.reason;
    }

    public final ArchiveAdoptionMismatch copy(String packageId, String str, ArchiveAdoptionMismatchReason reason) {
        Intrinsics.checkNotNullParameter(packageId, "packageId");
        Intrinsics.checkNotNullParameter(reason, "reason");
        return new ArchiveAdoptionMismatch(packageId, str, reason);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ArchiveAdoptionMismatch) {
            ArchiveAdoptionMismatch archiveAdoptionMismatch = (ArchiveAdoptionMismatch) obj;
            return Intrinsics.areEqual(this.packageId, archiveAdoptionMismatch.packageId) && Intrinsics.areEqual(this.relativePath, archiveAdoptionMismatch.relativePath) && this.reason == archiveAdoptionMismatch.reason;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.packageId.hashCode() * 31;
        String str = this.relativePath;
        return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.reason.hashCode();
    }

    public String toString() {
        String str = this.packageId;
        String str2 = this.relativePath;
        return "ArchiveAdoptionMismatch(packageId=" + str + ", relativePath=" + str2 + ", reason=" + this.reason + ")";
    }

    public ArchiveAdoptionMismatch(String packageId, String str, ArchiveAdoptionMismatchReason reason) {
        Intrinsics.checkNotNullParameter(packageId, "packageId");
        Intrinsics.checkNotNullParameter(reason, "reason");
        this.packageId = packageId;
        this.relativePath = str;
        this.reason = reason;
    }

    public final String getPackageId() {
        return this.packageId;
    }

    public final String getRelativePath() {
        return this.relativePath;
    }

    public final ArchiveAdoptionMismatchReason getReason() {
        return this.reason;
    }
}
