package com.arizona.launcher.updater.archive.download;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ArchivePackageDownloader.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/arizona/launcher/updater/archive/download/ArchivePackageDownloadErrorCode;", "", "<init>", "(Ljava/lang/String;I)V", "INVALID_REQUEST", "DESTINATION_UNAVAILABLE", "PARTIAL_RESET_FAILED", "SAME_TASK_BUSY_EXHAUSTED", "CANCELED", "RETRY_EXHAUSTED", "NETWORK_MONITOR_FAILED", "CONTENT_LENGTH_MISMATCH", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchivePackageDownloadErrorCode {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ArchivePackageDownloadErrorCode[] $VALUES;
    public static final ArchivePackageDownloadErrorCode INVALID_REQUEST = new ArchivePackageDownloadErrorCode("INVALID_REQUEST", 0);
    public static final ArchivePackageDownloadErrorCode DESTINATION_UNAVAILABLE = new ArchivePackageDownloadErrorCode("DESTINATION_UNAVAILABLE", 1);
    public static final ArchivePackageDownloadErrorCode PARTIAL_RESET_FAILED = new ArchivePackageDownloadErrorCode("PARTIAL_RESET_FAILED", 2);
    public static final ArchivePackageDownloadErrorCode SAME_TASK_BUSY_EXHAUSTED = new ArchivePackageDownloadErrorCode("SAME_TASK_BUSY_EXHAUSTED", 3);
    public static final ArchivePackageDownloadErrorCode CANCELED = new ArchivePackageDownloadErrorCode("CANCELED", 4);
    public static final ArchivePackageDownloadErrorCode RETRY_EXHAUSTED = new ArchivePackageDownloadErrorCode("RETRY_EXHAUSTED", 5);
    public static final ArchivePackageDownloadErrorCode NETWORK_MONITOR_FAILED = new ArchivePackageDownloadErrorCode("NETWORK_MONITOR_FAILED", 6);
    public static final ArchivePackageDownloadErrorCode CONTENT_LENGTH_MISMATCH = new ArchivePackageDownloadErrorCode("CONTENT_LENGTH_MISMATCH", 7);

    private static final /* synthetic */ ArchivePackageDownloadErrorCode[] $values() {
        return new ArchivePackageDownloadErrorCode[]{INVALID_REQUEST, DESTINATION_UNAVAILABLE, PARTIAL_RESET_FAILED, SAME_TASK_BUSY_EXHAUSTED, CANCELED, RETRY_EXHAUSTED, NETWORK_MONITOR_FAILED, CONTENT_LENGTH_MISMATCH};
    }

    public static EnumEntries<ArchivePackageDownloadErrorCode> getEntries() {
        return $ENTRIES;
    }

    public static ArchivePackageDownloadErrorCode valueOf(String str) {
        return (ArchivePackageDownloadErrorCode) Enum.valueOf(ArchivePackageDownloadErrorCode.class, str);
    }

    public static ArchivePackageDownloadErrorCode[] values() {
        return (ArchivePackageDownloadErrorCode[]) $VALUES.clone();
    }

    private ArchivePackageDownloadErrorCode(String str, int i) {
    }

    static {
        ArchivePackageDownloadErrorCode[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
