package com.arizona.launcher.updater.archive.adoption;

import com.arizona.launcher.updater.archive.model.ArchivePackage;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArchiveInstallAdopter.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001B=\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J\t\u0010\u0019\u001a\u00020\bHÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u000bHÆ\u0003JI\u0010\u001b\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\u0014\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001f\u001a\u00020 HÖ\u0081\u0004J\n\u0010!\u001a\u00020\"HÖ\u0081\u0004R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015Ê\u0001\f\b$\u0012\b\b%\u0012\u0004\b\u0003\u0010\u0002¨\u0006#"}, d2 = {"Lcom/arizona/launcher/updater/archive/adoption/ArchiveAdoptionScanResult;", "", "adoptedPackages", "", "Lcom/arizona/launcher/updater/archive/adoption/AdoptedArchivePackage;", "packagesNeedingFullArchive", "Lcom/arizona/launcher/updater/archive/model/ArchivePackage;", "scannedFiles", "", "scannedBytes", "firstMismatch", "Lcom/arizona/launcher/updater/archive/adoption/ArchiveAdoptionMismatch;", "<init>", "(Ljava/util/List;Ljava/util/List;JJLcom/arizona/launcher/updater/archive/adoption/ArchiveAdoptionMismatch;)V", "getAdoptedPackages", "()Ljava/util/List;", "getPackagesNeedingFullArchive", "getScannedFiles", "()J", "getScannedBytes", "getFirstMismatch", "()Lcom/arizona/launcher/updater/archive/adoption/ArchiveAdoptionMismatch;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveAdoptionScanResult {
    public static final int $stable = 0;
    private final List<AdoptedArchivePackage> adoptedPackages;
    private final ArchiveAdoptionMismatch firstMismatch;
    private final List<ArchivePackage> packagesNeedingFullArchive;
    private final long scannedBytes;
    private final long scannedFiles;

    public static /* synthetic */ ArchiveAdoptionScanResult copy$default(ArchiveAdoptionScanResult archiveAdoptionScanResult, List list, List list2, long j, long j2, ArchiveAdoptionMismatch archiveAdoptionMismatch, int i, Object obj) {
        List<AdoptedArchivePackage> list3 = list;
        if ((i & 1) != 0) {
            list3 = archiveAdoptionScanResult.adoptedPackages;
        }
        List<ArchivePackage> list4 = list2;
        if ((i & 2) != 0) {
            list4 = archiveAdoptionScanResult.packagesNeedingFullArchive;
        }
        if ((i & 4) != 0) {
            j = archiveAdoptionScanResult.scannedFiles;
        }
        if ((i & 8) != 0) {
            j2 = archiveAdoptionScanResult.scannedBytes;
        }
        if ((i & 16) != 0) {
            archiveAdoptionMismatch = archiveAdoptionScanResult.firstMismatch;
        }
        ArchiveAdoptionMismatch archiveAdoptionMismatch2 = archiveAdoptionMismatch;
        long j3 = j2;
        return archiveAdoptionScanResult.copy(list3, list4, j, j3, archiveAdoptionMismatch2);
    }

    public final List<AdoptedArchivePackage> component1() {
        return this.adoptedPackages;
    }

    public final List<ArchivePackage> component2() {
        return this.packagesNeedingFullArchive;
    }

    public final long component3() {
        return this.scannedFiles;
    }

    public final long component4() {
        return this.scannedBytes;
    }

    public final ArchiveAdoptionMismatch component5() {
        return this.firstMismatch;
    }

    public final ArchiveAdoptionScanResult copy(List<AdoptedArchivePackage> adoptedPackages, List<ArchivePackage> packagesNeedingFullArchive, long j, long j2, ArchiveAdoptionMismatch archiveAdoptionMismatch) {
        Intrinsics.checkNotNullParameter(adoptedPackages, "adoptedPackages");
        Intrinsics.checkNotNullParameter(packagesNeedingFullArchive, "packagesNeedingFullArchive");
        return new ArchiveAdoptionScanResult(adoptedPackages, packagesNeedingFullArchive, j, j2, archiveAdoptionMismatch);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ArchiveAdoptionScanResult) {
            ArchiveAdoptionScanResult archiveAdoptionScanResult = (ArchiveAdoptionScanResult) obj;
            return Intrinsics.areEqual(this.adoptedPackages, archiveAdoptionScanResult.adoptedPackages) && Intrinsics.areEqual(this.packagesNeedingFullArchive, archiveAdoptionScanResult.packagesNeedingFullArchive) && this.scannedFiles == archiveAdoptionScanResult.scannedFiles && this.scannedBytes == archiveAdoptionScanResult.scannedBytes && Intrinsics.areEqual(this.firstMismatch, archiveAdoptionScanResult.firstMismatch);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((((this.adoptedPackages.hashCode() * 31) + this.packagesNeedingFullArchive.hashCode()) * 31) + Long.hashCode(this.scannedFiles)) * 31) + Long.hashCode(this.scannedBytes)) * 31;
        ArchiveAdoptionMismatch archiveAdoptionMismatch = this.firstMismatch;
        return hashCode + (archiveAdoptionMismatch == null ? 0 : archiveAdoptionMismatch.hashCode());
    }

    public String toString() {
        List<AdoptedArchivePackage> list = this.adoptedPackages;
        List<ArchivePackage> list2 = this.packagesNeedingFullArchive;
        long j = this.scannedFiles;
        long j2 = this.scannedBytes;
        return "ArchiveAdoptionScanResult(adoptedPackages=" + list + ", packagesNeedingFullArchive=" + list2 + ", scannedFiles=" + j + ", scannedBytes=" + j2 + ", firstMismatch=" + this.firstMismatch + ")";
    }

    public ArchiveAdoptionScanResult(List<AdoptedArchivePackage> adoptedPackages, List<ArchivePackage> packagesNeedingFullArchive, long j, long j2, ArchiveAdoptionMismatch archiveAdoptionMismatch) {
        Intrinsics.checkNotNullParameter(adoptedPackages, "adoptedPackages");
        Intrinsics.checkNotNullParameter(packagesNeedingFullArchive, "packagesNeedingFullArchive");
        this.adoptedPackages = adoptedPackages;
        this.packagesNeedingFullArchive = packagesNeedingFullArchive;
        this.scannedFiles = j;
        this.scannedBytes = j2;
        this.firstMismatch = archiveAdoptionMismatch;
    }

    public final List<AdoptedArchivePackage> getAdoptedPackages() {
        return this.adoptedPackages;
    }

    public final List<ArchivePackage> getPackagesNeedingFullArchive() {
        return this.packagesNeedingFullArchive;
    }

    public final long getScannedFiles() {
        return this.scannedFiles;
    }

    public final long getScannedBytes() {
        return this.scannedBytes;
    }

    public final ArchiveAdoptionMismatch getFirstMismatch() {
        return this.firstMismatch;
    }
}
