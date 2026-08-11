package com.arizonagames.feature.arizona.bank;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: BankContract.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/arizonagames/feature/arizona/bank/BankDepositDisabledTime;", "", "withdraw", "", "deposit", "upgrade", "<init>", "(III)V", "getWithdraw", "()I", "getDeposit", "getUpgrade", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "bank"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BankDepositDisabledTime {
    private final int deposit;
    private final int upgrade;
    private final int withdraw;

    public BankDepositDisabledTime() {
        this(0, 0, 0, 7, null);
    }

    public static /* synthetic */ BankDepositDisabledTime copy$default(BankDepositDisabledTime bankDepositDisabledTime, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = bankDepositDisabledTime.withdraw;
        }
        if ((i4 & 2) != 0) {
            i2 = bankDepositDisabledTime.deposit;
        }
        if ((i4 & 4) != 0) {
            i3 = bankDepositDisabledTime.upgrade;
        }
        return bankDepositDisabledTime.copy(i, i2, i3);
    }

    public final int component1() {
        return this.withdraw;
    }

    public final int component2() {
        return this.deposit;
    }

    public final int component3() {
        return this.upgrade;
    }

    public final BankDepositDisabledTime copy(int i, int i2, int i3) {
        return new BankDepositDisabledTime(i, i2, i3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BankDepositDisabledTime) {
            BankDepositDisabledTime bankDepositDisabledTime = (BankDepositDisabledTime) obj;
            return this.withdraw == bankDepositDisabledTime.withdraw && this.deposit == bankDepositDisabledTime.deposit && this.upgrade == bankDepositDisabledTime.upgrade;
        }
        return false;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.withdraw) * 31) + Integer.hashCode(this.deposit)) * 31) + Integer.hashCode(this.upgrade);
    }

    public String toString() {
        int i = this.withdraw;
        int i2 = this.deposit;
        return "BankDepositDisabledTime(withdraw=" + i + ", deposit=" + i2 + ", upgrade=" + this.upgrade + ")";
    }

    public BankDepositDisabledTime(int i, int i2, int i3) {
        this.withdraw = i;
        this.deposit = i2;
        this.upgrade = i3;
    }

    public /* synthetic */ BankDepositDisabledTime(int i, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 0 : i, (i4 & 2) != 0 ? 0 : i2, (i4 & 4) != 0 ? 0 : i3);
    }

    public final int getWithdraw() {
        return this.withdraw;
    }

    public final int getDeposit() {
        return this.deposit;
    }

    public final int getUpgrade() {
        return this.upgrade;
    }
}
