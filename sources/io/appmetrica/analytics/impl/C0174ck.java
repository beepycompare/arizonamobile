package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import io.appmetrica.analytics.coreutils.internal.time.TimeProvider;
import java.util.concurrent.TimeUnit;
/* renamed from: io.appmetrica.analytics.impl.ck  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C0174ck {

    /* renamed from: a  reason: collision with root package name */
    public volatile long f833a;
    public C0220ef b;
    public TimeProvider c;

    public static C0174ck c() {
        return AbstractC0148bk.f818a;
    }

    public final synchronized long a() {
        return (System.currentTimeMillis() / 1000) + this.f833a;
    }

    public final synchronized void b() {
        this.b.d(false);
        this.b.b();
    }

    public final synchronized long d() {
        return this.f833a;
    }

    public final synchronized void e() {
        a(C0620ua.H.z(), new SystemTimeProvider());
    }

    public final synchronized boolean f() {
        return this.b.b(true);
    }

    public final synchronized void a(long j, Long l) {
        this.f833a = (j - this.c.currentTimeMillis()) / 1000;
        boolean z = true;
        if (this.b.b(true)) {
            if (l != null) {
                long abs = Math.abs(j - this.c.currentTimeMillis());
                C0220ef c0220ef = this.b;
                if (abs <= TimeUnit.SECONDS.toMillis(l.longValue())) {
                    z = false;
                }
                c0220ef.d(z);
            } else {
                this.b.d(false);
            }
        }
        this.b.d(this.f833a);
        this.b.b();
    }

    public final void a(C0220ef c0220ef, TimeProvider timeProvider) {
        this.b = c0220ef;
        this.f833a = c0220ef.a(0);
        this.c = timeProvider;
    }
}
