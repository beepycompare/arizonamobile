package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ICrashTransformer;
/* renamed from: io.appmetrica.analytics.impl.q6  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC0517q6 implements Ma {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0492p6 f1067a;
    public final ICrashTransformer b;
    public final T9 c;

    public AbstractC0517q6(InterfaceC0492p6 interfaceC0492p6, ICrashTransformer iCrashTransformer, T9 t9) {
        this.f1067a = interfaceC0492p6;
        this.b = iCrashTransformer;
        this.c = t9;
    }

    @Override // io.appmetrica.analytics.impl.Ma
    public final void a(Throwable th, V v) {
        if (this.f1067a.a(th)) {
            ICrashTransformer iCrashTransformer = this.b;
            if (iCrashTransformer == null || th == null || (th = iCrashTransformer.process(th)) != null) {
                Sn a2 = Vn.a(th, v, null, (String) this.c.b.a(), (Boolean) this.c.c.a());
                C0423mc c0423mc = (C0423mc) ((Gh) this).d;
                c0423mc.f776a.a().a(c0423mc.b).a(a2);
            }
        }
    }

    public final InterfaceC0492p6 b() {
        return this.f1067a;
    }

    public final ICrashTransformer a() {
        return this.b;
    }
}
