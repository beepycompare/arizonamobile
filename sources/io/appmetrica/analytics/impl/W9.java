package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class W9 {

    /* renamed from: a  reason: collision with root package name */
    public final long f825a;

    public W9(long j) {
        this.f825a = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof W9) && this.f825a == ((W9) obj).f825a;
    }

    public final int hashCode() {
        return Long.hashCode(this.f825a);
    }

    public final String toString() {
        return "ExternalAttributionConfig(collectingInterval=" + this.f825a + ')';
    }
}
