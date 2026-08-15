package com.arizona.launcher.updater.archive.orchestrator;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArchiveStateMaintenance.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveMetadataFinalizationResult;", "", "Success", "Blocked", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveMetadataFinalizationResult$Blocked;", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveMetadataFinalizationResult$Success;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface ArchiveMetadataFinalizationResult {

    /* compiled from: ArchiveStateMaintenance.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004Ê\u0001\f\b\r\u0012\b\b\u000e\u0012\u0004\b\u0003\u0010\u0002¨\u0006\f"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveMetadataFinalizationResult$Success;", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveMetadataFinalizationResult;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Success implements ArchiveMetadataFinalizationResult {
        public static final int $stable = 0;
        public static final Success INSTANCE = new Success();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Success) {
                Success success = (Success) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -153124751;
        }

        public String toString() {
            return "Success";
        }

        private Success() {
        }
    }

    /* compiled from: ArchiveStateMaintenance.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bÊ\u0001\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0016"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveMetadataFinalizationResult$Blocked;", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveMetadataFinalizationResult;", "reason", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveMetadataFinalizationBlockReason;", "detail", "", "<init>", "(Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveMetadataFinalizationBlockReason;Ljava/lang/String;)V", "getReason", "()Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveMetadataFinalizationBlockReason;", "getDetail", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Blocked implements ArchiveMetadataFinalizationResult {
        public static final int $stable = 0;
        private final String detail;
        private final ArchiveMetadataFinalizationBlockReason reason;

        public static /* synthetic */ Blocked copy$default(Blocked blocked, ArchiveMetadataFinalizationBlockReason archiveMetadataFinalizationBlockReason, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                archiveMetadataFinalizationBlockReason = blocked.reason;
            }
            if ((i & 2) != 0) {
                str = blocked.detail;
            }
            return blocked.copy(archiveMetadataFinalizationBlockReason, str);
        }

        public final ArchiveMetadataFinalizationBlockReason component1() {
            return this.reason;
        }

        public final String component2() {
            return this.detail;
        }

        public final Blocked copy(ArchiveMetadataFinalizationBlockReason reason, String detail) {
            Intrinsics.checkNotNullParameter(reason, "reason");
            Intrinsics.checkNotNullParameter(detail, "detail");
            return new Blocked(reason, detail);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Blocked) {
                Blocked blocked = (Blocked) obj;
                return this.reason == blocked.reason && Intrinsics.areEqual(this.detail, blocked.detail);
            }
            return false;
        }

        public int hashCode() {
            return (this.reason.hashCode() * 31) + this.detail.hashCode();
        }

        public String toString() {
            ArchiveMetadataFinalizationBlockReason archiveMetadataFinalizationBlockReason = this.reason;
            return "Blocked(reason=" + archiveMetadataFinalizationBlockReason + ", detail=" + this.detail + ")";
        }

        public Blocked(ArchiveMetadataFinalizationBlockReason reason, String detail) {
            Intrinsics.checkNotNullParameter(reason, "reason");
            Intrinsics.checkNotNullParameter(detail, "detail");
            this.reason = reason;
            this.detail = detail;
        }

        public final ArchiveMetadataFinalizationBlockReason getReason() {
            return this.reason;
        }

        public final String getDetail() {
            return this.detail;
        }
    }
}
