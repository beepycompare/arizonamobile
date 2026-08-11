package com.arizonagames.feature.arizona.bank;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: BankContract.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\tHÆ\u0003J;\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0014\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001d\u001a\u00020\u0006HÖ\u0081\u0004J\n\u0010\u001e\u001a\u00020\tHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcom/arizonagames/feature/arizona/bank/BankOrganizationHistoryApiItem;", "", "id", "", "timestamp", "type", "", "money", "playerName", "", "<init>", "(JJIJLjava/lang/String;)V", "getId", "()J", "getTimestamp", "getType", "()I", "getMoney", "getPlayerName", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "bank"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BankOrganizationHistoryApiItem {
    private final long id;
    private final long money;
    private final String playerName;
    private final long timestamp;
    private final int type;

    public BankOrganizationHistoryApiItem() {
        this(0L, 0L, 0, 0L, null, 31, null);
    }

    public static /* synthetic */ BankOrganizationHistoryApiItem copy$default(BankOrganizationHistoryApiItem bankOrganizationHistoryApiItem, long j, long j2, int i, long j3, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = bankOrganizationHistoryApiItem.id;
        }
        long j4 = j;
        if ((i2 & 2) != 0) {
            j2 = bankOrganizationHistoryApiItem.timestamp;
        }
        long j5 = j2;
        if ((i2 & 4) != 0) {
            i = bankOrganizationHistoryApiItem.type;
        }
        return bankOrganizationHistoryApiItem.copy(j4, j5, i, (i2 & 8) != 0 ? bankOrganizationHistoryApiItem.money : j3, (i2 & 16) != 0 ? bankOrganizationHistoryApiItem.playerName : str);
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

    public final String component5() {
        return this.playerName;
    }

    public final BankOrganizationHistoryApiItem copy(long j, long j2, int i, long j3, String playerName) {
        Intrinsics.checkNotNullParameter(playerName, "playerName");
        return new BankOrganizationHistoryApiItem(j, j2, i, j3, playerName);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BankOrganizationHistoryApiItem) {
            BankOrganizationHistoryApiItem bankOrganizationHistoryApiItem = (BankOrganizationHistoryApiItem) obj;
            return this.id == bankOrganizationHistoryApiItem.id && this.timestamp == bankOrganizationHistoryApiItem.timestamp && this.type == bankOrganizationHistoryApiItem.type && this.money == bankOrganizationHistoryApiItem.money && Intrinsics.areEqual(this.playerName, bankOrganizationHistoryApiItem.playerName);
        }
        return false;
    }

    public int hashCode() {
        return (((((((Long.hashCode(this.id) * 31) + Long.hashCode(this.timestamp)) * 31) + Integer.hashCode(this.type)) * 31) + Long.hashCode(this.money)) * 31) + this.playerName.hashCode();
    }

    public String toString() {
        long j = this.id;
        long j2 = this.timestamp;
        int i = this.type;
        long j3 = this.money;
        return "BankOrganizationHistoryApiItem(id=" + j + ", timestamp=" + j2 + ", type=" + i + ", money=" + j3 + ", playerName=" + this.playerName + ")";
    }

    public BankOrganizationHistoryApiItem(long j, long j2, int i, long j3, String playerName) {
        Intrinsics.checkNotNullParameter(playerName, "playerName");
        this.id = j;
        this.timestamp = j2;
        this.type = i;
        this.money = j3;
        this.playerName = playerName;
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

    public /* synthetic */ BankOrganizationHistoryApiItem(long j, long j2, int i, long j3, String str, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0L : j, (i2 & 2) != 0 ? 0L : j2, (i2 & 4) != 0 ? 0 : i, (i2 & 8) != 0 ? 0L : j3, (i2 & 16) != 0 ? "" : str);
    }

    public final String getPlayerName() {
        return this.playerName;
    }
}
