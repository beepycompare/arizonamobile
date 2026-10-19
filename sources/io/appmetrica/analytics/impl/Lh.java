package io.appmetrica.analytics.impl;

import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class Lh {

    /* renamed from: a  reason: collision with root package name */
    public final long f653a;
    public final C0756z9 b;
    public final int c;

    public Lh(long j, C0756z9 c0756z9, int i) {
        this.f653a = j;
        this.b = c0756z9;
        this.c = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Lh) {
            Lh lh = (Lh) obj;
            return this.f653a == lh.f653a && Intrinsics.areEqual(this.b, lh.b) && this.c == lh.c;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.b.hashCode();
        return Integer.hashCode(this.c) + ((hashCode + (Long.hashCode(this.f653a) * 31)) * 31);
    }

    public final String toString() {
        return "SessionCandidate(sessionId=" + this.f653a + ", sessionDesc=" + this.b + ", sessionTypeCode=" + this.c + ')';
    }
}
