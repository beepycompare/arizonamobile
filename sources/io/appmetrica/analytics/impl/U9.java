package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class U9 {

    /* renamed from: a  reason: collision with root package name */
    public final long f657a;

    public U9(long j) {
        this.f657a = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof U9) && this.f657a == ((U9) obj).f657a;
    }

    public final int hashCode() {
        return Long.hashCode(this.f657a);
    }

    public final String toString() {
        return "ExternalAttributionConfig(collectingInterval=" + this.f657a + ')';
    }
}
