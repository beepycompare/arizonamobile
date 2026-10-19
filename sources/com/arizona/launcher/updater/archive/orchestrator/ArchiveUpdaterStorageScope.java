package com.arizona.launcher.updater.archive.orchestrator;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ArchiveUpdaterStorageRoots.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveUpdaterStorageScope;", "", "<init>", "(Ljava/lang/String;I)V", "BASE", "VICE", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveUpdaterStorageScope {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ArchiveUpdaterStorageScope[] $VALUES;
    public static final ArchiveUpdaterStorageScope BASE = new ArchiveUpdaterStorageScope("BASE", 0);
    public static final ArchiveUpdaterStorageScope VICE = new ArchiveUpdaterStorageScope("VICE", 1);

    private static final /* synthetic */ ArchiveUpdaterStorageScope[] $values() {
        return new ArchiveUpdaterStorageScope[]{BASE, VICE};
    }

    public static EnumEntries<ArchiveUpdaterStorageScope> getEntries() {
        return $ENTRIES;
    }

    public static ArchiveUpdaterStorageScope valueOf(String str) {
        return (ArchiveUpdaterStorageScope) Enum.valueOf(ArchiveUpdaterStorageScope.class, str);
    }

    public static ArchiveUpdaterStorageScope[] values() {
        return (ArchiveUpdaterStorageScope[]) $VALUES.clone();
    }

    private ArchiveUpdaterStorageScope(String str, int i) {
    }

    static {
        ArchiveUpdaterStorageScope[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
