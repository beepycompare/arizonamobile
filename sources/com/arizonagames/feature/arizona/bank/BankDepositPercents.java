package com.arizonagames.feature.arizona.bank;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: BankContract.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0011\u001a\u00020\u0012HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/arizonagames/feature/arizona/bank/BankDepositPercents;", "", "withdraw", "", "deposit", "<init>", "(II)V", "getWithdraw", "()I", "getDeposit", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "bank"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BankDepositPercents {
    private final int deposit;
    private final int withdraw;

    public BankDepositPercents() {
        this(0, 0, 3, null);
    }

    public static /* synthetic */ BankDepositPercents copy$default(BankDepositPercents bankDepositPercents, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = bankDepositPercents.withdraw;
        }
        if ((i3 & 2) != 0) {
            i2 = bankDepositPercents.deposit;
        }
        return bankDepositPercents.copy(i, i2);
    }

    public final int component1() {
        return this.withdraw;
    }

    public final int component2() {
        return this.deposit;
    }

    public final BankDepositPercents copy(int i, int i2) {
        return new BankDepositPercents(i, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BankDepositPercents) {
            BankDepositPercents bankDepositPercents = (BankDepositPercents) obj;
            return this.withdraw == bankDepositPercents.withdraw && this.deposit == bankDepositPercents.deposit;
        }
        return false;
    }

    public int hashCode() {
        return (Integer.hashCode(this.withdraw) * 31) + Integer.hashCode(this.deposit);
    }

    public String toString() {
        int i = this.withdraw;
        return "BankDepositPercents(withdraw=" + i + ", deposit=" + this.deposit + ")";
    }

    public BankDepositPercents(int i, int i2) {
        this.withdraw = i;
        this.deposit = i2;
    }

    public /* synthetic */ BankDepositPercents(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2);
    }

    public final int getWithdraw() {
        return this.withdraw;
    }

    public final int getDeposit() {
        return this.deposit;
    }
}
