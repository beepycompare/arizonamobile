package com.arizona.launcher.updater.archive.transaction;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArchiveFileRetirement.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/arizona/launcher/updater/archive/transaction/ArchiveTrashCleanupResult;", "", "Success", "Failure", "Lcom/arizona/launcher/updater/archive/transaction/ArchiveTrashCleanupResult$Failure;", "Lcom/arizona/launcher/updater/archive/transaction/ArchiveTrashCleanupResult$Success;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface ArchiveTrashCleanupResult {

    /* compiled from: ArchiveFileRetirement.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007Ê\u0001\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0011"}, d2 = {"Lcom/arizona/launcher/updater/archive/transaction/ArchiveTrashCleanupResult$Success;", "Lcom/arizona/launcher/updater/archive/transaction/ArchiveTrashCleanupResult;", "deletedFiles", "", "<init>", "(I)V", "getDeletedFiles", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Success implements ArchiveTrashCleanupResult {
        public static final int $stable = 0;
        private final int deletedFiles;

        public static /* synthetic */ Success copy$default(Success success, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = success.deletedFiles;
            }
            return success.copy(i);
        }

        public final int component1() {
            return this.deletedFiles;
        }

        public final Success copy(int i) {
            return new Success(i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Success) && this.deletedFiles == ((Success) obj).deletedFiles;
        }

        public int hashCode() {
            return Integer.hashCode(this.deletedFiles);
        }

        public String toString() {
            return "Success(deletedFiles=" + this.deletedFiles + ")";
        }

        public Success(int i) {
            this.deletedFiles = i;
        }

        public final int getDeletedFiles() {
            return this.deletedFiles;
        }
    }

    /* compiled from: ArchiveFileRetirement.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J5\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0014\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0083\u0004J\n\u0010\u001b\u001a\u00020\bHÖ\u0081\u0004J\n\u0010\u001c\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011Ê\u0001\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u001d"}, d2 = {"Lcom/arizona/launcher/updater/archive/transaction/ArchiveTrashCleanupResult$Failure;", "Lcom/arizona/launcher/updater/archive/transaction/ArchiveTrashCleanupResult;", "code", "Lcom/arizona/launcher/updater/archive/transaction/ArchiveRetirementErrorCode;", "relativePath", "", "detail", "deletedFiles", "", "<init>", "(Lcom/arizona/launcher/updater/archive/transaction/ArchiveRetirementErrorCode;Ljava/lang/String;Ljava/lang/String;I)V", "getCode", "()Lcom/arizona/launcher/updater/archive/transaction/ArchiveRetirementErrorCode;", "getRelativePath", "()Ljava/lang/String;", "getDetail", "getDeletedFiles", "()I", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Failure implements ArchiveTrashCleanupResult {
        public static final int $stable = 0;
        private final ArchiveRetirementErrorCode code;
        private final int deletedFiles;
        private final String detail;
        private final String relativePath;

        public static /* synthetic */ Failure copy$default(Failure failure, ArchiveRetirementErrorCode archiveRetirementErrorCode, String str, String str2, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                archiveRetirementErrorCode = failure.code;
            }
            if ((i2 & 2) != 0) {
                str = failure.relativePath;
            }
            if ((i2 & 4) != 0) {
                str2 = failure.detail;
            }
            if ((i2 & 8) != 0) {
                i = failure.deletedFiles;
            }
            return failure.copy(archiveRetirementErrorCode, str, str2, i);
        }

        public final ArchiveRetirementErrorCode component1() {
            return this.code;
        }

        public final String component2() {
            return this.relativePath;
        }

        public final String component3() {
            return this.detail;
        }

        public final int component4() {
            return this.deletedFiles;
        }

        public final Failure copy(ArchiveRetirementErrorCode code, String str, String str2, int i) {
            Intrinsics.checkNotNullParameter(code, "code");
            return new Failure(code, str, str2, i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Failure) {
                Failure failure = (Failure) obj;
                return this.code == failure.code && Intrinsics.areEqual(this.relativePath, failure.relativePath) && Intrinsics.areEqual(this.detail, failure.detail) && this.deletedFiles == failure.deletedFiles;
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.code.hashCode() * 31;
            String str = this.relativePath;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.detail;
            return ((hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + Integer.hashCode(this.deletedFiles);
        }

        public String toString() {
            ArchiveRetirementErrorCode archiveRetirementErrorCode = this.code;
            String str = this.relativePath;
            String str2 = this.detail;
            return "Failure(code=" + archiveRetirementErrorCode + ", relativePath=" + str + ", detail=" + str2 + ", deletedFiles=" + this.deletedFiles + ")";
        }

        public Failure(ArchiveRetirementErrorCode code, String str, String str2, int i) {
            Intrinsics.checkNotNullParameter(code, "code");
            this.code = code;
            this.relativePath = str;
            this.detail = str2;
            this.deletedFiles = i;
        }

        public /* synthetic */ Failure(ArchiveRetirementErrorCode archiveRetirementErrorCode, String str, String str2, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(archiveRetirementErrorCode, (i2 & 2) != 0 ? null : str, (i2 & 4) != 0 ? null : str2, (i2 & 8) != 0 ? 0 : i);
        }

        public final ArchiveRetirementErrorCode getCode() {
            return this.code;
        }

        public final String getRelativePath() {
            return this.relativePath;
        }

        public final String getDetail() {
            return this.detail;
        }

        public final int getDeletedFiles() {
            return this.deletedFiles;
        }
    }
}
