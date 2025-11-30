package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.x7  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0692x7 {

    /* renamed from: a  reason: collision with root package name */
    public final long f1196a;
    public final int b;

    public C0692x7(long j, int i) {
        this.f1196a = j;
        this.b = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0692x7) {
            C0692x7 c0692x7 = (C0692x7) obj;
            return this.f1196a == c0692x7.f1196a && this.b == c0692x7.b;
        }
        return false;
    }

    public final int hashCode() {
        return Integer.hashCode(this.b) + (Long.hashCode(this.f1196a) * 31);
    }

    public final String toString() {
        return "DecimalProtoModel(mantissa=" + this.f1196a + ", exponent=" + this.b + ')';
    }
}
