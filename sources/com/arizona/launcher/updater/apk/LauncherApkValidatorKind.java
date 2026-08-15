package com.arizona.launcher.updater.apk;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: LauncherApkResumeStore.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/arizona/launcher/updater/apk/LauncherApkValidatorKind;", "", "<init>", "(Ljava/lang/String;I)V", "STRONG_ETAG", "LAST_MODIFIED", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class LauncherApkValidatorKind {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ LauncherApkValidatorKind[] $VALUES;
    public static final LauncherApkValidatorKind STRONG_ETAG = new LauncherApkValidatorKind("STRONG_ETAG", 0);
    public static final LauncherApkValidatorKind LAST_MODIFIED = new LauncherApkValidatorKind("LAST_MODIFIED", 1);

    private static final /* synthetic */ LauncherApkValidatorKind[] $values() {
        return new LauncherApkValidatorKind[]{STRONG_ETAG, LAST_MODIFIED};
    }

    public static EnumEntries<LauncherApkValidatorKind> getEntries() {
        return $ENTRIES;
    }

    public static LauncherApkValidatorKind valueOf(String str) {
        return (LauncherApkValidatorKind) Enum.valueOf(LauncherApkValidatorKind.class, str);
    }

    public static LauncherApkValidatorKind[] values() {
        return (LauncherApkValidatorKind[]) $VALUES.clone();
    }

    private LauncherApkValidatorKind(String str, int i) {
    }

    static {
        LauncherApkValidatorKind[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
