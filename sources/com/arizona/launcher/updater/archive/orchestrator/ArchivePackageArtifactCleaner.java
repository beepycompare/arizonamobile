package com.arizona.launcher.updater.archive.orchestrator;

import coil3.util.UtilsKt;
import com.arizona.launcher.updater.archive.download.FileArchiveDownloadResumeStore;
import com.arizona.launcher.updater.archive.state.ArchivePackageIdentity;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* compiled from: ArchivePackagePaths.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\u0018\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007H\u0002J\u0018\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007H\u0002J\u0018\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0007H\u0002J\u0018\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007H\u0002J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0007H\u0002Ê\u0001\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0018"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchivePackageArtifactCleaner;", "", "<init>", "()V", "cleanup", "", "gameRoot", "Ljava/io/File;", "downloadRoot", "identities", "", "Lcom/arizona/launcher/updater/archive/state/ArchivePackageIdentity;", "deleteOwnedFile", UtilsKt.SCHEME_FILE, "allowedRoot", "deleteOwnedTree", "root", "deleteOwnedNode", "node", "deletionRoot", "requireStrictChild", "candidate", "isStrictChild", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchivePackageArtifactCleaner {
    public static final int $stable = 0;
    public static final ArchivePackageArtifactCleaner INSTANCE = new ArchivePackageArtifactCleaner();

    private ArchivePackageArtifactCleaner() {
    }

    public final void cleanup(File gameRoot, File file, Collection<ArchivePackageIdentity> identities) throws IOException {
        File canonicalFile;
        Intrinsics.checkNotNullParameter(gameRoot, "gameRoot");
        Intrinsics.checkNotNullParameter(identities, "identities");
        if (identities.isEmpty()) {
            return;
        }
        File canonicalFile2 = gameRoot.getCanonicalFile();
        File canonicalFile3 = new File(canonicalFile2, ".archive-installing").getCanonicalFile();
        Intrinsics.checkNotNull(canonicalFile3);
        Intrinsics.checkNotNull(canonicalFile2);
        if (!isStrictChild(canonicalFile3, canonicalFile2)) {
            throw new IOException("Archive work root escapes game root");
        }
        if (file == null || (canonicalFile = file.getCanonicalFile()) == null) {
            throw new IOException("Archive download root is unavailable");
        }
        for (ArchivePackageIdentity archivePackageIdentity : CollectionsKt.distinct(identities)) {
            File archiveFile = ArchivePackagePaths.INSTANCE.archiveFile(canonicalFile, archivePackageIdentity);
            ArchivePackageArtifactCleaner archivePackageArtifactCleaner = INSTANCE;
            archivePackageArtifactCleaner.deleteOwnedFile(archiveFile, canonicalFile);
            File file2 = new File(archiveFile.getParentFile(), archiveFile.getName() + FileArchiveDownloadResumeStore.SIDECAR_SUFFIX);
            archivePackageArtifactCleaner.deleteOwnedFile(new File(file2.getParentFile(), file2.getName() + ".tmp"), canonicalFile);
            archivePackageArtifactCleaner.deleteOwnedFile(file2, canonicalFile);
            archivePackageArtifactCleaner.deleteOwnedTree(ArchivePackagePaths.INSTANCE.stagingRoot(canonicalFile3, archivePackageIdentity), canonicalFile3);
        }
    }

    private final void deleteOwnedFile(File file, File file2) {
        if (file.exists() || Files.isSymbolicLink(file.toPath())) {
            requireStrictChild(file, file2);
            if (file.isDirectory() && !Files.isSymbolicLink(file.toPath())) {
                throw new IOException("Expected updater-owned file, found directory: " + file.getPath());
            } else if (file.delete()) {
            } else {
                if (file.exists() || Files.isSymbolicLink(file.toPath())) {
                    throw new IOException("Unable to delete updater-owned file: " + file.getPath());
                }
            }
        }
    }

    private final void deleteOwnedTree(File file, File file2) {
        if (file.exists() || Files.isSymbolicLink(file.toPath())) {
            requireStrictChild(file, file2);
            deleteOwnedNode(file, file);
        }
    }

    private final void deleteOwnedNode(File file, File file2) {
        if (Files.isSymbolicLink(file.toPath())) {
            if (file.delete() || !Files.isSymbolicLink(file.toPath())) {
                return;
            }
            throw new IOException("Unable to delete updater-owned symbolic link: " + file.getPath());
        }
        File canonicalFile = file.getCanonicalFile();
        File canonicalFile2 = file2.getCanonicalFile();
        if (!Intrinsics.areEqual(canonicalFile, canonicalFile2)) {
            Intrinsics.checkNotNull(canonicalFile);
            Intrinsics.checkNotNull(canonicalFile2);
            if (!isStrictChild(canonicalFile, canonicalFile2)) {
                throw new IOException("Refusing to follow updater-owned path outside deletion root");
            }
        }
        if (canonicalFile.isDirectory()) {
            File[] listFiles = canonicalFile.listFiles();
            if (listFiles == null) {
                throw new IOException("Unable to list updater-owned directory: " + canonicalFile.getPath());
            }
            for (File file3 : listFiles) {
                ArchivePackageArtifactCleaner archivePackageArtifactCleaner = INSTANCE;
                Intrinsics.checkNotNull(file3);
                Intrinsics.checkNotNull(canonicalFile2);
                archivePackageArtifactCleaner.deleteOwnedNode(file3, canonicalFile2);
            }
        }
        if (canonicalFile.delete() || !canonicalFile.exists()) {
            return;
        }
        throw new IOException("Unable to delete updater-owned path: " + canonicalFile.getPath());
    }

    private final void requireStrictChild(File file, File file2) {
        File file3 = file.toPath().toAbsolutePath().normalize().toFile();
        File file4 = file2.toPath().toAbsolutePath().normalize().toFile();
        Intrinsics.checkNotNull(file3);
        Intrinsics.checkNotNull(file4);
        if (!isStrictChild(file3, file4)) {
            throw new IOException("Updater-owned path escapes its root: " + file.getPath());
        } else if (Files.isSymbolicLink(file.toPath())) {
        } else {
            File canonicalFile = file.getCanonicalFile();
            File canonicalFile2 = file2.getCanonicalFile();
            Intrinsics.checkNotNull(canonicalFile);
            Intrinsics.checkNotNull(canonicalFile2);
            if (isStrictChild(canonicalFile, canonicalFile2)) {
                return;
            }
            throw new IOException("Updater-owned canonical path escapes its root: " + file.getPath());
        }
    }

    private final boolean isStrictChild(File file, File file2) {
        String path = file.getPath();
        Intrinsics.checkNotNullExpressionValue(path, "getPath(...)");
        String path2 = file2.getPath();
        return StringsKt.startsWith$default(path, path2 + File.separator, false, 2, (Object) null);
    }
}
