package io.appmetrica.analytics.screenshot.impl;

import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.screenshot.impl.i  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0774i {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f1301a;

    public C0774i(boolean z) {
        this.f1301a = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (Intrinsics.areEqual(C0774i.class, obj != null ? obj.getClass() : null)) {
            if (obj != null) {
                return this.f1301a == ((C0774i) obj).f1301a;
            }
            throw new NullPointerException("null cannot be cast to non-null type io.appmetrica.analytics.screenshot.impl.config.client.model.ClientSideApiCaptorConfig");
        }
        return false;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.f1301a);
    }

    public final String toString() {
        return "ClientSideApiCaptorConfig(enabled=" + this.f1301a + ')';
    }

    public C0774i(C0788x c0788x) {
        this(c0788x.a());
    }
}
