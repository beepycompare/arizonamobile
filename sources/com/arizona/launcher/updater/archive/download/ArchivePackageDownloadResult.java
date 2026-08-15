package com.arizona.launcher.updater.archive.download;

import coil3.util.UtilsKt;
import com.arizona.launcher.DownloadFailureDetails;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArchivePackageDownloader.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/arizona/launcher/updater/archive/download/ArchivePackageDownloadResult;", "", "Success", "Failure", "Lcom/arizona/launcher/updater/archive/download/ArchivePackageDownloadResult$Failure;", "Lcom/arizona/launcher/updater/archive/download/ArchivePackageDownloadResult$Success;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface ArchivePackageDownloadResult {

    /* compiled from: ArchivePackageDownloader.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0005HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bÊ\u0001\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u0016"}, d2 = {"Lcom/arizona/launcher/updater/archive/download/ArchivePackageDownloadResult$Success;", "Lcom/arizona/launcher/updater/archive/download/ArchivePackageDownloadResult;", UtilsKt.SCHEME_FILE, "Ljava/io/File;", "retriesConsumed", "", "<init>", "(Ljava/io/File;I)V", "getFile", "()Ljava/io/File;", "getRetriesConsumed", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Success implements ArchivePackageDownloadResult {
        public static final int $stable = 8;
        private final File file;
        private final int retriesConsumed;

        public static /* synthetic */ Success copy$default(Success success, File file, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                file = success.file;
            }
            if ((i2 & 2) != 0) {
                i = success.retriesConsumed;
            }
            return success.copy(file, i);
        }

        public final File component1() {
            return this.file;
        }

        public final int component2() {
            return this.retriesConsumed;
        }

        public final Success copy(File file, int i) {
            Intrinsics.checkNotNullParameter(file, "file");
            return new Success(file, i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Success) {
                Success success = (Success) obj;
                return Intrinsics.areEqual(this.file, success.file) && this.retriesConsumed == success.retriesConsumed;
            }
            return false;
        }

        public int hashCode() {
            return (this.file.hashCode() * 31) + Integer.hashCode(this.retriesConsumed);
        }

        public String toString() {
            File file = this.file;
            return "Success(file=" + file + ", retriesConsumed=" + this.retriesConsumed + ")";
        }

        public Success(File file, int i) {
            Intrinsics.checkNotNullParameter(file, "file");
            this.file = file;
            this.retriesConsumed = i;
        }

        public final File getFile() {
            return this.file;
        }

        public final int getRetriesConsumed() {
            return this.retriesConsumed;
        }
    }

    /* compiled from: ArchivePackageDownloader.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bÊ\u0001\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u0017"}, d2 = {"Lcom/arizona/launcher/updater/archive/download/ArchivePackageDownloadResult$Failure;", "Lcom/arizona/launcher/updater/archive/download/ArchivePackageDownloadResult;", "code", "Lcom/arizona/launcher/updater/archive/download/ArchivePackageDownloadErrorCode;", "details", "Lcom/arizona/launcher/DownloadFailureDetails;", "<init>", "(Lcom/arizona/launcher/updater/archive/download/ArchivePackageDownloadErrorCode;Lcom/arizona/launcher/DownloadFailureDetails;)V", "getCode", "()Lcom/arizona/launcher/updater/archive/download/ArchivePackageDownloadErrorCode;", "getDetails", "()Lcom/arizona/launcher/DownloadFailureDetails;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Failure implements ArchivePackageDownloadResult {
        public static final int $stable = DownloadFailureDetails.$stable;
        private final ArchivePackageDownloadErrorCode code;
        private final DownloadFailureDetails details;

        public static /* synthetic */ Failure copy$default(Failure failure, ArchivePackageDownloadErrorCode archivePackageDownloadErrorCode, DownloadFailureDetails downloadFailureDetails, int i, Object obj) {
            if ((i & 1) != 0) {
                archivePackageDownloadErrorCode = failure.code;
            }
            if ((i & 2) != 0) {
                downloadFailureDetails = failure.details;
            }
            return failure.copy(archivePackageDownloadErrorCode, downloadFailureDetails);
        }

        public final ArchivePackageDownloadErrorCode component1() {
            return this.code;
        }

        public final DownloadFailureDetails component2() {
            return this.details;
        }

        public final Failure copy(ArchivePackageDownloadErrorCode code, DownloadFailureDetails downloadFailureDetails) {
            Intrinsics.checkNotNullParameter(code, "code");
            return new Failure(code, downloadFailureDetails);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Failure) {
                Failure failure = (Failure) obj;
                return this.code == failure.code && Intrinsics.areEqual(this.details, failure.details);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.code.hashCode() * 31;
            DownloadFailureDetails downloadFailureDetails = this.details;
            return hashCode + (downloadFailureDetails == null ? 0 : downloadFailureDetails.hashCode());
        }

        public String toString() {
            ArchivePackageDownloadErrorCode archivePackageDownloadErrorCode = this.code;
            return "Failure(code=" + archivePackageDownloadErrorCode + ", details=" + this.details + ")";
        }

        public Failure(ArchivePackageDownloadErrorCode code, DownloadFailureDetails downloadFailureDetails) {
            Intrinsics.checkNotNullParameter(code, "code");
            this.code = code;
            this.details = downloadFailureDetails;
        }

        public /* synthetic */ Failure(ArchivePackageDownloadErrorCode archivePackageDownloadErrorCode, DownloadFailureDetails downloadFailureDetails, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(archivePackageDownloadErrorCode, (i & 2) != 0 ? null : downloadFailureDetails);
        }

        public final ArchivePackageDownloadErrorCode getCode() {
            return this.code;
        }

        public final DownloadFailureDetails getDetails() {
            return this.details;
        }
    }
}
