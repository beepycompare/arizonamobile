package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import java.util.concurrent.TimeUnit;
/* renamed from: io.appmetrica.analytics.impl.g  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractC0259g {

    /* renamed from: a  reason: collision with root package name */
    public final X4 f1002a;
    public final Qk b;
    public final Uk c;
    public final Pk d;
    public final Ra e;
    public final SystemTimeProvider f;

    public AbstractC0259g(X4 x4, Qk qk, Uk uk, Pk pk, Ra ra, SystemTimeProvider systemTimeProvider) {
        this.f1002a = x4;
        this.b = qk;
        this.c = uk;
        this.d = pk;
        this.e = ra;
        this.f = systemTimeProvider;
    }

    public final /* bridge */ Dk a(Object obj) {
        return a((Ek) obj);
    }

    public final Dk b() {
        if (this.c.h()) {
            return new Dk(this.f1002a, this.c, a(), this.f);
        }
        return null;
    }

    public final Dk a(Ek ek) {
        if (this.c.h()) {
            this.e.reportEvent("create session with non-empty storage");
        }
        X4 x4 = this.f1002a;
        Uk uk = this.c;
        long a2 = this.b.a();
        Uk uk2 = this.c;
        uk2.a(Uk.f, Long.valueOf(a2));
        uk2.a(Uk.d, Long.valueOf(ek.f570a));
        uk2.a(Uk.h, Long.valueOf(ek.f570a));
        uk2.a(Uk.g, 0L);
        uk2.a(Uk.i, Boolean.TRUE);
        uk2.b();
        this.f1002a.e.a(a2, this.d.f742a, TimeUnit.MILLISECONDS.toSeconds(ek.b));
        return new Dk(x4, uk, a(), new SystemTimeProvider());
    }

    public final Gk a() {
        Fk fk = new Fk(this.d);
        fk.g = this.c.i();
        fk.f = this.c.c.a(Uk.g);
        fk.d = this.c.c.a(Uk.h);
        fk.c = this.c.c.a(Uk.f);
        fk.h = this.c.c.a(Uk.d);
        fk.f583a = this.c.c.a(Uk.e);
        return new Gk(fk);
    }
}
