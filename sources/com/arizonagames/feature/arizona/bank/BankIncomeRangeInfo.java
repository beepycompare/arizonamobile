package com.arizonagames.feature.arizona.bank;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: BankContract.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/arizonagames/feature/arizona/bank/BankIncomeRangeInfo;", "", "money", "", "history", "", "<init>", "(JLjava/util/List;)V", "getMoney", "()J", "getHistory", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "bank"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BankIncomeRangeInfo {
    private final List<Long> history;
    private final long money;

    public BankIncomeRangeInfo() {
        this(0L, null, 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BankIncomeRangeInfo copy$default(BankIncomeRangeInfo bankIncomeRangeInfo, long j, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            j = bankIncomeRangeInfo.money;
        }
        if ((i & 2) != 0) {
            list = bankIncomeRangeInfo.history;
        }
        return bankIncomeRangeInfo.copy(j, list);
    }

    public final long component1() {
        return this.money;
    }

    public final List<Long> component2() {
        return this.history;
    }

    public final BankIncomeRangeInfo copy(long j, List<Long> history) {
        Intrinsics.checkNotNullParameter(history, "history");
        return new BankIncomeRangeInfo(j, history);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BankIncomeRangeInfo) {
            BankIncomeRangeInfo bankIncomeRangeInfo = (BankIncomeRangeInfo) obj;
            return this.money == bankIncomeRangeInfo.money && Intrinsics.areEqual(this.history, bankIncomeRangeInfo.history);
        }
        return false;
    }

    public int hashCode() {
        return (Long.hashCode(this.money) * 31) + this.history.hashCode();
    }

    public String toString() {
        long j = this.money;
        return "BankIncomeRangeInfo(money=" + j + ", history=" + this.history + ")";
    }

    public BankIncomeRangeInfo(long j, List<Long> history) {
        Intrinsics.checkNotNullParameter(history, "history");
        this.money = j;
        this.history = history;
    }

    public final long getMoney() {
        return this.money;
    }

    public /* synthetic */ BankIncomeRangeInfo(long j, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j, (i & 2) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final List<Long> getHistory() {
        return this.history;
    }
}
