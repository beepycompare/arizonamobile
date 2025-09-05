package io.appmetrica.analytics.screenshot.impl;

import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.screenshot.impl.l  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0781l {

    /* renamed from: a  reason: collision with root package name */
    public final C0778i f1323a;
    public final C0782m b;
    public final C0779j c;

    public C0781l(C0778i c0778i, C0782m c0782m, C0779j c0779j) {
        this.f1323a = c0778i;
        this.b = c0782m;
        this.c = c0779j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (Intrinsics.areEqual(C0781l.class, obj != null ? obj.getClass() : null)) {
            if (obj != null) {
                C0781l c0781l = (C0781l) obj;
                return Intrinsics.areEqual(this.f1323a, c0781l.f1323a) && Intrinsics.areEqual(this.b, c0781l.b) && Intrinsics.areEqual(this.c, c0781l.c);
            }
            throw new NullPointerException("null cannot be cast to non-null type io.appmetrica.analytics.screenshot.impl.config.client.model.ClientSideScreenshotConfig");
        }
        return false;
    }

    public final int hashCode() {
        C0778i c0778i = this.f1323a;
        int hashCode = (c0778i != null ? c0778i.hashCode() : 0) * 31;
        C0782m c0782m = this.b;
        int hashCode2 = (hashCode + (c0782m != null ? c0782m.hashCode() : 0)) * 31;
        C0779j c0779j = this.c;
        return hashCode2 + (c0779j != null ? c0779j.hashCode() : 0);
    }

    public final String toString() {
        return "ClientSideScreenshotConfig(apiCaptorConfig=" + this.f1323a + ", serviceCaptorConfig=" + this.b + ", contentObserverCaptorConfig=" + this.c + ')';
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public C0781l(D d) {
        this(r2, r3, r5 != null ? new C0779j(r5) : null);
        C0792x a2 = d.a();
        C0778i c0778i = a2 != null ? new C0778i(a2) : null;
        F c = d.c();
        C0782m c0782m = c != null ? new C0782m(c) : null;
        C0794z b = d.b();
    }
}
