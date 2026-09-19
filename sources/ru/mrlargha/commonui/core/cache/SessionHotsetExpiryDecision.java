package ru.mrlargha.commonui.core.cache;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SessionHotsetPolicy.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\u0006¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u000e\u001a\u00020\u0004HÆ\u0003J\u0015\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\u0006HÆ\u0003J/\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\u0006HÆ\u0001J\u0014\u0010\u0011\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002HÖ\u0083\u0004J\n\u0010\u0013\u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lru/mrlargha/commonui/core/cache/SessionHotsetExpiryDecision;", "K", "", "targetEvicted", "", "evictions", "", "Lru/mrlargha/commonui/core/cache/SessionHotsetEviction;", "<init>", "(ZLjava/util/List;)V", "getTargetEvicted", "()Z", "getEvictions", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class SessionHotsetExpiryDecision<K> {
    private final List<SessionHotsetEviction<K>> evictions;
    private final boolean targetEvicted;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SessionHotsetExpiryDecision copy$default(SessionHotsetExpiryDecision sessionHotsetExpiryDecision, boolean z, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            z = sessionHotsetExpiryDecision.targetEvicted;
        }
        if ((i & 2) != 0) {
            list = sessionHotsetExpiryDecision.evictions;
        }
        return sessionHotsetExpiryDecision.copy(z, list);
    }

    public final boolean component1() {
        return this.targetEvicted;
    }

    public final List<SessionHotsetEviction<K>> component2() {
        return this.evictions;
    }

    public final SessionHotsetExpiryDecision<K> copy(boolean z, List<SessionHotsetEviction<K>> evictions) {
        Intrinsics.checkNotNullParameter(evictions, "evictions");
        return new SessionHotsetExpiryDecision<>(z, evictions);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SessionHotsetExpiryDecision) {
            SessionHotsetExpiryDecision sessionHotsetExpiryDecision = (SessionHotsetExpiryDecision) obj;
            return this.targetEvicted == sessionHotsetExpiryDecision.targetEvicted && Intrinsics.areEqual(this.evictions, sessionHotsetExpiryDecision.evictions);
        }
        return false;
    }

    public int hashCode() {
        return (Boolean.hashCode(this.targetEvicted) * 31) + this.evictions.hashCode();
    }

    public String toString() {
        boolean z = this.targetEvicted;
        return "SessionHotsetExpiryDecision(targetEvicted=" + z + ", evictions=" + this.evictions + ")";
    }

    public SessionHotsetExpiryDecision(boolean z, List<SessionHotsetEviction<K>> evictions) {
        Intrinsics.checkNotNullParameter(evictions, "evictions");
        this.targetEvicted = z;
        this.evictions = evictions;
    }

    public final boolean getTargetEvicted() {
        return this.targetEvicted;
    }

    public final List<SessionHotsetEviction<K>> getEvictions() {
        return this.evictions;
    }
}
