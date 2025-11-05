package io.appmetrica.analytics.impl;
/* loaded from: classes3.dex */
public final class Gm {

    /* renamed from: a  reason: collision with root package name */
    public final int f496a;

    public Gm(int i) {
        this.f496a = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Gm) && this.f496a == ((Gm) obj).f496a;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f496a);
    }

    public final String toString() {
        return "StartupUpdateConfig(intervalSeconds=" + this.f496a + ')';
    }
}
