package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ICrashTransformer;
/* renamed from: io.appmetrica.analytics.impl.z6  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC0760z6 implements InterfaceC0299hb {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0734y6 f1308a;
    public final ICrashTransformer b;
    public final C0298ha c;

    public AbstractC0760z6(InterfaceC0734y6 interfaceC0734y6, ICrashTransformer iCrashTransformer, C0298ha c0298ha) {
        this.f1308a = interfaceC0734y6;
        this.b = iCrashTransformer;
        this.c = c0298ha;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0299hb
    public final void a(Throwable th, X x) {
        if (this.f1308a.a(th)) {
            ICrashTransformer iCrashTransformer = this.b;
            if (iCrashTransformer == null || th == null || (th = iCrashTransformer.process(th)) != null) {
                C0622to a2 = AbstractC0700wo.a(th, x, null, (String) this.c.b.a(), (Boolean) this.c.c.a());
                Hc hc = (Hc) ((Vh) this).d;
                hc.f1323a.a().a(hc.b).a(a2);
            }
        }
    }

    public final InterfaceC0734y6 b() {
        return this.f1308a;
    }

    public final ICrashTransformer a() {
        return this.b;
    }
}
