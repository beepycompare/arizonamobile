package ru.mrlargha.feature.mobile.presentation;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: MobilePhoneResponse.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lru/mrlargha/feature/mobile/presentation/MobilePhoneGetSubIds;", "", "subId", "", "<init>", "(Ljava/lang/String;II)V", "getSubId", "()I", "RENT_REAL_ESTATE_LIST", "RENT_UPDATE", "mobile_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class MobilePhoneGetSubIds {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ MobilePhoneGetSubIds[] $VALUES;
    public static final MobilePhoneGetSubIds RENT_REAL_ESTATE_LIST = new MobilePhoneGetSubIds("RENT_REAL_ESTATE_LIST", 0, 51);
    public static final MobilePhoneGetSubIds RENT_UPDATE = new MobilePhoneGetSubIds("RENT_UPDATE", 1, 52);
    private final int subId;

    private static final /* synthetic */ MobilePhoneGetSubIds[] $values() {
        return new MobilePhoneGetSubIds[]{RENT_REAL_ESTATE_LIST, RENT_UPDATE};
    }

    public static EnumEntries<MobilePhoneGetSubIds> getEntries() {
        return $ENTRIES;
    }

    public static MobilePhoneGetSubIds valueOf(String str) {
        return (MobilePhoneGetSubIds) Enum.valueOf(MobilePhoneGetSubIds.class, str);
    }

    public static MobilePhoneGetSubIds[] values() {
        return (MobilePhoneGetSubIds[]) $VALUES.clone();
    }

    private MobilePhoneGetSubIds(String str, int i, int i2) {
        this.subId = i2;
    }

    public final int getSubId() {
        return this.subId;
    }

    static {
        MobilePhoneGetSubIds[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
