package com.arizona.launcher.updater.archive.orchestrator;

import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArchiveDownloadRootResolver.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0000\u001a\u0010\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0000¨\u0006\u0005"}, d2 = {"archivePrimaryDownloadRoot", "Ljava/io/File;", "externalCache", "archiveFallbackDownloadRoot", "externalFiles", "app"}, k = 2, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveDownloadRootResolverKt {
    public static final File archivePrimaryDownloadRoot(File externalCache) {
        Intrinsics.checkNotNullParameter(externalCache, "externalCache");
        return new File(new File(externalCache, "archive-updater"), "downloads");
    }

    public static final File archiveFallbackDownloadRoot(File externalFiles) {
        Intrinsics.checkNotNullParameter(externalFiles, "externalFiles");
        return new File(new File(externalFiles, ".archive-installing"), ".downloads");
    }
}
