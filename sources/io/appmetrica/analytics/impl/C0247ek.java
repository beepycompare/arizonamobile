package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import io.appmetrica.analytics.coreutils.internal.time.TimeProvider;
import java.util.concurrent.TimeUnit;
/* renamed from: io.appmetrica.analytics.impl.ek  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0247ek {

    /* renamed from: a  reason: collision with root package name */
    public volatile long f823a;
    public C0416lf b;
    public TimeProvider c;

    public static C0247ek c() {
        return AbstractC0222dk.f808a;
    }

    public final synchronized long a() {
        return (System.currentTimeMillis() / 1000) + this.f823a;
    }

    public final synchronized void b() {
        this.b.d(false);
        this.b.b();
    }

    public final synchronized long d() {
        return this.f823a;
    }

    public final synchronized void e() {
        a(Ga.F.x(), new SystemTimeProvider());
    }

    public final synchronized boolean f() {
        return this.b.b(true);
    }

    public final synchronized void a(long j, Long l) {
        this.f823a = (j - this.c.currentTimeMillis()) / 1000;
        boolean z = true;
        if (this.b.b(true)) {
            if (l != null) {
                long abs = Math.abs(j - this.c.currentTimeMillis());
                C0416lf c0416lf = this.b;
                if (abs <= TimeUnit.SECONDS.toMillis(l.longValue())) {
                    z = false;
                }
                c0416lf.d(z);
            } else {
                this.b.d(false);
            }
        }
        this.b.d(this.f823a);
        this.b.b();
    }

    public final void a(C0416lf c0416lf, TimeProvider timeProvider) {
        this.b = c0416lf;
        this.f823a = c0416lf.a(0);
        this.c = timeProvider;
    }
}
