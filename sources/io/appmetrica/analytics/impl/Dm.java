package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class Dm {

    /* renamed from: a  reason: collision with root package name */
    public final int f547a;

    public Dm(int i) {
        this.f547a = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Dm) && this.f547a == ((Dm) obj).f547a;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f547a);
    }

    public final String toString() {
        return "StartupUpdateConfig(intervalSeconds=" + this.f547a + ')';
    }
}
