package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.kl  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0379kl {

    /* renamed from: a  reason: collision with root package name */
    public final long f1075a;
    public final int b;
    public final long c;
    public final boolean d;

    public C0379kl(long j, int i, long j2, boolean z) {
        this.f1075a = j;
        this.b = i;
        this.c = j2;
        this.d = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0379kl) {
            C0379kl c0379kl = (C0379kl) obj;
            return this.f1075a == c0379kl.f1075a && this.b == c0379kl.b && this.c == c0379kl.c && this.d == c0379kl.d;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = Long.hashCode(this.c);
        return Boolean.hashCode(this.d) + ((hashCode + (((Long.hashCode(this.f1075a) * 31) + this.b) * 31)) * 31);
    }
}
