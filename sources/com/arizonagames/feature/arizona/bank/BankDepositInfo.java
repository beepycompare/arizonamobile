package com.arizonagames.feature.arizona.bank;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: BankContract.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001d\u001a\u00020\tHÆ\u0003J\t\u0010\u001e\u001a\u00020\tHÆ\u0003J\t\u0010\u001f\u001a\u00020\fHÆ\u0003JE\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0014\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010$\u001a\u00020\tHÖ\u0081\u0004J\n\u0010%\u001a\u00020\fHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006&"}, d2 = {"Lcom/arizonagames/feature/arizona/bank/BankDepositInfo;", "", "money", "", "percents", "Lcom/arizonagames/feature/arizona/bank/BankDepositPercents;", "disabledTime", "Lcom/arizonagames/feature/arizona/bank/BankDepositDisabledTime;", FirebaseAnalytics.Param.LEVEL, "", "maxLevel", "description", "", "<init>", "(JLcom/arizonagames/feature/arizona/bank/BankDepositPercents;Lcom/arizonagames/feature/arizona/bank/BankDepositDisabledTime;IILjava/lang/String;)V", "getMoney", "()J", "getPercents", "()Lcom/arizonagames/feature/arizona/bank/BankDepositPercents;", "getDisabledTime", "()Lcom/arizonagames/feature/arizona/bank/BankDepositDisabledTime;", "getLevel", "()I", "getMaxLevel", "getDescription", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "bank"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class BankDepositInfo {
    private final String description;
    private final BankDepositDisabledTime disabledTime;
    private final int level;
    private final int maxLevel;
    private final long money;
    private final BankDepositPercents percents;

    public BankDepositInfo() {
        this(0L, null, null, 0, 0, null, 63, null);
    }

    public static /* synthetic */ BankDepositInfo copy$default(BankDepositInfo bankDepositInfo, long j, BankDepositPercents bankDepositPercents, BankDepositDisabledTime bankDepositDisabledTime, int i, int i2, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j = bankDepositInfo.money;
        }
        long j2 = j;
        if ((i3 & 2) != 0) {
            bankDepositPercents = bankDepositInfo.percents;
        }
        BankDepositPercents bankDepositPercents2 = bankDepositPercents;
        if ((i3 & 4) != 0) {
            bankDepositDisabledTime = bankDepositInfo.disabledTime;
        }
        BankDepositDisabledTime bankDepositDisabledTime2 = bankDepositDisabledTime;
        if ((i3 & 8) != 0) {
            i = bankDepositInfo.level;
        }
        int i4 = i;
        if ((i3 & 16) != 0) {
            i2 = bankDepositInfo.maxLevel;
        }
        int i5 = i2;
        if ((i3 & 32) != 0) {
            str = bankDepositInfo.description;
        }
        return bankDepositInfo.copy(j2, bankDepositPercents2, bankDepositDisabledTime2, i4, i5, str);
    }

    public final long component1() {
        return this.money;
    }

    public final BankDepositPercents component2() {
        return this.percents;
    }

    public final BankDepositDisabledTime component3() {
        return this.disabledTime;
    }

    public final int component4() {
        return this.level;
    }

    public final int component5() {
        return this.maxLevel;
    }

    public final String component6() {
        return this.description;
    }

    public final BankDepositInfo copy(long j, BankDepositPercents percents, BankDepositDisabledTime disabledTime, int i, int i2, String description) {
        Intrinsics.checkNotNullParameter(percents, "percents");
        Intrinsics.checkNotNullParameter(disabledTime, "disabledTime");
        Intrinsics.checkNotNullParameter(description, "description");
        return new BankDepositInfo(j, percents, disabledTime, i, i2, description);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BankDepositInfo) {
            BankDepositInfo bankDepositInfo = (BankDepositInfo) obj;
            return this.money == bankDepositInfo.money && Intrinsics.areEqual(this.percents, bankDepositInfo.percents) && Intrinsics.areEqual(this.disabledTime, bankDepositInfo.disabledTime) && this.level == bankDepositInfo.level && this.maxLevel == bankDepositInfo.maxLevel && Intrinsics.areEqual(this.description, bankDepositInfo.description);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((Long.hashCode(this.money) * 31) + this.percents.hashCode()) * 31) + this.disabledTime.hashCode()) * 31) + Integer.hashCode(this.level)) * 31) + Integer.hashCode(this.maxLevel)) * 31) + this.description.hashCode();
    }

    public String toString() {
        long j = this.money;
        BankDepositPercents bankDepositPercents = this.percents;
        BankDepositDisabledTime bankDepositDisabledTime = this.disabledTime;
        int i = this.level;
        int i2 = this.maxLevel;
        return "BankDepositInfo(money=" + j + ", percents=" + bankDepositPercents + ", disabledTime=" + bankDepositDisabledTime + ", level=" + i + ", maxLevel=" + i2 + ", description=" + this.description + ")";
    }

    public BankDepositInfo(long j, BankDepositPercents percents, BankDepositDisabledTime disabledTime, int i, int i2, String description) {
        Intrinsics.checkNotNullParameter(percents, "percents");
        Intrinsics.checkNotNullParameter(disabledTime, "disabledTime");
        Intrinsics.checkNotNullParameter(description, "description");
        this.money = j;
        this.percents = percents;
        this.disabledTime = disabledTime;
        this.level = i;
        this.maxLevel = i2;
        this.description = description;
    }

    public final long getMoney() {
        return this.money;
    }

    public /* synthetic */ BankDepositInfo(long j, BankDepositPercents bankDepositPercents, BankDepositDisabledTime bankDepositDisabledTime, int i, int i2, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0L : j, (i3 & 2) != 0 ? new BankDepositPercents(0, 0, 3, null) : bankDepositPercents, (i3 & 4) != 0 ? new BankDepositDisabledTime(0, 0, 0, 7, null) : bankDepositDisabledTime, (i3 & 8) != 0 ? 0 : i, (i3 & 16) != 0 ? 0 : i2, (i3 & 32) != 0 ? "" : str);
    }

    public final BankDepositPercents getPercents() {
        return this.percents;
    }

    public final BankDepositDisabledTime getDisabledTime() {
        return this.disabledTime;
    }

    public final int getLevel() {
        return this.level;
    }

    public final int getMaxLevel() {
        return this.maxLevel;
    }

    public final String getDescription() {
        return this.description;
    }
}
