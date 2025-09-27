package io.appmetrica.analytics.screenshot.impl;

import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.screenshot.impl.k  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0780k {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f1327a;
    public final C0781l b;

    public C0780k(boolean z, C0781l c0781l) {
        this.f1327a = z;
        this.b = c0781l;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (Intrinsics.areEqual(C0780k.class, obj != null ? obj.getClass() : null)) {
            if (obj != null) {
                C0780k c0780k = (C0780k) obj;
                return this.f1327a == c0780k.f1327a && Intrinsics.areEqual(this.b, c0780k.b);
            }
            throw new NullPointerException("null cannot be cast to non-null type io.appmetrica.analytics.screenshot.impl.config.client.model.ClientSideRemoteScreenshotConfig");
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = Boolean.hashCode(this.f1327a) * 31;
        C0781l c0781l = this.b;
        return hashCode + (c0781l != null ? c0781l.hashCode() : 0);
    }

    public final String toString() {
        return "ClientSideRemoteScreenshotConfig(enabled=" + this.f1327a + ", config=" + this.b + ')';
    }
}
