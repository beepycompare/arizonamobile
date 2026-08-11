package com.arizonagames.feature.arizona.bank;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: BankLotteryResultState.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/arizonagames/feature/arizona/bank/BankLotteryResultState;", "", "<init>", "(Ljava/lang/String;I)V", "ACTIVE", "AWAITING_RESULTS", "FINISHED", "bank"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BankLotteryResultState {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ BankLotteryResultState[] $VALUES;
    public static final BankLotteryResultState ACTIVE = new BankLotteryResultState("ACTIVE", 0);
    public static final BankLotteryResultState AWAITING_RESULTS = new BankLotteryResultState("AWAITING_RESULTS", 1);
    public static final BankLotteryResultState FINISHED = new BankLotteryResultState("FINISHED", 2);

    private static final /* synthetic */ BankLotteryResultState[] $values() {
        return new BankLotteryResultState[]{ACTIVE, AWAITING_RESULTS, FINISHED};
    }

    public static EnumEntries<BankLotteryResultState> getEntries() {
        return $ENTRIES;
    }

    public static BankLotteryResultState valueOf(String str) {
        return (BankLotteryResultState) Enum.valueOf(BankLotteryResultState.class, str);
    }

    public static BankLotteryResultState[] values() {
        return (BankLotteryResultState[]) $VALUES.clone();
    }

    private BankLotteryResultState(String str, int i) {
    }

    static {
        BankLotteryResultState[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
