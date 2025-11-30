package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class Dm {

    /* renamed from: a  reason: collision with root package name */
    public final int f450a;

    public Dm(int i) {
        this.f450a = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Dm) && this.f450a == ((Dm) obj).f450a;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f450a);
    }

    public final String toString() {
        return "StartupUpdateConfig(intervalSeconds=" + this.f450a + ')';
    }
}
