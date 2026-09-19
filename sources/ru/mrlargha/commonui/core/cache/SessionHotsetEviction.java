package ru.mrlargha.commonui.core.cache;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SessionHotsetPolicy.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B/\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0015\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\rJ\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003JF\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00028\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0002\u0010\u001bJ\u0014\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0002HÖ\u0083\u0004J\n\u0010\u001f\u001a\u00020 HÖ\u0081\u0004J\n\u0010!\u001a\u00020\"HÖ\u0081\u0004R\u0013\u0010\u0003\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010¨\u0006#"}, d2 = {"Lru/mrlargha/commonui/core/cache/SessionHotsetEviction;", "K", "", "key", "entryToken", "", "hideGeneration", "reason", "Lru/mrlargha/commonui/core/cache/SessionHotsetEvictionReason;", "retainedMs", "<init>", "(Ljava/lang/Object;JJLru/mrlargha/commonui/core/cache/SessionHotsetEvictionReason;J)V", "getKey", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getEntryToken", "()J", "getHideGeneration", "getReason", "()Lru/mrlargha/commonui/core/cache/SessionHotsetEvictionReason;", "getRetainedMs", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Object;JJLru/mrlargha/commonui/core/cache/SessionHotsetEvictionReason;J)Lru/mrlargha/commonui/core/cache/SessionHotsetEviction;", "equals", "", "other", "hashCode", "", "toString", "", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class SessionHotsetEviction<K> {
    private final long entryToken;
    private final long hideGeneration;
    private final K key;
    private final SessionHotsetEvictionReason reason;
    private final long retainedMs;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SessionHotsetEviction copy$default(SessionHotsetEviction sessionHotsetEviction, Object obj, long j, long j2, SessionHotsetEvictionReason sessionHotsetEvictionReason, long j3, int i, Object obj2) {
        K k = obj;
        if ((i & 1) != 0) {
            k = sessionHotsetEviction.key;
        }
        if ((i & 2) != 0) {
            j = sessionHotsetEviction.entryToken;
        }
        if ((i & 4) != 0) {
            j2 = sessionHotsetEviction.hideGeneration;
        }
        if ((i & 8) != 0) {
            sessionHotsetEvictionReason = sessionHotsetEviction.reason;
        }
        if ((i & 16) != 0) {
            j3 = sessionHotsetEviction.retainedMs;
        }
        SessionHotsetEvictionReason sessionHotsetEvictionReason2 = sessionHotsetEvictionReason;
        long j4 = j2;
        return sessionHotsetEviction.copy(k, j, j4, sessionHotsetEvictionReason2, j3);
    }

    public final K component1() {
        return this.key;
    }

    public final long component2() {
        return this.entryToken;
    }

    public final long component3() {
        return this.hideGeneration;
    }

    public final SessionHotsetEvictionReason component4() {
        return this.reason;
    }

    public final long component5() {
        return this.retainedMs;
    }

    public final SessionHotsetEviction<K> copy(K k, long j, long j2, SessionHotsetEvictionReason reason, long j3) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        return new SessionHotsetEviction<>(k, j, j2, reason, j3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SessionHotsetEviction) {
            SessionHotsetEviction sessionHotsetEviction = (SessionHotsetEviction) obj;
            return Intrinsics.areEqual(this.key, sessionHotsetEviction.key) && this.entryToken == sessionHotsetEviction.entryToken && this.hideGeneration == sessionHotsetEviction.hideGeneration && this.reason == sessionHotsetEviction.reason && this.retainedMs == sessionHotsetEviction.retainedMs;
        }
        return false;
    }

    public int hashCode() {
        K k = this.key;
        return ((((((((k == null ? 0 : k.hashCode()) * 31) + Long.hashCode(this.entryToken)) * 31) + Long.hashCode(this.hideGeneration)) * 31) + this.reason.hashCode()) * 31) + Long.hashCode(this.retainedMs);
    }

    public String toString() {
        K k = this.key;
        long j = this.entryToken;
        long j2 = this.hideGeneration;
        SessionHotsetEvictionReason sessionHotsetEvictionReason = this.reason;
        return "SessionHotsetEviction(key=" + k + ", entryToken=" + j + ", hideGeneration=" + j2 + ", reason=" + sessionHotsetEvictionReason + ", retainedMs=" + this.retainedMs + ")";
    }

    public SessionHotsetEviction(K k, long j, long j2, SessionHotsetEvictionReason reason, long j3) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        this.key = k;
        this.entryToken = j;
        this.hideGeneration = j2;
        this.reason = reason;
        this.retainedMs = j3;
    }

    public final K getKey() {
        return this.key;
    }

    public final long getEntryToken() {
        return this.entryToken;
    }

    public final long getHideGeneration() {
        return this.hideGeneration;
    }

    public final SessionHotsetEvictionReason getReason() {
        return this.reason;
    }

    public final long getRetainedMs() {
        return this.retainedMs;
    }
}
