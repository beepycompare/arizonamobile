package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class Am {

    /* renamed from: a  reason: collision with root package name */
    public final int f341a;

    public Am(int i) {
        this.f341a = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Am) && this.f341a == ((Am) obj).f341a;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f341a);
    }

    public final String toString() {
        return "StartupUpdateConfig(intervalSeconds=" + this.f341a + ')';
    }
}
