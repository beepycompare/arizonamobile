package io.appmetrica.analytics.screenshot.impl;

import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.screenshot.impl.l  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0769l {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f1468a;
    public final C0770m b;

    public C0769l(boolean z, C0770m c0770m) {
        this.f1468a = z;
        this.b = c0770m;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (Intrinsics.areEqual(C0769l.class, obj != null ? obj.getClass() : null)) {
            if (obj != null) {
                C0769l c0769l = (C0769l) obj;
                return this.f1468a == c0769l.f1468a && Intrinsics.areEqual(this.b, c0769l.b);
            }
            throw new NullPointerException("null cannot be cast to non-null type io.appmetrica.analytics.screenshot.impl.config.client.model.ClientSideRemoteScreenshotConfig");
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = Boolean.hashCode(this.f1468a) * 31;
        C0770m c0770m = this.b;
        return hashCode + (c0770m != null ? c0770m.hashCode() : 0);
    }

    public final String toString() {
        return "ClientSideRemoteScreenshotConfig(enabled=" + this.f1468a + ", config=" + this.b + ')';
    }
}
