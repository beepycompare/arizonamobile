package com.arizona.launcher.updater.archive.planner;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ArchiveUpdatePlan.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/arizona/launcher/updater/archive/planner/ArchivePlanType;", "", "<init>", "(Ljava/lang/String;I)V", "SKIP", "FULL_BOOTSTRAP", "FULL_UPDATE", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchivePlanType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ArchivePlanType[] $VALUES;
    public static final ArchivePlanType SKIP = new ArchivePlanType("SKIP", 0);
    public static final ArchivePlanType FULL_BOOTSTRAP = new ArchivePlanType("FULL_BOOTSTRAP", 1);
    public static final ArchivePlanType FULL_UPDATE = new ArchivePlanType("FULL_UPDATE", 2);

    private static final /* synthetic */ ArchivePlanType[] $values() {
        return new ArchivePlanType[]{SKIP, FULL_BOOTSTRAP, FULL_UPDATE};
    }

    public static EnumEntries<ArchivePlanType> getEntries() {
        return $ENTRIES;
    }

    public static ArchivePlanType valueOf(String str) {
        return (ArchivePlanType) Enum.valueOf(ArchivePlanType.class, str);
    }

    public static ArchivePlanType[] values() {
        return (ArchivePlanType[]) $VALUES.clone();
    }

    private ArchivePlanType(String str, int i) {
    }

    static {
        ArchivePlanType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
