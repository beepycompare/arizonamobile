package ru.mrlargha.commonui.elements.donate.presentation.models;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DonatePayPassState.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001f\u001a\u00020\bHÆ\u0003J\u0017\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\nHÆ\u0003J\u000f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000e0\rHÆ\u0003JY\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rHÆ\u0001J\u0014\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010&\u001a\u00020\bHÖ\u0081\u0004J\n\u0010'\u001a\u00020(HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001f\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006)"}, d2 = {"Lru/mrlargha/commonui/elements/donate/presentation/models/DonatePayPassDynamicState;", "", "totalMoney", "", "maxMoney", "unixEndSeason", "", "currentLevel", "", "statuses", "", "Lru/mrlargha/commonui/elements/donate/presentation/models/DonatePayPassTierStatus;", "legacyRewards", "", "Lru/mrlargha/commonui/elements/donate/presentation/models/DonatePayPassReward;", "<init>", "(DDJILjava/util/Map;Ljava/util/List;)V", "getTotalMoney", "()D", "getMaxMoney", "getUnixEndSeason", "()J", "getCurrentLevel", "()I", "getStatuses", "()Ljava/util/Map;", "getLegacyRewards", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class DonatePayPassDynamicState {
    private final int currentLevel;
    private final List<DonatePayPassReward> legacyRewards;
    private final double maxMoney;
    private final Map<Integer, DonatePayPassTierStatus> statuses;
    private final double totalMoney;
    private final long unixEndSeason;

    public static /* synthetic */ DonatePayPassDynamicState copy$default(DonatePayPassDynamicState donatePayPassDynamicState, double d, double d2, long j, int i, Map map, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            d = donatePayPassDynamicState.totalMoney;
        }
        double d3 = d;
        if ((i2 & 2) != 0) {
            d2 = donatePayPassDynamicState.maxMoney;
        }
        return donatePayPassDynamicState.copy(d3, d2, (i2 & 4) != 0 ? donatePayPassDynamicState.unixEndSeason : j, (i2 & 8) != 0 ? donatePayPassDynamicState.currentLevel : i, (i2 & 16) != 0 ? donatePayPassDynamicState.statuses : map, (i2 & 32) != 0 ? donatePayPassDynamicState.legacyRewards : list);
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

    public final Map<Integer, DonatePayPassTierStatus> component5() {
        return this.statuses;
    }

    public final List<DonatePayPassReward> component6() {
        return this.legacyRewards;
    }

    public final DonatePayPassDynamicState copy(double d, double d2, long j, int i, Map<Integer, ? extends DonatePayPassTierStatus> statuses, List<DonatePayPassReward> legacyRewards) {
        Intrinsics.checkNotNullParameter(statuses, "statuses");
        Intrinsics.checkNotNullParameter(legacyRewards, "legacyRewards");
        return new DonatePayPassDynamicState(d, d2, j, i, statuses, legacyRewards);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DonatePayPassDynamicState) {
            DonatePayPassDynamicState donatePayPassDynamicState = (DonatePayPassDynamicState) obj;
            return Double.compare(this.totalMoney, donatePayPassDynamicState.totalMoney) == 0 && Double.compare(this.maxMoney, donatePayPassDynamicState.maxMoney) == 0 && this.unixEndSeason == donatePayPassDynamicState.unixEndSeason && this.currentLevel == donatePayPassDynamicState.currentLevel && Intrinsics.areEqual(this.statuses, donatePayPassDynamicState.statuses) && Intrinsics.areEqual(this.legacyRewards, donatePayPassDynamicState.legacyRewards);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((Double.hashCode(this.totalMoney) * 31) + Double.hashCode(this.maxMoney)) * 31) + Long.hashCode(this.unixEndSeason)) * 31) + Integer.hashCode(this.currentLevel)) * 31) + this.statuses.hashCode()) * 31) + this.legacyRewards.hashCode();
    }

    public String toString() {
        double d = this.totalMoney;
        double d2 = this.maxMoney;
        long j = this.unixEndSeason;
        int i = this.currentLevel;
        Map<Integer, DonatePayPassTierStatus> map = this.statuses;
        return "DonatePayPassDynamicState(totalMoney=" + d + ", maxMoney=" + d2 + ", unixEndSeason=" + j + ", currentLevel=" + i + ", statuses=" + map + ", legacyRewards=" + this.legacyRewards + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DonatePayPassDynamicState(double d, double d2, long j, int i, Map<Integer, ? extends DonatePayPassTierStatus> statuses, List<DonatePayPassReward> legacyRewards) {
        Intrinsics.checkNotNullParameter(statuses, "statuses");
        Intrinsics.checkNotNullParameter(legacyRewards, "legacyRewards");
        this.totalMoney = d;
        this.maxMoney = d2;
        this.unixEndSeason = j;
        this.currentLevel = i;
        this.statuses = statuses;
        this.legacyRewards = legacyRewards;
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

    public final Map<Integer, DonatePayPassTierStatus> getStatuses() {
        return this.statuses;
    }

    public /* synthetic */ DonatePayPassDynamicState(double d, double d2, long j, int i, Map map, List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(d, d2, j, i, map, (i2 & 32) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final List<DonatePayPassReward> getLegacyRewards() {
        return this.legacyRewards;
    }
}
