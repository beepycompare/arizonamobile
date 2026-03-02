package io.appmetrica.analytics.screenshot.impl;

import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.screenshot.impl.l  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0772l {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f1477a;
    public final C0773m b;

    public C0772l(boolean z, C0773m c0773m) {
        this.f1477a = z;
        this.b = c0773m;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (Intrinsics.areEqual(C0772l.class, obj != null ? obj.getClass() : null)) {
            if (obj != null) {
                C0772l c0772l = (C0772l) obj;
                return this.f1477a == c0772l.f1477a && Intrinsics.areEqual(this.b, c0772l.b);
            }
            throw new NullPointerException("null cannot be cast to non-null type io.appmetrica.analytics.screenshot.impl.config.client.model.ClientSideRemoteScreenshotConfig");
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = Boolean.hashCode(this.f1477a) * 31;
        C0773m c0773m = this.b;
        return hashCode + (c0773m != null ? c0773m.hashCode() : 0);
    }

    public final String toString() {
        return "ClientSideRemoteScreenshotConfig(enabled=" + this.f1477a + ", config=" + this.b + ')';
    }
}
