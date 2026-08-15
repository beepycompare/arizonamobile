package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import java.util.concurrent.TimeUnit;
/* renamed from: io.appmetrica.analytics.impl.g  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC0260g implements InterfaceC0582sb {

    /* renamed from: a  reason: collision with root package name */
    public final C0447n5 f989a;
    public final C0644ul b;
    public final C0774zl c;
    public final C0592sl d;
    public final InterfaceC0505pb e;
    public final SystemTimeProvider f;

    public AbstractC0260g(C0447n5 c0447n5, C0644ul c0644ul, C0774zl c0774zl, C0592sl c0592sl, InterfaceC0505pb interfaceC0505pb, SystemTimeProvider systemTimeProvider) {
        this.f989a = c0447n5;
        this.b = c0644ul;
        this.c = c0774zl;
        this.d = c0592sl;
        this.e = interfaceC0505pb;
        this.f = systemTimeProvider;
    }

    public final C0333il b() {
        C0308hl c0308hl = new C0308hl(this.d);
        c0308hl.h = this.c.c.a(C0774zl.j);
        c0308hl.g = this.c.c.b(C0774zl.g);
        c0308hl.d = this.c.c.b(C0774zl.h);
        c0308hl.e = this.c.c.b(C0774zl.i);
        c0308hl.c = this.c.c.b(C0774zl.f);
        c0308hl.i = this.c.c.b(C0774zl.d);
        c0308hl.f1023a = this.c.c.b(C0774zl.e);
        c0308hl.j = this.c.c.a(C0774zl.k);
        return new C0333il(c0308hl);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0582sb
    public final C0256fl a() {
        if (this.c.i()) {
            return new C0256fl(this.f989a, this.c, b(), this.f);
        }
        return null;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0582sb
    public final C0256fl a(C0282gl c0282gl) {
        boolean b;
        if (this.c.i()) {
            this.e.reportEvent("create session with non-empty storage");
        }
        C0447n5 c0447n5 = this.f989a;
        C0774zl c0774zl = this.c;
        long a2 = this.b.a();
        C0774zl c0774zl2 = this.c;
        c0774zl2.a(C0774zl.f, Long.valueOf(a2));
        c0774zl2.a(C0774zl.d, Long.valueOf(c0282gl.f1003a));
        c0774zl2.a(C0774zl.h, Long.valueOf(c0282gl.f1003a));
        c0774zl2.a(C0774zl.i, Long.valueOf(c0282gl.b));
        c0774zl2.a(C0774zl.g, 0L);
        c0774zl2.a(C0774zl.j, Boolean.TRUE);
        c0774zl2.a();
        C0165c7 c0165c7 = this.f989a.e;
        Al al = this.d.f1204a;
        long seconds = TimeUnit.MILLISECONDS.toSeconds(c0282gl.b);
        c0165c7.getClass();
        K7 k7 = new K7(null, 1, null);
        Long valueOf = Long.valueOf(a2);
        Long valueOf2 = Long.valueOf(seconds);
        String a3 = L7.a((Eh) c0165c7.e.k.a());
        Long valueOf3 = Long.valueOf(AbstractC0414lo.a());
        C0773zk c0773zk = AbstractC0747yk.f1301a;
        synchronized (c0773zk) {
            b = c0773zk.b.b(true);
        }
        c0165c7.a(k7.fromModel(new J7(valueOf, al, a3, new I7(valueOf2, valueOf3, Boolean.valueOf(b)))));
        return new C0256fl(c0447n5, c0774zl, b(), new SystemTimeProvider());
    }
}
