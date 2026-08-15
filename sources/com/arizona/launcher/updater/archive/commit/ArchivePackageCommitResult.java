package com.arizona.launcher.updater.archive.commit;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArchivePackageCommitter.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/arizona/launcher/updater/archive/commit/ArchivePackageCommitResult;", "", "Success", "Failure", "Lcom/arizona/launcher/updater/archive/commit/ArchivePackageCommitResult$Failure;", "Lcom/arizona/launcher/updater/archive/commit/ArchivePackageCommitResult$Success;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface ArchivePackageCommitResult {

    /* compiled from: ArchivePackageCommitter.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bÊ\u0001\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0016"}, d2 = {"Lcom/arizona/launcher/updater/archive/commit/ArchivePackageCommitResult$Success;", "Lcom/arizona/launcher/updater/archive/commit/ArchivePackageCommitResult;", "filesCommitted", "", "bytesCommitted", "", "<init>", "(IJ)V", "getFilesCommitted", "()I", "getBytesCommitted", "()J", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Success implements ArchivePackageCommitResult {
        public static final int $stable = 0;
        private final long bytesCommitted;
        private final int filesCommitted;

        public static /* synthetic */ Success copy$default(Success success, int i, long j, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = success.filesCommitted;
            }
            if ((i2 & 2) != 0) {
                j = success.bytesCommitted;
            }
            return success.copy(i, j);
        }

        public final int component1() {
            return this.filesCommitted;
        }

        public final long component2() {
            return this.bytesCommitted;
        }

        public final Success copy(int i, long j) {
            return new Success(i, j);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Success) {
                Success success = (Success) obj;
                return this.filesCommitted == success.filesCommitted && this.bytesCommitted == success.bytesCommitted;
            }
            return false;
        }

        public int hashCode() {
            return (Integer.hashCode(this.filesCommitted) * 31) + Long.hashCode(this.bytesCommitted);
        }

        public String toString() {
            int i = this.filesCommitted;
            return "Success(filesCommitted=" + i + ", bytesCommitted=" + this.bytesCommitted + ")";
        }

        public Success(int i, long j) {
            this.filesCommitted = i;
            this.bytesCommitted = j;
        }

        public final int getFilesCommitted() {
            return this.filesCommitted;
        }

        public final long getBytesCommitted() {
            return this.bytesCommitted;
        }
    }

    /* compiled from: ArchivePackageCommitter.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bÊ\u0001\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0016"}, d2 = {"Lcom/arizona/launcher/updater/archive/commit/ArchivePackageCommitResult$Failure;", "Lcom/arizona/launcher/updater/archive/commit/ArchivePackageCommitResult;", "code", "Lcom/arizona/launcher/updater/archive/commit/ArchivePackageCommitErrorCode;", "relativePath", "", "<init>", "(Lcom/arizona/launcher/updater/archive/commit/ArchivePackageCommitErrorCode;Ljava/lang/String;)V", "getCode", "()Lcom/arizona/launcher/updater/archive/commit/ArchivePackageCommitErrorCode;", "getRelativePath", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Failure implements ArchivePackageCommitResult {
        public static final int $stable = 0;
        private final ArchivePackageCommitErrorCode code;
        private final String relativePath;

        public static /* synthetic */ Failure copy$default(Failure failure, ArchivePackageCommitErrorCode archivePackageCommitErrorCode, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                archivePackageCommitErrorCode = failure.code;
            }
            if ((i & 2) != 0) {
                str = failure.relativePath;
            }
            return failure.copy(archivePackageCommitErrorCode, str);
        }

        public final ArchivePackageCommitErrorCode component1() {
            return this.code;
        }

        public final String component2() {
            return this.relativePath;
        }

        public final Failure copy(ArchivePackageCommitErrorCode code, String str) {
            Intrinsics.checkNotNullParameter(code, "code");
            return new Failure(code, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Failure) {
                Failure failure = (Failure) obj;
                return this.code == failure.code && Intrinsics.areEqual(this.relativePath, failure.relativePath);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.code.hashCode() * 31;
            String str = this.relativePath;
            return hashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            ArchivePackageCommitErrorCode archivePackageCommitErrorCode = this.code;
            return "Failure(code=" + archivePackageCommitErrorCode + ", relativePath=" + this.relativePath + ")";
        }

        public Failure(ArchivePackageCommitErrorCode code, String str) {
            Intrinsics.checkNotNullParameter(code, "code");
            this.code = code;
            this.relativePath = str;
        }

        public /* synthetic */ Failure(ArchivePackageCommitErrorCode archivePackageCommitErrorCode, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(archivePackageCommitErrorCode, (i & 2) != 0 ? null : str);
        }

        public final ArchivePackageCommitErrorCode getCode() {
            return this.code;
        }

        public final String getRelativePath() {
            return this.relativePath;
        }
    }
}
