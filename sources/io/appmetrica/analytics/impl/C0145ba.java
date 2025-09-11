package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.ba  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0145ba {

    /* renamed from: a  reason: collision with root package name */
    public final long f808a;

    public C0145ba(long j) {
        this.f808a = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C0145ba) && this.f808a == ((C0145ba) obj).f808a;
    }

    public final int hashCode() {
        return Long.hashCode(this.f808a);
    }

    public final String toString() {
        return "ExternalAttributionConfig(collectingInterval=" + this.f808a + ')';
    }
}
