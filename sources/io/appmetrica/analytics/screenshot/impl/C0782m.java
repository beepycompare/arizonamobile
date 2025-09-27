package io.appmetrica.analytics.screenshot.impl;

import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.screenshot.impl.m  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0782m {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f1329a;
    public final long b;

    public C0782m(boolean z, long j) {
        this.f1329a = z;
        this.b = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (Intrinsics.areEqual(C0782m.class, obj != null ? obj.getClass() : null)) {
            if (obj != null) {
                C0782m c0782m = (C0782m) obj;
                return this.f1329a == c0782m.f1329a && this.b == c0782m.b;
            }
            throw new NullPointerException("null cannot be cast to non-null type io.appmetrica.analytics.screenshot.impl.config.client.model.ClientSideServiceCaptorConfig");
        }
        return false;
    }

    public final int hashCode() {
        return Long.hashCode(this.b) + (Boolean.hashCode(this.f1329a) * 31);
    }

    public final String toString() {
        return "ClientSideServiceCaptorConfig(enabled=" + this.f1329a + ", delaySeconds=" + this.b + ')';
    }

    public C0782m(F f) {
        this(f.b(), f.a());
    }
}
