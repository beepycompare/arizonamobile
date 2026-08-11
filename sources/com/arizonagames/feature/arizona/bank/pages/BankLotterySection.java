package com.arizonagames.feature.arizona.bank.pages;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: BankLotteryPageController.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/arizonagames/feature/arizona/bank/pages/BankLotterySection;", "", "<init>", "(Ljava/lang/String;I)V", "HOME", "TASKS", "REWARDS", "bank"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BankLotterySection {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ BankLotterySection[] $VALUES;
    public static final BankLotterySection HOME = new BankLotterySection("HOME", 0);
    public static final BankLotterySection TASKS = new BankLotterySection("TASKS", 1);
    public static final BankLotterySection REWARDS = new BankLotterySection("REWARDS", 2);

    private static final /* synthetic */ BankLotterySection[] $values() {
        return new BankLotterySection[]{HOME, TASKS, REWARDS};
    }

    public static EnumEntries<BankLotterySection> getEntries() {
        return $ENTRIES;
    }

    public static BankLotterySection valueOf(String str) {
        return (BankLotterySection) Enum.valueOf(BankLotterySection.class, str);
    }

    public static BankLotterySection[] values() {
        return (BankLotterySection[]) $VALUES.clone();
    }

    private BankLotterySection(String str, int i) {
    }

    static {
        BankLotterySection[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
