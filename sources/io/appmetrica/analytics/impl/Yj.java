package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import io.appmetrica.analytics.coreutils.internal.time.TimeProvider;
import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public final class Yj {

    /* renamed from: a  reason: collision with root package name */
    public volatile long f865a;
    public C0116af b;
    public TimeProvider c;

    public static Yj c() {
        return Xj.f849a;
    }

    public final synchronized long a() {
        return (System.currentTimeMillis() / 1000) + this.f865a;
    }

    public final synchronized void b() {
        this.b.d(false);
        this.b.b();
    }

    public final synchronized long d() {
        return this.f865a;
    }

    public final synchronized void e() {
        a(C0470oa.I.y(), new SystemTimeProvider());
    }

    public final synchronized boolean f() {
        return this.b.b(true);
    }

    public final synchronized void a(long j, Long l) {
        this.f865a = (j - this.c.currentTimeMillis()) / 1000;
        boolean z = true;
        if (this.b.b(true)) {
            if (l != null) {
                long abs = Math.abs(j - this.c.currentTimeMillis());
                C0116af c0116af = this.b;
                if (abs <= TimeUnit.SECONDS.toMillis(l.longValue())) {
                    z = false;
                }
                c0116af.d(z);
            } else {
                this.b.d(false);
            }
        }
        this.b.d(this.f865a);
        this.b.b();
    }

    public final void a(C0116af c0116af, TimeProvider timeProvider) {
        this.b = c0116af;
        this.f865a = c0116af.a(0);
        this.c = timeProvider;
    }
}
