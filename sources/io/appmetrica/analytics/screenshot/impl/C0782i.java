package io.appmetrica.analytics.screenshot.impl;

import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.screenshot.impl.i  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0782i {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f1300a;

    public C0782i(boolean z) {
        this.f1300a = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (Intrinsics.areEqual(C0782i.class, obj != null ? obj.getClass() : null)) {
            if (obj != null) {
                return this.f1300a == ((C0782i) obj).f1300a;
            }
            throw new NullPointerException("null cannot be cast to non-null type io.appmetrica.analytics.screenshot.impl.config.client.model.ClientSideApiCaptorConfig");
        }
        return false;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.f1300a);
    }

    public final String toString() {
        return "ClientSideApiCaptorConfig(enabled=" + this.f1300a + ')';
    }

    public C0782i(C0796x c0796x) {
        this(c0796x.a());
    }
}
