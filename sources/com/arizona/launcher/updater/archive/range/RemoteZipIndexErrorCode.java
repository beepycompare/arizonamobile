package com.arizona.launcher.updater.archive.range;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: RemoteZipIndexModels.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b%\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%¨\u0006&"}, d2 = {"Lcom/arizona/launcher/updater/archive/range/RemoteZipIndexErrorCode;", "", "<init>", "(Ljava/lang/String;I)V", "TAIL_IS_NOT_ARCHIVE_SUFFIX", "EOCD_NOT_FOUND", "MULTI_DISK_ARCHIVE_UNSUPPORTED", "ZIP64_UNSUPPORTED", "EMPTY_ARCHIVE", "ENTRY_COUNT_LIMIT_EXCEEDED", "CENTRAL_DIRECTORY_SIZE_LIMIT_EXCEEDED", "CENTRAL_DIRECTORY_BOUNDS_INVALID", "CENTRAL_DIRECTORY_LENGTH_MISMATCH", "MALFORMED_CENTRAL_DIRECTORY", "ENTRY_NAME_INVALID_ENCODING", "ENTRY_NAME_EMPTY", "ENTRY_NAME_CONTAINS_NUL", "ENTRY_NAME_CONTAINS_BACKSLASH", "ABSOLUTE_ENTRY_PATH", "ENTRY_PREFIX_INVALID", "EMPTY_PATH_SEGMENT", "DOT_PATH_SEGMENT", "PATH_TRAVERSAL", "DUPLICATE_ENTRY", "CASE_COLLISION", "FILE_DIRECTORY_COLLISION", "ENCRYPTED_ENTRY", "UNSUPPORTED_ENTRY_FLAGS", "SYMLINK_ENTRY", "UNSUPPORTED_ENTRY_TYPE", "ENTRY_TYPE_MISMATCH", "UNSUPPORTED_COMPRESSION_METHOD", "ENTRY_METADATA_INCONSISTENT", "DIRECTORY_HAS_DATA", "ENTRY_SIZE_LIMIT_EXCEEDED", "TOTAL_SIZE_LIMIT_EXCEEDED", "COMPRESSION_RATIO_LIMIT_EXCEEDED", "LOCAL_HEADER_BOUNDS_INVALID", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class RemoteZipIndexErrorCode {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ RemoteZipIndexErrorCode[] $VALUES;
    public static final RemoteZipIndexErrorCode TAIL_IS_NOT_ARCHIVE_SUFFIX = new RemoteZipIndexErrorCode("TAIL_IS_NOT_ARCHIVE_SUFFIX", 0);
    public static final RemoteZipIndexErrorCode EOCD_NOT_FOUND = new RemoteZipIndexErrorCode("EOCD_NOT_FOUND", 1);
    public static final RemoteZipIndexErrorCode MULTI_DISK_ARCHIVE_UNSUPPORTED = new RemoteZipIndexErrorCode("MULTI_DISK_ARCHIVE_UNSUPPORTED", 2);
    public static final RemoteZipIndexErrorCode ZIP64_UNSUPPORTED = new RemoteZipIndexErrorCode("ZIP64_UNSUPPORTED", 3);
    public static final RemoteZipIndexErrorCode EMPTY_ARCHIVE = new RemoteZipIndexErrorCode("EMPTY_ARCHIVE", 4);
    public static final RemoteZipIndexErrorCode ENTRY_COUNT_LIMIT_EXCEEDED = new RemoteZipIndexErrorCode("ENTRY_COUNT_LIMIT_EXCEEDED", 5);
    public static final RemoteZipIndexErrorCode CENTRAL_DIRECTORY_SIZE_LIMIT_EXCEEDED = new RemoteZipIndexErrorCode("CENTRAL_DIRECTORY_SIZE_LIMIT_EXCEEDED", 6);
    public static final RemoteZipIndexErrorCode CENTRAL_DIRECTORY_BOUNDS_INVALID = new RemoteZipIndexErrorCode("CENTRAL_DIRECTORY_BOUNDS_INVALID", 7);
    public static final RemoteZipIndexErrorCode CENTRAL_DIRECTORY_LENGTH_MISMATCH = new RemoteZipIndexErrorCode("CENTRAL_DIRECTORY_LENGTH_MISMATCH", 8);
    public static final RemoteZipIndexErrorCode MALFORMED_CENTRAL_DIRECTORY = new RemoteZipIndexErrorCode("MALFORMED_CENTRAL_DIRECTORY", 9);
    public static final RemoteZipIndexErrorCode ENTRY_NAME_INVALID_ENCODING = new RemoteZipIndexErrorCode("ENTRY_NAME_INVALID_ENCODING", 10);
    public static final RemoteZipIndexErrorCode ENTRY_NAME_EMPTY = new RemoteZipIndexErrorCode("ENTRY_NAME_EMPTY", 11);
    public static final RemoteZipIndexErrorCode ENTRY_NAME_CONTAINS_NUL = new RemoteZipIndexErrorCode("ENTRY_NAME_CONTAINS_NUL", 12);
    public static final RemoteZipIndexErrorCode ENTRY_NAME_CONTAINS_BACKSLASH = new RemoteZipIndexErrorCode("ENTRY_NAME_CONTAINS_BACKSLASH", 13);
    public static final RemoteZipIndexErrorCode ABSOLUTE_ENTRY_PATH = new RemoteZipIndexErrorCode("ABSOLUTE_ENTRY_PATH", 14);
    public static final RemoteZipIndexErrorCode ENTRY_PREFIX_INVALID = new RemoteZipIndexErrorCode("ENTRY_PREFIX_INVALID", 15);
    public static final RemoteZipIndexErrorCode EMPTY_PATH_SEGMENT = new RemoteZipIndexErrorCode("EMPTY_PATH_SEGMENT", 16);
    public static final RemoteZipIndexErrorCode DOT_PATH_SEGMENT = new RemoteZipIndexErrorCode("DOT_PATH_SEGMENT", 17);
    public static final RemoteZipIndexErrorCode PATH_TRAVERSAL = new RemoteZipIndexErrorCode("PATH_TRAVERSAL", 18);
    public static final RemoteZipIndexErrorCode DUPLICATE_ENTRY = new RemoteZipIndexErrorCode("DUPLICATE_ENTRY", 19);
    public static final RemoteZipIndexErrorCode CASE_COLLISION = new RemoteZipIndexErrorCode("CASE_COLLISION", 20);
    public static final RemoteZipIndexErrorCode FILE_DIRECTORY_COLLISION = new RemoteZipIndexErrorCode("FILE_DIRECTORY_COLLISION", 21);
    public static final RemoteZipIndexErrorCode ENCRYPTED_ENTRY = new RemoteZipIndexErrorCode("ENCRYPTED_ENTRY", 22);
    public static final RemoteZipIndexErrorCode UNSUPPORTED_ENTRY_FLAGS = new RemoteZipIndexErrorCode("UNSUPPORTED_ENTRY_FLAGS", 23);
    public static final RemoteZipIndexErrorCode SYMLINK_ENTRY = new RemoteZipIndexErrorCode("SYMLINK_ENTRY", 24);
    public static final RemoteZipIndexErrorCode UNSUPPORTED_ENTRY_TYPE = new RemoteZipIndexErrorCode("UNSUPPORTED_ENTRY_TYPE", 25);
    public static final RemoteZipIndexErrorCode ENTRY_TYPE_MISMATCH = new RemoteZipIndexErrorCode("ENTRY_TYPE_MISMATCH", 26);
    public static final RemoteZipIndexErrorCode UNSUPPORTED_COMPRESSION_METHOD = new RemoteZipIndexErrorCode("UNSUPPORTED_COMPRESSION_METHOD", 27);
    public static final RemoteZipIndexErrorCode ENTRY_METADATA_INCONSISTENT = new RemoteZipIndexErrorCode("ENTRY_METADATA_INCONSISTENT", 28);
    public static final RemoteZipIndexErrorCode DIRECTORY_HAS_DATA = new RemoteZipIndexErrorCode("DIRECTORY_HAS_DATA", 29);
    public static final RemoteZipIndexErrorCode ENTRY_SIZE_LIMIT_EXCEEDED = new RemoteZipIndexErrorCode("ENTRY_SIZE_LIMIT_EXCEEDED", 30);
    public static final RemoteZipIndexErrorCode TOTAL_SIZE_LIMIT_EXCEEDED = new RemoteZipIndexErrorCode("TOTAL_SIZE_LIMIT_EXCEEDED", 31);
    public static final RemoteZipIndexErrorCode COMPRESSION_RATIO_LIMIT_EXCEEDED = new RemoteZipIndexErrorCode("COMPRESSION_RATIO_LIMIT_EXCEEDED", 32);
    public static final RemoteZipIndexErrorCode LOCAL_HEADER_BOUNDS_INVALID = new RemoteZipIndexErrorCode("LOCAL_HEADER_BOUNDS_INVALID", 33);

    private static final /* synthetic */ RemoteZipIndexErrorCode[] $values() {
        return new RemoteZipIndexErrorCode[]{TAIL_IS_NOT_ARCHIVE_SUFFIX, EOCD_NOT_FOUND, MULTI_DISK_ARCHIVE_UNSUPPORTED, ZIP64_UNSUPPORTED, EMPTY_ARCHIVE, ENTRY_COUNT_LIMIT_EXCEEDED, CENTRAL_DIRECTORY_SIZE_LIMIT_EXCEEDED, CENTRAL_DIRECTORY_BOUNDS_INVALID, CENTRAL_DIRECTORY_LENGTH_MISMATCH, MALFORMED_CENTRAL_DIRECTORY, ENTRY_NAME_INVALID_ENCODING, ENTRY_NAME_EMPTY, ENTRY_NAME_CONTAINS_NUL, ENTRY_NAME_CONTAINS_BACKSLASH, ABSOLUTE_ENTRY_PATH, ENTRY_PREFIX_INVALID, EMPTY_PATH_SEGMENT, DOT_PATH_SEGMENT, PATH_TRAVERSAL, DUPLICATE_ENTRY, CASE_COLLISION, FILE_DIRECTORY_COLLISION, ENCRYPTED_ENTRY, UNSUPPORTED_ENTRY_FLAGS, SYMLINK_ENTRY, UNSUPPORTED_ENTRY_TYPE, ENTRY_TYPE_MISMATCH, UNSUPPORTED_COMPRESSION_METHOD, ENTRY_METADATA_INCONSISTENT, DIRECTORY_HAS_DATA, ENTRY_SIZE_LIMIT_EXCEEDED, TOTAL_SIZE_LIMIT_EXCEEDED, COMPRESSION_RATIO_LIMIT_EXCEEDED, LOCAL_HEADER_BOUNDS_INVALID};
    }

    public static EnumEntries<RemoteZipIndexErrorCode> getEntries() {
        return $ENTRIES;
    }

    public static RemoteZipIndexErrorCode valueOf(String str) {
        return (RemoteZipIndexErrorCode) Enum.valueOf(RemoteZipIndexErrorCode.class, str);
    }

    public static RemoteZipIndexErrorCode[] values() {
        return (RemoteZipIndexErrorCode[]) $VALUES.clone();
    }

    private RemoteZipIndexErrorCode(String str, int i) {
    }

    static {
        RemoteZipIndexErrorCode[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
