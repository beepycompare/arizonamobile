package com.arizona.launcher.updater.archive.orchestrator;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ArchiveStorageSpaceChecker.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveStorageSpaceCheckResult;", "", "<init>", "(Ljava/lang/String;I)V", "ENOUGH", "INSUFFICIENT", "UNAVAILABLE", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveStorageSpaceCheckResult {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ArchiveStorageSpaceCheckResult[] $VALUES;
    public static final ArchiveStorageSpaceCheckResult ENOUGH = new ArchiveStorageSpaceCheckResult("ENOUGH", 0);
    public static final ArchiveStorageSpaceCheckResult INSUFFICIENT = new ArchiveStorageSpaceCheckResult("INSUFFICIENT", 1);
    public static final ArchiveStorageSpaceCheckResult UNAVAILABLE = new ArchiveStorageSpaceCheckResult("UNAVAILABLE", 2);

    private static final /* synthetic */ ArchiveStorageSpaceCheckResult[] $values() {
        return new ArchiveStorageSpaceCheckResult[]{ENOUGH, INSUFFICIENT, UNAVAILABLE};
    }

    public static EnumEntries<ArchiveStorageSpaceCheckResult> getEntries() {
        return $ENTRIES;
    }

    public static ArchiveStorageSpaceCheckResult valueOf(String str) {
        return (ArchiveStorageSpaceCheckResult) Enum.valueOf(ArchiveStorageSpaceCheckResult.class, str);
    }

    public static ArchiveStorageSpaceCheckResult[] values() {
        return (ArchiveStorageSpaceCheckResult[]) $VALUES.clone();
    }

    private ArchiveStorageSpaceCheckResult(String str, int i) {
    }

    static {
        ArchiveStorageSpaceCheckResult[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
