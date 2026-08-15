package com.arizona.launcher.updater.archive.orchestrator;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ArchiveFlowSelector.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveFlowSelection;", "", "<init>", "(Ljava/lang/String;I)V", "USE_ARCHIVE", "BLOCK_CORRUPT_STATE", "BLOCK_ARCHIVE_MANIFEST_REQUIRED", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveFlowSelection {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ArchiveFlowSelection[] $VALUES;
    public static final ArchiveFlowSelection USE_ARCHIVE = new ArchiveFlowSelection("USE_ARCHIVE", 0);
    public static final ArchiveFlowSelection BLOCK_CORRUPT_STATE = new ArchiveFlowSelection("BLOCK_CORRUPT_STATE", 1);
    public static final ArchiveFlowSelection BLOCK_ARCHIVE_MANIFEST_REQUIRED = new ArchiveFlowSelection("BLOCK_ARCHIVE_MANIFEST_REQUIRED", 2);

    private static final /* synthetic */ ArchiveFlowSelection[] $values() {
        return new ArchiveFlowSelection[]{USE_ARCHIVE, BLOCK_CORRUPT_STATE, BLOCK_ARCHIVE_MANIFEST_REQUIRED};
    }

    public static EnumEntries<ArchiveFlowSelection> getEntries() {
        return $ENTRIES;
    }

    public static ArchiveFlowSelection valueOf(String str) {
        return (ArchiveFlowSelection) Enum.valueOf(ArchiveFlowSelection.class, str);
    }

    public static ArchiveFlowSelection[] values() {
        return (ArchiveFlowSelection[]) $VALUES.clone();
    }

    private ArchiveFlowSelection(String str, int i) {
    }

    static {
        ArchiveFlowSelection[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
