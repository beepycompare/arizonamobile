package io.appmetrica.analytics.screenshot.impl;

import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.screenshot.impl.m  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0778m {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f1306a;
    public final long b;

    public C0778m(boolean z, long j) {
        this.f1306a = z;
        this.b = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (Intrinsics.areEqual(C0778m.class, obj != null ? obj.getClass() : null)) {
            if (obj != null) {
                C0778m c0778m = (C0778m) obj;
                return this.f1306a == c0778m.f1306a && this.b == c0778m.b;
            }
            throw new NullPointerException("null cannot be cast to non-null type io.appmetrica.analytics.screenshot.impl.config.client.model.ClientSideServiceCaptorConfig");
        }
        return false;
    }

    public final int hashCode() {
        return Long.hashCode(this.b) + (Boolean.hashCode(this.f1306a) * 31);
    }

    public final String toString() {
        return "ClientSideServiceCaptorConfig(enabled=" + this.f1306a + ", delaySeconds=" + this.b + ')';
    }

    public C0778m(F f) {
        this(f.b(), f.a());
    }
}
