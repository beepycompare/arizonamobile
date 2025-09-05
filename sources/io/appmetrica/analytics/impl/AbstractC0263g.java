package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import java.util.concurrent.TimeUnit;
/* renamed from: io.appmetrica.analytics.impl.g  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC0263g {

    /* renamed from: a  reason: collision with root package name */
    public final C0651v5 f881a;
    public final C0130al b;
    public final C0233el c;
    public final Zk d;
    public final InterfaceC0557rb e;
    public final SystemTimeProvider f;

    public AbstractC0263g(C0651v5 c0651v5, C0130al c0130al, C0233el c0233el, Zk zk, InterfaceC0557rb interfaceC0557rb, SystemTimeProvider systemTimeProvider) {
        this.f881a = c0651v5;
        this.b = c0130al;
        this.c = c0233el;
        this.d = zk;
        this.e = interfaceC0557rb;
        this.f = systemTimeProvider;
    }

    public final /* bridge */ Nk a(Object obj) {
        return a((Ok) obj);
    }

    public final Nk b() {
        if (this.c.h()) {
            return new Nk(this.f881a, this.c, a(), this.f);
        }
        return null;
    }

    public final Nk a(Ok ok) {
        if (this.c.h()) {
            this.e.reportEvent("create session with non-empty storage");
        }
        C0651v5 c0651v5 = this.f881a;
        C0233el c0233el = this.c;
        long a2 = this.b.a();
        C0233el c0233el2 = this.c;
        c0233el2.a(C0233el.f, Long.valueOf(a2));
        c0233el2.a(C0233el.d, Long.valueOf(ok.f608a));
        c0233el2.a(C0233el.h, Long.valueOf(ok.f608a));
        c0233el2.a(C0233el.g, 0L);
        c0233el2.a(C0233el.i, Boolean.TRUE);
        c0233el2.b();
        this.f881a.e.a(a2, this.d.f774a, TimeUnit.MILLISECONDS.toSeconds(ok.b));
        return new Nk(c0651v5, c0233el, a(), new SystemTimeProvider());
    }

    public final Qk a() {
        Pk pk = new Pk(this.d);
        pk.g = this.c.i();
        pk.f = this.c.c.a(C0233el.g);
        pk.d = this.c.c.a(C0233el.h);
        pk.c = this.c.c.a(C0233el.f);
        pk.h = this.c.c.a(C0233el.d);
        pk.f624a = this.c.c.a(C0233el.e);
        return new Qk(pk);
    }
}
