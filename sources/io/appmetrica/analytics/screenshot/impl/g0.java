package io.appmetrica.analytics.screenshot.impl;
/* loaded from: classes4.dex */
public final class g0 {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f1299a;
    public final h0 b;

    public g0(boolean z, h0 h0Var) {
        this.f1299a = z;
        this.b = h0Var;
    }

    public final h0 a() {
        return this.b;
    }

    public final boolean b() {
        return this.f1299a;
    }

    public final String toString() {
        return "ServiceSideRemoteScreenshotConfig(enabled=" + this.f1299a + ", config=" + this.b + ')';
    }

    public g0() {
        this(new G());
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public g0(G g) {
        this(r0, r3 != null ? new h0(r3) : null);
        boolean b = g.b();
        T a2 = g.a();
    }
}
