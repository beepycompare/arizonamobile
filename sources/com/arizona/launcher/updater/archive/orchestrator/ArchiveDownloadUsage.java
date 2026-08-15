package com.arizona.launcher.updater.archive.orchestrator;

import android.system.Os;
import com.arizona.launcher.updater.archive.model.ArchivePackage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
/* compiled from: ArchiveStorageEstimator.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\b\u0010\b\u001a\u0004\u0018\u00010\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bR\u000e\u0010\r\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000Ê\u0001\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u000e"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveDownloadUsage;", "", "<init>", "()V", "allocatedBytesByPackage", "", "", "", "downloadRoot", "Ljava/io/File;", "packages", "", "Lcom/arizona/launcher/updater/archive/model/ArchivePackage;", "POSIX_BLOCK_BYTES", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveDownloadUsage {
    public static final int $stable = 0;
    public static final ArchiveDownloadUsage INSTANCE = new ArchiveDownloadUsage();
    private static final long POSIX_BLOCK_BYTES = 512;

    private ArchiveDownloadUsage() {
    }

    public final Map<String, Long> allocatedBytesByPackage(File file, List<ArchivePackage> packages) {
        long j;
        Pair pair;
        Intrinsics.checkNotNullParameter(packages, "packages");
        if (file == null || !file.isDirectory()) {
            return MapsKt.emptyMap();
        }
        ArrayList arrayList = new ArrayList();
        for (ArchivePackage archivePackage : packages) {
            File archiveFile = ArchivePackagePaths.INSTANCE.archiveFile(file, archivePackage);
            if (archiveFile.isFile()) {
                try {
                    j = RangesKt.coerceIn(Math.multiplyExact(Os.stat(archiveFile.getAbsolutePath()).st_blocks, 512L), 0L, archivePackage.getArchiveSize());
                } catch (Exception unused) {
                    j = 0;
                }
                pair = TuplesKt.to(archivePackage.getId(), Long.valueOf(j));
            } else {
                pair = null;
            }
            if (pair != null) {
                arrayList.add(pair);
            }
        }
        return MapsKt.toMap(arrayList);
    }
}
