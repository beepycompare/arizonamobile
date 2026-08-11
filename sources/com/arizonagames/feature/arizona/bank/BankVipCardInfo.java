package com.arizonagames.feature.arizona.bank;

import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: BankContract.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J'\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0014\u0010\u0017\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0019\u001a\u00020\u001aHÖ\u0081\u0004J\n\u0010\u001b\u001a\u00020\u0007HÖ\u0081\u0004R%\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\f\u0012\b\b\r\u0012\u0004\b\t0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001c"}, d2 = {"Lcom/arizonagames/feature/arizona/bank/BankVipCardInfo;", "", "available", "", "buyCost", "", "description", "", "<init>", "(ZJLjava/lang/String;)V", "getAvailable", "()Z", "Lcom/google/gson/annotations/JsonAdapter;", "value", "Lcom/arizonagames/feature/arizona/bank/BankBooleanJsonAdapter;", "getBuyCost", "()J", "getDescription", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "bank"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BankVipCardInfo {
    @JsonAdapter(BankBooleanJsonAdapter.class)
    private final boolean available;
    private final long buyCost;
    private final String description;

    public BankVipCardInfo() {
        this(false, 0L, null, 7, null);
    }

    public static /* synthetic */ BankVipCardInfo copy$default(BankVipCardInfo bankVipCardInfo, boolean z, long j, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z = bankVipCardInfo.available;
        }
        if ((i & 2) != 0) {
            j = bankVipCardInfo.buyCost;
        }
        if ((i & 4) != 0) {
            str = bankVipCardInfo.description;
        }
        return bankVipCardInfo.copy(z, j, str);
    }

    public final boolean component1() {
        return this.available;
    }

    public final long component2() {
        return this.buyCost;
    }

    public final String component3() {
        return this.description;
    }

    public final BankVipCardInfo copy(boolean z, long j, String description) {
        Intrinsics.checkNotNullParameter(description, "description");
        return new BankVipCardInfo(z, j, description);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BankVipCardInfo) {
            BankVipCardInfo bankVipCardInfo = (BankVipCardInfo) obj;
            return this.available == bankVipCardInfo.available && this.buyCost == bankVipCardInfo.buyCost && Intrinsics.areEqual(this.description, bankVipCardInfo.description);
        }
        return false;
    }

    public int hashCode() {
        return (((Boolean.hashCode(this.available) * 31) + Long.hashCode(this.buyCost)) * 31) + this.description.hashCode();
    }

    public String toString() {
        boolean z = this.available;
        long j = this.buyCost;
        return "BankVipCardInfo(available=" + z + ", buyCost=" + j + ", description=" + this.description + ")";
    }

    public BankVipCardInfo(boolean z, long j, String description) {
        Intrinsics.checkNotNullParameter(description, "description");
        this.available = z;
        this.buyCost = j;
        this.description = description;
    }

    public final boolean getAvailable() {
        return this.available;
    }

    public final long getBuyCost() {
        return this.buyCost;
    }

    public /* synthetic */ BankVipCardInfo(boolean z, long j, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? 0L : j, (i & 4) != 0 ? "" : str);
    }

    public final String getDescription() {
        return this.description;
    }
}
