package io.appmetrica.analytics.screenshot.impl;

import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.screenshot.impl.k  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0781k {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f1327a;
    public final C0782l b;

    public C0781k(boolean z, C0782l c0782l) {
        this.f1327a = z;
        this.b = c0782l;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (Intrinsics.areEqual(C0781k.class, obj != null ? obj.getClass() : null)) {
            if (obj != null) {
                C0781k c0781k = (C0781k) obj;
                return this.f1327a == c0781k.f1327a && Intrinsics.areEqual(this.b, c0781k.b);
            }
            throw new NullPointerException("null cannot be cast to non-null type io.appmetrica.analytics.screenshot.impl.config.client.model.ClientSideRemoteScreenshotConfig");
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = Boolean.hashCode(this.f1327a) * 31;
        C0782l c0782l = this.b;
        return hashCode + (c0782l != null ? c0782l.hashCode() : 0);
    }

    public final String toString() {
        return "ClientSideRemoteScreenshotConfig(enabled=" + this.f1327a + ", config=" + this.b + ')';
    }
}
