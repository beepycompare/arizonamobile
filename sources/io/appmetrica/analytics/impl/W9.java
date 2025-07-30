package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class W9 {

    /* renamed from: a  reason: collision with root package name */
    public final long f700a;

    public W9(long j) {
        this.f700a = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof W9) && this.f700a == ((W9) obj).f700a;
    }

    public final int hashCode() {
        return Long.hashCode(this.f700a);
    }

    public final String toString() {
        return "ExternalAttributionConfig(collectingInterval=" + this.f700a + ')';
    }
}
