package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class Cm {

    /* renamed from: a  reason: collision with root package name */
    public final int f540a;

    public Cm(int i) {
        this.f540a = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Cm) && this.f540a == ((Cm) obj).f540a;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f540a);
    }

    public final String toString() {
        return "StartupUpdateConfig(intervalSeconds=" + this.f540a + ')';
    }
}
