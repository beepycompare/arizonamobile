package io.appmetrica.analytics.impl;
/* loaded from: classes3.dex */
public final class E7 {

    /* renamed from: a  reason: collision with root package name */
    public final long f454a;
    public final int b;

    public E7(int i, long j) {
        this.f454a = j;
        this.b = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof E7) {
            E7 e7 = (E7) obj;
            return this.f454a == e7.f454a && this.b == e7.b;
        }
        return false;
    }

    public final int hashCode() {
        return Integer.hashCode(this.b) + (Long.hashCode(this.f454a) * 31);
    }

    public final String toString() {
        return "DecimalProtoModel(mantissa=" + this.f454a + ", exponent=" + this.b + ')';
    }
}
