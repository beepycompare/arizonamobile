package com.arizonagames.feature.arizona.bank;

import androidx.media3.extractor.text.ttml.TtmlNode;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: BankContract.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BK\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003JM\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0001J\u0014\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001c\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u001d\u001a\u00020\u001eHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010¨\u0006\u001f"}, d2 = {"Lcom/arizonagames/feature/arizona/bank/BankCurrencyHistoryInfo;", "", TtmlNode.ATTR_ID, "", "diff", "day", "", "", "week", "month", "<init>", "(IILjava/util/List;Ljava/util/List;Ljava/util/List;)V", "getId", "()I", "getDiff", "getDay", "()Ljava/util/List;", "getWeek", "getMonth", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "", "bank"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BankCurrencyHistoryInfo {
    private final List<Long> day;
    private final int diff;
    private final int id;
    private final List<Long> month;
    private final List<Long> week;

    public BankCurrencyHistoryInfo() {
        this(0, 0, null, null, null, 31, null);
    }

    public static /* synthetic */ BankCurrencyHistoryInfo copy$default(BankCurrencyHistoryInfo bankCurrencyHistoryInfo, int i, int i2, List list, List list2, List list3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = bankCurrencyHistoryInfo.id;
        }
        if ((i3 & 2) != 0) {
            i2 = bankCurrencyHistoryInfo.diff;
        }
        List<Long> list4 = list;
        if ((i3 & 4) != 0) {
            list4 = bankCurrencyHistoryInfo.day;
        }
        List<Long> list5 = list2;
        if ((i3 & 8) != 0) {
            list5 = bankCurrencyHistoryInfo.week;
        }
        List<Long> list6 = list3;
        if ((i3 & 16) != 0) {
            list6 = bankCurrencyHistoryInfo.month;
        }
        List list7 = list6;
        List list8 = list4;
        return bankCurrencyHistoryInfo.copy(i, i2, list8, list5, list7);
    }

    public final int component1() {
        return this.id;
    }

    public final int component2() {
        return this.diff;
    }

    public final List<Long> component3() {
        return this.day;
    }

    public final List<Long> component4() {
        return this.week;
    }

    public final List<Long> component5() {
        return this.month;
    }

    public final BankCurrencyHistoryInfo copy(int i, int i2, List<Long> day, List<Long> week, List<Long> month) {
        Intrinsics.checkNotNullParameter(day, "day");
        Intrinsics.checkNotNullParameter(week, "week");
        Intrinsics.checkNotNullParameter(month, "month");
        return new BankCurrencyHistoryInfo(i, i2, day, week, month);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BankCurrencyHistoryInfo) {
            BankCurrencyHistoryInfo bankCurrencyHistoryInfo = (BankCurrencyHistoryInfo) obj;
            return this.id == bankCurrencyHistoryInfo.id && this.diff == bankCurrencyHistoryInfo.diff && Intrinsics.areEqual(this.day, bankCurrencyHistoryInfo.day) && Intrinsics.areEqual(this.week, bankCurrencyHistoryInfo.week) && Intrinsics.areEqual(this.month, bankCurrencyHistoryInfo.month);
        }
        return false;
    }

    public int hashCode() {
        return (((((((Integer.hashCode(this.id) * 31) + Integer.hashCode(this.diff)) * 31) + this.day.hashCode()) * 31) + this.week.hashCode()) * 31) + this.month.hashCode();
    }

    public String toString() {
        int i = this.id;
        int i2 = this.diff;
        List<Long> list = this.day;
        List<Long> list2 = this.week;
        return "BankCurrencyHistoryInfo(id=" + i + ", diff=" + i2 + ", day=" + list + ", week=" + list2 + ", month=" + this.month + ")";
    }

    public BankCurrencyHistoryInfo(int i, int i2, List<Long> day, List<Long> week, List<Long> month) {
        Intrinsics.checkNotNullParameter(day, "day");
        Intrinsics.checkNotNullParameter(week, "week");
        Intrinsics.checkNotNullParameter(month, "month");
        this.id = i;
        this.diff = i2;
        this.day = day;
        this.week = week;
        this.month = month;
    }

    public final int getId() {
        return this.id;
    }

    public final int getDiff() {
        return this.diff;
    }

    public /* synthetic */ BankCurrencyHistoryInfo(int i, int i2, List list, List list2, List list3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0 : i, (i3 & 2) != 0 ? 0 : i2, (i3 & 4) != 0 ? CollectionsKt.emptyList() : list, (i3 & 8) != 0 ? CollectionsKt.emptyList() : list2, (i3 & 16) != 0 ? CollectionsKt.emptyList() : list3);
    }

    public final List<Long> getDay() {
        return this.day;
    }

    public final List<Long> getWeek() {
        return this.week;
    }

    public final List<Long> getMonth() {
        return this.month;
    }
}
