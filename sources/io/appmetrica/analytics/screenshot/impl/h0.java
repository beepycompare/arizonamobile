package io.appmetrica.analytics.screenshot.impl;
/* loaded from: classes4.dex */
public final class h0 {

    /* renamed from: a  reason: collision with root package name */
    public final e0 f1300a;
    public final i0 b;
    public final f0 c;

    public h0(e0 e0Var, i0 i0Var, f0 f0Var) {
        this.f1300a = e0Var;
        this.b = i0Var;
        this.c = f0Var;
    }

    public final e0 a() {
        return this.f1300a;
    }

    public final f0 b() {
        return this.c;
    }

    public final i0 c() {
        return this.b;
    }

    public final String toString() {
        return "ServiceSideScreenshotConfig(apiCaptorConfig=" + this.f1300a + ", serviceCaptorConfig=" + this.b + ", contentObserverCaptorConfig=" + this.c + ')';
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public h0(T t) {
        this(r2, r3, r5 != null ? new f0(r5) : null);
        C0770e a2 = t.a();
        e0 e0Var = a2 != null ? new e0(a2) : null;
        X c = t.c();
        i0 i0Var = c != null ? new i0(c) : null;
        C0780o b = t.b();
    }
}
