package com.arizona.launcher.updater.archive.orchestrator;

import android.os.StatFs;
import android.system.Os;
import com.arizona.launcher.updater.archive.model.ArchivePackage;
import com.arizona.launcher.updater.archive.planner.ArchiveUpdatePlan;
import com.arizona.launcher.updater.archive.state.ArchiveUpdaterState;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArchiveDownloadAheadPolicy.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000Ê\u0001\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u000f"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/AndroidArchiveDownloadAheadPolicy;", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveDownloadAheadPolicy;", "gameRoot", "Ljava/io/File;", "downloadRoot", "<init>", "(Ljava/io/File;Ljava/io/File;)V", "canStart", "", "plan", "Lcom/arizona/launcher/updater/archive/planner/ArchiveUpdatePlan;", RemoteConfigConstants.ResponseFieldKey.STATE, "Lcom/arizona/launcher/updater/archive/state/ArchiveUpdaterState;", "nextPackage", "Lcom/arizona/launcher/updater/archive/model/ArchivePackage;", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AndroidArchiveDownloadAheadPolicy implements ArchiveDownloadAheadPolicy {
    public static final int $stable = 8;
    private final File downloadRoot;
    private final File gameRoot;

    public AndroidArchiveDownloadAheadPolicy(File gameRoot, File downloadRoot) {
        Intrinsics.checkNotNullParameter(gameRoot, "gameRoot");
        Intrinsics.checkNotNullParameter(downloadRoot, "downloadRoot");
        this.gameRoot = gameRoot;
        this.downloadRoot = downloadRoot;
    }

    @Override // com.arizona.launcher.updater.archive.orchestrator.ArchiveDownloadAheadPolicy
    public boolean canStart(ArchiveUpdatePlan plan, ArchiveUpdaterState state, ArchivePackage nextPackage) {
        Intrinsics.checkNotNullParameter(plan, "plan");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(nextPackage, "nextPackage");
        try {
            if (Os.stat(this.gameRoot.getAbsolutePath()).st_dev == Os.stat(this.downloadRoot.getAbsolutePath()).st_dev) {
                if (new StatFs(this.gameRoot.getAbsolutePath()).getAvailableBytes() >= Math.addExact(ArchiveStorageEstimator.INSTANCE.requiredFreeSpaceBytes(plan, state, ArchiveStagingUsage.INSTANCE.bytesByPackage(this.gameRoot, plan.getPackages()), ArchiveDownloadUsage.INSTANCE.allocatedBytesByPackage(this.downloadRoot, plan.getPackages())), (long) ArchiveStorageEstimatorKt.ARCHIVE_FREE_SPACE_RESERVE_BYTES)) {
                    return true;
                }
            }
        } catch (RuntimeException | Exception unused) {
        }
        return false;
    }
}
