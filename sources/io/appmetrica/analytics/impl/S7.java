package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class S7 {

    /* renamed from: a  reason: collision with root package name */
    public final long f635a;
    public final int b;

    public S7(int i, long j) {
        this.f635a = j;
        this.b = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof S7) {
            S7 s7 = (S7) obj;
            return this.f635a == s7.f635a && this.b == s7.b;
        }
        return false;
    }

    public final int hashCode() {
        return Integer.hashCode(this.b) + (Long.hashCode(this.f635a) * 31);
    }

    public final String toString() {
        return "DecimalProtoModel(mantissa=" + this.f635a + ", exponent=" + this.b + ')';
    }
}
