package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* loaded from: classes4.dex */
public abstract class Pd implements InterfaceC0166bo, InterfaceC0472o2 {

    /* renamed from: a  reason: collision with root package name */
    public final String f595a;
    public final int b;
    public final po c;
    public final W2 d;
    public PublicLogger e = PublicLogger.getAnonymousInstance();

    public Pd(int i, String str, po poVar, W2 w2) {
        this.b = i;
        this.f595a = str;
        this.c = poVar;
        this.d = w2;
    }

    public final C0192co a() {
        C0192co c0192co = new C0192co();
        c0192co.b = this.b;
        c0192co.f806a = this.f595a.getBytes();
        c0192co.d = new C0243eo();
        c0192co.c = new Cdo();
        return c0192co;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0166bo
    public abstract /* synthetic */ void a(C0140ao c0140ao);

    public final W2 b() {
        return this.d;
    }

    public final String c() {
        return this.f595a;
    }

    public final po d() {
        return this.c;
    }

    public final int e() {
        return this.b;
    }

    public final boolean f() {
        no a2 = this.c.a(this.f595a);
        if (a2.f976a) {
            return true;
        }
        this.e.warning("Attribute " + this.f595a + " of type " + ((String) Ln.f538a.get(this.b)) + " is skipped because " + a2.b, new Object[0]);
        return false;
    }

    public final void a(PublicLogger publicLogger) {
        this.e = publicLogger;
    }
}
