package com.arizona.launcher.updater.archive.adoption;

import com.arizona.launcher.updater.archive.manifest.OriginalTzArchiveManifestParser;
import com.arizona.launcher.updater.archive.model.ArchivePackage;
import com.arizona.launcher.updater.archive.state.ArchivePackageFileRecord;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArchiveInstallAdopter.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fÊ\u0001\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u0017"}, d2 = {"Lcom/arizona/launcher/updater/archive/adoption/AdoptedArchivePackage;", "", "archivePackage", "Lcom/arizona/launcher/updater/archive/model/ArchivePackage;", OriginalTzArchiveManifestParser.FILES_ROOT, "", "Lcom/arizona/launcher/updater/archive/state/ArchivePackageFileRecord;", "<init>", "(Lcom/arizona/launcher/updater/archive/model/ArchivePackage;Ljava/util/List;)V", "getArchivePackage", "()Lcom/arizona/launcher/updater/archive/model/ArchivePackage;", "getFiles", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AdoptedArchivePackage {
    public static final int $stable = ArchivePackage.$stable;
    private final ArchivePackage archivePackage;
    private final List<ArchivePackageFileRecord> files;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AdoptedArchivePackage copy$default(AdoptedArchivePackage adoptedArchivePackage, ArchivePackage archivePackage, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            archivePackage = adoptedArchivePackage.archivePackage;
        }
        if ((i & 2) != 0) {
            list = adoptedArchivePackage.files;
        }
        return adoptedArchivePackage.copy(archivePackage, list);
    }

    public final ArchivePackage component1() {
        return this.archivePackage;
    }

    public final List<ArchivePackageFileRecord> component2() {
        return this.files;
    }

    public final AdoptedArchivePackage copy(ArchivePackage archivePackage, List<ArchivePackageFileRecord> files) {
        Intrinsics.checkNotNullParameter(archivePackage, "archivePackage");
        Intrinsics.checkNotNullParameter(files, "files");
        return new AdoptedArchivePackage(archivePackage, files);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdoptedArchivePackage) {
            AdoptedArchivePackage adoptedArchivePackage = (AdoptedArchivePackage) obj;
            return Intrinsics.areEqual(this.archivePackage, adoptedArchivePackage.archivePackage) && Intrinsics.areEqual(this.files, adoptedArchivePackage.files);
        }
        return false;
    }

    public int hashCode() {
        return (this.archivePackage.hashCode() * 31) + this.files.hashCode();
    }

    public String toString() {
        ArchivePackage archivePackage = this.archivePackage;
        return "AdoptedArchivePackage(archivePackage=" + archivePackage + ", files=" + this.files + ")";
    }

    public AdoptedArchivePackage(ArchivePackage archivePackage, List<ArchivePackageFileRecord> files) {
        Intrinsics.checkNotNullParameter(archivePackage, "archivePackage");
        Intrinsics.checkNotNullParameter(files, "files");
        this.archivePackage = archivePackage;
        this.files = files;
    }

    public final ArchivePackage getArchivePackage() {
        return this.archivePackage;
    }

    public final List<ArchivePackageFileRecord> getFiles() {
        return this.files;
    }
}
