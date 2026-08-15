package com.arizona.launcher.updater.archive.planner;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ArchiveUpdatePlan.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/arizona/launcher/updater/archive/planner/ArchivePlanReason;", "", "<init>", "(Ljava/lang/String;I)V", "UP_TO_DATE", "NO_LOCAL_STATE", "BOOTSTRAP_INCOMPLETE", "REPAIR_REQUESTED", "PAYLOAD_REPAIR", "LOCAL_SCHEMA_CHANGED", "GPU_PACKAGE_SET_CHANGED", "MANIFEST_VERSION_CHANGED", "PACKAGE_SET_CHANGED", "PACKAGE_IDENTITY_CHANGED", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchivePlanReason {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ArchivePlanReason[] $VALUES;
    public static final ArchivePlanReason UP_TO_DATE = new ArchivePlanReason("UP_TO_DATE", 0);
    public static final ArchivePlanReason NO_LOCAL_STATE = new ArchivePlanReason("NO_LOCAL_STATE", 1);
    public static final ArchivePlanReason BOOTSTRAP_INCOMPLETE = new ArchivePlanReason("BOOTSTRAP_INCOMPLETE", 2);
    public static final ArchivePlanReason REPAIR_REQUESTED = new ArchivePlanReason("REPAIR_REQUESTED", 3);
    public static final ArchivePlanReason PAYLOAD_REPAIR = new ArchivePlanReason("PAYLOAD_REPAIR", 4);
    public static final ArchivePlanReason LOCAL_SCHEMA_CHANGED = new ArchivePlanReason("LOCAL_SCHEMA_CHANGED", 5);
    public static final ArchivePlanReason GPU_PACKAGE_SET_CHANGED = new ArchivePlanReason("GPU_PACKAGE_SET_CHANGED", 6);
    public static final ArchivePlanReason MANIFEST_VERSION_CHANGED = new ArchivePlanReason("MANIFEST_VERSION_CHANGED", 7);
    public static final ArchivePlanReason PACKAGE_SET_CHANGED = new ArchivePlanReason("PACKAGE_SET_CHANGED", 8);
    public static final ArchivePlanReason PACKAGE_IDENTITY_CHANGED = new ArchivePlanReason("PACKAGE_IDENTITY_CHANGED", 9);

    private static final /* synthetic */ ArchivePlanReason[] $values() {
        return new ArchivePlanReason[]{UP_TO_DATE, NO_LOCAL_STATE, BOOTSTRAP_INCOMPLETE, REPAIR_REQUESTED, PAYLOAD_REPAIR, LOCAL_SCHEMA_CHANGED, GPU_PACKAGE_SET_CHANGED, MANIFEST_VERSION_CHANGED, PACKAGE_SET_CHANGED, PACKAGE_IDENTITY_CHANGED};
    }

    public static EnumEntries<ArchivePlanReason> getEntries() {
        return $ENTRIES;
    }

    public static ArchivePlanReason valueOf(String str) {
        return (ArchivePlanReason) Enum.valueOf(ArchivePlanReason.class, str);
    }

    public static ArchivePlanReason[] values() {
        return (ArchivePlanReason[]) $VALUES.clone();
    }

    private ArchivePlanReason(String str, int i) {
    }

    static {
        ArchivePlanReason[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
