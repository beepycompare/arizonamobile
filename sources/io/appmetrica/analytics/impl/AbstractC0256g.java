package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import java.util.concurrent.TimeUnit;
/* renamed from: io.appmetrica.analytics.impl.g  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC0256g {

    /* renamed from: a  reason: collision with root package name */
    public final C0210e5 f883a;
    public final Vk b;
    public final Zk c;
    public final Uk d;
    public final Ya e;
    public final SystemTimeProvider f;

    public AbstractC0256g(C0210e5 c0210e5, Vk vk, Zk zk, Uk uk, Ya ya, SystemTimeProvider systemTimeProvider) {
        this.f883a = c0210e5;
        this.b = vk;
        this.c = zk;
        this.d = uk;
        this.e = ya;
        this.f = systemTimeProvider;
    }

    public final /* bridge */ Ik a(Object obj) {
        return a((Jk) obj);
    }

    public final Ik b() {
        if (this.c.h()) {
            return new Ik(this.f883a, this.c, a(), this.f);
        }
        return null;
    }

    public final Ik a(Jk jk) {
        if (this.c.h()) {
            this.e.reportEvent("create session with non-empty storage");
        }
        C0210e5 c0210e5 = this.f883a;
        Zk zk = this.c;
        long a2 = this.b.a();
        Zk zk2 = this.c;
        zk2.a(Zk.f, Long.valueOf(a2));
        zk2.a(Zk.d, Long.valueOf(jk.f549a));
        zk2.a(Zk.h, Long.valueOf(jk.f549a));
        zk2.a(Zk.g, 0L);
        zk2.a(Zk.i, Boolean.TRUE);
        zk2.b();
        this.f883a.e.a(a2, this.d.f723a, TimeUnit.MILLISECONDS.toSeconds(jk.b));
        return new Ik(c0210e5, zk, a(), new SystemTimeProvider());
    }

    public final Lk a() {
        Kk kk = new Kk(this.d);
        kk.g = this.c.i();
        kk.f = this.c.c.a(Zk.g);
        kk.d = this.c.c.a(Zk.h);
        kk.c = this.c.c.a(Zk.f);
        kk.h = this.c.c.a(Zk.d);
        kk.f562a = this.c.c.a(Zk.e);
        return new Lk(kk);
    }
}
