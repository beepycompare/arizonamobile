package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class Dm {

    /* renamed from: a  reason: collision with root package name */
    public final int f402a;

    public Dm(int i) {
        this.f402a = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Dm) && this.f402a == ((Dm) obj).f402a;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f402a);
    }

    public final String toString() {
        return "StartupUpdateConfig(intervalSeconds=" + this.f402a + ')';
    }
}
