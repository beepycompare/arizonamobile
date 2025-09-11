package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import io.appmetrica.analytics.coreutils.internal.time.TimeProvider;
import java.util.concurrent.TimeUnit;
/* renamed from: io.appmetrica.analytics.impl.qk  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0542qk {

    /* renamed from: a  reason: collision with root package name */
    public volatile long f1053a;
    public C0611tf b;
    public TimeProvider c;

    public static C0542qk c() {
        return AbstractC0517pk.f1037a;
    }

    public final synchronized long a() {
        return (System.currentTimeMillis() / 1000) + this.f1053a;
    }

    public final synchronized void b() {
        this.b.d(false);
        this.b.b();
    }

    public final synchronized long d() {
        return this.f1053a;
    }

    public final synchronized void e() {
        a(Na.F.x(), new SystemTimeProvider());
    }

    public final synchronized boolean f() {
        return this.b.b(true);
    }

    public final synchronized void a(long j, Long l) {
        this.f1053a = (j - this.c.currentTimeMillis()) / 1000;
        boolean z = true;
        if (this.b.b(true)) {
            if (l != null) {
                long abs = Math.abs(j - this.c.currentTimeMillis());
                C0611tf c0611tf = this.b;
                if (abs <= TimeUnit.SECONDS.toMillis(l.longValue())) {
                    z = false;
                }
                c0611tf.d(z);
            } else {
                this.b.d(false);
            }
        }
        this.b.d(this.f1053a);
        this.b.b();
    }

    public final void a(C0611tf c0611tf, TimeProvider timeProvider) {
        this.b = c0611tf;
        this.f1053a = c0611tf.a(0);
        this.c = timeProvider;
    }
}
