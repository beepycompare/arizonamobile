package com.arizona.launcher.updater.archive.transaction;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ArchiveOwnershipDiff.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/arizona/launcher/updater/archive/transaction/ArchiveOwnershipErrorCode;", "", "<init>", "(Ljava/lang/String;I)V", "INVALID_PACKAGE_ID", "UNSAFE_RELATIVE_PATH", "RESERVED_UPDATER_PATH", "DUPLICATE_PATH", "FILE_DESCENDANT_COLLISION", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveOwnershipErrorCode {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ArchiveOwnershipErrorCode[] $VALUES;
    public static final ArchiveOwnershipErrorCode INVALID_PACKAGE_ID = new ArchiveOwnershipErrorCode("INVALID_PACKAGE_ID", 0);
    public static final ArchiveOwnershipErrorCode UNSAFE_RELATIVE_PATH = new ArchiveOwnershipErrorCode("UNSAFE_RELATIVE_PATH", 1);
    public static final ArchiveOwnershipErrorCode RESERVED_UPDATER_PATH = new ArchiveOwnershipErrorCode("RESERVED_UPDATER_PATH", 2);
    public static final ArchiveOwnershipErrorCode DUPLICATE_PATH = new ArchiveOwnershipErrorCode("DUPLICATE_PATH", 3);
    public static final ArchiveOwnershipErrorCode FILE_DESCENDANT_COLLISION = new ArchiveOwnershipErrorCode("FILE_DESCENDANT_COLLISION", 4);

    private static final /* synthetic */ ArchiveOwnershipErrorCode[] $values() {
        return new ArchiveOwnershipErrorCode[]{INVALID_PACKAGE_ID, UNSAFE_RELATIVE_PATH, RESERVED_UPDATER_PATH, DUPLICATE_PATH, FILE_DESCENDANT_COLLISION};
    }

    public static EnumEntries<ArchiveOwnershipErrorCode> getEntries() {
        return $ENTRIES;
    }

    public static ArchiveOwnershipErrorCode valueOf(String str) {
        return (ArchiveOwnershipErrorCode) Enum.valueOf(ArchiveOwnershipErrorCode.class, str);
    }

    public static ArchiveOwnershipErrorCode[] values() {
        return (ArchiveOwnershipErrorCode[]) $VALUES.clone();
    }

    private ArchiveOwnershipErrorCode(String str, int i) {
    }

    static {
        ArchiveOwnershipErrorCode[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
