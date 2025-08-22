package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import java.util.concurrent.TimeUnit;
/* renamed from: io.appmetrica.analytics.impl.g  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC0263g {

    /* renamed from: a  reason: collision with root package name */
    public final C0572s5 f861a;
    public final Wk b;
    public final C0130al c;
    public final Vk d;
    public final InterfaceC0479ob e;
    public final SystemTimeProvider f;

    public AbstractC0263g(C0572s5 c0572s5, Wk wk, C0130al c0130al, Vk vk, InterfaceC0479ob interfaceC0479ob, SystemTimeProvider systemTimeProvider) {
        this.f861a = c0572s5;
        this.b = wk;
        this.c = c0130al;
        this.d = vk;
        this.e = interfaceC0479ob;
        this.f = systemTimeProvider;
    }

    public final /* bridge */ Jk a(Object obj) {
        return a((Kk) obj);
    }

    public final Jk b() {
        if (this.c.h()) {
            return new Jk(this.f861a, this.c, a(), this.f);
        }
        return null;
    }

    public final Jk a(Kk kk) {
        if (this.c.h()) {
            this.e.reportEvent("create session with non-empty storage");
        }
        C0572s5 c0572s5 = this.f861a;
        C0130al c0130al = this.c;
        long a2 = this.b.a();
        C0130al c0130al2 = this.c;
        c0130al2.a(C0130al.f, Long.valueOf(a2));
        c0130al2.a(C0130al.d, Long.valueOf(kk.f532a));
        c0130al2.a(C0130al.h, Long.valueOf(kk.f532a));
        c0130al2.a(C0130al.g, 0L);
        c0130al2.a(C0130al.i, Boolean.TRUE);
        c0130al2.b();
        this.f861a.e.a(a2, this.d.f699a, TimeUnit.MILLISECONDS.toSeconds(kk.b));
        return new Jk(c0572s5, c0130al, a(), new SystemTimeProvider());
    }

    public final Mk a() {
        Lk lk = new Lk(this.d);
        lk.g = this.c.i();
        lk.f = this.c.c.a(C0130al.g);
        lk.d = this.c.c.a(C0130al.h);
        lk.c = this.c.c.a(C0130al.f);
        lk.h = this.c.c.a(C0130al.d);
        lk.f547a = this.c.c.a(C0130al.e);
        return new Mk(lk);
    }
}
