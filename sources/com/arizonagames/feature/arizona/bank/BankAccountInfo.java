package com.arizonagames.feature.arizona.bank;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: BankContract.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\nB/\b\u0016\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\fJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÂ\u0003¢\u0006\u0002\u0010\u001cJ\t\u0010\u001d\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J8\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001¢\u0006\u0002\u0010 J\u0014\u0010!\u001a\u00020\u00182\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010#\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010$\u001a\u00020%HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR#\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0002X\u0083\u0004\u0092\u0002\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u000b¢\u0006\u0004\n\u0002\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\u0017\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0019¨\u0006&"}, d2 = {"Lcom/arizonagames/feature/arizona/bank/BankAccountInfo;", "", "id", "", "rawMoney", "", "percents", "Lcom/arizonagames/feature/arizona/bank/BankMoneyPercents;", "buyCost", "<init>", "(ILjava/lang/Long;Lcom/arizonagames/feature/arizona/bank/BankMoneyPercents;J)V", "money", "(IJLcom/arizonagames/feature/arizona/bank/BankMoneyPercents;J)V", "getId", "()I", "Ljava/lang/Long;", "Lcom/google/gson/annotations/SerializedName;", "value", "getPercents", "()Lcom/arizonagames/feature/arizona/bank/BankMoneyPercents;", "getBuyCost", "()J", "getMoney", "isOpened", "", "()Z", "component1", "component2", "()Ljava/lang/Long;", "component3", "component4", "copy", "(ILjava/lang/Long;Lcom/arizonagames/feature/arizona/bank/BankMoneyPercents;J)Lcom/arizonagames/feature/arizona/bank/BankAccountInfo;", "equals", "other", "hashCode", "toString", "", "bank"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BankAccountInfo {
    private final long buyCost;
    private final int id;
    private final BankMoneyPercents percents;
    @SerializedName("money")
    private final Long rawMoney;

    public BankAccountInfo() {
        this(0, (Long) null, (BankMoneyPercents) null, 0L, 15, (DefaultConstructorMarker) null);
    }

    private final Long component2() {
        return this.rawMoney;
    }

    public static /* synthetic */ BankAccountInfo copy$default(BankAccountInfo bankAccountInfo, int i, Long l, BankMoneyPercents bankMoneyPercents, long j, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = bankAccountInfo.id;
        }
        if ((i2 & 2) != 0) {
            l = bankAccountInfo.rawMoney;
        }
        if ((i2 & 4) != 0) {
            bankMoneyPercents = bankAccountInfo.percents;
        }
        if ((i2 & 8) != 0) {
            j = bankAccountInfo.buyCost;
        }
        BankMoneyPercents bankMoneyPercents2 = bankMoneyPercents;
        return bankAccountInfo.copy(i, l, bankMoneyPercents2, j);
    }

    public final int component1() {
        return this.id;
    }

    public final BankMoneyPercents component3() {
        return this.percents;
    }

    public final long component4() {
        return this.buyCost;
    }

    public final BankAccountInfo copy(int i, Long l, BankMoneyPercents percents, long j) {
        Intrinsics.checkNotNullParameter(percents, "percents");
        return new BankAccountInfo(i, l, percents, j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BankAccountInfo) {
            BankAccountInfo bankAccountInfo = (BankAccountInfo) obj;
            return this.id == bankAccountInfo.id && Intrinsics.areEqual(this.rawMoney, bankAccountInfo.rawMoney) && Intrinsics.areEqual(this.percents, bankAccountInfo.percents) && this.buyCost == bankAccountInfo.buyCost;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = Integer.hashCode(this.id) * 31;
        Long l = this.rawMoney;
        return ((((hashCode + (l == null ? 0 : l.hashCode())) * 31) + this.percents.hashCode()) * 31) + Long.hashCode(this.buyCost);
    }

    public String toString() {
        int i = this.id;
        Long l = this.rawMoney;
        BankMoneyPercents bankMoneyPercents = this.percents;
        return "BankAccountInfo(id=" + i + ", rawMoney=" + l + ", percents=" + bankMoneyPercents + ", buyCost=" + this.buyCost + ")";
    }

    public BankAccountInfo(int i, Long l, BankMoneyPercents percents, long j) {
        Intrinsics.checkNotNullParameter(percents, "percents");
        this.id = i;
        this.rawMoney = l;
        this.percents = percents;
        this.buyCost = j;
    }

    public final int getId() {
        return this.id;
    }

    public /* synthetic */ BankAccountInfo(int i, Long l, BankMoneyPercents bankMoneyPercents, long j, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? null : l, (i2 & 4) != 0 ? new BankMoneyPercents(0, 0, 0, 7, null) : bankMoneyPercents, (i2 & 8) != 0 ? 0L : j);
    }

    public final BankMoneyPercents getPercents() {
        return this.percents;
    }

    public final long getBuyCost() {
        return this.buyCost;
    }

    public /* synthetic */ BankAccountInfo(int i, long j, BankMoneyPercents bankMoneyPercents, long j2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, j, (i2 & 4) != 0 ? new BankMoneyPercents(0, 0, 0, 7, null) : bankMoneyPercents, (i2 & 8) != 0 ? 0L : j2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BankAccountInfo(int i, long j, BankMoneyPercents percents, long j2) {
        this(i, Long.valueOf(j), percents, j2);
        Intrinsics.checkNotNullParameter(percents, "percents");
    }

    public final long getMoney() {
        Long l = this.rawMoney;
        if (l != null) {
            return l.longValue();
        }
        return 0L;
    }

    public final boolean isOpened() {
        return this.rawMoney != null;
    }
}
