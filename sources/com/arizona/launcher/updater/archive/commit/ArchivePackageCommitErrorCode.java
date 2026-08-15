package com.arizona.launcher.updater.archive.commit;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ArchivePackageCommitter.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0010\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/arizona/launcher/updater/archive/commit/ArchivePackageCommitErrorCode;", "", "<init>", "(Ljava/lang/String;I)V", "INVALID_PACKAGE_ID", "EMPTY_PACKAGE", "INVALID_ROOT", "INVALID_ENTRY", "SOURCE_MISSING", "SOURCE_VERIFICATION_FAILED", "TARGET_TYPE_CONFLICT", "TARGET_PARENT_INVALID", "BACKUP_CONFLICT", "TARGET_VERIFICATION_FAILED", "CLEANUP_FAILED", "NO_SPACE_LEFT", "IO_ERROR", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchivePackageCommitErrorCode {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ArchivePackageCommitErrorCode[] $VALUES;
    public static final ArchivePackageCommitErrorCode INVALID_PACKAGE_ID = new ArchivePackageCommitErrorCode("INVALID_PACKAGE_ID", 0);
    public static final ArchivePackageCommitErrorCode EMPTY_PACKAGE = new ArchivePackageCommitErrorCode("EMPTY_PACKAGE", 1);
    public static final ArchivePackageCommitErrorCode INVALID_ROOT = new ArchivePackageCommitErrorCode("INVALID_ROOT", 2);
    public static final ArchivePackageCommitErrorCode INVALID_ENTRY = new ArchivePackageCommitErrorCode("INVALID_ENTRY", 3);
    public static final ArchivePackageCommitErrorCode SOURCE_MISSING = new ArchivePackageCommitErrorCode("SOURCE_MISSING", 4);
    public static final ArchivePackageCommitErrorCode SOURCE_VERIFICATION_FAILED = new ArchivePackageCommitErrorCode("SOURCE_VERIFICATION_FAILED", 5);
    public static final ArchivePackageCommitErrorCode TARGET_TYPE_CONFLICT = new ArchivePackageCommitErrorCode("TARGET_TYPE_CONFLICT", 6);
    public static final ArchivePackageCommitErrorCode TARGET_PARENT_INVALID = new ArchivePackageCommitErrorCode("TARGET_PARENT_INVALID", 7);
    public static final ArchivePackageCommitErrorCode BACKUP_CONFLICT = new ArchivePackageCommitErrorCode("BACKUP_CONFLICT", 8);
    public static final ArchivePackageCommitErrorCode TARGET_VERIFICATION_FAILED = new ArchivePackageCommitErrorCode("TARGET_VERIFICATION_FAILED", 9);
    public static final ArchivePackageCommitErrorCode CLEANUP_FAILED = new ArchivePackageCommitErrorCode("CLEANUP_FAILED", 10);
    public static final ArchivePackageCommitErrorCode NO_SPACE_LEFT = new ArchivePackageCommitErrorCode("NO_SPACE_LEFT", 11);
    public static final ArchivePackageCommitErrorCode IO_ERROR = new ArchivePackageCommitErrorCode("IO_ERROR", 12);

    private static final /* synthetic */ ArchivePackageCommitErrorCode[] $values() {
        return new ArchivePackageCommitErrorCode[]{INVALID_PACKAGE_ID, EMPTY_PACKAGE, INVALID_ROOT, INVALID_ENTRY, SOURCE_MISSING, SOURCE_VERIFICATION_FAILED, TARGET_TYPE_CONFLICT, TARGET_PARENT_INVALID, BACKUP_CONFLICT, TARGET_VERIFICATION_FAILED, CLEANUP_FAILED, NO_SPACE_LEFT, IO_ERROR};
    }

    public static EnumEntries<ArchivePackageCommitErrorCode> getEntries() {
        return $ENTRIES;
    }

    public static ArchivePackageCommitErrorCode valueOf(String str) {
        return (ArchivePackageCommitErrorCode) Enum.valueOf(ArchivePackageCommitErrorCode.class, str);
    }

    public static ArchivePackageCommitErrorCode[] values() {
        return (ArchivePackageCommitErrorCode[]) $VALUES.clone();
    }

    private ArchivePackageCommitErrorCode(String str, int i) {
    }

    static {
        ArchivePackageCommitErrorCode[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
