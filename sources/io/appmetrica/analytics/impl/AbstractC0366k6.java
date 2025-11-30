package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.ICrashTransformer;
/* renamed from: io.appmetrica.analytics.impl.k6  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC0366k6 implements Ga {

    /* renamed from: a  reason: collision with root package name */
    public final InterfaceC0340j6 f970a;
    public final ICrashTransformer b;
    public final N9 c;

    public AbstractC0366k6(InterfaceC0340j6 interfaceC0340j6, ICrashTransformer iCrashTransformer, N9 n9) {
        this.f970a = interfaceC0340j6;
        this.b = iCrashTransformer;
        this.c = n9;
    }

    @Override // io.appmetrica.analytics.impl.Ga
    public final void a(Throwable th, V v) {
        if (this.f970a.a(th)) {
            ICrashTransformer iCrashTransformer = this.b;
            if (iCrashTransformer == null || th == null || (th = iCrashTransformer.process(th)) != null) {
                Rn a2 = Un.a(th, v, null, (String) this.c.b.a(), (Boolean) this.c.c.a());
                C0269gc c0269gc = (C0269gc) ((Ch) this).d;
                c0269gc.f756a.a().a(c0269gc.b).a(a2);
            }
        }
    }

    public final InterfaceC0340j6 b() {
        return this.f970a;
    }

    public final ICrashTransformer a() {
        return this.b;
    }
}
