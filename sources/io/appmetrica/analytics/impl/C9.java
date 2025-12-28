package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class C9 {

    /* renamed from: a  reason: collision with root package name */
    public final long f525a;

    public C9(long j) {
        this.f525a = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C9) && this.f525a == ((C9) obj).f525a;
    }

    public final int hashCode() {
        return Long.hashCode(this.f525a);
    }

    public final String toString() {
        return "ExternalAttributionConfig(collectingInterval=" + this.f525a + ')';
    }
}
