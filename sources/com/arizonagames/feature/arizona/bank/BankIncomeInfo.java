package com.arizonagames.feature.arizona.bank;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: BankContract.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J1\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0014\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001c\u001a\u00020\u001dHÖ\u0081\u0004J\n\u0010\u001e\u001a\u00020\u001fHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR3\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004\u0092\u0002\u001a\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0006\u0012\f\b\u0012\u0012\b\b\fJ\u0004\b\b(\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006 "}, d2 = {"Lcom/arizonagames/feature/arizona/bank/BankIncomeInfo;", "", "day", "Lcom/arizonagames/feature/arizona/bank/BankIncomeRangeInfo;", "week", "month", "payDayIncome", "", "<init>", "(Lcom/arizonagames/feature/arizona/bank/BankIncomeRangeInfo;Lcom/arizonagames/feature/arizona/bank/BankIncomeRangeInfo;Lcom/arizonagames/feature/arizona/bank/BankIncomeRangeInfo;J)V", "getDay", "()Lcom/arizonagames/feature/arizona/bank/BankIncomeRangeInfo;", "getWeek", "getMonth", "getPayDayIncome", "()J", "Lcom/google/gson/annotations/SerializedName;", "value", "alternate", "poyDayIncome", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "bank"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BankIncomeInfo {
    private final BankIncomeRangeInfo day;
    private final BankIncomeRangeInfo month;
    @SerializedName(alternate = {"poyDayIncome"}, value = "payDayIncome")
    private final long payDayIncome;
    private final BankIncomeRangeInfo week;

    public BankIncomeInfo() {
        this(null, null, null, 0L, 15, null);
    }

    public static /* synthetic */ BankIncomeInfo copy$default(BankIncomeInfo bankIncomeInfo, BankIncomeRangeInfo bankIncomeRangeInfo, BankIncomeRangeInfo bankIncomeRangeInfo2, BankIncomeRangeInfo bankIncomeRangeInfo3, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            bankIncomeRangeInfo = bankIncomeInfo.day;
        }
        if ((i & 2) != 0) {
            bankIncomeRangeInfo2 = bankIncomeInfo.week;
        }
        if ((i & 4) != 0) {
            bankIncomeRangeInfo3 = bankIncomeInfo.month;
        }
        if ((i & 8) != 0) {
            j = bankIncomeInfo.payDayIncome;
        }
        BankIncomeRangeInfo bankIncomeRangeInfo4 = bankIncomeRangeInfo3;
        return bankIncomeInfo.copy(bankIncomeRangeInfo, bankIncomeRangeInfo2, bankIncomeRangeInfo4, j);
    }

    public final BankIncomeRangeInfo component1() {
        return this.day;
    }

    public final BankIncomeRangeInfo component2() {
        return this.week;
    }

    public final BankIncomeRangeInfo component3() {
        return this.month;
    }

    public final long component4() {
        return this.payDayIncome;
    }

    public final BankIncomeInfo copy(BankIncomeRangeInfo day, BankIncomeRangeInfo week, BankIncomeRangeInfo month, long j) {
        Intrinsics.checkNotNullParameter(day, "day");
        Intrinsics.checkNotNullParameter(week, "week");
        Intrinsics.checkNotNullParameter(month, "month");
        return new BankIncomeInfo(day, week, month, j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BankIncomeInfo) {
            BankIncomeInfo bankIncomeInfo = (BankIncomeInfo) obj;
            return Intrinsics.areEqual(this.day, bankIncomeInfo.day) && Intrinsics.areEqual(this.week, bankIncomeInfo.week) && Intrinsics.areEqual(this.month, bankIncomeInfo.month) && this.payDayIncome == bankIncomeInfo.payDayIncome;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.day.hashCode() * 31) + this.week.hashCode()) * 31) + this.month.hashCode()) * 31) + Long.hashCode(this.payDayIncome);
    }

    public String toString() {
        BankIncomeRangeInfo bankIncomeRangeInfo = this.day;
        BankIncomeRangeInfo bankIncomeRangeInfo2 = this.week;
        BankIncomeRangeInfo bankIncomeRangeInfo3 = this.month;
        return "BankIncomeInfo(day=" + bankIncomeRangeInfo + ", week=" + bankIncomeRangeInfo2 + ", month=" + bankIncomeRangeInfo3 + ", payDayIncome=" + this.payDayIncome + ")";
    }

    public BankIncomeInfo(BankIncomeRangeInfo day, BankIncomeRangeInfo week, BankIncomeRangeInfo month, long j) {
        Intrinsics.checkNotNullParameter(day, "day");
        Intrinsics.checkNotNullParameter(week, "week");
        Intrinsics.checkNotNullParameter(month, "month");
        this.day = day;
        this.week = week;
        this.month = month;
        this.payDayIncome = j;
    }

    public /* synthetic */ BankIncomeInfo(BankIncomeRangeInfo bankIncomeRangeInfo, BankIncomeRangeInfo bankIncomeRangeInfo2, BankIncomeRangeInfo bankIncomeRangeInfo3, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new BankIncomeRangeInfo(0L, null, 3, null) : bankIncomeRangeInfo, (i & 2) != 0 ? new BankIncomeRangeInfo(0L, null, 3, null) : bankIncomeRangeInfo2, (i & 4) != 0 ? new BankIncomeRangeInfo(0L, null, 3, null) : bankIncomeRangeInfo3, (i & 8) != 0 ? 0L : j);
    }

    public final BankIncomeRangeInfo getDay() {
        return this.day;
    }

    public final BankIncomeRangeInfo getWeek() {
        return this.week;
    }

    public final BankIncomeRangeInfo getMonth() {
        return this.month;
    }

    public final long getPayDayIncome() {
        return this.payDayIncome;
    }
}
