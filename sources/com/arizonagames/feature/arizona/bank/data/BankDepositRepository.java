package com.arizonagames.feature.arizona.bank.data;

import com.arizonagames.feature.arizona.bank.BankDepositIncomePayload;
import com.arizonagames.feature.arizona.bank.data.remote.BankApiService;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: BankDepositRepository.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u0007H\u0086@¢\u0006\u0002\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/arizonagames/feature/arizona/bank/data/BankDepositRepository;", "", "apiService", "Lcom/arizonagames/feature/arizona/bank/data/remote/BankApiService;", "<init>", "(Lcom/arizonagames/feature/arizona/bank/data/remote/BankApiService;)V", "getDepositIncome", "Lcom/arizonagames/feature/arizona/bank/BankDepositIncomePayload;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "bank"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BankDepositRepository {
    private final BankApiService apiService;

    public BankDepositRepository(BankApiService apiService) {
        Intrinsics.checkNotNullParameter(apiService, "apiService");
        this.apiService = apiService;
    }

    public final Object getDepositIncome(Continuation<? super BankDepositIncomePayload> continuation) {
        return this.apiService.getDepositIncome(continuation);
    }
}
