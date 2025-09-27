package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.ba  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0145ba {

    /* renamed from: a  reason: collision with root package name */
    public final long f809a;

    public C0145ba(long j) {
        this.f809a = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C0145ba) && this.f809a == ((C0145ba) obj).f809a;
    }

    public final int hashCode() {
        return Long.hashCode(this.f809a);
    }

    public final String toString() {
        return "ExternalAttributionConfig(collectingInterval=" + this.f809a + ')';
    }
}
