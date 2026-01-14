package io.appmetrica.analytics.screenshot.impl;
/* loaded from: classes5.dex */
public final class W {

    /* renamed from: a  reason: collision with root package name */
    public final C0766e f1458a;
    public final a0 b;
    public final C0777p c;

    public W(C0766e c0766e, a0 a0Var, C0777p c0777p) {
        this.f1458a = c0766e;
        this.b = a0Var;
        this.c = c0777p;
    }

    public final C0766e a() {
        return this.f1458a;
    }

    public final C0777p b() {
        return this.c;
    }

    public final a0 c() {
        return this.b;
    }

    public final String toString() {
        return "ScreenshotConfig(apiCaptorConfig=" + this.f1458a + ", serviceCaptorConfig=" + this.b + ", contentObserverCaptorConfig=" + this.c + ')';
    }

    public W() {
        this(new C0766e(), new a0(), new C0777p());
    }
}
