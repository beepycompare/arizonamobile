package com.arizona.launcher.updater.archive.adoption;

import coil3.util.UtilsKt;
import com.arizona.launcher.updater.archive.adoption.ArchiveAdoptionFileVerification;
import com.arizona.launcher.updater.archive.install.WholeFileCrc32Verifier;
import com.arizona.launcher.updater.archive.install.WholeFileVerificationErrorCode;
import com.arizona.launcher.updater.archive.install.WholeFileVerificationResult;
import java.io.File;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ArchiveInstallAdopter.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016J\f\u0010\u000b\u001a\u00020\f*\u00020\rH\u0002Ê\u0001\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u000e"}, d2 = {"Lcom/arizona/launcher/updater/archive/adoption/JvmArchiveAdoptionFileVerifier;", "Lcom/arizona/launcher/updater/archive/adoption/ArchiveAdoptionFileVerifier;", "<init>", "()V", "verify", "Lcom/arizona/launcher/updater/archive/adoption/ArchiveAdoptionFileVerification;", UtilsKt.SCHEME_FILE, "Ljava/io/File;", "expectedSize", "", "expectedCrc32", "toAdoptionReason", "Lcom/arizona/launcher/updater/archive/adoption/ArchiveAdoptionMismatchReason;", "Lcom/arizona/launcher/updater/archive/install/WholeFileVerificationErrorCode;", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class JvmArchiveAdoptionFileVerifier implements ArchiveAdoptionFileVerifier {
    public static final int $stable = 0;
    public static final JvmArchiveAdoptionFileVerifier INSTANCE = new JvmArchiveAdoptionFileVerifier();

    /* compiled from: ArchiveInstallAdopter.kt */
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

    private JvmArchiveAdoptionFileVerifier() {
    }

    @Override // com.arizona.launcher.updater.archive.adoption.ArchiveAdoptionFileVerifier
    public ArchiveAdoptionFileVerification verify(File file, long j, long j2) {
        Long actualSize;
        Intrinsics.checkNotNullParameter(file, "file");
        WholeFileVerificationResult verify = WholeFileCrc32Verifier.INSTANCE.verify(file, j, j2);
        if (verify instanceof WholeFileVerificationResult.Success) {
            WholeFileVerificationResult.Success success = (WholeFileVerificationResult.Success) verify;
            return new ArchiveAdoptionFileVerification.Match(success.getSize(), success.getCrc32(), success.getSize());
        } else if (!(verify instanceof WholeFileVerificationResult.Failure)) {
            throw new NoWhenBranchMatchedException();
        } else {
            WholeFileVerificationResult.Failure failure = (WholeFileVerificationResult.Failure) verify;
            ArchiveAdoptionMismatchReason adoptionReason = toAdoptionReason(failure.getCode());
            long j3 = 0;
            if (failure.getActualCrc32() != null && (actualSize = failure.getActualSize()) != null) {
                j3 = actualSize.longValue();
            }
            return new ArchiveAdoptionFileVerification.Mismatch(adoptionReason, j3);
        }
    }

    private final ArchiveAdoptionMismatchReason toAdoptionReason(WholeFileVerificationErrorCode wholeFileVerificationErrorCode) {
        switch (WhenMappings.$EnumSwitchMapping$0[wholeFileVerificationErrorCode.ordinal()]) {
            case 1:
            case 2:
                return ArchiveAdoptionMismatchReason.INVALID_ENTRY_METADATA;
            case 3:
                return ArchiveAdoptionMismatchReason.FILE_MISSING;
            case 4:
                return ArchiveAdoptionMismatchReason.NOT_REGULAR_FILE;
            case 5:
                return ArchiveAdoptionMismatchReason.FILE_NOT_READABLE;
            case 6:
                return ArchiveAdoptionMismatchReason.SIZE_MISMATCH;
            case 7:
                return ArchiveAdoptionMismatchReason.CRC32_MISMATCH;
            case 8:
                return ArchiveAdoptionMismatchReason.IO_ERROR;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
