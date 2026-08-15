package com.arizonagames.feature.arizona.bank;

import androidx.media3.extractor.text.ttml.TtmlNode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: BankContract.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0014\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0017\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0007HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/arizonagames/feature/arizona/bank/BankChestInfo;", "", TtmlNode.ATTR_ID, "", "disabledTime", "", "error", "", "<init>", "(IJLjava/lang/String;)V", "getId", "()I", "getDisabledTime", "()J", "getError", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "bank"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BankChestInfo {
    private final long disabledTime;
    private final String error;
    private final int id;

    public BankChestInfo() {
        this(0, 0L, null, 7, null);
    }

    public static /* synthetic */ BankChestInfo copy$default(BankChestInfo bankChestInfo, int i, long j, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = bankChestInfo.id;
        }
        if ((i2 & 2) != 0) {
            j = bankChestInfo.disabledTime;
        }
        if ((i2 & 4) != 0) {
            str = bankChestInfo.error;
        }
        return bankChestInfo.copy(i, j, str);
    }

    public final int component1() {
        return this.id;
    }

    public final long component2() {
        return this.disabledTime;
    }

    public final String component3() {
        return this.error;
    }

    public final BankChestInfo copy(int i, long j, String error) {
        Intrinsics.checkNotNullParameter(error, "error");
        return new BankChestInfo(i, j, error);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BankChestInfo) {
            BankChestInfo bankChestInfo = (BankChestInfo) obj;
            return this.id == bankChestInfo.id && this.disabledTime == bankChestInfo.disabledTime && Intrinsics.areEqual(this.error, bankChestInfo.error);
        }
        return false;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.id) * 31) + Long.hashCode(this.disabledTime)) * 31) + this.error.hashCode();
    }

    public String toString() {
        int i = this.id;
        long j = this.disabledTime;
        return "BankChestInfo(id=" + i + ", disabledTime=" + j + ", error=" + this.error + ")";
    }

    public BankChestInfo(int i, long j, String error) {
        Intrinsics.checkNotNullParameter(error, "error");
        this.id = i;
        this.disabledTime = j;
        this.error = error;
    }

    public final int getId() {
        return this.id;
    }

    public final long getDisabledTime() {
        return this.disabledTime;
    }

    public /* synthetic */ BankChestInfo(int i, long j, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? 0L : j, (i2 & 4) != 0 ? "" : str);
    }

    public final String getError() {
        return this.error;
    }
}
