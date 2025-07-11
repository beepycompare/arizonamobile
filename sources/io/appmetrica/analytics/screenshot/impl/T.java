package io.appmetrica.analytics.screenshot.impl;
/* loaded from: classes4.dex */
public final class T {

    /* renamed from: a  reason: collision with root package name */
    public final C0770e f1283a;
    public final X b;
    public final C0780o c;

    public T(C0770e c0770e, X x, C0780o c0780o) {
        this.f1283a = c0770e;
        this.b = x;
        this.c = c0780o;
    }

    public final C0770e a() {
        return this.f1283a;
    }

    public final C0780o b() {
        return this.c;
    }

    public final X c() {
        return this.b;
    }

    public final String toString() {
        return "ScreenshotConfig(apiCaptorConfig=" + this.f1283a + ", serviceCaptorConfig=" + this.b + ", contentObserverCaptorConfig=" + this.c + ')';
    }

    public T() {
        this(new C0770e(), new X(), new C0780o());
    }
}
