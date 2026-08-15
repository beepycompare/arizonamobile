package com.arizona.launcher.updater.archive.transaction;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArchiveOwnershipDiff.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bÊ\u0001\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0013"}, d2 = {"Lcom/arizona/launcher/updater/archive/transaction/ArchiveOwnedPath;", "", "packageId", "", "relativePath", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getPackageId", "()Ljava/lang/String;", "getRelativePath", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveOwnedPath {
    public static final int $stable = 0;
    private final String packageId;
    private final String relativePath;

    public static /* synthetic */ ArchiveOwnedPath copy$default(ArchiveOwnedPath archiveOwnedPath, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = archiveOwnedPath.packageId;
        }
        if ((i & 2) != 0) {
            str2 = archiveOwnedPath.relativePath;
        }
        return archiveOwnedPath.copy(str, str2);
    }

    public final String component1() {
        return this.packageId;
    }

    public final String component2() {
        return this.relativePath;
    }

    public final ArchiveOwnedPath copy(String packageId, String relativePath) {
        Intrinsics.checkNotNullParameter(packageId, "packageId");
        Intrinsics.checkNotNullParameter(relativePath, "relativePath");
        return new ArchiveOwnedPath(packageId, relativePath);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ArchiveOwnedPath) {
            ArchiveOwnedPath archiveOwnedPath = (ArchiveOwnedPath) obj;
            return Intrinsics.areEqual(this.packageId, archiveOwnedPath.packageId) && Intrinsics.areEqual(this.relativePath, archiveOwnedPath.relativePath);
        }
        return false;
    }

    public int hashCode() {
        return (this.packageId.hashCode() * 31) + this.relativePath.hashCode();
    }

    public String toString() {
        String str = this.packageId;
        return "ArchiveOwnedPath(packageId=" + str + ", relativePath=" + this.relativePath + ")";
    }

    public ArchiveOwnedPath(String packageId, String relativePath) {
        Intrinsics.checkNotNullParameter(packageId, "packageId");
        Intrinsics.checkNotNullParameter(relativePath, "relativePath");
        this.packageId = packageId;
        this.relativePath = relativePath;
    }

    public final String getPackageId() {
        return this.packageId;
    }

    public final String getRelativePath() {
        return this.relativePath;
    }
}
