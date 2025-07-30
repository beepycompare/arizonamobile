package io.appmetrica.analytics.screenshot.impl;

import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.screenshot.impl.i  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0776i {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f1305a;

    public C0776i(boolean z) {
        this.f1305a = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (Intrinsics.areEqual(C0776i.class, obj != null ? obj.getClass() : null)) {
            if (obj != null) {
                return this.f1305a == ((C0776i) obj).f1305a;
            }
            throw new NullPointerException("null cannot be cast to non-null type io.appmetrica.analytics.screenshot.impl.config.client.model.ClientSideApiCaptorConfig");
        }
        return false;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.f1305a);
    }

    public final String toString() {
        return "ClientSideApiCaptorConfig(enabled=" + this.f1305a + ')';
    }

    public C0776i(C0790x c0790x) {
        this(c0790x.a());
    }
}
