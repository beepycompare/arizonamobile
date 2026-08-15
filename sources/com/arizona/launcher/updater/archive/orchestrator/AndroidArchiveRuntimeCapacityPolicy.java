package com.arizona.launcher.updater.archive.orchestrator;

import android.os.StatFs;
import android.system.Os;
import com.arizona.launcher.updater.archive.orchestrator.ArchiveRuntimeCapacityResult;
import com.arizona.launcher.updater.archive.planner.ArchiveUpdatePlan;
import com.arizona.launcher.updater.archive.state.ArchiveUpdaterState;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArchiveDownloadAheadPolicy.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0017\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0002¢\u0006\u0002\u0010\u0015J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0017\u001a\u00020\u0003H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000Ê\u0001\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\u0003\u0010\u0000¨\u0006\u0018"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/AndroidArchiveRuntimeCapacityPolicy;", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveRuntimeCapacityPolicy;", "gameRoot", "Ljava/io/File;", "downloadRoot", "<init>", "(Ljava/io/File;Ljava/io/File;)V", "evaluate", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveRuntimeCapacityResult;", "plan", "Lcom/arizona/launcher/updater/archive/planner/ArchiveUpdatePlan;", RemoteConfigConstants.ResponseFieldKey.STATE, "Lcom/arizona/launcher/updater/archive/state/ArchiveUpdaterState;", "unavailableStorageRoot", "Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveRuntimeCapacityResult$Unavailable;", "name", "", "requiredFreeSpaceBytes", "", "addReserve", "requiredBytes", "(J)Ljava/lang/Long;", "existingStorageAnchor", "root", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AndroidArchiveRuntimeCapacityPolicy implements ArchiveRuntimeCapacityPolicy {
    public static final int $stable = 8;
    private final File downloadRoot;
    private final File gameRoot;

    public AndroidArchiveRuntimeCapacityPolicy(File gameRoot, File downloadRoot) {
        Intrinsics.checkNotNullParameter(gameRoot, "gameRoot");
        Intrinsics.checkNotNullParameter(downloadRoot, "downloadRoot");
        this.gameRoot = gameRoot;
        this.downloadRoot = downloadRoot;
    }

    @Override // com.arizona.launcher.updater.archive.orchestrator.ArchiveRuntimeCapacityPolicy
    public ArchiveRuntimeCapacityResult evaluate(ArchiveUpdatePlan plan, ArchiveUpdaterState state) {
        long gameBytes;
        Intrinsics.checkNotNullParameter(plan, "plan");
        Intrinsics.checkNotNullParameter(state, "state");
        try {
            ArchiveStorageRequirements storageRequirements = ArchiveStorageEstimator.INSTANCE.storageRequirements(plan, state, ArchiveStagingUsage.INSTANCE.bytesByPackage(this.gameRoot, plan.getPackages()), ArchiveDownloadUsage.INSTANCE.allocatedBytesByPackage(this.downloadRoot, plan.getPackages()));
            File existingStorageAnchor = existingStorageAnchor(this.gameRoot);
            if (existingStorageAnchor == null) {
                return unavailableStorageRoot("game", storageRequirements.getCombinedBytes());
            }
            File existingStorageAnchor2 = existingStorageAnchor(this.downloadRoot);
            if (existingStorageAnchor2 == null) {
                return unavailableStorageRoot("download", storageRequirements.getCombinedBytes());
            }
            try {
                boolean z = Os.stat(existingStorageAnchor.getAbsolutePath()).st_dev == Os.stat(existingStorageAnchor2.getAbsolutePath()).st_dev;
                if (z) {
                    gameBytes = storageRequirements.getCombinedBytes();
                } else {
                    gameBytes = storageRequirements.getGameBytes();
                }
                Long addReserve = addReserve(gameBytes);
                if (addReserve == null) {
                    return new ArchiveRuntimeCapacityResult.Unavailable("game storage requirement overflows Long", Long.valueOf(storageRequirements.getCombinedBytes()));
                }
                long longValue = addReserve.longValue();
                try {
                    long availableBytes = new StatFs(existingStorageAnchor.getAbsolutePath()).getAvailableBytes();
                    if (availableBytes < longValue) {
                        return new ArchiveRuntimeCapacityResult.Insufficient(storageRequirements.getCombinedBytes(), availableBytes);
                    }
                    if (!z) {
                        Long addReserve2 = addReserve(storageRequirements.getDownloadBytes());
                        if (addReserve2 == null) {
                            return new ArchiveRuntimeCapacityResult.Unavailable("download storage requirement overflows Long", Long.valueOf(storageRequirements.getCombinedBytes()));
                        }
                        long longValue2 = addReserve2.longValue();
                        try {
                            long availableBytes2 = new StatFs(existingStorageAnchor2.getAbsolutePath()).getAvailableBytes();
                            if (availableBytes2 < longValue2) {
                                return new ArchiveRuntimeCapacityResult.Insufficient(storageRequirements.getCombinedBytes(), availableBytes2);
                            }
                        } catch (RuntimeException e) {
                            return new ArchiveRuntimeCapacityResult.Unavailable(e.getMessage(), Long.valueOf(storageRequirements.getCombinedBytes()));
                        }
                    }
                    return new ArchiveRuntimeCapacityResult.Sufficient(storageRequirements.getCombinedBytes());
                } catch (RuntimeException e2) {
                    return new ArchiveRuntimeCapacityResult.Unavailable(e2.getMessage(), Long.valueOf(storageRequirements.getCombinedBytes()));
                }
            } catch (Exception e3) {
                return new ArchiveRuntimeCapacityResult.Unavailable(e3.getMessage(), Long.valueOf(storageRequirements.getCombinedBytes()));
            }
        } catch (Exception e4) {
            return new ArchiveRuntimeCapacityResult.Unavailable(e4.getMessage(), null, 2, null);
        }
    }

    private final ArchiveRuntimeCapacityResult.Unavailable unavailableStorageRoot(String str, long j) {
        return new ArchiveRuntimeCapacityResult.Unavailable(str + " storage root is unavailable", Long.valueOf(j));
    }

    private final Long addReserve(long j) {
        try {
            return Long.valueOf(Math.addExact(j, (long) ArchiveStorageEstimatorKt.ARCHIVE_FREE_SPACE_RESERVE_BYTES));
        } catch (ArithmeticException unused) {
            return null;
        }
    }

    private final File existingStorageAnchor(File file) {
        File absoluteFile = file.getAbsoluteFile();
        while (absoluteFile != null && !absoluteFile.exists()) {
            absoluteFile = absoluteFile.getParentFile();
        }
        return absoluteFile;
    }
}
