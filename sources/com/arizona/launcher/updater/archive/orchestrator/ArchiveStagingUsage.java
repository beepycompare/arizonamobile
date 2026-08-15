package com.arizona.launcher.updater.archive.orchestrator;

import com.arizona.launcher.updater.archive.model.ArchivePackage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
/* compiled from: ArchivePackagePaths.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010#\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bJ&\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u0011H\u0002J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\tH\u0002Ê\u0001\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0016"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveStagingUsage;", "", "<init>", "()V", "bytesByPackage", "", "", "", "gameRoot", "Ljava/io/File;", "packages", "", "Lcom/arizona/launcher/updater/archive/model/ArchivePackage;", "measuredBytes", "node", "allowedRoot", "visitedDirectories", "", "isStrictChild", "", "candidate", "root", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveStagingUsage {
    public static final int $stable = 0;
    public static final ArchiveStagingUsage INSTANCE = new ArchiveStagingUsage();

    private ArchiveStagingUsage() {
    }

    public final Map<String, Long> bytesByPackage(File gameRoot, List<ArchivePackage> packages) {
        Intrinsics.checkNotNullParameter(gameRoot, "gameRoot");
        Intrinsics.checkNotNullParameter(packages, "packages");
        File canonicalFile = gameRoot.getCanonicalFile();
        File canonicalFile2 = new File(canonicalFile, ".archive-installing").getCanonicalFile();
        Intrinsics.checkNotNull(canonicalFile2);
        Intrinsics.checkNotNull(canonicalFile);
        if (!isStrictChild(canonicalFile2, canonicalFile)) {
            throw new IOException("Archive work root escapes game root");
        }
        List<ArchivePackage> list = packages;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(list, 10)), 16));
        for (ArchivePackage archivePackage : list) {
            File canonicalFile3 = ArchivePackagePaths.INSTANCE.stagingRoot(canonicalFile2, archivePackage).getCanonicalFile();
            ArchiveStagingUsage archiveStagingUsage = INSTANCE;
            Intrinsics.checkNotNull(canonicalFile3);
            if (!archiveStagingUsage.isStrictChild(canonicalFile3, canonicalFile2)) {
                throw new IOException("Archive staging root escapes work root");
            }
            Pair pair = TuplesKt.to(archivePackage.getId(), Long.valueOf(archiveStagingUsage.measuredBytes(canonicalFile3, canonicalFile3, new LinkedHashSet())));
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        return linkedHashMap;
    }

    private final long measuredBytes(File file, File file2, Set<String> set) {
        long j = 0;
        if (file.exists()) {
            File canonicalFile = file.getCanonicalFile();
            if (!Intrinsics.areEqual(canonicalFile, file2)) {
                Intrinsics.checkNotNull(canonicalFile);
                if (!isStrictChild(canonicalFile, file2)) {
                    return 0L;
                }
            }
            if (canonicalFile.isFile()) {
                return RangesKt.coerceAtLeast(canonicalFile.length(), 0L);
            }
            if (canonicalFile.isDirectory()) {
                String path = canonicalFile.getPath();
                Intrinsics.checkNotNullExpressionValue(path, "getPath(...)");
                if (set.add(path)) {
                    File[] listFiles = canonicalFile.listFiles();
                    if (listFiles == null) {
                        throw new IOException("Unable to list archive staging directory");
                    }
                    try {
                        for (File file3 : listFiles) {
                            ArchiveStagingUsage archiveStagingUsage = INSTANCE;
                            Intrinsics.checkNotNull(file3);
                            j = Math.addExact(j, archiveStagingUsage.measuredBytes(file3, file2, set));
                        }
                        return j;
                    } catch (ArithmeticException e) {
                        throw new IOException("Archive staging byte total overflows Long", e);
                    }
                }
                return 0L;
            }
            return 0L;
        }
        return 0L;
    }

    private final boolean isStrictChild(File file, File file2) {
        String path = file.getPath();
        Intrinsics.checkNotNullExpressionValue(path, "getPath(...)");
        String path2 = file2.getPath();
        return StringsKt.startsWith$default(path, path2 + File.separator, false, 2, (Object) null);
    }
}
