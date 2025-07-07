package io.appmetrica.analytics.screenshot.impl;

import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.screenshot.impl.l  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0785l {

    /* renamed from: a  reason: collision with root package name */
    public final C0782i f1304a;
    public final C0786m b;
    public final C0783j c;

    public C0785l(C0782i c0782i, C0786m c0786m, C0783j c0783j) {
        this.f1304a = c0782i;
        this.b = c0786m;
        this.c = c0783j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (Intrinsics.areEqual(C0785l.class, obj != null ? obj.getClass() : null)) {
            if (obj != null) {
                C0785l c0785l = (C0785l) obj;
                return Intrinsics.areEqual(this.f1304a, c0785l.f1304a) && Intrinsics.areEqual(this.b, c0785l.b) && Intrinsics.areEqual(this.c, c0785l.c);
            }
            throw new NullPointerException("null cannot be cast to non-null type io.appmetrica.analytics.screenshot.impl.config.client.model.ClientSideScreenshotConfig");
        }
        return false;
    }

    public final int hashCode() {
        C0782i c0782i = this.f1304a;
        int hashCode = (c0782i != null ? c0782i.hashCode() : 0) * 31;
        C0786m c0786m = this.b;
        int hashCode2 = (hashCode + (c0786m != null ? c0786m.hashCode() : 0)) * 31;
        C0783j c0783j = this.c;
        return hashCode2 + (c0783j != null ? c0783j.hashCode() : 0);
    }

    public final String toString() {
        return "ClientSideScreenshotConfig(apiCaptorConfig=" + this.f1304a + ", serviceCaptorConfig=" + this.b + ", contentObserverCaptorConfig=" + this.c + ')';
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public C0785l(D d) {
        this(r2, r3, r5 != null ? new C0783j(r5) : null);
        C0796x a2 = d.a();
        C0782i c0782i = a2 != null ? new C0782i(a2) : null;
        F c = d.c();
        C0786m c0786m = c != null ? new C0786m(c) : null;
        C0798z b = d.b();
    }
}
