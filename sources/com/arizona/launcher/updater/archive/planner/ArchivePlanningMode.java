package com.arizona.launcher.updater.archive.planner;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ArchiveUpdatePlan.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/arizona/launcher/updater/archive/planner/ArchivePlanningMode;", "", "<init>", "(Ljava/lang/String;I)V", "NORMAL", "REPAIR", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchivePlanningMode {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ArchivePlanningMode[] $VALUES;
    public static final ArchivePlanningMode NORMAL = new ArchivePlanningMode("NORMAL", 0);
    public static final ArchivePlanningMode REPAIR = new ArchivePlanningMode("REPAIR", 1);

    private static final /* synthetic */ ArchivePlanningMode[] $values() {
        return new ArchivePlanningMode[]{NORMAL, REPAIR};
    }

    public static EnumEntries<ArchivePlanningMode> getEntries() {
        return $ENTRIES;
    }

    public static ArchivePlanningMode valueOf(String str) {
        return (ArchivePlanningMode) Enum.valueOf(ArchivePlanningMode.class, str);
    }

    public static ArchivePlanningMode[] values() {
        return (ArchivePlanningMode[]) $VALUES.clone();
    }

    private ArchivePlanningMode(String str, int i) {
    }

    static {
        ArchivePlanningMode[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
