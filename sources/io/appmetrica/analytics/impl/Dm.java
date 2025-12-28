package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class Dm {

    /* renamed from: a  reason: collision with root package name */
    public final int f548a;

    public Dm(int i) {
        this.f548a = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Dm) && this.f548a == ((Dm) obj).f548a;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f548a);
    }

    public final String toString() {
        return "StartupUpdateConfig(intervalSeconds=" + this.f548a + ')';
    }
}
