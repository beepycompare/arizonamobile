package com.arizona.launcher.updater.archive.transaction;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ArchiveFileRetirement.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/arizona/launcher/updater/archive/transaction/ArchiveRetirementErrorCode;", "", "<init>", "(Ljava/lang/String;I)V", "INVALID_TRANSACTION_ID", "INVALID_OWNERSHIP", "GAME_ROOT_INVALID", "SOURCE_MISSING", "SOURCE_NOT_REGULAR", "TRASH_CONFLICT", "UNSAFE_FILESYSTEM_NODE", "IO_ERROR", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveRetirementErrorCode {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ArchiveRetirementErrorCode[] $VALUES;
    public static final ArchiveRetirementErrorCode INVALID_TRANSACTION_ID = new ArchiveRetirementErrorCode("INVALID_TRANSACTION_ID", 0);
    public static final ArchiveRetirementErrorCode INVALID_OWNERSHIP = new ArchiveRetirementErrorCode("INVALID_OWNERSHIP", 1);
    public static final ArchiveRetirementErrorCode GAME_ROOT_INVALID = new ArchiveRetirementErrorCode("GAME_ROOT_INVALID", 2);
    public static final ArchiveRetirementErrorCode SOURCE_MISSING = new ArchiveRetirementErrorCode("SOURCE_MISSING", 3);
    public static final ArchiveRetirementErrorCode SOURCE_NOT_REGULAR = new ArchiveRetirementErrorCode("SOURCE_NOT_REGULAR", 4);
    public static final ArchiveRetirementErrorCode TRASH_CONFLICT = new ArchiveRetirementErrorCode("TRASH_CONFLICT", 5);
    public static final ArchiveRetirementErrorCode UNSAFE_FILESYSTEM_NODE = new ArchiveRetirementErrorCode("UNSAFE_FILESYSTEM_NODE", 6);
    public static final ArchiveRetirementErrorCode IO_ERROR = new ArchiveRetirementErrorCode("IO_ERROR", 7);

    private static final /* synthetic */ ArchiveRetirementErrorCode[] $values() {
        return new ArchiveRetirementErrorCode[]{INVALID_TRANSACTION_ID, INVALID_OWNERSHIP, GAME_ROOT_INVALID, SOURCE_MISSING, SOURCE_NOT_REGULAR, TRASH_CONFLICT, UNSAFE_FILESYSTEM_NODE, IO_ERROR};
    }

    public static EnumEntries<ArchiveRetirementErrorCode> getEntries() {
        return $ENTRIES;
    }

    public static ArchiveRetirementErrorCode valueOf(String str) {
        return (ArchiveRetirementErrorCode) Enum.valueOf(ArchiveRetirementErrorCode.class, str);
    }

    public static ArchiveRetirementErrorCode[] values() {
        return (ArchiveRetirementErrorCode[]) $VALUES.clone();
    }

    private ArchiveRetirementErrorCode(String str, int i) {
    }

    static {
        ArchiveRetirementErrorCode[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
