package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class W7 {

    /* renamed from: a  reason: collision with root package name */
    public final long f725a;
    public final int b;

    public W7(int i, long j) {
        this.f725a = j;
        this.b = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof W7) {
            W7 w7 = (W7) obj;
            return this.f725a == w7.f725a && this.b == w7.b;
        }
        return false;
    }

    public final int hashCode() {
        return Integer.hashCode(this.b) + (Long.hashCode(this.f725a) * 31);
    }

    public final String toString() {
        return "DecimalProtoModel(mantissa=" + this.f725a + ", exponent=" + this.b + ')';
    }
}
