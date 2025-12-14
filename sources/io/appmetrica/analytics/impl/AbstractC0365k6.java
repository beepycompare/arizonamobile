package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ICrashTransformer;
/* renamed from: io.appmetrica.analytics.impl.k6  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC0365k6 implements Ga {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0339j6 f1067a;
    public final ICrashTransformer b;
    public final N9 c;

    public AbstractC0365k6(InterfaceC0339j6 interfaceC0339j6, ICrashTransformer iCrashTransformer, N9 n9) {
        this.f1067a = interfaceC0339j6;
        this.b = iCrashTransformer;
        this.c = n9;
    }

    @Override // io.appmetrica.analytics.impl.Ga
    public final void a(Throwable th, V v) {
        if (this.f1067a.a(th)) {
            ICrashTransformer iCrashTransformer = this.b;
            if (iCrashTransformer == null || th == null || (th = iCrashTransformer.process(th)) != null) {
                Rn a2 = Un.a(th, v, null, (String) this.c.b.a(), (Boolean) this.c.c.a());
                C0268gc c0268gc = (C0268gc) ((Ch) this).d;
                c0268gc.f853a.a().a(c0268gc.b).a(a2);
            }
        }
    }

    public final InterfaceC0339j6 b() {
        return this.f1067a;
    }

    public final ICrashTransformer a() {
        return this.b;
    }
}
