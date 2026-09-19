package com.arizona.launcher;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: UpdateActivity.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/arizona/launcher/PersistedLauncherApkInspection;", "", "<init>", "(Ljava/lang/String;I)V", "MissingOrChanged", "Ready", "AlreadyInstalled", "Invalid", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
final class PersistedLauncherApkInspection {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ PersistedLauncherApkInspection[] $VALUES;
    public static final PersistedLauncherApkInspection MissingOrChanged = new PersistedLauncherApkInspection("MissingOrChanged", 0);
    public static final PersistedLauncherApkInspection Ready = new PersistedLauncherApkInspection("Ready", 1);
    public static final PersistedLauncherApkInspection AlreadyInstalled = new PersistedLauncherApkInspection("AlreadyInstalled", 2);
    public static final PersistedLauncherApkInspection Invalid = new PersistedLauncherApkInspection("Invalid", 3);

    private static final /* synthetic */ PersistedLauncherApkInspection[] $values() {
        return new PersistedLauncherApkInspection[]{MissingOrChanged, Ready, AlreadyInstalled, Invalid};
    }

    public static EnumEntries<PersistedLauncherApkInspection> getEntries() {
        return $ENTRIES;
    }

    public static PersistedLauncherApkInspection valueOf(String str) {
        return (PersistedLauncherApkInspection) Enum.valueOf(PersistedLauncherApkInspection.class, str);
    }

    public static PersistedLauncherApkInspection[] values() {
        return (PersistedLauncherApkInspection[]) $VALUES.clone();
    }

    private PersistedLauncherApkInspection(String str, int i) {
    }

    static {
        PersistedLauncherApkInspection[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
