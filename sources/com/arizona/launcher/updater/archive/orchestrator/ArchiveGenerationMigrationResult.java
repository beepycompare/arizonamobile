package com.arizona.launcher.updater.archive.orchestrator;

import com.arizona.launcher.updater.archive.orchestrator.ArchiveUpdateCheckDecision;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArchiveCrossLaneUpdateCheck.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0003\u0005\u0006\u0007¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveGenerationMigrationResult;", "", "NotRequired", "Prepared", "Blocked", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveGenerationMigrationResult$Blocked;", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveGenerationMigrationResult$NotRequired;", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveGenerationMigrationResult$Prepared;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface ArchiveGenerationMigrationResult {

    /* compiled from: ArchiveCrossLaneUpdateCheck.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004Ê\u0001\f\b\r\u0012\b\b\u000e\u0012\u0004\b\u0003\u0010\u0002¨\u0006\f"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveGenerationMigrationResult$NotRequired;", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveGenerationMigrationResult;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class NotRequired implements ArchiveGenerationMigrationResult {
        public static final int $stable = 0;
        public static final NotRequired INSTANCE = new NotRequired();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof NotRequired) {
                NotRequired notRequired = (NotRequired) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 1050652437;
        }

        public String toString() {
            return "NotRequired";
        }

        private NotRequired() {
        }
    }

    /* compiled from: ArchiveCrossLaneUpdateCheck.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004Ê\u0001\f\b\r\u0012\b\b\u000e\u0012\u0004\b\u0003\u0010\u0002¨\u0006\f"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveGenerationMigrationResult$Prepared;", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveGenerationMigrationResult;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Prepared implements ArchiveGenerationMigrationResult {
        public static final int $stable = 0;
        public static final Prepared INSTANCE = new Prepared();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Prepared) {
                Prepared prepared = (Prepared) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 959873946;
        }

        public String toString() {
            return "Prepared";
        }

        private Prepared() {
        }
    }

    /* compiled from: ArchiveCrossLaneUpdateCheck.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007Ê\u0001\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u0012"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveGenerationMigrationResult$Blocked;", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveGenerationMigrationResult;", "decision", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdateCheckDecision$Block;", "<init>", "(Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdateCheckDecision$Block;)V", "getDecision", "()Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdateCheckDecision$Block;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Blocked implements ArchiveGenerationMigrationResult {
        public static final int $stable = ArchiveUpdateCheckDecision.Block.$stable;
        private final ArchiveUpdateCheckDecision.Block decision;

        public static /* synthetic */ Blocked copy$default(Blocked blocked, ArchiveUpdateCheckDecision.Block block, int i, Object obj) {
            if ((i & 1) != 0) {
                block = blocked.decision;
            }
            return blocked.copy(block);
        }

        public final ArchiveUpdateCheckDecision.Block component1() {
            return this.decision;
        }

        public final Blocked copy(ArchiveUpdateCheckDecision.Block decision) {
            Intrinsics.checkNotNullParameter(decision, "decision");
            return new Blocked(decision);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Blocked) && Intrinsics.areEqual(this.decision, ((Blocked) obj).decision);
        }

        public int hashCode() {
            return this.decision.hashCode();
        }

        public String toString() {
            return "Blocked(decision=" + this.decision + ")";
        }

        public Blocked(ArchiveUpdateCheckDecision.Block decision) {
            Intrinsics.checkNotNullParameter(decision, "decision");
            this.decision = decision;
        }

        public final ArchiveUpdateCheckDecision.Block getDecision() {
            return this.decision;
        }
    }
}
