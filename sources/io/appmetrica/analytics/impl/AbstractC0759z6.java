package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ICrashTransformer;
/* renamed from: io.appmetrica.analytics.impl.z6  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC0759z6 implements InterfaceC0298hb {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0733y6 f1310a;
    public final ICrashTransformer b;
    public final C0297ha c;

    public AbstractC0759z6(InterfaceC0733y6 interfaceC0733y6, ICrashTransformer iCrashTransformer, C0297ha c0297ha) {
        this.f1310a = interfaceC0733y6;
        this.b = iCrashTransformer;
        this.c = c0297ha;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0298hb
    public final void a(Throwable th, X x) {
        if (this.f1310a.a(th)) {
            ICrashTransformer iCrashTransformer = this.b;
            if (iCrashTransformer == null || th == null || (th = iCrashTransformer.process(th)) != null) {
                C0621to a2 = AbstractC0699wo.a(th, x, null, (String) this.c.b.a(), (Boolean) this.c.c.a());
                Hc hc = (Hc) ((Vh) this).d;
                hc.f1325a.a().a(hc.b).a(a2);
            }
        }
    }

    public final InterfaceC0733y6 b() {
        return this.f1310a;
    }

    public final ICrashTransformer a() {
        return this.b;
    }
}
