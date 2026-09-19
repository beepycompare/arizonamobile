package ru.mrlargha.commonui.core.cache;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SessionHotsetPolicy.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002BC\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0012\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f0\u000b¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u0018\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÆ\u0003J\u0015\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f0\u000bHÆ\u0003JW\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\u0014\b\u0002\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f0\u000bHÆ\u0001J\u0014\u0010\u001f\u001a\u00020\u00042\b\u0010 \u001a\u0004\u0018\u00010\u0002HÖ\u0083\u0004J\n\u0010!\u001a\u00020\"HÖ\u0081\u0004J\n\u0010#\u001a\u00020$HÖ\u0081\u0004R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u001d\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006%"}, d2 = {"Lru/mrlargha/commonui/core/cache/SessionHotsetHideDecision;", "K", "", "admitted", "", "duplicate", "ttlMs", "", "expiresAtMs", "hideGeneration", "evictions", "", "Lru/mrlargha/commonui/core/cache/SessionHotsetEviction;", "<init>", "(ZZJJJLjava/util/List;)V", "getAdmitted", "()Z", "getDuplicate", "getTtlMs", "()J", "getExpiresAtMs", "getHideGeneration", "getEvictions", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class SessionHotsetHideDecision<K> {
    private final boolean admitted;
    private final boolean duplicate;
    private final List<SessionHotsetEviction<K>> evictions;
    private final long expiresAtMs;
    private final long hideGeneration;
    private final long ttlMs;

    public static /* synthetic */ SessionHotsetHideDecision copy$default(SessionHotsetHideDecision sessionHotsetHideDecision, boolean z, boolean z2, long j, long j2, long j3, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            z = sessionHotsetHideDecision.admitted;
        }
        if ((i & 2) != 0) {
            z2 = sessionHotsetHideDecision.duplicate;
        }
        if ((i & 4) != 0) {
            j = sessionHotsetHideDecision.ttlMs;
        }
        if ((i & 8) != 0) {
            j2 = sessionHotsetHideDecision.expiresAtMs;
        }
        if ((i & 16) != 0) {
            j3 = sessionHotsetHideDecision.hideGeneration;
        }
        List<SessionHotsetEviction<K>> list2 = list;
        if ((i & 32) != 0) {
            list2 = sessionHotsetHideDecision.evictions;
        }
        List list3 = list2;
        long j4 = j3;
        long j5 = j2;
        return sessionHotsetHideDecision.copy(z, z2, j, j5, j4, list3);
    }

    public final boolean component1() {
        return this.admitted;
    }

    public final boolean component2() {
        return this.duplicate;
    }

    public final long component3() {
        return this.ttlMs;
    }

    public final long component4() {
        return this.expiresAtMs;
    }

    public final long component5() {
        return this.hideGeneration;
    }

    public final List<SessionHotsetEviction<K>> component6() {
        return this.evictions;
    }

    public final SessionHotsetHideDecision<K> copy(boolean z, boolean z2, long j, long j2, long j3, List<SessionHotsetEviction<K>> evictions) {
        Intrinsics.checkNotNullParameter(evictions, "evictions");
        return new SessionHotsetHideDecision<>(z, z2, j, j2, j3, evictions);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SessionHotsetHideDecision) {
            SessionHotsetHideDecision sessionHotsetHideDecision = (SessionHotsetHideDecision) obj;
            return this.admitted == sessionHotsetHideDecision.admitted && this.duplicate == sessionHotsetHideDecision.duplicate && this.ttlMs == sessionHotsetHideDecision.ttlMs && this.expiresAtMs == sessionHotsetHideDecision.expiresAtMs && this.hideGeneration == sessionHotsetHideDecision.hideGeneration && Intrinsics.areEqual(this.evictions, sessionHotsetHideDecision.evictions);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((Boolean.hashCode(this.admitted) * 31) + Boolean.hashCode(this.duplicate)) * 31) + Long.hashCode(this.ttlMs)) * 31) + Long.hashCode(this.expiresAtMs)) * 31) + Long.hashCode(this.hideGeneration)) * 31) + this.evictions.hashCode();
    }

    public String toString() {
        boolean z = this.admitted;
        boolean z2 = this.duplicate;
        long j = this.ttlMs;
        long j2 = this.expiresAtMs;
        long j3 = this.hideGeneration;
        return "SessionHotsetHideDecision(admitted=" + z + ", duplicate=" + z2 + ", ttlMs=" + j + ", expiresAtMs=" + j2 + ", hideGeneration=" + j3 + ", evictions=" + this.evictions + ")";
    }

    public SessionHotsetHideDecision(boolean z, boolean z2, long j, long j2, long j3, List<SessionHotsetEviction<K>> evictions) {
        Intrinsics.checkNotNullParameter(evictions, "evictions");
        this.admitted = z;
        this.duplicate = z2;
        this.ttlMs = j;
        this.expiresAtMs = j2;
        this.hideGeneration = j3;
        this.evictions = evictions;
    }

    public final boolean getAdmitted() {
        return this.admitted;
    }

    public final boolean getDuplicate() {
        return this.duplicate;
    }

    public final long getTtlMs() {
        return this.ttlMs;
    }

    public final long getExpiresAtMs() {
        return this.expiresAtMs;
    }

    public final long getHideGeneration() {
        return this.hideGeneration;
    }

    public final List<SessionHotsetEviction<K>> getEvictions() {
        return this.evictions;
    }
}
