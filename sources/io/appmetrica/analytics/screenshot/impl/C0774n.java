package io.appmetrica.analytics.screenshot.impl;

import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.screenshot.impl.n  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0774n {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f1485a;
    public final long b;

    public C0774n(boolean z, long j) {
        this.f1485a = z;
        this.b = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (Intrinsics.areEqual(C0774n.class, obj != null ? obj.getClass() : null)) {
            if (obj != null) {
                C0774n c0774n = (C0774n) obj;
                return this.f1485a == c0774n.f1485a && this.b == c0774n.b;
            }
            throw new NullPointerException("null cannot be cast to non-null type io.appmetrica.analytics.screenshot.impl.config.client.model.ClientSideServiceCaptorConfig");
        }
        return false;
    }

    public final int hashCode() {
        return Long.hashCode(this.b) + (Boolean.hashCode(this.f1485a) * 31);
    }

    public final String toString() {
        return "ClientSideServiceCaptorConfig(enabled=" + this.f1485a + ", delaySeconds=" + this.b + ')';
    }

    public C0774n(H h) {
        this(h.b(), h.a());
    }
}
