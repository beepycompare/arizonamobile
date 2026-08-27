package com.arizona.launcher.updater.archive.orchestrator;

import com.arizona.launcher.updater.archive.manifest.OriginalTzArchiveManifestParser;
import com.arizona.launcher.updater.archive.state.ArchivePackageFileRecord;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArchiveSelectivePackageInstaller.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveSelectiveInstallResult;", "", "Success", "Failure", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveSelectiveInstallResult$Failure;", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveSelectiveInstallResult$Success;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface ArchiveSelectiveInstallResult {

    /* compiled from: ArchiveSelectivePackageInstaller.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0083\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fÊ\u0001\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u0018"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveSelectiveInstallResult$Success;", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveSelectiveInstallResult;", OriginalTzArchiveManifestParser.FILES_ROOT, "", "Lcom/arizona/launcher/updater/archive/state/ArchivePackageFileRecord;", "networkBytes", "", "<init>", "(Ljava/util/List;J)V", "getFiles", "()Ljava/util/List;", "getNetworkBytes", "()J", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Success implements ArchiveSelectiveInstallResult {
        public static final int $stable = 8;
        private final List<ArchivePackageFileRecord> files;
        private final long networkBytes;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Success copy$default(Success success, List list, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                list = success.files;
            }
            if ((i & 2) != 0) {
                j = success.networkBytes;
            }
            return success.copy(list, j);
        }

        public final List<ArchivePackageFileRecord> component1() {
            return this.files;
        }

        public final long component2() {
            return this.networkBytes;
        }

        public final Success copy(List<ArchivePackageFileRecord> files, long j) {
            Intrinsics.checkNotNullParameter(files, "files");
            return new Success(files, j);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Success) {
                Success success = (Success) obj;
                return Intrinsics.areEqual(this.files, success.files) && this.networkBytes == success.networkBytes;
            }
            return false;
        }

        public int hashCode() {
            return (this.files.hashCode() * 31) + Long.hashCode(this.networkBytes);
        }

        public String toString() {
            List<ArchivePackageFileRecord> list = this.files;
            return "Success(files=" + list + ", networkBytes=" + this.networkBytes + ")";
        }

        public Success(List<ArchivePackageFileRecord> files, long j) {
            Intrinsics.checkNotNullParameter(files, "files");
            this.files = files;
            this.networkBytes = j;
        }

        public final List<ArchivePackageFileRecord> getFiles() {
            return this.files;
        }

        public final long getNetworkBytes() {
            return this.networkBytes;
        }
    }

    /* compiled from: ArchiveSelectivePackageInstaller.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J)\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0014\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0083\u0004J\n\u0010\u0018\u001a\u00020\u0019HÖ\u0081\u0004J\n\u0010\u001a\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fÊ\u0001\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u001b"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveSelectiveInstallResult$Failure;", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveSelectiveInstallResult;", "code", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdaterErrorCode;", "detail", "", "networkBytes", "", "<init>", "(Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdaterErrorCode;Ljava/lang/String;J)V", "getCode", "()Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdaterErrorCode;", "getDetail", "()Ljava/lang/String;", "getNetworkBytes", "()J", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Failure implements ArchiveSelectiveInstallResult {
        public static final int $stable = 0;
        private final ArchiveUpdaterErrorCode code;
        private final String detail;
        private final long networkBytes;

        public static /* synthetic */ Failure copy$default(Failure failure, ArchiveUpdaterErrorCode archiveUpdaterErrorCode, String str, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                archiveUpdaterErrorCode = failure.code;
            }
            if ((i & 2) != 0) {
                str = failure.detail;
            }
            if ((i & 4) != 0) {
                j = failure.networkBytes;
            }
            return failure.copy(archiveUpdaterErrorCode, str, j);
        }

        public final ArchiveUpdaterErrorCode component1() {
            return this.code;
        }

        public final String component2() {
            return this.detail;
        }

        public final long component3() {
            return this.networkBytes;
        }

        public final Failure copy(ArchiveUpdaterErrorCode code, String str, long j) {
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
            ArchiveUpdaterErrorCode archiveUpdaterErrorCode = this.code;
            String str = this.detail;
            return "Failure(code=" + archiveUpdaterErrorCode + ", detail=" + str + ", networkBytes=" + this.networkBytes + ")";
        }

        public Failure(ArchiveUpdaterErrorCode code, String str, long j) {
            Intrinsics.checkNotNullParameter(code, "code");
            this.code = code;
            this.detail = str;
            this.networkBytes = j;
        }

        public /* synthetic */ Failure(ArchiveUpdaterErrorCode archiveUpdaterErrorCode, String str, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(archiveUpdaterErrorCode, (i & 2) != 0 ? null : str, (i & 4) != 0 ? 0L : j);
        }

        public final ArchiveUpdaterErrorCode getCode() {
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
