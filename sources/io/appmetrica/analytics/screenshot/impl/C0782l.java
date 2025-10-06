package io.appmetrica.analytics.screenshot.impl;

import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.screenshot.impl.l  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0782l {

    /* renamed from: a  reason: collision with root package name */
    public final C0779i f1328a;
    public final C0783m b;
    public final C0780j c;

    public C0782l(C0779i c0779i, C0783m c0783m, C0780j c0780j) {
        this.f1328a = c0779i;
        this.b = c0783m;
        this.c = c0780j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (Intrinsics.areEqual(C0782l.class, obj != null ? obj.getClass() : null)) {
            if (obj != null) {
                C0782l c0782l = (C0782l) obj;
                return Intrinsics.areEqual(this.f1328a, c0782l.f1328a) && Intrinsics.areEqual(this.b, c0782l.b) && Intrinsics.areEqual(this.c, c0782l.c);
            }
            throw new NullPointerException("null cannot be cast to non-null type io.appmetrica.analytics.screenshot.impl.config.client.model.ClientSideScreenshotConfig");
        }
        return false;
    }

    public final int hashCode() {
        C0779i c0779i = this.f1328a;
        int hashCode = (c0779i != null ? c0779i.hashCode() : 0) * 31;
        C0783m c0783m = this.b;
        int hashCode2 = (hashCode + (c0783m != null ? c0783m.hashCode() : 0)) * 31;
        C0780j c0780j = this.c;
        return hashCode2 + (c0780j != null ? c0780j.hashCode() : 0);
    }

    public final String toString() {
        return "ClientSideScreenshotConfig(apiCaptorConfig=" + this.f1328a + ", serviceCaptorConfig=" + this.b + ", contentObserverCaptorConfig=" + this.c + ')';
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public C0782l(D d) {
        this(r2, r3, r5 != null ? new C0780j(r5) : null);
        C0793x a2 = d.a();
        C0779i c0779i = a2 != null ? new C0779i(a2) : null;
        F c = d.c();
        C0783m c0783m = c != null ? new C0783m(c) : null;
        C0795z b = d.b();
    }
}
