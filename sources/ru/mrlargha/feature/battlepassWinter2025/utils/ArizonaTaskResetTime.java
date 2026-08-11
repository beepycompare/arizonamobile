package ru.mrlargha.feature.battlepassWinter2025.utils;

import kotlin.Metadata;
/* compiled from: ArizonaMissionHelpers.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lru/mrlargha/feature/battlepassWinter2025/utils/ArizonaTaskResetTime;", "", "hours", "", "minutes", "<init>", "(JJ)V", "getHours", "()J", "getMinutes", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "battle-pass"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ArizonaTaskResetTime {
    private final long hours;
    private final long minutes;

    public static /* synthetic */ ArizonaTaskResetTime copy$default(ArizonaTaskResetTime arizonaTaskResetTime, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = arizonaTaskResetTime.hours;
        }
        if ((i & 2) != 0) {
            j2 = arizonaTaskResetTime.minutes;
        }
        return arizonaTaskResetTime.copy(j, j2);
    }

    public final long component1() {
        return this.hours;
    }

    public final long component2() {
        return this.minutes;
    }

    public final ArizonaTaskResetTime copy(long j, long j2) {
        return new ArizonaTaskResetTime(j, j2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ArizonaTaskResetTime) {
            ArizonaTaskResetTime arizonaTaskResetTime = (ArizonaTaskResetTime) obj;
            return this.hours == arizonaTaskResetTime.hours && this.minutes == arizonaTaskResetTime.minutes;
        }
        return false;
    }

    public int hashCode() {
        return (Long.hashCode(this.hours) * 31) + Long.hashCode(this.minutes);
    }

    public String toString() {
        long j = this.hours;
        return "ArizonaTaskResetTime(hours=" + j + ", minutes=" + this.minutes + ")";
    }

    public ArizonaTaskResetTime(long j, long j2) {
        this.hours = j;
        this.minutes = j2;
    }

    public final long getHours() {
        return this.hours;
    }

    public final long getMinutes() {
        return this.minutes;
    }
}
