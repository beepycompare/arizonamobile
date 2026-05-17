package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.w7  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0669w7 {

    /* renamed from: a  reason: collision with root package name */
    public final long f1288a;
    public final int b;

    public C0669w7(long j, int i) {
        this.f1288a = j;
        this.b = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0669w7) {
            C0669w7 c0669w7 = (C0669w7) obj;
            return this.f1288a == c0669w7.f1288a && this.b == c0669w7.b;
        }
        return false;
    }

    public final int hashCode() {
        return Integer.hashCode(this.b) + (Long.hashCode(this.f1288a) * 31);
    }

    public final String toString() {
        return "DecimalProtoModel(mantissa=" + this.f1288a + ", exponent=" + this.b + ')';
    }
}
