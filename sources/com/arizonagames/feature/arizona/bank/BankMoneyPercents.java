package com.arizonagames.feature.arizona.bank;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: BankContract.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/arizonagames/feature/arizona/bank/BankMoneyPercents;", "", "withdraw", "", "deposit", "transfer", "<init>", "(III)V", "getWithdraw", "()I", "getDeposit", "getTransfer", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "bank"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BankMoneyPercents {
    private final int deposit;
    private final int transfer;
    private final int withdraw;

    public BankMoneyPercents() {
        this(0, 0, 0, 7, null);
    }

    public static /* synthetic */ BankMoneyPercents copy$default(BankMoneyPercents bankMoneyPercents, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = bankMoneyPercents.withdraw;
        }
        if ((i4 & 2) != 0) {
            i2 = bankMoneyPercents.deposit;
        }
        if ((i4 & 4) != 0) {
            i3 = bankMoneyPercents.transfer;
        }
        return bankMoneyPercents.copy(i, i2, i3);
    }

    public final int component1() {
        return this.withdraw;
    }

    public final int component2() {
        return this.deposit;
    }

    public final int component3() {
        return this.transfer;
    }

    public final BankMoneyPercents copy(int i, int i2, int i3) {
        return new BankMoneyPercents(i, i2, i3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BankMoneyPercents) {
            BankMoneyPercents bankMoneyPercents = (BankMoneyPercents) obj;
            return this.withdraw == bankMoneyPercents.withdraw && this.deposit == bankMoneyPercents.deposit && this.transfer == bankMoneyPercents.transfer;
        }
        return false;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.withdraw) * 31) + Integer.hashCode(this.deposit)) * 31) + Integer.hashCode(this.transfer);
    }

    public String toString() {
        int i = this.withdraw;
        int i2 = this.deposit;
        return "BankMoneyPercents(withdraw=" + i + ", deposit=" + i2 + ", transfer=" + this.transfer + ")";
    }

    public BankMoneyPercents(int i, int i2, int i3) {
        this.withdraw = i;
        this.deposit = i2;
        this.transfer = i3;
    }

    public /* synthetic */ BankMoneyPercents(int i, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 0 : i, (i4 & 2) != 0 ? 0 : i2, (i4 & 4) != 0 ? 0 : i3);
    }

    public final int getWithdraw() {
        return this.withdraw;
    }

    public final int getDeposit() {
        return this.deposit;
    }

    public final int getTransfer() {
        return this.transfer;
    }
}
