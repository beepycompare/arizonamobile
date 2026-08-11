package com.arizonagames.feature.arizona.bank.pages;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: BankLotteryPageController.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/arizonagames/feature/arizona/bank/pages/BankLotteryStreamPlatform;", "", "<init>", "(Ljava/lang/String;I)V", "YOUTUBE", "VK", "TWITCH", "bank"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BankLotteryStreamPlatform {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ BankLotteryStreamPlatform[] $VALUES;
    public static final BankLotteryStreamPlatform YOUTUBE = new BankLotteryStreamPlatform("YOUTUBE", 0);
    public static final BankLotteryStreamPlatform VK = new BankLotteryStreamPlatform("VK", 1);
    public static final BankLotteryStreamPlatform TWITCH = new BankLotteryStreamPlatform("TWITCH", 2);

    private static final /* synthetic */ BankLotteryStreamPlatform[] $values() {
        return new BankLotteryStreamPlatform[]{YOUTUBE, VK, TWITCH};
    }

    public static EnumEntries<BankLotteryStreamPlatform> getEntries() {
        return $ENTRIES;
    }

    public static BankLotteryStreamPlatform valueOf(String str) {
        return (BankLotteryStreamPlatform) Enum.valueOf(BankLotteryStreamPlatform.class, str);
    }

    public static BankLotteryStreamPlatform[] values() {
        return (BankLotteryStreamPlatform[]) $VALUES.clone();
    }

    private BankLotteryStreamPlatform(String str, int i) {
    }

    static {
        BankLotteryStreamPlatform[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
