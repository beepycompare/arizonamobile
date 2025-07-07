package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class U9 {

    /* renamed from: a  reason: collision with root package name */
    public final long f656a;

    public U9(long j) {
        this.f656a = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof U9) && this.f656a == ((U9) obj).f656a;
    }

    public final int hashCode() {
        return Long.hashCode(this.f656a);
    }

    public final String toString() {
        return "ExternalAttributionConfig(collectingInterval=" + this.f656a + ')';
    }
}
