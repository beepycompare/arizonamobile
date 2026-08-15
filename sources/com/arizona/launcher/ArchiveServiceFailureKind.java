package com.arizona.launcher;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ArchiveUpdateServiceFlow.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/arizona/launcher/ArchiveServiceFailureKind;", "", "<init>", "(Ljava/lang/String;I)V", "CONNECTION", "CORRUPTED", "INSUFFICIENT_STORAGE", "FOREGROUND_UNAVAILABLE", "RECOVERY_BLOCKED", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveServiceFailureKind {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ArchiveServiceFailureKind[] $VALUES;
    public static final ArchiveServiceFailureKind CONNECTION = new ArchiveServiceFailureKind("CONNECTION", 0);
    public static final ArchiveServiceFailureKind CORRUPTED = new ArchiveServiceFailureKind("CORRUPTED", 1);
    public static final ArchiveServiceFailureKind INSUFFICIENT_STORAGE = new ArchiveServiceFailureKind("INSUFFICIENT_STORAGE", 2);
    public static final ArchiveServiceFailureKind FOREGROUND_UNAVAILABLE = new ArchiveServiceFailureKind("FOREGROUND_UNAVAILABLE", 3);
    public static final ArchiveServiceFailureKind RECOVERY_BLOCKED = new ArchiveServiceFailureKind("RECOVERY_BLOCKED", 4);

    private static final /* synthetic */ ArchiveServiceFailureKind[] $values() {
        return new ArchiveServiceFailureKind[]{CONNECTION, CORRUPTED, INSUFFICIENT_STORAGE, FOREGROUND_UNAVAILABLE, RECOVERY_BLOCKED};
    }

    public static EnumEntries<ArchiveServiceFailureKind> getEntries() {
        return $ENTRIES;
    }

    public static ArchiveServiceFailureKind valueOf(String str) {
        return (ArchiveServiceFailureKind) Enum.valueOf(ArchiveServiceFailureKind.class, str);
    }

    public static ArchiveServiceFailureKind[] values() {
        return (ArchiveServiceFailureKind[]) $VALUES.clone();
    }

    private ArchiveServiceFailureKind(String str, int i) {
    }

    static {
        ArchiveServiceFailureKind[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
