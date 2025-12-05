package io.appmetrica.analytics.screenshot.impl;

import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.screenshot.impl.m  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0770m {

    /* renamed from: a  reason: collision with root package name */
    public final C0767j f1456a;
    public final C0771n b;
    public final C0768k c;

    public C0770m(C0767j c0767j, C0771n c0771n, C0768k c0768k) {
        this.f1456a = c0767j;
        this.b = c0771n;
        this.c = c0768k;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (Intrinsics.areEqual(C0770m.class, obj != null ? obj.getClass() : null)) {
            if (obj != null) {
                C0770m c0770m = (C0770m) obj;
                return Intrinsics.areEqual(this.f1456a, c0770m.f1456a) && Intrinsics.areEqual(this.b, c0770m.b) && Intrinsics.areEqual(this.c, c0770m.c);
            }
            throw new NullPointerException("null cannot be cast to non-null type io.appmetrica.analytics.screenshot.impl.config.client.model.ClientSideScreenshotConfig");
        }
        return false;
    }

    public final int hashCode() {
        C0767j c0767j = this.f1456a;
        int hashCode = (c0767j != null ? c0767j.hashCode() : 0) * 31;
        C0771n c0771n = this.b;
        int hashCode2 = (hashCode + (c0771n != null ? c0771n.hashCode() : 0)) * 31;
        C0768k c0768k = this.c;
        return hashCode2 + (c0768k != null ? c0768k.hashCode() : 0);
    }

    public final String toString() {
        return "ClientSideScreenshotConfig(apiCaptorConfig=" + this.f1456a + ", serviceCaptorConfig=" + this.b + ", contentObserverCaptorConfig=" + this.c + ')';
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public C0770m(F f) {
        this(r2, r3, r5 != null ? new C0768k(r5) : null);
        C0782z a2 = f.a();
        C0767j c0767j = a2 != null ? new C0767j(a2) : null;
        H c = f.c();
        C0771n c0771n = c != null ? new C0771n(c) : null;
        B b = f.b();
    }
}
