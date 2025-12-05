package io.appmetrica.analytics.screenshot.impl;
/* loaded from: classes5.dex */
public final class J {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f1424a;
    public final W b;

    public J(boolean z, W w) {
        this.f1424a = z;
        this.b = w;
    }

    public final W a() {
        return this.b;
    }

    public final boolean b() {
        return this.f1424a;
    }

    public final String toString() {
        return "RemoteScreenshotConfig(enabled=" + this.f1424a + ", config=" + this.b + ')';
    }

    public J() {
        this(new S().f1432a, new W());
    }
}
