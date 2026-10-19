package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ICrashTransformer;
/* renamed from: io.appmetrica.analytics.impl.z6  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC0753z6 implements InterfaceC0292hb {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0727y6 f1313a;
    public final ICrashTransformer b;
    public final C0291ha c;

    public AbstractC0753z6(InterfaceC0727y6 interfaceC0727y6, ICrashTransformer iCrashTransformer, C0291ha c0291ha) {
        this.f1313a = interfaceC0727y6;
        this.b = iCrashTransformer;
        this.c = c0291ha;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0292hb
    public final void a(Throwable th, X x) {
        if (this.f1313a.a(th)) {
            ICrashTransformer iCrashTransformer = this.b;
            if (iCrashTransformer == null || th == null || (th = iCrashTransformer.process(th)) != null) {
                C0615to a2 = AbstractC0693wo.a(th, x, null, (String) this.c.b.a(), (Boolean) this.c.c.a());
                Hc hc = (Hc) ((Vh) this).d;
                hc.f1328a.a().a(hc.b).a(a2);
            }
        }
    }

    public final InterfaceC0727y6 b() {
        return this.f1313a;
    }

    public final ICrashTransformer a() {
        return this.b;
    }
}
