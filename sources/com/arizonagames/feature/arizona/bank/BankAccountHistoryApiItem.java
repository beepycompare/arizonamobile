package com.arizonagames.feature.arizona.bank;

import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: BankContract.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001Bu\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0006HÆ\u0003J\t\u0010'\u001a\u00020\u0006HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\fHÆ\u0003J\t\u0010,\u001a\u00020\fHÆ\u0003J\t\u0010-\u001a\u00020\u0006HÆ\u0003J\t\u0010.\u001a\u00020\u0010HÆ\u0003Jw\u0010/\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010HÆ\u0001J\u0014\u00100\u001a\u00020\u00102\b\u00101\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u00102\u001a\u00020\u0006HÖ\u0081\u0004J\n\u00103\u001a\u00020\fHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\r\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u0011\u0010\u000e\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0017R%\u0010\u000f\u001a\u00020\u00108\u0006X\u0087\u0004\u0092\u0002\f\b!\u0012\b\b\"\u0012\u0004\b\t0#¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010 ¨\u00064"}, d2 = {"Lcom/arizonagames/feature/arizona/bank/BankAccountHistoryApiItem;", "", "id", "", "timestamp", "type", "", "accountNumber", "money", "balanceAfter", "targetId", "targetName", "", "commission", "serverId", "isMobile", "", "<init>", "(JJIIJJJLjava/lang/String;Ljava/lang/String;IZ)V", "getId", "()J", "getTimestamp", "getType", "()I", "getAccountNumber", "getMoney", "getBalanceAfter", "getTargetId", "getTargetName", "()Ljava/lang/String;", "getCommission", "getServerId", "()Z", "Lcom/google/gson/annotations/JsonAdapter;", "value", "Lcom/arizonagames/feature/arizona/bank/BankBooleanJsonAdapter;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", "other", "hashCode", "toString", "bank"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BankAccountHistoryApiItem {
    private final int accountNumber;
    private final long balanceAfter;
    private final String commission;
    private final long id;
    @JsonAdapter(BankBooleanJsonAdapter.class)
    private final boolean isMobile;
    private final long money;
    private final int serverId;
    private final long targetId;
    private final String targetName;
    private final long timestamp;
    private final int type;

    public BankAccountHistoryApiItem() {
        this(0L, 0L, 0, 0, 0L, 0L, 0L, null, null, 0, false, 2047, null);
    }

    public static /* synthetic */ BankAccountHistoryApiItem copy$default(BankAccountHistoryApiItem bankAccountHistoryApiItem, long j, long j2, int i, int i2, long j3, long j4, long j5, String str, String str2, int i3, boolean z, int i4, Object obj) {
        long j6 = (i4 & 1) != 0 ? bankAccountHistoryApiItem.id : j;
        return bankAccountHistoryApiItem.copy(j6, (i4 & 2) != 0 ? bankAccountHistoryApiItem.timestamp : j2, (i4 & 4) != 0 ? bankAccountHistoryApiItem.type : i, (i4 & 8) != 0 ? bankAccountHistoryApiItem.accountNumber : i2, (i4 & 16) != 0 ? bankAccountHistoryApiItem.money : j3, (i4 & 32) != 0 ? bankAccountHistoryApiItem.balanceAfter : j4, (i4 & 64) != 0 ? bankAccountHistoryApiItem.targetId : j5, (i4 & 128) != 0 ? bankAccountHistoryApiItem.targetName : str, (i4 & 256) != 0 ? bankAccountHistoryApiItem.commission : str2, (i4 & 512) != 0 ? bankAccountHistoryApiItem.serverId : i3, (i4 & 1024) != 0 ? bankAccountHistoryApiItem.isMobile : z);
    }

    public final long component1() {
        return this.id;
    }

    public final int component10() {
        return this.serverId;
    }

    public final boolean component11() {
        return this.isMobile;
    }

    public final long component2() {
        return this.timestamp;
    }

    public final int component3() {
        return this.type;
    }

    public final int component4() {
        return this.accountNumber;
    }

    public final long component5() {
        return this.money;
    }

    public final long component6() {
        return this.balanceAfter;
    }

    public final long component7() {
        return this.targetId;
    }

    public final String component8() {
        return this.targetName;
    }

    public final String component9() {
        return this.commission;
    }

    public final BankAccountHistoryApiItem copy(long j, long j2, int i, int i2, long j3, long j4, long j5, String targetName, String commission, int i3, boolean z) {
        Intrinsics.checkNotNullParameter(targetName, "targetName");
        Intrinsics.checkNotNullParameter(commission, "commission");
        return new BankAccountHistoryApiItem(j, j2, i, i2, j3, j4, j5, targetName, commission, i3, z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BankAccountHistoryApiItem) {
            BankAccountHistoryApiItem bankAccountHistoryApiItem = (BankAccountHistoryApiItem) obj;
            return this.id == bankAccountHistoryApiItem.id && this.timestamp == bankAccountHistoryApiItem.timestamp && this.type == bankAccountHistoryApiItem.type && this.accountNumber == bankAccountHistoryApiItem.accountNumber && this.money == bankAccountHistoryApiItem.money && this.balanceAfter == bankAccountHistoryApiItem.balanceAfter && this.targetId == bankAccountHistoryApiItem.targetId && Intrinsics.areEqual(this.targetName, bankAccountHistoryApiItem.targetName) && Intrinsics.areEqual(this.commission, bankAccountHistoryApiItem.commission) && this.serverId == bankAccountHistoryApiItem.serverId && this.isMobile == bankAccountHistoryApiItem.isMobile;
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((((Long.hashCode(this.id) * 31) + Long.hashCode(this.timestamp)) * 31) + Integer.hashCode(this.type)) * 31) + Integer.hashCode(this.accountNumber)) * 31) + Long.hashCode(this.money)) * 31) + Long.hashCode(this.balanceAfter)) * 31) + Long.hashCode(this.targetId)) * 31) + this.targetName.hashCode()) * 31) + this.commission.hashCode()) * 31) + Integer.hashCode(this.serverId)) * 31) + Boolean.hashCode(this.isMobile);
    }

    public String toString() {
        long j = this.id;
        long j2 = this.timestamp;
        int i = this.type;
        int i2 = this.accountNumber;
        long j3 = this.money;
        long j4 = this.balanceAfter;
        long j5 = this.targetId;
        String str = this.targetName;
        String str2 = this.commission;
        int i3 = this.serverId;
        return "BankAccountHistoryApiItem(id=" + j + ", timestamp=" + j2 + ", type=" + i + ", accountNumber=" + i2 + ", money=" + j3 + ", balanceAfter=" + j4 + ", targetId=" + j5 + ", targetName=" + str + ", commission=" + str2 + ", serverId=" + i3 + ", isMobile=" + this.isMobile + ")";
    }

    public BankAccountHistoryApiItem(long j, long j2, int i, int i2, long j3, long j4, long j5, String targetName, String commission, int i3, boolean z) {
        Intrinsics.checkNotNullParameter(targetName, "targetName");
        Intrinsics.checkNotNullParameter(commission, "commission");
        this.id = j;
        this.timestamp = j2;
        this.type = i;
        this.accountNumber = i2;
        this.money = j3;
        this.balanceAfter = j4;
        this.targetId = j5;
        this.targetName = targetName;
        this.commission = commission;
        this.serverId = i3;
        this.isMobile = z;
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

    public final int getAccountNumber() {
        return this.accountNumber;
    }

    public final long getMoney() {
        return this.money;
    }

    public final long getBalanceAfter() {
        return this.balanceAfter;
    }

    public final long getTargetId() {
        return this.targetId;
    }

    public /* synthetic */ BankAccountHistoryApiItem(long j, long j2, int i, int i2, long j3, long j4, long j5, String str, String str2, int i3, boolean z, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 0L : j, (i4 & 2) != 0 ? 0L : j2, (i4 & 4) != 0 ? 0 : i, (i4 & 8) != 0 ? 0 : i2, (i4 & 16) != 0 ? 0L : j3, (i4 & 32) != 0 ? 0L : j4, (i4 & 64) == 0 ? j5 : 0L, (i4 & 128) != 0 ? "" : str, (i4 & 256) != 0 ? "0" : str2, (i4 & 512) != 0 ? 0 : i3, (i4 & 1024) != 0 ? false : z);
    }

    public final String getTargetName() {
        return this.targetName;
    }

    public final String getCommission() {
        return this.commission;
    }

    public final int getServerId() {
        return this.serverId;
    }

    public final boolean isMobile() {
        return this.isMobile;
    }
}
