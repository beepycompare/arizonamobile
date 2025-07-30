package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class S7 {

    /* renamed from: a  reason: collision with root package name */
    public final long f636a;
    public final int b;

    public S7(int i, long j) {
        this.f636a = j;
        this.b = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof S7) {
            S7 s7 = (S7) obj;
            return this.f636a == s7.f636a && this.b == s7.b;
        }
        return false;
    }

    public final int hashCode() {
        return Integer.hashCode(this.b) + (Long.hashCode(this.f636a) * 31);
    }

    public final String toString() {
        return "DecimalProtoModel(mantissa=" + this.f636a + ", exponent=" + this.b + ')';
    }
}
