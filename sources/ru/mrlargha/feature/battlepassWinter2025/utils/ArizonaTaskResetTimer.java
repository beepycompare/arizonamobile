package ru.mrlargha.feature.battlepassWinter2025.utils;

import kotlin.Metadata;
import kotlin.ranges.RangesKt;
/* compiled from: ArizonaMissionHelpers.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u0007¨\u0006\t"}, d2 = {"Lru/mrlargha/feature/battlepassWinter2025/utils/ArizonaTaskResetTimer;", "", "<init>", "()V", "remaining", "Lru/mrlargha/feature/battlepassWinter2025/utils/ArizonaTaskResetTime;", "timestampSeconds", "", "nowMillis", "battle-pass"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ArizonaTaskResetTimer {
    public static final ArizonaTaskResetTimer INSTANCE = new ArizonaTaskResetTimer();

    private ArizonaTaskResetTimer() {
    }

    public static /* synthetic */ ArizonaTaskResetTime remaining$default(ArizonaTaskResetTimer arizonaTaskResetTimer, long j, long j2, int i, Object obj) {
        if ((i & 2) != 0) {
            j2 = System.currentTimeMillis();
        }
        return arizonaTaskResetTimer.remaining(j, j2);
    }

    public final ArizonaTaskResetTime remaining(long j, long j2) {
        long coerceAtLeast = RangesKt.coerceAtLeast(j - (j2 / 1000), 0L);
        return new ArizonaTaskResetTime(coerceAtLeast / 3600, (coerceAtLeast % 3600) / 60);
    }
}
