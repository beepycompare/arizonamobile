package com.arizona.launcher.updater.archive.io;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ArchiveNodeInspector.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/arizona/launcher/updater/archive/io/ArchiveFsNodeType;", "", "<init>", "(Ljava/lang/String;I)V", "ABSENT", "REGULAR_FILE", "DIRECTORY", "SYMBOLIC_LINK", "OTHER", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ArchiveFsNodeType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ArchiveFsNodeType[] $VALUES;
    public static final ArchiveFsNodeType ABSENT = new ArchiveFsNodeType("ABSENT", 0);
    public static final ArchiveFsNodeType REGULAR_FILE = new ArchiveFsNodeType("REGULAR_FILE", 1);
    public static final ArchiveFsNodeType DIRECTORY = new ArchiveFsNodeType("DIRECTORY", 2);
    public static final ArchiveFsNodeType SYMBOLIC_LINK = new ArchiveFsNodeType("SYMBOLIC_LINK", 3);
    public static final ArchiveFsNodeType OTHER = new ArchiveFsNodeType("OTHER", 4);

    private static final /* synthetic */ ArchiveFsNodeType[] $values() {
        return new ArchiveFsNodeType[]{ABSENT, REGULAR_FILE, DIRECTORY, SYMBOLIC_LINK, OTHER};
    }

    public static EnumEntries<ArchiveFsNodeType> getEntries() {
        return $ENTRIES;
    }

    public static ArchiveFsNodeType valueOf(String str) {
        return (ArchiveFsNodeType) Enum.valueOf(ArchiveFsNodeType.class, str);
    }

    public static ArchiveFsNodeType[] values() {
        return (ArchiveFsNodeType[]) $VALUES.clone();
    }

    private ArchiveFsNodeType(String str, int i) {
    }

    static {
        ArchiveFsNodeType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
