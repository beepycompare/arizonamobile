package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class Mm {

    /* renamed from: a  reason: collision with root package name */
    public final int f582a;

    public Mm(int i) {
        this.f582a = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Mm) && this.f582a == ((Mm) obj).f582a;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f582a);
    }

    public final String toString() {
        return "StartupUpdateConfig(intervalSeconds=" + this.f582a + ')';
    }
}
