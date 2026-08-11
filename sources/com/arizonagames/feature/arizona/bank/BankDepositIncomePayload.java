package com.arizonagames.feature.arizona.bank;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: BankContract.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\r\u001a\u00020\u000eHÖ\u0081\u0004J\n\u0010\u000f\u001a\u00020\u0010HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/arizonagames/feature/arizona/bank/BankDepositIncomePayload;", "", "income", "Lcom/arizonagames/feature/arizona/bank/BankIncomeInfo;", "<init>", "(Lcom/arizonagames/feature/arizona/bank/BankIncomeInfo;)V", "getIncome", "()Lcom/arizonagames/feature/arizona/bank/BankIncomeInfo;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "bank"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BankDepositIncomePayload {
    private final BankIncomeInfo income;

    public BankDepositIncomePayload() {
        this(null, 1, null);
    }

    public static /* synthetic */ BankDepositIncomePayload copy$default(BankDepositIncomePayload bankDepositIncomePayload, BankIncomeInfo bankIncomeInfo, int i, Object obj) {
        if ((i & 1) != 0) {
            bankIncomeInfo = bankDepositIncomePayload.income;
        }
        return bankDepositIncomePayload.copy(bankIncomeInfo);
    }

    public final BankIncomeInfo component1() {
        return this.income;
    }

    public final BankDepositIncomePayload copy(BankIncomeInfo bankIncomeInfo) {
        return new BankDepositIncomePayload(bankIncomeInfo);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof BankDepositIncomePayload) && Intrinsics.areEqual(this.income, ((BankDepositIncomePayload) obj).income);
    }

    public int hashCode() {
        BankIncomeInfo bankIncomeInfo = this.income;
        if (bankIncomeInfo == null) {
            return 0;
        }
        return bankIncomeInfo.hashCode();
    }

    public String toString() {
        return "BankDepositIncomePayload(income=" + this.income + ")";
    }

    public BankDepositIncomePayload(BankIncomeInfo bankIncomeInfo) {
        this.income = bankIncomeInfo;
    }

    public /* synthetic */ BankDepositIncomePayload(BankIncomeInfo bankIncomeInfo, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : bankIncomeInfo);
    }

    public final BankIncomeInfo getIncome() {
        return this.income;
    }
}
