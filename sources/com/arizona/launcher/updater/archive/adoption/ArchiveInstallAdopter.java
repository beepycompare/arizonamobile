package com.arizona.launcher.updater.archive.adoption;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.arizona.launcher.updater.archive.adoption.ArchiveAdoptionFileVerification;
import com.arizona.launcher.updater.archive.adoption.GameRootResolution;
import com.arizona.launcher.updater.archive.adoption.TargetResolution;
import com.arizona.launcher.updater.archive.io.ArchiveLivePathSafety;
import com.arizona.launcher.updater.archive.model.ArchiveEntryMetadata;
import com.arizona.launcher.updater.archive.model.ArchiveManifest;
import com.arizona.launcher.updater.archive.model.ArchivePackage;
import com.arizona.launcher.updater.archive.state.ArchivePackageFileRecord;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArchiveInstallAdopter.kt */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u001e\u0010\u000e\u001a\u00020\t2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\f\u0010\u001b\u001a\u00020\u001c*\u00020\u001dH\u0002J\u0018\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000Ê\u0001\f\b$\u0012\b\b%\u0012\u0004\b\u0003\u0010\u0000¨\u0006#"}, d2 = {"Lcom/arizona/launcher/updater/archive/adoption/ArchiveInstallAdopter;", "", "pathSafety", "Lcom/arizona/launcher/updater/archive/io/ArchiveLivePathSafety;", "verifier", "Lcom/arizona/launcher/updater/archive/adoption/ArchiveAdoptionFileVerifier;", "<init>", "(Lcom/arizona/launcher/updater/archive/io/ArchiveLivePathSafety;Lcom/arizona/launcher/updater/archive/adoption/ArchiveAdoptionFileVerifier;)V", "scan", "Lcom/arizona/launcher/updater/archive/adoption/ArchiveAdoptionScanResult;", "gameRoot", "Ljava/io/File;", "manifest", "Lcom/arizona/launcher/updater/archive/model/ArchiveManifest;", "allPackagesNeedArchive", "packages", "", "Lcom/arizona/launcher/updater/archive/model/ArchivePackage;", "reason", "Lcom/arizona/launcher/updater/archive/adoption/ArchiveAdoptionMismatchReason;", "resolveGameRoot", "Lcom/arizona/launcher/updater/archive/adoption/GameRootResolution;", "resolveTarget", "Lcom/arizona/launcher/updater/archive/adoption/TargetResolution;", "canonicalRoot", "relativePath", "", "toFileRecord", "Lcom/arizona/launcher/updater/archive/state/ArchivePackageFileRecord;", "Lcom/arizona/launcher/updater/archive/model/ArchiveEntryMetadata;", "saturatedAdd", "", TtmlNode.LEFT, TtmlNode.RIGHT, "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveInstallAdopter {
    private final ArchiveLivePathSafety pathSafety;
    private final ArchiveAdoptionFileVerifier verifier;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = ArchiveLivePathSafety.$stable;

    private final long saturatedAdd(long j, long j2) {
        if (j > Long.MAX_VALUE - j2) {
            return Long.MAX_VALUE;
        }
        return j + j2;
    }

    public ArchiveInstallAdopter(ArchiveLivePathSafety pathSafety, ArchiveAdoptionFileVerifier verifier) {
        Intrinsics.checkNotNullParameter(pathSafety, "pathSafety");
        Intrinsics.checkNotNullParameter(verifier, "verifier");
        this.pathSafety = pathSafety;
        this.verifier = verifier;
    }

    public /* synthetic */ ArchiveInstallAdopter(ArchiveLivePathSafety archiveLivePathSafety, JvmArchiveAdoptionFileVerifier jvmArchiveAdoptionFileVerifier, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(archiveLivePathSafety, (i & 2) != 0 ? JvmArchiveAdoptionFileVerifier.INSTANCE : jvmArchiveAdoptionFileVerifier);
    }

    public final ArchiveAdoptionScanResult scan(File gameRoot, ArchiveManifest manifest) {
        File file;
        Iterator it;
        ArchiveAdoptionMismatch archiveAdoptionMismatch;
        ArchiveAdoptionFileVerification.Mismatch mismatch;
        Intrinsics.checkNotNullParameter(gameRoot, "gameRoot");
        Intrinsics.checkNotNullParameter(manifest, "manifest");
        List<ArchivePackage> packages = manifest.getPackages();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(packages, 10));
        for (ArchivePackage archivePackage : packages) {
            List<ArchiveEntryMetadata> entries = archivePackage.getEntries();
            if (entries == null) {
                throw new IllegalArgumentException(("archive package '" + archivePackage.getId() + "' must include entry metadata for adoption").toString());
            }
            arrayList.add(TuplesKt.to(archivePackage, entries));
        }
        ArrayList arrayList2 = arrayList;
        GameRootResolution resolveGameRoot = resolveGameRoot(gameRoot);
        if (resolveGameRoot instanceof GameRootResolution.Failure) {
            return allPackagesNeedArchive(manifest.getPackages(), ((GameRootResolution.Failure) resolveGameRoot).getReason());
        }
        Intrinsics.checkNotNull(resolveGameRoot, "null cannot be cast to non-null type com.arizona.launcher.updater.archive.adoption.GameRootResolution.Success");
        File canonicalRoot = ((GameRootResolution.Success) resolveGameRoot).getCanonicalRoot();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        Iterator it2 = arrayList2.iterator();
        long j = 0;
        long j2 = 0;
        ArchiveAdoptionMismatch archiveAdoptionMismatch2 = null;
        while (it2.hasNext()) {
            Pair pair = (Pair) it2.next();
            ArchivePackage archivePackage2 = (ArchivePackage) pair.component1();
            List list = (List) pair.component2();
            ArrayList arrayList5 = new ArrayList(list.size());
            Iterator it3 = list.iterator();
            while (true) {
                if (!it3.hasNext()) {
                    file = canonicalRoot;
                    it = it2;
                    archiveAdoptionMismatch = null;
                    break;
                }
                ArchiveEntryMetadata archiveEntryMetadata = (ArchiveEntryMetadata) it3.next();
                j = saturatedAdd(j, 1L);
                String targetRelativePath = archiveEntryMetadata.getTargetRelativePath();
                TargetResolution resolveTarget = resolveTarget(canonicalRoot, targetRelativePath);
                file = canonicalRoot;
                if (!(resolveTarget instanceof TargetResolution.Success)) {
                    it = it2;
                    if (!(resolveTarget instanceof TargetResolution.Failure)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    archiveAdoptionMismatch = new ArchiveAdoptionMismatch(archivePackage2.getId(), targetRelativePath, ((TargetResolution.Failure) resolveTarget).getReason());
                } else {
                    try {
                        mismatch = this.verifier.verify(((TargetResolution.Success) resolveTarget).getFile(), archiveEntryMetadata.getSize(), archiveEntryMetadata.getCrc32());
                    } catch (IOException unused) {
                        mismatch = new ArchiveAdoptionFileVerification.Mismatch(ArchiveAdoptionMismatchReason.IO_ERROR, 0L, 2, null);
                    } catch (SecurityException unused2) {
                        mismatch = new ArchiveAdoptionFileVerification.Mismatch(ArchiveAdoptionMismatchReason.FILE_NOT_READABLE, 0L, 2, null);
                    }
                    if (mismatch.getScannedBytes() < 0) {
                        throw new IllegalArgumentException("archive adoption verifier returned negative scannedBytes".toString());
                    }
                    it = it2;
                    Iterator it4 = it3;
                    j2 = saturatedAdd(j2, mismatch.getScannedBytes());
                    if (mismatch instanceof ArchiveAdoptionFileVerification.Match) {
                        ArchiveAdoptionFileVerification.Match match = (ArchiveAdoptionFileVerification.Match) mismatch;
                        if (match.getSize() != archiveEntryMetadata.getSize()) {
                            archiveAdoptionMismatch = new ArchiveAdoptionMismatch(archivePackage2.getId(), targetRelativePath, ArchiveAdoptionMismatchReason.SIZE_MISMATCH);
                            break;
                        } else if (match.getCrc32() != archiveEntryMetadata.getCrc32()) {
                            archiveAdoptionMismatch = new ArchiveAdoptionMismatch(archivePackage2.getId(), targetRelativePath, ArchiveAdoptionMismatchReason.CRC32_MISMATCH);
                            break;
                        } else {
                            arrayList5.add(toFileRecord(archiveEntryMetadata));
                            canonicalRoot = file;
                            it2 = it;
                            it3 = it4;
                        }
                    } else if (!(mismatch instanceof ArchiveAdoptionFileVerification.Mismatch)) {
                        throw new NoWhenBranchMatchedException();
                    } else {
                        archiveAdoptionMismatch = new ArchiveAdoptionMismatch(archivePackage2.getId(), targetRelativePath, ((ArchiveAdoptionFileVerification.Mismatch) mismatch).getReason());
                    }
                }
            }
            if (archiveAdoptionMismatch == null) {
                arrayList3.add(new AdoptedArchivePackage(archivePackage2, arrayList5));
            } else {
                arrayList4.add(archivePackage2);
                if (archiveAdoptionMismatch2 == null) {
                    archiveAdoptionMismatch2 = archiveAdoptionMismatch;
                }
            }
            canonicalRoot = file;
            it2 = it;
        }
        return new ArchiveAdoptionScanResult(arrayList3, arrayList4, j, j2, archiveAdoptionMismatch2);
    }

    private final ArchiveAdoptionScanResult allPackagesNeedArchive(List<ArchivePackage> list, ArchiveAdoptionMismatchReason archiveAdoptionMismatchReason) {
        return new ArchiveAdoptionScanResult(CollectionsKt.emptyList(), list, 0L, 0L, new ArchiveAdoptionMismatch(((ArchivePackage) CollectionsKt.first((List<? extends Object>) list)).getId(), null, archiveAdoptionMismatchReason));
    }

    private final GameRootResolution resolveGameRoot(File file) {
        File normalizedAbsoluteFile = this.pathSafety.normalizedAbsoluteFile(file);
        if (normalizedAbsoluteFile == null) {
            return new GameRootResolution.Failure(ArchiveAdoptionMismatchReason.ROOT_UNSAFE);
        }
        try {
            File canonicalFile = file.getCanonicalFile();
            if (!Intrinsics.areEqual(normalizedAbsoluteFile.getPath(), canonicalFile.getPath())) {
                return new GameRootResolution.Failure(ArchiveAdoptionMismatchReason.SYMLINK_LIKE_CANONICAL_MISMATCH);
            }
            try {
                if (!canonicalFile.exists()) {
                    return new GameRootResolution.Failure(ArchiveAdoptionMismatchReason.ROOT_MISSING);
                }
                if (!canonicalFile.isDirectory()) {
                    return new GameRootResolution.Failure(ArchiveAdoptionMismatchReason.ROOT_NOT_DIRECTORY);
                }
                if (!canonicalFile.canRead()) {
                    return new GameRootResolution.Failure(ArchiveAdoptionMismatchReason.ROOT_NOT_READABLE);
                }
                Intrinsics.checkNotNull(canonicalFile);
                return new GameRootResolution.Success(canonicalFile);
            } catch (SecurityException unused) {
                return new GameRootResolution.Failure(ArchiveAdoptionMismatchReason.ROOT_NOT_READABLE);
            }
        } catch (IOException unused2) {
            return new GameRootResolution.Failure(ArchiveAdoptionMismatchReason.ROOT_UNSAFE);
        } catch (SecurityException unused3) {
            return new GameRootResolution.Failure(ArchiveAdoptionMismatchReason.ROOT_NOT_READABLE);
        }
    }

    private final TargetResolution resolveTarget(File file, String str) {
        File normalizedAbsoluteFile = this.pathSafety.normalizedAbsoluteFile(new File(file, str));
        if (normalizedAbsoluteFile == null) {
            return new TargetResolution.Failure(ArchiveAdoptionMismatchReason.PATH_UNSAFE);
        }
        if (!this.pathSafety.isStrictChild(normalizedAbsoluteFile, file)) {
            return new TargetResolution.Failure(ArchiveAdoptionMismatchReason.PATH_ESCAPE);
        }
        try {
            File canonicalFile = normalizedAbsoluteFile.getCanonicalFile();
            ArchiveLivePathSafety archiveLivePathSafety = this.pathSafety;
            Intrinsics.checkNotNull(canonicalFile);
            if (!archiveLivePathSafety.isStrictChild(canonicalFile, file)) {
                return new TargetResolution.Failure(ArchiveAdoptionMismatchReason.PATH_ESCAPE);
            }
            if (this.pathSafety.hasUnsafeCanonicalAlias(file, normalizedAbsoluteFile, canonicalFile)) {
                return new TargetResolution.Failure(ArchiveAdoptionMismatchReason.SYMLINK_LIKE_CANONICAL_MISMATCH);
            }
            return new TargetResolution.Success(canonicalFile);
        } catch (IOException unused) {
            return new TargetResolution.Failure(ArchiveAdoptionMismatchReason.PATH_UNSAFE);
        } catch (SecurityException unused2) {
            return new TargetResolution.Failure(ArchiveAdoptionMismatchReason.FILE_NOT_READABLE);
        }
    }

    private final ArchivePackageFileRecord toFileRecord(ArchiveEntryMetadata archiveEntryMetadata) {
        return new ArchivePackageFileRecord(archiveEntryMetadata.getTargetRelativePath(), archiveEntryMetadata.getSize(), archiveEntryMetadata.getCrc32(), (String) null, 8, (DefaultConstructorMarker) null);
    }

    /* compiled from: ArchiveInstallAdopter.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0006"}, d2 = {"Lcom/arizona/launcher/updater/archive/adoption/ArchiveInstallAdopter$Companion;", "", "<init>", "()V", "forAndroid", "Lcom/arizona/launcher/updater/archive/adoption/ArchiveInstallAdopter;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ArchiveInstallAdopter forAndroid() {
            return new ArchiveInstallAdopter(ArchiveLivePathSafety.Companion.forAndroid(), null, 2, null);
        }
    }
}
