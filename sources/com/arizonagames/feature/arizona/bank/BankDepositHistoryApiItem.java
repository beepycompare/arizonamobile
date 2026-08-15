package com.arizonagames.feature.arizona.bank;

import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: BankContract.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0006HÆ\u0003J\t\u0010 \u001a\u00020\u000bHÆ\u0003JO\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0014\u0010\"\u001a\u00020\u000b2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010$\u001a\u00020\u0006HÖ\u0081\u0004J\n\u0010%\u001a\u00020&HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R%\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004\u0092\u0002\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\t0\u0019¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0016¨\u0006'"}, d2 = {"Lcom/arizonagames/feature/arizona/bank/BankDepositHistoryApiItem;", "", TtmlNode.ATTR_ID, "", "timestamp", "type", "", "money", "balanceAfter", "serverId", "isMobile", "", "<init>", "(JJIJJIZ)V", "getId", "()J", "getTimestamp", "getType", "()I", "getMoney", "getBalanceAfter", "getServerId", "()Z", "Lcom/google/gson/annotations/JsonAdapter;", "value", "Lcom/arizonagames/feature/arizona/bank/BankBooleanJsonAdapter;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "", "bank"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BankDepositHistoryApiItem {
    private final long balanceAfter;
    private final long id;
    @JsonAdapter(BankBooleanJsonAdapter.class)
    private final boolean isMobile;
    private final long money;
    private final int serverId;
    private final long timestamp;
    private final int type;

    public BankDepositHistoryApiItem() {
        this(0L, 0L, 0, 0L, 0L, 0, false, 127, null);
    }

    public static /* synthetic */ BankDepositHistoryApiItem copy$default(BankDepositHistoryApiItem bankDepositHistoryApiItem, long j, long j2, int i, long j3, long j4, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j = bankDepositHistoryApiItem.id;
        }
        return bankDepositHistoryApiItem.copy(j, (i3 & 2) != 0 ? bankDepositHistoryApiItem.timestamp : j2, (i3 & 4) != 0 ? bankDepositHistoryApiItem.type : i, (i3 & 8) != 0 ? bankDepositHistoryApiItem.money : j3, (i3 & 16) != 0 ? bankDepositHistoryApiItem.balanceAfter : j4, (i3 & 32) != 0 ? bankDepositHistoryApiItem.serverId : i2, (i3 & 64) != 0 ? bankDepositHistoryApiItem.isMobile : z);
    }

    public final long component1() {
        return this.id;
    }

    public final long component2() {
        return this.timestamp;
    }

    public final int component3() {
        return this.type;
    }

    public final long component4() {
        return this.money;
    }

    public final long component5() {
        return this.balanceAfter;
    }

    public final int component6() {
        return this.serverId;
    }

    public final boolean component7() {
        return this.isMobile;
    }

    public final BankDepositHistoryApiItem copy(long j, long j2, int i, long j3, long j4, int i2, boolean z) {
        return new BankDepositHistoryApiItem(j, j2, i, j3, j4, i2, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BankDepositHistoryApiItem) {
            BankDepositHistoryApiItem bankDepositHistoryApiItem = (BankDepositHistoryApiItem) obj;
            return this.id == bankDepositHistoryApiItem.id && this.timestamp == bankDepositHistoryApiItem.timestamp && this.type == bankDepositHistoryApiItem.type && this.money == bankDepositHistoryApiItem.money && this.balanceAfter == bankDepositHistoryApiItem.balanceAfter && this.serverId == bankDepositHistoryApiItem.serverId && this.isMobile == bankDepositHistoryApiItem.isMobile;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((Long.hashCode(this.id) * 31) + Long.hashCode(this.timestamp)) * 31) + Integer.hashCode(this.type)) * 31) + Long.hashCode(this.money)) * 31) + Long.hashCode(this.balanceAfter)) * 31) + Integer.hashCode(this.serverId)) * 31) + Boolean.hashCode(this.isMobile);
    }

    public String toString() {
        long j = this.id;
        long j2 = this.timestamp;
        int i = this.type;
        long j3 = this.money;
        long j4 = this.balanceAfter;
        int i2 = this.serverId;
        return "BankDepositHistoryApiItem(id=" + j + ", timestamp=" + j2 + ", type=" + i + ", money=" + j3 + ", balanceAfter=" + j4 + ", serverId=" + i2 + ", isMobile=" + this.isMobile + ")";
    }

    public BankDepositHistoryApiItem(long j, long j2, int i, long j3, long j4, int i2, boolean z) {
        this.id = j;
        this.timestamp = j2;
        this.type = i;
        this.money = j3;
        this.balanceAfter = j4;
        this.serverId = i2;
        this.isMobile = z;
    }

    public /* synthetic */ BankDepositHistoryApiItem(long j, long j2, int i, long j3, long j4, int i2, boolean z, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0L : j, (i3 & 2) != 0 ? 0L : j2, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0L : j3, (i3 & 16) == 0 ? j4 : 0L, (i3 & 32) != 0 ? 0 : i2, (i3 & 64) != 0 ? false : z);
    }

    public final long getId() {
        return this.id;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public final int getType() {
        return this.type;
    }

    public final long getMoney() {
        return this.money;
    }

    public final long getBalanceAfter() {
        return this.balanceAfter;
    }

    public final int getServerId() {
        return this.serverId;
    }

    public final boolean isMobile() {
        return this.isMobile;
    }
}
