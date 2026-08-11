package com.arizonagames.feature.arizona.bank;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: BankContract.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\r\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u000e\u001a\u00020\u000fHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/arizonagames/feature/arizona/bank/BankRetirementPercents;", "", "withdraw", "", "<init>", "(I)V", "getWithdraw", "()I", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "bank"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BankRetirementPercents {
    private final int withdraw;

    public BankRetirementPercents() {
        this(0, 1, null);
    }

    public static /* synthetic */ BankRetirementPercents copy$default(BankRetirementPercents bankRetirementPercents, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = bankRetirementPercents.withdraw;
        }
        return bankRetirementPercents.copy(i);
    }

    public final int component1() {
        return this.withdraw;
    }

    public final BankRetirementPercents copy(int i) {
        return new BankRetirementPercents(i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof BankRetirementPercents) && this.withdraw == ((BankRetirementPercents) obj).withdraw;
    }

    public int hashCode() {
        return Integer.hashCode(this.withdraw);
    }

    public String toString() {
        return "BankRetirementPercents(withdraw=" + this.withdraw + ")";
    }

    public BankRetirementPercents(int i) {
        this.withdraw = i;
    }

    public /* synthetic */ BankRetirementPercents(int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i);
    }

    public final int getWithdraw() {
        return this.withdraw;
    }
}
