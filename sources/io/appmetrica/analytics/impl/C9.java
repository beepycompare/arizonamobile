package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class C9 {

    /* renamed from: a  reason: collision with root package name */
    public final long f524a;

    public C9(long j) {
        this.f524a = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C9) && this.f524a == ((C9) obj).f524a;
    }

    public final int hashCode() {
        return Long.hashCode(this.f524a);
    }

    public final String toString() {
        return "ExternalAttributionConfig(collectingInterval=" + this.f524a + ')';
    }
}
