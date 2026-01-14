package io.appmetrica.analytics.screenshot.impl;

import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.screenshot.impl.n  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0775n {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f1481a;
    public final long b;

    public C0775n(boolean z, long j) {
        this.f1481a = z;
        this.b = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (Intrinsics.areEqual(C0775n.class, obj != null ? obj.getClass() : null)) {
            if (obj != null) {
                C0775n c0775n = (C0775n) obj;
                return this.f1481a == c0775n.f1481a && this.b == c0775n.b;
            }
            throw new NullPointerException("null cannot be cast to non-null type io.appmetrica.analytics.screenshot.impl.config.client.model.ClientSideServiceCaptorConfig");
        }
        return false;
    }

    public final int hashCode() {
        return Long.hashCode(this.b) + (Boolean.hashCode(this.f1481a) * 31);
    }

    public final String toString() {
        return "ClientSideServiceCaptorConfig(enabled=" + this.f1481a + ", delaySeconds=" + this.b + ')';
    }

    public C0775n(H h) {
        this(h.b(), h.a());
    }
}
