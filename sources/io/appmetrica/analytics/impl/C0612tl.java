package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import java.util.concurrent.TimeUnit;
/* renamed from: io.appmetrica.analytics.impl.tl  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0612tl implements InterfaceC0576sb {

    /* renamed from: a  reason: collision with root package name */
    public final C0441n5 f1224a;
    public final C0638ul b;
    public final C0768zl c;
    public final C0586sl d = C0586sl.a(Al.BACKGROUND).b().a();

    public C0612tl(C0441n5 c0441n5, C0638ul c0638ul) {
        this.f1224a = c0441n5;
        this.b = c0638ul;
        this.c = new C0768zl(c0441n5.h(), M2.g);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0576sb
    public final C0250fl a() {
        return null;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0576sb
    public final C0250fl a(C0276gl c0276gl) {
        String a2;
        boolean b;
        long a3 = this.b.a();
        C0768zl c0768zl = this.c;
        c0768zl.a(C0768zl.f, Long.valueOf(a3));
        c0768zl.a(C0768zl.d, Long.valueOf(c0276gl.f1006a));
        c0768zl.a(C0768zl.h, Long.valueOf(c0276gl.f1006a));
        c0768zl.a(C0768zl.i, Long.valueOf(c0276gl.b));
        c0768zl.a(C0768zl.g, 0L);
        c0768zl.a(C0768zl.j, Boolean.FALSE);
        c0768zl.a();
        C0159c7 c0159c7 = this.f1224a.e;
        Al al = Al.BACKGROUND;
        long seconds = TimeUnit.MILLISECONDS.toSeconds(c0276gl.b);
        C0690wl c0690wl = c0276gl.c;
        c0159c7.getClass();
        K7 k7 = new K7(null, 1, null);
        Eh eh = (Eh) c0159c7.e.k.a();
        Long valueOf = Long.valueOf(a3);
        Long valueOf2 = Long.valueOf(seconds);
        if (c0690wl == null || (a2 = c0690wl.f1275a) == null) {
            a2 = L7.a(eh);
        }
        Long valueOf3 = Long.valueOf(AbstractC0408lo.a());
        C0767zk c0767zk = AbstractC0741yk.f1304a;
        synchronized (c0767zk) {
            b = c0767zk.b.b(true);
        }
        c0159c7.a(k7.fromModel(new J7(valueOf, al, a2, new I7(valueOf2, valueOf3, Boolean.valueOf(b)))));
        C0302hl c0302hl = new C0302hl(this.d);
        c0302hl.h = this.c.c.a(C0768zl.j);
        c0302hl.g = this.c.c.b(C0768zl.g);
        c0302hl.d = this.c.c.b(C0768zl.h);
        c0302hl.e = this.c.c.b(C0768zl.i);
        c0302hl.c = this.c.c.b(C0768zl.f);
        c0302hl.i = this.c.c.b(C0768zl.d);
        c0302hl.f1026a = this.c.c.b(C0768zl.e);
        return new C0250fl(this.f1224a, this.c, new C0327il(c0302hl), new SystemTimeProvider());
    }
}
