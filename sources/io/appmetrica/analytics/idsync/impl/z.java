package io.appmetrica.analytics.idsync.impl;

import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes3.dex */
public final class z {

    /* renamed from: a  reason: collision with root package name */
    public final String f479a;
    public final long b;
    public final int c;

    public z(String str, long j, int i) {
        this.f479a = str;
        this.b = j;
        this.c = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof z) {
            z zVar = (z) obj;
            return Intrinsics.areEqual(this.f479a, zVar.f479a) && this.b == zVar.b && this.c == zVar.c;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = Long.hashCode(this.b);
        return v.a(this.c) + ((hashCode + (this.f479a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return "RequestState(type=" + this.f479a + ", lastAttempt=" + this.b + ", lastAttemptResult=" + u.b(this.c) + ')';
    }
}
