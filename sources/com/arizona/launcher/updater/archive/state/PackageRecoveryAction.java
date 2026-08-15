package com.arizona.launcher.updater.archive.state;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: PackageRecoveryAction.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/arizona/launcher/updater/archive/state/PackageRecoveryAction;", "", "<init>", "(Ljava/lang/String;I)V", "SKIP_COMPLETE", "START_DOWNLOAD", "CONTINUE_DOWNLOAD", "REVERIFY_ARCHIVE", "DISCARD_AND_REEXTRACT", "BEGIN_COMMIT", "REAPPLY_DIRTY_COMMIT", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PackageRecoveryAction {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ PackageRecoveryAction[] $VALUES;
    public static final PackageRecoveryAction SKIP_COMPLETE = new PackageRecoveryAction("SKIP_COMPLETE", 0);
    public static final PackageRecoveryAction START_DOWNLOAD = new PackageRecoveryAction("START_DOWNLOAD", 1);
    public static final PackageRecoveryAction CONTINUE_DOWNLOAD = new PackageRecoveryAction("CONTINUE_DOWNLOAD", 2);
    public static final PackageRecoveryAction REVERIFY_ARCHIVE = new PackageRecoveryAction("REVERIFY_ARCHIVE", 3);
    public static final PackageRecoveryAction DISCARD_AND_REEXTRACT = new PackageRecoveryAction("DISCARD_AND_REEXTRACT", 4);
    public static final PackageRecoveryAction BEGIN_COMMIT = new PackageRecoveryAction("BEGIN_COMMIT", 5);
    public static final PackageRecoveryAction REAPPLY_DIRTY_COMMIT = new PackageRecoveryAction("REAPPLY_DIRTY_COMMIT", 6);

    private static final /* synthetic */ PackageRecoveryAction[] $values() {
        return new PackageRecoveryAction[]{SKIP_COMPLETE, START_DOWNLOAD, CONTINUE_DOWNLOAD, REVERIFY_ARCHIVE, DISCARD_AND_REEXTRACT, BEGIN_COMMIT, REAPPLY_DIRTY_COMMIT};
    }

    public static EnumEntries<PackageRecoveryAction> getEntries() {
        return $ENTRIES;
    }

    public static PackageRecoveryAction valueOf(String str) {
        return (PackageRecoveryAction) Enum.valueOf(PackageRecoveryAction.class, str);
    }

    public static PackageRecoveryAction[] values() {
        return (PackageRecoveryAction[]) $VALUES.clone();
    }

    private PackageRecoveryAction(String str, int i) {
    }

    static {
        PackageRecoveryAction[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
