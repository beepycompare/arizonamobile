package io.appmetrica.analytics.screenshot.impl;
/* loaded from: classes4.dex */
public final class i0 {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f1324a;
    public final long b;

    public i0(boolean z, long j) {
        this.f1324a = z;
        this.b = j;
    }

    public final long a() {
        return this.b;
    }

    public final boolean b() {
        return this.f1324a;
    }

    public final String toString() {
        return "ServiceSideServiceCaptorConfig(enabled=" + this.f1324a + ", delaySeconds=" + this.b + ')';
    }

    public i0(X x) {
        this(x.b(), x.a());
    }
}
