package com.arizona.launcher.updater.archive.orchestrator;

import com.arizona.launcher.updater.archive.model.ArchivePackage;
import com.arizona.launcher.updater.archive.state.ArchivePackageIdentity;
import com.google.android.vending.expansion.downloader.Constants;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
/* compiled from: ArchivePackagePaths.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nJ \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0016\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nJ \u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002Ê\u0001\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u0011"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchivePackagePaths;", "", "<init>", "()V", "archiveFile", "Ljava/io/File;", "downloadRoot", "archivePackage", "Lcom/arizona/launcher/updater/archive/model/ArchivePackage;", "identity", "Lcom/arizona/launcher/updater/archive/state/ArchivePackageIdentity;", "packageId", "", "archiveCrc32", "", "stagingRoot", "workRoot", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchivePackagePaths {
    public static final int $stable = 0;
    public static final ArchivePackagePaths INSTANCE = new ArchivePackagePaths();

    private ArchivePackagePaths() {
    }

    public final File archiveFile(File downloadRoot, ArchivePackage archivePackage) {
        Intrinsics.checkNotNullParameter(downloadRoot, "downloadRoot");
        Intrinsics.checkNotNullParameter(archivePackage, "archivePackage");
        return archiveFile(downloadRoot, archivePackage.getId(), archivePackage.getCrc32());
    }

    public final File archiveFile(File downloadRoot, ArchivePackageIdentity identity) {
        Intrinsics.checkNotNullParameter(downloadRoot, "downloadRoot");
        Intrinsics.checkNotNullParameter(identity, "identity");
        return archiveFile(downloadRoot, identity.getPackageId(), identity.getArchiveCrc32());
    }

    private final File archiveFile(File file, String str, long j) {
        String l = Long.toString(j, CharsKt.checkRadix(16));
        Intrinsics.checkNotNullExpressionValue(l, "toString(...)");
        return new File(file, str + Constants.FILENAME_SEQUENCE_SEPARATOR + l + ".zip.part");
    }

    public final File stagingRoot(File workRoot, ArchivePackage archivePackage) {
        Intrinsics.checkNotNullParameter(workRoot, "workRoot");
        Intrinsics.checkNotNullParameter(archivePackage, "archivePackage");
        return stagingRoot(workRoot, archivePackage.getId(), archivePackage.getCrc32());
    }

    public final File stagingRoot(File workRoot, ArchivePackageIdentity identity) {
        Intrinsics.checkNotNullParameter(workRoot, "workRoot");
        Intrinsics.checkNotNullParameter(identity, "identity");
        return stagingRoot(workRoot, identity.getPackageId(), identity.getArchiveCrc32());
    }

    private final File stagingRoot(File file, String str, long j) {
        String l = Long.toString(j, CharsKt.checkRadix(16));
        Intrinsics.checkNotNullExpressionValue(l, "toString(...)");
        return new File(file, "packages/" + str + Constants.FILENAME_SEQUENCE_SEPARATOR + l);
    }
}
