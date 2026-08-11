package com.arizonagames.feature.arizona.bank;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: BankContract.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b.\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B#\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3¨\u00064"}, d2 = {"Lcom/arizonagames/feature/arizona/bank/BankSendSubId;", "", "subId", "", "actionId", "payloadMode", "Lcom/arizonagames/feature/arizona/bank/BankSendPayloadMode;", "<init>", "(Ljava/lang/String;IIILcom/arizonagames/feature/arizona/bank/BankSendPayloadMode;)V", "getSubId", "()I", "getActionId", "getPayloadMode", "()Lcom/arizonagames/feature/arizona/bank/BankSendPayloadMode;", "CLOSE", "SIGNATURE_OPEN", "BANK_ACCOUNT_OPEN", "ACCOUNT_WITHDRAW", "ACCOUNT_DEPOSIT", "ACCOUNT_TRANSFER", "ACCOUNT_HISTORY", "ACCOUNT_OPEN", "ORGANIZATION_WITHDRAW", "ORGANIZATION_DEPOSIT", "ORGANIZATION_HISTORY", "RETIREMENT_BUY", "RETIREMENT_WITHDRAW", "RETIREMENT_INFO", "TAX_PAY_ALL", "TAX_PAY", "DEPOSIT_WITHDRAW", "DEPOSIT_DEPOSIT", "DEPOSIT_HISTORY", "DEPOSIT_UPGRADE", "CURRENCY_BUY", "CURRENCY_SELL", "CURRENCY_INFO", "VIP_INFO", "VIP_BUY", "MOBILE_TOP_UP", "VEHICLE_PICK_UP", "BUSINESS_WITHDRAW", "BUSINESS_DEPOSIT", "ELECTRIC_DEPOSIT", "GIVEAWAY_CLAIM", "GIVEAWAY_TASK", "MAIN_STATISTICS", "OLIGARCH_CHEST_REWARD", "ORGANIZATION_CHEST_REWARD", "BUSINESS_SELECT", "ELECTRIC_SELECT", "TOP_TAB_SELECT", "bank"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BankSendSubId {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ BankSendSubId[] $VALUES;
    private final int actionId;
    private final BankSendPayloadMode payloadMode;
    private final int subId;
    public static final BankSendSubId CLOSE = new BankSendSubId("CLOSE", 0, 0, 0, null, 4, null);
    public static final BankSendSubId SIGNATURE_OPEN = new BankSendSubId("SIGNATURE_OPEN", 1, 1, 0, null, 4, null);
    public static final BankSendSubId BANK_ACCOUNT_OPEN = new BankSendSubId("BANK_ACCOUNT_OPEN", 2, 1, 1, null, 4, null);
    public static final BankSendSubId ACCOUNT_WITHDRAW = new BankSendSubId("ACCOUNT_WITHDRAW", 3, 2, 0, BankSendPayloadMode.TARGET_AS_DATA);
    public static final BankSendSubId ACCOUNT_DEPOSIT = new BankSendSubId("ACCOUNT_DEPOSIT", 4, 2, 1, BankSendPayloadMode.TARGET_AS_DATA);
    public static final BankSendSubId ACCOUNT_TRANSFER = new BankSendSubId("ACCOUNT_TRANSFER", 5, 2, 2, BankSendPayloadMode.TARGET_AS_DATA);
    public static final BankSendSubId ACCOUNT_HISTORY = new BankSendSubId("ACCOUNT_HISTORY", 6, 2, 3, BankSendPayloadMode.TARGET_AS_DATA);
    public static final BankSendSubId ACCOUNT_OPEN = new BankSendSubId("ACCOUNT_OPEN", 7, 2, 4, null, 4, null);
    public static final BankSendSubId ORGANIZATION_WITHDRAW = new BankSendSubId("ORGANIZATION_WITHDRAW", 8, 3, 0, null, 4, null);
    public static final BankSendSubId ORGANIZATION_DEPOSIT = new BankSendSubId("ORGANIZATION_DEPOSIT", 9, 3, 1, null, 4, null);
    public static final BankSendSubId ORGANIZATION_HISTORY = new BankSendSubId("ORGANIZATION_HISTORY", 10, 3, 2, null, 4, null);
    public static final BankSendSubId RETIREMENT_BUY = new BankSendSubId("RETIREMENT_BUY", 11, 4, 0, null, 4, null);
    public static final BankSendSubId RETIREMENT_WITHDRAW = new BankSendSubId("RETIREMENT_WITHDRAW", 12, 4, 1, null, 4, null);
    public static final BankSendSubId RETIREMENT_INFO = new BankSendSubId("RETIREMENT_INFO", 13, 4, 2, null, 4, null);
    public static final BankSendSubId TAX_PAY_ALL = new BankSendSubId("TAX_PAY_ALL", 14, 5, 0, null, 4, null);
    public static final BankSendSubId TAX_PAY = new BankSendSubId("TAX_PAY", 15, 5, 1, BankSendPayloadMode.TARGET_AS_DATA);
    public static final BankSendSubId DEPOSIT_WITHDRAW = new BankSendSubId("DEPOSIT_WITHDRAW", 16, 6, 0, null, 4, null);
    public static final BankSendSubId DEPOSIT_DEPOSIT = new BankSendSubId("DEPOSIT_DEPOSIT", 17, 6, 1, null, 4, null);
    public static final BankSendSubId DEPOSIT_HISTORY = new BankSendSubId("DEPOSIT_HISTORY", 18, 6, 2, null, 4, null);
    public static final BankSendSubId DEPOSIT_UPGRADE = new BankSendSubId("DEPOSIT_UPGRADE", 19, 6, 3, null, 4, null);
    public static final BankSendSubId CURRENCY_BUY = new BankSendSubId("CURRENCY_BUY", 20, 7, 0, BankSendPayloadMode.TARGET_AS_DATA);
    public static final BankSendSubId CURRENCY_SELL = new BankSendSubId("CURRENCY_SELL", 21, 7, 1, BankSendPayloadMode.TARGET_AS_DATA);
    public static final BankSendSubId CURRENCY_INFO = new BankSendSubId("CURRENCY_INFO", 22, 7, 2, BankSendPayloadMode.TARGET_AS_DATA);
    public static final BankSendSubId VIP_INFO = new BankSendSubId("VIP_INFO", 23, 8, 0, null, 4, null);
    public static final BankSendSubId VIP_BUY = new BankSendSubId("VIP_BUY", 24, 8, 1, null, 4, null);
    public static final BankSendSubId MOBILE_TOP_UP = new BankSendSubId("MOBILE_TOP_UP", 25, 8, 2, null, 4, null);
    public static final BankSendSubId VEHICLE_PICK_UP = new BankSendSubId("VEHICLE_PICK_UP", 26, 9, 0, BankSendPayloadMode.TARGET_AS_DATA);
    public static final BankSendSubId BUSINESS_WITHDRAW = new BankSendSubId("BUSINESS_WITHDRAW", 27, 10, 0, BankSendPayloadMode.TARGET_AS_DATA);
    public static final BankSendSubId BUSINESS_DEPOSIT = new BankSendSubId("BUSINESS_DEPOSIT", 28, 10, 1, BankSendPayloadMode.TARGET_AS_DATA);
    public static final BankSendSubId ELECTRIC_DEPOSIT = new BankSendSubId("ELECTRIC_DEPOSIT", 29, 11, 0, BankSendPayloadMode.TARGET_AS_ID);
    public static final BankSendSubId GIVEAWAY_CLAIM = new BankSendSubId("GIVEAWAY_CLAIM", 30, 12, 0, BankSendPayloadMode.EMPTY_JSON);
    public static final BankSendSubId GIVEAWAY_TASK = new BankSendSubId("GIVEAWAY_TASK", 31, 12, 1, BankSendPayloadMode.TARGET_AS_DATA);
    public static final BankSendSubId MAIN_STATISTICS = new BankSendSubId("MAIN_STATISTICS", 32, 12, 2, null, 4, null);
    public static final BankSendSubId OLIGARCH_CHEST_REWARD = new BankSendSubId("OLIGARCH_CHEST_REWARD", 33, 12, 3, BankSendPayloadMode.CHEST_REWARD);
    public static final BankSendSubId ORGANIZATION_CHEST_REWARD = new BankSendSubId("ORGANIZATION_CHEST_REWARD", 34, 12, 4, BankSendPayloadMode.CHEST_REWARD);
    public static final BankSendSubId BUSINESS_SELECT = new BankSendSubId("BUSINESS_SELECT", 35, 13, 0, BankSendPayloadMode.TARGET_AS_ID);
    public static final BankSendSubId ELECTRIC_SELECT = new BankSendSubId("ELECTRIC_SELECT", 36, 14, 0, BankSendPayloadMode.TARGET_AS_ID);
    public static final BankSendSubId TOP_TAB_SELECT = new BankSendSubId("TOP_TAB_SELECT", 37, 16, 0, BankSendPayloadMode.TARGET_AS_ID);

    private static final /* synthetic */ BankSendSubId[] $values() {
        return new BankSendSubId[]{CLOSE, SIGNATURE_OPEN, BANK_ACCOUNT_OPEN, ACCOUNT_WITHDRAW, ACCOUNT_DEPOSIT, ACCOUNT_TRANSFER, ACCOUNT_HISTORY, ACCOUNT_OPEN, ORGANIZATION_WITHDRAW, ORGANIZATION_DEPOSIT, ORGANIZATION_HISTORY, RETIREMENT_BUY, RETIREMENT_WITHDRAW, RETIREMENT_INFO, TAX_PAY_ALL, TAX_PAY, DEPOSIT_WITHDRAW, DEPOSIT_DEPOSIT, DEPOSIT_HISTORY, DEPOSIT_UPGRADE, CURRENCY_BUY, CURRENCY_SELL, CURRENCY_INFO, VIP_INFO, VIP_BUY, MOBILE_TOP_UP, VEHICLE_PICK_UP, BUSINESS_WITHDRAW, BUSINESS_DEPOSIT, ELECTRIC_DEPOSIT, GIVEAWAY_CLAIM, GIVEAWAY_TASK, MAIN_STATISTICS, OLIGARCH_CHEST_REWARD, ORGANIZATION_CHEST_REWARD, BUSINESS_SELECT, ELECTRIC_SELECT, TOP_TAB_SELECT};
    }

    public static EnumEntries<BankSendSubId> getEntries() {
        return $ENTRIES;
    }

    public static BankSendSubId valueOf(String str) {
        return (BankSendSubId) Enum.valueOf(BankSendSubId.class, str);
    }

    public static BankSendSubId[] values() {
        return (BankSendSubId[]) $VALUES.clone();
    }

    private BankSendSubId(String str, int i, int i2, int i3, BankSendPayloadMode bankSendPayloadMode) {
        this.subId = i2;
        this.actionId = i3;
        this.payloadMode = bankSendPayloadMode;
    }

    public final int getSubId() {
        return this.subId;
    }

    public final int getActionId() {
        return this.actionId;
    }

    /* synthetic */ BankSendSubId(String str, int i, int i2, int i3, BankSendPayloadMode bankSendPayloadMode, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, i2, i3, (i4 & 4) != 0 ? BankSendPayloadMode.NONE : bankSendPayloadMode);
    }

    public final BankSendPayloadMode getPayloadMode() {
        return this.payloadMode;
    }

    static {
        BankSendSubId[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
