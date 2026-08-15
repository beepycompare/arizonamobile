package com.arizona.launcher.updater.archive.install;

import com.arizona.launcher.updater.archive.manifest.OriginalTzArchiveManifestParser;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SafeZipExtractor.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/arizona/launcher/updater/archive/install/SafeZipExtractionResult;", "", "Success", "Failure", "Lcom/arizona/launcher/updater/archive/install/SafeZipExtractionResult$Failure;", "Lcom/arizona/launcher/updater/archive/install/SafeZipExtractionResult$Success;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface SafeZipExtractionResult {

    /* compiled from: SafeZipExtractor.kt */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\u000f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003JA\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0001J\u0014\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0083\u0004J\n\u0010\u001f\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010 \u001a\u00020!HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014Ê\u0001\f\b#\u0012\b\b$\u0012\u0004\b\u0003\u0010\u0000¨\u0006\""}, d2 = {"Lcom/arizona/launcher/updater/archive/install/SafeZipExtractionResult$Success;", "Lcom/arizona/launcher/updater/archive/install/SafeZipExtractionResult;", "entryCount", "", "fileCount", "directoryCount", "totalUncompressedBytes", "", OriginalTzArchiveManifestParser.FILES_ROOT, "", "Lcom/arizona/launcher/updater/archive/install/ExtractedZipFile;", "<init>", "(IIIJLjava/util/List;)V", "getEntryCount", "()I", "getFileCount", "getDirectoryCount", "getTotalUncompressedBytes", "()J", "getFiles", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Success implements SafeZipExtractionResult {
        public static final int $stable = 8;
        private final int directoryCount;
        private final int entryCount;
        private final int fileCount;
        private final List<ExtractedZipFile> files;
        private final long totalUncompressedBytes;

        public static /* synthetic */ Success copy$default(Success success, int i, int i2, int i3, long j, List list, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                i = success.entryCount;
            }
            if ((i4 & 2) != 0) {
                i2 = success.fileCount;
            }
            if ((i4 & 4) != 0) {
                i3 = success.directoryCount;
            }
            if ((i4 & 8) != 0) {
                j = success.totalUncompressedBytes;
            }
            List<ExtractedZipFile> list2 = list;
            if ((i4 & 16) != 0) {
                list2 = success.files;
            }
            List list3 = list2;
            int i5 = i3;
            return success.copy(i, i2, i5, j, list3);
        }

        public final int component1() {
            return this.entryCount;
        }

        public final int component2() {
            return this.fileCount;
        }

        public final int component3() {
            return this.directoryCount;
        }

        public final long component4() {
            return this.totalUncompressedBytes;
        }

        public final List<ExtractedZipFile> component5() {
            return this.files;
        }

        public final Success copy(int i, int i2, int i3, long j, List<ExtractedZipFile> files) {
            Intrinsics.checkNotNullParameter(files, "files");
            return new Success(i, i2, i3, j, files);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Success) {
                Success success = (Success) obj;
                return this.entryCount == success.entryCount && this.fileCount == success.fileCount && this.directoryCount == success.directoryCount && this.totalUncompressedBytes == success.totalUncompressedBytes && Intrinsics.areEqual(this.files, success.files);
            }
            return false;
        }

        public int hashCode() {
            return (((((((Integer.hashCode(this.entryCount) * 31) + Integer.hashCode(this.fileCount)) * 31) + Integer.hashCode(this.directoryCount)) * 31) + Long.hashCode(this.totalUncompressedBytes)) * 31) + this.files.hashCode();
        }

        public String toString() {
            int i = this.entryCount;
            int i2 = this.fileCount;
            int i3 = this.directoryCount;
            long j = this.totalUncompressedBytes;
            return "Success(entryCount=" + i + ", fileCount=" + i2 + ", directoryCount=" + i3 + ", totalUncompressedBytes=" + j + ", files=" + this.files + ")";
        }

        public Success(int i, int i2, int i3, long j, List<ExtractedZipFile> files) {
            Intrinsics.checkNotNullParameter(files, "files");
            this.entryCount = i;
            this.fileCount = i2;
            this.directoryCount = i3;
            this.totalUncompressedBytes = j;
            this.files = files;
        }

        public final int getEntryCount() {
            return this.entryCount;
        }

        public final int getFileCount() {
            return this.fileCount;
        }

        public final int getDirectoryCount() {
            return this.directoryCount;
        }

        public final long getTotalUncompressedBytes() {
            return this.totalUncompressedBytes;
        }

        public final List<ExtractedZipFile> getFiles() {
            return this.files;
        }
    }

    /* compiled from: SafeZipExtractor.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bÊ\u0001\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0016"}, d2 = {"Lcom/arizona/launcher/updater/archive/install/SafeZipExtractionResult$Failure;", "Lcom/arizona/launcher/updater/archive/install/SafeZipExtractionResult;", "code", "Lcom/arizona/launcher/updater/archive/install/SafeZipExtractionErrorCode;", "entryName", "", "<init>", "(Lcom/arizona/launcher/updater/archive/install/SafeZipExtractionErrorCode;Ljava/lang/String;)V", "getCode", "()Lcom/arizona/launcher/updater/archive/install/SafeZipExtractionErrorCode;", "getEntryName", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Failure implements SafeZipExtractionResult {
        public static final int $stable = 0;
        private final SafeZipExtractionErrorCode code;
        private final String entryName;

        public static /* synthetic */ Failure copy$default(Failure failure, SafeZipExtractionErrorCode safeZipExtractionErrorCode, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                safeZipExtractionErrorCode = failure.code;
            }
            if ((i & 2) != 0) {
                str = failure.entryName;
            }
            return failure.copy(safeZipExtractionErrorCode, str);
        }

        public final SafeZipExtractionErrorCode component1() {
            return this.code;
        }

        public final String component2() {
            return this.entryName;
        }

        public final Failure copy(SafeZipExtractionErrorCode code, String str) {
            Intrinsics.checkNotNullParameter(code, "code");
            return new Failure(code, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Failure) {
                Failure failure = (Failure) obj;
                return this.code == failure.code && Intrinsics.areEqual(this.entryName, failure.entryName);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.code.hashCode() * 31;
            String str = this.entryName;
            return hashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            SafeZipExtractionErrorCode safeZipExtractionErrorCode = this.code;
            return "Failure(code=" + safeZipExtractionErrorCode + ", entryName=" + this.entryName + ")";
        }

        public Failure(SafeZipExtractionErrorCode code, String str) {
            Intrinsics.checkNotNullParameter(code, "code");
            this.code = code;
            this.entryName = str;
        }

        public /* synthetic */ Failure(SafeZipExtractionErrorCode safeZipExtractionErrorCode, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(safeZipExtractionErrorCode, (i & 2) != 0 ? null : str);
        }

        public final SafeZipExtractionErrorCode getCode() {
            return this.code;
        }

        public final String getEntryName() {
            return this.entryName;
        }
    }
}
