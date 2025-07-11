package ru.mrlargha.commonui.elements.authorization.domain.controller;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: RegistrationServerResponse.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lru/mrlargha/commonui/elements/authorization/domain/controller/RegistrationServerResponse;", "", "id", "", "<init>", "(Ljava/lang/String;II)V", "getId", "()I", "AUTH_INIT", "AUTH_SERVER_ID_INFO", "AUTH_SERVER_ONLINE_INFO", "AUTH_SERVER_SUCCESS", "REGISTRATION_ACCOUNT_RESPONSE", "REGISTRATION_REFERRAL_RESPONSE", "REGISTRATION_PED_SETTINGS_RESPONSE", "RECOVERY_HANDLER_RESPONSE", "SELECT_SPAWN_DATA", "LOCAL_CHANGE_VIDEO", "AUTH_AWAIT_TEXT", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RegistrationServerResponse {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ RegistrationServerResponse[] $VALUES;
    private final int id;
    public static final RegistrationServerResponse AUTH_INIT = new RegistrationServerResponse("AUTH_INIT", 0, 0);
    public static final RegistrationServerResponse AUTH_SERVER_ID_INFO = new RegistrationServerResponse("AUTH_SERVER_ID_INFO", 1, 1);
    public static final RegistrationServerResponse AUTH_SERVER_ONLINE_INFO = new RegistrationServerResponse("AUTH_SERVER_ONLINE_INFO", 2, 2);
    public static final RegistrationServerResponse AUTH_SERVER_SUCCESS = new RegistrationServerResponse("AUTH_SERVER_SUCCESS", 3, 3);
    public static final RegistrationServerResponse REGISTRATION_ACCOUNT_RESPONSE = new RegistrationServerResponse("REGISTRATION_ACCOUNT_RESPONSE", 4, 4);
    public static final RegistrationServerResponse REGISTRATION_REFERRAL_RESPONSE = new RegistrationServerResponse("REGISTRATION_REFERRAL_RESPONSE", 5, 5);
    public static final RegistrationServerResponse REGISTRATION_PED_SETTINGS_RESPONSE = new RegistrationServerResponse("REGISTRATION_PED_SETTINGS_RESPONSE", 6, 6);
    public static final RegistrationServerResponse RECOVERY_HANDLER_RESPONSE = new RegistrationServerResponse("RECOVERY_HANDLER_RESPONSE", 7, 7);
    public static final RegistrationServerResponse SELECT_SPAWN_DATA = new RegistrationServerResponse("SELECT_SPAWN_DATA", 8, 8);
    public static final RegistrationServerResponse LOCAL_CHANGE_VIDEO = new RegistrationServerResponse("LOCAL_CHANGE_VIDEO", 9, 9);
    public static final RegistrationServerResponse AUTH_AWAIT_TEXT = new RegistrationServerResponse("AUTH_AWAIT_TEXT", 10, 10);

    private static final /* synthetic */ RegistrationServerResponse[] $values() {
        return new RegistrationServerResponse[]{AUTH_INIT, AUTH_SERVER_ID_INFO, AUTH_SERVER_ONLINE_INFO, AUTH_SERVER_SUCCESS, REGISTRATION_ACCOUNT_RESPONSE, REGISTRATION_REFERRAL_RESPONSE, REGISTRATION_PED_SETTINGS_RESPONSE, RECOVERY_HANDLER_RESPONSE, SELECT_SPAWN_DATA, LOCAL_CHANGE_VIDEO, AUTH_AWAIT_TEXT};
    }

    public static EnumEntries<RegistrationServerResponse> getEntries() {
        return $ENTRIES;
    }

    public static RegistrationServerResponse valueOf(String str) {
        return (RegistrationServerResponse) Enum.valueOf(RegistrationServerResponse.class, str);
    }

    public static RegistrationServerResponse[] values() {
        return (RegistrationServerResponse[]) $VALUES.clone();
    }

    private RegistrationServerResponse(String str, int i, int i2) {
        this.id = i2;
    }

    public final int getId() {
        return this.id;
    }

    static {
        RegistrationServerResponse[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
