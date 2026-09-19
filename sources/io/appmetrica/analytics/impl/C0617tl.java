package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import java.util.concurrent.TimeUnit;
/* renamed from: io.appmetrica.analytics.impl.tl  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0617tl implements InterfaceC0581sb {

    /* renamed from: a  reason: collision with root package name */
    public final C0446n5 f1221a;
    public final C0643ul b;
    public final C0773zl c;
    public final C0591sl d = C0591sl.a(Al.BACKGROUND).b().a();

    public C0617tl(C0446n5 c0446n5, C0643ul c0643ul) {
        this.f1221a = c0446n5;
        this.b = c0643ul;
        this.c = new C0773zl(c0446n5.h(), M2.g);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0581sb
    public final C0255fl a() {
        return null;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0581sb
    public final C0255fl a(C0281gl c0281gl) {
        String a2;
        boolean b;
        long a3 = this.b.a();
        C0773zl c0773zl = this.c;
        c0773zl.a(C0773zl.f, Long.valueOf(a3));
        c0773zl.a(C0773zl.d, Long.valueOf(c0281gl.f1003a));
        c0773zl.a(C0773zl.h, Long.valueOf(c0281gl.f1003a));
        c0773zl.a(C0773zl.i, Long.valueOf(c0281gl.b));
        c0773zl.a(C0773zl.g, 0L);
        c0773zl.a(C0773zl.j, Boolean.FALSE);
        c0773zl.a();
        C0164c7 c0164c7 = this.f1221a.e;
        Al al = Al.BACKGROUND;
        long seconds = TimeUnit.MILLISECONDS.toSeconds(c0281gl.b);
        C0695wl c0695wl = c0281gl.c;
        c0164c7.getClass();
        K7 k7 = new K7(null, 1, null);
        Eh eh = (Eh) c0164c7.e.k.a();
        Long valueOf = Long.valueOf(a3);
        Long valueOf2 = Long.valueOf(seconds);
        if (c0695wl == null || (a2 = c0695wl.f1272a) == null) {
            a2 = L7.a(eh);
        }
        Long valueOf3 = Long.valueOf(AbstractC0413lo.a());
        C0772zk c0772zk = AbstractC0746yk.f1301a;
        synchronized (c0772zk) {
            b = c0772zk.b.b(true);
        }
        c0164c7.a(k7.fromModel(new J7(valueOf, al, a2, new I7(valueOf2, valueOf3, Boolean.valueOf(b)))));
        C0307hl c0307hl = new C0307hl(this.d);
        c0307hl.h = this.c.c.a(C0773zl.j);
        c0307hl.g = this.c.c.b(C0773zl.g);
        c0307hl.d = this.c.c.b(C0773zl.h);
        c0307hl.e = this.c.c.b(C0773zl.i);
        c0307hl.c = this.c.c.b(C0773zl.f);
        c0307hl.i = this.c.c.b(C0773zl.d);
        c0307hl.f1023a = this.c.c.b(C0773zl.e);
        return new C0255fl(this.f1221a, this.c, new C0332il(c0307hl), new SystemTimeProvider());
    }
}
