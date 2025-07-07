package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class P7 {

    /* renamed from: a  reason: collision with root package name */
    public final long f576a;
    public final int b;

    public P7(int i, long j) {
        this.f576a = j;
        this.b = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof P7) {
            P7 p7 = (P7) obj;
            return this.f576a == p7.f576a && this.b == p7.b;
        }
        return false;
    }

    public final int hashCode() {
        return Integer.hashCode(this.b) + (Long.hashCode(this.f576a) * 31);
    }

    public final String toString() {
        return "DecimalProtoModel(mantissa=" + this.f576a + ", exponent=" + this.b + ')';
    }
}
