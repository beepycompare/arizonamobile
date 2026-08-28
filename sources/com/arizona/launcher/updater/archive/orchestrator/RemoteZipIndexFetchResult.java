package com.arizona.launcher.updater.archive.orchestrator;

import com.arizona.launcher.updater.archive.range.ArchiveObservedRepresentationFence;
import com.arizona.launcher.updater.archive.range.RemoteZipIndex;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: RemoteZipIndexFetcher.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/RemoteZipIndexFetchResult;", "", "Success", "Failure", "Lcom/arizona/launcher/updater/archive/orchestrator/RemoteZipIndexFetchResult$Failure;", "Lcom/arizona/launcher/updater/archive/orchestrator/RemoteZipIndexFetchResult$Success;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface RemoteZipIndexFetchResult {

    /* compiled from: RemoteZipIndexFetcher.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007Ê\u0001\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u0012"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/RemoteZipIndexFetchResult$Success;", "Lcom/arizona/launcher/updater/archive/orchestrator/RemoteZipIndexFetchResult;", "session", "Lcom/arizona/launcher/updater/archive/orchestrator/RemoteZipIndexSession;", "<init>", "(Lcom/arizona/launcher/updater/archive/orchestrator/RemoteZipIndexSession;)V", "getSession", "()Lcom/arizona/launcher/updater/archive/orchestrator/RemoteZipIndexSession;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Success implements RemoteZipIndexFetchResult {
        public static final int $stable = ArchiveObservedRepresentationFence.$stable | RemoteZipIndex.$stable;
        private final RemoteZipIndexSession session;

        public static /* synthetic */ Success copy$default(Success success, RemoteZipIndexSession remoteZipIndexSession, int i, Object obj) {
            if ((i & 1) != 0) {
                remoteZipIndexSession = success.session;
            }
            return success.copy(remoteZipIndexSession);
        }

        public final RemoteZipIndexSession component1() {
            return this.session;
        }

        public final Success copy(RemoteZipIndexSession session) {
            Intrinsics.checkNotNullParameter(session, "session");
            return new Success(session);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Success) && Intrinsics.areEqual(this.session, ((Success) obj).session);
        }

        public int hashCode() {
            return this.session.hashCode();
        }

        public String toString() {
            return "Success(session=" + this.session + ")";
        }

        public Success(RemoteZipIndexSession session) {
            Intrinsics.checkNotNullParameter(session, "session");
            this.session = session;
        }

        public final RemoteZipIndexSession getSession() {
            return this.session;
        }
    }

    /* compiled from: RemoteZipIndexFetcher.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J)\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0014\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0083\u0004J\n\u0010\u0018\u001a\u00020\u0019HÖ\u0081\u0004J\n\u0010\u001a\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fÊ\u0001\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u001b"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/RemoteZipIndexFetchResult$Failure;", "Lcom/arizona/launcher/updater/archive/orchestrator/RemoteZipIndexFetchResult;", "code", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveManifestResolutionErrorCode;", "detail", "", "networkBytes", "", "<init>", "(Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveManifestResolutionErrorCode;Ljava/lang/String;J)V", "getCode", "()Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveManifestResolutionErrorCode;", "getDetail", "()Ljava/lang/String;", "getNetworkBytes", "()J", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Failure implements RemoteZipIndexFetchResult {
        public static final int $stable = 0;
        private final ArchiveManifestResolutionErrorCode code;
        private final String detail;
        private final long networkBytes;

        public static /* synthetic */ Failure copy$default(Failure failure, ArchiveManifestResolutionErrorCode archiveManifestResolutionErrorCode, String str, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                archiveManifestResolutionErrorCode = failure.code;
            }
            if ((i & 2) != 0) {
                str = failure.detail;
            }
            if ((i & 4) != 0) {
                j = failure.networkBytes;
            }
            return failure.copy(archiveManifestResolutionErrorCode, str, j);
        }

        public final ArchiveManifestResolutionErrorCode component1() {
            return this.code;
        }

        public final String component2() {
            return this.detail;
        }

        public final long component3() {
            return this.networkBytes;
        }

        public final Failure copy(ArchiveManifestResolutionErrorCode code, String str, long j) {
            Intrinsics.checkNotNullParameter(code, "code");
            return new Failure(code, str, j);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Failure) {
                Failure failure = (Failure) obj;
                return this.code == failure.code && Intrinsics.areEqual(this.detail, failure.detail) && this.networkBytes == failure.networkBytes;
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.code.hashCode() * 31;
            String str = this.detail;
            return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + Long.hashCode(this.networkBytes);
        }

        public String toString() {
            ArchiveManifestResolutionErrorCode archiveManifestResolutionErrorCode = this.code;
            String str = this.detail;
            return "Failure(code=" + archiveManifestResolutionErrorCode + ", detail=" + str + ", networkBytes=" + this.networkBytes + ")";
        }

        public Failure(ArchiveManifestResolutionErrorCode code, String str, long j) {
            Intrinsics.checkNotNullParameter(code, "code");
            this.code = code;
            this.detail = str;
            this.networkBytes = j;
        }

        public /* synthetic */ Failure(ArchiveManifestResolutionErrorCode archiveManifestResolutionErrorCode, String str, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(archiveManifestResolutionErrorCode, (i & 2) != 0 ? null : str, (i & 4) != 0 ? 0L : j);
        }

        public final ArchiveManifestResolutionErrorCode getCode() {
            return this.code;
        }

        public final String getDetail() {
            return this.detail;
        }

        public final long getNetworkBytes() {
            return this.networkBytes;
        }
    }
}
