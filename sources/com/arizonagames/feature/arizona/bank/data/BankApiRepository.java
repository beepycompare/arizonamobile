package com.arizonagames.feature.arizona.bank.data;

import com.arizonagames.feature.arizona.bank.BankAccountHistoryApiItem;
import com.arizonagames.feature.arizona.bank.BankCurrencyHistoryPayload;
import com.arizonagames.feature.arizona.bank.BankDepositHistoryApiItem;
import com.arizonagames.feature.arizona.bank.BankLotteryRewardInfo;
import com.arizonagames.feature.arizona.bank.BankOrganizationHistoryApiItem;
import com.arizonagames.feature.arizona.bank.data.remote.BankApiService;
import com.google.gson.JsonElement;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: BankApiRepository.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0086@¢\u0006\u0002\u0010\tJ\u000e\u0010\n\u001a\u00020\u000bH\u0086@¢\u0006\u0002\u0010\tJ\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\u0086@¢\u0006\u0002\u0010\u0010J\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0007H\u0086@¢\u0006\u0002\u0010\tJ\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0007H\u0086@¢\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/arizonagames/feature/arizona/bank/data/BankApiRepository;", "", "apiService", "Lcom/arizonagames/feature/arizona/bank/data/remote/BankApiService;", "<init>", "(Lcom/arizonagames/feature/arizona/bank/data/remote/BankApiService;)V", "getGiveawayPrizes", "", "Lcom/arizonagames/feature/arizona/bank/BankLotteryRewardInfo;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCurrencyHistory", "Lcom/arizonagames/feature/arizona/bank/BankCurrencyHistoryPayload;", "getAccountHistory", "Lcom/arizonagames/feature/arizona/bank/BankAccountHistoryApiItem;", "accountNumber", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getDepositHistory", "Lcom/arizonagames/feature/arizona/bank/BankDepositHistoryApiItem;", "getOrganizationHistory", "Lcom/arizonagames/feature/arizona/bank/BankOrganizationHistoryApiItem;", "bank"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BankApiRepository {
    private final BankApiService apiService;

    public BankApiRepository(BankApiService apiService) {
        Intrinsics.checkNotNullParameter(apiService, "apiService");
        this.apiService = apiService;
    }

    public final Object getGiveawayPrizes(Continuation<? super List<BankLotteryRewardInfo>> continuation) {
        return this.apiService.getGiveawayPrizes(continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object getCurrencyHistory(Continuation<? super BankCurrencyHistoryPayload> continuation) {
        BankApiRepository$getCurrencyHistory$1 bankApiRepository$getCurrencyHistory$1;
        int i;
        if (continuation instanceof BankApiRepository$getCurrencyHistory$1) {
            bankApiRepository$getCurrencyHistory$1 = (BankApiRepository$getCurrencyHistory$1) continuation;
            if ((bankApiRepository$getCurrencyHistory$1.label & Integer.MIN_VALUE) != 0) {
                bankApiRepository$getCurrencyHistory$1.label -= Integer.MIN_VALUE;
                Object obj = bankApiRepository$getCurrencyHistory$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = bankApiRepository$getCurrencyHistory$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    BankApiService bankApiService = this.apiService;
                    bankApiRepository$getCurrencyHistory$1.label = 1;
                    obj = bankApiService.getCurrencyHistory(bankApiRepository$getCurrencyHistory$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    ResultKt.throwOnFailure(obj);
                }
                return BankApiRepositoryKt.parseCurrencyHistoryPayload((JsonElement) obj);
            }
        }
        bankApiRepository$getCurrencyHistory$1 = new BankApiRepository$getCurrencyHistory$1(this, continuation);
        Object obj2 = bankApiRepository$getCurrencyHistory$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = bankApiRepository$getCurrencyHistory$1.label;
        if (i != 0) {
        }
        return BankApiRepositoryKt.parseCurrencyHistoryPayload((JsonElement) obj2);
    }

    public final Object getAccountHistory(int i, Continuation<? super List<BankAccountHistoryApiItem>> continuation) {
        return BankApiService.getAccountHistory$default(this.apiService, Boxing.boxInt(i), 0, 0, continuation, 6, null);
    }

    public final Object getDepositHistory(Continuation<? super List<BankDepositHistoryApiItem>> continuation) {
        return BankApiService.getDepositHistory$default(this.apiService, 0, 0, continuation, 3, null);
    }

    public final Object getOrganizationHistory(Continuation<? super List<BankOrganizationHistoryApiItem>> continuation) {
        return BankApiService.getOrganizationHistory$default(this.apiService, 0, 0, continuation, 3, null);
    }
}
