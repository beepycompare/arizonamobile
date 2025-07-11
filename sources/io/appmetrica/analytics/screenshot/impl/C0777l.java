package io.appmetrica.analytics.screenshot.impl;

import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.screenshot.impl.l  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0777l {

    /* renamed from: a  reason: collision with root package name */
    public final C0774i f1305a;
    public final C0778m b;
    public final C0775j c;

    public C0777l(C0774i c0774i, C0778m c0778m, C0775j c0775j) {
        this.f1305a = c0774i;
        this.b = c0778m;
        this.c = c0775j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (Intrinsics.areEqual(C0777l.class, obj != null ? obj.getClass() : null)) {
            if (obj != null) {
                C0777l c0777l = (C0777l) obj;
                return Intrinsics.areEqual(this.f1305a, c0777l.f1305a) && Intrinsics.areEqual(this.b, c0777l.b) && Intrinsics.areEqual(this.c, c0777l.c);
            }
            throw new NullPointerException("null cannot be cast to non-null type io.appmetrica.analytics.screenshot.impl.config.client.model.ClientSideScreenshotConfig");
        }
        return false;
    }

    public final int hashCode() {
        C0774i c0774i = this.f1305a;
        int hashCode = (c0774i != null ? c0774i.hashCode() : 0) * 31;
        C0778m c0778m = this.b;
        int hashCode2 = (hashCode + (c0778m != null ? c0778m.hashCode() : 0)) * 31;
        C0775j c0775j = this.c;
        return hashCode2 + (c0775j != null ? c0775j.hashCode() : 0);
    }

    public final String toString() {
        return "ClientSideScreenshotConfig(apiCaptorConfig=" + this.f1305a + ", serviceCaptorConfig=" + this.b + ", contentObserverCaptorConfig=" + this.c + ')';
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public C0777l(D d) {
        this(r2, r3, r5 != null ? new C0775j(r5) : null);
        C0788x a2 = d.a();
        C0774i c0774i = a2 != null ? new C0774i(a2) : null;
        F c = d.c();
        C0778m c0778m = c != null ? new C0778m(c) : null;
        C0790z b = d.b();
    }
}
