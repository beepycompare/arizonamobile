package ru.mrlargha.commonui.elements.donate.presentation.models;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: DonateBoostModelUi.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lru/mrlargha/commonui/elements/donate/presentation/models/DonateRateType;", "", "<init>", "(Ljava/lang/String;I)V", "BUY_AZ", "EXCHANGER_RUB", "EXCHANGER_EXP", "EXCHANGER_GREEN_RUB", "CommonUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class DonateRateType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ DonateRateType[] $VALUES;
    public static final DonateRateType BUY_AZ = new DonateRateType("BUY_AZ", 0);
    public static final DonateRateType EXCHANGER_RUB = new DonateRateType("EXCHANGER_RUB", 1);
    public static final DonateRateType EXCHANGER_EXP = new DonateRateType("EXCHANGER_EXP", 2);
    public static final DonateRateType EXCHANGER_GREEN_RUB = new DonateRateType("EXCHANGER_GREEN_RUB", 3);

    private static final /* synthetic */ DonateRateType[] $values() {
        return new DonateRateType[]{BUY_AZ, EXCHANGER_RUB, EXCHANGER_EXP, EXCHANGER_GREEN_RUB};
    }

    public static EnumEntries<DonateRateType> getEntries() {
        return $ENTRIES;
    }

    public static DonateRateType valueOf(String str) {
        return (DonateRateType) Enum.valueOf(DonateRateType.class, str);
    }

    public static DonateRateType[] values() {
        return (DonateRateType[]) $VALUES.clone();
    }

    private DonateRateType(String str, int i) {
    }

    static {
        DonateRateType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
