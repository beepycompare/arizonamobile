package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.x7  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0691x7 {

    /* renamed from: a  reason: collision with root package name */
    public final long f1293a;
    public final int b;

    public C0691x7(long j, int i) {
        this.f1293a = j;
        this.b = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0691x7) {
            C0691x7 c0691x7 = (C0691x7) obj;
            return this.f1293a == c0691x7.f1293a && this.b == c0691x7.b;
        }
        return false;
    }

    public final int hashCode() {
        return Integer.hashCode(this.b) + (Long.hashCode(this.f1293a) * 31);
    }

    public final String toString() {
        return "DecimalProtoModel(mantissa=" + this.f1293a + ", exponent=" + this.b + ')';
    }
}
