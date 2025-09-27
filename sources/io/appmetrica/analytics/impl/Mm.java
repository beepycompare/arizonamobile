package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class Mm {

    /* renamed from: a  reason: collision with root package name */
    public final int f583a;

    public Mm(int i) {
        this.f583a = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Mm) && this.f583a == ((Mm) obj).f583a;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f583a);
    }

    public final String toString() {
        return "StartupUpdateConfig(intervalSeconds=" + this.f583a + ')';
    }
}
