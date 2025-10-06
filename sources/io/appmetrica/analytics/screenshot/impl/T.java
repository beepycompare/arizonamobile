package io.appmetrica.analytics.screenshot.impl;
/* loaded from: classes4.dex */
public final class T {

    /* renamed from: a  reason: collision with root package name */
    public final C0775e f1306a;
    public final X b;
    public final C0785o c;

    public T(C0775e c0775e, X x, C0785o c0785o) {
        this.f1306a = c0775e;
        this.b = x;
        this.c = c0785o;
    }

    public final C0775e a() {
        return this.f1306a;
    }

    public final C0785o b() {
        return this.c;
    }

    public final X c() {
        return this.b;
    }

    public final String toString() {
        return "ScreenshotConfig(apiCaptorConfig=" + this.f1306a + ", serviceCaptorConfig=" + this.b + ", contentObserverCaptorConfig=" + this.c + ')';
    }

    public T() {
        this(new C0775e(), new X(), new C0785o());
    }
}
