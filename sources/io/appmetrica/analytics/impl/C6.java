package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ICrashTransformer;
/* loaded from: classes4.dex */
public abstract class C6 implements Ya {

    /* renamed from: a  reason: collision with root package name */
    public final B6 f367a;
    public final ICrashTransformer b;
    public final C0262fa c;

    public C6(B6 b6, ICrashTransformer iCrashTransformer, C0262fa c0262fa) {
        this.f367a = b6;
        this.b = iCrashTransformer;
        this.c = c0262fa;
    }

    @Override // io.appmetrica.analytics.impl.Ya
    public final void a(Throwable th, U u) {
        if (this.f367a.a(th)) {
            ICrashTransformer iCrashTransformer = this.b;
            if (iCrashTransformer == null || th == null || (th = iCrashTransformer.process(th)) != null) {
                Kn a2 = Nn.a(th, u, null, (String) this.c.b.a(), (Boolean) this.c.c.a());
                C0737yc c0737yc = (C0737yc) ((Mh) this).d;
                c0737yc.f599a.a().a(c0737yc.b).a(a2);
            }
        }
    }

    public final B6 b() {
        return this.f367a;
    }

    public final ICrashTransformer a() {
        return this.b;
    }
}
