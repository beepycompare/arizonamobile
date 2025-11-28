package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* loaded from: classes5.dex */
public abstract class Hd implements InterfaceC0281go, InterfaceC0537r2 {

    /* renamed from: a  reason: collision with root package name */
    public final String f506a;
    public final int b;
    public final uo c;
    public final R2 d;
    public PublicLogger e = PublicLogger.getAnonymousInstance();

    public Hd(int i, String str, uo uoVar, R2 r2) {
        this.b = i;
        this.f506a = str;
        this.c = uoVar;
        this.d = r2;
    }

    public final C0307ho a() {
        C0307ho c0307ho = new C0307ho();
        c0307ho.b = this.b;
        c0307ho.f919a = this.f506a.getBytes();
        c0307ho.d = new C0358jo();
        c0307ho.c = new C0332io();
        return c0307ho;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0281go
    public abstract /* synthetic */ void a(C0255fo c0255fo);

    public final R2 b() {
        return this.d;
    }

    public final String c() {
        return this.f506a;
    }

    public final uo d() {
        return this.c;
    }

    public final int e() {
        return this.b;
    }

    public final boolean f() {
        so a2 = this.c.a(this.f506a);
        if (a2.f1120a) {
            return true;
        }
        this.e.warning("Attribute " + this.f506a + " of type " + ((String) Qn.f656a.get(this.b)) + " is skipped because " + a2.b, new Object[0]);
        return false;
    }

    public final void a(PublicLogger publicLogger) {
        this.e = publicLogger;
    }
}
