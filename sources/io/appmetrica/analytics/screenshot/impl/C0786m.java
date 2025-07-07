package io.appmetrica.analytics.screenshot.impl;

import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.screenshot.impl.m  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0786m {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f1305a;
    public final long b;

    public C0786m(boolean z, long j) {
        this.f1305a = z;
        this.b = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (Intrinsics.areEqual(C0786m.class, obj != null ? obj.getClass() : null)) {
            if (obj != null) {
                C0786m c0786m = (C0786m) obj;
                return this.f1305a == c0786m.f1305a && this.b == c0786m.b;
            }
            throw new NullPointerException("null cannot be cast to non-null type io.appmetrica.analytics.screenshot.impl.config.client.model.ClientSideServiceCaptorConfig");
        }
        return false;
    }

    public final int hashCode() {
        return Long.hashCode(this.b) + (Boolean.hashCode(this.f1305a) * 31);
    }

    public final String toString() {
        return "ClientSideServiceCaptorConfig(enabled=" + this.f1305a + ", delaySeconds=" + this.b + ')';
    }

    public C0786m(F f) {
        this(f.b(), f.a());
    }
}
