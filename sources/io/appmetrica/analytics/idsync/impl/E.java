package io.appmetrica.analytics.idsync.impl;

import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class E {

    /* renamed from: a  reason: collision with root package name */
    public final String f415a;
    public final long b;
    public final A c;

    public E(String str, long j, A a2) {
        this.f415a = str;
        this.b = j;
        this.c = a2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof E) {
            E e = (E) obj;
            return Intrinsics.areEqual(this.f415a, e.f415a) && this.b == e.b && this.c == e.c;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = Long.hashCode(this.b);
        return this.c.hashCode() + ((hashCode + (this.f415a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return "RequestState(type=" + this.f415a + ", lastAttempt=" + this.b + ", lastAttemptResult=" + this.c + ')';
    }
}
