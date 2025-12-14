package io.appmetrica.analytics.screenshot.impl;

import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.screenshot.impl.n  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0771n {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f1471a;
    public final long b;

    public C0771n(boolean z, long j) {
        this.f1471a = z;
        this.b = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (Intrinsics.areEqual(C0771n.class, obj != null ? obj.getClass() : null)) {
            if (obj != null) {
                C0771n c0771n = (C0771n) obj;
                return this.f1471a == c0771n.f1471a && this.b == c0771n.b;
            }
            throw new NullPointerException("null cannot be cast to non-null type io.appmetrica.analytics.screenshot.impl.config.client.model.ClientSideServiceCaptorConfig");
        }
        return false;
    }

    public final int hashCode() {
        return Long.hashCode(this.b) + (Boolean.hashCode(this.f1471a) * 31);
    }

    public final String toString() {
        return "ClientSideServiceCaptorConfig(enabled=" + this.f1471a + ", delaySeconds=" + this.b + ')';
    }

    public C0771n(H h) {
        this(h.b(), h.a());
    }
}
