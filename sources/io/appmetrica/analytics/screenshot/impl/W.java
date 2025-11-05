package io.appmetrica.analytics.screenshot.impl;
/* loaded from: classes3.dex */
public final class W {

    /* renamed from: a  reason: collision with root package name */
    public final C0763e f1349a;
    public final a0 b;
    public final C0774p c;

    public W(C0763e c0763e, a0 a0Var, C0774p c0774p) {
        this.f1349a = c0763e;
        this.b = a0Var;
        this.c = c0774p;
    }

    public final C0763e a() {
        return this.f1349a;
    }

    public final C0774p b() {
        return this.c;
    }

    public final a0 c() {
        return this.b;
    }

    public final String toString() {
        return "ScreenshotConfig(apiCaptorConfig=" + this.f1349a + ", serviceCaptorConfig=" + this.b + ", contentObserverCaptorConfig=" + this.c + ')';
    }

    public W() {
        this(new C0763e(), new a0(), new C0774p());
    }
}
