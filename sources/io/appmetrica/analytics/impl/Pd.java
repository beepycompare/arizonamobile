package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* loaded from: classes4.dex */
public abstract class Pd implements InterfaceC0167bo, InterfaceC0473o2 {

    /* renamed from: a  reason: collision with root package name */
    public final String f594a;
    public final int b;
    public final po c;
    public final W2 d;
    public PublicLogger e = PublicLogger.getAnonymousInstance();

    public Pd(int i, String str, po poVar, W2 w2) {
        this.b = i;
        this.f594a = str;
        this.c = poVar;
        this.d = w2;
    }

    public final C0193co a() {
        C0193co c0193co = new C0193co();
        c0193co.b = this.b;
        c0193co.f805a = this.f594a.getBytes();
        c0193co.d = new C0244eo();
        c0193co.c = new Cdo();
        return c0193co;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0167bo
    public abstract /* synthetic */ void a(C0141ao c0141ao);

    public final W2 b() {
        return this.d;
    }

    public final String c() {
        return this.f594a;
    }

    public final po d() {
        return this.c;
    }

    public final int e() {
        return this.b;
    }

    public final boolean f() {
        no a2 = this.c.a(this.f594a);
        if (a2.f975a) {
            return true;
        }
        this.e.warning("Attribute " + this.f594a + " of type " + ((String) Ln.f537a.get(this.b)) + " is skipped because " + a2.b, new Object[0]);
        return false;
    }

    public final void a(PublicLogger publicLogger) {
        this.e = publicLogger;
    }
}
