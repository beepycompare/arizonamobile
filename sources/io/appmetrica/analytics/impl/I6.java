package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ICrashTransformer;
/* loaded from: classes4.dex */
public abstract class I6 implements InterfaceC0249fb {

    /* renamed from: a  reason: collision with root package name */
    public final H6 f491a;
    public final ICrashTransformer b;
    public final C0429ma c;

    public I6(H6 h6, ICrashTransformer iCrashTransformer, C0429ma c0429ma) {
        this.f491a = h6;
        this.b = iCrashTransformer;
        this.c = c0429ma;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0249fb
    public final void a(Throwable th, U u) {
        if (this.f491a.a(th)) {
            ICrashTransformer iCrashTransformer = this.b;
            if (iCrashTransformer == null || th == null || (th = iCrashTransformer.process(th)) != null) {
                Wn a2 = Zn.a(th, u, null, (String) this.c.b.a(), (Boolean) this.c.c.a());
                Fc fc = (Fc) ((Xh) this).d;
                fc.f831a.a().a(fc.b).a(a2);
            }
        }
    }

    public final H6 b() {
        return this.f491a;
    }

    public final ICrashTransformer a() {
        return this.b;
    }
}
