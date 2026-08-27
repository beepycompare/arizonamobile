package com.arizona.launcher.updater.archive.orchestrator;

import com.arizona.launcher.updater.archive.state.ArchivePackageFileRecord;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArchiveSelectivePackageInstaller.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\u000f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\n0\u0007HÆ\u0003J\t\u0010\u001e\u001a\u00020\fHÆ\u0003J\t\u0010\u001f\u001a\u00020\fHÆ\u0003JQ\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\fHÆ\u0001J\u0014\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010$\u001a\u00020%HÖ\u0081\u0004J\n\u0010&\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\r\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018Ê\u0001\f\b(\u0012\b\b)\u0012\u0004\b\u0003\u0010\u0000¨\u0006'"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveSelectiveInstallSession;", "", "requestUrl", "", "indexSession", "Lcom/arizona/launcher/updater/archive/orchestrator/RemoteZipIndexSession;", "reusable", "", "Lcom/arizona/launcher/updater/archive/state/ArchivePackageFileRecord;", "toFetch", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveSelectiveEntryTransfer;", "preflightNetworkBytes", "", "estimatedNetworkBytes", "<init>", "(Ljava/lang/String;Lcom/arizona/launcher/updater/archive/orchestrator/RemoteZipIndexSession;Ljava/util/List;Ljava/util/List;JJ)V", "getRequestUrl", "()Ljava/lang/String;", "getIndexSession", "()Lcom/arizona/launcher/updater/archive/orchestrator/RemoteZipIndexSession;", "getReusable", "()Ljava/util/List;", "getToFetch", "getPreflightNetworkBytes", "()J", "getEstimatedNetworkBytes", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveSelectiveInstallSession {
    public static final int $stable = RemoteZipIndexSession.$stable;
    private final long estimatedNetworkBytes;
    private final RemoteZipIndexSession indexSession;
    private final long preflightNetworkBytes;
    private final String requestUrl;
    private final List<ArchivePackageFileRecord> reusable;
    private final List<ArchiveSelectiveEntryTransfer> toFetch;

    public static /* synthetic */ ArchiveSelectiveInstallSession copy$default(ArchiveSelectiveInstallSession archiveSelectiveInstallSession, String str, RemoteZipIndexSession remoteZipIndexSession, List list, List list2, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = archiveSelectiveInstallSession.requestUrl;
        }
        if ((i & 2) != 0) {
            remoteZipIndexSession = archiveSelectiveInstallSession.indexSession;
        }
        List<ArchivePackageFileRecord> list3 = list;
        if ((i & 4) != 0) {
            list3 = archiveSelectiveInstallSession.reusable;
        }
        List<ArchiveSelectiveEntryTransfer> list4 = list2;
        if ((i & 8) != 0) {
            list4 = archiveSelectiveInstallSession.toFetch;
        }
        if ((i & 16) != 0) {
            j = archiveSelectiveInstallSession.preflightNetworkBytes;
        }
        if ((i & 32) != 0) {
            j2 = archiveSelectiveInstallSession.estimatedNetworkBytes;
        }
        long j3 = j2;
        long j4 = j;
        return archiveSelectiveInstallSession.copy(str, remoteZipIndexSession, list3, list4, j4, j3);
    }

    public final String component1() {
        return this.requestUrl;
    }

    public final RemoteZipIndexSession component2() {
        return this.indexSession;
    }

    public final List<ArchivePackageFileRecord> component3() {
        return this.reusable;
    }

    public final List<ArchiveSelectiveEntryTransfer> component4() {
        return this.toFetch;
    }

    public final long component5() {
        return this.preflightNetworkBytes;
    }

    public final long component6() {
        return this.estimatedNetworkBytes;
    }

    public final ArchiveSelectiveInstallSession copy(String requestUrl, RemoteZipIndexSession indexSession, List<ArchivePackageFileRecord> reusable, List<ArchiveSelectiveEntryTransfer> toFetch, long j, long j2) {
        Intrinsics.checkNotNullParameter(requestUrl, "requestUrl");
        Intrinsics.checkNotNullParameter(indexSession, "indexSession");
        Intrinsics.checkNotNullParameter(reusable, "reusable");
        Intrinsics.checkNotNullParameter(toFetch, "toFetch");
        return new ArchiveSelectiveInstallSession(requestUrl, indexSession, reusable, toFetch, j, j2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ArchiveSelectiveInstallSession) {
            ArchiveSelectiveInstallSession archiveSelectiveInstallSession = (ArchiveSelectiveInstallSession) obj;
            return Intrinsics.areEqual(this.requestUrl, archiveSelectiveInstallSession.requestUrl) && Intrinsics.areEqual(this.indexSession, archiveSelectiveInstallSession.indexSession) && Intrinsics.areEqual(this.reusable, archiveSelectiveInstallSession.reusable) && Intrinsics.areEqual(this.toFetch, archiveSelectiveInstallSession.toFetch) && this.preflightNetworkBytes == archiveSelectiveInstallSession.preflightNetworkBytes && this.estimatedNetworkBytes == archiveSelectiveInstallSession.estimatedNetworkBytes;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((this.requestUrl.hashCode() * 31) + this.indexSession.hashCode()) * 31) + this.reusable.hashCode()) * 31) + this.toFetch.hashCode()) * 31) + Long.hashCode(this.preflightNetworkBytes)) * 31) + Long.hashCode(this.estimatedNetworkBytes);
    }

    public String toString() {
        String str = this.requestUrl;
        RemoteZipIndexSession remoteZipIndexSession = this.indexSession;
        List<ArchivePackageFileRecord> list = this.reusable;
        List<ArchiveSelectiveEntryTransfer> list2 = this.toFetch;
        long j = this.preflightNetworkBytes;
        return "ArchiveSelectiveInstallSession(requestUrl=" + str + ", indexSession=" + remoteZipIndexSession + ", reusable=" + list + ", toFetch=" + list2 + ", preflightNetworkBytes=" + j + ", estimatedNetworkBytes=" + this.estimatedNetworkBytes + ")";
    }

    public ArchiveSelectiveInstallSession(String requestUrl, RemoteZipIndexSession indexSession, List<ArchivePackageFileRecord> reusable, List<ArchiveSelectiveEntryTransfer> toFetch, long j, long j2) {
        Intrinsics.checkNotNullParameter(requestUrl, "requestUrl");
        Intrinsics.checkNotNullParameter(indexSession, "indexSession");
        Intrinsics.checkNotNullParameter(reusable, "reusable");
        Intrinsics.checkNotNullParameter(toFetch, "toFetch");
        this.requestUrl = requestUrl;
        this.indexSession = indexSession;
        this.reusable = reusable;
        this.toFetch = toFetch;
        this.preflightNetworkBytes = j;
        this.estimatedNetworkBytes = j2;
    }

    public final String getRequestUrl() {
        return this.requestUrl;
    }

    public final RemoteZipIndexSession getIndexSession() {
        return this.indexSession;
    }

    public final List<ArchivePackageFileRecord> getReusable() {
        return this.reusable;
    }

    public final List<ArchiveSelectiveEntryTransfer> getToFetch() {
        return this.toFetch;
    }

    public final long getPreflightNetworkBytes() {
        return this.preflightNetworkBytes;
    }

    public final long getEstimatedNetworkBytes() {
        return this.estimatedNetworkBytes;
    }
}
