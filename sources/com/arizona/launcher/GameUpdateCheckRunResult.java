package com.arizona.launcher;

import com.arizona.launcher.updater.archive.orchestrator.ArchiveUpdateCheckDecision;
import com.arizona.launcher.updater.http.UpdateMetadataHttpResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: GameUpdateCheckRunner.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0004\u0002\u0003\u0004\u0005\u0082\u0001\u0004\u0006\u0007\b\t¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lcom/arizona/launcher/GameUpdateCheckRunResult;", "", "Prepared", "MetadataFailed", "ServerEmpty", "Stale", "Lcom/arizona/launcher/GameUpdateCheckRunResult$MetadataFailed;", "Lcom/arizona/launcher/GameUpdateCheckRunResult$Prepared;", "Lcom/arizona/launcher/GameUpdateCheckRunResult$ServerEmpty;", "Lcom/arizona/launcher/GameUpdateCheckRunResult$Stale;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface GameUpdateCheckRunResult {

    /* compiled from: GameUpdateCheckRunner.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bÊ\u0001\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u0016"}, d2 = {"Lcom/arizona/launcher/GameUpdateCheckRunResult$Prepared;", "Lcom/arizona/launcher/GameUpdateCheckRunResult;", "server", "", "decision", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdateCheckDecision;", "<init>", "(Ljava/lang/String;Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdateCheckDecision;)V", "getServer", "()Ljava/lang/String;", "getDecision", "()Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdateCheckDecision;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Prepared implements GameUpdateCheckRunResult {
        public static final int $stable = 8;
        private final ArchiveUpdateCheckDecision decision;
        private final String server;

        public static /* synthetic */ Prepared copy$default(Prepared prepared, String str, ArchiveUpdateCheckDecision archiveUpdateCheckDecision, int i, Object obj) {
            if ((i & 1) != 0) {
                str = prepared.server;
            }
            if ((i & 2) != 0) {
                archiveUpdateCheckDecision = prepared.decision;
            }
            return prepared.copy(str, archiveUpdateCheckDecision);
        }

        public final String component1() {
            return this.server;
        }

        public final ArchiveUpdateCheckDecision component2() {
            return this.decision;
        }

        public final Prepared copy(String server, ArchiveUpdateCheckDecision decision) {
            Intrinsics.checkNotNullParameter(server, "server");
            Intrinsics.checkNotNullParameter(decision, "decision");
            return new Prepared(server, decision);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Prepared) {
                Prepared prepared = (Prepared) obj;
                return Intrinsics.areEqual(this.server, prepared.server) && Intrinsics.areEqual(this.decision, prepared.decision);
            }
            return false;
        }

        public int hashCode() {
            return (this.server.hashCode() * 31) + this.decision.hashCode();
        }

        public String toString() {
            String str = this.server;
            return "Prepared(server=" + str + ", decision=" + this.decision + ")";
        }

        public Prepared(String server, ArchiveUpdateCheckDecision decision) {
            Intrinsics.checkNotNullParameter(server, "server");
            Intrinsics.checkNotNullParameter(decision, "decision");
            this.server = server;
            this.decision = decision;
        }

        public final String getServer() {
            return this.server;
        }

        public final ArchiveUpdateCheckDecision getDecision() {
            return this.decision;
        }
    }

    /* compiled from: GameUpdateCheckRunner.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bÊ\u0001\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u0016"}, d2 = {"Lcom/arizona/launcher/GameUpdateCheckRunResult$MetadataFailed;", "Lcom/arizona/launcher/GameUpdateCheckRunResult;", "server", "", "failure", "Lcom/arizona/launcher/updater/http/UpdateMetadataHttpResult;", "<init>", "(Ljava/lang/String;Lcom/arizona/launcher/updater/http/UpdateMetadataHttpResult;)V", "getServer", "()Ljava/lang/String;", "getFailure", "()Lcom/arizona/launcher/updater/http/UpdateMetadataHttpResult;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class MetadataFailed implements GameUpdateCheckRunResult {
        public static final int $stable = 8;
        private final UpdateMetadataHttpResult failure;
        private final String server;

        public static /* synthetic */ MetadataFailed copy$default(MetadataFailed metadataFailed, String str, UpdateMetadataHttpResult updateMetadataHttpResult, int i, Object obj) {
            if ((i & 1) != 0) {
                str = metadataFailed.server;
            }
            if ((i & 2) != 0) {
                updateMetadataHttpResult = metadataFailed.failure;
            }
            return metadataFailed.copy(str, updateMetadataHttpResult);
        }

        public final String component1() {
            return this.server;
        }

        public final UpdateMetadataHttpResult component2() {
            return this.failure;
        }

        public final MetadataFailed copy(String server, UpdateMetadataHttpResult failure) {
            Intrinsics.checkNotNullParameter(server, "server");
            Intrinsics.checkNotNullParameter(failure, "failure");
            return new MetadataFailed(server, failure);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof MetadataFailed) {
                MetadataFailed metadataFailed = (MetadataFailed) obj;
                return Intrinsics.areEqual(this.server, metadataFailed.server) && Intrinsics.areEqual(this.failure, metadataFailed.failure);
            }
            return false;
        }

        public int hashCode() {
            return (this.server.hashCode() * 31) + this.failure.hashCode();
        }

        public String toString() {
            String str = this.server;
            return "MetadataFailed(server=" + str + ", failure=" + this.failure + ")";
        }

        public MetadataFailed(String server, UpdateMetadataHttpResult failure) {
            Intrinsics.checkNotNullParameter(server, "server");
            Intrinsics.checkNotNullParameter(failure, "failure");
            this.server = server;
            this.failure = failure;
        }

        public final String getServer() {
            return this.server;
        }

        public final UpdateMetadataHttpResult getFailure() {
            return this.failure;
        }
    }

    /* compiled from: GameUpdateCheckRunner.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004Ê\u0001\f\b\r\u0012\b\b\u000e\u0012\u0004\b\u0003\u0010\u0002¨\u0006\f"}, d2 = {"Lcom/arizona/launcher/GameUpdateCheckRunResult$ServerEmpty;", "Lcom/arizona/launcher/GameUpdateCheckRunResult;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class ServerEmpty implements GameUpdateCheckRunResult {
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
            return 1913917034;
        }

        public String toString() {
            return "ServerEmpty";
        }

        private ServerEmpty() {
        }
    }

    /* compiled from: GameUpdateCheckRunner.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÖ\u0083\u0004J\n\u0010\b\u001a\u00020\tHÖ\u0081\u0004J\n\u0010\n\u001a\u00020\u000bHÖ\u0081\u0004Ê\u0001\f\b\r\u0012\b\b\u000e\u0012\u0004\b\u0003\u0010\u0002¨\u0006\f"}, d2 = {"Lcom/arizona/launcher/GameUpdateCheckRunResult$Stale;", "Lcom/arizona/launcher/GameUpdateCheckRunResult;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Stale implements GameUpdateCheckRunResult {
        public static final int $stable = 0;
        public static final Stale INSTANCE = new Stale();

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Stale) {
                Stale stale = (Stale) obj;
                return true;
            }
            return false;
        }

        public int hashCode() {
            return -1146826183;
        }

        public String toString() {
            return "Stale";
        }

        private Stale() {
        }
    }
}
