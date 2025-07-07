package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* loaded from: classes4.dex */
public abstract class Nd implements Yn, InterfaceC0478o2 {

    /* renamed from: a  reason: collision with root package name */
    public final String f552a;
    public final int b;
    public final mo c;
    public final W2 d;
    public PublicLogger e = PublicLogger.getAnonymousInstance();

    public Nd(int i, String str, mo moVar, W2 w2) {
        this.b = i;
        this.f552a = str;
        this.c = moVar;
        this.d = w2;
    }

    public final Zn a() {
        Zn zn = new Zn();
        zn.b = this.b;
        zn.f744a = this.f552a.getBytes();
        zn.d = new C0174bo();
        zn.c = new C0148ao();
        return zn;
    }

    @Override // io.appmetrica.analytics.impl.Yn
    public abstract /* synthetic */ void a(Xn xn);

    public final W2 b() {
        return this.d;
    }

    public final String c() {
        return this.f552a;
    }

    public final mo d() {
        return this.c;
    }

    public final int e() {
        return this.b;
    }

    public final boolean f() {
        ko a2 = this.c.a(this.f552a);
        if (a2.f912a) {
            return true;
        }
        this.e.warning("Attribute " + this.f552a + " of type " + ((String) In.f481a.get(this.b)) + " is skipped because " + a2.b, new Object[0]);
        return false;
    }

    public final void a(PublicLogger publicLogger) {
        this.e = publicLogger;
    }
}
