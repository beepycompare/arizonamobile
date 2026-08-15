package com.arizona.launcher.updater.archive.adoption;

import coil3.util.UtilsKt;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArchiveInstallAdopter.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\br\u0018\u00002\u00020\u0001:\u0002\u0002\u0003\u0082\u0001\u0002\u0004\u0005¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/arizona/launcher/updater/archive/adoption/TargetResolution;", "", "Success", "Failure", "Lcom/arizona/launcher/updater/archive/adoption/TargetResolution$Failure;", "Lcom/arizona/launcher/updater/archive/adoption/TargetResolution$Success;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
interface TargetResolution {

    /* compiled from: ArchiveInstallAdopter.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007Ê\u0001\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u0012"}, d2 = {"Lcom/arizona/launcher/updater/archive/adoption/TargetResolution$Success;", "Lcom/arizona/launcher/updater/archive/adoption/TargetResolution;", UtilsKt.SCHEME_FILE, "Ljava/io/File;", "<init>", "(Ljava/io/File;)V", "getFile", "()Ljava/io/File;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Success implements TargetResolution {
        public static final int $stable = 8;
        private final File file;

        public static /* synthetic */ Success copy$default(Success success, File file, int i, Object obj) {
            if ((i & 1) != 0) {
                file = success.file;
            }
            return success.copy(file);
        }

        public final File component1() {
            return this.file;
        }

        public final Success copy(File file) {
            Intrinsics.checkNotNullParameter(file, "file");
            return new Success(file);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Success) && Intrinsics.areEqual(this.file, ((Success) obj).file);
        }

        public int hashCode() {
            return this.file.hashCode();
        }

        public String toString() {
            return "Success(file=" + this.file + ")";
        }

        public Success(File file) {
            Intrinsics.checkNotNullParameter(file, "file");
            this.file = file;
        }

        public final File getFile() {
            return this.file;
        }
    }

    /* compiled from: ArchiveInstallAdopter.kt */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0083\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007Ê\u0001\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0012"}, d2 = {"Lcom/arizona/launcher/updater/archive/adoption/TargetResolution$Failure;", "Lcom/arizona/launcher/updater/archive/adoption/TargetResolution;", "reason", "Lcom/arizona/launcher/updater/archive/adoption/ArchiveAdoptionMismatchReason;", "<init>", "(Lcom/arizona/launcher/updater/archive/adoption/ArchiveAdoptionMismatchReason;)V", "getReason", "()Lcom/arizona/launcher/updater/archive/adoption/ArchiveAdoptionMismatchReason;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Failure implements TargetResolution {
        public static final int $stable = 0;
        private final ArchiveAdoptionMismatchReason reason;

        public static /* synthetic */ Failure copy$default(Failure failure, ArchiveAdoptionMismatchReason archiveAdoptionMismatchReason, int i, Object obj) {
            if ((i & 1) != 0) {
                archiveAdoptionMismatchReason = failure.reason;
            }
            return failure.copy(archiveAdoptionMismatchReason);
        }

        public final ArchiveAdoptionMismatchReason component1() {
            return this.reason;
        }

        public final Failure copy(ArchiveAdoptionMismatchReason reason) {
            Intrinsics.checkNotNullParameter(reason, "reason");
            return new Failure(reason);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Failure) && this.reason == ((Failure) obj).reason;
        }

        public int hashCode() {
            return this.reason.hashCode();
        }

        public String toString() {
            return "Failure(reason=" + this.reason + ")";
        }

        public Failure(ArchiveAdoptionMismatchReason reason) {
            Intrinsics.checkNotNullParameter(reason, "reason");
            this.reason = reason;
        }

        public final ArchiveAdoptionMismatchReason getReason() {
            return this.reason;
        }
    }
}
