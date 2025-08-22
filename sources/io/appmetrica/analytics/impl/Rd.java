package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* loaded from: classes4.dex */
public abstract class Rd implements InterfaceC0288go, InterfaceC0470o2 {

    /* renamed from: a  reason: collision with root package name */
    public final String f634a;
    public final int b;
    public final uo c;
    public final W2 d;
    public PublicLogger e = PublicLogger.getAnonymousInstance();

    public Rd(int i, String str, uo uoVar, W2 w2) {
        this.b = i;
        this.f634a = str;
        this.c = uoVar;
        this.d = w2;
    }

    public final C0314ho a() {
        C0314ho c0314ho = new C0314ho();
        c0314ho.b = this.b;
        c0314ho.f896a = this.f634a.getBytes();
        c0314ho.d = new C0365jo();
        c0314ho.c = new C0339io();
        return c0314ho;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0288go
    public abstract /* synthetic */ void a(C0262fo c0262fo);

    public final W2 b() {
        return this.d;
    }

    public final String c() {
        return this.f634a;
    }

    public final uo d() {
        return this.c;
    }

    public final int e() {
        return this.b;
    }

    public final boolean f() {
        so a2 = this.c.a(this.f634a);
        if (a2.f1067a) {
            return true;
        }
        this.e.warning("Attribute " + this.f634a + " of type " + ((String) Qn.f625a.get(this.b)) + " is skipped because " + a2.b, new Object[0]);
        return false;
    }

    public final void a(PublicLogger publicLogger) {
        this.e = publicLogger;
    }
}
