package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.en  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0226en {

    /* renamed from: a  reason: collision with root package name */
    public final int f974a;

    public C0226en(int i) {
        this.f974a = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C0226en) && this.f974a == ((C0226en) obj).f974a;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f974a);
    }

    public final String toString() {
        return "StartupUpdateConfig(intervalSeconds=" + this.f974a + ')';
    }
}
