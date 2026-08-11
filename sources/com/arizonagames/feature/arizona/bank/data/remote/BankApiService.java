package com.arizonagames.feature.arizona.bank.data.remote;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.arizonagames.feature.arizona.bank.BankAccountHistoryApiItem;
import com.arizonagames.feature.arizona.bank.BankApiEndpoints;
import com.arizonagames.feature.arizona.bank.BankDepositHistoryApiItem;
import com.arizonagames.feature.arizona.bank.BankDepositIncomePayload;
import com.arizonagames.feature.arizona.bank.BankLotteryRewardInfo;
import com.arizonagames.feature.arizona.bank.BankOrganizationHistoryApiItem;
import com.google.gson.JsonElement;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.http.GET;
import retrofit2.http.Query;
/* compiled from: BankApiService.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u0000  2\u00020\u0001:\u0001 J\"\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H§@b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b¢\u0006\u0002\u0010\u0005J\u001c\u0010\t\u001a\u00020\nH§@b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000b¢\u0006\u0002\u0010\u0005J\u001c\u0010\f\u001a\u00020\rH§@b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000e¢\u0006\u0002\u0010\u0005Jl\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u00032\u0018\b\u0003\u0010\u0011\u001a\u0004\u0018\u00010\u0012:\f\b\u0013\u0012\b\b\u0007\u0012\u0004\b\b(\u00142\u0016\b\u0003\u0010\u0015\u001a\u00020\u0012:\f\b\u0013\u0012\b\b\u0007\u0012\u0004\b\b(\u00152\u0016\b\u0003\u0010\u0016\u001a\u00020\u0012:\f\b\u0013\u0012\b\b\u0007\u0012\u0004\b\b(\u0016H§@b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0018¢\u0006\u0002\u0010\u0017JR\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00032\u0016\b\u0003\u0010\u0015\u001a\u00020\u0012:\f\b\u0013\u0012\b\b\u0007\u0012\u0004\b\b(\u00152\u0016\b\u0003\u0010\u0016\u001a\u00020\u0012:\f\b\u0013\u0012\b\b\u0007\u0012\u0004\b\b(\u0016H§@b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u001c¢\u0006\u0002\u0010\u001bJR\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00032\u0016\b\u0003\u0010\u0015\u001a\u00020\u0012:\f\b\u0013\u0012\b\b\u0007\u0012\u0004\b\b(\u00152\u0016\b\u0003\u0010\u0016\u001a\u00020\u0012:\f\b\u0013\u0012\b\b\u0007\u0012\u0004\b\b(\u0016H§@b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u001f¢\u0006\u0002\u0010\u001b¨\u0006!À\u0006\u0003"}, d2 = {"Lcom/arizonagames/feature/arizona/bank/data/remote/BankApiService;", "", "getGiveawayPrizes", "", "Lcom/arizonagames/feature/arizona/bank/BankLotteryRewardInfo;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lretrofit2/http/GET;", "value", BankApiEndpoints.GIVEAWAY_PRIZES, "getCurrencyHistory", "Lcom/google/gson/JsonElement;", BankApiEndpoints.CURRENCY_HISTORY, "getDepositIncome", "Lcom/arizonagames/feature/arizona/bank/BankDepositIncomePayload;", BankApiEndpoints.DEPOSIT_INCOME, "getAccountHistory", "Lcom/arizonagames/feature/arizona/bank/BankAccountHistoryApiItem;", "accountNumber", "", "Lretrofit2/http/Query;", "account_number", "limit", TypedValues.CycleType.S_WAVE_OFFSET, "(Ljava/lang/Integer;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", BankApiEndpoints.ACCOUNT_HISTORY, "getDepositHistory", "Lcom/arizonagames/feature/arizona/bank/BankDepositHistoryApiItem;", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", BankApiEndpoints.DEPOSIT_HISTORY, "getOrganizationHistory", "Lcom/arizonagames/feature/arizona/bank/BankOrganizationHistoryApiItem;", BankApiEndpoints.ORGANIZATION_HISTORY, "Companion", "bank"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface BankApiService {
    public static final /* synthetic */ Companion Companion = Companion.$$INSTANCE;
    @Deprecated
    public static final int DEFAULT_HISTORY_LIMIT = 100;
    @Deprecated
    public static final int DEFAULT_HISTORY_OFFSET = 0;

    @GET(BankApiEndpoints.ACCOUNT_HISTORY)
    Object getAccountHistory(@Query("account_number") Integer num, @Query("limit") int i, @Query("offset") int i2, Continuation<? super List<BankAccountHistoryApiItem>> continuation);

    @GET(BankApiEndpoints.CURRENCY_HISTORY)
    Object getCurrencyHistory(Continuation<? super JsonElement> continuation);

    @GET(BankApiEndpoints.DEPOSIT_HISTORY)
    Object getDepositHistory(@Query("limit") int i, @Query("offset") int i2, Continuation<? super List<BankDepositHistoryApiItem>> continuation);

    @GET(BankApiEndpoints.DEPOSIT_INCOME)
    Object getDepositIncome(Continuation<? super BankDepositIncomePayload> continuation);

    @GET(BankApiEndpoints.GIVEAWAY_PRIZES)
    Object getGiveawayPrizes(Continuation<? super List<BankLotteryRewardInfo>> continuation);

    @GET(BankApiEndpoints.ORGANIZATION_HISTORY)
    Object getOrganizationHistory(@Query("limit") int i, @Query("offset") int i2, Continuation<? super List<BankOrganizationHistoryApiItem>> continuation);

    /* compiled from: BankApiService.kt */
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
    }

    static /* synthetic */ Object getAccountHistory$default(BankApiService bankApiService, Integer num, int i, int i2, Continuation continuation, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 1) != 0) {
                num = null;
            }
            if ((i3 & 2) != 0) {
                i = 100;
            }
            if ((i3 & 4) != 0) {
                i2 = 0;
            }
            return bankApiService.getAccountHistory(num, i, i2, continuation);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getAccountHistory");
    }

    static /* synthetic */ Object getDepositHistory$default(BankApiService bankApiService, int i, int i2, Continuation continuation, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 1) != 0) {
                i = 100;
            }
            if ((i3 & 2) != 0) {
                i2 = 0;
            }
            return bankApiService.getDepositHistory(i, i2, continuation);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getDepositHistory");
    }

    static /* synthetic */ Object getOrganizationHistory$default(BankApiService bankApiService, int i, int i2, Continuation continuation, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 1) != 0) {
                i = 100;
            }
            if ((i3 & 2) != 0) {
                i2 = 0;
            }
            return bankApiService.getOrganizationHistory(i, i2, continuation);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getOrganizationHistory");
    }

    /* compiled from: BankApiService.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/arizonagames/feature/arizona/bank/data/remote/BankApiService$Companion;", "", "<init>", "()V", "DEFAULT_HISTORY_LIMIT", "", "DEFAULT_HISTORY_OFFSET", "bank"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int DEFAULT_HISTORY_LIMIT = 100;
        public static final int DEFAULT_HISTORY_OFFSET = 0;

        private Companion() {
        }
    }
}
