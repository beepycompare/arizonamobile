package com.arizona.launcher.updater.archive.orchestrator;

import com.arizona.launcher.updater.archive.verify.ArchiveInstalledPayloadMismatch;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArchiveStateMaintenance.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0003\u0005\u0006\u0007¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchivePayloadAuditResult;", "", "Valid", "RepairScheduled", "Unavailable", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchivePayloadAuditResult$RepairScheduled;", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchivePayloadAuditResult$Unavailable;", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchivePayloadAuditResult$Valid;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface ArchivePayloadAuditResult {

    /* compiled from: ArchiveStateMaintenance.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004Ê\u0001\f\b\r\u0012\b\b\u000e\u0012\u0004\b\u0003\u0010\u0002¨\u0006\f"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchivePayloadAuditResult$Valid;", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchivePayloadAuditResult;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Valid implements ArchivePayloadAuditResult {
        public static final int $stable = 0;
        public static final Valid INSTANCE = new Valid();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Valid) {
                Valid valid = (Valid) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 1872743898;
        }

        public String toString() {
            return "Valid";
        }

        private Valid() {
        }
    }

    /* compiled from: ArchiveStateMaintenance.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0006HÆ\u0003J%\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0083\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0004HÖ\u0081\u0004R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fÊ\u0001\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u0017"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchivePayloadAuditResult$RepairScheduled;", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchivePayloadAuditResult;", "mismatchedPackageIds", "", "", "firstMismatch", "Lcom/arizona/launcher/updater/archive/verify/ArchiveInstalledPayloadMismatch;", "<init>", "(Ljava/util/List;Lcom/arizona/launcher/updater/archive/verify/ArchiveInstalledPayloadMismatch;)V", "getMismatchedPackageIds", "()Ljava/util/List;", "getFirstMismatch", "()Lcom/arizona/launcher/updater/archive/verify/ArchiveInstalledPayloadMismatch;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class RepairScheduled implements ArchivePayloadAuditResult {
        public static final int $stable = ArchiveInstalledPayloadMismatch.$stable;
        private final ArchiveInstalledPayloadMismatch firstMismatch;
        private final List<String> mismatchedPackageIds;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ RepairScheduled copy$default(RepairScheduled repairScheduled, List list, ArchiveInstalledPayloadMismatch archiveInstalledPayloadMismatch, int i, Object obj) {
            if ((i & 1) != 0) {
                list = repairScheduled.mismatchedPackageIds;
            }
            if ((i & 2) != 0) {
                archiveInstalledPayloadMismatch = repairScheduled.firstMismatch;
            }
            return repairScheduled.copy(list, archiveInstalledPayloadMismatch);
        }

        public final List<String> component1() {
            return this.mismatchedPackageIds;
        }

        public final ArchiveInstalledPayloadMismatch component2() {
            return this.firstMismatch;
        }

        public final RepairScheduled copy(List<String> mismatchedPackageIds, ArchiveInstalledPayloadMismatch archiveInstalledPayloadMismatch) {
            Intrinsics.checkNotNullParameter(mismatchedPackageIds, "mismatchedPackageIds");
            return new RepairScheduled(mismatchedPackageIds, archiveInstalledPayloadMismatch);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof RepairScheduled) {
                RepairScheduled repairScheduled = (RepairScheduled) obj;
                return Intrinsics.areEqual(this.mismatchedPackageIds, repairScheduled.mismatchedPackageIds) && Intrinsics.areEqual(this.firstMismatch, repairScheduled.firstMismatch);
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
            return "RepairScheduled(mismatchedPackageIds=" + list + ", firstMismatch=" + this.firstMismatch + ")";
        }

        public RepairScheduled(List<String> mismatchedPackageIds, ArchiveInstalledPayloadMismatch archiveInstalledPayloadMismatch) {
            Intrinsics.checkNotNullParameter(mismatchedPackageIds, "mismatchedPackageIds");
            this.mismatchedPackageIds = mismatchedPackageIds;
            this.firstMismatch = archiveInstalledPayloadMismatch;
        }

        public final List<String> getMismatchedPackageIds() {
            return this.mismatchedPackageIds;
        }

        public final ArchiveInstalledPayloadMismatch getFirstMismatch() {
            return this.firstMismatch;
        }
    }

    /* compiled from: ArchiveStateMaintenance.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007Ê\u0001\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0012"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchivePayloadAuditResult$Unavailable;", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchivePayloadAuditResult;", "reason", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchivePayloadAuditUnavailableReason;", "<init>", "(Lcom/arizona/launcher/updater/archive/orchestrator/ArchivePayloadAuditUnavailableReason;)V", "getReason", "()Lcom/arizona/launcher/updater/archive/orchestrator/ArchivePayloadAuditUnavailableReason;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Unavailable implements ArchivePayloadAuditResult {
        public static final int $stable = 0;
        private final ArchivePayloadAuditUnavailableReason reason;

        public static /* synthetic */ Unavailable copy$default(Unavailable unavailable, ArchivePayloadAuditUnavailableReason archivePayloadAuditUnavailableReason, int i, Object obj) {
            if ((i & 1) != 0) {
                archivePayloadAuditUnavailableReason = unavailable.reason;
            }
            return unavailable.copy(archivePayloadAuditUnavailableReason);
        }

        public final ArchivePayloadAuditUnavailableReason component1() {
            return this.reason;
        }

        public final Unavailable copy(ArchivePayloadAuditUnavailableReason reason) {
            Intrinsics.checkNotNullParameter(reason, "reason");
            return new Unavailable(reason);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Unavailable) && this.reason == ((Unavailable) obj).reason;
        }

        public int hashCode() {
            return this.reason.hashCode();
        }

        public String toString() {
            return "Unavailable(reason=" + this.reason + ")";
        }

        public Unavailable(ArchivePayloadAuditUnavailableReason reason) {
            Intrinsics.checkNotNullParameter(reason, "reason");
            this.reason = reason;
        }

        public final ArchivePayloadAuditUnavailableReason getReason() {
            return this.reason;
        }
    }
}
