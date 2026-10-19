package com.arizona.launcher;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: LauncherUpdateLifecyclePolicy.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/arizona/launcher/LauncherApkRequestDisposition;", "", "<init>", "(Ljava/lang/String;I)V", "START_APK", "REATTACH_ACTIVE_APK", "REPLAY_READY_APK", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class LauncherApkRequestDisposition {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ LauncherApkRequestDisposition[] $VALUES;
    public static final LauncherApkRequestDisposition START_APK = new LauncherApkRequestDisposition("START_APK", 0);
    public static final LauncherApkRequestDisposition REATTACH_ACTIVE_APK = new LauncherApkRequestDisposition("REATTACH_ACTIVE_APK", 1);
    public static final LauncherApkRequestDisposition REPLAY_READY_APK = new LauncherApkRequestDisposition("REPLAY_READY_APK", 2);

    private static final /* synthetic */ LauncherApkRequestDisposition[] $values() {
        return new LauncherApkRequestDisposition[]{START_APK, REATTACH_ACTIVE_APK, REPLAY_READY_APK};
    }

    public static EnumEntries<LauncherApkRequestDisposition> getEntries() {
        return $ENTRIES;
    }

    public static LauncherApkRequestDisposition valueOf(String str) {
        return (LauncherApkRequestDisposition) Enum.valueOf(LauncherApkRequestDisposition.class, str);
    }

    public static LauncherApkRequestDisposition[] values() {
        return (LauncherApkRequestDisposition[]) $VALUES.clone();
    }

    private LauncherApkRequestDisposition(String str, int i) {
    }

    static {
        LauncherApkRequestDisposition[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
