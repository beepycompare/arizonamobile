package com.arizona.launcher.updater.archive.orchestrator;

import com.arizona.launcher.updater.archive.install.SafeZipExtractionResult;
import java.io.File;
import kotlin.Metadata;
/* compiled from: ArchivePackageUpdater.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\bà\u0080\u0001\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveExtractor;", "", "extract", "Lcom/arizona/launcher/updater/archive/install/SafeZipExtractionResult;", "archive", "Ljava/io/File;", "stagingRoot", "expectedInstalledSize", "", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface ArchiveExtractor {
    SafeZipExtractionResult extract(File file, File file2, long j);
}
