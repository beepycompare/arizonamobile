package io.appmetrica.analytics.screenshot.impl;

import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.screenshot.impl.m  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0781m {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f1309a;
    public final long b;

    public C0781m(boolean z, long j) {
        this.f1309a = z;
        this.b = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (Intrinsics.areEqual(C0781m.class, obj != null ? obj.getClass() : null)) {
            if (obj != null) {
                C0781m c0781m = (C0781m) obj;
                return this.f1309a == c0781m.f1309a && this.b == c0781m.b;
            }
            throw new NullPointerException("null cannot be cast to non-null type io.appmetrica.analytics.screenshot.impl.config.client.model.ClientSideServiceCaptorConfig");
        }
        return false;
    }

    public final int hashCode() {
        return Long.hashCode(this.b) + (Boolean.hashCode(this.f1309a) * 31);
    }

    public final String toString() {
        return "ClientSideServiceCaptorConfig(enabled=" + this.f1309a + ", delaySeconds=" + this.b + ')';
    }

    public C0781m(F f) {
        this(f.b(), f.a());
    }
}
