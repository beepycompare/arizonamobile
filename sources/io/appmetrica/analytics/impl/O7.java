package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class O7 {

    /* renamed from: a  reason: collision with root package name */
    public final long f699a;
    public final int b;

    public O7(long j, int i) {
        this.f699a = j;
        this.b = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof O7) {
            O7 o7 = (O7) obj;
            return this.f699a == o7.f699a && this.b == o7.b;
        }
        return false;
    }

    public final int hashCode() {
        return Integer.hashCode(this.b) + (Long.hashCode(this.f699a) * 31);
    }

    public final String toString() {
        return "DecimalProtoModel(mantissa=" + this.f699a + ", exponent=" + this.b + ')';
    }
}
