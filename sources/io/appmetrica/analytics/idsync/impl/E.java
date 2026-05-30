package io.appmetrica.analytics.idsync.impl;

import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class E {

    /* renamed from: a  reason: collision with root package name */
    public final String f416a;
    public final long b;
    public final A c;

    public E(String str, long j, A a2) {
        this.f416a = str;
        this.b = j;
        this.c = a2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof E) {
            E e = (E) obj;
            return Intrinsics.areEqual(this.f416a, e.f416a) && this.b == e.b && this.c == e.c;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = Long.hashCode(this.b);
        return this.c.hashCode() + ((hashCode + (this.f416a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return "RequestState(type=" + this.f416a + ", lastAttempt=" + this.b + ", lastAttemptResult=" + this.c + ')';
    }
}
