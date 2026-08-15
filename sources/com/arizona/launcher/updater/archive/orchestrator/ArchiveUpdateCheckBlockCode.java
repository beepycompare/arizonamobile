package com.arizona.launcher.updater.archive.orchestrator;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ArchiveUpdateCheckCoordinator.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\r\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdateCheckBlockCode;", "", "<init>", "(Ljava/lang/String;I)V", "STATE_IO_FAILED", "STATE_CORRUPT", "STATE_INVALID", "ARCHIVE_MANIFEST_INVALID", "ARCHIVE_MANIFEST_REQUIRED", "ARCHIVE_ENTRY_METADATA_REQUIRED", "ARCHIVE_INDEX_UNAVAILABLE", "ARCHIVE_REPRESENTATION_CHANGED", "INCOMPLETE_MANIFEST_MISMATCH", "GAME_ROOT_UNAVAILABLE", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveUpdateCheckBlockCode {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ArchiveUpdateCheckBlockCode[] $VALUES;
    public static final ArchiveUpdateCheckBlockCode STATE_IO_FAILED = new ArchiveUpdateCheckBlockCode("STATE_IO_FAILED", 0);
    public static final ArchiveUpdateCheckBlockCode STATE_CORRUPT = new ArchiveUpdateCheckBlockCode("STATE_CORRUPT", 1);
    public static final ArchiveUpdateCheckBlockCode STATE_INVALID = new ArchiveUpdateCheckBlockCode("STATE_INVALID", 2);
    public static final ArchiveUpdateCheckBlockCode ARCHIVE_MANIFEST_INVALID = new ArchiveUpdateCheckBlockCode("ARCHIVE_MANIFEST_INVALID", 3);
    public static final ArchiveUpdateCheckBlockCode ARCHIVE_MANIFEST_REQUIRED = new ArchiveUpdateCheckBlockCode("ARCHIVE_MANIFEST_REQUIRED", 4);
    public static final ArchiveUpdateCheckBlockCode ARCHIVE_ENTRY_METADATA_REQUIRED = new ArchiveUpdateCheckBlockCode("ARCHIVE_ENTRY_METADATA_REQUIRED", 5);
    public static final ArchiveUpdateCheckBlockCode ARCHIVE_INDEX_UNAVAILABLE = new ArchiveUpdateCheckBlockCode("ARCHIVE_INDEX_UNAVAILABLE", 6);
    public static final ArchiveUpdateCheckBlockCode ARCHIVE_REPRESENTATION_CHANGED = new ArchiveUpdateCheckBlockCode("ARCHIVE_REPRESENTATION_CHANGED", 7);
    public static final ArchiveUpdateCheckBlockCode INCOMPLETE_MANIFEST_MISMATCH = new ArchiveUpdateCheckBlockCode("INCOMPLETE_MANIFEST_MISMATCH", 8);
    public static final ArchiveUpdateCheckBlockCode GAME_ROOT_UNAVAILABLE = new ArchiveUpdateCheckBlockCode("GAME_ROOT_UNAVAILABLE", 9);

    private static final /* synthetic */ ArchiveUpdateCheckBlockCode[] $values() {
        return new ArchiveUpdateCheckBlockCode[]{STATE_IO_FAILED, STATE_CORRUPT, STATE_INVALID, ARCHIVE_MANIFEST_INVALID, ARCHIVE_MANIFEST_REQUIRED, ARCHIVE_ENTRY_METADATA_REQUIRED, ARCHIVE_INDEX_UNAVAILABLE, ARCHIVE_REPRESENTATION_CHANGED, INCOMPLETE_MANIFEST_MISMATCH, GAME_ROOT_UNAVAILABLE};
    }

    public static EnumEntries<ArchiveUpdateCheckBlockCode> getEntries() {
        return $ENTRIES;
    }

    public static ArchiveUpdateCheckBlockCode valueOf(String str) {
        return (ArchiveUpdateCheckBlockCode) Enum.valueOf(ArchiveUpdateCheckBlockCode.class, str);
    }

    public static ArchiveUpdateCheckBlockCode[] values() {
        return (ArchiveUpdateCheckBlockCode[]) $VALUES.clone();
    }

    private ArchiveUpdateCheckBlockCode(String str, int i) {
    }

    static {
        ArchiveUpdateCheckBlockCode[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
