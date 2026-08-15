package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.kl  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0385kl {

    /* renamed from: a  reason: collision with root package name */
    public final long f1072a;
    public final int b;
    public final long c;
    public final boolean d;

    public C0385kl(long j, int i, long j2, boolean z) {
        this.f1072a = j;
        this.b = i;
        this.c = j2;
        this.d = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0385kl) {
            C0385kl c0385kl = (C0385kl) obj;
            return this.f1072a == c0385kl.f1072a && this.b == c0385kl.b && this.c == c0385kl.c && this.d == c0385kl.d;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = Long.hashCode(this.c);
        return Boolean.hashCode(this.d) + ((hashCode + (((Long.hashCode(this.f1072a) * 31) + this.b) * 31)) * 31);
    }
}
