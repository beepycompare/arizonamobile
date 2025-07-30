package io.appmetrica.analytics.screenshot.impl;

import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.screenshot.impl.m  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0780m {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f1310a;
    public final long b;

    public C0780m(boolean z, long j) {
        this.f1310a = z;
        this.b = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (Intrinsics.areEqual(C0780m.class, obj != null ? obj.getClass() : null)) {
            if (obj != null) {
                C0780m c0780m = (C0780m) obj;
                return this.f1310a == c0780m.f1310a && this.b == c0780m.b;
            }
            throw new NullPointerException("null cannot be cast to non-null type io.appmetrica.analytics.screenshot.impl.config.client.model.ClientSideServiceCaptorConfig");
        }
        return false;
    }

    public final int hashCode() {
        return Long.hashCode(this.b) + (Boolean.hashCode(this.f1310a) * 31);
    }

    public final String toString() {
        return "ClientSideServiceCaptorConfig(enabled=" + this.f1310a + ", delaySeconds=" + this.b + ')';
    }

    public C0780m(F f) {
        this(f.b(), f.a());
    }
}
