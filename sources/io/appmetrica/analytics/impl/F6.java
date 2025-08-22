package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ICrashTransformer;
/* loaded from: classes4.dex */
public abstract class F6 implements InterfaceC0172cb {

    /* renamed from: a  reason: collision with root package name */
    public final E6 f428a;
    public final ICrashTransformer b;
    public final C0351ja c;

    public F6(E6 e6, ICrashTransformer iCrashTransformer, C0351ja c0351ja) {
        this.f428a = e6;
        this.b = iCrashTransformer;
        this.c = c0351ja;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0172cb
    public final void a(Throwable th, U u) {
        if (this.f428a.a(th)) {
            ICrashTransformer iCrashTransformer = this.b;
            if (iCrashTransformer == null || th == null || (th = iCrashTransformer.process(th)) != null) {
                Sn a2 = Vn.a(th, u, null, (String) this.c.b.a(), (Boolean) this.c.c.a());
                Cc cc = (Cc) ((Th) this).d;
                cc.f748a.a().a(cc.b).a(a2);
            }
        }
    }

    public final E6 b() {
        return this.f428a;
    }

    public final ICrashTransformer a() {
        return this.b;
    }
}
