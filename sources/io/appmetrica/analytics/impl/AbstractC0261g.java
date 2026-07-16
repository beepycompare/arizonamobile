package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import java.util.concurrent.TimeUnit;
/* renamed from: io.appmetrica.analytics.impl.g  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC0261g implements InterfaceC0583sb {

    /* renamed from: a  reason: collision with root package name */
    public final C0448n5 f989a;
    public final C0645ul b;
    public final C0775zl c;
    public final C0593sl d;
    public final InterfaceC0506pb e;
    public final SystemTimeProvider f;

    public AbstractC0261g(C0448n5 c0448n5, C0645ul c0645ul, C0775zl c0775zl, C0593sl c0593sl, InterfaceC0506pb interfaceC0506pb, SystemTimeProvider systemTimeProvider) {
        this.f989a = c0448n5;
        this.b = c0645ul;
        this.c = c0775zl;
        this.d = c0593sl;
        this.e = interfaceC0506pb;
        this.f = systemTimeProvider;
    }

    public final C0334il b() {
        C0309hl c0309hl = new C0309hl(this.d);
        c0309hl.h = this.c.c.a(C0775zl.j);
        c0309hl.g = this.c.c.b(C0775zl.g);
        c0309hl.d = this.c.c.b(C0775zl.h);
        c0309hl.e = this.c.c.b(C0775zl.i);
        c0309hl.c = this.c.c.b(C0775zl.f);
        c0309hl.i = this.c.c.b(C0775zl.d);
        c0309hl.f1023a = this.c.c.b(C0775zl.e);
        c0309hl.j = this.c.c.a(C0775zl.k);
        return new C0334il(c0309hl);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0583sb
    public final C0257fl a() {
        if (this.c.i()) {
            return new C0257fl(this.f989a, this.c, b(), this.f);
        }
        return null;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0583sb
    public final C0257fl a(C0283gl c0283gl) {
        boolean b;
        if (this.c.i()) {
            this.e.reportEvent("create session with non-empty storage");
        }
        C0448n5 c0448n5 = this.f989a;
        C0775zl c0775zl = this.c;
        long a2 = this.b.a();
        C0775zl c0775zl2 = this.c;
        c0775zl2.a(C0775zl.f, Long.valueOf(a2));
        c0775zl2.a(C0775zl.d, Long.valueOf(c0283gl.f1003a));
        c0775zl2.a(C0775zl.h, Long.valueOf(c0283gl.f1003a));
        c0775zl2.a(C0775zl.i, Long.valueOf(c0283gl.b));
        c0775zl2.a(C0775zl.g, 0L);
        c0775zl2.a(C0775zl.j, Boolean.TRUE);
        c0775zl2.a();
        C0166c7 c0166c7 = this.f989a.e;
        Al al = this.d.f1204a;
        long seconds = TimeUnit.MILLISECONDS.toSeconds(c0283gl.b);
        c0166c7.getClass();
        K7 k7 = new K7(null, 1, null);
        Long valueOf = Long.valueOf(a2);
        Long valueOf2 = Long.valueOf(seconds);
        String a3 = L7.a((Eh) c0166c7.e.k.a());
        Long valueOf3 = Long.valueOf(AbstractC0415lo.a());
        C0774zk c0774zk = AbstractC0748yk.f1301a;
        synchronized (c0774zk) {
            b = c0774zk.b.b(true);
        }
        c0166c7.a(k7.fromModel(new J7(valueOf, al, a3, new I7(valueOf2, valueOf3, Boolean.valueOf(b)))));
        return new C0257fl(c0448n5, c0775zl, b(), new SystemTimeProvider());
    }
}
