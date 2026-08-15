package com.arizona.launcher;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: UpdateOperationCoordinator.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/arizona/launcher/UpdateOperationKind;", "", "<init>", "(Ljava/lang/String;I)V", "CHECK_UPDATE", "ARCHIVE_UPDATE", "FILE_CHECK", "LAUNCHER_CHECK", "LAUNCHER_APK", "CHECK_AND_DOWNLOAD", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class UpdateOperationKind {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ UpdateOperationKind[] $VALUES;
    public static final UpdateOperationKind CHECK_UPDATE = new UpdateOperationKind("CHECK_UPDATE", 0);
    public static final UpdateOperationKind ARCHIVE_UPDATE = new UpdateOperationKind("ARCHIVE_UPDATE", 1);
    public static final UpdateOperationKind FILE_CHECK = new UpdateOperationKind("FILE_CHECK", 2);
    public static final UpdateOperationKind LAUNCHER_CHECK = new UpdateOperationKind("LAUNCHER_CHECK", 3);
    public static final UpdateOperationKind LAUNCHER_APK = new UpdateOperationKind("LAUNCHER_APK", 4);
    public static final UpdateOperationKind CHECK_AND_DOWNLOAD = new UpdateOperationKind("CHECK_AND_DOWNLOAD", 5);

    private static final /* synthetic */ UpdateOperationKind[] $values() {
        return new UpdateOperationKind[]{CHECK_UPDATE, ARCHIVE_UPDATE, FILE_CHECK, LAUNCHER_CHECK, LAUNCHER_APK, CHECK_AND_DOWNLOAD};
    }

    public static EnumEntries<UpdateOperationKind> getEntries() {
        return $ENTRIES;
    }

    public static UpdateOperationKind valueOf(String str) {
        return (UpdateOperationKind) Enum.valueOf(UpdateOperationKind.class, str);
    }

    public static UpdateOperationKind[] values() {
        return (UpdateOperationKind[]) $VALUES.clone();
    }

    private UpdateOperationKind(String str, int i) {
    }

    static {
        UpdateOperationKind[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
