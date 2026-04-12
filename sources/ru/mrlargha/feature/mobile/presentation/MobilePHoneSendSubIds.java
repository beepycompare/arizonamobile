package ru.mrlargha.feature.mobile.presentation;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: MobilePhoneResponse.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0017\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lru/mrlargha/feature/mobile/presentation/MobilePHoneSendSubIds;", "", "subIds", "", "<init>", "(Ljava/lang/String;II)V", "getSubIds", "()I", "RENT", "RENT_DELETE", "RENT_RISE", "RENT_ADD_AD", "RENT_ACCESSORY_NAVIGATE_CREATE_ADD", "RENT_ACCESSORY_SET_ITEM", "RENT_ACCESSORY_ADD_ITEM", "RENT_ACCESSORY_DELETE_ITEM", "RENT_ACCESSORY_RENT", "RENT_ACCESSORY_RAISE", "RENT_ACCESSORY_RENT_OUT", "RENT_ACCESSORY_DELETE", "RENT_ACCESSORY_TAKE_ITEMS", "RENT_ACCESSORY_INFO", "RENT_ACCESSORY_CREATE_ADD", "RENT_ACCESSORY_PUBLIC", "RENT_ACCESSORY_CLOSE", "RENT_ACCESSORY_CLICK_LOCATION", "mobile"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class MobilePHoneSendSubIds {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ MobilePHoneSendSubIds[] $VALUES;
    private final int subIds;
    public static final MobilePHoneSendSubIds RENT = new MobilePHoneSendSubIds("RENT", 0, 30);
    public static final MobilePHoneSendSubIds RENT_DELETE = new MobilePHoneSendSubIds("RENT_DELETE", 1, 31);
    public static final MobilePHoneSendSubIds RENT_RISE = new MobilePHoneSendSubIds("RENT_RISE", 2, 32);
    public static final MobilePHoneSendSubIds RENT_ADD_AD = new MobilePHoneSendSubIds("RENT_ADD_AD", 3, 33);
    public static final MobilePHoneSendSubIds RENT_ACCESSORY_NAVIGATE_CREATE_ADD = new MobilePHoneSendSubIds("RENT_ACCESSORY_NAVIGATE_CREATE_ADD", 4, 34);
    public static final MobilePHoneSendSubIds RENT_ACCESSORY_SET_ITEM = new MobilePHoneSendSubIds("RENT_ACCESSORY_SET_ITEM", 5, 35);
    public static final MobilePHoneSendSubIds RENT_ACCESSORY_ADD_ITEM = new MobilePHoneSendSubIds("RENT_ACCESSORY_ADD_ITEM", 6, 36);
    public static final MobilePHoneSendSubIds RENT_ACCESSORY_DELETE_ITEM = new MobilePHoneSendSubIds("RENT_ACCESSORY_DELETE_ITEM", 7, 37);
    public static final MobilePHoneSendSubIds RENT_ACCESSORY_RENT = new MobilePHoneSendSubIds("RENT_ACCESSORY_RENT", 8, 39);
    public static final MobilePHoneSendSubIds RENT_ACCESSORY_RAISE = new MobilePHoneSendSubIds("RENT_ACCESSORY_RAISE", 9, 40);
    public static final MobilePHoneSendSubIds RENT_ACCESSORY_RENT_OUT = new MobilePHoneSendSubIds("RENT_ACCESSORY_RENT_OUT", 10, 41);
    public static final MobilePHoneSendSubIds RENT_ACCESSORY_DELETE = new MobilePHoneSendSubIds("RENT_ACCESSORY_DELETE", 11, 42);
    public static final MobilePHoneSendSubIds RENT_ACCESSORY_TAKE_ITEMS = new MobilePHoneSendSubIds("RENT_ACCESSORY_TAKE_ITEMS", 12, 43);
    public static final MobilePHoneSendSubIds RENT_ACCESSORY_INFO = new MobilePHoneSendSubIds("RENT_ACCESSORY_INFO", 13, 44);
    public static final MobilePHoneSendSubIds RENT_ACCESSORY_CREATE_ADD = new MobilePHoneSendSubIds("RENT_ACCESSORY_CREATE_ADD", 14, 45);
    public static final MobilePHoneSendSubIds RENT_ACCESSORY_PUBLIC = new MobilePHoneSendSubIds("RENT_ACCESSORY_PUBLIC", 15, 46);
    public static final MobilePHoneSendSubIds RENT_ACCESSORY_CLOSE = new MobilePHoneSendSubIds("RENT_ACCESSORY_CLOSE", 16, 47);
    public static final MobilePHoneSendSubIds RENT_ACCESSORY_CLICK_LOCATION = new MobilePHoneSendSubIds("RENT_ACCESSORY_CLICK_LOCATION", 17, 48);

    private static final /* synthetic */ MobilePHoneSendSubIds[] $values() {
        return new MobilePHoneSendSubIds[]{RENT, RENT_DELETE, RENT_RISE, RENT_ADD_AD, RENT_ACCESSORY_NAVIGATE_CREATE_ADD, RENT_ACCESSORY_SET_ITEM, RENT_ACCESSORY_ADD_ITEM, RENT_ACCESSORY_DELETE_ITEM, RENT_ACCESSORY_RENT, RENT_ACCESSORY_RAISE, RENT_ACCESSORY_RENT_OUT, RENT_ACCESSORY_DELETE, RENT_ACCESSORY_TAKE_ITEMS, RENT_ACCESSORY_INFO, RENT_ACCESSORY_CREATE_ADD, RENT_ACCESSORY_PUBLIC, RENT_ACCESSORY_CLOSE, RENT_ACCESSORY_CLICK_LOCATION};
    }

    public static EnumEntries<MobilePHoneSendSubIds> getEntries() {
        return $ENTRIES;
    }

    public static MobilePHoneSendSubIds valueOf(String str) {
        return (MobilePHoneSendSubIds) Enum.valueOf(MobilePHoneSendSubIds.class, str);
    }

    public static MobilePHoneSendSubIds[] values() {
        return (MobilePHoneSendSubIds[]) $VALUES.clone();
    }

    private MobilePHoneSendSubIds(String str, int i, int i2) {
        this.subIds = i2;
    }

    public final int getSubIds() {
        return this.subIds;
    }

    static {
        MobilePHoneSendSubIds[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
