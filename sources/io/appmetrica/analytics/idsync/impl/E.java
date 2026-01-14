package io.appmetrica.analytics.idsync.impl;

import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes3.dex */
public final class E {

    /* renamed from: a  reason: collision with root package name */
    public final String f461a;
    public final long b;
    public final int c;

    public E(String str, long j, int i) {
        this.f461a = str;
        this.b = j;
        this.c = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof E) {
            E e = (E) obj;
            return Intrinsics.areEqual(this.f461a, e.f461a) && this.b == e.b && this.c == e.c;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = Long.hashCode(this.b);
        return A.a(this.c) + ((hashCode + (this.f461a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return "RequestState(type=" + this.f461a + ", lastAttempt=" + this.b + ", lastAttemptResult=" + z.b(this.c) + ')';
    }
}
