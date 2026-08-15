package com.arizona.launcher.updater.archive.orchestrator;

import com.arizona.launcher.updater.archive.planner.ArchiveUpdatePlan;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArchiveUpdateCheckCoordinator.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdateCheckDecision;", "", "UseArchive", "Block", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdateCheckDecision$Block;", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdateCheckDecision$UseArchive;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface ArchiveUpdateCheckDecision {

    /* compiled from: ArchiveUpdateCheckCoordinator.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0019\u001a\u00020\tHÆ\u0003J1\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0014\u0010\u001b\u001a\u00020\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0083\u0004J\n\u0010\u001e\u001a\u00020\u001fHÖ\u0081\u0004J\n\u0010 \u001a\u00020!HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u000fÊ\u0001\f\b#\u0012\b\b$\u0012\u0004\b\u0003\u0010\u0000¨\u0006\""}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdateCheckDecision$UseArchive;", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdateCheckDecision;", "plan", "Lcom/arizona/launcher/updater/archive/planner/ArchiveUpdatePlan;", "downloadBytes", "", "storageRequirements", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveStorageRequirements;", "requiresFinalization", "", "<init>", "(Lcom/arizona/launcher/updater/archive/planner/ArchiveUpdatePlan;JLcom/arizona/launcher/updater/archive/orchestrator/ArchiveStorageRequirements;Z)V", "getPlan", "()Lcom/arizona/launcher/updater/archive/planner/ArchiveUpdatePlan;", "getDownloadBytes", "()J", "getStorageRequirements", "()Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveStorageRequirements;", "getRequiresFinalization", "()Z", "requiredFreeSpaceBytes", "getRequiredFreeSpaceBytes", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class UseArchive implements ArchiveUpdateCheckDecision {
        public static final int $stable = ArchiveStorageRequirements.$stable | ArchiveUpdatePlan.$stable;
        private final long downloadBytes;
        private final ArchiveUpdatePlan plan;
        private final boolean requiresFinalization;
        private final ArchiveStorageRequirements storageRequirements;

        public static /* synthetic */ UseArchive copy$default(UseArchive useArchive, ArchiveUpdatePlan archiveUpdatePlan, long j, ArchiveStorageRequirements archiveStorageRequirements, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                archiveUpdatePlan = useArchive.plan;
            }
            if ((i & 2) != 0) {
                j = useArchive.downloadBytes;
            }
            if ((i & 4) != 0) {
                archiveStorageRequirements = useArchive.storageRequirements;
            }
            if ((i & 8) != 0) {
                z = useArchive.requiresFinalization;
            }
            return useArchive.copy(archiveUpdatePlan, j, archiveStorageRequirements, z);
        }

        public final ArchiveUpdatePlan component1() {
            return this.plan;
        }

        public final long component2() {
            return this.downloadBytes;
        }

        public final ArchiveStorageRequirements component3() {
            return this.storageRequirements;
        }

        public final boolean component4() {
            return this.requiresFinalization;
        }

        public final UseArchive copy(ArchiveUpdatePlan plan, long j, ArchiveStorageRequirements storageRequirements, boolean z) {
            Intrinsics.checkNotNullParameter(plan, "plan");
            Intrinsics.checkNotNullParameter(storageRequirements, "storageRequirements");
            return new UseArchive(plan, j, storageRequirements, z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof UseArchive) {
                UseArchive useArchive = (UseArchive) obj;
                return Intrinsics.areEqual(this.plan, useArchive.plan) && this.downloadBytes == useArchive.downloadBytes && Intrinsics.areEqual(this.storageRequirements, useArchive.storageRequirements) && this.requiresFinalization == useArchive.requiresFinalization;
            }
            return false;
        }

        public int hashCode() {
            return (((((this.plan.hashCode() * 31) + Long.hashCode(this.downloadBytes)) * 31) + this.storageRequirements.hashCode()) * 31) + Boolean.hashCode(this.requiresFinalization);
        }

        public String toString() {
            ArchiveUpdatePlan archiveUpdatePlan = this.plan;
            long j = this.downloadBytes;
            ArchiveStorageRequirements archiveStorageRequirements = this.storageRequirements;
            return "UseArchive(plan=" + archiveUpdatePlan + ", downloadBytes=" + j + ", storageRequirements=" + archiveStorageRequirements + ", requiresFinalization=" + this.requiresFinalization + ")";
        }

        public UseArchive(ArchiveUpdatePlan plan, long j, ArchiveStorageRequirements storageRequirements, boolean z) {
            Intrinsics.checkNotNullParameter(plan, "plan");
            Intrinsics.checkNotNullParameter(storageRequirements, "storageRequirements");
            this.plan = plan;
            this.downloadBytes = j;
            this.storageRequirements = storageRequirements;
            this.requiresFinalization = z;
        }

        public /* synthetic */ UseArchive(ArchiveUpdatePlan archiveUpdatePlan, long j, ArchiveStorageRequirements archiveStorageRequirements, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(archiveUpdatePlan, j, archiveStorageRequirements, (i & 8) != 0 ? false : z);
        }

        public final ArchiveUpdatePlan getPlan() {
            return this.plan;
        }

        public final long getDownloadBytes() {
            return this.downloadBytes;
        }

        public final ArchiveStorageRequirements getStorageRequirements() {
            return this.storageRequirements;
        }

        public final boolean getRequiresFinalization() {
            return this.requiresFinalization;
        }

        public final long getRequiredFreeSpaceBytes() {
            return this.storageRequirements.getCombinedBytes();
        }
    }

    /* compiled from: ArchiveUpdateCheckCoordinator.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bÊ\u0001\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0016"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdateCheckDecision$Block;", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdateCheckDecision;", "code", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdateCheckBlockCode;", "detail", "", "<init>", "(Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdateCheckBlockCode;Ljava/lang/String;)V", "getCode", "()Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdateCheckBlockCode;", "getDetail", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Block implements ArchiveUpdateCheckDecision {
        public static final int $stable = 0;
        private final ArchiveUpdateCheckBlockCode code;
        private final String detail;

        public static /* synthetic */ Block copy$default(Block block, ArchiveUpdateCheckBlockCode archiveUpdateCheckBlockCode, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                archiveUpdateCheckBlockCode = block.code;
            }
            if ((i & 2) != 0) {
                str = block.detail;
            }
            return block.copy(archiveUpdateCheckBlockCode, str);
        }

        public final ArchiveUpdateCheckBlockCode component1() {
            return this.code;
        }

        public final String component2() {
            return this.detail;
        }

        public final Block copy(ArchiveUpdateCheckBlockCode code, String str) {
            Intrinsics.checkNotNullParameter(code, "code");
            return new Block(code, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Block) {
                Block block = (Block) obj;
                return this.code == block.code && Intrinsics.areEqual(this.detail, block.detail);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.code.hashCode() * 31;
            String str = this.detail;
            return hashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            ArchiveUpdateCheckBlockCode archiveUpdateCheckBlockCode = this.code;
            return "Block(code=" + archiveUpdateCheckBlockCode + ", detail=" + this.detail + ")";
        }

        public Block(ArchiveUpdateCheckBlockCode code, String str) {
            Intrinsics.checkNotNullParameter(code, "code");
            this.code = code;
            this.detail = str;
        }

        public /* synthetic */ Block(ArchiveUpdateCheckBlockCode archiveUpdateCheckBlockCode, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(archiveUpdateCheckBlockCode, (i & 2) != 0 ? null : str);
        }

        public final ArchiveUpdateCheckBlockCode getCode() {
            return this.code;
        }

        public final String getDetail() {
            return this.detail;
        }
    }
}
