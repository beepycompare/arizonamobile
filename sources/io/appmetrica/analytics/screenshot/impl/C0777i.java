package io.appmetrica.analytics.screenshot.impl;

import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.screenshot.impl.i  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0777i {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f1304a;

    public C0777i(boolean z) {
        this.f1304a = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (Intrinsics.areEqual(C0777i.class, obj != null ? obj.getClass() : null)) {
            if (obj != null) {
                return this.f1304a == ((C0777i) obj).f1304a;
            }
            throw new NullPointerException("null cannot be cast to non-null type io.appmetrica.analytics.screenshot.impl.config.client.model.ClientSideApiCaptorConfig");
        }
        return false;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.f1304a);
    }

    public final String toString() {
        return "ClientSideApiCaptorConfig(enabled=" + this.f1304a + ')';
    }

    public C0777i(C0791x c0791x) {
        this(c0791x.a());
    }
}
