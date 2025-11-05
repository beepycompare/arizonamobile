package ru.mrlargha.feature.mobile.presentation;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: MobilePhoneResponse.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lru/mrlargha/feature/mobile/presentation/MobilePHoneSendSubIds;", "", "subIds", "", "<init>", "(Ljava/lang/String;II)V", "getSubIds", "()I", "RENT", "RENT_DELETE", "RENT_RISE", "RENT_ADD_AD", "mobile_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class MobilePHoneSendSubIds {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ MobilePHoneSendSubIds[] $VALUES;
    private final int subIds;
    public static final MobilePHoneSendSubIds RENT = new MobilePHoneSendSubIds("RENT", 0, 30);
    public static final MobilePHoneSendSubIds RENT_DELETE = new MobilePHoneSendSubIds("RENT_DELETE", 1, 31);
    public static final MobilePHoneSendSubIds RENT_RISE = new MobilePHoneSendSubIds("RENT_RISE", 2, 32);
    public static final MobilePHoneSendSubIds RENT_ADD_AD = new MobilePHoneSendSubIds("RENT_ADD_AD", 3, 33);

    private static final /* synthetic */ MobilePHoneSendSubIds[] $values() {
        return new MobilePHoneSendSubIds[]{RENT, RENT_DELETE, RENT_RISE, RENT_ADD_AD};
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
