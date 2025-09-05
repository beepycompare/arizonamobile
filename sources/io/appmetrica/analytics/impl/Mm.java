package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class Mm {

    /* renamed from: a  reason: collision with root package name */
    public final int f578a;

    public Mm(int i) {
        this.f578a = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Mm) && this.f578a == ((Mm) obj).f578a;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f578a);
    }

    public final String toString() {
        return "StartupUpdateConfig(intervalSeconds=" + this.f578a + ')';
    }
}
