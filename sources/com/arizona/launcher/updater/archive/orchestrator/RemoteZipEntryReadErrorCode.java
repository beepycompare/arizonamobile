package com.arizona.launcher.updater.archive.orchestrator;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: RemoteZipEntryRangeReader.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\r\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/RemoteZipEntryReadErrorCode;", "", "<init>", "(Ljava/lang/String;I)V", "LOCAL_HEADER_INVALID", "LOCAL_HEADER_MISMATCH", "REPRESENTATION_CHANGED", "RANGE_FAILED", "ENTRY_DATA_CORRUPT", "ENTRY_SIZE_MISMATCH", "ENTRY_CRC32_MISMATCH", "PATH_UNSAFE", "NO_SPACE_LEFT", "IO_ERROR", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class RemoteZipEntryReadErrorCode {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ RemoteZipEntryReadErrorCode[] $VALUES;
    public static final RemoteZipEntryReadErrorCode LOCAL_HEADER_INVALID = new RemoteZipEntryReadErrorCode("LOCAL_HEADER_INVALID", 0);
    public static final RemoteZipEntryReadErrorCode LOCAL_HEADER_MISMATCH = new RemoteZipEntryReadErrorCode("LOCAL_HEADER_MISMATCH", 1);
    public static final RemoteZipEntryReadErrorCode REPRESENTATION_CHANGED = new RemoteZipEntryReadErrorCode("REPRESENTATION_CHANGED", 2);
    public static final RemoteZipEntryReadErrorCode RANGE_FAILED = new RemoteZipEntryReadErrorCode("RANGE_FAILED", 3);
    public static final RemoteZipEntryReadErrorCode ENTRY_DATA_CORRUPT = new RemoteZipEntryReadErrorCode("ENTRY_DATA_CORRUPT", 4);
    public static final RemoteZipEntryReadErrorCode ENTRY_SIZE_MISMATCH = new RemoteZipEntryReadErrorCode("ENTRY_SIZE_MISMATCH", 5);
    public static final RemoteZipEntryReadErrorCode ENTRY_CRC32_MISMATCH = new RemoteZipEntryReadErrorCode("ENTRY_CRC32_MISMATCH", 6);
    public static final RemoteZipEntryReadErrorCode PATH_UNSAFE = new RemoteZipEntryReadErrorCode("PATH_UNSAFE", 7);
    public static final RemoteZipEntryReadErrorCode NO_SPACE_LEFT = new RemoteZipEntryReadErrorCode("NO_SPACE_LEFT", 8);
    public static final RemoteZipEntryReadErrorCode IO_ERROR = new RemoteZipEntryReadErrorCode("IO_ERROR", 9);

    private static final /* synthetic */ RemoteZipEntryReadErrorCode[] $values() {
        return new RemoteZipEntryReadErrorCode[]{LOCAL_HEADER_INVALID, LOCAL_HEADER_MISMATCH, REPRESENTATION_CHANGED, RANGE_FAILED, ENTRY_DATA_CORRUPT, ENTRY_SIZE_MISMATCH, ENTRY_CRC32_MISMATCH, PATH_UNSAFE, NO_SPACE_LEFT, IO_ERROR};
    }

    public static EnumEntries<RemoteZipEntryReadErrorCode> getEntries() {
        return $ENTRIES;
    }

    public static RemoteZipEntryReadErrorCode valueOf(String str) {
        return (RemoteZipEntryReadErrorCode) Enum.valueOf(RemoteZipEntryReadErrorCode.class, str);
    }

    public static RemoteZipEntryReadErrorCode[] values() {
        return (RemoteZipEntryReadErrorCode[]) $VALUES.clone();
    }

    private RemoteZipEntryReadErrorCode(String str, int i) {
    }

    static {
        RemoteZipEntryReadErrorCode[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
