package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import io.appmetrica.analytics.coreutils.internal.time.TimeProvider;
import java.util.concurrent.TimeUnit;
/* renamed from: io.appmetrica.analytics.impl.ek  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0239ek {

    /* renamed from: a  reason: collision with root package name */
    public volatile long f824a;
    public C0408lf b;
    public TimeProvider c;

    public static C0239ek c() {
        return AbstractC0214dk.f809a;
    }

    public final synchronized long a() {
        return (System.currentTimeMillis() / 1000) + this.f824a;
    }

    public final synchronized void b() {
        this.b.d(false);
        this.b.b();
    }

    public final synchronized long d() {
        return this.f824a;
    }

    public final synchronized void e() {
        a(Ga.F.x(), new SystemTimeProvider());
    }

    public final synchronized boolean f() {
        return this.b.b(true);
    }

    public final synchronized void a(long j, Long l) {
        this.f824a = (j - this.c.currentTimeMillis()) / 1000;
        boolean z = true;
        if (this.b.b(true)) {
            if (l != null) {
                long abs = Math.abs(j - this.c.currentTimeMillis());
                C0408lf c0408lf = this.b;
                if (abs <= TimeUnit.SECONDS.toMillis(l.longValue())) {
                    z = false;
                }
                c0408lf.d(z);
            } else {
                this.b.d(false);
            }
        }
        this.b.d(this.f824a);
        this.b.b();
    }

    public final void a(C0408lf c0408lf, TimeProvider timeProvider) {
        this.b = c0408lf;
        this.f824a = c0408lf.a(0);
        this.c = timeProvider;
    }
}
