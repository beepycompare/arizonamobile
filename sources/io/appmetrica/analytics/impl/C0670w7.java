package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.w7  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0670w7 {

    /* renamed from: a  reason: collision with root package name */
    public final long f1284a;
    public final int b;

    public C0670w7(long j, int i) {
        this.f1284a = j;
        this.b = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0670w7) {
            C0670w7 c0670w7 = (C0670w7) obj;
            return this.f1284a == c0670w7.f1284a && this.b == c0670w7.b;
        }
        return false;
    }

    public final int hashCode() {
        return Integer.hashCode(this.b) + (Long.hashCode(this.f1284a) * 31);
    }

    public final String toString() {
        return "DecimalProtoModel(mantissa=" + this.f1284a + ", exponent=" + this.b + ')';
    }
}
