package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class Am {

    /* renamed from: a  reason: collision with root package name */
    public final int f342a;

    public Am(int i) {
        this.f342a = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Am) && this.f342a == ((Am) obj).f342a;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f342a);
    }

    public final String toString() {
        return "StartupUpdateConfig(intervalSeconds=" + this.f342a + ')';
    }
}
