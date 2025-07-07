package io.appmetrica.analytics.screenshot.impl;
/* loaded from: classes4.dex */
public final class G {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f1272a;
    public final T b;

    public G(boolean z, T t) {
        this.f1272a = z;
        this.b = t;
    }

    public final T a() {
        return this.b;
    }

    public final boolean b() {
        return this.f1272a;
    }

    public final String toString() {
        return "RemoteScreenshotConfig(enabled=" + this.f1272a + ", config=" + this.b + ')';
    }

    public G() {
        this(new O().f1280a, new T());
    }
}
