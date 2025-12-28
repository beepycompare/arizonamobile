package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* loaded from: classes5.dex */
public abstract class Bd implements InterfaceC0254fo, InterfaceC0335j2 {

    /* renamed from: a  reason: collision with root package name */
    public final String f508a;
    public final int b;
    public final to c;
    public final K2 d;
    public PublicLogger e = PublicLogger.getAnonymousInstance();

    public Bd(int i, String str, to toVar, K2 k2) {
        this.b = i;
        this.f508a = str;
        this.c = toVar;
        this.d = k2;
    }

    public final C0280go a() {
        C0280go c0280go = new C0280go();
        c0280go.b = this.b;
        c0280go.f1011a = this.f508a.getBytes();
        c0280go.d = new C0331io();
        c0280go.c = new C0306ho();
        return c0280go;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0254fo
    public abstract /* synthetic */ void a(C0228eo c0228eo);

    public final K2 b() {
        return this.d;
    }

    public final String c() {
        return this.f508a;
    }

    public final to d() {
        return this.c;
    }

    public final int e() {
        return this.b;
    }

    public final boolean f() {
        ro a2 = this.c.a(this.f508a);
        if (a2.f1205a) {
            return true;
        }
        this.e.warning("Attribute " + this.f508a + " of type " + ((String) Pn.f740a.get(this.b)) + " is skipped because " + a2.b, new Object[0]);
        return false;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0254fo
    public final void a(PublicLogger publicLogger) {
        this.e = publicLogger;
    }
}
