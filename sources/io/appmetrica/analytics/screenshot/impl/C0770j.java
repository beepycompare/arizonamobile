package io.appmetrica.analytics.screenshot.impl;

import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.screenshot.impl.j  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0770j {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f1478a;

    public C0770j(boolean z) {
        this.f1478a = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (Intrinsics.areEqual(C0770j.class, obj != null ? obj.getClass() : null)) {
            if (obj != null) {
                return this.f1478a == ((C0770j) obj).f1478a;
            }
            throw new NullPointerException("null cannot be cast to non-null type io.appmetrica.analytics.screenshot.impl.config.client.model.ClientSideApiCaptorConfig");
        }
        return false;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.f1478a);
    }

    public final String toString() {
        return "ClientSideApiCaptorConfig(enabled=" + this.f1478a + ')';
    }

    public C0770j(C0785z c0785z) {
        this(c0785z.a());
    }
}
