package com.arizona.launcher.updater.archive.manifest;

import com.arizona.launcher.updater.archive.model.ArchiveGpu;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: OriginalTzArchiveManifestParser.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J-\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0014\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0018\u001a\u00020\u0019HÖ\u0081\u0004J\n\u0010\u001a\u001a\u00020\u0005HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010Ê\u0001\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u001b"}, d2 = {"Lcom/arizona/launcher/updater/archive/manifest/OriginalTzArchiveManifestDescriptor;", "", "selectedGpu", "Lcom/arizona/launcher/updater/archive/model/ArchiveGpu;", "manifestVersion", "", "packages", "", "Lcom/arizona/launcher/updater/archive/manifest/OriginalTzArchivePackageDescriptor;", "<init>", "(Lcom/arizona/launcher/updater/archive/model/ArchiveGpu;Ljava/lang/String;Ljava/util/List;)V", "getSelectedGpu", "()Lcom/arizona/launcher/updater/archive/model/ArchiveGpu;", "getManifestVersion", "()Ljava/lang/String;", "getPackages", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class OriginalTzArchiveManifestDescriptor {
    public static final int $stable = 8;
    private final String manifestVersion;
    private final List<OriginalTzArchivePackageDescriptor> packages;
    private final ArchiveGpu selectedGpu;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OriginalTzArchiveManifestDescriptor copy$default(OriginalTzArchiveManifestDescriptor originalTzArchiveManifestDescriptor, ArchiveGpu archiveGpu, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            archiveGpu = originalTzArchiveManifestDescriptor.selectedGpu;
        }
        if ((i & 2) != 0) {
            str = originalTzArchiveManifestDescriptor.manifestVersion;
        }
        if ((i & 4) != 0) {
            list = originalTzArchiveManifestDescriptor.packages;
        }
        return originalTzArchiveManifestDescriptor.copy(archiveGpu, str, list);
    }

    public final ArchiveGpu component1() {
        return this.selectedGpu;
    }

    public final String component2() {
        return this.manifestVersion;
    }

    public final List<OriginalTzArchivePackageDescriptor> component3() {
        return this.packages;
    }

    public final OriginalTzArchiveManifestDescriptor copy(ArchiveGpu selectedGpu, String manifestVersion, List<OriginalTzArchivePackageDescriptor> packages) {
        Intrinsics.checkNotNullParameter(selectedGpu, "selectedGpu");
        Intrinsics.checkNotNullParameter(manifestVersion, "manifestVersion");
        Intrinsics.checkNotNullParameter(packages, "packages");
        return new OriginalTzArchiveManifestDescriptor(selectedGpu, manifestVersion, packages);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OriginalTzArchiveManifestDescriptor) {
            OriginalTzArchiveManifestDescriptor originalTzArchiveManifestDescriptor = (OriginalTzArchiveManifestDescriptor) obj;
            return this.selectedGpu == originalTzArchiveManifestDescriptor.selectedGpu && Intrinsics.areEqual(this.manifestVersion, originalTzArchiveManifestDescriptor.manifestVersion) && Intrinsics.areEqual(this.packages, originalTzArchiveManifestDescriptor.packages);
        }
        return false;
    }

    public int hashCode() {
        return (((this.selectedGpu.hashCode() * 31) + this.manifestVersion.hashCode()) * 31) + this.packages.hashCode();
    }

    public String toString() {
        ArchiveGpu archiveGpu = this.selectedGpu;
        String str = this.manifestVersion;
        return "OriginalTzArchiveManifestDescriptor(selectedGpu=" + archiveGpu + ", manifestVersion=" + str + ", packages=" + this.packages + ")";
    }

    public OriginalTzArchiveManifestDescriptor(ArchiveGpu selectedGpu, String manifestVersion, List<OriginalTzArchivePackageDescriptor> packages) {
        Intrinsics.checkNotNullParameter(selectedGpu, "selectedGpu");
        Intrinsics.checkNotNullParameter(manifestVersion, "manifestVersion");
        Intrinsics.checkNotNullParameter(packages, "packages");
        this.selectedGpu = selectedGpu;
        this.manifestVersion = manifestVersion;
        this.packages = packages;
    }

    public final ArchiveGpu getSelectedGpu() {
        return this.selectedGpu;
    }

    public final String getManifestVersion() {
        return this.manifestVersion;
    }

    public final List<OriginalTzArchivePackageDescriptor> getPackages() {
        return this.packages;
    }
}
