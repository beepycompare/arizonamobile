package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import java.util.concurrent.TimeUnit;
/* renamed from: io.appmetrica.analytics.impl.tl  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0618tl implements InterfaceC0582sb {

    /* renamed from: a  reason: collision with root package name */
    public final C0447n5 f1221a;
    public final C0644ul b;
    public final C0774zl c;
    public final C0592sl d = C0592sl.a(Al.BACKGROUND).b().a();

    public C0618tl(C0447n5 c0447n5, C0644ul c0644ul) {
        this.f1221a = c0447n5;
        this.b = c0644ul;
        this.c = new C0774zl(c0447n5.h(), M2.g);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0582sb
    public final C0256fl a() {
        return null;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0582sb
    public final C0256fl a(C0282gl c0282gl) {
        String a2;
        boolean b;
        long a3 = this.b.a();
        C0774zl c0774zl = this.c;
        c0774zl.a(C0774zl.f, Long.valueOf(a3));
        c0774zl.a(C0774zl.d, Long.valueOf(c0282gl.f1003a));
        c0774zl.a(C0774zl.h, Long.valueOf(c0282gl.f1003a));
        c0774zl.a(C0774zl.i, Long.valueOf(c0282gl.b));
        c0774zl.a(C0774zl.g, 0L);
        c0774zl.a(C0774zl.j, Boolean.FALSE);
        c0774zl.a();
        C0165c7 c0165c7 = this.f1221a.e;
        Al al = Al.BACKGROUND;
        long seconds = TimeUnit.MILLISECONDS.toSeconds(c0282gl.b);
        C0696wl c0696wl = c0282gl.c;
        c0165c7.getClass();
        K7 k7 = new K7(null, 1, null);
        Eh eh = (Eh) c0165c7.e.k.a();
        Long valueOf = Long.valueOf(a3);
        Long valueOf2 = Long.valueOf(seconds);
        if (c0696wl == null || (a2 = c0696wl.f1272a) == null) {
            a2 = L7.a(eh);
        }
        Long valueOf3 = Long.valueOf(AbstractC0414lo.a());
        C0773zk c0773zk = AbstractC0747yk.f1301a;
        synchronized (c0773zk) {
            b = c0773zk.b.b(true);
        }
        c0165c7.a(k7.fromModel(new J7(valueOf, al, a2, new I7(valueOf2, valueOf3, Boolean.valueOf(b)))));
        C0308hl c0308hl = new C0308hl(this.d);
        c0308hl.h = this.c.c.a(C0774zl.j);
        c0308hl.g = this.c.c.b(C0774zl.g);
        c0308hl.d = this.c.c.b(C0774zl.h);
        c0308hl.e = this.c.c.b(C0774zl.i);
        c0308hl.c = this.c.c.b(C0774zl.f);
        c0308hl.i = this.c.c.b(C0774zl.d);
        c0308hl.f1023a = this.c.c.b(C0774zl.e);
        return new C0256fl(this.f1221a, this.c, new C0333il(c0308hl), new SystemTimeProvider());
    }
}
