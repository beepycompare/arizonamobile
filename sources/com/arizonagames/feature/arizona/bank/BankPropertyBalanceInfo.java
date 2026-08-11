package com.arizonagames.feature.arizona.bank;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: BankContract.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0003J-\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0001J\u0014\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0017\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0019HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/arizonagames/feature/arizona/bank/BankPropertyBalanceInfo;", "", "id", "", "money", "", "percents", "", "<init>", "(IJLjava/util/List;)V", "getId", "()I", "getMoney", "()J", "getPercents", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "bank"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BankPropertyBalanceInfo {
    private final int id;
    private final long money;
    private final List<Integer> percents;

    public BankPropertyBalanceInfo() {
        this(0, 0L, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BankPropertyBalanceInfo copy$default(BankPropertyBalanceInfo bankPropertyBalanceInfo, int i, long j, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = bankPropertyBalanceInfo.id;
        }
        if ((i2 & 2) != 0) {
            j = bankPropertyBalanceInfo.money;
        }
        if ((i2 & 4) != 0) {
            list = bankPropertyBalanceInfo.percents;
        }
        return bankPropertyBalanceInfo.copy(i, j, list);
    }

    public final int component1() {
        return this.id;
    }

    public final long component2() {
        return this.money;
    }

    public final List<Integer> component3() {
        return this.percents;
    }

    public final BankPropertyBalanceInfo copy(int i, long j, List<Integer> percents) {
        Intrinsics.checkNotNullParameter(percents, "percents");
        return new BankPropertyBalanceInfo(i, j, percents);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BankPropertyBalanceInfo) {
            BankPropertyBalanceInfo bankPropertyBalanceInfo = (BankPropertyBalanceInfo) obj;
            return this.id == bankPropertyBalanceInfo.id && this.money == bankPropertyBalanceInfo.money && Intrinsics.areEqual(this.percents, bankPropertyBalanceInfo.percents);
        }
        return false;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.id) * 31) + Long.hashCode(this.money)) * 31) + this.percents.hashCode();
    }

    public String toString() {
        int i = this.id;
        long j = this.money;
        return "BankPropertyBalanceInfo(id=" + i + ", money=" + j + ", percents=" + this.percents + ")";
    }

    public BankPropertyBalanceInfo(int i, long j, List<Integer> percents) {
        Intrinsics.checkNotNullParameter(percents, "percents");
        this.id = i;
        this.money = j;
        this.percents = percents;
    }

    public final int getId() {
        return this.id;
    }

    public final long getMoney() {
        return this.money;
    }

    public /* synthetic */ BankPropertyBalanceInfo(int i, long j, List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? 0L : j, (i2 & 4) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final List<Integer> getPercents() {
        return this.percents;
    }
}
