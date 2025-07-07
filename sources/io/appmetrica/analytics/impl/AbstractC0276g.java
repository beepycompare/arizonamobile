package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import java.util.concurrent.TimeUnit;
/* renamed from: io.appmetrica.analytics.impl.g  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC0276g {

    /* renamed from: a  reason: collision with root package name */
    public final C0580s5 f845a;
    public final Ok b;
    public final Sk c;
    public final Nk d;
    public final InterfaceC0387kb e;
    public final SystemTimeProvider f;

    public AbstractC0276g(C0580s5 c0580s5, Ok ok, Sk sk, Nk nk, InterfaceC0387kb interfaceC0387kb, SystemTimeProvider systemTimeProvider) {
        this.f845a = c0580s5;
        this.b = ok;
        this.c = sk;
        this.d = nk;
        this.e = interfaceC0387kb;
        this.f = systemTimeProvider;
    }

    public final /* bridge */ Bk a(Object obj) {
        return a((Ck) obj);
    }

    public final Bk b() {
        if (this.c.h()) {
            return new Bk(this.f845a, this.c, a(), this.f);
        }
        return null;
    }

    public final Bk a(Ck ck) {
        if (this.c.h()) {
            this.e.reportEvent("create session with non-empty storage");
        }
        C0580s5 c0580s5 = this.f845a;
        Sk sk = this.c;
        long a2 = this.b.a();
        Sk sk2 = this.c;
        sk2.a(Sk.f, Long.valueOf(a2));
        sk2.a(Sk.d, Long.valueOf(ck.f376a));
        sk2.a(Sk.h, Long.valueOf(ck.f376a));
        sk2.a(Sk.g, 0L);
        sk2.a(Sk.i, Boolean.TRUE);
        sk2.b();
        this.f845a.e.a(a2, this.d.f558a, TimeUnit.MILLISECONDS.toSeconds(ck.b));
        return new Bk(c0580s5, sk, a(), new SystemTimeProvider());
    }

    public final Ek a() {
        Dk dk = new Dk(this.d);
        dk.g = this.c.i();
        dk.f = this.c.c.a(Sk.g);
        dk.d = this.c.c.a(Sk.h);
        dk.c = this.c.c.a(Sk.f);
        dk.h = this.c.c.a(Sk.d);
        dk.f392a = this.c.c.a(Sk.e);
        return new Ek(dk);
    }
}
