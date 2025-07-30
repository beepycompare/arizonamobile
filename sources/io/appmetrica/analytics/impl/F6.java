package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ICrashTransformer;
/* loaded from: classes4.dex */
public abstract class F6 implements InterfaceC0127ab {

    /* renamed from: a  reason: collision with root package name */
    public final E6 f432a;
    public final ICrashTransformer b;
    public final C0306ha c;

    public F6(E6 e6, ICrashTransformer iCrashTransformer, C0306ha c0306ha) {
        this.f432a = e6;
        this.b = iCrashTransformer;
        this.c = c0306ha;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0127ab
    public final void a(Throwable th, U u) {
        if (this.f432a.a(th)) {
            ICrashTransformer iCrashTransformer = this.b;
            if (iCrashTransformer == null || th == null || (th = iCrashTransformer.process(th)) != null) {
                Nn a2 = Qn.a(th, u, null, (String) this.c.b.a(), (Boolean) this.c.c.a());
                Ac ac = (Ac) ((Oh) this).d;
                ac.f660a.a().a(ac.b).a(a2);
            }
        }
    }

    public final E6 b() {
        return this.f432a;
    }

    public final ICrashTransformer a() {
        return this.b;
    }
}
