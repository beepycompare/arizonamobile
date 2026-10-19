package com.arizona.launcher.updater.archive.orchestrator;

import com.arizona.launcher.updater.archive.model.ArchiveManifest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArchiveUpdateCheckCoordinator.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdateCheckRemoteStage;", "", "Resolved", "Completed", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdateCheckRemoteStage$Completed;", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdateCheckRemoteStage$Resolved;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface ArchiveUpdateCheckRemoteStage {

    /* compiled from: ArchiveUpdateCheckCoordinator.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007Ê\u0001\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u0012"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdateCheckRemoteStage$Resolved;", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdateCheckRemoteStage;", "remote", "Lcom/arizona/launcher/updater/archive/model/ArchiveManifest;", "<init>", "(Lcom/arizona/launcher/updater/archive/model/ArchiveManifest;)V", "getRemote", "()Lcom/arizona/launcher/updater/archive/model/ArchiveManifest;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Resolved implements ArchiveUpdateCheckRemoteStage {
        public static final int $stable = ArchiveManifest.$stable;
        private final ArchiveManifest remote;

        public static /* synthetic */ Resolved copy$default(Resolved resolved, ArchiveManifest archiveManifest, int i, Object obj) {
            if ((i & 1) != 0) {
                archiveManifest = resolved.remote;
            }
            return resolved.copy(archiveManifest);
        }

        public final ArchiveManifest component1() {
            return this.remote;
        }

        public final Resolved copy(ArchiveManifest remote) {
            Intrinsics.checkNotNullParameter(remote, "remote");
            return new Resolved(remote);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Resolved) && Intrinsics.areEqual(this.remote, ((Resolved) obj).remote);
        }

        public int hashCode() {
            return this.remote.hashCode();
        }

        public String toString() {
            return "Resolved(remote=" + this.remote + ")";
        }

        public Resolved(ArchiveManifest remote) {
            Intrinsics.checkNotNullParameter(remote, "remote");
            this.remote = remote;
        }

        public final ArchiveManifest getRemote() {
            return this.remote;
        }
    }

    /* compiled from: ArchiveUpdateCheckCoordinator.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007Ê\u0001\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u0012"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdateCheckRemoteStage$Completed;", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdateCheckRemoteStage;", "decision", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdateCheckDecision;", "<init>", "(Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdateCheckDecision;)V", "getDecision", "()Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdateCheckDecision;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Completed implements ArchiveUpdateCheckRemoteStage {
        public static final int $stable = 8;
        private final ArchiveUpdateCheckDecision decision;

        public static /* synthetic */ Completed copy$default(Completed completed, ArchiveUpdateCheckDecision archiveUpdateCheckDecision, int i, Object obj) {
            if ((i & 1) != 0) {
                archiveUpdateCheckDecision = completed.decision;
            }
            return completed.copy(archiveUpdateCheckDecision);
        }

        public final ArchiveUpdateCheckDecision component1() {
            return this.decision;
        }

        public final Completed copy(ArchiveUpdateCheckDecision decision) {
            Intrinsics.checkNotNullParameter(decision, "decision");
            return new Completed(decision);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Completed) && Intrinsics.areEqual(this.decision, ((Completed) obj).decision);
        }

        public int hashCode() {
            return this.decision.hashCode();
        }

        public String toString() {
            return "Completed(decision=" + this.decision + ")";
        }

        public Completed(ArchiveUpdateCheckDecision decision) {
            Intrinsics.checkNotNullParameter(decision, "decision");
            this.decision = decision;
        }

        public final ArchiveUpdateCheckDecision getDecision() {
            return this.decision;
        }
    }
}
