package ru.mrlargha.feature.mobile.presentation.page.rent_accessory;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: MobileRentAccessoryEvent.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lru/mrlargha/feature/mobile/presentation/page/rent_accessory/MobileRentAccessoryEvent;", "", "<init>", "(Ljava/lang/String;I)V", "NONE", "UPDATE_ADDS", "GET_FILTER", "GET_CHOSEN_ITEM", "GET_CATEGORY", "SET_LIMITS", "SET_TAB", "WITHOUT_CLEAR", "WARE_HOUSE_COUNT", "mobile"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class MobileRentAccessoryEvent {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ MobileRentAccessoryEvent[] $VALUES;
    public static final MobileRentAccessoryEvent NONE = new MobileRentAccessoryEvent("NONE", 0);
    public static final MobileRentAccessoryEvent UPDATE_ADDS = new MobileRentAccessoryEvent("UPDATE_ADDS", 1);
    public static final MobileRentAccessoryEvent GET_FILTER = new MobileRentAccessoryEvent("GET_FILTER", 2);
    public static final MobileRentAccessoryEvent GET_CHOSEN_ITEM = new MobileRentAccessoryEvent("GET_CHOSEN_ITEM", 3);
    public static final MobileRentAccessoryEvent GET_CATEGORY = new MobileRentAccessoryEvent("GET_CATEGORY", 4);
    public static final MobileRentAccessoryEvent SET_LIMITS = new MobileRentAccessoryEvent("SET_LIMITS", 5);
    public static final MobileRentAccessoryEvent SET_TAB = new MobileRentAccessoryEvent("SET_TAB", 6);
    public static final MobileRentAccessoryEvent WITHOUT_CLEAR = new MobileRentAccessoryEvent("WITHOUT_CLEAR", 7);
    public static final MobileRentAccessoryEvent WARE_HOUSE_COUNT = new MobileRentAccessoryEvent("WARE_HOUSE_COUNT", 8);

    private static final /* synthetic */ MobileRentAccessoryEvent[] $values() {
        return new MobileRentAccessoryEvent[]{NONE, UPDATE_ADDS, GET_FILTER, GET_CHOSEN_ITEM, GET_CATEGORY, SET_LIMITS, SET_TAB, WITHOUT_CLEAR, WARE_HOUSE_COUNT};
    }

    public static EnumEntries<MobileRentAccessoryEvent> getEntries() {
        return $ENTRIES;
    }

    public static MobileRentAccessoryEvent valueOf(String str) {
        return (MobileRentAccessoryEvent) Enum.valueOf(MobileRentAccessoryEvent.class, str);
    }

    public static MobileRentAccessoryEvent[] values() {
        return (MobileRentAccessoryEvent[]) $VALUES.clone();
    }

    private MobileRentAccessoryEvent(String str, int i) {
    }

    static {
        MobileRentAccessoryEvent[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
