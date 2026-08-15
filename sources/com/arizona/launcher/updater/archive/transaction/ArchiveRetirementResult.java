package com.arizona.launcher.updater.archive.transaction;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArchiveFileRetirement.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bp\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/arizona/launcher/updater/archive/transaction/ArchiveRetirementResult;", "", "Success", "Failure", "Lcom/arizona/launcher/updater/archive/transaction/ArchiveRetirementResult$Failure;", "Lcom/arizona/launcher/updater/archive/transaction/ArchiveRetirementResult$Success;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface ArchiveRetirementResult {

    /* compiled from: ArchiveFileRetirement.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J)\u0010\r\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0014\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0004HÖ\u0081\u0004R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tÊ\u0001\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0015"}, d2 = {"Lcom/arizona/launcher/updater/archive/transaction/ArchiveRetirementResult$Success;", "Lcom/arizona/launcher/updater/archive/transaction/ArchiveRetirementResult;", "quarantinedPaths", "", "", "alreadyQuarantinedPaths", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getQuarantinedPaths", "()Ljava/util/List;", "getAlreadyQuarantinedPaths", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Success implements ArchiveRetirementResult {
        public static final int $stable = 0;
        private final List<String> alreadyQuarantinedPaths;
        private final List<String> quarantinedPaths;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Success copy$default(Success success, List list, List list2, int i, Object obj) {
            if ((i & 1) != 0) {
                list = success.quarantinedPaths;
            }
            if ((i & 2) != 0) {
                list2 = success.alreadyQuarantinedPaths;
            }
            return success.copy(list, list2);
        }

        public final List<String> component1() {
            return this.quarantinedPaths;
        }

        public final List<String> component2() {
            return this.alreadyQuarantinedPaths;
        }

        public final Success copy(List<String> quarantinedPaths, List<String> alreadyQuarantinedPaths) {
            Intrinsics.checkNotNullParameter(quarantinedPaths, "quarantinedPaths");
            Intrinsics.checkNotNullParameter(alreadyQuarantinedPaths, "alreadyQuarantinedPaths");
            return new Success(quarantinedPaths, alreadyQuarantinedPaths);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Success) {
                Success success = (Success) obj;
                return Intrinsics.areEqual(this.quarantinedPaths, success.quarantinedPaths) && Intrinsics.areEqual(this.alreadyQuarantinedPaths, success.alreadyQuarantinedPaths);
            }
            return false;
        }

        public int hashCode() {
            return (this.quarantinedPaths.hashCode() * 31) + this.alreadyQuarantinedPaths.hashCode();
        }

        public String toString() {
            List<String> list = this.quarantinedPaths;
            return "Success(quarantinedPaths=" + list + ", alreadyQuarantinedPaths=" + this.alreadyQuarantinedPaths + ")";
        }

        public Success(List<String> quarantinedPaths, List<String> alreadyQuarantinedPaths) {
            Intrinsics.checkNotNullParameter(quarantinedPaths, "quarantinedPaths");
            Intrinsics.checkNotNullParameter(alreadyQuarantinedPaths, "alreadyQuarantinedPaths");
            this.quarantinedPaths = quarantinedPaths;
            this.alreadyQuarantinedPaths = alreadyQuarantinedPaths;
        }

        public final List<String> getQuarantinedPaths() {
            return this.quarantinedPaths;
        }

        public final List<String> getAlreadyQuarantinedPaths() {
            return this.alreadyQuarantinedPaths;
        }
    }

    /* compiled from: ArchiveFileRetirement.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\b\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\b¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\bHÆ\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\bHÆ\u0003JK\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\bHÆ\u0001J\u0014\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0083\u0004J\n\u0010\u001e\u001a\u00020\u001fHÖ\u0081\u0004J\n\u0010 \u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012Ê\u0001\f\b\"\u0012\b\b#\u0012\u0004\b\u0003\u0010\u0002¨\u0006!"}, d2 = {"Lcom/arizona/launcher/updater/archive/transaction/ArchiveRetirementResult$Failure;", "Lcom/arizona/launcher/updater/archive/transaction/ArchiveRetirementResult;", "code", "Lcom/arizona/launcher/updater/archive/transaction/ArchiveRetirementErrorCode;", "relativePath", "", "detail", "quarantinedPaths", "", "alreadyQuarantinedPaths", "<init>", "(Lcom/arizona/launcher/updater/archive/transaction/ArchiveRetirementErrorCode;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "getCode", "()Lcom/arizona/launcher/updater/archive/transaction/ArchiveRetirementErrorCode;", "getRelativePath", "()Ljava/lang/String;", "getDetail", "getQuarantinedPaths", "()Ljava/util/List;", "getAlreadyQuarantinedPaths", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Failure implements ArchiveRetirementResult {
        public static final int $stable = 0;
        private final List<String> alreadyQuarantinedPaths;
        private final ArchiveRetirementErrorCode code;
        private final String detail;
        private final List<String> quarantinedPaths;
        private final String relativePath;

        public static /* synthetic */ Failure copy$default(Failure failure, ArchiveRetirementErrorCode archiveRetirementErrorCode, String str, String str2, List list, List list2, int i, Object obj) {
            if ((i & 1) != 0) {
                archiveRetirementErrorCode = failure.code;
            }
            if ((i & 2) != 0) {
                str = failure.relativePath;
            }
            if ((i & 4) != 0) {
                str2 = failure.detail;
            }
            List<String> list3 = list;
            if ((i & 8) != 0) {
                list3 = failure.quarantinedPaths;
            }
            List<String> list4 = list2;
            if ((i & 16) != 0) {
                list4 = failure.alreadyQuarantinedPaths;
            }
            List list5 = list4;
            String str3 = str2;
            return failure.copy(archiveRetirementErrorCode, str, str3, list3, list5);
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

        public final List<String> component4() {
            return this.quarantinedPaths;
        }

        public final List<String> component5() {
            return this.alreadyQuarantinedPaths;
        }

        public final Failure copy(ArchiveRetirementErrorCode code, String str, String str2, List<String> quarantinedPaths, List<String> alreadyQuarantinedPaths) {
            Intrinsics.checkNotNullParameter(code, "code");
            Intrinsics.checkNotNullParameter(quarantinedPaths, "quarantinedPaths");
            Intrinsics.checkNotNullParameter(alreadyQuarantinedPaths, "alreadyQuarantinedPaths");
            return new Failure(code, str, str2, quarantinedPaths, alreadyQuarantinedPaths);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Failure) {
                Failure failure = (Failure) obj;
                return this.code == failure.code && Intrinsics.areEqual(this.relativePath, failure.relativePath) && Intrinsics.areEqual(this.detail, failure.detail) && Intrinsics.areEqual(this.quarantinedPaths, failure.quarantinedPaths) && Intrinsics.areEqual(this.alreadyQuarantinedPaths, failure.alreadyQuarantinedPaths);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.code.hashCode() * 31;
            String str = this.relativePath;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.detail;
            return ((((hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31) + this.quarantinedPaths.hashCode()) * 31) + this.alreadyQuarantinedPaths.hashCode();
        }

        public String toString() {
            ArchiveRetirementErrorCode archiveRetirementErrorCode = this.code;
            String str = this.relativePath;
            String str2 = this.detail;
            List<String> list = this.quarantinedPaths;
            return "Failure(code=" + archiveRetirementErrorCode + ", relativePath=" + str + ", detail=" + str2 + ", quarantinedPaths=" + list + ", alreadyQuarantinedPaths=" + this.alreadyQuarantinedPaths + ")";
        }

        public Failure(ArchiveRetirementErrorCode code, String str, String str2, List<String> quarantinedPaths, List<String> alreadyQuarantinedPaths) {
            Intrinsics.checkNotNullParameter(code, "code");
            Intrinsics.checkNotNullParameter(quarantinedPaths, "quarantinedPaths");
            Intrinsics.checkNotNullParameter(alreadyQuarantinedPaths, "alreadyQuarantinedPaths");
            this.code = code;
            this.relativePath = str;
            this.detail = str2;
            this.quarantinedPaths = quarantinedPaths;
            this.alreadyQuarantinedPaths = alreadyQuarantinedPaths;
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

        public /* synthetic */ Failure(ArchiveRetirementErrorCode archiveRetirementErrorCode, String str, String str2, List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(archiveRetirementErrorCode, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? CollectionsKt.emptyList() : list, (i & 16) != 0 ? CollectionsKt.emptyList() : list2);
        }

        public final List<String> getQuarantinedPaths() {
            return this.quarantinedPaths;
        }

        public final List<String> getAlreadyQuarantinedPaths() {
            return this.alreadyQuarantinedPaths;
        }
    }
}
