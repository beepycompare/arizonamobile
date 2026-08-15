package com.arizona.launcher.updater.archive.orchestrator;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ArchiveStartupGuard.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveStartupGuard;", "", "<init>", "(Ljava/lang/String;I)V", "NONE", "RECOVERY_REQUIRED", "CORRUPT_STATE", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveStartupGuard {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ArchiveStartupGuard[] $VALUES;
    public static final ArchiveStartupGuard NONE = new ArchiveStartupGuard("NONE", 0);
    public static final ArchiveStartupGuard RECOVERY_REQUIRED = new ArchiveStartupGuard("RECOVERY_REQUIRED", 1);
    public static final ArchiveStartupGuard CORRUPT_STATE = new ArchiveStartupGuard("CORRUPT_STATE", 2);

    private static final /* synthetic */ ArchiveStartupGuard[] $values() {
        return new ArchiveStartupGuard[]{NONE, RECOVERY_REQUIRED, CORRUPT_STATE};
    }

    public static EnumEntries<ArchiveStartupGuard> getEntries() {
        return $ENTRIES;
    }

    public static ArchiveStartupGuard valueOf(String str) {
        return (ArchiveStartupGuard) Enum.valueOf(ArchiveStartupGuard.class, str);
    }

    public static ArchiveStartupGuard[] values() {
        return (ArchiveStartupGuard[]) $VALUES.clone();
    }

    private ArchiveStartupGuard(String str, int i) {
    }

    static {
        ArchiveStartupGuard[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
