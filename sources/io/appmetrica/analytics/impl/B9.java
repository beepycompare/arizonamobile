package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class B9 {

    /* renamed from: a  reason: collision with root package name */
    public final long f520a;

    public B9(long j) {
        this.f520a = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof B9) && this.f520a == ((B9) obj).f520a;
    }

    public final int hashCode() {
        return Long.hashCode(this.f520a);
    }

    public final String toString() {
        return "ExternalAttributionConfig(collectingInterval=" + this.f520a + ')';
    }
}
