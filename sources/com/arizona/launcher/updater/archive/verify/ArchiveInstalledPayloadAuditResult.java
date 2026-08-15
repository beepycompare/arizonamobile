package com.arizona.launcher.updater.archive.verify;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArchiveInstalledPayloadAuditor.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0081\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u001f\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0006HÆ\u0003J%\u0010\u0012\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0014\u0010\u0013\u001a\u00020\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004J\n\u0010\u0017\u001a\u00020\u0004HÖ\u0081\u0004R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000fÊ\u0001\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u0019"}, d2 = {"Lcom/arizona/launcher/updater/archive/verify/ArchiveInstalledPayloadAuditResult;", "", "mismatchedPackageIds", "", "", "firstMismatch", "Lcom/arizona/launcher/updater/archive/verify/ArchiveInstalledPayloadMismatch;", "<init>", "(Ljava/util/List;Lcom/arizona/launcher/updater/archive/verify/ArchiveInstalledPayloadMismatch;)V", "getMismatchedPackageIds", "()Ljava/util/List;", "getFirstMismatch", "()Lcom/arizona/launcher/updater/archive/verify/ArchiveInstalledPayloadMismatch;", "isValid", "", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveInstalledPayloadAuditResult {
    private final ArchiveInstalledPayloadMismatch firstMismatch;
    private final List<String> mismatchedPackageIds;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final ArchiveInstalledPayloadAuditResult VALID = new ArchiveInstalledPayloadAuditResult(CollectionsKt.emptyList(), null);

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ArchiveInstalledPayloadAuditResult copy$default(ArchiveInstalledPayloadAuditResult archiveInstalledPayloadAuditResult, List list, ArchiveInstalledPayloadMismatch archiveInstalledPayloadMismatch, int i, Object obj) {
        if ((i & 1) != 0) {
            list = archiveInstalledPayloadAuditResult.mismatchedPackageIds;
        }
        if ((i & 2) != 0) {
            archiveInstalledPayloadMismatch = archiveInstalledPayloadAuditResult.firstMismatch;
        }
        return archiveInstalledPayloadAuditResult.copy(list, archiveInstalledPayloadMismatch);
    }

    public final List<String> component1() {
        return this.mismatchedPackageIds;
    }

    public final ArchiveInstalledPayloadMismatch component2() {
        return this.firstMismatch;
    }

    public final ArchiveInstalledPayloadAuditResult copy(List<String> mismatchedPackageIds, ArchiveInstalledPayloadMismatch archiveInstalledPayloadMismatch) {
        Intrinsics.checkNotNullParameter(mismatchedPackageIds, "mismatchedPackageIds");
        return new ArchiveInstalledPayloadAuditResult(mismatchedPackageIds, archiveInstalledPayloadMismatch);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ArchiveInstalledPayloadAuditResult) {
            ArchiveInstalledPayloadAuditResult archiveInstalledPayloadAuditResult = (ArchiveInstalledPayloadAuditResult) obj;
            return Intrinsics.areEqual(this.mismatchedPackageIds, archiveInstalledPayloadAuditResult.mismatchedPackageIds) && Intrinsics.areEqual(this.firstMismatch, archiveInstalledPayloadAuditResult.firstMismatch);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.mismatchedPackageIds.hashCode() * 31;
        ArchiveInstalledPayloadMismatch archiveInstalledPayloadMismatch = this.firstMismatch;
        return hashCode + (archiveInstalledPayloadMismatch == null ? 0 : archiveInstalledPayloadMismatch.hashCode());
    }

    public String toString() {
        List<String> list = this.mismatchedPackageIds;
        return "ArchiveInstalledPayloadAuditResult(mismatchedPackageIds=" + list + ", firstMismatch=" + this.firstMismatch + ")";
    }

    public ArchiveInstalledPayloadAuditResult(List<String> mismatchedPackageIds, ArchiveInstalledPayloadMismatch archiveInstalledPayloadMismatch) {
        Intrinsics.checkNotNullParameter(mismatchedPackageIds, "mismatchedPackageIds");
        this.mismatchedPackageIds = mismatchedPackageIds;
        this.firstMismatch = archiveInstalledPayloadMismatch;
        if (mismatchedPackageIds.isEmpty() != (archiveInstalledPayloadMismatch == null)) {
            throw new IllegalArgumentException("firstMismatch must be present exactly when mismatchedPackageIds is non-empty".toString());
        }
    }

    public final List<String> getMismatchedPackageIds() {
        return this.mismatchedPackageIds;
    }

    public final ArchiveInstalledPayloadMismatch getFirstMismatch() {
        return this.firstMismatch;
    }

    public final boolean isValid() {
        return this.mismatchedPackageIds.isEmpty();
    }

    /* compiled from: ArchiveInstalledPayloadAuditor.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/arizona/launcher/updater/archive/verify/ArchiveInstalledPayloadAuditResult$Companion;", "", "<init>", "()V", "VALID", "Lcom/arizona/launcher/updater/archive/verify/ArchiveInstalledPayloadAuditResult;", "getVALID", "()Lcom/arizona/launcher/updater/archive/verify/ArchiveInstalledPayloadAuditResult;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ArchiveInstalledPayloadAuditResult getVALID() {
            return ArchiveInstalledPayloadAuditResult.VALID;
        }
    }
}
