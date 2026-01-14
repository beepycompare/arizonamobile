package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* loaded from: classes5.dex */
public abstract class Ad implements InterfaceC0233eo, InterfaceC0315i2 {

    /* renamed from: a  reason: collision with root package name */
    public final String f499a;
    public final int b;
    public final so c;
    public final J2 d;
    public PublicLogger e = PublicLogger.getAnonymousInstance();

    public Ad(int i, String str, so soVar, J2 j2) {
        this.b = i;
        this.f499a = str;
        this.c = soVar;
        this.d = j2;
    }

    public final C0259fo a() {
        C0259fo c0259fo = new C0259fo();
        c0259fo.b = this.b;
        c0259fo.f1002a = this.f499a.getBytes();
        c0259fo.d = new C0311ho();
        c0259fo.c = new C0285go();
        return c0259fo;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0233eo
    public abstract /* synthetic */ void a(Cdo cdo);

    public final J2 b() {
        return this.d;
    }

    public final String c() {
        return this.f499a;
    }

    public final so d() {
        return this.c;
    }

    public final int e() {
        return this.b;
    }

    public final boolean f() {
        qo a2 = this.c.a(this.f499a);
        if (a2.f1195a) {
            return true;
        }
        this.e.warning("Attribute " + this.f499a + " of type " + ((String) On.f732a.get(this.b)) + " is skipped because " + a2.b, new Object[0]);
        return false;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0233eo
    public final void a(PublicLogger publicLogger) {
        this.e = publicLogger;
    }
}
