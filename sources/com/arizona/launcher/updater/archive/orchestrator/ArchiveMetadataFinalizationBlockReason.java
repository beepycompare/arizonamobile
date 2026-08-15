package com.arizona.launcher.updater.archive.orchestrator;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ArchiveStateMaintenance.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveMetadataFinalizationBlockReason;", "", "<init>", "(Ljava/lang/String;I)V", "STATE_MISSING", "PAYLOAD_NOT_COMMITTED", "PUBLISHED_METADATA_MISSING", "PUBLISHED_PAYLOAD_MISMATCH", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveMetadataFinalizationBlockReason {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ArchiveMetadataFinalizationBlockReason[] $VALUES;
    public static final ArchiveMetadataFinalizationBlockReason STATE_MISSING = new ArchiveMetadataFinalizationBlockReason("STATE_MISSING", 0);
    public static final ArchiveMetadataFinalizationBlockReason PAYLOAD_NOT_COMMITTED = new ArchiveMetadataFinalizationBlockReason("PAYLOAD_NOT_COMMITTED", 1);
    public static final ArchiveMetadataFinalizationBlockReason PUBLISHED_METADATA_MISSING = new ArchiveMetadataFinalizationBlockReason("PUBLISHED_METADATA_MISSING", 2);
    public static final ArchiveMetadataFinalizationBlockReason PUBLISHED_PAYLOAD_MISMATCH = new ArchiveMetadataFinalizationBlockReason("PUBLISHED_PAYLOAD_MISMATCH", 3);

    private static final /* synthetic */ ArchiveMetadataFinalizationBlockReason[] $values() {
        return new ArchiveMetadataFinalizationBlockReason[]{STATE_MISSING, PAYLOAD_NOT_COMMITTED, PUBLISHED_METADATA_MISSING, PUBLISHED_PAYLOAD_MISMATCH};
    }

    public static EnumEntries<ArchiveMetadataFinalizationBlockReason> getEntries() {
        return $ENTRIES;
    }

    public static ArchiveMetadataFinalizationBlockReason valueOf(String str) {
        return (ArchiveMetadataFinalizationBlockReason) Enum.valueOf(ArchiveMetadataFinalizationBlockReason.class, str);
    }

    public static ArchiveMetadataFinalizationBlockReason[] values() {
        return (ArchiveMetadataFinalizationBlockReason[]) $VALUES.clone();
    }

    private ArchiveMetadataFinalizationBlockReason(String str, int i) {
    }

    static {
        ArchiveMetadataFinalizationBlockReason[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
