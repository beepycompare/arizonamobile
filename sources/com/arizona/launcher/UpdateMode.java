package com.arizona.launcher;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: UpdateActivity.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/arizona/launcher/UpdateMode;", "", "<init>", "(Ljava/lang/String;I)V", "Undefined", "LauncherUpdate", "GameUpdate", "app_arizonaRelease_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class UpdateMode {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ UpdateMode[] $VALUES;
    public static final UpdateMode Undefined = new UpdateMode("Undefined", 0);
    public static final UpdateMode LauncherUpdate = new UpdateMode("LauncherUpdate", 1);
    public static final UpdateMode GameUpdate = new UpdateMode("GameUpdate", 2);

    private static final /* synthetic */ UpdateMode[] $values() {
        return new UpdateMode[]{Undefined, LauncherUpdate, GameUpdate};
    }

    public static EnumEntries<UpdateMode> getEntries() {
        return $ENTRIES;
    }

    private UpdateMode(String str, int i) {
    }

    static {
        UpdateMode[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static UpdateMode valueOf(String str) {
        return (UpdateMode) Enum.valueOf(UpdateMode.class, str);
    }

    public static UpdateMode[] values() {
        return (UpdateMode[]) $VALUES.clone();
    }
}
