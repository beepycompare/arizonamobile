package com.arizonagames.feature.arizona.bank;

import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: BankContract.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J'\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0017\u001a\u00020\u0018HÖ\u0081\u0004J\n\u0010\u0019\u001a\u00020\u001aHÖ\u0081\u0004R%\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u000b\u0012\b\b\f\u0012\u0004\b\t0\r¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/arizonagames/feature/arizona/bank/BankMobileInfo;", "", "available", "", "balance", "", "max", "<init>", "(ZJJ)V", "getAvailable", "()Z", "Lcom/google/gson/annotations/JsonAdapter;", "value", "Lcom/arizonagames/feature/arizona/bank/BankBooleanJsonAdapter;", "getBalance", "()J", "getMax", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "bank"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BankMobileInfo {
    @JsonAdapter(BankBooleanJsonAdapter.class)
    private final boolean available;
    private final long balance;
    private final long max;

    public BankMobileInfo() {
        this(false, 0L, 0L, 7, null);
    }

    public static /* synthetic */ BankMobileInfo copy$default(BankMobileInfo bankMobileInfo, boolean z, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            z = bankMobileInfo.available;
        }
        if ((i & 2) != 0) {
            j = bankMobileInfo.balance;
        }
        if ((i & 4) != 0) {
            j2 = bankMobileInfo.max;
        }
        return bankMobileInfo.copy(z, j, j2);
    }

    public final boolean component1() {
        return this.available;
    }

    public final long component2() {
        return this.balance;
    }

    public final long component3() {
        return this.max;
    }

    public final BankMobileInfo copy(boolean z, long j, long j2) {
        return new BankMobileInfo(z, j, j2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BankMobileInfo) {
            BankMobileInfo bankMobileInfo = (BankMobileInfo) obj;
            return this.available == bankMobileInfo.available && this.balance == bankMobileInfo.balance && this.max == bankMobileInfo.max;
        }
        return false;
    }

    public int hashCode() {
        return (((Boolean.hashCode(this.available) * 31) + Long.hashCode(this.balance)) * 31) + Long.hashCode(this.max);
    }

    public String toString() {
        boolean z = this.available;
        long j = this.balance;
        return "BankMobileInfo(available=" + z + ", balance=" + j + ", max=" + this.max + ")";
    }

    public BankMobileInfo(boolean z, long j, long j2) {
        this.available = z;
        this.balance = j;
        this.max = j2;
    }

    public /* synthetic */ BankMobileInfo(boolean z, long j, long j2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? 0L : j, (i & 4) != 0 ? 0L : j2);
    }

    public final boolean getAvailable() {
        return this.available;
    }

    public final long getBalance() {
        return this.balance;
    }

    public final long getMax() {
        return this.max;
    }
}
