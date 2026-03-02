package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ICrashTransformer;
/* renamed from: io.appmetrica.analytics.impl.j6  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC0343j6 implements Fa {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0318i6 f1057a;
    public final ICrashTransformer b;
    public final M9 c;

    public AbstractC0343j6(InterfaceC0318i6 interfaceC0318i6, ICrashTransformer iCrashTransformer, M9 m9) {
        this.f1057a = interfaceC0318i6;
        this.b = iCrashTransformer;
        this.c = m9;
    }

    @Override // io.appmetrica.analytics.impl.Fa
    public final void a(Throwable th, V v) {
        if (this.f1057a.a(th)) {
            ICrashTransformer iCrashTransformer = this.b;
            if (iCrashTransformer == null || th == null || (th = iCrashTransformer.process(th)) != null) {
                Qn a2 = Tn.a(th, v, null, (String) this.c.b.a(), (Boolean) this.c.c.a());
                C0246fc c0246fc = (C0246fc) ((Bh) this).d;
                c0246fc.f845a.a().a(c0246fc.b).a(a2);
            }
        }
    }

    public final InterfaceC0318i6 b() {
        return this.f1057a;
    }

    public final ICrashTransformer a() {
        return this.b;
    }
}
