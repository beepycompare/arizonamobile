package io.appmetrica.analytics.idsync.impl;

import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class E {

    /* renamed from: a  reason: collision with root package name */
    public final String f418a;
    public final long b;
    public final A c;

    public E(String str, long j, A a2) {
        this.f418a = str;
        this.b = j;
        this.c = a2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof E) {
            E e = (E) obj;
            return Intrinsics.areEqual(this.f418a, e.f418a) && this.b == e.b && this.c == e.c;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = Long.hashCode(this.b);
        return this.c.hashCode() + ((hashCode + (this.f418a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return "RequestState(type=" + this.f418a + ", lastAttempt=" + this.b + ", lastAttemptResult=" + this.c + ')';
    }
}
