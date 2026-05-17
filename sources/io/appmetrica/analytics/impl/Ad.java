package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* loaded from: classes5.dex */
public abstract class Ad implements InterfaceC0232eo, InterfaceC0314i2 {

    /* renamed from: a  reason: collision with root package name */
    public final String f503a;
    public final int b;
    public final so c;
    public final J2 d;
    public PublicLogger e = PublicLogger.getAnonymousInstance();

    public Ad(int i, String str, so soVar, J2 j2) {
        this.b = i;
        this.f503a = str;
        this.c = soVar;
        this.d = j2;
    }

    public final C0258fo a() {
        C0258fo c0258fo = new C0258fo();
        c0258fo.b = this.b;
        c0258fo.f1006a = this.f503a.getBytes();
        c0258fo.d = new C0310ho();
        c0258fo.c = new C0284go();
        return c0258fo;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0232eo
    public abstract /* synthetic */ void a(Cdo cdo);

    public final J2 b() {
        return this.d;
    }

    public final String c() {
        return this.f503a;
    }

    public final so d() {
        return this.c;
    }

    public final int e() {
        return this.b;
    }

    public final boolean f() {
        qo a2 = this.c.a(this.f503a);
        if (a2.f1199a) {
            return true;
        }
        this.e.warning("Attribute " + this.f503a + " of type " + ((String) On.f736a.get(this.b)) + " is skipped because " + a2.b, new Object[0]);
        return false;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0232eo
    public final void a(PublicLogger publicLogger) {
        this.e = publicLogger;
    }
}
