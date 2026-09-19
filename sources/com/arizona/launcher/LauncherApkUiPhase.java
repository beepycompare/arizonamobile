package com.arizona.launcher;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: UpdateActivity.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/arizona/launcher/LauncherApkUiPhase;", "", "<init>", "(Ljava/lang/String;I)V", "Idle", "Downloading", "Ready", "Installing", "AwaitingUnknownSources", "Invalid", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class LauncherApkUiPhase {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ LauncherApkUiPhase[] $VALUES;
    public static final LauncherApkUiPhase Idle = new LauncherApkUiPhase("Idle", 0);
    public static final LauncherApkUiPhase Downloading = new LauncherApkUiPhase("Downloading", 1);
    public static final LauncherApkUiPhase Ready = new LauncherApkUiPhase("Ready", 2);
    public static final LauncherApkUiPhase Installing = new LauncherApkUiPhase("Installing", 3);
    public static final LauncherApkUiPhase AwaitingUnknownSources = new LauncherApkUiPhase("AwaitingUnknownSources", 4);
    public static final LauncherApkUiPhase Invalid = new LauncherApkUiPhase("Invalid", 5);

    private static final /* synthetic */ LauncherApkUiPhase[] $values() {
        return new LauncherApkUiPhase[]{Idle, Downloading, Ready, Installing, AwaitingUnknownSources, Invalid};
    }

    public static EnumEntries<LauncherApkUiPhase> getEntries() {
        return $ENTRIES;
    }

    public static LauncherApkUiPhase valueOf(String str) {
        return (LauncherApkUiPhase) Enum.valueOf(LauncherApkUiPhase.class, str);
    }

    public static LauncherApkUiPhase[] values() {
        return (LauncherApkUiPhase[]) $VALUES.clone();
    }

    private LauncherApkUiPhase(String str, int i) {
    }

    static {
        LauncherApkUiPhase[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
