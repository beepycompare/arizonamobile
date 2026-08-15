package com.arizona.launcher.updater.archive.adoption;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ArchiveInstallAdopter.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0011\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/arizona/launcher/updater/archive/adoption/ArchiveAdoptionMismatchReason;", "", "<init>", "(Ljava/lang/String;I)V", "ROOT_MISSING", "ROOT_NOT_DIRECTORY", "ROOT_NOT_READABLE", "ROOT_UNSAFE", "PATH_UNSAFE", "PATH_ESCAPE", "SYMLINK_LIKE_CANONICAL_MISMATCH", "INVALID_ENTRY_METADATA", "FILE_MISSING", "NOT_REGULAR_FILE", "FILE_NOT_READABLE", "SIZE_MISMATCH", "CRC32_MISMATCH", "IO_ERROR", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveAdoptionMismatchReason {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ArchiveAdoptionMismatchReason[] $VALUES;
    public static final ArchiveAdoptionMismatchReason ROOT_MISSING = new ArchiveAdoptionMismatchReason("ROOT_MISSING", 0);
    public static final ArchiveAdoptionMismatchReason ROOT_NOT_DIRECTORY = new ArchiveAdoptionMismatchReason("ROOT_NOT_DIRECTORY", 1);
    public static final ArchiveAdoptionMismatchReason ROOT_NOT_READABLE = new ArchiveAdoptionMismatchReason("ROOT_NOT_READABLE", 2);
    public static final ArchiveAdoptionMismatchReason ROOT_UNSAFE = new ArchiveAdoptionMismatchReason("ROOT_UNSAFE", 3);
    public static final ArchiveAdoptionMismatchReason PATH_UNSAFE = new ArchiveAdoptionMismatchReason("PATH_UNSAFE", 4);
    public static final ArchiveAdoptionMismatchReason PATH_ESCAPE = new ArchiveAdoptionMismatchReason("PATH_ESCAPE", 5);
    public static final ArchiveAdoptionMismatchReason SYMLINK_LIKE_CANONICAL_MISMATCH = new ArchiveAdoptionMismatchReason("SYMLINK_LIKE_CANONICAL_MISMATCH", 6);
    public static final ArchiveAdoptionMismatchReason INVALID_ENTRY_METADATA = new ArchiveAdoptionMismatchReason("INVALID_ENTRY_METADATA", 7);
    public static final ArchiveAdoptionMismatchReason FILE_MISSING = new ArchiveAdoptionMismatchReason("FILE_MISSING", 8);
    public static final ArchiveAdoptionMismatchReason NOT_REGULAR_FILE = new ArchiveAdoptionMismatchReason("NOT_REGULAR_FILE", 9);
    public static final ArchiveAdoptionMismatchReason FILE_NOT_READABLE = new ArchiveAdoptionMismatchReason("FILE_NOT_READABLE", 10);
    public static final ArchiveAdoptionMismatchReason SIZE_MISMATCH = new ArchiveAdoptionMismatchReason("SIZE_MISMATCH", 11);
    public static final ArchiveAdoptionMismatchReason CRC32_MISMATCH = new ArchiveAdoptionMismatchReason("CRC32_MISMATCH", 12);
    public static final ArchiveAdoptionMismatchReason IO_ERROR = new ArchiveAdoptionMismatchReason("IO_ERROR", 13);

    private static final /* synthetic */ ArchiveAdoptionMismatchReason[] $values() {
        return new ArchiveAdoptionMismatchReason[]{ROOT_MISSING, ROOT_NOT_DIRECTORY, ROOT_NOT_READABLE, ROOT_UNSAFE, PATH_UNSAFE, PATH_ESCAPE, SYMLINK_LIKE_CANONICAL_MISMATCH, INVALID_ENTRY_METADATA, FILE_MISSING, NOT_REGULAR_FILE, FILE_NOT_READABLE, SIZE_MISMATCH, CRC32_MISMATCH, IO_ERROR};
    }

    public static EnumEntries<ArchiveAdoptionMismatchReason> getEntries() {
        return $ENTRIES;
    }

    public static ArchiveAdoptionMismatchReason valueOf(String str) {
        return (ArchiveAdoptionMismatchReason) Enum.valueOf(ArchiveAdoptionMismatchReason.class, str);
    }

    public static ArchiveAdoptionMismatchReason[] values() {
        return (ArchiveAdoptionMismatchReason[]) $VALUES.clone();
    }

    private ArchiveAdoptionMismatchReason(String str, int i) {
    }

    static {
        ArchiveAdoptionMismatchReason[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
