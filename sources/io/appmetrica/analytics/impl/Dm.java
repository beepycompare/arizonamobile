package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class Dm {

    /* renamed from: a  reason: collision with root package name */
    public final int f403a;

    public Dm(int i) {
        this.f403a = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Dm) && this.f403a == ((Dm) obj).f403a;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f403a);
    }

    public final String toString() {
        return "StartupUpdateConfig(intervalSeconds=" + this.f403a + ')';
    }
}
