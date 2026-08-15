package com.arizona.launcher.updater.archive.verify;

import coil3.util.UtilsKt;
import com.arizona.launcher.updater.archive.verify.ArchiveInstalledPayloadFileVerification;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArchiveInstalledPayloadAuditor.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016Ê\u0001\f\b\f\u0012\b\b\r\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u000b"}, d2 = {"Lcom/arizona/launcher/updater/archive/verify/JvmArchiveInstalledPayloadMetadataVerifier;", "Lcom/arizona/launcher/updater/archive/verify/ArchiveInstalledPayloadFileVerifier;", "<init>", "()V", "verify", "Lcom/arizona/launcher/updater/archive/verify/ArchiveInstalledPayloadFileVerification;", UtilsKt.SCHEME_FILE, "Ljava/io/File;", "expectedSize", "", "expectedCrc32", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class JvmArchiveInstalledPayloadMetadataVerifier implements ArchiveInstalledPayloadFileVerifier {
    public static final int $stable = 0;
    public static final JvmArchiveInstalledPayloadMetadataVerifier INSTANCE = new JvmArchiveInstalledPayloadMetadataVerifier();

    private JvmArchiveInstalledPayloadMetadataVerifier() {
    }

    @Override // com.arizona.launcher.updater.archive.verify.ArchiveInstalledPayloadFileVerifier
    public ArchiveInstalledPayloadFileVerification verify(File file, long j, long j2) {
        Intrinsics.checkNotNullParameter(file, "file");
        if (j < 0) {
            return new ArchiveInstalledPayloadFileVerification.Mismatch(ArchiveInstalledPayloadMismatchReason.INVALID_FILE_METADATA);
        }
        if (!file.canRead()) {
            return new ArchiveInstalledPayloadFileVerification.Mismatch(ArchiveInstalledPayloadMismatchReason.FILE_NOT_READABLE);
        }
        if (file.length() != j) {
            return new ArchiveInstalledPayloadFileVerification.Mismatch(ArchiveInstalledPayloadMismatchReason.SIZE_MISMATCH);
        }
        return ArchiveInstalledPayloadFileVerification.Match.INSTANCE;
    }
}
