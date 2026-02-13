package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ICrashTransformer;
/* renamed from: io.appmetrica.analytics.impl.j6  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC0344j6 implements Fa {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0319i6 f1057a;
    public final ICrashTransformer b;
    public final M9 c;

    public AbstractC0344j6(InterfaceC0319i6 interfaceC0319i6, ICrashTransformer iCrashTransformer, M9 m9) {
        this.f1057a = interfaceC0319i6;
        this.b = iCrashTransformer;
        this.c = m9;
    }

    @Override // io.appmetrica.analytics.impl.Fa
    public final void a(Throwable th, V v) {
        if (this.f1057a.a(th)) {
            ICrashTransformer iCrashTransformer = this.b;
            if (iCrashTransformer == null || th == null || (th = iCrashTransformer.process(th)) != null) {
                Qn a2 = Tn.a(th, v, null, (String) this.c.b.a(), (Boolean) this.c.c.a());
                C0247fc c0247fc = (C0247fc) ((Bh) this).d;
                c0247fc.f845a.a().a(c0247fc.b).a(a2);
            }
        }
    }

    public final InterfaceC0319i6 b() {
        return this.f1057a;
    }

    public final ICrashTransformer a() {
        return this.b;
    }
}
