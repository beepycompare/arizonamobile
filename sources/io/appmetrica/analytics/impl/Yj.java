package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import io.appmetrica.analytics.coreutils.internal.time.TimeProvider;
import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public final class Yj {

    /* renamed from: a  reason: collision with root package name */
    public volatile long f768a;
    public C0117af b;
    public TimeProvider c;

    public static Yj c() {
        return Xj.f752a;
    }

    public final synchronized long a() {
        return (System.currentTimeMillis() / 1000) + this.f768a;
    }

    public final synchronized void b() {
        this.b.d(false);
        this.b.b();
    }

    public final synchronized long d() {
        return this.f768a;
    }

    public final synchronized void e() {
        a(C0471oa.I.y(), new SystemTimeProvider());
    }

    public final synchronized boolean f() {
        return this.b.b(true);
    }

    public final synchronized void a(long j, Long l) {
        this.f768a = (j - this.c.currentTimeMillis()) / 1000;
        boolean z = true;
        if (this.b.b(true)) {
            if (l != null) {
                long abs = Math.abs(j - this.c.currentTimeMillis());
                C0117af c0117af = this.b;
                if (abs <= TimeUnit.SECONDS.toMillis(l.longValue())) {
                    z = false;
                }
                c0117af.d(z);
            } else {
                this.b.d(false);
            }
        }
        this.b.d(this.f768a);
        this.b.b();
    }

    public final void a(C0117af c0117af, TimeProvider timeProvider) {
        this.b = c0117af;
        this.f768a = c0117af.a(0);
        this.c = timeProvider;
    }
}
