package ru.mrlargha.commonui.elements.authorization.domain.controller;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;
import ru.mrlargha.commonui.elements.authorization.domain.ReferralMethodType;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: RegistrationInterfaceType.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\b\u0086\u0081\u0002\u0018\u0000 \u00162\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0016B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0017"}, d2 = {"Lru/mrlargha/commonui/elements/authorization/domain/controller/RegistrationInterfaceType;", "", "id", "", "<init>", "(Ljava/lang/String;II)V", "getId", "()I", "AUTH_INIT", "AUTH_SERVER_ID_INFO", "AUTH_SERVER_ONLINE_INFO", "AUTH_SERVER_SUCCESS", "VIDEO_BACKGROUND", "REGISTRATION_INIT", "REGISTRATION_REFERRAL", "REGISTRATION_REFERRAL_METHOD", "REGISTRATION_PED_SETTINGS", "RECOVERY_HANDLER", "RECOVERY_METHOD", "RECOVERY_FINAL", "SPAWN_SELECTOR", "AUTHORIZATION_NEWS", "Companion", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RegistrationInterfaceType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ RegistrationInterfaceType[] $VALUES;
    public static final Companion Companion;
    private static final Map<Integer, ReferralMethodType> map;
    private final int id;
    public static final RegistrationInterfaceType AUTH_INIT = new RegistrationInterfaceType("AUTH_INIT", 0, 0);
    public static final RegistrationInterfaceType AUTH_SERVER_ID_INFO = new RegistrationInterfaceType("AUTH_SERVER_ID_INFO", 1, 1);
    public static final RegistrationInterfaceType AUTH_SERVER_ONLINE_INFO = new RegistrationInterfaceType("AUTH_SERVER_ONLINE_INFO", 2, 2);
    public static final RegistrationInterfaceType AUTH_SERVER_SUCCESS = new RegistrationInterfaceType("AUTH_SERVER_SUCCESS", 3, 3);
    public static final RegistrationInterfaceType VIDEO_BACKGROUND = new RegistrationInterfaceType("VIDEO_BACKGROUND", 4, 4);
    public static final RegistrationInterfaceType REGISTRATION_INIT = new RegistrationInterfaceType("REGISTRATION_INIT", 5, 5);
    public static final RegistrationInterfaceType REGISTRATION_REFERRAL = new RegistrationInterfaceType("REGISTRATION_REFERRAL", 6, 6);
    public static final RegistrationInterfaceType REGISTRATION_REFERRAL_METHOD = new RegistrationInterfaceType("REGISTRATION_REFERRAL_METHOD", 7, 7);
    public static final RegistrationInterfaceType REGISTRATION_PED_SETTINGS = new RegistrationInterfaceType("REGISTRATION_PED_SETTINGS", 8, 8);
    public static final RegistrationInterfaceType RECOVERY_HANDLER = new RegistrationInterfaceType("RECOVERY_HANDLER", 9, 9);
    public static final RegistrationInterfaceType RECOVERY_METHOD = new RegistrationInterfaceType("RECOVERY_METHOD", 10, 10);
    public static final RegistrationInterfaceType RECOVERY_FINAL = new RegistrationInterfaceType("RECOVERY_FINAL", 11, 11);
    public static final RegistrationInterfaceType SPAWN_SELECTOR = new RegistrationInterfaceType("SPAWN_SELECTOR", 12, 12);
    public static final RegistrationInterfaceType AUTHORIZATION_NEWS = new RegistrationInterfaceType("AUTHORIZATION_NEWS", 13, 13);

    private static final /* synthetic */ RegistrationInterfaceType[] $values() {
        return new RegistrationInterfaceType[]{AUTH_INIT, AUTH_SERVER_ID_INFO, AUTH_SERVER_ONLINE_INFO, AUTH_SERVER_SUCCESS, VIDEO_BACKGROUND, REGISTRATION_INIT, REGISTRATION_REFERRAL, REGISTRATION_REFERRAL_METHOD, REGISTRATION_PED_SETTINGS, RECOVERY_HANDLER, RECOVERY_METHOD, RECOVERY_FINAL, SPAWN_SELECTOR, AUTHORIZATION_NEWS};
    }

    public static EnumEntries<RegistrationInterfaceType> getEntries() {
        return $ENTRIES;
    }

    public static RegistrationInterfaceType valueOf(String str) {
        return (RegistrationInterfaceType) Enum.valueOf(RegistrationInterfaceType.class, str);
    }

    public static RegistrationInterfaceType[] values() {
        return (RegistrationInterfaceType[]) $VALUES.clone();
    }

    private RegistrationInterfaceType(String str, int i, int i2) {
        this.id = i2;
    }

    public final int getId() {
        return this.id;
    }

    static {
        RegistrationInterfaceType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        Companion = new Companion(null);
        ReferralMethodType[] values = ReferralMethodType.values();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(values.length), 16));
        for (ReferralMethodType referralMethodType : values) {
            linkedHashMap.put(Integer.valueOf(referralMethodType.getId()), referralMethodType);
        }
        map = linkedHashMap;
    }

    /* compiled from: RegistrationInterfaceType.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\u0006H\u0086\u0002R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lru/mrlargha/commonui/elements/authorization/domain/controller/RegistrationInterfaceType$Companion;", "", "<init>", "()V", "map", "", "", "Lru/mrlargha/commonui/elements/authorization/domain/ReferralMethodType;", "get", "value", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ReferralMethodType get(int i) {
            return (ReferralMethodType) RegistrationInterfaceType.map.get(Integer.valueOf(i));
        }
    }
}
