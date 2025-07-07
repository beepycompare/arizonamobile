package io.appmetrica.analytics.screenshot.impl;
/* loaded from: classes4.dex */
public final class T {

    /* renamed from: a  reason: collision with root package name */
    public final C0778e f1282a;
    public final X b;
    public final C0788o c;

    public T(C0778e c0778e, X x, C0788o c0788o) {
        this.f1282a = c0778e;
        this.b = x;
        this.c = c0788o;
    }

    public final C0778e a() {
        return this.f1282a;
    }

    public final C0788o b() {
        return this.c;
    }

    public final X c() {
        return this.b;
    }

    public final String toString() {
        return "ScreenshotConfig(apiCaptorConfig=" + this.f1282a + ", serviceCaptorConfig=" + this.b + ", contentObserverCaptorConfig=" + this.c + ')';
    }

    public T() {
        this(new C0778e(), new X(), new C0788o());
    }
}
