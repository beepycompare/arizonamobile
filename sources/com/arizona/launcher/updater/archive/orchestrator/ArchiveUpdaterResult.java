package com.arizona.launcher.updater.archive.orchestrator;

import com.arizona.launcher.DownloadFailureDetails;
import com.arizona.launcher.updater.archive.download.ArchivePackageDownloadErrorCode;
import com.arizona.launcher.updater.archive.state.ArchiveUpdaterState;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArchivePackageUpdater.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdaterResult;", "", "Success", "Failure", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdaterResult$Failure;", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdaterResult$Success;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface ArchiveUpdaterResult {

    /* compiled from: ArchivePackageUpdater.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007Ê\u0001\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u0012"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdaterResult$Success;", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdaterResult;", RemoteConfigConstants.ResponseFieldKey.STATE, "Lcom/arizona/launcher/updater/archive/state/ArchiveUpdaterState;", "<init>", "(Lcom/arizona/launcher/updater/archive/state/ArchiveUpdaterState;)V", "getState", "()Lcom/arizona/launcher/updater/archive/state/ArchiveUpdaterState;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Success implements ArchiveUpdaterResult {
        public static final int $stable = ArchiveUpdaterState.$stable;
        private final ArchiveUpdaterState state;

        public static /* synthetic */ Success copy$default(Success success, ArchiveUpdaterState archiveUpdaterState, int i, Object obj) {
            if ((i & 1) != 0) {
                archiveUpdaterState = success.state;
            }
            return success.copy(archiveUpdaterState);
        }

        public final ArchiveUpdaterState component1() {
            return this.state;
        }

        public final Success copy(ArchiveUpdaterState state) {
            Intrinsics.checkNotNullParameter(state, "state");
            return new Success(state);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Success) && Intrinsics.areEqual(this.state, ((Success) obj).state);
        }

        public int hashCode() {
            return this.state.hashCode();
        }

        public String toString() {
            return "Success(state=" + this.state + ")";
        }

        public Success(ArchiveUpdaterState state) {
            Intrinsics.checkNotNullParameter(state, "state");
            this.state = state;
        }

        public final ArchiveUpdaterState getState() {
            return this.state;
        }
    }

    /* compiled from: ArchivePackageUpdater.kt */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010#\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u001aJ`\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010%J\u0014\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)HÖ\u0083\u0004J\n\u0010*\u001a\u00020+HÖ\u0081\u0004J\n\u0010,\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u0015\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u001c\u0010\u001aÊ\u0001\f\b.\u0012\b\b/\u0012\u0004\b\u0003\u0010\u0000¨\u0006-"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdaterResult$Failure;", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdaterResult;", "code", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdaterErrorCode;", "packageId", "", "detail", "downloadErrorCode", "Lcom/arizona/launcher/updater/archive/download/ArchivePackageDownloadErrorCode;", "downloadFailure", "Lcom/arizona/launcher/DownloadFailureDetails;", "runtimeDownloadBytes", "", "runtimeRequiredFreeSpaceBytes", "<init>", "(Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdaterErrorCode;Ljava/lang/String;Ljava/lang/String;Lcom/arizona/launcher/updater/archive/download/ArchivePackageDownloadErrorCode;Lcom/arizona/launcher/DownloadFailureDetails;Ljava/lang/Long;Ljava/lang/Long;)V", "getCode", "()Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdaterErrorCode;", "getPackageId", "()Ljava/lang/String;", "getDetail", "getDownloadErrorCode", "()Lcom/arizona/launcher/updater/archive/download/ArchivePackageDownloadErrorCode;", "getDownloadFailure", "()Lcom/arizona/launcher/DownloadFailureDetails;", "getRuntimeDownloadBytes", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getRuntimeRequiredFreeSpaceBytes", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdaterErrorCode;Ljava/lang/String;Ljava/lang/String;Lcom/arizona/launcher/updater/archive/download/ArchivePackageDownloadErrorCode;Lcom/arizona/launcher/DownloadFailureDetails;Ljava/lang/Long;Ljava/lang/Long;)Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdaterResult$Failure;", "equals", "", "other", "", "hashCode", "", "toString", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Failure implements ArchiveUpdaterResult {
        public static final int $stable = DownloadFailureDetails.$stable;
        private final ArchiveUpdaterErrorCode code;
        private final String detail;
        private final ArchivePackageDownloadErrorCode downloadErrorCode;
        private final DownloadFailureDetails downloadFailure;
        private final String packageId;
        private final Long runtimeDownloadBytes;
        private final Long runtimeRequiredFreeSpaceBytes;

        public static /* synthetic */ Failure copy$default(Failure failure, ArchiveUpdaterErrorCode archiveUpdaterErrorCode, String str, String str2, ArchivePackageDownloadErrorCode archivePackageDownloadErrorCode, DownloadFailureDetails downloadFailureDetails, Long l, Long l2, int i, Object obj) {
            if ((i & 1) != 0) {
                archiveUpdaterErrorCode = failure.code;
            }
            if ((i & 2) != 0) {
                str = failure.packageId;
            }
            if ((i & 4) != 0) {
                str2 = failure.detail;
            }
            if ((i & 8) != 0) {
                archivePackageDownloadErrorCode = failure.downloadErrorCode;
            }
            if ((i & 16) != 0) {
                downloadFailureDetails = failure.downloadFailure;
            }
            if ((i & 32) != 0) {
                l = failure.runtimeDownloadBytes;
            }
            if ((i & 64) != 0) {
                l2 = failure.runtimeRequiredFreeSpaceBytes;
            }
            Long l3 = l;
            Long l4 = l2;
            DownloadFailureDetails downloadFailureDetails2 = downloadFailureDetails;
            String str3 = str2;
            return failure.copy(archiveUpdaterErrorCode, str, str3, archivePackageDownloadErrorCode, downloadFailureDetails2, l3, l4);
        }

        public final ArchiveUpdaterErrorCode component1() {
            return this.code;
        }

        public final String component2() {
            return this.packageId;
        }

        public final String component3() {
            return this.detail;
        }

        public final ArchivePackageDownloadErrorCode component4() {
            return this.downloadErrorCode;
        }

        public final DownloadFailureDetails component5() {
            return this.downloadFailure;
        }

        public final Long component6() {
            return this.runtimeDownloadBytes;
        }

        public final Long component7() {
            return this.runtimeRequiredFreeSpaceBytes;
        }

        public final Failure copy(ArchiveUpdaterErrorCode code, String str, String str2, ArchivePackageDownloadErrorCode archivePackageDownloadErrorCode, DownloadFailureDetails downloadFailureDetails, Long l, Long l2) {
            Intrinsics.checkNotNullParameter(code, "code");
            return new Failure(code, str, str2, archivePackageDownloadErrorCode, downloadFailureDetails, l, l2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Failure) {
                Failure failure = (Failure) obj;
                return this.code == failure.code && Intrinsics.areEqual(this.packageId, failure.packageId) && Intrinsics.areEqual(this.detail, failure.detail) && this.downloadErrorCode == failure.downloadErrorCode && Intrinsics.areEqual(this.downloadFailure, failure.downloadFailure) && Intrinsics.areEqual(this.runtimeDownloadBytes, failure.runtimeDownloadBytes) && Intrinsics.areEqual(this.runtimeRequiredFreeSpaceBytes, failure.runtimeRequiredFreeSpaceBytes);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.code.hashCode() * 31;
            String str = this.packageId;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.detail;
            int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            ArchivePackageDownloadErrorCode archivePackageDownloadErrorCode = this.downloadErrorCode;
            int hashCode4 = (hashCode3 + (archivePackageDownloadErrorCode == null ? 0 : archivePackageDownloadErrorCode.hashCode())) * 31;
            DownloadFailureDetails downloadFailureDetails = this.downloadFailure;
            int hashCode5 = (hashCode4 + (downloadFailureDetails == null ? 0 : downloadFailureDetails.hashCode())) * 31;
            Long l = this.runtimeDownloadBytes;
            int hashCode6 = (hashCode5 + (l == null ? 0 : l.hashCode())) * 31;
            Long l2 = this.runtimeRequiredFreeSpaceBytes;
            return hashCode6 + (l2 != null ? l2.hashCode() : 0);
        }

        public String toString() {
            ArchiveUpdaterErrorCode archiveUpdaterErrorCode = this.code;
            String str = this.packageId;
            String str2 = this.detail;
            ArchivePackageDownloadErrorCode archivePackageDownloadErrorCode = this.downloadErrorCode;
            DownloadFailureDetails downloadFailureDetails = this.downloadFailure;
            Long l = this.runtimeDownloadBytes;
            return "Failure(code=" + archiveUpdaterErrorCode + ", packageId=" + str + ", detail=" + str2 + ", downloadErrorCode=" + archivePackageDownloadErrorCode + ", downloadFailure=" + downloadFailureDetails + ", runtimeDownloadBytes=" + l + ", runtimeRequiredFreeSpaceBytes=" + this.runtimeRequiredFreeSpaceBytes + ")";
        }

        public Failure(ArchiveUpdaterErrorCode code, String str, String str2, ArchivePackageDownloadErrorCode archivePackageDownloadErrorCode, DownloadFailureDetails downloadFailureDetails, Long l, Long l2) {
            Intrinsics.checkNotNullParameter(code, "code");
            this.code = code;
            this.packageId = str;
            this.detail = str2;
            this.downloadErrorCode = archivePackageDownloadErrorCode;
            this.downloadFailure = downloadFailureDetails;
            this.runtimeDownloadBytes = l;
            this.runtimeRequiredFreeSpaceBytes = l2;
        }

        public /* synthetic */ Failure(ArchiveUpdaterErrorCode archiveUpdaterErrorCode, String str, String str2, ArchivePackageDownloadErrorCode archivePackageDownloadErrorCode, DownloadFailureDetails downloadFailureDetails, Long l, Long l2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(archiveUpdaterErrorCode, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : archivePackageDownloadErrorCode, (i & 16) != 0 ? null : downloadFailureDetails, (i & 32) != 0 ? null : l, (i & 64) != 0 ? null : l2);
        }

        public final ArchiveUpdaterErrorCode getCode() {
            return this.code;
        }

        public final String getPackageId() {
            return this.packageId;
        }

        public final String getDetail() {
            return this.detail;
        }

        public final ArchivePackageDownloadErrorCode getDownloadErrorCode() {
            return this.downloadErrorCode;
        }

        public final DownloadFailureDetails getDownloadFailure() {
            return this.downloadFailure;
        }

        public final Long getRuntimeDownloadBytes() {
            return this.runtimeDownloadBytes;
        }

        public final Long getRuntimeRequiredFreeSpaceBytes() {
            return this.runtimeRequiredFreeSpaceBytes;
        }
    }
}
