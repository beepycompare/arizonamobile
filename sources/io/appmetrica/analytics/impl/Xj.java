package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import io.appmetrica.analytics.coreutils.internal.time.TimeProvider;
import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public final class Xj {

    /* renamed from: a  reason: collision with root package name */
    public volatile long f861a;
    public Ze b;
    public TimeProvider c;

    public static Xj c() {
        return Wj.f846a;
    }

    public final synchronized long a() {
        return (System.currentTimeMillis() / 1000) + this.f861a;
    }

    public final synchronized void b() {
        this.b.d(false);
        this.b.b();
    }

    public final synchronized long d() {
        return this.f861a;
    }

    public final synchronized void e() {
        a(C0448na.I.y(), new SystemTimeProvider());
    }

    public final synchronized boolean f() {
        return this.b.b(true);
    }

    public final synchronized void a(long j, Long l) {
        this.f861a = (j - this.c.currentTimeMillis()) / 1000;
        boolean z = true;
        if (this.b.b(true)) {
            if (l != null) {
                long abs = Math.abs(j - this.c.currentTimeMillis());
                Ze ze = this.b;
                if (abs <= TimeUnit.SECONDS.toMillis(l.longValue())) {
                    z = false;
                }
                ze.d(z);
            } else {
                this.b.d(false);
            }
        }
        this.b.d(this.f861a);
        this.b.b();
    }

    public final void a(Ze ze, TimeProvider timeProvider) {
        this.b = ze;
        this.f861a = ze.a(0);
        this.c = timeProvider;
    }
}
