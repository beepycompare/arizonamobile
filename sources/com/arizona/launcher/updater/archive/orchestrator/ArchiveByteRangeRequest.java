package com.arizona.launcher.updater.archive.orchestrator;

import com.arizona.launcher.updater.archive.range.StrongEtag;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArchiveManifestResolver.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\nHÆ\u0003JG\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0014\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010 \u001a\u00020!HÖ\u0081\u0004J\n\u0010\"\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015Ê\u0001\f\b$\u0012\b\b%\u0012\u0004\b\u0003\u0010\u0000¨\u0006#"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveByteRangeRequest;", "", "packageId", "", "url", "startInclusive", "", "endInclusive", "expectedArchiveSize", "ifRange", "Lcom/arizona/launcher/updater/archive/range/StrongEtag;", "<init>", "(Ljava/lang/String;Ljava/lang/String;JJJLcom/arizona/launcher/updater/archive/range/StrongEtag;)V", "getPackageId", "()Ljava/lang/String;", "getUrl", "getStartInclusive", "()J", "getEndInclusive", "getExpectedArchiveSize", "getIfRange", "()Lcom/arizona/launcher/updater/archive/range/StrongEtag;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveByteRangeRequest {
    public static final int $stable = StrongEtag.$stable;
    private final long endInclusive;
    private final long expectedArchiveSize;
    private final StrongEtag ifRange;
    private final String packageId;
    private final long startInclusive;
    private final String url;

    public static /* synthetic */ ArchiveByteRangeRequest copy$default(ArchiveByteRangeRequest archiveByteRangeRequest, String str, String str2, long j, long j2, long j3, StrongEtag strongEtag, int i, Object obj) {
        if ((i & 1) != 0) {
            str = archiveByteRangeRequest.packageId;
        }
        if ((i & 2) != 0) {
            str2 = archiveByteRangeRequest.url;
        }
        if ((i & 4) != 0) {
            j = archiveByteRangeRequest.startInclusive;
        }
        if ((i & 8) != 0) {
            j2 = archiveByteRangeRequest.endInclusive;
        }
        if ((i & 16) != 0) {
            j3 = archiveByteRangeRequest.expectedArchiveSize;
        }
        if ((i & 32) != 0) {
            strongEtag = archiveByteRangeRequest.ifRange;
        }
        StrongEtag strongEtag2 = strongEtag;
        long j4 = j3;
        long j5 = j2;
        return archiveByteRangeRequest.copy(str, str2, j, j5, j4, strongEtag2);
    }

    public final String component1() {
        return this.packageId;
    }

    public final String component2() {
        return this.url;
    }

    public final long component3() {
        return this.startInclusive;
    }

    public final long component4() {
        return this.endInclusive;
    }

    public final long component5() {
        return this.expectedArchiveSize;
    }

    public final StrongEtag component6() {
        return this.ifRange;
    }

    public final ArchiveByteRangeRequest copy(String packageId, String url, long j, long j2, long j3, StrongEtag strongEtag) {
        Intrinsics.checkNotNullParameter(packageId, "packageId");
        Intrinsics.checkNotNullParameter(url, "url");
        return new ArchiveByteRangeRequest(packageId, url, j, j2, j3, strongEtag);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ArchiveByteRangeRequest) {
            ArchiveByteRangeRequest archiveByteRangeRequest = (ArchiveByteRangeRequest) obj;
            return Intrinsics.areEqual(this.packageId, archiveByteRangeRequest.packageId) && Intrinsics.areEqual(this.url, archiveByteRangeRequest.url) && this.startInclusive == archiveByteRangeRequest.startInclusive && this.endInclusive == archiveByteRangeRequest.endInclusive && this.expectedArchiveSize == archiveByteRangeRequest.expectedArchiveSize && Intrinsics.areEqual(this.ifRange, archiveByteRangeRequest.ifRange);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((((((this.packageId.hashCode() * 31) + this.url.hashCode()) * 31) + Long.hashCode(this.startInclusive)) * 31) + Long.hashCode(this.endInclusive)) * 31) + Long.hashCode(this.expectedArchiveSize)) * 31;
        StrongEtag strongEtag = this.ifRange;
        return hashCode + (strongEtag == null ? 0 : strongEtag.hashCode());
    }

    public String toString() {
        String str = this.packageId;
        String str2 = this.url;
        long j = this.startInclusive;
        long j2 = this.endInclusive;
        long j3 = this.expectedArchiveSize;
        return "ArchiveByteRangeRequest(packageId=" + str + ", url=" + str2 + ", startInclusive=" + j + ", endInclusive=" + j2 + ", expectedArchiveSize=" + j3 + ", ifRange=" + this.ifRange + ")";
    }

    public ArchiveByteRangeRequest(String packageId, String url, long j, long j2, long j3, StrongEtag strongEtag) {
        Intrinsics.checkNotNullParameter(packageId, "packageId");
        Intrinsics.checkNotNullParameter(url, "url");
        this.packageId = packageId;
        this.url = url;
        this.startInclusive = j;
        this.endInclusive = j2;
        this.expectedArchiveSize = j3;
        this.ifRange = strongEtag;
    }

    public /* synthetic */ ArchiveByteRangeRequest(String str, String str2, long j, long j2, long j3, StrongEtag strongEtag, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, j, j2, j3, (i & 32) != 0 ? null : strongEtag);
    }

    public final String getPackageId() {
        return this.packageId;
    }

    public final String getUrl() {
        return this.url;
    }

    public final long getStartInclusive() {
        return this.startInclusive;
    }

    public final long getEndInclusive() {
        return this.endInclusive;
    }

    public final long getExpectedArchiveSize() {
        return this.expectedArchiveSize;
    }

    public final StrongEtag getIfRange() {
        return this.ifRange;
    }
}
