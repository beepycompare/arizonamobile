package com.arizona.launcher.updater.archive.orchestrator;

import coil3.util.UtilsKt;
import com.arizona.launcher.updater.archive.commit.ArchivePackageCommitter;
import com.arizona.launcher.updater.archive.download.FileArchiveDownloadResumeStore;
import com.arizona.launcher.updater.archive.io.AndroidArchiveNodeInspector;
import com.arizona.launcher.updater.archive.io.ArchiveFsNodeType;
import com.arizona.launcher.updater.archive.io.ArchiveLivePathSafety;
import com.arizona.launcher.updater.archive.io.ArchiveNodeInspector;
import com.arizona.launcher.updater.archive.state.ArchivePackageIdentity;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
/* compiled from: ArchivePackagePaths.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eJ\u001c\u0010\u0010\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u000eJ\u0018\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000bH\u0002J\u0018\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000bH\u0002J\u0018\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u000bH\u0002J\u0018\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u000bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000Ê\u0001\f\b\u001f\u0012\b\b \u0012\u0004\b\u0003\u0010\u0000¨\u0006\u001e"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchivePackageArtifactCleaner;", "", "nodeInspector", "Lcom/arizona/launcher/updater/archive/io/ArchiveNodeInspector;", "<init>", "(Lcom/arizona/launcher/updater/archive/io/ArchiveNodeInspector;)V", "pathSafety", "Lcom/arizona/launcher/updater/archive/io/ArchiveLivePathSafety;", "cleanup", "", "gameRoot", "Ljava/io/File;", "downloadRoot", "identities", "", "Lcom/arizona/launcher/updater/archive/state/ArchivePackageIdentity;", "cleanupAbandonedCommitBackups", "activeCommittingPackageIds", "", "deleteOwnedFile", UtilsKt.SCHEME_FILE, "allowedRoot", "deleteOwnedTree", "root", "deleteOwnedNode", "node", "deletionRoot", "requireStrictChild", "candidate", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchivePackageArtifactCleaner {
    private final ArchiveNodeInspector nodeInspector;
    private final ArchiveLivePathSafety pathSafety;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = ArchiveLivePathSafety.$stable;
    private static final Regex PACKAGE_ID = new Regex("[A-Za-z0-9][A-Za-z0-9._-]{0,95}");

    /* compiled from: ArchivePackagePaths.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ArchiveFsNodeType.values().length];
            try {
                iArr[ArchiveFsNodeType.ABSENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ArchiveFsNodeType.DIRECTORY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ArchiveFsNodeType.SYMBOLIC_LINK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ArchiveFsNodeType.REGULAR_FILE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ArchiveFsNodeType.OTHER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public ArchivePackageArtifactCleaner(ArchiveNodeInspector nodeInspector) {
        Intrinsics.checkNotNullParameter(nodeInspector, "nodeInspector");
        this.nodeInspector = nodeInspector;
        this.pathSafety = new ArchiveLivePathSafety(nodeInspector);
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
        ArchiveLivePathSafety archiveLivePathSafety = this.pathSafety;
        Intrinsics.checkNotNull(canonicalFile3);
        Intrinsics.checkNotNull(canonicalFile2);
        if (!archiveLivePathSafety.isStrictChild(canonicalFile3, canonicalFile2)) {
            throw new IOException("Archive work root escapes game root");
        }
        if (file == null || (canonicalFile = file.getCanonicalFile()) == null) {
            throw new IOException("Archive download root is unavailable");
        }
        for (ArchivePackageIdentity archivePackageIdentity : CollectionsKt.distinct(identities)) {
            File archiveFile = ArchivePackagePaths.INSTANCE.archiveFile(canonicalFile, archivePackageIdentity);
            deleteOwnedFile(archiveFile, canonicalFile);
            File file2 = new File(archiveFile.getParentFile(), archiveFile.getName() + FileArchiveDownloadResumeStore.SIDECAR_SUFFIX);
            deleteOwnedFile(new File(file2.getParentFile(), file2.getName() + ".tmp"), canonicalFile);
            deleteOwnedFile(file2, canonicalFile);
            deleteOwnedTree(ArchivePackagePaths.INSTANCE.stagingRoot(canonicalFile3, archivePackageIdentity), canonicalFile3);
        }
    }

    public final void cleanupAbandonedCommitBackups(File gameRoot, Collection<String> activeCommittingPackageIds) throws IOException {
        Intrinsics.checkNotNullParameter(gameRoot, "gameRoot");
        Intrinsics.checkNotNullParameter(activeCommittingPackageIds, "activeCommittingPackageIds");
        File canonicalFile = gameRoot.getCanonicalFile();
        File canonicalFile2 = new File(canonicalFile, ".archive-installing").getCanonicalFile();
        ArchiveLivePathSafety archiveLivePathSafety = this.pathSafety;
        Intrinsics.checkNotNull(canonicalFile2);
        Intrinsics.checkNotNull(canonicalFile);
        if (!archiveLivePathSafety.isStrictChild(canonicalFile2, canonicalFile)) {
            throw new IOException("Archive work root escapes game root");
        }
        HashSet hashSet = new HashSet();
        for (String str : activeCommittingPackageIds) {
            String obj = StringsKt.trim((CharSequence) str).toString();
            if (!PACKAGE_ID.matches(obj)) {
                throw new IOException("Invalid archive package id for backup cleanup");
            }
            hashSet.add(obj);
        }
        HashSet hashSet2 = hashSet;
        File file = new File(canonicalFile2, ArchivePackageCommitter.BACKUP_DIRECTORY);
        int i = WhenMappings.$EnumSwitchMapping$0[this.nodeInspector.nodeType(file).ordinal()];
        if (i != 1) {
            if (i != 2) {
                throw new IOException("Invalid archive backup root");
            }
            requireStrictChild(file, canonicalFile2);
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                throw new IOException("Unable to list archive commit backups");
            }
            for (File file2 : listFiles) {
                if (!hashSet2.contains(file2.getName())) {
                    Regex regex = PACKAGE_ID;
                    String name = file2.getName();
                    Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                    if (regex.matches(name)) {
                        Intrinsics.checkNotNull(file2);
                        deleteOwnedTree(file2, canonicalFile2);
                    }
                }
            }
        }
    }

    private final void deleteOwnedFile(File file, File file2) {
        ArchiveFsNodeType nodeType = this.nodeInspector.nodeType(file);
        if (nodeType == ArchiveFsNodeType.ABSENT) {
            return;
        }
        requireStrictChild(file, file2);
        if (nodeType == ArchiveFsNodeType.DIRECTORY || nodeType == ArchiveFsNodeType.OTHER) {
            throw new IOException("Expected updater-owned regular file or link: " + file.getPath());
        } else if (file.delete() || this.nodeInspector.nodeType(file) == ArchiveFsNodeType.ABSENT) {
        } else {
            throw new IOException("Unable to delete updater-owned file: " + file.getPath());
        }
    }

    private final void deleteOwnedTree(File file, File file2) {
        if (this.nodeInspector.nodeType(file) == ArchiveFsNodeType.ABSENT) {
            return;
        }
        requireStrictChild(file, file2);
        deleteOwnedNode(file, file);
    }

    private final void deleteOwnedNode(File file, File file2) {
        int i = WhenMappings.$EnumSwitchMapping$0[this.nodeInspector.nodeType(file).ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i == 3) {
                    if (file.delete() || this.nodeInspector.nodeType(file) == ArchiveFsNodeType.ABSENT) {
                        return;
                    }
                    throw new IOException("Unable to delete updater-owned symbolic link: " + file.getPath());
                } else if (i != 4) {
                    if (i != 5) {
                        throw new NoWhenBranchMatchedException();
                    }
                    throw new IOException("Refusing to delete special updater-owned node: " + file.getPath());
                }
            }
            File canonicalFile = file.getCanonicalFile();
            File canonicalFile2 = file2.getCanonicalFile();
            if (!Intrinsics.areEqual(canonicalFile, canonicalFile2)) {
                ArchiveLivePathSafety archiveLivePathSafety = this.pathSafety;
                Intrinsics.checkNotNull(canonicalFile);
                Intrinsics.checkNotNull(canonicalFile2);
                if (!archiveLivePathSafety.isStrictChild(canonicalFile, canonicalFile2)) {
                    throw new IOException("Refusing to follow updater-owned path outside deletion root");
                }
            }
            if (canonicalFile.isDirectory()) {
                File[] listFiles = canonicalFile.listFiles();
                if (listFiles == null) {
                    throw new IOException("Unable to list updater-owned directory: " + canonicalFile.getPath());
                }
                for (File file3 : listFiles) {
                    Intrinsics.checkNotNull(file3);
                    Intrinsics.checkNotNull(canonicalFile2);
                    deleteOwnedNode(file3, canonicalFile2);
                }
            }
            if (canonicalFile.delete()) {
                return;
            }
            ArchiveNodeInspector archiveNodeInspector = this.nodeInspector;
            Intrinsics.checkNotNull(canonicalFile);
            if (archiveNodeInspector.nodeType(canonicalFile) == ArchiveFsNodeType.ABSENT) {
                return;
            }
            throw new IOException("Unable to delete updater-owned path: " + canonicalFile.getPath());
        }
    }

    private final void requireStrictChild(File file, File file2) {
        File normalizedAbsoluteFile = this.pathSafety.normalizedAbsoluteFile(file);
        if (normalizedAbsoluteFile == null) {
            throw new IOException("Unable to normalize updater-owned path: " + file.getPath());
        }
        File normalizedAbsoluteFile2 = this.pathSafety.normalizedAbsoluteFile(file2);
        if (normalizedAbsoluteFile2 == null) {
            throw new IOException("Unable to normalize updater-owned root: " + file2.getPath());
        } else if (!this.pathSafety.isStrictChild(normalizedAbsoluteFile, normalizedAbsoluteFile2)) {
            throw new IOException("Updater-owned path escapes its root: " + file.getPath());
        } else if (this.nodeInspector.nodeType(file) != ArchiveFsNodeType.SYMBOLIC_LINK) {
            File canonicalFile = file.getCanonicalFile();
            File canonicalFile2 = file2.getCanonicalFile();
            ArchiveLivePathSafety archiveLivePathSafety = this.pathSafety;
            Intrinsics.checkNotNull(canonicalFile);
            Intrinsics.checkNotNull(canonicalFile2);
            if (archiveLivePathSafety.isStrictChild(canonicalFile, canonicalFile2)) {
                return;
            }
            throw new IOException("Updater-owned canonical path escapes its root: " + file.getPath());
        }
    }

    /* compiled from: ArchivePackagePaths.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchivePackageArtifactCleaner$Companion;", "", "<init>", "()V", "PACKAGE_ID", "Lkotlin/text/Regex;", "forAndroid", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchivePackageArtifactCleaner;", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ArchivePackageArtifactCleaner forAndroid() {
            return new ArchivePackageArtifactCleaner(AndroidArchiveNodeInspector.INSTANCE);
        }
    }
}
