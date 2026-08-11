package com.arizonagames.feature.arizona.bank;

import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: BankContract.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0012J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\nHÆ\u0003JN\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001¢\u0006\u0002\u0010\"J\u0014\u0010#\u001a\u00020\n2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010%\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010&\u001a\u00020'HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0010R%\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004\u0092\u0002\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\t0\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006("}, d2 = {"Lcom/arizonagames/feature/arizona/bank/BankCurrencyInfo;", "", "id", "", "current", "", "percent", "sellPercent", "availableMoney", "blocked", "", "<init>", "(IJLjava/lang/Integer;Ljava/lang/Integer;JZ)V", "getId", "()I", "getCurrent", "()J", "getPercent", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSellPercent", "getAvailableMoney", "getBlocked", "()Z", "Lcom/google/gson/annotations/JsonAdapter;", "value", "Lcom/arizonagames/feature/arizona/bank/BankBooleanJsonAdapter;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(IJLjava/lang/Integer;Ljava/lang/Integer;JZ)Lcom/arizonagames/feature/arizona/bank/BankCurrencyInfo;", "equals", "other", "hashCode", "toString", "", "bank"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BankCurrencyInfo {
    private final long availableMoney;
    @JsonAdapter(BankBooleanJsonAdapter.class)
    private final boolean blocked;
    private final long current;
    private final int id;
    private final Integer percent;
    private final Integer sellPercent;

    public BankCurrencyInfo() {
        this(0, 0L, null, null, 0L, false, 63, null);
    }

    public static /* synthetic */ BankCurrencyInfo copy$default(BankCurrencyInfo bankCurrencyInfo, int i, long j, Integer num, Integer num2, long j2, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = bankCurrencyInfo.id;
        }
        if ((i2 & 2) != 0) {
            j = bankCurrencyInfo.current;
        }
        if ((i2 & 4) != 0) {
            num = bankCurrencyInfo.percent;
        }
        if ((i2 & 8) != 0) {
            num2 = bankCurrencyInfo.sellPercent;
        }
        if ((i2 & 16) != 0) {
            j2 = bankCurrencyInfo.availableMoney;
        }
        if ((i2 & 32) != 0) {
            z = bankCurrencyInfo.blocked;
        }
        boolean z2 = z;
        return bankCurrencyInfo.copy(i, j, num, num2, j2, z2);
    }

    public final int component1() {
        return this.id;
    }

    public final long component2() {
        return this.current;
    }

    public final Integer component3() {
        return this.percent;
    }

    public final Integer component4() {
        return this.sellPercent;
    }

    public final long component5() {
        return this.availableMoney;
    }

    public final boolean component6() {
        return this.blocked;
    }

    public final BankCurrencyInfo copy(int i, long j, Integer num, Integer num2, long j2, boolean z) {
        return new BankCurrencyInfo(i, j, num, num2, j2, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BankCurrencyInfo) {
            BankCurrencyInfo bankCurrencyInfo = (BankCurrencyInfo) obj;
            return this.id == bankCurrencyInfo.id && this.current == bankCurrencyInfo.current && Intrinsics.areEqual(this.percent, bankCurrencyInfo.percent) && Intrinsics.areEqual(this.sellPercent, bankCurrencyInfo.sellPercent) && this.availableMoney == bankCurrencyInfo.availableMoney && this.blocked == bankCurrencyInfo.blocked;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((Integer.hashCode(this.id) * 31) + Long.hashCode(this.current)) * 31;
        Integer num = this.percent;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.sellPercent;
        return ((((hashCode2 + (num2 != null ? num2.hashCode() : 0)) * 31) + Long.hashCode(this.availableMoney)) * 31) + Boolean.hashCode(this.blocked);
    }

    public String toString() {
        int i = this.id;
        long j = this.current;
        Integer num = this.percent;
        Integer num2 = this.sellPercent;
        long j2 = this.availableMoney;
        return "BankCurrencyInfo(id=" + i + ", current=" + j + ", percent=" + num + ", sellPercent=" + num2 + ", availableMoney=" + j2 + ", blocked=" + this.blocked + ")";
    }

    public BankCurrencyInfo(int i, long j, Integer num, Integer num2, long j2, boolean z) {
        this.id = i;
        this.current = j;
        this.percent = num;
        this.sellPercent = num2;
        this.availableMoney = j2;
        this.blocked = z;
    }

    public /* synthetic */ BankCurrencyInfo(int i, long j, Integer num, Integer num2, long j2, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? 0L : j, (i2 & 4) != 0 ? null : num, (i2 & 8) != 0 ? null : num2, (i2 & 16) != 0 ? 0L : j2, (i2 & 32) != 0 ? false : z);
    }

    public final int getId() {
        return this.id;
    }

    public final long getCurrent() {
        return this.current;
    }

    public final Integer getPercent() {
        return this.percent;
    }

    public final Integer getSellPercent() {
        return this.sellPercent;
    }

    public final long getAvailableMoney() {
        return this.availableMoney;
    }

    public final boolean getBlocked() {
        return this.blocked;
    }
}
