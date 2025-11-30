package io.appmetrica.analytics.screenshot.impl;

import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.screenshot.impl.n  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0772n {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f1374a;
    public final long b;

    public C0772n(boolean z, long j) {
        this.f1374a = z;
        this.b = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (Intrinsics.areEqual(C0772n.class, obj != null ? obj.getClass() : null)) {
            if (obj != null) {
                C0772n c0772n = (C0772n) obj;
                return this.f1374a == c0772n.f1374a && this.b == c0772n.b;
            }
            throw new NullPointerException("null cannot be cast to non-null type io.appmetrica.analytics.screenshot.impl.config.client.model.ClientSideServiceCaptorConfig");
        }
        return false;
    }

    public final int hashCode() {
        return Long.hashCode(this.b) + (Boolean.hashCode(this.f1374a) * 31);
    }

    public final String toString() {
        return "ClientSideServiceCaptorConfig(enabled=" + this.f1374a + ", delaySeconds=" + this.b + ')';
    }

    public C0772n(H h) {
        this(h.b(), h.a());
    }
}
