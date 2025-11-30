package io.appmetrica.analytics.screenshot.impl;

import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.screenshot.impl.m  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0771m {

    /* renamed from: a  reason: collision with root package name */
    public final C0768j f1373a;
    public final C0772n b;
    public final C0769k c;

    public C0771m(C0768j c0768j, C0772n c0772n, C0769k c0769k) {
        this.f1373a = c0768j;
        this.b = c0772n;
        this.c = c0769k;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (Intrinsics.areEqual(C0771m.class, obj != null ? obj.getClass() : null)) {
            if (obj != null) {
                C0771m c0771m = (C0771m) obj;
                return Intrinsics.areEqual(this.f1373a, c0771m.f1373a) && Intrinsics.areEqual(this.b, c0771m.b) && Intrinsics.areEqual(this.c, c0771m.c);
            }
            throw new NullPointerException("null cannot be cast to non-null type io.appmetrica.analytics.screenshot.impl.config.client.model.ClientSideScreenshotConfig");
        }
        return false;
    }

    public final int hashCode() {
        C0768j c0768j = this.f1373a;
        int hashCode = (c0768j != null ? c0768j.hashCode() : 0) * 31;
        C0772n c0772n = this.b;
        int hashCode2 = (hashCode + (c0772n != null ? c0772n.hashCode() : 0)) * 31;
        C0769k c0769k = this.c;
        return hashCode2 + (c0769k != null ? c0769k.hashCode() : 0);
    }

    public final String toString() {
        return "ClientSideScreenshotConfig(apiCaptorConfig=" + this.f1373a + ", serviceCaptorConfig=" + this.b + ", contentObserverCaptorConfig=" + this.c + ')';
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public C0771m(F f) {
        this(r2, r3, r5 != null ? new C0769k(r5) : null);
        C0783z a2 = f.a();
        C0768j c0768j = a2 != null ? new C0768j(a2) : null;
        H c = f.c();
        C0772n c0772n = c != null ? new C0772n(c) : null;
        B b = f.b();
    }
}
