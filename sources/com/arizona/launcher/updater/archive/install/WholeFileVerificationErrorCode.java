package com.arizona.launcher.updater.archive.install;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: WholeFileCrc32Verifier.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/arizona/launcher/updater/archive/install/WholeFileVerificationErrorCode;", "", "<init>", "(Ljava/lang/String;I)V", "INVALID_EXPECTED_SIZE", "INVALID_EXPECTED_CRC32", "FILE_NOT_FOUND", "NOT_A_FILE", "FILE_NOT_READABLE", "SIZE_MISMATCH", "CRC32_MISMATCH", "IO_ERROR", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class WholeFileVerificationErrorCode {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ WholeFileVerificationErrorCode[] $VALUES;
    public static final WholeFileVerificationErrorCode INVALID_EXPECTED_SIZE = new WholeFileVerificationErrorCode("INVALID_EXPECTED_SIZE", 0);
    public static final WholeFileVerificationErrorCode INVALID_EXPECTED_CRC32 = new WholeFileVerificationErrorCode("INVALID_EXPECTED_CRC32", 1);
    public static final WholeFileVerificationErrorCode FILE_NOT_FOUND = new WholeFileVerificationErrorCode("FILE_NOT_FOUND", 2);
    public static final WholeFileVerificationErrorCode NOT_A_FILE = new WholeFileVerificationErrorCode("NOT_A_FILE", 3);
    public static final WholeFileVerificationErrorCode FILE_NOT_READABLE = new WholeFileVerificationErrorCode("FILE_NOT_READABLE", 4);
    public static final WholeFileVerificationErrorCode SIZE_MISMATCH = new WholeFileVerificationErrorCode("SIZE_MISMATCH", 5);
    public static final WholeFileVerificationErrorCode CRC32_MISMATCH = new WholeFileVerificationErrorCode("CRC32_MISMATCH", 6);
    public static final WholeFileVerificationErrorCode IO_ERROR = new WholeFileVerificationErrorCode("IO_ERROR", 7);

    private static final /* synthetic */ WholeFileVerificationErrorCode[] $values() {
        return new WholeFileVerificationErrorCode[]{INVALID_EXPECTED_SIZE, INVALID_EXPECTED_CRC32, FILE_NOT_FOUND, NOT_A_FILE, FILE_NOT_READABLE, SIZE_MISMATCH, CRC32_MISMATCH, IO_ERROR};
    }

    public static EnumEntries<WholeFileVerificationErrorCode> getEntries() {
        return $ENTRIES;
    }

    public static WholeFileVerificationErrorCode valueOf(String str) {
        return (WholeFileVerificationErrorCode) Enum.valueOf(WholeFileVerificationErrorCode.class, str);
    }

    public static WholeFileVerificationErrorCode[] values() {
        return (WholeFileVerificationErrorCode[]) $VALUES.clone();
    }

    private WholeFileVerificationErrorCode(String str, int i) {
    }

    static {
        WholeFileVerificationErrorCode[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
