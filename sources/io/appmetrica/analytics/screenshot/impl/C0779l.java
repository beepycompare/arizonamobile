package io.appmetrica.analytics.screenshot.impl;

import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.screenshot.impl.l  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0779l {

    /* renamed from: a  reason: collision with root package name */
    public final C0776i f1309a;
    public final C0780m b;
    public final C0777j c;

    public C0779l(C0776i c0776i, C0780m c0780m, C0777j c0777j) {
        this.f1309a = c0776i;
        this.b = c0780m;
        this.c = c0777j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (Intrinsics.areEqual(C0779l.class, obj != null ? obj.getClass() : null)) {
            if (obj != null) {
                C0779l c0779l = (C0779l) obj;
                return Intrinsics.areEqual(this.f1309a, c0779l.f1309a) && Intrinsics.areEqual(this.b, c0779l.b) && Intrinsics.areEqual(this.c, c0779l.c);
            }
            throw new NullPointerException("null cannot be cast to non-null type io.appmetrica.analytics.screenshot.impl.config.client.model.ClientSideScreenshotConfig");
        }
        return false;
    }

    public final int hashCode() {
        C0776i c0776i = this.f1309a;
        int hashCode = (c0776i != null ? c0776i.hashCode() : 0) * 31;
        C0780m c0780m = this.b;
        int hashCode2 = (hashCode + (c0780m != null ? c0780m.hashCode() : 0)) * 31;
        C0777j c0777j = this.c;
        return hashCode2 + (c0777j != null ? c0777j.hashCode() : 0);
    }

    public final String toString() {
        return "ClientSideScreenshotConfig(apiCaptorConfig=" + this.f1309a + ", serviceCaptorConfig=" + this.b + ", contentObserverCaptorConfig=" + this.c + ')';
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public C0779l(D d) {
        this(r2, r3, r5 != null ? new C0777j(r5) : null);
        C0790x a2 = d.a();
        C0776i c0776i = a2 != null ? new C0776i(a2) : null;
        F c = d.c();
        C0780m c0780m = c != null ? new C0780m(c) : null;
        C0792z b = d.b();
    }
}
