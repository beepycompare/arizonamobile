package io.appmetrica.analytics.screenshot.impl;
/* loaded from: classes3.dex */
public final class a0 {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f1354a;
    public final long b;

    public a0(boolean z, long j) {
        this.f1354a = z;
        this.b = j;
    }

    public final long a() {
        return this.b;
    }

    public final boolean b() {
        return this.f1354a;
    }

    public final String toString() {
        return "ServiceCaptorConfig(enabled=" + this.f1354a + ", delaySeconds=" + this.b + ')';
    }

    public a0() {
        this(new P().f1345a, new P().b);
    }
}
