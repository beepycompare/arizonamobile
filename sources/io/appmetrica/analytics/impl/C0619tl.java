package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import java.util.concurrent.TimeUnit;
/* renamed from: io.appmetrica.analytics.impl.tl  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0619tl implements InterfaceC0583sb {

    /* renamed from: a  reason: collision with root package name */
    public final C0448n5 f1219a;
    public final C0645ul b;
    public final C0775zl c;
    public final C0593sl d = C0593sl.a(Al.BACKGROUND).b().a();

    public C0619tl(C0448n5 c0448n5, C0645ul c0645ul) {
        this.f1219a = c0448n5;
        this.b = c0645ul;
        this.c = new C0775zl(c0448n5.h(), M2.g);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0583sb
    public final C0257fl a() {
        return null;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0583sb
    public final C0257fl a(C0283gl c0283gl) {
        String a2;
        boolean b;
        long a3 = this.b.a();
        C0775zl c0775zl = this.c;
        c0775zl.a(C0775zl.f, Long.valueOf(a3));
        c0775zl.a(C0775zl.d, Long.valueOf(c0283gl.f1001a));
        c0775zl.a(C0775zl.h, Long.valueOf(c0283gl.f1001a));
        c0775zl.a(C0775zl.i, Long.valueOf(c0283gl.b));
        c0775zl.a(C0775zl.g, 0L);
        c0775zl.a(C0775zl.j, Boolean.FALSE);
        c0775zl.a();
        C0166c7 c0166c7 = this.f1219a.e;
        Al al = Al.BACKGROUND;
        long seconds = TimeUnit.MILLISECONDS.toSeconds(c0283gl.b);
        C0697wl c0697wl = c0283gl.c;
        c0166c7.getClass();
        K7 k7 = new K7(null, 1, null);
        Eh eh = (Eh) c0166c7.e.k.a();
        Long valueOf = Long.valueOf(a3);
        Long valueOf2 = Long.valueOf(seconds);
        if (c0697wl == null || (a2 = c0697wl.f1270a) == null) {
            a2 = L7.a(eh);
        }
        Long valueOf3 = Long.valueOf(AbstractC0415lo.a());
        C0774zk c0774zk = AbstractC0748yk.f1299a;
        synchronized (c0774zk) {
            b = c0774zk.b.b(true);
        }
        c0166c7.a(k7.fromModel(new J7(valueOf, al, a2, new I7(valueOf2, valueOf3, Boolean.valueOf(b)))));
        C0309hl c0309hl = new C0309hl(this.d);
        c0309hl.h = this.c.c.a(C0775zl.j);
        c0309hl.g = this.c.c.b(C0775zl.g);
        c0309hl.d = this.c.c.b(C0775zl.h);
        c0309hl.e = this.c.c.b(C0775zl.i);
        c0309hl.c = this.c.c.b(C0775zl.f);
        c0309hl.i = this.c.c.b(C0775zl.d);
        c0309hl.f1021a = this.c.c.b(C0775zl.e);
        return new C0257fl(this.f1219a, this.c, new C0334il(c0309hl), new SystemTimeProvider());
    }
}
