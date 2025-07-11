package io.appmetrica.analytics.screenshot.impl;
/* loaded from: classes4.dex */
public final class X {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f1287a;
    public final long b;

    public X(boolean z, long j) {
        this.f1287a = z;
        this.b = j;
    }

    public final long a() {
        return this.b;
    }

    public final boolean b() {
        return this.f1287a;
    }

    public final String toString() {
        return "ServiceCaptorConfig(enabled=" + this.f1287a + ", delaySeconds=" + this.b + ')';
    }

    public X() {
        this(new M().f1279a, new M().b);
    }
}
