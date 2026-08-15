package com.arizona.launcher.updater.archive.install;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: SafeZipExtractor.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b/\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/¨\u00060"}, d2 = {"Lcom/arizona/launcher/updater/archive/install/SafeZipExtractionErrorCode;", "", "<init>", "(Ljava/lang/String;I)V", "ARCHIVE_NOT_FOUND", "ARCHIVE_NOT_FILE", "ARCHIVE_NOT_READABLE", "STAGING_ROOT_INVALID", "STAGING_ROOT_NOT_EMPTY", "CANNOT_CREATE_STAGING_ROOT", "EMPTY_ARCHIVE", "MALFORMED_ARCHIVE", "MULTI_DISK_ARCHIVE_UNSUPPORTED", "ENTRY_COUNT_LIMIT_EXCEEDED", "ENTRY_NAME_EMPTY", "ENTRY_NAME_CONTAINS_NUL", "ENTRY_NAME_CONTAINS_BACKSLASH", "ABSOLUTE_ENTRY_PATH", "ENTRY_PREFIX_INVALID", "EMPTY_PATH_SEGMENT", "DOT_PATH_SEGMENT", "PATH_TRAVERSAL", "DUPLICATE_ENTRY", "CASE_COLLISION", "FILE_DIRECTORY_COLLISION", "ENTRY_OUTSIDE_STAGING_ROOT", "ENCRYPTED_ENTRY", "UNSUPPORTED_ENTRY_FLAGS", "SYMLINK_ENTRY", "UNSUPPORTED_ENTRY_TYPE", "ENTRY_TYPE_MISMATCH", "UNSUPPORTED_COMPRESSION_METHOD", "ENTRY_SIZE_UNKNOWN", "ENTRY_CRC_UNKNOWN", "ENTRY_METADATA_INCONSISTENT", "DIRECTORY_HAS_DATA", "ENTRY_SIZE_LIMIT_EXCEEDED", "TOTAL_SIZE_LIMIT_EXCEEDED", "COMPRESSION_RATIO_LIMIT_EXCEEDED", "CANNOT_CREATE_DIRECTORY", "OUTPUT_TARGET_ALREADY_EXISTS", "ENTRY_SIZE_MISMATCH", "TOTAL_SIZE_MISMATCH", "ENTRY_CRC32_MISMATCH", "ENTRY_DATA_CORRUPT", "NO_SPACE_LEFT", "ENTRY_IO_ERROR", "IO_ERROR", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class SafeZipExtractionErrorCode {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SafeZipExtractionErrorCode[] $VALUES;
    public static final SafeZipExtractionErrorCode ARCHIVE_NOT_FOUND = new SafeZipExtractionErrorCode("ARCHIVE_NOT_FOUND", 0);
    public static final SafeZipExtractionErrorCode ARCHIVE_NOT_FILE = new SafeZipExtractionErrorCode("ARCHIVE_NOT_FILE", 1);
    public static final SafeZipExtractionErrorCode ARCHIVE_NOT_READABLE = new SafeZipExtractionErrorCode("ARCHIVE_NOT_READABLE", 2);
    public static final SafeZipExtractionErrorCode STAGING_ROOT_INVALID = new SafeZipExtractionErrorCode("STAGING_ROOT_INVALID", 3);
    public static final SafeZipExtractionErrorCode STAGING_ROOT_NOT_EMPTY = new SafeZipExtractionErrorCode("STAGING_ROOT_NOT_EMPTY", 4);
    public static final SafeZipExtractionErrorCode CANNOT_CREATE_STAGING_ROOT = new SafeZipExtractionErrorCode("CANNOT_CREATE_STAGING_ROOT", 5);
    public static final SafeZipExtractionErrorCode EMPTY_ARCHIVE = new SafeZipExtractionErrorCode("EMPTY_ARCHIVE", 6);
    public static final SafeZipExtractionErrorCode MALFORMED_ARCHIVE = new SafeZipExtractionErrorCode("MALFORMED_ARCHIVE", 7);
    public static final SafeZipExtractionErrorCode MULTI_DISK_ARCHIVE_UNSUPPORTED = new SafeZipExtractionErrorCode("MULTI_DISK_ARCHIVE_UNSUPPORTED", 8);
    public static final SafeZipExtractionErrorCode ENTRY_COUNT_LIMIT_EXCEEDED = new SafeZipExtractionErrorCode("ENTRY_COUNT_LIMIT_EXCEEDED", 9);
    public static final SafeZipExtractionErrorCode ENTRY_NAME_EMPTY = new SafeZipExtractionErrorCode("ENTRY_NAME_EMPTY", 10);
    public static final SafeZipExtractionErrorCode ENTRY_NAME_CONTAINS_NUL = new SafeZipExtractionErrorCode("ENTRY_NAME_CONTAINS_NUL", 11);
    public static final SafeZipExtractionErrorCode ENTRY_NAME_CONTAINS_BACKSLASH = new SafeZipExtractionErrorCode("ENTRY_NAME_CONTAINS_BACKSLASH", 12);
    public static final SafeZipExtractionErrorCode ABSOLUTE_ENTRY_PATH = new SafeZipExtractionErrorCode("ABSOLUTE_ENTRY_PATH", 13);
    public static final SafeZipExtractionErrorCode ENTRY_PREFIX_INVALID = new SafeZipExtractionErrorCode("ENTRY_PREFIX_INVALID", 14);
    public static final SafeZipExtractionErrorCode EMPTY_PATH_SEGMENT = new SafeZipExtractionErrorCode("EMPTY_PATH_SEGMENT", 15);
    public static final SafeZipExtractionErrorCode DOT_PATH_SEGMENT = new SafeZipExtractionErrorCode("DOT_PATH_SEGMENT", 16);
    public static final SafeZipExtractionErrorCode PATH_TRAVERSAL = new SafeZipExtractionErrorCode("PATH_TRAVERSAL", 17);
    public static final SafeZipExtractionErrorCode DUPLICATE_ENTRY = new SafeZipExtractionErrorCode("DUPLICATE_ENTRY", 18);
    public static final SafeZipExtractionErrorCode CASE_COLLISION = new SafeZipExtractionErrorCode("CASE_COLLISION", 19);
    public static final SafeZipExtractionErrorCode FILE_DIRECTORY_COLLISION = new SafeZipExtractionErrorCode("FILE_DIRECTORY_COLLISION", 20);
    public static final SafeZipExtractionErrorCode ENTRY_OUTSIDE_STAGING_ROOT = new SafeZipExtractionErrorCode("ENTRY_OUTSIDE_STAGING_ROOT", 21);
    public static final SafeZipExtractionErrorCode ENCRYPTED_ENTRY = new SafeZipExtractionErrorCode("ENCRYPTED_ENTRY", 22);
    public static final SafeZipExtractionErrorCode UNSUPPORTED_ENTRY_FLAGS = new SafeZipExtractionErrorCode("UNSUPPORTED_ENTRY_FLAGS", 23);
    public static final SafeZipExtractionErrorCode SYMLINK_ENTRY = new SafeZipExtractionErrorCode("SYMLINK_ENTRY", 24);
    public static final SafeZipExtractionErrorCode UNSUPPORTED_ENTRY_TYPE = new SafeZipExtractionErrorCode("UNSUPPORTED_ENTRY_TYPE", 25);
    public static final SafeZipExtractionErrorCode ENTRY_TYPE_MISMATCH = new SafeZipExtractionErrorCode("ENTRY_TYPE_MISMATCH", 26);
    public static final SafeZipExtractionErrorCode UNSUPPORTED_COMPRESSION_METHOD = new SafeZipExtractionErrorCode("UNSUPPORTED_COMPRESSION_METHOD", 27);
    public static final SafeZipExtractionErrorCode ENTRY_SIZE_UNKNOWN = new SafeZipExtractionErrorCode("ENTRY_SIZE_UNKNOWN", 28);
    public static final SafeZipExtractionErrorCode ENTRY_CRC_UNKNOWN = new SafeZipExtractionErrorCode("ENTRY_CRC_UNKNOWN", 29);
    public static final SafeZipExtractionErrorCode ENTRY_METADATA_INCONSISTENT = new SafeZipExtractionErrorCode("ENTRY_METADATA_INCONSISTENT", 30);
    public static final SafeZipExtractionErrorCode DIRECTORY_HAS_DATA = new SafeZipExtractionErrorCode("DIRECTORY_HAS_DATA", 31);
    public static final SafeZipExtractionErrorCode ENTRY_SIZE_LIMIT_EXCEEDED = new SafeZipExtractionErrorCode("ENTRY_SIZE_LIMIT_EXCEEDED", 32);
    public static final SafeZipExtractionErrorCode TOTAL_SIZE_LIMIT_EXCEEDED = new SafeZipExtractionErrorCode("TOTAL_SIZE_LIMIT_EXCEEDED", 33);
    public static final SafeZipExtractionErrorCode COMPRESSION_RATIO_LIMIT_EXCEEDED = new SafeZipExtractionErrorCode("COMPRESSION_RATIO_LIMIT_EXCEEDED", 34);
    public static final SafeZipExtractionErrorCode CANNOT_CREATE_DIRECTORY = new SafeZipExtractionErrorCode("CANNOT_CREATE_DIRECTORY", 35);
    public static final SafeZipExtractionErrorCode OUTPUT_TARGET_ALREADY_EXISTS = new SafeZipExtractionErrorCode("OUTPUT_TARGET_ALREADY_EXISTS", 36);
    public static final SafeZipExtractionErrorCode ENTRY_SIZE_MISMATCH = new SafeZipExtractionErrorCode("ENTRY_SIZE_MISMATCH", 37);
    public static final SafeZipExtractionErrorCode TOTAL_SIZE_MISMATCH = new SafeZipExtractionErrorCode("TOTAL_SIZE_MISMATCH", 38);
    public static final SafeZipExtractionErrorCode ENTRY_CRC32_MISMATCH = new SafeZipExtractionErrorCode("ENTRY_CRC32_MISMATCH", 39);
    public static final SafeZipExtractionErrorCode ENTRY_DATA_CORRUPT = new SafeZipExtractionErrorCode("ENTRY_DATA_CORRUPT", 40);
    public static final SafeZipExtractionErrorCode NO_SPACE_LEFT = new SafeZipExtractionErrorCode("NO_SPACE_LEFT", 41);
    public static final SafeZipExtractionErrorCode ENTRY_IO_ERROR = new SafeZipExtractionErrorCode("ENTRY_IO_ERROR", 42);
    public static final SafeZipExtractionErrorCode IO_ERROR = new SafeZipExtractionErrorCode("IO_ERROR", 43);

    private static final /* synthetic */ SafeZipExtractionErrorCode[] $values() {
        return new SafeZipExtractionErrorCode[]{ARCHIVE_NOT_FOUND, ARCHIVE_NOT_FILE, ARCHIVE_NOT_READABLE, STAGING_ROOT_INVALID, STAGING_ROOT_NOT_EMPTY, CANNOT_CREATE_STAGING_ROOT, EMPTY_ARCHIVE, MALFORMED_ARCHIVE, MULTI_DISK_ARCHIVE_UNSUPPORTED, ENTRY_COUNT_LIMIT_EXCEEDED, ENTRY_NAME_EMPTY, ENTRY_NAME_CONTAINS_NUL, ENTRY_NAME_CONTAINS_BACKSLASH, ABSOLUTE_ENTRY_PATH, ENTRY_PREFIX_INVALID, EMPTY_PATH_SEGMENT, DOT_PATH_SEGMENT, PATH_TRAVERSAL, DUPLICATE_ENTRY, CASE_COLLISION, FILE_DIRECTORY_COLLISION, ENTRY_OUTSIDE_STAGING_ROOT, ENCRYPTED_ENTRY, UNSUPPORTED_ENTRY_FLAGS, SYMLINK_ENTRY, UNSUPPORTED_ENTRY_TYPE, ENTRY_TYPE_MISMATCH, UNSUPPORTED_COMPRESSION_METHOD, ENTRY_SIZE_UNKNOWN, ENTRY_CRC_UNKNOWN, ENTRY_METADATA_INCONSISTENT, DIRECTORY_HAS_DATA, ENTRY_SIZE_LIMIT_EXCEEDED, TOTAL_SIZE_LIMIT_EXCEEDED, COMPRESSION_RATIO_LIMIT_EXCEEDED, CANNOT_CREATE_DIRECTORY, OUTPUT_TARGET_ALREADY_EXISTS, ENTRY_SIZE_MISMATCH, TOTAL_SIZE_MISMATCH, ENTRY_CRC32_MISMATCH, ENTRY_DATA_CORRUPT, NO_SPACE_LEFT, ENTRY_IO_ERROR, IO_ERROR};
    }

    public static EnumEntries<SafeZipExtractionErrorCode> getEntries() {
        return $ENTRIES;
    }

    public static SafeZipExtractionErrorCode valueOf(String str) {
        return (SafeZipExtractionErrorCode) Enum.valueOf(SafeZipExtractionErrorCode.class, str);
    }

    public static SafeZipExtractionErrorCode[] values() {
        return (SafeZipExtractionErrorCode[]) $VALUES.clone();
    }

    private SafeZipExtractionErrorCode(String str, int i) {
    }

    static {
        SafeZipExtractionErrorCode[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
