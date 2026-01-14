package io.appmetrica.analytics.screenshot.impl;
/* loaded from: classes5.dex */
public final class j0 {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f1475a;
    public final k0 b;

    public j0(boolean z, k0 k0Var) {
        this.f1475a = z;
        this.b = k0Var;
    }

    public final k0 a() {
        return this.b;
    }

    public final boolean b() {
        return this.f1475a;
    }

    public final String toString() {
        return "ServiceSideRemoteScreenshotConfig(enabled=" + this.f1475a + ", config=" + this.b + ')';
    }

    public j0() {
        this(new J());
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public j0(J j) {
        this(r0, r3 != null ? new k0(r3) : null);
        boolean b = j.b();
        W a2 = j.a();
    }
}
