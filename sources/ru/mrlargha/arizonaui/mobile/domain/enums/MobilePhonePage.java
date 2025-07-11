package ru.mrlargha.arizonaui.mobile.domain.enums;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: MobilePhonePage.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0018\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001a¨\u0006\u001b"}, d2 = {"Lru/mrlargha/arizonaui/mobile/domain/enums/MobilePhonePage;", "", "id", "", "<init>", "(Ljava/lang/String;II)V", "getId", "()I", "MAIN_PAGE", "CALL_TYPE_PAGE", "CALL_RECEIVE_PAGE", "CALL_TALK_PAGE", "ARIZONAMOBIL_MAIN", "ARIZONAMOBIL_CAR_INFO", "ARIZONAMOBIL_CARS", "ARIZONAMOBIL_RENTED", "UBER_PREVIEW", "UBER_CHOSE_TAXI", "UBER_ORDER", "UBER_COMPLETE", "MOBILE_PHONE_PAGE", "DRIVER_ORDERS", "DRIVER_ORDER", "SPOTIFY_PAGE", "CATCH_APP", "MESSENGER_APP", "MESSENGER_CHAT", "ArizonaUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MobilePhonePage {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ MobilePhonePage[] $VALUES;
    private final int id;
    public static final MobilePhonePage MAIN_PAGE = new MobilePhonePage("MAIN_PAGE", 0, 0);
    public static final MobilePhonePage CALL_TYPE_PAGE = new MobilePhonePage("CALL_TYPE_PAGE", 1, 1);
    public static final MobilePhonePage CALL_RECEIVE_PAGE = new MobilePhonePage("CALL_RECEIVE_PAGE", 2, 2);
    public static final MobilePhonePage CALL_TALK_PAGE = new MobilePhonePage("CALL_TALK_PAGE", 3, 3);
    public static final MobilePhonePage ARIZONAMOBIL_MAIN = new MobilePhonePage("ARIZONAMOBIL_MAIN", 4, 4);
    public static final MobilePhonePage ARIZONAMOBIL_CAR_INFO = new MobilePhonePage("ARIZONAMOBIL_CAR_INFO", 5, 5);
    public static final MobilePhonePage ARIZONAMOBIL_CARS = new MobilePhonePage("ARIZONAMOBIL_CARS", 6, 6);
    public static final MobilePhonePage ARIZONAMOBIL_RENTED = new MobilePhonePage("ARIZONAMOBIL_RENTED", 7, 7);
    public static final MobilePhonePage UBER_PREVIEW = new MobilePhonePage("UBER_PREVIEW", 8, 8);
    public static final MobilePhonePage UBER_CHOSE_TAXI = new MobilePhonePage("UBER_CHOSE_TAXI", 9, 9);
    public static final MobilePhonePage UBER_ORDER = new MobilePhonePage("UBER_ORDER", 10, 10);
    public static final MobilePhonePage UBER_COMPLETE = new MobilePhonePage("UBER_COMPLETE", 11, 11);
    public static final MobilePhonePage MOBILE_PHONE_PAGE = new MobilePhonePage("MOBILE_PHONE_PAGE", 12, 12);
    public static final MobilePhonePage DRIVER_ORDERS = new MobilePhonePage("DRIVER_ORDERS", 13, 13);
    public static final MobilePhonePage DRIVER_ORDER = new MobilePhonePage("DRIVER_ORDER", 14, 14);
    public static final MobilePhonePage SPOTIFY_PAGE = new MobilePhonePage("SPOTIFY_PAGE", 15, 15);
    public static final MobilePhonePage CATCH_APP = new MobilePhonePage("CATCH_APP", 16, 16);
    public static final MobilePhonePage MESSENGER_APP = new MobilePhonePage("MESSENGER_APP", 17, 17);
    public static final MobilePhonePage MESSENGER_CHAT = new MobilePhonePage("MESSENGER_CHAT", 18, 18);

    private static final /* synthetic */ MobilePhonePage[] $values() {
        return new MobilePhonePage[]{MAIN_PAGE, CALL_TYPE_PAGE, CALL_RECEIVE_PAGE, CALL_TALK_PAGE, ARIZONAMOBIL_MAIN, ARIZONAMOBIL_CAR_INFO, ARIZONAMOBIL_CARS, ARIZONAMOBIL_RENTED, UBER_PREVIEW, UBER_CHOSE_TAXI, UBER_ORDER, UBER_COMPLETE, MOBILE_PHONE_PAGE, DRIVER_ORDERS, DRIVER_ORDER, SPOTIFY_PAGE, CATCH_APP, MESSENGER_APP, MESSENGER_CHAT};
    }

    public static EnumEntries<MobilePhonePage> getEntries() {
        return $ENTRIES;
    }

    public static MobilePhonePage valueOf(String str) {
        return (MobilePhonePage) Enum.valueOf(MobilePhonePage.class, str);
    }

    public static MobilePhonePage[] values() {
        return (MobilePhonePage[]) $VALUES.clone();
    }

    private MobilePhonePage(String str, int i, int i2) {
        this.id = i2;
    }

    public final int getId() {
        return this.id;
    }

    static {
        MobilePhonePage[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
