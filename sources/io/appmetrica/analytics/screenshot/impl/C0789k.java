package io.appmetrica.analytics.screenshot.impl;

import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.screenshot.impl.k  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0789k {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f1453a;
    public final C0787i b;
    public final C0790l c;
    public final C0788j d;

    public C0789k(boolean z, C0787i c0787i, C0790l c0790l, C0788j c0788j) {
        this.f1453a = z;
        this.b = c0787i;
        this.c = c0790l;
        this.d = c0788j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0789k) {
            C0789k c0789k = (C0789k) obj;
            return this.f1453a == c0789k.f1453a && Intrinsics.areEqual(this.b, c0789k.b) && Intrinsics.areEqual(this.c, c0789k.c) && Intrinsics.areEqual(this.d, c0789k.d);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = Boolean.hashCode(this.f1453a) * 31;
        C0787i c0787i = this.b;
        int hashCode2 = (hashCode + (c0787i == null ? 0 : Boolean.hashCode(c0787i.f1451a))) * 31;
        C0790l c0790l = this.c;
        int hashCode3 = (hashCode2 + (c0790l == null ? 0 : c0790l.hashCode())) * 31;
        C0788j c0788j = this.d;
        return hashCode3 + (c0788j != null ? c0788j.hashCode() : 0);
    }

    public final String toString() {
        return "ClientSideScreenshotConfig(enabled=" + this.f1453a + ", apiCaptorConfig=" + this.b + ", serviceCaptorConfig=" + this.c + ", contentObserverCaptorConfig=" + this.d + ')';
    }
}
