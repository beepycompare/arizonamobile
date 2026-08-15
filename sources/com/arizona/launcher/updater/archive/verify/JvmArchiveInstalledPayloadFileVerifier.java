package com.arizona.launcher.updater.archive.verify;

import coil3.util.UtilsKt;
import com.arizona.launcher.updater.archive.install.WholeFileCrc32Verifier;
import com.arizona.launcher.updater.archive.install.WholeFileVerificationErrorCode;
import com.arizona.launcher.updater.archive.install.WholeFileVerificationResult;
import com.arizona.launcher.updater.archive.verify.ArchiveInstalledPayloadFileVerification;
import java.io.File;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArchiveInstalledPayloadAuditor.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016J\f\u0010\u000b\u001a\u00020\f*\u00020\rH\u0002Ê\u0001\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u000e"}, d2 = {"Lcom/arizona/launcher/updater/archive/verify/JvmArchiveInstalledPayloadFileVerifier;", "Lcom/arizona/launcher/updater/archive/verify/ArchiveInstalledPayloadFileVerifier;", "<init>", "()V", "verify", "Lcom/arizona/launcher/updater/archive/verify/ArchiveInstalledPayloadFileVerification;", UtilsKt.SCHEME_FILE, "Ljava/io/File;", "expectedSize", "", "expectedCrc32", "toAuditReason", "Lcom/arizona/launcher/updater/archive/verify/ArchiveInstalledPayloadMismatchReason;", "Lcom/arizona/launcher/updater/archive/install/WholeFileVerificationErrorCode;", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class JvmArchiveInstalledPayloadFileVerifier implements ArchiveInstalledPayloadFileVerifier {
    public static final int $stable = 0;
    public static final JvmArchiveInstalledPayloadFileVerifier INSTANCE = new JvmArchiveInstalledPayloadFileVerifier();

    /* compiled from: ArchiveInstalledPayloadAuditor.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[WholeFileVerificationErrorCode.values().length];
            try {
                iArr[WholeFileVerificationErrorCode.INVALID_EXPECTED_SIZE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[WholeFileVerificationErrorCode.INVALID_EXPECTED_CRC32.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[WholeFileVerificationErrorCode.FILE_NOT_FOUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[WholeFileVerificationErrorCode.NOT_A_FILE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[WholeFileVerificationErrorCode.FILE_NOT_READABLE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[WholeFileVerificationErrorCode.SIZE_MISMATCH.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[WholeFileVerificationErrorCode.CRC32_MISMATCH.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[WholeFileVerificationErrorCode.IO_ERROR.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private JvmArchiveInstalledPayloadFileVerifier() {
    }

    @Override // com.arizona.launcher.updater.archive.verify.ArchiveInstalledPayloadFileVerifier
    public ArchiveInstalledPayloadFileVerification verify(File file, long j, long j2) {
        Intrinsics.checkNotNullParameter(file, "file");
        WholeFileVerificationResult verify = WholeFileCrc32Verifier.INSTANCE.verify(file, j, j2);
        if (verify instanceof WholeFileVerificationResult.Success) {
            return ArchiveInstalledPayloadFileVerification.Match.INSTANCE;
        }
        if (!(verify instanceof WholeFileVerificationResult.Failure)) {
            throw new NoWhenBranchMatchedException();
        }
        return new ArchiveInstalledPayloadFileVerification.Mismatch(toAuditReason(((WholeFileVerificationResult.Failure) verify).getCode()));
    }

    private final ArchiveInstalledPayloadMismatchReason toAuditReason(WholeFileVerificationErrorCode wholeFileVerificationErrorCode) {
        switch (WhenMappings.$EnumSwitchMapping$0[wholeFileVerificationErrorCode.ordinal()]) {
            case 1:
            case 2:
                return ArchiveInstalledPayloadMismatchReason.INVALID_FILE_METADATA;
            case 3:
                return ArchiveInstalledPayloadMismatchReason.FILE_MISSING;
            case 4:
                return ArchiveInstalledPayloadMismatchReason.NOT_REGULAR_FILE;
            case 5:
                return ArchiveInstalledPayloadMismatchReason.FILE_NOT_READABLE;
            case 6:
                return ArchiveInstalledPayloadMismatchReason.SIZE_MISMATCH;
            case 7:
                return ArchiveInstalledPayloadMismatchReason.CRC32_MISMATCH;
            case 8:
                return ArchiveInstalledPayloadMismatchReason.IO_ERROR;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
