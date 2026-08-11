package com.arizonagames.feature.arizona.bank;

import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* compiled from: BankLotteryResultState.kt */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a(\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0000\u001a\u001a\u0010\t\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0000\u001a\u0016\u0010\u000b\u001a\u00020\n2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0000¨\u0006\f"}, d2 = {"resolveBankLotteryResultState", "Lcom/arizonagames/feature/arizona/bank/BankLotteryResultState;", "lottery", "Lcom/arizonagames/feature/arizona/bank/BankLotteryInfo;", "prizes", "", "Lcom/arizonagames/feature/arizona/bank/BankLotteryRewardInfo;", "nowEpochSeconds", "", "hasBankLotteryEnded", "", "hasAllBankLotteryWinners", "bank"}, k = 2, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BankLotteryResultStateKt {
    public static /* synthetic */ BankLotteryResultState resolveBankLotteryResultState$default(BankLotteryInfo bankLotteryInfo, List list, long j, int i, Object obj) {
        if ((i & 4) != 0) {
            j = System.currentTimeMillis() / 1000;
        }
        return resolveBankLotteryResultState(bankLotteryInfo, list, j);
    }

    public static final BankLotteryResultState resolveBankLotteryResultState(BankLotteryInfo lottery, List<BankLotteryRewardInfo> prizes, long j) {
        Intrinsics.checkNotNullParameter(lottery, "lottery");
        Intrinsics.checkNotNullParameter(prizes, "prizes");
        if (!hasBankLotteryEnded(lottery, j)) {
            return BankLotteryResultState.ACTIVE;
        }
        if (hasAllBankLotteryWinners(prizes)) {
            return BankLotteryResultState.FINISHED;
        }
        return BankLotteryResultState.AWAITING_RESULTS;
    }

    public static /* synthetic */ boolean hasBankLotteryEnded$default(BankLotteryInfo bankLotteryInfo, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = System.currentTimeMillis() / 1000;
        }
        return hasBankLotteryEnded(bankLotteryInfo, j);
    }

    public static final boolean hasBankLotteryEnded(BankLotteryInfo lottery, long j) {
        Intrinsics.checkNotNullParameter(lottery, "lottery");
        if (lottery.getActiveState()) {
            return lottery.getEndTime() > 0 && lottery.getEndTime() <= j;
        }
        return true;
    }

    public static final boolean hasAllBankLotteryWinners(List<BankLotteryRewardInfo> prizes) {
        boolean z;
        Intrinsics.checkNotNullParameter(prizes, "prizes");
        if (prizes.isEmpty()) {
            return false;
        }
        List<BankLotteryRewardInfo> list = prizes;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            for (BankLotteryRewardInfo bankLotteryRewardInfo : list) {
                String winner = bankLotteryRewardInfo.getWinner();
                if (winner == null || StringsKt.isBlank(winner)) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (z) {
                    return false;
                }
            }
        }
        return true;
    }
}
