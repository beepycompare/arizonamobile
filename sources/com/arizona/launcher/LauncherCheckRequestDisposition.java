package com.arizona.launcher;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: LauncherUpdateLifecyclePolicy.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/arizona/launcher/LauncherCheckRequestDisposition;", "", "<init>", "(Ljava/lang/String;I)V", "START_CHECK", "REATTACH_ACTIVE_CHECK", "ROUTE_TO_ACTIVE_APK", "REPLAY_READY_APK", "app"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class LauncherCheckRequestDisposition {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ LauncherCheckRequestDisposition[] $VALUES;
    public static final LauncherCheckRequestDisposition START_CHECK = new LauncherCheckRequestDisposition("START_CHECK", 0);
    public static final LauncherCheckRequestDisposition REATTACH_ACTIVE_CHECK = new LauncherCheckRequestDisposition("REATTACH_ACTIVE_CHECK", 1);
    public static final LauncherCheckRequestDisposition ROUTE_TO_ACTIVE_APK = new LauncherCheckRequestDisposition("ROUTE_TO_ACTIVE_APK", 2);
    public static final LauncherCheckRequestDisposition REPLAY_READY_APK = new LauncherCheckRequestDisposition("REPLAY_READY_APK", 3);

    private static final /* synthetic */ LauncherCheckRequestDisposition[] $values() {
        return new LauncherCheckRequestDisposition[]{START_CHECK, REATTACH_ACTIVE_CHECK, ROUTE_TO_ACTIVE_APK, REPLAY_READY_APK};
    }

    public static EnumEntries<LauncherCheckRequestDisposition> getEntries() {
        return $ENTRIES;
    }

    public static LauncherCheckRequestDisposition valueOf(String str) {
        return (LauncherCheckRequestDisposition) Enum.valueOf(LauncherCheckRequestDisposition.class, str);
    }

    public static LauncherCheckRequestDisposition[] values() {
        return (LauncherCheckRequestDisposition[]) $VALUES.clone();
    }

    private LauncherCheckRequestDisposition(String str, int i) {
    }

    static {
        LauncherCheckRequestDisposition[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
