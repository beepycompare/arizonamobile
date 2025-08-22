package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import io.appmetrica.analytics.coreutils.internal.time.TimeProvider;
import java.util.concurrent.TimeUnit;
/* renamed from: io.appmetrica.analytics.impl.mk  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0438mk {

    /* renamed from: a  reason: collision with root package name */
    public volatile long f971a;
    public C0508pf b;
    public TimeProvider c;

    public static C0438mk c() {
        return AbstractC0413lk.f955a;
    }

    public final synchronized long a() {
        return (System.currentTimeMillis() / 1000) + this.f971a;
    }

    public final synchronized void b() {
        this.b.d(false);
        this.b.b();
    }

    public final synchronized long d() {
        return this.f971a;
    }

    public final synchronized void e() {
        a(Ka.F.x(), new SystemTimeProvider());
    }

    public final synchronized boolean f() {
        return this.b.b(true);
    }

    public final synchronized void a(long j, Long l) {
        this.f971a = (j - this.c.currentTimeMillis()) / 1000;
        boolean z = true;
        if (this.b.b(true)) {
            if (l != null) {
                long abs = Math.abs(j - this.c.currentTimeMillis());
                C0508pf c0508pf = this.b;
                if (abs <= TimeUnit.SECONDS.toMillis(l.longValue())) {
                    z = false;
                }
                c0508pf.d(z);
            } else {
                this.b.d(false);
            }
        }
        this.b.d(this.f971a);
        this.b.b();
    }

    public final void a(C0508pf c0508pf, TimeProvider timeProvider) {
        this.b = c0508pf;
        this.f971a = c0508pf.a(0);
        this.c = timeProvider;
    }
}
