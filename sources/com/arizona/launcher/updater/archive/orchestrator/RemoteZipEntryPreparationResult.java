package com.arizona.launcher.updater.archive.orchestrator;

import com.arizona.launcher.updater.archive.range.RemoteZipEntry;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: RemoteZipEntryRangeReader.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/RemoteZipEntryPreparationResult;", "", "Success", "Failure", "Lcom/arizona/launcher/updater/archive/orchestrator/RemoteZipEntryPreparationResult$Failure;", "Lcom/arizona/launcher/updater/archive/orchestrator/RemoteZipEntryPreparationResult$Success;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface RemoteZipEntryPreparationResult {

    /* compiled from: RemoteZipEntryRangeReader.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bÊ\u0001\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u0017"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/RemoteZipEntryPreparationResult$Success;", "Lcom/arizona/launcher/updater/archive/orchestrator/RemoteZipEntryPreparationResult;", "prepared", "Lcom/arizona/launcher/updater/archive/orchestrator/RemoteZipPreparedEntry;", "fetchedBytes", "", "<init>", "(Lcom/arizona/launcher/updater/archive/orchestrator/RemoteZipPreparedEntry;J)V", "getPrepared", "()Lcom/arizona/launcher/updater/archive/orchestrator/RemoteZipPreparedEntry;", "getFetchedBytes", "()J", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Success implements RemoteZipEntryPreparationResult {
        public static final int $stable = RemoteZipEntry.$stable;
        private final long fetchedBytes;
        private final RemoteZipPreparedEntry prepared;

        public static /* synthetic */ Success copy$default(Success success, RemoteZipPreparedEntry remoteZipPreparedEntry, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                remoteZipPreparedEntry = success.prepared;
            }
            if ((i & 2) != 0) {
                j = success.fetchedBytes;
            }
            return success.copy(remoteZipPreparedEntry, j);
        }

        public final RemoteZipPreparedEntry component1() {
            return this.prepared;
        }

        public final long component2() {
            return this.fetchedBytes;
        }

        public final Success copy(RemoteZipPreparedEntry prepared, long j) {
            Intrinsics.checkNotNullParameter(prepared, "prepared");
            return new Success(prepared, j);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Success) {
                Success success = (Success) obj;
                return Intrinsics.areEqual(this.prepared, success.prepared) && this.fetchedBytes == success.fetchedBytes;
            }
            return false;
        }

        public int hashCode() {
            return (this.prepared.hashCode() * 31) + Long.hashCode(this.fetchedBytes);
        }

        public String toString() {
            RemoteZipPreparedEntry remoteZipPreparedEntry = this.prepared;
            return "Success(prepared=" + remoteZipPreparedEntry + ", fetchedBytes=" + this.fetchedBytes + ")";
        }

        public Success(RemoteZipPreparedEntry prepared, long j) {
            Intrinsics.checkNotNullParameter(prepared, "prepared");
            this.prepared = prepared;
            this.fetchedBytes = j;
        }

        public final RemoteZipPreparedEntry getPrepared() {
            return this.prepared;
        }

        public final long getFetchedBytes() {
            return this.fetchedBytes;
        }
    }

    /* compiled from: RemoteZipEntryRangeReader.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J)\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0014\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0083\u0004J\n\u0010\u0018\u001a\u00020\u0019HÖ\u0081\u0004J\n\u0010\u001a\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fÊ\u0001\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u001b"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/RemoteZipEntryPreparationResult$Failure;", "Lcom/arizona/launcher/updater/archive/orchestrator/RemoteZipEntryPreparationResult;", "code", "Lcom/arizona/launcher/updater/archive/orchestrator/RemoteZipEntryReadErrorCode;", "detail", "", "fetchedBytes", "", "<init>", "(Lcom/arizona/launcher/updater/archive/orchestrator/RemoteZipEntryReadErrorCode;Ljava/lang/String;J)V", "getCode", "()Lcom/arizona/launcher/updater/archive/orchestrator/RemoteZipEntryReadErrorCode;", "getDetail", "()Ljava/lang/String;", "getFetchedBytes", "()J", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Failure implements RemoteZipEntryPreparationResult {
        public static final int $stable = 0;
        private final RemoteZipEntryReadErrorCode code;
        private final String detail;
        private final long fetchedBytes;

        public static /* synthetic */ Failure copy$default(Failure failure, RemoteZipEntryReadErrorCode remoteZipEntryReadErrorCode, String str, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                remoteZipEntryReadErrorCode = failure.code;
            }
            if ((i & 2) != 0) {
                str = failure.detail;
            }
            if ((i & 4) != 0) {
                j = failure.fetchedBytes;
            }
            return failure.copy(remoteZipEntryReadErrorCode, str, j);
        }

        public final RemoteZipEntryReadErrorCode component1() {
            return this.code;
        }

        public final String component2() {
            return this.detail;
        }

        public final long component3() {
            return this.fetchedBytes;
        }

        public final Failure copy(RemoteZipEntryReadErrorCode code, String str, long j) {
            Intrinsics.checkNotNullParameter(code, "code");
            return new Failure(code, str, j);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Failure) {
                Failure failure = (Failure) obj;
                return this.code == failure.code && Intrinsics.areEqual(this.detail, failure.detail) && this.fetchedBytes == failure.fetchedBytes;
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.code.hashCode() * 31;
            String str = this.detail;
            return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + Long.hashCode(this.fetchedBytes);
        }

        public String toString() {
            RemoteZipEntryReadErrorCode remoteZipEntryReadErrorCode = this.code;
            String str = this.detail;
            return "Failure(code=" + remoteZipEntryReadErrorCode + ", detail=" + str + ", fetchedBytes=" + this.fetchedBytes + ")";
        }

        public Failure(RemoteZipEntryReadErrorCode code, String str, long j) {
            Intrinsics.checkNotNullParameter(code, "code");
            this.code = code;
            this.detail = str;
            this.fetchedBytes = j;
        }

        public /* synthetic */ Failure(RemoteZipEntryReadErrorCode remoteZipEntryReadErrorCode, String str, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(remoteZipEntryReadErrorCode, (i & 2) != 0 ? null : str, (i & 4) != 0 ? 0L : j);
        }

        public final RemoteZipEntryReadErrorCode getCode() {
            return this.code;
        }

        public final String getDetail() {
            return this.detail;
        }

        public final long getFetchedBytes() {
            return this.fetchedBytes;
        }
    }
}
