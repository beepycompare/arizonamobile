package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class Cm {

    /* renamed from: a  reason: collision with root package name */
    public final int f544a;

    public Cm(int i) {
        this.f544a = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Cm) && this.f544a == ((Cm) obj).f544a;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f544a);
    }

    public final String toString() {
        return "StartupUpdateConfig(intervalSeconds=" + this.f544a + ')';
    }
}
