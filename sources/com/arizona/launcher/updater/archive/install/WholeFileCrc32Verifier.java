package com.arizona.launcher.updater.archive.install;

import coil3.util.UtilsKt;
import com.arizona.launcher.updater.archive.install.WholeFileVerificationResult;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.CRC32;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: WholeFileCrc32Verifier.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000Ê\u0001\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\u0003\u0010\u0002¨\u0006\u000e"}, d2 = {"Lcom/arizona/launcher/updater/archive/install/WholeFileCrc32Verifier;", "", "<init>", "()V", "BUFFER_SIZE", "", "MAX_CRC32", "", "verify", "Lcom/arizona/launcher/updater/archive/install/WholeFileVerificationResult;", UtilsKt.SCHEME_FILE, "Ljava/io/File;", "expectedSize", "expectedCrc32", "app", "Landroidx/compose/runtime/internal/StabilityInferred;", "parameters"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class WholeFileCrc32Verifier {
    public static final int $stable = 0;
    private static final int BUFFER_SIZE = 65536;
    public static final WholeFileCrc32Verifier INSTANCE = new WholeFileCrc32Verifier();
    private static final long MAX_CRC32 = 4294967295L;

    private WholeFileCrc32Verifier() {
    }

    public final WholeFileVerificationResult verify(File file, long j, long j2) {
        Intrinsics.checkNotNullParameter(file, "file");
        long j3 = 0;
        if (j < 0) {
            return new WholeFileVerificationResult.Failure(WholeFileVerificationErrorCode.INVALID_EXPECTED_SIZE, null, null, 6, null);
        }
        if (0 > j2 || j2 >= 4294967296L) {
            return new WholeFileVerificationResult.Failure(WholeFileVerificationErrorCode.INVALID_EXPECTED_CRC32, null, null, 6, null);
        }
        if (!file.exists()) {
            return new WholeFileVerificationResult.Failure(WholeFileVerificationErrorCode.FILE_NOT_FOUND, null, null, 6, null);
        }
        if (!file.isFile()) {
            return new WholeFileVerificationResult.Failure(WholeFileVerificationErrorCode.NOT_A_FILE, null, null, 6, null);
        }
        if (!file.canRead()) {
            return new WholeFileVerificationResult.Failure(WholeFileVerificationErrorCode.FILE_NOT_READABLE, null, null, 6, null);
        }
        long length = file.length();
        if (length != j) {
            return new WholeFileVerificationResult.Failure(WholeFileVerificationErrorCode.SIZE_MISMATCH, Long.valueOf(length), null, 4, null);
        }
        try {
            CRC32 crc32 = new CRC32();
            byte[] bArr = new byte[65536];
            FileInputStream fileInputStream = new FileInputStream(file);
            BufferedInputStream bufferedInputStream = fileInputStream instanceof BufferedInputStream ? (BufferedInputStream) fileInputStream : new BufferedInputStream(fileInputStream, 65536);
            try {
                BufferedInputStream bufferedInputStream2 = bufferedInputStream;
                while (true) {
                    int read = bufferedInputStream2.read(bArr);
                    if (read < 0) {
                        Unit unit = Unit.INSTANCE;
                        CloseableKt.closeFinally(bufferedInputStream, null);
                        long value = crc32.getValue();
                        long length2 = file.length();
                        if (j3 == j && length2 == j3) {
                            return value != j2 ? new WholeFileVerificationResult.Failure(WholeFileVerificationErrorCode.CRC32_MISMATCH, Long.valueOf(j3), Long.valueOf(value)) : new WholeFileVerificationResult.Success(j3, value);
                        }
                        return new WholeFileVerificationResult.Failure(WholeFileVerificationErrorCode.SIZE_MISMATCH, Long.valueOf(j3), Long.valueOf(value));
                    } else if (read != 0) {
                        long j4 = read;
                        if (j3 > Long.MAX_VALUE - j4) {
                            WholeFileVerificationResult.Failure failure = new WholeFileVerificationResult.Failure(WholeFileVerificationErrorCode.SIZE_MISMATCH, Long.valueOf(j3), null, 4, null);
                            CloseableKt.closeFinally(bufferedInputStream, null);
                            return failure;
                        }
                        j3 += j4;
                        crc32.update(bArr, 0, read);
                    }
                }
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(bufferedInputStream, th);
                    throw th2;
                }
            }
        } catch (IOException unused) {
            return new WholeFileVerificationResult.Failure(WholeFileVerificationErrorCode.IO_ERROR, null, null, 6, null);
        } catch (SecurityException unused2) {
            return new WholeFileVerificationResult.Failure(WholeFileVerificationErrorCode.FILE_NOT_READABLE, null, null, 6, null);
        }
    }
}
