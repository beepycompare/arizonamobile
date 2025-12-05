package io.appmetrica.analytics.screenshot.impl;

import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.screenshot.impl.j  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0767j {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f1450a;

    public C0767j(boolean z) {
        this.f1450a = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (Intrinsics.areEqual(C0767j.class, obj != null ? obj.getClass() : null)) {
            if (obj != null) {
                return this.f1450a == ((C0767j) obj).f1450a;
            }
            throw new NullPointerException("null cannot be cast to non-null type io.appmetrica.analytics.screenshot.impl.config.client.model.ClientSideApiCaptorConfig");
        }
        return false;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.f1450a);
    }

    public final String toString() {
        return "ClientSideApiCaptorConfig(enabled=" + this.f1450a + ')';
    }

    public C0767j(C0782z c0782z) {
        this(c0782z.a());
    }
}
