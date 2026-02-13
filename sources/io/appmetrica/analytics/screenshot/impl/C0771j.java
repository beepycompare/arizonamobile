package io.appmetrica.analytics.screenshot.impl;

import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.screenshot.impl.j  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0771j {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f1473a;

    public C0771j(boolean z) {
        this.f1473a = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (Intrinsics.areEqual(C0771j.class, obj != null ? obj.getClass() : null)) {
            if (obj != null) {
                return this.f1473a == ((C0771j) obj).f1473a;
            }
            throw new NullPointerException("null cannot be cast to non-null type io.appmetrica.analytics.screenshot.impl.config.client.model.ClientSideApiCaptorConfig");
        }
        return false;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.f1473a);
    }

    public final String toString() {
        return "ClientSideApiCaptorConfig(enabled=" + this.f1473a + ')';
    }

    public C0771j(C0786z c0786z) {
        this(c0786z.a());
    }
}
