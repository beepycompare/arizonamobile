package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
/* renamed from: io.appmetrica.analytics.impl.ae  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC0121ae implements Ho, InterfaceC0652v2 {

    /* renamed from: a  reason: collision with root package name */
    public final String f886a;
    public final int b;
    public final Vo c;
    public final W2 d;
    public PublicLogger e = PublicLogger.getAnonymousInstance();

    public AbstractC0121ae(int i, String str, Vo vo, W2 w2) {
        this.b = i;
        this.f886a = str;
        this.c = vo;
        this.d = w2;
    }

    public final Io a() {
        Io io2 = new Io();
        io2.b = this.b;
        io2.f600a = this.f886a.getBytes();
        io2.d = new Ko();
        io2.c = new Jo();
        return io2;
    }

    @Override // io.appmetrica.analytics.impl.Ho
    public abstract /* synthetic */ void a(Go go);

    public final W2 b() {
        return this.d;
    }

    public final String c() {
        return this.f886a;
    }

    public final Vo d() {
        return this.c;
    }

    public final int e() {
        return this.b;
    }

    public final boolean f() {
        To a2 = this.c.a(this.f886a);
        if (a2.f782a) {
            return true;
        }
        this.e.warning("Attribute " + this.f886a + " of type " + ((String) AbstractC0570ro.f1187a.get(this.b)) + " is skipped because " + a2.b, new Object[0]);
        return false;
    }

    @Override // io.appmetrica.analytics.impl.Ho
    public final void a(PublicLogger publicLogger) {
        this.e = publicLogger;
    }
}
