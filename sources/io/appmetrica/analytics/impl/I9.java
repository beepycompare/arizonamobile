package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class I9 {

    /* renamed from: a  reason: collision with root package name */
    public final long f524a;

    public I9(long j) {
        this.f524a = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof I9) && this.f524a == ((I9) obj).f524a;
    }

    public final int hashCode() {
        return Long.hashCode(this.f524a);
    }

    public final String toString() {
        return "ExternalAttributionConfig(collectingInterval=" + this.f524a + ')';
    }
}
