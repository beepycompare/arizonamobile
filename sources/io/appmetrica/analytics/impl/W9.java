package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class W9 {

    /* renamed from: a  reason: collision with root package name */
    public final long f828a;

    public W9(long j) {
        this.f828a = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof W9) && this.f828a == ((W9) obj).f828a;
    }

    public final int hashCode() {
        return Long.hashCode(this.f828a);
    }

    public final String toString() {
        return "ExternalAttributionConfig(collectingInterval=" + this.f828a + ')';
    }
}
