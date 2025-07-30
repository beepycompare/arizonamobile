package io.appmetrica.analytics.screenshot.impl;

import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.screenshot.impl.k  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0778k {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f1308a;
    public final C0779l b;

    public C0778k(boolean z, C0779l c0779l) {
        this.f1308a = z;
        this.b = c0779l;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (Intrinsics.areEqual(C0778k.class, obj != null ? obj.getClass() : null)) {
            if (obj != null) {
                C0778k c0778k = (C0778k) obj;
                return this.f1308a == c0778k.f1308a && Intrinsics.areEqual(this.b, c0778k.b);
            }
            throw new NullPointerException("null cannot be cast to non-null type io.appmetrica.analytics.screenshot.impl.config.client.model.ClientSideRemoteScreenshotConfig");
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = Boolean.hashCode(this.f1308a) * 31;
        C0779l c0779l = this.b;
        return hashCode + (c0779l != null ? c0779l.hashCode() : 0);
    }

    public final String toString() {
        return "ClientSideRemoteScreenshotConfig(enabled=" + this.f1308a + ", config=" + this.b + ')';
    }
}
