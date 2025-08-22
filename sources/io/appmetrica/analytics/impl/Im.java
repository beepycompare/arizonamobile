package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class Im {

    /* renamed from: a  reason: collision with root package name */
    public final int f502a;

    public Im(int i) {
        this.f502a = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Im) && this.f502a == ((Im) obj).f502a;
    }

    public final int hashCode() {
        return Integer.hashCode(this.f502a);
    }

    public final String toString() {
        return "StartupUpdateConfig(intervalSeconds=" + this.f502a + ')';
    }
}
