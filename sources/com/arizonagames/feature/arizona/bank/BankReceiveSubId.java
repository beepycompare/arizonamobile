package com.arizonagames.feature.arizona.bank;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: BankContract.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/arizonagames/feature/arizona/bank/BankReceiveSubId;", "", "subId", "", "<init>", "(Ljava/lang/String;II)V", "getSubId", "()I", "ROOT_STATE", "DEPOSIT_STATE", "OTHER_STATE", "SELECTED_BUSINESS_STATE", "SELECTED_ELECTRIC_STATE", "CURRENCY_STATE", "SIGNATURE_STATE", "LAYOUT_MODE", "SELECTED_TAB", "GIVEAWAY_STATE", "bank"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BankReceiveSubId {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ BankReceiveSubId[] $VALUES;
    private final int subId;
    public static final BankReceiveSubId ROOT_STATE = new BankReceiveSubId("ROOT_STATE", 0, 0);
    public static final BankReceiveSubId DEPOSIT_STATE = new BankReceiveSubId("DEPOSIT_STATE", 1, 1);
    public static final BankReceiveSubId OTHER_STATE = new BankReceiveSubId("OTHER_STATE", 2, 2);
    public static final BankReceiveSubId SELECTED_BUSINESS_STATE = new BankReceiveSubId("SELECTED_BUSINESS_STATE", 3, 3);
    public static final BankReceiveSubId SELECTED_ELECTRIC_STATE = new BankReceiveSubId("SELECTED_ELECTRIC_STATE", 4, 4);
    public static final BankReceiveSubId CURRENCY_STATE = new BankReceiveSubId("CURRENCY_STATE", 5, 5);
    public static final BankReceiveSubId SIGNATURE_STATE = new BankReceiveSubId("SIGNATURE_STATE", 6, 6);
    public static final BankReceiveSubId LAYOUT_MODE = new BankReceiveSubId("LAYOUT_MODE", 7, 7);
    public static final BankReceiveSubId SELECTED_TAB = new BankReceiveSubId("SELECTED_TAB", 8, 8);
    public static final BankReceiveSubId GIVEAWAY_STATE = new BankReceiveSubId("GIVEAWAY_STATE", 9, 9);

    private static final /* synthetic */ BankReceiveSubId[] $values() {
        return new BankReceiveSubId[]{ROOT_STATE, DEPOSIT_STATE, OTHER_STATE, SELECTED_BUSINESS_STATE, SELECTED_ELECTRIC_STATE, CURRENCY_STATE, SIGNATURE_STATE, LAYOUT_MODE, SELECTED_TAB, GIVEAWAY_STATE};
    }

    public static EnumEntries<BankReceiveSubId> getEntries() {
        return $ENTRIES;
    }

    public static BankReceiveSubId valueOf(String str) {
        return (BankReceiveSubId) Enum.valueOf(BankReceiveSubId.class, str);
    }

    public static BankReceiveSubId[] values() {
        return (BankReceiveSubId[]) $VALUES.clone();
    }

    private BankReceiveSubId(String str, int i, int i2) {
        this.subId = i2;
    }

    public final int getSubId() {
        return this.subId;
    }

    static {
        BankReceiveSubId[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
