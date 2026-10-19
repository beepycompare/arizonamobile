package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import java.util.concurrent.TimeUnit;
/* renamed from: io.appmetrica.analytics.impl.g  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC0254g implements InterfaceC0576sb {

    /* renamed from: a  reason: collision with root package name */
    public final C0441n5 f992a;
    public final C0638ul b;
    public final C0768zl c;
    public final C0586sl d;
    public final InterfaceC0499pb e;
    public final SystemTimeProvider f;

    public AbstractC0254g(C0441n5 c0441n5, C0638ul c0638ul, C0768zl c0768zl, C0586sl c0586sl, InterfaceC0499pb interfaceC0499pb, SystemTimeProvider systemTimeProvider) {
        this.f992a = c0441n5;
        this.b = c0638ul;
        this.c = c0768zl;
        this.d = c0586sl;
        this.e = interfaceC0499pb;
        this.f = systemTimeProvider;
    }

    public final C0327il b() {
        C0302hl c0302hl = new C0302hl(this.d);
        c0302hl.h = this.c.c.a(C0768zl.j);
        c0302hl.g = this.c.c.b(C0768zl.g);
        c0302hl.d = this.c.c.b(C0768zl.h);
        c0302hl.e = this.c.c.b(C0768zl.i);
        c0302hl.c = this.c.c.b(C0768zl.f);
        c0302hl.i = this.c.c.b(C0768zl.d);
        c0302hl.f1026a = this.c.c.b(C0768zl.e);
        c0302hl.j = this.c.c.a(C0768zl.k);
        return new C0327il(c0302hl);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0576sb
    public final C0250fl a() {
        if (this.c.i()) {
            return new C0250fl(this.f992a, this.c, b(), this.f);
        }
        return null;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0576sb
    public final C0250fl a(C0276gl c0276gl) {
        boolean b;
        if (this.c.i()) {
            this.e.reportEvent("create session with non-empty storage");
        }
        C0441n5 c0441n5 = this.f992a;
        C0768zl c0768zl = this.c;
        long a2 = this.b.a();
        C0768zl c0768zl2 = this.c;
        c0768zl2.a(C0768zl.f, Long.valueOf(a2));
        c0768zl2.a(C0768zl.d, Long.valueOf(c0276gl.f1006a));
        c0768zl2.a(C0768zl.h, Long.valueOf(c0276gl.f1006a));
        c0768zl2.a(C0768zl.i, Long.valueOf(c0276gl.b));
        c0768zl2.a(C0768zl.g, 0L);
        c0768zl2.a(C0768zl.j, Boolean.TRUE);
        c0768zl2.a();
        C0159c7 c0159c7 = this.f992a.e;
        Al al = this.d.f1207a;
        long seconds = TimeUnit.MILLISECONDS.toSeconds(c0276gl.b);
        c0159c7.getClass();
        K7 k7 = new K7(null, 1, null);
        Long valueOf = Long.valueOf(a2);
        Long valueOf2 = Long.valueOf(seconds);
        String a3 = L7.a((Eh) c0159c7.e.k.a());
        Long valueOf3 = Long.valueOf(AbstractC0408lo.a());
        C0767zk c0767zk = AbstractC0741yk.f1304a;
        synchronized (c0767zk) {
            b = c0767zk.b.b(true);
        }
        c0159c7.a(k7.fromModel(new J7(valueOf, al, a3, new I7(valueOf2, valueOf3, Boolean.valueOf(b)))));
        return new C0250fl(c0441n5, c0768zl, b(), new SystemTimeProvider());
    }
}
