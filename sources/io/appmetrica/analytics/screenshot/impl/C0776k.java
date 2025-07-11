package io.appmetrica.analytics.screenshot.impl;

import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.screenshot.impl.k  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0776k {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f1304a;
    public final C0777l b;

    public C0776k(boolean z, C0777l c0777l) {
        this.f1304a = z;
        this.b = c0777l;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (Intrinsics.areEqual(C0776k.class, obj != null ? obj.getClass() : null)) {
            if (obj != null) {
                C0776k c0776k = (C0776k) obj;
                return this.f1304a == c0776k.f1304a && Intrinsics.areEqual(this.b, c0776k.b);
            }
            throw new NullPointerException("null cannot be cast to non-null type io.appmetrica.analytics.screenshot.impl.config.client.model.ClientSideRemoteScreenshotConfig");
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = Boolean.hashCode(this.f1304a) * 31;
        C0777l c0777l = this.b;
        return hashCode + (c0777l != null ? c0777l.hashCode() : 0);
    }

    public final String toString() {
        return "ClientSideRemoteScreenshotConfig(enabled=" + this.f1304a + ", config=" + this.b + ')';
    }
}
