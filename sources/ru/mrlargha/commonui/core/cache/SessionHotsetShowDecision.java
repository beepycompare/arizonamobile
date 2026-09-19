package ru.mrlargha.commonui.core.cache;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SessionHotsetPolicy.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B%\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0015\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\u0006HÆ\u0003J6\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\u0006HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0014\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0019HÖ\u0081\u0004R\u0015\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lru/mrlargha/commonui/core/cache/SessionHotsetShowDecision;", "K", "", "cancelledEntryToken", "", "evictions", "", "Lru/mrlargha/commonui/core/cache/SessionHotsetEviction;", "<init>", "(Ljava/lang/Long;Ljava/util/List;)V", "getCancelledEntryToken", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getEvictions", "()Ljava/util/List;", "component1", "component2", "copy", "(Ljava/lang/Long;Ljava/util/List;)Lru/mrlargha/commonui/core/cache/SessionHotsetShowDecision;", "equals", "", "other", "hashCode", "", "toString", "", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class SessionHotsetShowDecision<K> {
    private final Long cancelledEntryToken;
    private final List<SessionHotsetEviction<K>> evictions;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SessionHotsetShowDecision copy$default(SessionHotsetShowDecision sessionHotsetShowDecision, Long l, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            l = sessionHotsetShowDecision.cancelledEntryToken;
        }
        if ((i & 2) != 0) {
            list = sessionHotsetShowDecision.evictions;
        }
        return sessionHotsetShowDecision.copy(l, list);
    }

    public final Long component1() {
        return this.cancelledEntryToken;
    }

    public final List<SessionHotsetEviction<K>> component2() {
        return this.evictions;
    }

    public final SessionHotsetShowDecision<K> copy(Long l, List<SessionHotsetEviction<K>> evictions) {
        Intrinsics.checkNotNullParameter(evictions, "evictions");
        return new SessionHotsetShowDecision<>(l, evictions);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SessionHotsetShowDecision) {
            SessionHotsetShowDecision sessionHotsetShowDecision = (SessionHotsetShowDecision) obj;
            return Intrinsics.areEqual(this.cancelledEntryToken, sessionHotsetShowDecision.cancelledEntryToken) && Intrinsics.areEqual(this.evictions, sessionHotsetShowDecision.evictions);
        }
        return false;
    }

    public int hashCode() {
        Long l = this.cancelledEntryToken;
        return ((l == null ? 0 : l.hashCode()) * 31) + this.evictions.hashCode();
    }

    public String toString() {
        Long l = this.cancelledEntryToken;
        return "SessionHotsetShowDecision(cancelledEntryToken=" + l + ", evictions=" + this.evictions + ")";
    }

    public SessionHotsetShowDecision(Long l, List<SessionHotsetEviction<K>> evictions) {
        Intrinsics.checkNotNullParameter(evictions, "evictions");
        this.cancelledEntryToken = l;
        this.evictions = evictions;
    }

    public final Long getCancelledEntryToken() {
        return this.cancelledEntryToken;
    }

    public final List<SessionHotsetEviction<K>> getEvictions() {
        return this.evictions;
    }
}
