package com.arizona.launcher.updater.archive.orchestrator;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ArchivePackageUpdater.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0019\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdaterErrorCode;", "", "<init>", "(Ljava/lang/String;I)V", "INVALID_ENVIRONMENT", "STATE_MISSING", "STATE_CORRUPT", "STATE_INVALID", "STATE_MANIFEST_MISMATCH", "STATE_PACKAGE_MISSING", "STATE_FILES_MISSING", "ENTRY_METADATA_MISSING", "OWNERSHIP_INVALID", "PACKAGE_URL_INVALID", "DOWNLOAD_FAILED", "ARCHIVE_VERIFICATION_FAILED", "STAGING_RESET_FAILED", "EXTRACTION_FAILED", "ENTRY_MANIFEST_MISMATCH", "INSTALLED_SIZE_MISMATCH", "INSUFFICIENT_STORAGE", "COMMIT_FAILED", "RETIREMENT_FAILED", "RETIREMENT_CLEANUP_FAILED", "ARTIFACT_CLEANUP_FAILED", "INSTALL_NOT_READY", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveUpdaterErrorCode {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ArchiveUpdaterErrorCode[] $VALUES;
    public static final ArchiveUpdaterErrorCode INVALID_ENVIRONMENT = new ArchiveUpdaterErrorCode("INVALID_ENVIRONMENT", 0);
    public static final ArchiveUpdaterErrorCode STATE_MISSING = new ArchiveUpdaterErrorCode("STATE_MISSING", 1);
    public static final ArchiveUpdaterErrorCode STATE_CORRUPT = new ArchiveUpdaterErrorCode("STATE_CORRUPT", 2);
    public static final ArchiveUpdaterErrorCode STATE_INVALID = new ArchiveUpdaterErrorCode("STATE_INVALID", 3);
    public static final ArchiveUpdaterErrorCode STATE_MANIFEST_MISMATCH = new ArchiveUpdaterErrorCode("STATE_MANIFEST_MISMATCH", 4);
    public static final ArchiveUpdaterErrorCode STATE_PACKAGE_MISSING = new ArchiveUpdaterErrorCode("STATE_PACKAGE_MISSING", 5);
    public static final ArchiveUpdaterErrorCode STATE_FILES_MISSING = new ArchiveUpdaterErrorCode("STATE_FILES_MISSING", 6);
    public static final ArchiveUpdaterErrorCode ENTRY_METADATA_MISSING = new ArchiveUpdaterErrorCode("ENTRY_METADATA_MISSING", 7);
    public static final ArchiveUpdaterErrorCode OWNERSHIP_INVALID = new ArchiveUpdaterErrorCode("OWNERSHIP_INVALID", 8);
    public static final ArchiveUpdaterErrorCode PACKAGE_URL_INVALID = new ArchiveUpdaterErrorCode("PACKAGE_URL_INVALID", 9);
    public static final ArchiveUpdaterErrorCode DOWNLOAD_FAILED = new ArchiveUpdaterErrorCode("DOWNLOAD_FAILED", 10);
    public static final ArchiveUpdaterErrorCode ARCHIVE_VERIFICATION_FAILED = new ArchiveUpdaterErrorCode("ARCHIVE_VERIFICATION_FAILED", 11);
    public static final ArchiveUpdaterErrorCode STAGING_RESET_FAILED = new ArchiveUpdaterErrorCode("STAGING_RESET_FAILED", 12);
    public static final ArchiveUpdaterErrorCode EXTRACTION_FAILED = new ArchiveUpdaterErrorCode("EXTRACTION_FAILED", 13);
    public static final ArchiveUpdaterErrorCode ENTRY_MANIFEST_MISMATCH = new ArchiveUpdaterErrorCode("ENTRY_MANIFEST_MISMATCH", 14);
    public static final ArchiveUpdaterErrorCode INSTALLED_SIZE_MISMATCH = new ArchiveUpdaterErrorCode("INSTALLED_SIZE_MISMATCH", 15);
    public static final ArchiveUpdaterErrorCode INSUFFICIENT_STORAGE = new ArchiveUpdaterErrorCode("INSUFFICIENT_STORAGE", 16);
    public static final ArchiveUpdaterErrorCode COMMIT_FAILED = new ArchiveUpdaterErrorCode("COMMIT_FAILED", 17);
    public static final ArchiveUpdaterErrorCode RETIREMENT_FAILED = new ArchiveUpdaterErrorCode("RETIREMENT_FAILED", 18);
    public static final ArchiveUpdaterErrorCode RETIREMENT_CLEANUP_FAILED = new ArchiveUpdaterErrorCode("RETIREMENT_CLEANUP_FAILED", 19);
    public static final ArchiveUpdaterErrorCode ARTIFACT_CLEANUP_FAILED = new ArchiveUpdaterErrorCode("ARTIFACT_CLEANUP_FAILED", 20);
    public static final ArchiveUpdaterErrorCode INSTALL_NOT_READY = new ArchiveUpdaterErrorCode("INSTALL_NOT_READY", 21);

    private static final /* synthetic */ ArchiveUpdaterErrorCode[] $values() {
        return new ArchiveUpdaterErrorCode[]{INVALID_ENVIRONMENT, STATE_MISSING, STATE_CORRUPT, STATE_INVALID, STATE_MANIFEST_MISMATCH, STATE_PACKAGE_MISSING, STATE_FILES_MISSING, ENTRY_METADATA_MISSING, OWNERSHIP_INVALID, PACKAGE_URL_INVALID, DOWNLOAD_FAILED, ARCHIVE_VERIFICATION_FAILED, STAGING_RESET_FAILED, EXTRACTION_FAILED, ENTRY_MANIFEST_MISMATCH, INSTALLED_SIZE_MISMATCH, INSUFFICIENT_STORAGE, COMMIT_FAILED, RETIREMENT_FAILED, RETIREMENT_CLEANUP_FAILED, ARTIFACT_CLEANUP_FAILED, INSTALL_NOT_READY};
    }

    public static EnumEntries<ArchiveUpdaterErrorCode> getEntries() {
        return $ENTRIES;
    }

    public static ArchiveUpdaterErrorCode valueOf(String str) {
        return (ArchiveUpdaterErrorCode) Enum.valueOf(ArchiveUpdaterErrorCode.class, str);
    }

    public static ArchiveUpdaterErrorCode[] values() {
        return (ArchiveUpdaterErrorCode[]) $VALUES.clone();
    }

    private ArchiveUpdaterErrorCode(String str, int i) {
    }

    static {
        ArchiveUpdaterErrorCode[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
