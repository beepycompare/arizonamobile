package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class P7 {

    /* renamed from: a  reason: collision with root package name */
    public final long f577a;
    public final int b;

    public P7(int i, long j) {
        this.f577a = j;
        this.b = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof P7) {
            P7 p7 = (P7) obj;
            return this.f577a == p7.f577a && this.b == p7.b;
        }
        return false;
    }

    public final int hashCode() {
        return Integer.hashCode(this.b) + (Long.hashCode(this.f577a) * 31);
    }

    public final String toString() {
        return "DecimalProtoModel(mantissa=" + this.f577a + ", exponent=" + this.b + ')';
    }
}
