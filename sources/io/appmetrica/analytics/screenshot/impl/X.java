package io.appmetrica.analytics.screenshot.impl;
/* loaded from: classes4.dex */
public final class X {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f1310a;
    public final long b;

    public X(boolean z, long j) {
        this.f1310a = z;
        this.b = j;
    }

    public final long a() {
        return this.b;
    }

    public final boolean b() {
        return this.f1310a;
    }

    public final String toString() {
        return "ServiceCaptorConfig(enabled=" + this.f1310a + ", delaySeconds=" + this.b + ')';
    }

    public X() {
        this(new M().f1302a, new M().b);
    }
}
