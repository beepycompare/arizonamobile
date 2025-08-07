package io.appmetrica.analytics.screenshot.impl;

import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.screenshot.impl.l  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0780l {

    /* renamed from: a  reason: collision with root package name */
    public final C0777i f1308a;
    public final C0781m b;
    public final C0778j c;

    public C0780l(C0777i c0777i, C0781m c0781m, C0778j c0778j) {
        this.f1308a = c0777i;
        this.b = c0781m;
        this.c = c0778j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (Intrinsics.areEqual(C0780l.class, obj != null ? obj.getClass() : null)) {
            if (obj != null) {
                C0780l c0780l = (C0780l) obj;
                return Intrinsics.areEqual(this.f1308a, c0780l.f1308a) && Intrinsics.areEqual(this.b, c0780l.b) && Intrinsics.areEqual(this.c, c0780l.c);
            }
            throw new NullPointerException("null cannot be cast to non-null type io.appmetrica.analytics.screenshot.impl.config.client.model.ClientSideScreenshotConfig");
        }
        return false;
    }

    public final int hashCode() {
        C0777i c0777i = this.f1308a;
        int hashCode = (c0777i != null ? c0777i.hashCode() : 0) * 31;
        C0781m c0781m = this.b;
        int hashCode2 = (hashCode + (c0781m != null ? c0781m.hashCode() : 0)) * 31;
        C0778j c0778j = this.c;
        return hashCode2 + (c0778j != null ? c0778j.hashCode() : 0);
    }

    public final String toString() {
        return "ClientSideScreenshotConfig(apiCaptorConfig=" + this.f1308a + ", serviceCaptorConfig=" + this.b + ", contentObserverCaptorConfig=" + this.c + ')';
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public C0780l(D d) {
        this(r2, r3, r5 != null ? new C0778j(r5) : null);
        C0791x a2 = d.a();
        C0777i c0777i = a2 != null ? new C0777i(a2) : null;
        F c = d.c();
        C0781m c0781m = c != null ? new C0781m(c) : null;
        C0793z b = d.b();
    }
}
