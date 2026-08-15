package com.arizona.launcher.updater.archive.adoption;

import coil3.util.UtilsKt;
import java.io.File;
import kotlin.Metadata;
/* compiled from: ArchiveInstallAdopter.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\bà\u0080\u0001\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H&¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lcom/arizona/launcher/updater/archive/adoption/ArchiveAdoptionFileVerifier;", "", "verify", "Lcom/arizona/launcher/updater/archive/adoption/ArchiveAdoptionFileVerification;", UtilsKt.SCHEME_FILE, "Ljava/io/File;", "expectedSize", "", "expectedCrc32", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface ArchiveAdoptionFileVerifier {
    ArchiveAdoptionFileVerification verify(File file, long j, long j2);
}
