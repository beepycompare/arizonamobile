package io.appmetrica.analytics.screenshot.impl;

import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.screenshot.impl.i  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0778i {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f1319a;

    public C0778i(boolean z) {
        this.f1319a = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (Intrinsics.areEqual(C0778i.class, obj != null ? obj.getClass() : null)) {
            if (obj != null) {
                return this.f1319a == ((C0778i) obj).f1319a;
            }
            throw new NullPointerException("null cannot be cast to non-null type io.appmetrica.analytics.screenshot.impl.config.client.model.ClientSideApiCaptorConfig");
        }
        return false;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.f1319a);
    }

    public final String toString() {
        return "ClientSideApiCaptorConfig(enabled=" + this.f1319a + ')';
    }

    public C0778i(C0792x c0792x) {
        this(c0792x.a());
    }
}
