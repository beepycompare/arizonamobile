package io.appmetrica.analytics.screenshot.impl;

import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.screenshot.impl.k  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0779k {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f1307a;
    public final C0780l b;

    public C0779k(boolean z, C0780l c0780l) {
        this.f1307a = z;
        this.b = c0780l;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (Intrinsics.areEqual(C0779k.class, obj != null ? obj.getClass() : null)) {
            if (obj != null) {
                C0779k c0779k = (C0779k) obj;
                return this.f1307a == c0779k.f1307a && Intrinsics.areEqual(this.b, c0779k.b);
            }
            throw new NullPointerException("null cannot be cast to non-null type io.appmetrica.analytics.screenshot.impl.config.client.model.ClientSideRemoteScreenshotConfig");
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = Boolean.hashCode(this.f1307a) * 31;
        C0780l c0780l = this.b;
        return hashCode + (c0780l != null ? c0780l.hashCode() : 0);
    }

    public final String toString() {
        return "ClientSideRemoteScreenshotConfig(enabled=" + this.f1307a + ", config=" + this.b + ')';
    }
}
