package com.arizona.launcher.updater.apk;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: LauncherUpdateController.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/arizona/launcher/updater/apk/LauncherUpdatePhase;", "", "<init>", "(Ljava/lang/String;I)V", "METADATA_CHECK", "APK_DOWNLOAD", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class LauncherUpdatePhase {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ LauncherUpdatePhase[] $VALUES;
    public static final LauncherUpdatePhase METADATA_CHECK = new LauncherUpdatePhase("METADATA_CHECK", 0);
    public static final LauncherUpdatePhase APK_DOWNLOAD = new LauncherUpdatePhase("APK_DOWNLOAD", 1);

    private static final /* synthetic */ LauncherUpdatePhase[] $values() {
        return new LauncherUpdatePhase[]{METADATA_CHECK, APK_DOWNLOAD};
    }

    public static EnumEntries<LauncherUpdatePhase> getEntries() {
        return $ENTRIES;
    }

    public static LauncherUpdatePhase valueOf(String str) {
        return (LauncherUpdatePhase) Enum.valueOf(LauncherUpdatePhase.class, str);
    }

    public static LauncherUpdatePhase[] values() {
        return (LauncherUpdatePhase[]) $VALUES.clone();
    }

    private LauncherUpdatePhase(String str, int i) {
    }

    static {
        LauncherUpdatePhase[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
