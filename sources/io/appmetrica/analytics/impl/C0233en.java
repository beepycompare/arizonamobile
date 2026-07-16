package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.en  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0233en {

    /* renamed from: a  reason: collision with root package name */
    public final int f971a;

    public C0233en(int i) {
        this.f971a = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C0233en) && this.f971a == ((C0233en) obj).f971a;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f971a);
    }

    public final String toString() {
        return "StartupUpdateConfig(intervalSeconds=" + this.f971a + ')';
    }
}
