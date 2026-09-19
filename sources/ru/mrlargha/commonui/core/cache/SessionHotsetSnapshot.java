package ru.mrlargha.commonui.core.cache;

import kotlin.Metadata;
/* compiled from: SessionHotsetPolicy.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0014\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0018\u001a\u00020\u0003HÖ\u0081\u0004J\n\u0010\u0019\u001a\u00020\u001aHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lru/mrlargha/commonui/core/cache/SessionHotsetSnapshot;", "", "hiddenEntries", "", "peakHiddenEntries", "maxHiddenEntries", "hiddenTtlMs", "", "<init>", "(IIIJ)V", "getHiddenEntries", "()I", "getPeakHiddenEntries", "getMaxHiddenEntries", "getHiddenTtlMs", "()J", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class SessionHotsetSnapshot {
    private final int hiddenEntries;
    private final long hiddenTtlMs;
    private final int maxHiddenEntries;
    private final int peakHiddenEntries;

    public static /* synthetic */ SessionHotsetSnapshot copy$default(SessionHotsetSnapshot sessionHotsetSnapshot, int i, int i2, int i3, long j, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = sessionHotsetSnapshot.hiddenEntries;
        }
        if ((i4 & 2) != 0) {
            i2 = sessionHotsetSnapshot.peakHiddenEntries;
        }
        if ((i4 & 4) != 0) {
            i3 = sessionHotsetSnapshot.maxHiddenEntries;
        }
        if ((i4 & 8) != 0) {
            j = sessionHotsetSnapshot.hiddenTtlMs;
        }
        int i5 = i3;
        return sessionHotsetSnapshot.copy(i, i2, i5, j);
    }

    public final int component1() {
        return this.hiddenEntries;
    }

    public final int component2() {
        return this.peakHiddenEntries;
    }

    public final int component3() {
        return this.maxHiddenEntries;
    }

    public final long component4() {
        return this.hiddenTtlMs;
    }

    public final SessionHotsetSnapshot copy(int i, int i2, int i3, long j) {
        return new SessionHotsetSnapshot(i, i2, i3, j);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SessionHotsetSnapshot) {
            SessionHotsetSnapshot sessionHotsetSnapshot = (SessionHotsetSnapshot) obj;
            return this.hiddenEntries == sessionHotsetSnapshot.hiddenEntries && this.peakHiddenEntries == sessionHotsetSnapshot.peakHiddenEntries && this.maxHiddenEntries == sessionHotsetSnapshot.maxHiddenEntries && this.hiddenTtlMs == sessionHotsetSnapshot.hiddenTtlMs;
        }
        return false;
    }

    public int hashCode() {
        return (((((Integer.hashCode(this.hiddenEntries) * 31) + Integer.hashCode(this.peakHiddenEntries)) * 31) + Integer.hashCode(this.maxHiddenEntries)) * 31) + Long.hashCode(this.hiddenTtlMs);
    }

    public String toString() {
        int i = this.hiddenEntries;
        int i2 = this.peakHiddenEntries;
        int i3 = this.maxHiddenEntries;
        return "SessionHotsetSnapshot(hiddenEntries=" + i + ", peakHiddenEntries=" + i2 + ", maxHiddenEntries=" + i3 + ", hiddenTtlMs=" + this.hiddenTtlMs + ")";
    }

    public SessionHotsetSnapshot(int i, int i2, int i3, long j) {
        this.hiddenEntries = i;
        this.peakHiddenEntries = i2;
        this.maxHiddenEntries = i3;
        this.hiddenTtlMs = j;
    }

    public final int getHiddenEntries() {
        return this.hiddenEntries;
    }

    public final int getPeakHiddenEntries() {
        return this.peakHiddenEntries;
    }

    public final int getMaxHiddenEntries() {
        return this.maxHiddenEntries;
    }

    public final long getHiddenTtlMs() {
        return this.hiddenTtlMs;
    }
}
