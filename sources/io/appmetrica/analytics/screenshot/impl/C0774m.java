package io.appmetrica.analytics.screenshot.impl;

import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.screenshot.impl.m  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0774m {

    /* renamed from: a  reason: collision with root package name */
    public final C0771j f1479a;
    public final C0775n b;
    public final C0772k c;

    public C0774m(C0771j c0771j, C0775n c0775n, C0772k c0772k) {
        this.f1479a = c0771j;
        this.b = c0775n;
        this.c = c0772k;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (Intrinsics.areEqual(C0774m.class, obj != null ? obj.getClass() : null)) {
            if (obj != null) {
                C0774m c0774m = (C0774m) obj;
                return Intrinsics.areEqual(this.f1479a, c0774m.f1479a) && Intrinsics.areEqual(this.b, c0774m.b) && Intrinsics.areEqual(this.c, c0774m.c);
            }
            throw new NullPointerException("null cannot be cast to non-null type io.appmetrica.analytics.screenshot.impl.config.client.model.ClientSideScreenshotConfig");
        }
        return false;
    }

    public final int hashCode() {
        C0771j c0771j = this.f1479a;
        int hashCode = (c0771j != null ? c0771j.hashCode() : 0) * 31;
        C0775n c0775n = this.b;
        int hashCode2 = (hashCode + (c0775n != null ? c0775n.hashCode() : 0)) * 31;
        C0772k c0772k = this.c;
        return hashCode2 + (c0772k != null ? c0772k.hashCode() : 0);
    }

    public final String toString() {
        return "ClientSideScreenshotConfig(apiCaptorConfig=" + this.f1479a + ", serviceCaptorConfig=" + this.b + ", contentObserverCaptorConfig=" + this.c + ')';
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public C0774m(F f) {
        this(r2, r3, r5 != null ? new C0772k(r5) : null);
        C0786z a2 = f.a();
        C0771j c0771j = a2 != null ? new C0771j(a2) : null;
        H c = f.c();
        C0775n c0775n = c != null ? new C0775n(c) : null;
        B b = f.b();
    }
}
