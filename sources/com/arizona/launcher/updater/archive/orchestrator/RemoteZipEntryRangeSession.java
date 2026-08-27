package com.arizona.launcher.updater.archive.orchestrator;

import com.arizona.launcher.updater.archive.range.StrongEtag;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: RemoteZipEntryRangeReader.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\tHÆ\u0003J\t\u0010\u001b\u001a\u00020\tHÆ\u0003JE\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\tHÆ\u0001J\u0014\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010 \u001a\u00020!HÖ\u0081\u0004J\n\u0010\"\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014Ê\u0001\f\b$\u0012\b\b%\u0012\u0004\b\u0003\u0010\u0000¨\u0006#"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/RemoteZipEntryRangeSession;", "", "packageId", "", "requestUrl", "effectiveUrl", "fence", "Lcom/arizona/launcher/updater/archive/range/StrongEtag;", "archiveSize", "", "centralDirectoryOffset", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/arizona/launcher/updater/archive/range/StrongEtag;JJ)V", "getPackageId", "()Ljava/lang/String;", "getRequestUrl", "getEffectiveUrl", "getFence", "()Lcom/arizona/launcher/updater/archive/range/StrongEtag;", "getArchiveSize", "()J", "getCentralDirectoryOffset", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class RemoteZipEntryRangeSession {
    public static final int $stable = StrongEtag.$stable;
    private final long archiveSize;
    private final long centralDirectoryOffset;
    private final String effectiveUrl;
    private final StrongEtag fence;
    private final String packageId;
    private final String requestUrl;

    public static /* synthetic */ RemoteZipEntryRangeSession copy$default(RemoteZipEntryRangeSession remoteZipEntryRangeSession, String str, String str2, String str3, StrongEtag strongEtag, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = remoteZipEntryRangeSession.packageId;
        }
        if ((i & 2) != 0) {
            str2 = remoteZipEntryRangeSession.requestUrl;
        }
        if ((i & 4) != 0) {
            str3 = remoteZipEntryRangeSession.effectiveUrl;
        }
        if ((i & 8) != 0) {
            strongEtag = remoteZipEntryRangeSession.fence;
        }
        if ((i & 16) != 0) {
            j = remoteZipEntryRangeSession.archiveSize;
        }
        if ((i & 32) != 0) {
            j2 = remoteZipEntryRangeSession.centralDirectoryOffset;
        }
        long j3 = j2;
        long j4 = j;
        return remoteZipEntryRangeSession.copy(str, str2, str3, strongEtag, j4, j3);
    }

    public final String component1() {
        return this.packageId;
    }

    public final String component2() {
        return this.requestUrl;
    }

    public final String component3() {
        return this.effectiveUrl;
    }

    public final StrongEtag component4() {
        return this.fence;
    }

    public final long component5() {
        return this.archiveSize;
    }

    public final long component6() {
        return this.centralDirectoryOffset;
    }

    public final RemoteZipEntryRangeSession copy(String packageId, String requestUrl, String effectiveUrl, StrongEtag fence, long j, long j2) {
        Intrinsics.checkNotNullParameter(packageId, "packageId");
        Intrinsics.checkNotNullParameter(requestUrl, "requestUrl");
        Intrinsics.checkNotNullParameter(effectiveUrl, "effectiveUrl");
        Intrinsics.checkNotNullParameter(fence, "fence");
        return new RemoteZipEntryRangeSession(packageId, requestUrl, effectiveUrl, fence, j, j2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof RemoteZipEntryRangeSession) {
            RemoteZipEntryRangeSession remoteZipEntryRangeSession = (RemoteZipEntryRangeSession) obj;
            return Intrinsics.areEqual(this.packageId, remoteZipEntryRangeSession.packageId) && Intrinsics.areEqual(this.requestUrl, remoteZipEntryRangeSession.requestUrl) && Intrinsics.areEqual(this.effectiveUrl, remoteZipEntryRangeSession.effectiveUrl) && Intrinsics.areEqual(this.fence, remoteZipEntryRangeSession.fence) && this.archiveSize == remoteZipEntryRangeSession.archiveSize && this.centralDirectoryOffset == remoteZipEntryRangeSession.centralDirectoryOffset;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((this.packageId.hashCode() * 31) + this.requestUrl.hashCode()) * 31) + this.effectiveUrl.hashCode()) * 31) + this.fence.hashCode()) * 31) + Long.hashCode(this.archiveSize)) * 31) + Long.hashCode(this.centralDirectoryOffset);
    }

    public String toString() {
        String str = this.packageId;
        String str2 = this.requestUrl;
        String str3 = this.effectiveUrl;
        StrongEtag strongEtag = this.fence;
        long j = this.archiveSize;
        return "RemoteZipEntryRangeSession(packageId=" + str + ", requestUrl=" + str2 + ", effectiveUrl=" + str3 + ", fence=" + strongEtag + ", archiveSize=" + j + ", centralDirectoryOffset=" + this.centralDirectoryOffset + ")";
    }

    public RemoteZipEntryRangeSession(String packageId, String requestUrl, String effectiveUrl, StrongEtag fence, long j, long j2) {
        Intrinsics.checkNotNullParameter(packageId, "packageId");
        Intrinsics.checkNotNullParameter(requestUrl, "requestUrl");
        Intrinsics.checkNotNullParameter(effectiveUrl, "effectiveUrl");
        Intrinsics.checkNotNullParameter(fence, "fence");
        this.packageId = packageId;
        this.requestUrl = requestUrl;
        this.effectiveUrl = effectiveUrl;
        this.fence = fence;
        this.archiveSize = j;
        this.centralDirectoryOffset = j2;
    }

    public final String getPackageId() {
        return this.packageId;
    }

    public final String getRequestUrl() {
        return this.requestUrl;
    }

    public final String getEffectiveUrl() {
        return this.effectiveUrl;
    }

    public final StrongEtag getFence() {
        return this.fence;
    }

    public final long getArchiveSize() {
        return this.archiveSize;
    }

    public final long getCentralDirectoryOffset() {
        return this.centralDirectoryOffset;
    }
}
