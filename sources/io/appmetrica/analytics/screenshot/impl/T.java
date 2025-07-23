package io.appmetrica.analytics.screenshot.impl;
/* loaded from: classes4.dex */
public final class T {

    /* renamed from: a  reason: collision with root package name */
    public final C0772e f1286a;
    public final X b;
    public final C0782o c;

    public T(C0772e c0772e, X x, C0782o c0782o) {
        this.f1286a = c0772e;
        this.b = x;
        this.c = c0782o;
    }

    public final C0772e a() {
        return this.f1286a;
    }

    public final C0782o b() {
        return this.c;
    }

    public final X c() {
        return this.b;
    }

    public final String toString() {
        return "ScreenshotConfig(apiCaptorConfig=" + this.f1286a + ", serviceCaptorConfig=" + this.b + ", contentObserverCaptorConfig=" + this.c + ')';
    }

    public T() {
        this(new C0772e(), new X(), new C0782o());
    }
}
