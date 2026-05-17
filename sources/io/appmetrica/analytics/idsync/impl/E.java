package io.appmetrica.analytics.idsync.impl;

import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class E {

    /* renamed from: a  reason: collision with root package name */
    public final String f465a;
    public final long b;
    public final int c;

    public E(String str, long j, int i) {
        this.f465a = str;
        this.b = j;
        this.c = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof E) {
            E e = (E) obj;
            return Intrinsics.areEqual(this.f465a, e.f465a) && this.b == e.b && this.c == e.c;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = Long.hashCode(this.b);
        return A.a(this.c) + ((hashCode + (this.f465a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return "RequestState(type=" + this.f465a + ", lastAttempt=" + this.b + ", lastAttemptResult=" + z.b(this.c) + ')';
    }
}
