package com.arizona.launcher.updater.apk;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: LauncherUpdatePolicies.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/arizona/launcher/updater/apk/LauncherApkLocalStorageFailure;", "", "<init>", "(Ljava/lang/String;I)V", "UNAVAILABLE", "INSUFFICIENT", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class LauncherApkLocalStorageFailure {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ LauncherApkLocalStorageFailure[] $VALUES;
    public static final LauncherApkLocalStorageFailure UNAVAILABLE = new LauncherApkLocalStorageFailure("UNAVAILABLE", 0);
    public static final LauncherApkLocalStorageFailure INSUFFICIENT = new LauncherApkLocalStorageFailure("INSUFFICIENT", 1);

    private static final /* synthetic */ LauncherApkLocalStorageFailure[] $values() {
        return new LauncherApkLocalStorageFailure[]{UNAVAILABLE, INSUFFICIENT};
    }

    public static EnumEntries<LauncherApkLocalStorageFailure> getEntries() {
        return $ENTRIES;
    }

    public static LauncherApkLocalStorageFailure valueOf(String str) {
        return (LauncherApkLocalStorageFailure) Enum.valueOf(LauncherApkLocalStorageFailure.class, str);
    }

    public static LauncherApkLocalStorageFailure[] values() {
        return (LauncherApkLocalStorageFailure[]) $VALUES.clone();
    }

    private LauncherApkLocalStorageFailure(String str, int i) {
    }

    static {
        LauncherApkLocalStorageFailure[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
