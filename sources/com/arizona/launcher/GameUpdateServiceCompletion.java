package com.arizona.launcher;

import com.arizona.launcher.updater.archive.orchestrator.ArchiveUpdateCheckDecision;
import com.arizona.launcher.updater.http.UpdateMetadataHttpResult;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: GameUpdateServiceFlow.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0003\u0005\u0006\u0007¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcom/arizona/launcher/GameUpdateServiceCompletion;", "", "Prepared", "MetadataFailed", "ServerEmpty", "Lcom/arizona/launcher/GameUpdateServiceCompletion$MetadataFailed;", "Lcom/arizona/launcher/GameUpdateServiceCompletion$Prepared;", "Lcom/arizona/launcher/GameUpdateServiceCompletion$ServerEmpty;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface GameUpdateServiceCompletion {

    /* compiled from: GameUpdateServiceFlow.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bÊ\u0001\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u0016"}, d2 = {"Lcom/arizona/launcher/GameUpdateServiceCompletion$Prepared;", "Lcom/arizona/launcher/GameUpdateServiceCompletion;", "successfully", "", "blockedCheck", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdateCheckDecision$Block;", "<init>", "(ZLcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdateCheckDecision$Block;)V", "getSuccessfully", "()Z", "getBlockedCheck", "()Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdateCheckDecision$Block;", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Prepared implements GameUpdateServiceCompletion {
        public static final int $stable = ArchiveUpdateCheckDecision.Block.$stable;
        private final ArchiveUpdateCheckDecision.Block blockedCheck;
        private final boolean successfully;

        public static /* synthetic */ Prepared copy$default(Prepared prepared, boolean z, ArchiveUpdateCheckDecision.Block block, int i, Object obj) {
            if ((i & 1) != 0) {
                z = prepared.successfully;
            }
            if ((i & 2) != 0) {
                block = prepared.blockedCheck;
            }
            return prepared.copy(z, block);
        }

        public final boolean component1() {
            return this.successfully;
        }

        public final ArchiveUpdateCheckDecision.Block component2() {
            return this.blockedCheck;
        }

        public final Prepared copy(boolean z, ArchiveUpdateCheckDecision.Block block) {
            return new Prepared(z, block);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Prepared) {
                Prepared prepared = (Prepared) obj;
                return this.successfully == prepared.successfully && Intrinsics.areEqual(this.blockedCheck, prepared.blockedCheck);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = Boolean.hashCode(this.successfully) * 31;
            ArchiveUpdateCheckDecision.Block block = this.blockedCheck;
            return hashCode + (block == null ? 0 : block.hashCode());
        }

        public String toString() {
            boolean z = this.successfully;
            return "Prepared(successfully=" + z + ", blockedCheck=" + this.blockedCheck + ")";
        }

        public Prepared(boolean z, ArchiveUpdateCheckDecision.Block block) {
            this.successfully = z;
            this.blockedCheck = block;
        }

        public /* synthetic */ Prepared(boolean z, ArchiveUpdateCheckDecision.Block block, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(z, (i & 2) != 0 ? null : block);
        }

        public final boolean getSuccessfully() {
            return this.successfully;
        }

        public final ArchiveUpdateCheckDecision.Block getBlockedCheck() {
            return this.blockedCheck;
        }
    }

    /* compiled from: GameUpdateServiceFlow.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bÊ\u0001\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u0016"}, d2 = {"Lcom/arizona/launcher/GameUpdateServiceCompletion$MetadataFailed;", "Lcom/arizona/launcher/GameUpdateServiceCompletion;", "failure", "Lcom/arizona/launcher/updater/http/UpdateMetadataHttpResult;", "failedServer", "", "<init>", "(Lcom/arizona/launcher/updater/http/UpdateMetadataHttpResult;Ljava/lang/String;)V", "getFailure", "()Lcom/arizona/launcher/updater/http/UpdateMetadataHttpResult;", "getFailedServer", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class MetadataFailed implements GameUpdateServiceCompletion {
        public static final int $stable = 8;
        private final String failedServer;
        private final UpdateMetadataHttpResult failure;

        public static /* synthetic */ MetadataFailed copy$default(MetadataFailed metadataFailed, UpdateMetadataHttpResult updateMetadataHttpResult, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                updateMetadataHttpResult = metadataFailed.failure;
            }
            if ((i & 2) != 0) {
                str = metadataFailed.failedServer;
            }
            return metadataFailed.copy(updateMetadataHttpResult, str);
        }

        public final UpdateMetadataHttpResult component1() {
            return this.failure;
        }

        public final String component2() {
            return this.failedServer;
        }

        public final MetadataFailed copy(UpdateMetadataHttpResult failure, String failedServer) {
            Intrinsics.checkNotNullParameter(failure, "failure");
            Intrinsics.checkNotNullParameter(failedServer, "failedServer");
            return new MetadataFailed(failure, failedServer);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof MetadataFailed) {
                MetadataFailed metadataFailed = (MetadataFailed) obj;
                return Intrinsics.areEqual(this.failure, metadataFailed.failure) && Intrinsics.areEqual(this.failedServer, metadataFailed.failedServer);
            }
            return false;
        }

        public int hashCode() {
            return (this.failure.hashCode() * 31) + this.failedServer.hashCode();
        }

        public String toString() {
            UpdateMetadataHttpResult updateMetadataHttpResult = this.failure;
            return "MetadataFailed(failure=" + updateMetadataHttpResult + ", failedServer=" + this.failedServer + ")";
        }

        public MetadataFailed(UpdateMetadataHttpResult failure, String failedServer) {
            Intrinsics.checkNotNullParameter(failure, "failure");
            Intrinsics.checkNotNullParameter(failedServer, "failedServer");
            this.failure = failure;
            this.failedServer = failedServer;
        }

        public final UpdateMetadataHttpResult getFailure() {
            return this.failure;
        }

        public final String getFailedServer() {
            return this.failedServer;
        }
    }

    /* compiled from: GameUpdateServiceFlow.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004Ê\u0001\f\b\r\u0012\b\b\u000e\u0012\u0004\b\u0003\u0010\u0002¨\u0006\f"}, d2 = {"Lcom/arizona/launcher/GameUpdateServiceCompletion$ServerEmpty;", "Lcom/arizona/launcher/GameUpdateServiceCompletion;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class ServerEmpty implements GameUpdateServiceCompletion {
        public static final int $stable = 0;
        public static final ServerEmpty INSTANCE = new ServerEmpty();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof ServerEmpty) {
                ServerEmpty serverEmpty = (ServerEmpty) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return 2017241503;
        }

        public String toString() {
            return "ServerEmpty";
        }

        private ServerEmpty() {
        }
    }
}
