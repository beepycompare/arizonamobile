package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class C9 {

    /* renamed from: a  reason: collision with root package name */
    public final long f427a;

    public C9(long j) {
        this.f427a = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C9) && this.f427a == ((C9) obj).f427a;
    }

    public final int hashCode() {
        return Long.hashCode(this.f427a);
    }

    public final String toString() {
        return "ExternalAttributionConfig(collectingInterval=" + this.f427a + ')';
    }
}
