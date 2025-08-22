package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class T7 {

    /* renamed from: a  reason: collision with root package name */
    public final long f658a;
    public final int b;

    public T7(int i, long j) {
        this.f658a = j;
        this.b = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof T7) {
            T7 t7 = (T7) obj;
            return this.f658a == t7.f658a && this.b == t7.b;
        }
        return false;
    }

    public final int hashCode() {
        return Integer.hashCode(this.b) + (Long.hashCode(this.f658a) * 31);
    }

    public final String toString() {
        return "DecimalProtoModel(mantissa=" + this.f658a + ", exponent=" + this.b + ')';
    }
}
