package io.appmetrica.analytics.screenshot.impl;
/* loaded from: classes4.dex */
public final class T {

    /* renamed from: a  reason: collision with root package name */
    public final C0773e f1286a;
    public final X b;
    public final C0783o c;

    public T(C0773e c0773e, X x, C0783o c0783o) {
        this.f1286a = c0773e;
        this.b = x;
        this.c = c0783o;
    }

    public final C0773e a() {
        return this.f1286a;
    }

    public final C0783o b() {
        return this.c;
    }

    public final X c() {
        return this.b;
    }

    public final String toString() {
        return "ScreenshotConfig(apiCaptorConfig=" + this.f1286a + ", serviceCaptorConfig=" + this.b + ", contentObserverCaptorConfig=" + this.c + ')';
    }

    public T() {
        this(new C0773e(), new X(), new C0783o());
    }
}
