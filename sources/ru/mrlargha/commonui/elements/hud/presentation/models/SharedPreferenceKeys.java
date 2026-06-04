package ru.mrlargha.commonui.elements.hud.presentation.models;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: ServerInfoItem.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lru/mrlargha/commonui/elements/hud/presentation/models/SharedPreferenceKeys;", "", "keyName", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getKeyName", "()Ljava/lang/String;", "API_TOKEN", "SERVER_ID", "ACCOUNT_ID", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class SharedPreferenceKeys {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SharedPreferenceKeys[] $VALUES;
    private final String keyName;
    public static final SharedPreferenceKeys API_TOKEN = new SharedPreferenceKeys("API_TOKEN", 0, "api_token");
    public static final SharedPreferenceKeys SERVER_ID = new SharedPreferenceKeys("SERVER_ID", 1, "server_id");
    public static final SharedPreferenceKeys ACCOUNT_ID = new SharedPreferenceKeys("ACCOUNT_ID", 2, "account_id");

    private static final /* synthetic */ SharedPreferenceKeys[] $values() {
        return new SharedPreferenceKeys[]{API_TOKEN, SERVER_ID, ACCOUNT_ID};
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

    private SharedPreferenceKeys(String str, int i, String str2) {
        this.keyName = str2;
    }

    public final String getKeyName() {
        return this.keyName;
    }

    static {
        SharedPreferenceKeys[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
