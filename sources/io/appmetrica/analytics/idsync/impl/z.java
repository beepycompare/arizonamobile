package io.appmetrica.analytics.idsync.impl;

import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes3.dex */
public final class z {

    /* renamed from: a  reason: collision with root package name */
    public final String f480a;
    public final long b;
    public final int c;

    public z(String str, long j, int i) {
        this.f480a = str;
        this.b = j;
        this.c = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof z) {
            z zVar = (z) obj;
            return Intrinsics.areEqual(this.f480a, zVar.f480a) && this.b == zVar.b && this.c == zVar.c;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = Long.hashCode(this.b);
        return v.a(this.c) + ((hashCode + (this.f480a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return "RequestState(type=" + this.f480a + ", lastAttempt=" + this.b + ", lastAttemptResult=" + u.b(this.c) + ')';
    }
}
