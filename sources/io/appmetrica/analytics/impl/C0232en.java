package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.en  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0232en {

    /* renamed from: a  reason: collision with root package name */
    public final int f971a;

    public C0232en(int i) {
        this.f971a = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C0232en) && this.f971a == ((C0232en) obj).f971a;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f971a);
    }

    public final String toString() {
        return "StartupUpdateConfig(intervalSeconds=" + this.f971a + ')';
    }
}
