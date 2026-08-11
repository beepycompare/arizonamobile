package com.arizonagames.feature.arizona.bank;

import android.content.Context;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: BankContract.kt */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0003\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0004\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0005\u001a\u00020\u0001*\u00020\u0006H\u0000\u001a\u0014\u0010\u0007\u001a\u00020\b*\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0000¨\u0006\f"}, d2 = {"hasOpenedBankAccount", "", "Lcom/arizonagames/feature/arizona/bank/BankScreenPayload;", "requiresBankAccountSetup", "hasLotteryPage", "isAvailable", "Lcom/arizonagames/feature/arizona/bank/BankLotteryInfo;", "resolveTitle", "", "Lcom/arizonagames/feature/arizona/bank/BankPage;", "context", "Landroid/content/Context;", "bank"}, k = 2, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BankContractKt {
    public static final boolean hasOpenedBankAccount(BankScreenPayload bankScreenPayload) {
        Intrinsics.checkNotNullParameter(bankScreenPayload, "<this>");
        List<BankAccountInfo> bankAccounts = bankScreenPayload.getBankAccounts();
        if ((bankAccounts instanceof Collection) && bankAccounts.isEmpty()) {
            return false;
        }
        for (BankAccountInfo bankAccountInfo : bankAccounts) {
            if (bankAccountInfo.isOpened()) {
                return true;
            }
        }
        return false;
    }

    public static final boolean requiresBankAccountSetup(BankScreenPayload bankScreenPayload) {
        Intrinsics.checkNotNullParameter(bankScreenPayload, "<this>");
        return !hasOpenedBankAccount(bankScreenPayload);
    }

    public static final boolean hasLotteryPage(BankScreenPayload bankScreenPayload) {
        Intrinsics.checkNotNullParameter(bankScreenPayload, "<this>");
        BankLotteryInfo lottery = bankScreenPayload.getLottery();
        return lottery != null && lottery.getVisible();
    }

    public static final boolean isAvailable(BankLotteryInfo bankLotteryInfo) {
        Intrinsics.checkNotNullParameter(bankLotteryInfo, "<this>");
        return bankLotteryInfo.getVisible();
    }

    public static final String resolveTitle(BankPage bankPage, Context context) {
        Intrinsics.checkNotNullParameter(bankPage, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        if (bankPage.getTitleResId() != 0) {
            String string = context.getString(bankPage.getTitleResId());
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            return string;
        }
        return bankPage.getTitle();
    }
}
