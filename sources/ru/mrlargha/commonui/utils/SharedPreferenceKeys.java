package ru.mrlargha.commonui.utils;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: Constants.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lru/mrlargha/commonui/utils/SharedPreferenceKeys;", "", "<init>", "(Ljava/lang/String;I)V", "UNREAD_MESSAGE", "CommonUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class SharedPreferenceKeys {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SharedPreferenceKeys[] $VALUES;
    public static final SharedPreferenceKeys UNREAD_MESSAGE = new SharedPreferenceKeys("UNREAD_MESSAGE", 0);

    private static final /* synthetic */ SharedPreferenceKeys[] $values() {
        return new SharedPreferenceKeys[]{UNREAD_MESSAGE};
    }

    public static EnumEntries<SharedPreferenceKeys> getEntries() {
        return $ENTRIES;
    }

    public static SharedPreferenceKeys valueOf(String str) {
        return (SharedPreferenceKeys) Enum.valueOf(SharedPreferenceKeys.class, str);
    }

    public static SharedPreferenceKeys[] values() {
        return (SharedPreferenceKeys[]) $VALUES.clone();
    }

    private SharedPreferenceKeys(String str, int i) {
    }

    static {
        SharedPreferenceKeys[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
