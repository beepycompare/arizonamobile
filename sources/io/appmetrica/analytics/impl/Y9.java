package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class Y9 {

    /* renamed from: a  reason: collision with root package name */
    public final long f739a;

    public Y9(long j) {
        this.f739a = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Y9) && this.f739a == ((Y9) obj).f739a;
    }

    public final int hashCode() {
        return Long.hashCode(this.f739a);
    }

    public final String toString() {
        return "ExternalAttributionConfig(collectingInterval=" + this.f739a + ')';
    }
}
