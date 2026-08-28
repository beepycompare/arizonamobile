package com.arizona.launcher.updater.archive.orchestrator;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArchiveSelectivePackageInstaller.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveSelectiveProbeResult;", "", "Ready", "Fallback", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveSelectiveProbeResult$Fallback;", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveSelectiveProbeResult$Ready;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface ArchiveSelectiveProbeResult {

    /* compiled from: ArchiveSelectivePackageInstaller.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007Ê\u0001\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u0012"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveSelectiveProbeResult$Ready;", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveSelectiveProbeResult;", "session", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveSelectiveInstallSession;", "<init>", "(Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveSelectiveInstallSession;)V", "getSession", "()Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveSelectiveInstallSession;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Ready implements ArchiveSelectiveProbeResult {
        public static final int $stable = RemoteZipIndexSession.$stable;
        private final ArchiveSelectiveInstallSession session;

        public static /* synthetic */ Ready copy$default(Ready ready, ArchiveSelectiveInstallSession archiveSelectiveInstallSession, int i, Object obj) {
            if ((i & 1) != 0) {
                archiveSelectiveInstallSession = ready.session;
            }
            return ready.copy(archiveSelectiveInstallSession);
        }

        public final ArchiveSelectiveInstallSession component1() {
            return this.session;
        }

        public final Ready copy(ArchiveSelectiveInstallSession session) {
            Intrinsics.checkNotNullParameter(session, "session");
            return new Ready(session);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Ready) && Intrinsics.areEqual(this.session, ((Ready) obj).session);
        }

        public int hashCode() {
            return this.session.hashCode();
        }

        public String toString() {
            return "Ready(session=" + this.session + ")";
        }

        public Ready(ArchiveSelectiveInstallSession session) {
            Intrinsics.checkNotNullParameter(session, "session");
            this.session = session;
        }

        public final ArchiveSelectiveInstallSession getSession() {
            return this.session;
        }
    }

    /* compiled from: ArchiveSelectivePackageInstaller.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bÊ\u0001\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0016"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveSelectiveProbeResult$Fallback;", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveSelectiveProbeResult;", "reason", "", "networkBytes", "", "<init>", "(Ljava/lang/String;J)V", "getReason", "()Ljava/lang/String;", "getNetworkBytes", "()J", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Fallback implements ArchiveSelectiveProbeResult {
        public static final int $stable = 0;
        private final long networkBytes;
        private final String reason;

        public static /* synthetic */ Fallback copy$default(Fallback fallback, String str, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                str = fallback.reason;
            }
            if ((i & 2) != 0) {
                j = fallback.networkBytes;
            }
            return fallback.copy(str, j);
        }

        public final String component1() {
            return this.reason;
        }

        public final long component2() {
            return this.networkBytes;
        }

        public final Fallback copy(String reason, long j) {
            Intrinsics.checkNotNullParameter(reason, "reason");
            return new Fallback(reason, j);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Fallback) {
                Fallback fallback = (Fallback) obj;
                return Intrinsics.areEqual(this.reason, fallback.reason) && this.networkBytes == fallback.networkBytes;
            }
            return false;
        }

        public int hashCode() {
            return (this.reason.hashCode() * 31) + Long.hashCode(this.networkBytes);
        }

        public String toString() {
            String str = this.reason;
            return "Fallback(reason=" + str + ", networkBytes=" + this.networkBytes + ")";
        }

        public Fallback(String reason, long j) {
            Intrinsics.checkNotNullParameter(reason, "reason");
            this.reason = reason;
            this.networkBytes = j;
        }

        public /* synthetic */ Fallback(String str, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? 0L : j);
        }

        public final String getReason() {
            return this.reason;
        }

        public final long getNetworkBytes() {
            return this.networkBytes;
        }
    }
}
