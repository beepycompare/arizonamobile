package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* loaded from: classes4.dex */
public abstract class Vd implements InterfaceC0391ko, InterfaceC0524q2 {

    /* renamed from: a  reason: collision with root package name */
    public final String f712a;
    public final int b;
    public final yo c;
    public final Z2 d;
    public PublicLogger e = PublicLogger.getAnonymousInstance();

    public Vd(int i, String str, yo yoVar, Z2 z2) {
        this.b = i;
        this.f712a = str;
        this.c = yoVar;
        this.d = z2;
    }

    public final C0417lo a() {
        C0417lo c0417lo = new C0417lo();
        c0417lo.b = this.b;
        c0417lo.f981a = this.f712a.getBytes();
        c0417lo.d = new C0469no();
        c0417lo.c = new C0443mo();
        return c0417lo;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0391ko
    public abstract /* synthetic */ void a(C0365jo c0365jo);

    public final Z2 b() {
        return this.d;
    }

    public final String c() {
        return this.f712a;
    }

    public final yo d() {
        return this.c;
    }

    public final int e() {
        return this.b;
    }

    public final boolean f() {
        wo a2 = this.c.a(this.f712a);
        if (a2.f1146a) {
            return true;
        }
        this.e.warning("Attribute " + this.f712a + " of type " + ((String) Un.f705a.get(this.b)) + " is skipped because " + a2.b, new Object[0]);
        return false;
    }

    public final void a(PublicLogger publicLogger) {
        this.e = publicLogger;
    }
}
