package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* loaded from: classes5.dex */
public abstract class Bd implements InterfaceC0255fo, InterfaceC0336j2 {

    /* renamed from: a  reason: collision with root package name */
    public final String f410a;
    public final int b;
    public final to c;
    public final K2 d;
    public PublicLogger e = PublicLogger.getAnonymousInstance();

    public Bd(int i, String str, to toVar, K2 k2) {
        this.b = i;
        this.f410a = str;
        this.c = toVar;
        this.d = k2;
    }

    public final C0281go a() {
        C0281go c0281go = new C0281go();
        c0281go.b = this.b;
        c0281go.f913a = this.f410a.getBytes();
        c0281go.d = new C0332io();
        c0281go.c = new C0307ho();
        return c0281go;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0255fo
    public abstract /* synthetic */ void a(C0229eo c0229eo);

    public final K2 b() {
        return this.d;
    }

    public final String c() {
        return this.f410a;
    }

    public final to d() {
        return this.c;
    }

    public final int e() {
        return this.b;
    }

    public final boolean f() {
        ro a2 = this.c.a(this.f410a);
        if (a2.f1107a) {
            return true;
        }
        this.e.warning("Attribute " + this.f410a + " of type " + ((String) Pn.f642a.get(this.b)) + " is skipped because " + a2.b, new Object[0]);
        return false;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0255fo
    public final void a(PublicLogger publicLogger) {
        this.e = publicLogger;
    }
}
