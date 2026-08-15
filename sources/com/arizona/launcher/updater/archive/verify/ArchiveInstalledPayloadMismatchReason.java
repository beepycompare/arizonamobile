package com.arizona.launcher.updater.archive.verify;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ArchiveInstalledPayloadAuditor.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0012\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/arizona/launcher/updater/archive/verify/ArchiveInstalledPayloadMismatchReason;", "", "<init>", "(Ljava/lang/String;I)V", "ROOT_MISSING", "ROOT_NOT_DIRECTORY", "ROOT_NOT_READABLE", "ROOT_UNSAFE", "NO_COMMITTED_FILE_RECORDS", "PATH_UNSAFE", "PATH_ESCAPE", "SYMLINK_LIKE_CANONICAL_MISMATCH", "INVALID_FILE_METADATA", "FILE_MISSING", "NOT_REGULAR_FILE", "FILE_NOT_READABLE", "SIZE_MISMATCH", "CRC32_MISMATCH", "IO_ERROR", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveInstalledPayloadMismatchReason {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ArchiveInstalledPayloadMismatchReason[] $VALUES;
    public static final ArchiveInstalledPayloadMismatchReason ROOT_MISSING = new ArchiveInstalledPayloadMismatchReason("ROOT_MISSING", 0);
    public static final ArchiveInstalledPayloadMismatchReason ROOT_NOT_DIRECTORY = new ArchiveInstalledPayloadMismatchReason("ROOT_NOT_DIRECTORY", 1);
    public static final ArchiveInstalledPayloadMismatchReason ROOT_NOT_READABLE = new ArchiveInstalledPayloadMismatchReason("ROOT_NOT_READABLE", 2);
    public static final ArchiveInstalledPayloadMismatchReason ROOT_UNSAFE = new ArchiveInstalledPayloadMismatchReason("ROOT_UNSAFE", 3);
    public static final ArchiveInstalledPayloadMismatchReason NO_COMMITTED_FILE_RECORDS = new ArchiveInstalledPayloadMismatchReason("NO_COMMITTED_FILE_RECORDS", 4);
    public static final ArchiveInstalledPayloadMismatchReason PATH_UNSAFE = new ArchiveInstalledPayloadMismatchReason("PATH_UNSAFE", 5);
    public static final ArchiveInstalledPayloadMismatchReason PATH_ESCAPE = new ArchiveInstalledPayloadMismatchReason("PATH_ESCAPE", 6);
    public static final ArchiveInstalledPayloadMismatchReason SYMLINK_LIKE_CANONICAL_MISMATCH = new ArchiveInstalledPayloadMismatchReason("SYMLINK_LIKE_CANONICAL_MISMATCH", 7);
    public static final ArchiveInstalledPayloadMismatchReason INVALID_FILE_METADATA = new ArchiveInstalledPayloadMismatchReason("INVALID_FILE_METADATA", 8);
    public static final ArchiveInstalledPayloadMismatchReason FILE_MISSING = new ArchiveInstalledPayloadMismatchReason("FILE_MISSING", 9);
    public static final ArchiveInstalledPayloadMismatchReason NOT_REGULAR_FILE = new ArchiveInstalledPayloadMismatchReason("NOT_REGULAR_FILE", 10);
    public static final ArchiveInstalledPayloadMismatchReason FILE_NOT_READABLE = new ArchiveInstalledPayloadMismatchReason("FILE_NOT_READABLE", 11);
    public static final ArchiveInstalledPayloadMismatchReason SIZE_MISMATCH = new ArchiveInstalledPayloadMismatchReason("SIZE_MISMATCH", 12);
    public static final ArchiveInstalledPayloadMismatchReason CRC32_MISMATCH = new ArchiveInstalledPayloadMismatchReason("CRC32_MISMATCH", 13);
    public static final ArchiveInstalledPayloadMismatchReason IO_ERROR = new ArchiveInstalledPayloadMismatchReason("IO_ERROR", 14);

    private static final /* synthetic */ ArchiveInstalledPayloadMismatchReason[] $values() {
        return new ArchiveInstalledPayloadMismatchReason[]{ROOT_MISSING, ROOT_NOT_DIRECTORY, ROOT_NOT_READABLE, ROOT_UNSAFE, NO_COMMITTED_FILE_RECORDS, PATH_UNSAFE, PATH_ESCAPE, SYMLINK_LIKE_CANONICAL_MISMATCH, INVALID_FILE_METADATA, FILE_MISSING, NOT_REGULAR_FILE, FILE_NOT_READABLE, SIZE_MISMATCH, CRC32_MISMATCH, IO_ERROR};
    }

    public static EnumEntries<ArchiveInstalledPayloadMismatchReason> getEntries() {
        return $ENTRIES;
    }

    public static ArchiveInstalledPayloadMismatchReason valueOf(String str) {
        return (ArchiveInstalledPayloadMismatchReason) Enum.valueOf(ArchiveInstalledPayloadMismatchReason.class, str);
    }

    public static ArchiveInstalledPayloadMismatchReason[] values() {
        return (ArchiveInstalledPayloadMismatchReason[]) $VALUES.clone();
    }

    private ArchiveInstalledPayloadMismatchReason(String str, int i) {
    }

    static {
        ArchiveInstalledPayloadMismatchReason[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
