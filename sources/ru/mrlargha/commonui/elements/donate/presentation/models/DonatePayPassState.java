package ru.mrlargha.commonui.elements.donate.presentation.models;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
/* compiled from: DonatePayPassState.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0017\u001a\u00020\u00062\b\b\u0002\u0010\u0018\u001a\u00020\u0006J\u0010\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u0018\u001a\u00020\u0006J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001e\u001a\u00020\bHÆ\u0003J\u000f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0003JA\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nHÆ\u0001J\u0014\u0010!\u001a\u00020\u001a2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010#\u001a\u00020\bHÖ\u0081\u0004J\n\u0010$\u001a\u00020%HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006&"}, d2 = {"Lru/mrlargha/commonui/elements/donate/presentation/models/DonatePayPassState;", "", "totalMoney", "", "maxMoney", "unixEndSeason", "", "currentLevel", "", "rewards", "", "Lru/mrlargha/commonui/elements/donate/presentation/models/DonatePayPassReward;", "<init>", "(DDJILjava/util/List;)V", "getTotalMoney", "()D", "getMaxMoney", "getUnixEndSeason", "()J", "getCurrentLevel", "()I", "getRewards", "()Ljava/util/List;", "remainingSeasonMs", "nowMs", "isSeasonExpired", "", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class DonatePayPassState {
    private final int currentLevel;
    private final double maxMoney;
    private final List<DonatePayPassReward> rewards;
    private final double totalMoney;
    private final long unixEndSeason;

    public static /* synthetic */ DonatePayPassState copy$default(DonatePayPassState donatePayPassState, double d, double d2, long j, int i, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            d = donatePayPassState.totalMoney;
        }
        double d3 = d;
        if ((i2 & 2) != 0) {
            d2 = donatePayPassState.maxMoney;
        }
        double d4 = d2;
        if ((i2 & 4) != 0) {
            j = donatePayPassState.unixEndSeason;
        }
        return donatePayPassState.copy(d3, d4, j, (i2 & 8) != 0 ? donatePayPassState.currentLevel : i, (i2 & 16) != 0 ? donatePayPassState.rewards : list);
    }

    public final double component1() {
        return this.totalMoney;
    }

    public final double component2() {
        return this.maxMoney;
    }

    public final long component3() {
        return this.unixEndSeason;
    }

    public final int component4() {
        return this.currentLevel;
    }

    public final List<DonatePayPassReward> component5() {
        return this.rewards;
    }

    public final DonatePayPassState copy(double d, double d2, long j, int i, List<DonatePayPassReward> rewards) {
        Intrinsics.checkNotNullParameter(rewards, "rewards");
        return new DonatePayPassState(d, d2, j, i, rewards);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DonatePayPassState) {
            DonatePayPassState donatePayPassState = (DonatePayPassState) obj;
            return Double.compare(this.totalMoney, donatePayPassState.totalMoney) == 0 && Double.compare(this.maxMoney, donatePayPassState.maxMoney) == 0 && this.unixEndSeason == donatePayPassState.unixEndSeason && this.currentLevel == donatePayPassState.currentLevel && Intrinsics.areEqual(this.rewards, donatePayPassState.rewards);
        }
        return false;
    }

    public int hashCode() {
        return (((((((Double.hashCode(this.totalMoney) * 31) + Double.hashCode(this.maxMoney)) * 31) + Long.hashCode(this.unixEndSeason)) * 31) + Integer.hashCode(this.currentLevel)) * 31) + this.rewards.hashCode();
    }

    public String toString() {
        double d = this.totalMoney;
        double d2 = this.maxMoney;
        long j = this.unixEndSeason;
        int i = this.currentLevel;
        return "DonatePayPassState(totalMoney=" + d + ", maxMoney=" + d2 + ", unixEndSeason=" + j + ", currentLevel=" + i + ", rewards=" + this.rewards + ")";
    }

    public DonatePayPassState(double d, double d2, long j, int i, List<DonatePayPassReward> rewards) {
        Intrinsics.checkNotNullParameter(rewards, "rewards");
        this.totalMoney = d;
        this.maxMoney = d2;
        this.unixEndSeason = j;
        this.currentLevel = i;
        this.rewards = rewards;
    }

    public final double getTotalMoney() {
        return this.totalMoney;
    }

    public final double getMaxMoney() {
        return this.maxMoney;
    }

    public final long getUnixEndSeason() {
        return this.unixEndSeason;
    }

    public final int getCurrentLevel() {
        return this.currentLevel;
    }

    public final List<DonatePayPassReward> getRewards() {
        return this.rewards;
    }

    public static /* synthetic */ long remainingSeasonMs$default(DonatePayPassState donatePayPassState, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = System.currentTimeMillis();
        }
        return donatePayPassState.remainingSeasonMs(j);
    }

    public final long remainingSeasonMs(long j) {
        long saturatingSecondsToMillis;
        saturatingSecondsToMillis = DonatePayPassStateKt.saturatingSecondsToMillis(this.unixEndSeason);
        return RangesKt.coerceAtLeast(saturatingSecondsToMillis - j, 0L);
    }

    public static /* synthetic */ boolean isSeasonExpired$default(DonatePayPassState donatePayPassState, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = System.currentTimeMillis();
        }
        return donatePayPassState.isSeasonExpired(j);
    }

    public final boolean isSeasonExpired(long j) {
        return remainingSeasonMs(j) <= 0;
    }
}
