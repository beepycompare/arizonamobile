package io.appmetrica.analytics.screenshot.impl;
/* renamed from: io.appmetrica.analytics.screenshot.impl.l  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0790l {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f1454a;
    public final long b;

    public C0790l(boolean z, long j) {
        this.f1454a = z;
        this.b = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0790l) {
            C0790l c0790l = (C0790l) obj;
            return this.f1454a == c0790l.f1454a && this.b == c0790l.b;
        }
        return false;
    }

    public final int hashCode() {
        return Long.hashCode(this.b) + (Boolean.hashCode(this.f1454a) * 31);
    }

    public final String toString() {
        return "ClientSideServiceCaptorConfig(enabled=" + this.f1454a + ", delaySeconds=" + this.b + ')';
    }
}
