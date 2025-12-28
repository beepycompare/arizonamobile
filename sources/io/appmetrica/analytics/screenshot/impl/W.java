package io.appmetrica.analytics.screenshot.impl;
/* loaded from: classes5.dex */
public final class W {

    /* renamed from: a  reason: collision with root package name */
    public final C0762e f1449a;
    public final a0 b;
    public final C0773p c;

    public W(C0762e c0762e, a0 a0Var, C0773p c0773p) {
        this.f1449a = c0762e;
        this.b = a0Var;
        this.c = c0773p;
    }

    public final C0762e a() {
        return this.f1449a;
    }

    public final C0773p b() {
        return this.c;
    }

    public final a0 c() {
        return this.b;
    }

    public final String toString() {
        return "ScreenshotConfig(apiCaptorConfig=" + this.f1449a + ", serviceCaptorConfig=" + this.b + ", contentObserverCaptorConfig=" + this.c + ')';
    }

    public W() {
        this(new C0762e(), new a0(), new C0773p());
    }
}
