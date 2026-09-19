package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import java.util.concurrent.TimeUnit;
/* renamed from: io.appmetrica.analytics.impl.g  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC0259g implements InterfaceC0581sb {

    /* renamed from: a  reason: collision with root package name */
    public final C0446n5 f989a;
    public final C0643ul b;
    public final C0773zl c;
    public final C0591sl d;
    public final InterfaceC0504pb e;
    public final SystemTimeProvider f;

    public AbstractC0259g(C0446n5 c0446n5, C0643ul c0643ul, C0773zl c0773zl, C0591sl c0591sl, InterfaceC0504pb interfaceC0504pb, SystemTimeProvider systemTimeProvider) {
        this.f989a = c0446n5;
        this.b = c0643ul;
        this.c = c0773zl;
        this.d = c0591sl;
        this.e = interfaceC0504pb;
        this.f = systemTimeProvider;
    }

    public final C0332il b() {
        C0307hl c0307hl = new C0307hl(this.d);
        c0307hl.h = this.c.c.a(C0773zl.j);
        c0307hl.g = this.c.c.b(C0773zl.g);
        c0307hl.d = this.c.c.b(C0773zl.h);
        c0307hl.e = this.c.c.b(C0773zl.i);
        c0307hl.c = this.c.c.b(C0773zl.f);
        c0307hl.i = this.c.c.b(C0773zl.d);
        c0307hl.f1023a = this.c.c.b(C0773zl.e);
        c0307hl.j = this.c.c.a(C0773zl.k);
        return new C0332il(c0307hl);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0581sb
    public final C0255fl a() {
        if (this.c.i()) {
            return new C0255fl(this.f989a, this.c, b(), this.f);
        }
        return null;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0581sb
    public final C0255fl a(C0281gl c0281gl) {
        boolean b;
        if (this.c.i()) {
            this.e.reportEvent("create session with non-empty storage");
        }
        C0446n5 c0446n5 = this.f989a;
        C0773zl c0773zl = this.c;
        long a2 = this.b.a();
        C0773zl c0773zl2 = this.c;
        c0773zl2.a(C0773zl.f, Long.valueOf(a2));
        c0773zl2.a(C0773zl.d, Long.valueOf(c0281gl.f1003a));
        c0773zl2.a(C0773zl.h, Long.valueOf(c0281gl.f1003a));
        c0773zl2.a(C0773zl.i, Long.valueOf(c0281gl.b));
        c0773zl2.a(C0773zl.g, 0L);
        c0773zl2.a(C0773zl.j, Boolean.TRUE);
        c0773zl2.a();
        C0164c7 c0164c7 = this.f989a.e;
        Al al = this.d.f1204a;
        long seconds = TimeUnit.MILLISECONDS.toSeconds(c0281gl.b);
        c0164c7.getClass();
        K7 k7 = new K7(null, 1, null);
        Long valueOf = Long.valueOf(a2);
        Long valueOf2 = Long.valueOf(seconds);
        String a3 = L7.a((Eh) c0164c7.e.k.a());
        Long valueOf3 = Long.valueOf(AbstractC0413lo.a());
        C0772zk c0772zk = AbstractC0746yk.f1301a;
        synchronized (c0772zk) {
            b = c0772zk.b.b(true);
        }
        c0164c7.a(k7.fromModel(new J7(valueOf, al, a3, new I7(valueOf2, valueOf3, Boolean.valueOf(b)))));
        return new C0255fl(c0446n5, c0773zl, b(), new SystemTimeProvider());
    }
}
