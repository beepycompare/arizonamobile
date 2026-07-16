package io.appmetrica.analytics.screenshot.impl;
/* renamed from: io.appmetrica.analytics.screenshot.impl.i  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0787i {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f1451a;

    public C0787i(boolean z) {
        this.f1451a = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C0787i) && this.f1451a == ((C0787i) obj).f1451a;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.f1451a);
    }

    public final String toString() {
        return "ClientSideApiCaptorConfig(enabled=" + this.f1451a + ')';
    }
}
