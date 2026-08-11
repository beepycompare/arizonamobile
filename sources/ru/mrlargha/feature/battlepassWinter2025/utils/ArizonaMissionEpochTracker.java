package ru.mrlargha.feature.battlepassWinter2025.utils;

import kotlin.Metadata;
/* compiled from: ArizonaMissionsState.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\f\u001a\u00020\rJ\u0016\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\bR\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0006R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lru/mrlargha/feature/battlepassWinter2025/utils/ArizonaMissionEpochTracker;", "", "<init>", "()V", "lastMissionTimestamp", "", "Ljava/lang/Long;", "lastPremiumTier", "", "Ljava/lang/Integer;", "isPreparedForNextMain", "", "prepareForNextMain", "", "shouldBeginProgressSnapshot", "missionTimestamp", "premiumTier", "battle-pass"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ArizonaMissionEpochTracker {
    private boolean isPreparedForNextMain = true;
    private Long lastMissionTimestamp;
    private Integer lastPremiumTier;

    public final void prepareForNextMain() {
        this.isPreparedForNextMain = true;
    }

    public final boolean shouldBeginProgressSnapshot(long j, int i) {
        Integer num;
        Long l = this.lastMissionTimestamp;
        boolean z = (l == null || l.longValue() != j || (num = this.lastPremiumTier) == null || num.intValue() != i) && !this.isPreparedForNextMain;
        this.lastMissionTimestamp = Long.valueOf(j);
        this.lastPremiumTier = Integer.valueOf(i);
        this.isPreparedForNextMain = false;
        return z;
    }
}
