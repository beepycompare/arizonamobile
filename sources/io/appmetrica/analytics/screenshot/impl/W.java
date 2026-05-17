package io.appmetrica.analytics.screenshot.impl;
/* loaded from: classes5.dex */
public final class W {

    /* renamed from: a  reason: collision with root package name */
    public final C0765e f1462a;
    public final a0 b;
    public final C0776p c;

    public W(C0765e c0765e, a0 a0Var, C0776p c0776p) {
        this.f1462a = c0765e;
        this.b = a0Var;
        this.c = c0776p;
    }

    public final C0765e a() {
        return this.f1462a;
    }

    public final C0776p b() {
        return this.c;
    }

    public final a0 c() {
        return this.b;
    }

    public final String toString() {
        return "ScreenshotConfig(apiCaptorConfig=" + this.f1462a + ", serviceCaptorConfig=" + this.b + ", contentObserverCaptorConfig=" + this.c + ')';
    }

    public W() {
        this(new C0765e(), new a0(), new C0776p());
    }
}
