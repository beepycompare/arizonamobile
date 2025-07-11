package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import java.util.concurrent.TimeUnit;
/* renamed from: io.appmetrica.analytics.impl.g  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public abstract class AbstractC0268g {

    /* renamed from: a  reason: collision with root package name */
    public final C0572s5 f846a;
    public final Ok b;
    public final Sk c;
    public final Nk d;
    public final InterfaceC0379kb e;
    public final SystemTimeProvider f;

    public AbstractC0268g(C0572s5 c0572s5, Ok ok, Sk sk, Nk nk, InterfaceC0379kb interfaceC0379kb, SystemTimeProvider systemTimeProvider) {
        this.f846a = c0572s5;
        this.b = ok;
        this.c = sk;
        this.d = nk;
        this.e = interfaceC0379kb;
        this.f = systemTimeProvider;
    }

    public final /* bridge */ Bk a(Object obj) {
        return a((Ck) obj);
    }

    public final Bk b() {
        if (this.c.h()) {
            return new Bk(this.f846a, this.c, a(), this.f);
        }
        return null;
    }

    public final Bk a(Ck ck) {
        if (this.c.h()) {
            this.e.reportEvent("create session with non-empty storage");
        }
        C0572s5 c0572s5 = this.f846a;
        Sk sk = this.c;
        long a2 = this.b.a();
        Sk sk2 = this.c;
        sk2.a(Sk.f, Long.valueOf(a2));
        sk2.a(Sk.d, Long.valueOf(ck.f377a));
        sk2.a(Sk.h, Long.valueOf(ck.f377a));
        sk2.a(Sk.g, 0L);
        sk2.a(Sk.i, Boolean.TRUE);
        sk2.b();
        this.f846a.e.a(a2, this.d.f559a, TimeUnit.MILLISECONDS.toSeconds(ck.b));
        return new Bk(c0572s5, sk, a(), new SystemTimeProvider());
    }

    public final Ek a() {
        Dk dk = new Dk(this.d);
        dk.g = this.c.i();
        dk.f = this.c.c.a(Sk.g);
        dk.d = this.c.c.a(Sk.h);
        dk.c = this.c.c.a(Sk.f);
        dk.h = this.c.c.a(Sk.d);
        dk.f393a = this.c.c.a(Sk.e);
        return new Ek(dk);
    }
}
