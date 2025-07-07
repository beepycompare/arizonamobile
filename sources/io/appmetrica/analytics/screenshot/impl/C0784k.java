package io.appmetrica.analytics.screenshot.impl;

import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.screenshot.impl.k  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0784k {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f1303a;
    public final C0785l b;

    public C0784k(boolean z, C0785l c0785l) {
        this.f1303a = z;
        this.b = c0785l;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (Intrinsics.areEqual(C0784k.class, obj != null ? obj.getClass() : null)) {
            if (obj != null) {
                C0784k c0784k = (C0784k) obj;
                return this.f1303a == c0784k.f1303a && Intrinsics.areEqual(this.b, c0784k.b);
            }
            throw new NullPointerException("null cannot be cast to non-null type io.appmetrica.analytics.screenshot.impl.config.client.model.ClientSideRemoteScreenshotConfig");
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = Boolean.hashCode(this.f1303a) * 31;
        C0785l c0785l = this.b;
        return hashCode + (c0785l != null ? c0785l.hashCode() : 0);
    }

    public final String toString() {
        return "ClientSideRemoteScreenshotConfig(enabled=" + this.f1303a + ", config=" + this.b + ')';
    }
}
