package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ICrashTransformer;
/* renamed from: io.appmetrica.analytics.impl.z6  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC0758z6 implements InterfaceC0297hb {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0732y6 f1310a;
    public final ICrashTransformer b;
    public final C0296ha c;

    public AbstractC0758z6(InterfaceC0732y6 interfaceC0732y6, ICrashTransformer iCrashTransformer, C0296ha c0296ha) {
        this.f1310a = interfaceC0732y6;
        this.b = iCrashTransformer;
        this.c = c0296ha;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0297hb
    public final void a(Throwable th, X x) {
        if (this.f1310a.a(th)) {
            ICrashTransformer iCrashTransformer = this.b;
            if (iCrashTransformer == null || th == null || (th = iCrashTransformer.process(th)) != null) {
                C0620to a2 = AbstractC0698wo.a(th, x, null, (String) this.c.b.a(), (Boolean) this.c.c.a());
                Hc hc = (Hc) ((Vh) this).d;
                hc.f1325a.a().a(hc.b).a(a2);
            }
        }
    }

    public final InterfaceC0732y6 b() {
        return this.f1310a;
    }

    public final ICrashTransformer a() {
        return this.b;
    }
}
