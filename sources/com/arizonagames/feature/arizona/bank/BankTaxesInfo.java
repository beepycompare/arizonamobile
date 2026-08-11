package com.arizonagames.feature.arizona.bank;

import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: BankContract.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J\t\u0010\u001b\u001a\u00020\nHÆ\u0003J7\u0010\u001c\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0014\u0010\u001d\u001a\u00020\b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001f\u001a\u00020\u0006HÖ\u0081\u0004J\n\u0010 \u001a\u00020!HÖ\u0081\u0004R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R%\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004\u0092\u0002\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\t0\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006\""}, d2 = {"Lcom/arizonagames/feature/arizona/bank/BankTaxesInfo;", "", "list", "", "Lcom/arizonagames/feature/arizona/bank/BankTaxInfo;", "playTime", "", "hasAddVip", "", "totalCost", "", "<init>", "(Ljava/util/List;IZJ)V", "getList", "()Ljava/util/List;", "getPlayTime", "()I", "getHasAddVip", "()Z", "Lcom/google/gson/annotations/JsonAdapter;", "value", "Lcom/arizonagames/feature/arizona/bank/BankBooleanJsonAdapter;", "getTotalCost", "()J", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "", "bank"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BankTaxesInfo {
    @JsonAdapter(BankBooleanJsonAdapter.class)
    private final boolean hasAddVip;
    private final List<BankTaxInfo> list;
    private final int playTime;
    private final long totalCost;

    public BankTaxesInfo() {
        this(null, 0, false, 0L, 15, null);
    }

    public static /* synthetic */ BankTaxesInfo copy$default(BankTaxesInfo bankTaxesInfo, List list, int i, boolean z, long j, int i2, Object obj) {
        List<BankTaxInfo> list2 = list;
        if ((i2 & 1) != 0) {
            list2 = bankTaxesInfo.list;
        }
        if ((i2 & 2) != 0) {
            i = bankTaxesInfo.playTime;
        }
        if ((i2 & 4) != 0) {
            z = bankTaxesInfo.hasAddVip;
        }
        if ((i2 & 8) != 0) {
            j = bankTaxesInfo.totalCost;
        }
        boolean z2 = z;
        return bankTaxesInfo.copy(list2, i, z2, j);
    }

    public final List<BankTaxInfo> component1() {
        return this.list;
    }

    public final int component2() {
        return this.playTime;
    }

    public final boolean component3() {
        return this.hasAddVip;
    }

    public final long component4() {
        return this.totalCost;
    }

    public final BankTaxesInfo copy(List<BankTaxInfo> list, int i, boolean z, long j) {
        Intrinsics.checkNotNullParameter(list, "list");
        return new BankTaxesInfo(list, i, z, j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BankTaxesInfo) {
            BankTaxesInfo bankTaxesInfo = (BankTaxesInfo) obj;
            return Intrinsics.areEqual(this.list, bankTaxesInfo.list) && this.playTime == bankTaxesInfo.playTime && this.hasAddVip == bankTaxesInfo.hasAddVip && this.totalCost == bankTaxesInfo.totalCost;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.list.hashCode() * 31) + Integer.hashCode(this.playTime)) * 31) + Boolean.hashCode(this.hasAddVip)) * 31) + Long.hashCode(this.totalCost);
    }

    public String toString() {
        List<BankTaxInfo> list = this.list;
        int i = this.playTime;
        boolean z = this.hasAddVip;
        return "BankTaxesInfo(list=" + list + ", playTime=" + i + ", hasAddVip=" + z + ", totalCost=" + this.totalCost + ")";
    }

    public BankTaxesInfo(List<BankTaxInfo> list, int i, boolean z, long j) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.list = list;
        this.playTime = i;
        this.hasAddVip = z;
        this.totalCost = j;
    }

    public /* synthetic */ BankTaxesInfo(List list, int i, boolean z, long j, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? CollectionsKt.emptyList() : list, (i2 & 2) != 0 ? 0 : i, (i2 & 4) != 0 ? false : z, (i2 & 8) != 0 ? 0L : j);
    }

    public final List<BankTaxInfo> getList() {
        return this.list;
    }

    public final int getPlayTime() {
        return this.playTime;
    }

    public final boolean getHasAddVip() {
        return this.hasAddVip;
    }

    public final long getTotalCost() {
        return this.totalCost;
    }
}
