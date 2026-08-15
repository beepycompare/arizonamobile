package com.arizona.launcher;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArchiveUpdateServiceFlow.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0014JF\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0014\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010!\u001a\u00020\"HÖ\u0081\u0004J\n\u0010#\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0015\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0016\u0010\u0014Ê\u0001\f\b%\u0012\b\b&\u0012\u0004\b\u0003\u0010\u0000¨\u0006$"}, d2 = {"Lcom/arizona/launcher/ArchiveServiceFailure;", "", "detail", "", "kind", "Lcom/arizona/launcher/ArchiveServiceFailureKind;", "failureDetails", "Lcom/arizona/launcher/DownloadFailureDetails;", "requiredFreeSpaceBytes", "", "operationToken", "<init>", "(Ljava/lang/String;Lcom/arizona/launcher/ArchiveServiceFailureKind;Lcom/arizona/launcher/DownloadFailureDetails;Ljava/lang/Long;Ljava/lang/Long;)V", "getDetail", "()Ljava/lang/String;", "getKind", "()Lcom/arizona/launcher/ArchiveServiceFailureKind;", "getFailureDetails", "()Lcom/arizona/launcher/DownloadFailureDetails;", "getRequiredFreeSpaceBytes", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getOperationToken", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Lcom/arizona/launcher/ArchiveServiceFailureKind;Lcom/arizona/launcher/DownloadFailureDetails;Ljava/lang/Long;Ljava/lang/Long;)Lcom/arizona/launcher/ArchiveServiceFailure;", "equals", "", "other", "hashCode", "", "toString", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveServiceFailure {
    public static final int $stable = DownloadFailureDetails.$stable;
    private final String detail;
    private final DownloadFailureDetails failureDetails;
    private final ArchiveServiceFailureKind kind;
    private final Long operationToken;
    private final Long requiredFreeSpaceBytes;

    public static /* synthetic */ ArchiveServiceFailure copy$default(ArchiveServiceFailure archiveServiceFailure, String str, ArchiveServiceFailureKind archiveServiceFailureKind, DownloadFailureDetails downloadFailureDetails, Long l, Long l2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = archiveServiceFailure.detail;
        }
        if ((i & 2) != 0) {
            archiveServiceFailureKind = archiveServiceFailure.kind;
        }
        if ((i & 4) != 0) {
            downloadFailureDetails = archiveServiceFailure.failureDetails;
        }
        if ((i & 8) != 0) {
            l = archiveServiceFailure.requiredFreeSpaceBytes;
        }
        if ((i & 16) != 0) {
            l2 = archiveServiceFailure.operationToken;
        }
        Long l3 = l2;
        DownloadFailureDetails downloadFailureDetails2 = downloadFailureDetails;
        return archiveServiceFailure.copy(str, archiveServiceFailureKind, downloadFailureDetails2, l, l3);
    }

    public final String component1() {
        return this.detail;
    }

    public final ArchiveServiceFailureKind component2() {
        return this.kind;
    }

    public final DownloadFailureDetails component3() {
        return this.failureDetails;
    }

    public final Long component4() {
        return this.requiredFreeSpaceBytes;
    }

    public final Long component5() {
        return this.operationToken;
    }

    public final ArchiveServiceFailure copy(String detail, ArchiveServiceFailureKind kind, DownloadFailureDetails downloadFailureDetails, Long l, Long l2) {
        Intrinsics.checkNotNullParameter(detail, "detail");
        Intrinsics.checkNotNullParameter(kind, "kind");
        return new ArchiveServiceFailure(detail, kind, downloadFailureDetails, l, l2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ArchiveServiceFailure) {
            ArchiveServiceFailure archiveServiceFailure = (ArchiveServiceFailure) obj;
            return Intrinsics.areEqual(this.detail, archiveServiceFailure.detail) && this.kind == archiveServiceFailure.kind && Intrinsics.areEqual(this.failureDetails, archiveServiceFailure.failureDetails) && Intrinsics.areEqual(this.requiredFreeSpaceBytes, archiveServiceFailure.requiredFreeSpaceBytes) && Intrinsics.areEqual(this.operationToken, archiveServiceFailure.operationToken);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((this.detail.hashCode() * 31) + this.kind.hashCode()) * 31;
        DownloadFailureDetails downloadFailureDetails = this.failureDetails;
        int hashCode2 = (hashCode + (downloadFailureDetails == null ? 0 : downloadFailureDetails.hashCode())) * 31;
        Long l = this.requiredFreeSpaceBytes;
        int hashCode3 = (hashCode2 + (l == null ? 0 : l.hashCode())) * 31;
        Long l2 = this.operationToken;
        return hashCode3 + (l2 != null ? l2.hashCode() : 0);
    }

    public String toString() {
        String str = this.detail;
        ArchiveServiceFailureKind archiveServiceFailureKind = this.kind;
        DownloadFailureDetails downloadFailureDetails = this.failureDetails;
        Long l = this.requiredFreeSpaceBytes;
        return "ArchiveServiceFailure(detail=" + str + ", kind=" + archiveServiceFailureKind + ", failureDetails=" + downloadFailureDetails + ", requiredFreeSpaceBytes=" + l + ", operationToken=" + this.operationToken + ")";
    }

    public ArchiveServiceFailure(String detail, ArchiveServiceFailureKind kind, DownloadFailureDetails downloadFailureDetails, Long l, Long l2) {
        Intrinsics.checkNotNullParameter(detail, "detail");
        Intrinsics.checkNotNullParameter(kind, "kind");
        this.detail = detail;
        this.kind = kind;
        this.failureDetails = downloadFailureDetails;
        this.requiredFreeSpaceBytes = l;
        this.operationToken = l2;
    }

    public final String getDetail() {
        return this.detail;
    }

    public /* synthetic */ ArchiveServiceFailure(String str, ArchiveServiceFailureKind archiveServiceFailureKind, DownloadFailureDetails downloadFailureDetails, Long l, Long l2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? ArchiveServiceFailureKind.CORRUPTED : archiveServiceFailureKind, (i & 4) != 0 ? null : downloadFailureDetails, (i & 8) != 0 ? null : l, (i & 16) != 0 ? null : l2);
    }

    public final ArchiveServiceFailureKind getKind() {
        return this.kind;
    }

    public final DownloadFailureDetails getFailureDetails() {
        return this.failureDetails;
    }

    public final Long getRequiredFreeSpaceBytes() {
        return this.requiredFreeSpaceBytes;
    }

    public final Long getOperationToken() {
        return this.operationToken;
    }
}
