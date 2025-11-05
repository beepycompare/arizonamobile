package io.appmetrica.analytics.screenshot.impl;

import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.screenshot.impl.j  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0768j {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f1365a;

    public C0768j(boolean z) {
        this.f1365a = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (Intrinsics.areEqual(C0768j.class, obj != null ? obj.getClass() : null)) {
            if (obj != null) {
                return this.f1365a == ((C0768j) obj).f1365a;
            }
            throw new NullPointerException("null cannot be cast to non-null type io.appmetrica.analytics.screenshot.impl.config.client.model.ClientSideApiCaptorConfig");
        }
        return false;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.f1365a);
    }

    public final String toString() {
        return "ClientSideApiCaptorConfig(enabled=" + this.f1365a + ')';
    }

    public C0768j(C0783z c0783z) {
        this(c0783z.a());
    }
}
