package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class B9 {

    /* renamed from: a  reason: collision with root package name */
    public final long f515a;

    public B9(long j) {
        this.f515a = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof B9) && this.f515a == ((B9) obj).f515a;
    }

    public final int hashCode() {
        return Long.hashCode(this.f515a);
    }

    public final String toString() {
        return "ExternalAttributionConfig(collectingInterval=" + this.f515a + ')';
    }
}
