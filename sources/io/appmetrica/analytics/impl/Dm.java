package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class Dm {

    /* renamed from: a  reason: collision with root package name */
    public final int f533a;

    public Dm(int i) {
        this.f533a = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Dm) && this.f533a == ((Dm) obj).f533a;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f533a);
    }

    public final String toString() {
        return "StartupUpdateConfig(intervalSeconds=" + this.f533a + ')';
    }
}
