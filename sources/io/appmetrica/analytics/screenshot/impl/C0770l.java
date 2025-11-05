package io.appmetrica.analytics.screenshot.impl;

import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.screenshot.impl.l  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0770l {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f1369a;
    public final C0771m b;

    public C0770l(boolean z, C0771m c0771m) {
        this.f1369a = z;
        this.b = c0771m;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (Intrinsics.areEqual(C0770l.class, obj != null ? obj.getClass() : null)) {
            if (obj != null) {
                C0770l c0770l = (C0770l) obj;
                return this.f1369a == c0770l.f1369a && Intrinsics.areEqual(this.b, c0770l.b);
            }
            throw new NullPointerException("null cannot be cast to non-null type io.appmetrica.analytics.screenshot.impl.config.client.model.ClientSideRemoteScreenshotConfig");
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = Boolean.hashCode(this.f1369a) * 31;
        C0771m c0771m = this.b;
        return hashCode + (c0771m != null ? c0771m.hashCode() : 0);
    }

    public final String toString() {
        return "ClientSideRemoteScreenshotConfig(enabled=" + this.f1369a + ", config=" + this.b + ')';
    }
}
