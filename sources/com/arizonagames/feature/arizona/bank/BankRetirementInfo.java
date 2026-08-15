package com.arizonagames.feature.arizona.bank;

import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: BankContract.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J1\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0014\u0010\u001a\u001a\u00020\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001c\u001a\u00020\u001dHÖ\u0081\u0004J\n\u0010\u001e\u001a\u00020\u001fHÖ\u0081\u0004R%\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\r\u0012\b\b\u000e\u0012\u0004\b\t0\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006 "}, d2 = {"Lcom/arizonagames/feature/arizona/bank/BankRetirementInfo;", "", "status", "", "buyCost", "", "money", "percents", "Lcom/arizonagames/feature/arizona/bank/BankRetirementPercents;", "<init>", "(ZJJLcom/arizonagames/feature/arizona/bank/BankRetirementPercents;)V", "getStatus", "()Z", "Lcom/google/gson/annotations/JsonAdapter;", "value", "Lcom/arizonagames/feature/arizona/bank/BankBooleanJsonAdapter;", "getBuyCost", "()J", "getMoney", "getPercents", "()Lcom/arizonagames/feature/arizona/bank/BankRetirementPercents;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "", "bank"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BankRetirementInfo {
    private final long buyCost;
    private final long money;
    private final BankRetirementPercents percents;
    @JsonAdapter(BankBooleanJsonAdapter.class)
    private final boolean status;

    public BankRetirementInfo() {
        this(false, 0L, 0L, null, 15, null);
    }

    public static /* synthetic */ BankRetirementInfo copy$default(BankRetirementInfo bankRetirementInfo, boolean z, long j, long j2, BankRetirementPercents bankRetirementPercents, int i, Object obj) {
        if ((i & 1) != 0) {
            z = bankRetirementInfo.status;
        }
        if ((i & 2) != 0) {
            j = bankRetirementInfo.buyCost;
        }
        if ((i & 4) != 0) {
            j2 = bankRetirementInfo.money;
        }
        if ((i & 8) != 0) {
            bankRetirementPercents = bankRetirementInfo.percents;
        }
        BankRetirementPercents bankRetirementPercents2 = bankRetirementPercents;
        return bankRetirementInfo.copy(z, j, j2, bankRetirementPercents2);
    }

    public final boolean component1() {
        return this.status;
    }

    public final long component2() {
        return this.buyCost;
    }

    public final long component3() {
        return this.money;
    }

    public final BankRetirementPercents component4() {
        return this.percents;
    }

    public final BankRetirementInfo copy(boolean z, long j, long j2, BankRetirementPercents percents) {
        Intrinsics.checkNotNullParameter(percents, "percents");
        return new BankRetirementInfo(z, j, j2, percents);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BankRetirementInfo) {
            BankRetirementInfo bankRetirementInfo = (BankRetirementInfo) obj;
            return this.status == bankRetirementInfo.status && this.buyCost == bankRetirementInfo.buyCost && this.money == bankRetirementInfo.money && Intrinsics.areEqual(this.percents, bankRetirementInfo.percents);
        }
        return false;
    }

    public int hashCode() {
        return (((((Boolean.hashCode(this.status) * 31) + Long.hashCode(this.buyCost)) * 31) + Long.hashCode(this.money)) * 31) + this.percents.hashCode();
    }

    public String toString() {
        boolean z = this.status;
        long j = this.buyCost;
        long j2 = this.money;
        return "BankRetirementInfo(status=" + z + ", buyCost=" + j + ", money=" + j2 + ", percents=" + this.percents + ")";
    }

    public BankRetirementInfo(boolean z, long j, long j2, BankRetirementPercents percents) {
        Intrinsics.checkNotNullParameter(percents, "percents");
        this.status = z;
        this.buyCost = j;
        this.money = j2;
        this.percents = percents;
    }

    public final boolean getStatus() {
        return this.status;
    }

    public final long getBuyCost() {
        return this.buyCost;
    }

    public final long getMoney() {
        return this.money;
    }

    public /* synthetic */ BankRetirementInfo(boolean z, long j, long j2, BankRetirementPercents bankRetirementPercents, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? 0L : j, (i & 4) != 0 ? 0L : j2, (i & 8) != 0 ? new BankRetirementPercents(0, 1, null) : bankRetirementPercents);
    }

    public final BankRetirementPercents getPercents() {
        return this.percents;
    }
}
