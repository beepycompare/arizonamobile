package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import java.util.concurrent.TimeUnit;
/* renamed from: io.appmetrica.analytics.impl.g  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC0264g {

    /* renamed from: a  reason: collision with root package name */
    public final C0652v5 f886a;
    public final C0131al b;
    public final C0234el c;
    public final Zk d;
    public final InterfaceC0558rb e;
    public final SystemTimeProvider f;

    public AbstractC0264g(C0652v5 c0652v5, C0131al c0131al, C0234el c0234el, Zk zk, InterfaceC0558rb interfaceC0558rb, SystemTimeProvider systemTimeProvider) {
        this.f886a = c0652v5;
        this.b = c0131al;
        this.c = c0234el;
        this.d = zk;
        this.e = interfaceC0558rb;
        this.f = systemTimeProvider;
    }

    public final /* bridge */ Nk a(Object obj) {
        return a((Ok) obj);
    }

    public final Nk b() {
        if (this.c.h()) {
            return new Nk(this.f886a, this.c, a(), this.f);
        }
        return null;
    }

    public final Nk a(Ok ok) {
        if (this.c.h()) {
            this.e.reportEvent("create session with non-empty storage");
        }
        C0652v5 c0652v5 = this.f886a;
        C0234el c0234el = this.c;
        long a2 = this.b.a();
        C0234el c0234el2 = this.c;
        c0234el2.a(C0234el.f, Long.valueOf(a2));
        c0234el2.a(C0234el.d, Long.valueOf(ok.f613a));
        c0234el2.a(C0234el.h, Long.valueOf(ok.f613a));
        c0234el2.a(C0234el.g, 0L);
        c0234el2.a(C0234el.i, Boolean.TRUE);
        c0234el2.b();
        this.f886a.e.a(a2, this.d.f779a, TimeUnit.MILLISECONDS.toSeconds(ok.b));
        return new Nk(c0652v5, c0234el, a(), new SystemTimeProvider());
    }

    public final Qk a() {
        Pk pk = new Pk(this.d);
        pk.g = this.c.i();
        pk.f = this.c.c.a(C0234el.g);
        pk.d = this.c.c.a(C0234el.h);
        pk.c = this.c.c.a(C0234el.f);
        pk.h = this.c.c.a(C0234el.d);
        pk.f629a = this.c.c.a(C0234el.e);
        return new Qk(pk);
    }
}
