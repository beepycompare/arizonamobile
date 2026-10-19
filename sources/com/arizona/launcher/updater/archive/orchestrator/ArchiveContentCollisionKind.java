package com.arizona.launcher.updater.archive.orchestrator;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ArchiveContentCollisionGuard.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/arizona/launcher/updater/archive/orchestrator/ArchiveContentCollisionKind;", "", "<init>", "(Ljava/lang/String;I)V", "EXACT_PATH", "FILE_DESCENDANT", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveContentCollisionKind {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ArchiveContentCollisionKind[] $VALUES;
    public static final ArchiveContentCollisionKind EXACT_PATH = new ArchiveContentCollisionKind("EXACT_PATH", 0);
    public static final ArchiveContentCollisionKind FILE_DESCENDANT = new ArchiveContentCollisionKind("FILE_DESCENDANT", 1);

    private static final /* synthetic */ ArchiveContentCollisionKind[] $values() {
        return new ArchiveContentCollisionKind[]{EXACT_PATH, FILE_DESCENDANT};
    }

    public static EnumEntries<ArchiveContentCollisionKind> getEntries() {
        return $ENTRIES;
    }

    public static ArchiveContentCollisionKind valueOf(String str) {
        return (ArchiveContentCollisionKind) Enum.valueOf(ArchiveContentCollisionKind.class, str);
    }

    public static ArchiveContentCollisionKind[] values() {
        return (ArchiveContentCollisionKind[]) $VALUES.clone();
    }

    private ArchiveContentCollisionKind(String str, int i) {
    }

    static {
        ArchiveContentCollisionKind[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
