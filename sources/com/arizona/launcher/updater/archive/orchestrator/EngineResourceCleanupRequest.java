package com.arizona.launcher.updater.archive.orchestrator;

import com.arizona.launcher.updater.archive.model.ArchiveManifest;
import com.arizona.launcher.updater.archive.state.DurableArchiveStateStore;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: EngineResourceGenerationMigration.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001BY\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\nHÆ\u0003J\t\u0010%\u001a\u00020\nHÆ\u0003J\t\u0010&\u001a\u00020\rHÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\rHÆ\u0003Jo\u0010(\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\rHÆ\u0001J\u0014\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010,\u001a\u00020-HÖ\u0081\u0004J\n\u0010.\u001a\u00020/HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cÊ\u0001\f\b1\u0012\b\b2\u0012\u0004\b\u0003\u0010\u0000¨\u00060"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/EngineResourceCleanupRequest;", "", "gameRoot", "Ljava/io/File;", "cacheRoot", "noBackupRoot", "baseDownloadRoot", "viceDownloadRoot", "workRoot", "baseStateStore", "Lcom/arizona/launcher/updater/archive/state/DurableArchiveStateStore;", "viceStateStore", "baseDesired", "Lcom/arizona/launcher/updater/archive/model/ArchiveManifest;", "viceDesired", "<init>", "(Ljava/io/File;Ljava/io/File;Ljava/io/File;Ljava/io/File;Ljava/io/File;Ljava/io/File;Lcom/arizona/launcher/updater/archive/state/DurableArchiveStateStore;Lcom/arizona/launcher/updater/archive/state/DurableArchiveStateStore;Lcom/arizona/launcher/updater/archive/model/ArchiveManifest;Lcom/arizona/launcher/updater/archive/model/ArchiveManifest;)V", "getGameRoot", "()Ljava/io/File;", "getCacheRoot", "getNoBackupRoot", "getBaseDownloadRoot", "getViceDownloadRoot", "getWorkRoot", "getBaseStateStore", "()Lcom/arizona/launcher/updater/archive/state/DurableArchiveStateStore;", "getViceStateStore", "getBaseDesired", "()Lcom/arizona/launcher/updater/archive/model/ArchiveManifest;", "getViceDesired", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class EngineResourceCleanupRequest {
    public static final int $stable = 8;
    private final ArchiveManifest baseDesired;
    private final File baseDownloadRoot;
    private final DurableArchiveStateStore baseStateStore;
    private final File cacheRoot;
    private final File gameRoot;
    private final File noBackupRoot;
    private final ArchiveManifest viceDesired;
    private final File viceDownloadRoot;
    private final DurableArchiveStateStore viceStateStore;
    private final File workRoot;

    public static /* synthetic */ EngineResourceCleanupRequest copy$default(EngineResourceCleanupRequest engineResourceCleanupRequest, File file, File file2, File file3, File file4, File file5, File file6, DurableArchiveStateStore durableArchiveStateStore, DurableArchiveStateStore durableArchiveStateStore2, ArchiveManifest archiveManifest, ArchiveManifest archiveManifest2, int i, Object obj) {
        if ((i & 1) != 0) {
            file = engineResourceCleanupRequest.gameRoot;
        }
        if ((i & 2) != 0) {
            file2 = engineResourceCleanupRequest.cacheRoot;
        }
        if ((i & 4) != 0) {
            file3 = engineResourceCleanupRequest.noBackupRoot;
        }
        if ((i & 8) != 0) {
            file4 = engineResourceCleanupRequest.baseDownloadRoot;
        }
        if ((i & 16) != 0) {
            file5 = engineResourceCleanupRequest.viceDownloadRoot;
        }
        if ((i & 32) != 0) {
            file6 = engineResourceCleanupRequest.workRoot;
        }
        if ((i & 64) != 0) {
            durableArchiveStateStore = engineResourceCleanupRequest.baseStateStore;
        }
        if ((i & 128) != 0) {
            durableArchiveStateStore2 = engineResourceCleanupRequest.viceStateStore;
        }
        if ((i & 256) != 0) {
            archiveManifest = engineResourceCleanupRequest.baseDesired;
        }
        if ((i & 512) != 0) {
            archiveManifest2 = engineResourceCleanupRequest.viceDesired;
        }
        ArchiveManifest archiveManifest3 = archiveManifest;
        ArchiveManifest archiveManifest4 = archiveManifest2;
        DurableArchiveStateStore durableArchiveStateStore3 = durableArchiveStateStore;
        DurableArchiveStateStore durableArchiveStateStore4 = durableArchiveStateStore2;
        File file7 = file5;
        File file8 = file6;
        return engineResourceCleanupRequest.copy(file, file2, file3, file4, file7, file8, durableArchiveStateStore3, durableArchiveStateStore4, archiveManifest3, archiveManifest4);
    }

    public final File component1() {
        return this.gameRoot;
    }

    public final ArchiveManifest component10() {
        return this.viceDesired;
    }

    public final File component2() {
        return this.cacheRoot;
    }

    public final File component3() {
        return this.noBackupRoot;
    }

    public final File component4() {
        return this.baseDownloadRoot;
    }

    public final File component5() {
        return this.viceDownloadRoot;
    }

    public final File component6() {
        return this.workRoot;
    }

    public final DurableArchiveStateStore component7() {
        return this.baseStateStore;
    }

    public final DurableArchiveStateStore component8() {
        return this.viceStateStore;
    }

    public final ArchiveManifest component9() {
        return this.baseDesired;
    }

    public final EngineResourceCleanupRequest copy(File gameRoot, File cacheRoot, File noBackupRoot, File baseDownloadRoot, File viceDownloadRoot, File workRoot, DurableArchiveStateStore baseStateStore, DurableArchiveStateStore viceStateStore, ArchiveManifest baseDesired, ArchiveManifest archiveManifest) {
        Intrinsics.checkNotNullParameter(gameRoot, "gameRoot");
        Intrinsics.checkNotNullParameter(cacheRoot, "cacheRoot");
        Intrinsics.checkNotNullParameter(noBackupRoot, "noBackupRoot");
        Intrinsics.checkNotNullParameter(baseDownloadRoot, "baseDownloadRoot");
        Intrinsics.checkNotNullParameter(viceDownloadRoot, "viceDownloadRoot");
        Intrinsics.checkNotNullParameter(workRoot, "workRoot");
        Intrinsics.checkNotNullParameter(baseStateStore, "baseStateStore");
        Intrinsics.checkNotNullParameter(viceStateStore, "viceStateStore");
        Intrinsics.checkNotNullParameter(baseDesired, "baseDesired");
        return new EngineResourceCleanupRequest(gameRoot, cacheRoot, noBackupRoot, baseDownloadRoot, viceDownloadRoot, workRoot, baseStateStore, viceStateStore, baseDesired, archiveManifest);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof EngineResourceCleanupRequest) {
            EngineResourceCleanupRequest engineResourceCleanupRequest = (EngineResourceCleanupRequest) obj;
            return Intrinsics.areEqual(this.gameRoot, engineResourceCleanupRequest.gameRoot) && Intrinsics.areEqual(this.cacheRoot, engineResourceCleanupRequest.cacheRoot) && Intrinsics.areEqual(this.noBackupRoot, engineResourceCleanupRequest.noBackupRoot) && Intrinsics.areEqual(this.baseDownloadRoot, engineResourceCleanupRequest.baseDownloadRoot) && Intrinsics.areEqual(this.viceDownloadRoot, engineResourceCleanupRequest.viceDownloadRoot) && Intrinsics.areEqual(this.workRoot, engineResourceCleanupRequest.workRoot) && Intrinsics.areEqual(this.baseStateStore, engineResourceCleanupRequest.baseStateStore) && Intrinsics.areEqual(this.viceStateStore, engineResourceCleanupRequest.viceStateStore) && Intrinsics.areEqual(this.baseDesired, engineResourceCleanupRequest.baseDesired) && Intrinsics.areEqual(this.viceDesired, engineResourceCleanupRequest.viceDesired);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((((((((((((((this.gameRoot.hashCode() * 31) + this.cacheRoot.hashCode()) * 31) + this.noBackupRoot.hashCode()) * 31) + this.baseDownloadRoot.hashCode()) * 31) + this.viceDownloadRoot.hashCode()) * 31) + this.workRoot.hashCode()) * 31) + this.baseStateStore.hashCode()) * 31) + this.viceStateStore.hashCode()) * 31) + this.baseDesired.hashCode()) * 31;
        ArchiveManifest archiveManifest = this.viceDesired;
        return hashCode + (archiveManifest == null ? 0 : archiveManifest.hashCode());
    }

    public String toString() {
        File file = this.gameRoot;
        File file2 = this.cacheRoot;
        File file3 = this.noBackupRoot;
        File file4 = this.baseDownloadRoot;
        File file5 = this.viceDownloadRoot;
        File file6 = this.workRoot;
        DurableArchiveStateStore durableArchiveStateStore = this.baseStateStore;
        DurableArchiveStateStore durableArchiveStateStore2 = this.viceStateStore;
        ArchiveManifest archiveManifest = this.baseDesired;
        return "EngineResourceCleanupRequest(gameRoot=" + file + ", cacheRoot=" + file2 + ", noBackupRoot=" + file3 + ", baseDownloadRoot=" + file4 + ", viceDownloadRoot=" + file5 + ", workRoot=" + file6 + ", baseStateStore=" + durableArchiveStateStore + ", viceStateStore=" + durableArchiveStateStore2 + ", baseDesired=" + archiveManifest + ", viceDesired=" + this.viceDesired + ")";
    }

    public EngineResourceCleanupRequest(File gameRoot, File cacheRoot, File noBackupRoot, File baseDownloadRoot, File viceDownloadRoot, File workRoot, DurableArchiveStateStore baseStateStore, DurableArchiveStateStore viceStateStore, ArchiveManifest baseDesired, ArchiveManifest archiveManifest) {
        Intrinsics.checkNotNullParameter(gameRoot, "gameRoot");
        Intrinsics.checkNotNullParameter(cacheRoot, "cacheRoot");
        Intrinsics.checkNotNullParameter(noBackupRoot, "noBackupRoot");
        Intrinsics.checkNotNullParameter(baseDownloadRoot, "baseDownloadRoot");
        Intrinsics.checkNotNullParameter(viceDownloadRoot, "viceDownloadRoot");
        Intrinsics.checkNotNullParameter(workRoot, "workRoot");
        Intrinsics.checkNotNullParameter(baseStateStore, "baseStateStore");
        Intrinsics.checkNotNullParameter(viceStateStore, "viceStateStore");
        Intrinsics.checkNotNullParameter(baseDesired, "baseDesired");
        this.gameRoot = gameRoot;
        this.cacheRoot = cacheRoot;
        this.noBackupRoot = noBackupRoot;
        this.baseDownloadRoot = baseDownloadRoot;
        this.viceDownloadRoot = viceDownloadRoot;
        this.workRoot = workRoot;
        this.baseStateStore = baseStateStore;
        this.viceStateStore = viceStateStore;
        this.baseDesired = baseDesired;
        this.viceDesired = archiveManifest;
    }

    public final File getGameRoot() {
        return this.gameRoot;
    }

    public final File getCacheRoot() {
        return this.cacheRoot;
    }

    public final File getNoBackupRoot() {
        return this.noBackupRoot;
    }

    public final File getBaseDownloadRoot() {
        return this.baseDownloadRoot;
    }

    public final File getViceDownloadRoot() {
        return this.viceDownloadRoot;
    }

    public final File getWorkRoot() {
        return this.workRoot;
    }

    public final DurableArchiveStateStore getBaseStateStore() {
        return this.baseStateStore;
    }

    public final DurableArchiveStateStore getViceStateStore() {
        return this.viceStateStore;
    }

    public final ArchiveManifest getBaseDesired() {
        return this.baseDesired;
    }

    public final ArchiveManifest getViceDesired() {
        return this.viceDesired;
    }
}
