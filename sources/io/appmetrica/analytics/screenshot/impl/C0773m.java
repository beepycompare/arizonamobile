package io.appmetrica.analytics.screenshot.impl;

import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.screenshot.impl.m  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0773m {

    /* renamed from: a  reason: collision with root package name */
    public final C0770j f1484a;
    public final C0774n b;
    public final C0771k c;

    public C0773m(C0770j c0770j, C0774n c0774n, C0771k c0771k) {
        this.f1484a = c0770j;
        this.b = c0774n;
        this.c = c0771k;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (Intrinsics.areEqual(C0773m.class, obj != null ? obj.getClass() : null)) {
            if (obj != null) {
                C0773m c0773m = (C0773m) obj;
                return Intrinsics.areEqual(this.f1484a, c0773m.f1484a) && Intrinsics.areEqual(this.b, c0773m.b) && Intrinsics.areEqual(this.c, c0773m.c);
            }
            throw new NullPointerException("null cannot be cast to non-null type io.appmetrica.analytics.screenshot.impl.config.client.model.ClientSideScreenshotConfig");
        }
        return false;
    }

    public final int hashCode() {
        C0770j c0770j = this.f1484a;
        int hashCode = (c0770j != null ? c0770j.hashCode() : 0) * 31;
        C0774n c0774n = this.b;
        int hashCode2 = (hashCode + (c0774n != null ? c0774n.hashCode() : 0)) * 31;
        C0771k c0771k = this.c;
        return hashCode2 + (c0771k != null ? c0771k.hashCode() : 0);
    }

    public final String toString() {
        return "ClientSideScreenshotConfig(apiCaptorConfig=" + this.f1484a + ", serviceCaptorConfig=" + this.b + ", contentObserverCaptorConfig=" + this.c + ')';
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public C0773m(F f) {
        this(r2, r3, r5 != null ? new C0771k(r5) : null);
        C0785z a2 = f.a();
        C0770j c0770j = a2 != null ? new C0770j(a2) : null;
        H c = f.c();
        C0774n c0774n = c != null ? new C0774n(c) : null;
        B b = f.b();
    }
}
