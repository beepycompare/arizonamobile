package io.appmetrica.analytics.screenshot.impl;
/* loaded from: classes4.dex */
public final class T {

    /* renamed from: a  reason: collision with root package name */
    public final C0774e f1305a;
    public final X b;
    public final C0784o c;

    public T(C0774e c0774e, X x, C0784o c0784o) {
        this.f1305a = c0774e;
        this.b = x;
        this.c = c0784o;
    }

    public final C0774e a() {
        return this.f1305a;
    }

    public final C0784o b() {
        return this.c;
    }

    public final X c() {
        return this.b;
    }

    public final String toString() {
        return "ScreenshotConfig(apiCaptorConfig=" + this.f1305a + ", serviceCaptorConfig=" + this.b + ", contentObserverCaptorConfig=" + this.c + ')';
    }

    public T() {
        this(new C0774e(), new X(), new C0784o());
    }
}
