package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import io.appmetrica.analytics.coreutils.internal.time.TimeProvider;
import java.util.concurrent.TimeUnit;
/* renamed from: io.appmetrica.analytics.impl.hk  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0317hk {

    /* renamed from: a  reason: collision with root package name */
    public volatile long f888a;
    public C0461nf b;
    public TimeProvider c;

    public static C0317hk c() {
        return AbstractC0292gk.f869a;
    }

    public final synchronized long a() {
        return (System.currentTimeMillis() / 1000) + this.f888a;
    }

    public final synchronized void b() {
        this.b.d(false);
        this.b.b();
    }

    public final synchronized long d() {
        return this.f888a;
    }

    public final synchronized void e() {
        a(Ia.F.x(), new SystemTimeProvider());
    }

    public final synchronized boolean f() {
        return this.b.b(true);
    }

    public final synchronized void a(long j, Long l) {
        this.f888a = (j - this.c.currentTimeMillis()) / 1000;
        boolean z = true;
        if (this.b.b(true)) {
            if (l != null) {
                long abs = Math.abs(j - this.c.currentTimeMillis());
                C0461nf c0461nf = this.b;
                if (abs <= TimeUnit.SECONDS.toMillis(l.longValue())) {
                    z = false;
                }
                c0461nf.d(z);
            } else {
                this.b.d(false);
            }
        }
        this.b.d(this.f888a);
        this.b.b();
    }

    public final void a(C0461nf c0461nf, TimeProvider timeProvider) {
        this.b = c0461nf;
        this.f888a = c0461nf.a(0);
        this.c = timeProvider;
    }
}
