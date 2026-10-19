package com.arizona.launcher.updater.archive.orchestrator;

import com.arizona.launcher.updater.archive.commit.ArchivePackageCommitter;
import java.io.File;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArchiveUpdaterStorageRoots.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0081\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0019HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nÊ\u0001\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u001b"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdaterStorageRoots;", "", "gameRoot", "Ljava/io/File;", "stateRoot", "downloadRoot", "workRoot", "<init>", "(Ljava/io/File;Ljava/io/File;Ljava/io/File;Ljava/io/File;)V", "getGameRoot", "()Ljava/io/File;", "getStateRoot", "getDownloadRoot", "getWorkRoot", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveUpdaterStorageRoots {
    public static final String FALLBACK_CACHE_ANCHOR_RELATIVE = ".archive-installing/.download-cache";
    private final File downloadRoot;
    private final File gameRoot;
    private final File stateRoot;
    private final File workRoot;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public static /* synthetic */ ArchiveUpdaterStorageRoots copy$default(ArchiveUpdaterStorageRoots archiveUpdaterStorageRoots, File file, File file2, File file3, File file4, int i, Object obj) {
        if ((i & 1) != 0) {
            file = archiveUpdaterStorageRoots.gameRoot;
        }
        if ((i & 2) != 0) {
            file2 = archiveUpdaterStorageRoots.stateRoot;
        }
        if ((i & 4) != 0) {
            file3 = archiveUpdaterStorageRoots.downloadRoot;
        }
        if ((i & 8) != 0) {
            file4 = archiveUpdaterStorageRoots.workRoot;
        }
        return archiveUpdaterStorageRoots.copy(file, file2, file3, file4);
    }

    public final File component1() {
        return this.gameRoot;
    }

    public final File component2() {
        return this.stateRoot;
    }

    public final File component3() {
        return this.downloadRoot;
    }

    public final File component4() {
        return this.workRoot;
    }

    public final ArchiveUpdaterStorageRoots copy(File gameRoot, File stateRoot, File downloadRoot, File workRoot) {
        Intrinsics.checkNotNullParameter(gameRoot, "gameRoot");
        Intrinsics.checkNotNullParameter(stateRoot, "stateRoot");
        Intrinsics.checkNotNullParameter(downloadRoot, "downloadRoot");
        Intrinsics.checkNotNullParameter(workRoot, "workRoot");
        return new ArchiveUpdaterStorageRoots(gameRoot, stateRoot, downloadRoot, workRoot);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ArchiveUpdaterStorageRoots) {
            ArchiveUpdaterStorageRoots archiveUpdaterStorageRoots = (ArchiveUpdaterStorageRoots) obj;
            return Intrinsics.areEqual(this.gameRoot, archiveUpdaterStorageRoots.gameRoot) && Intrinsics.areEqual(this.stateRoot, archiveUpdaterStorageRoots.stateRoot) && Intrinsics.areEqual(this.downloadRoot, archiveUpdaterStorageRoots.downloadRoot) && Intrinsics.areEqual(this.workRoot, archiveUpdaterStorageRoots.workRoot);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.gameRoot.hashCode() * 31) + this.stateRoot.hashCode()) * 31) + this.downloadRoot.hashCode()) * 31) + this.workRoot.hashCode();
    }

    public String toString() {
        File file = this.gameRoot;
        File file2 = this.stateRoot;
        File file3 = this.downloadRoot;
        return "ArchiveUpdaterStorageRoots(gameRoot=" + file + ", stateRoot=" + file2 + ", downloadRoot=" + file3 + ", workRoot=" + this.workRoot + ")";
    }

    public ArchiveUpdaterStorageRoots(File gameRoot, File stateRoot, File downloadRoot, File workRoot) {
        Intrinsics.checkNotNullParameter(gameRoot, "gameRoot");
        Intrinsics.checkNotNullParameter(stateRoot, "stateRoot");
        Intrinsics.checkNotNullParameter(downloadRoot, "downloadRoot");
        Intrinsics.checkNotNullParameter(workRoot, "workRoot");
        this.gameRoot = gameRoot;
        this.stateRoot = stateRoot;
        this.downloadRoot = downloadRoot;
        this.workRoot = workRoot;
    }

    public final File getGameRoot() {
        return this.gameRoot;
    }

    public final File getStateRoot() {
        return this.stateRoot;
    }

    public final File getDownloadRoot() {
        return this.downloadRoot;
    }

    public final File getWorkRoot() {
        return this.workRoot;
    }

    /* compiled from: ArchiveUpdaterStorageRoots.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bJ(\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdaterStorageRoots$Companion;", "", "<init>", "()V", "FALLBACK_CACHE_ANCHOR_RELATIVE", "", "fallbackCacheAnchor", "Ljava/io/File;", "gameRoot", "downloadRelative", "scope", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdaterStorageScope;", "resolve", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdaterStorageRoots;", "cacheRoot", "noBackupRoot", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {

        /* compiled from: ArchiveUpdaterStorageRoots.kt */
        @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[ArchiveUpdaterStorageScope.values().length];
                try {
                    iArr[ArchiveUpdaterStorageScope.BASE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[ArchiveUpdaterStorageScope.VICE.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final File fallbackCacheAnchor(File gameRoot) {
            Intrinsics.checkNotNullParameter(gameRoot, "gameRoot");
            return new File(gameRoot, ArchiveUpdaterStorageRoots.FALLBACK_CACHE_ANCHOR_RELATIVE);
        }

        public final String downloadRelative(ArchiveUpdaterStorageScope scope) {
            Intrinsics.checkNotNullParameter(scope, "scope");
            int i = WhenMappings.$EnumSwitchMapping$0[scope.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                return "archive-updater/vice/downloads";
            }
            return "archive-updater/downloads";
        }

        public static /* synthetic */ ArchiveUpdaterStorageRoots resolve$default(Companion companion, File file, File file2, File file3, ArchiveUpdaterStorageScope archiveUpdaterStorageScope, int i, Object obj) {
            if ((i & 8) != 0) {
                archiveUpdaterStorageScope = ArchiveUpdaterStorageScope.BASE;
            }
            return companion.resolve(file, file2, file3, archiveUpdaterStorageScope);
        }

        public final ArchiveUpdaterStorageRoots resolve(File gameRoot, File cacheRoot, File noBackupRoot, ArchiveUpdaterStorageScope scope) {
            Intrinsics.checkNotNullParameter(gameRoot, "gameRoot");
            Intrinsics.checkNotNullParameter(cacheRoot, "cacheRoot");
            Intrinsics.checkNotNullParameter(noBackupRoot, "noBackupRoot");
            Intrinsics.checkNotNullParameter(scope, "scope");
            int i = WhenMappings.$EnumSwitchMapping$0[scope.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                return new ArchiveUpdaterStorageRoots(gameRoot, new File(noBackupRoot, "archive-updater/vice"), new File(cacheRoot, downloadRelative(ArchiveUpdaterStorageScope.VICE)), new File(gameRoot, ".archive-installing/vice"));
            }
            return new ArchiveUpdaterStorageRoots(gameRoot, new File(noBackupRoot, "archive-updater"), new File(cacheRoot, downloadRelative(ArchiveUpdaterStorageScope.BASE)), new File(gameRoot, ArchivePackageCommitter.DEFAULT_WORK_DIRECTORY));
        }
    }
}
