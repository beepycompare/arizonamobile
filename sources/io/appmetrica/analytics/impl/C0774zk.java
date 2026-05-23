package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import io.appmetrica.analytics.coreutils.internal.time.TimeProvider;
import java.util.concurrent.TimeUnit;
/* renamed from: io.appmetrica.analytics.impl.zk  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0774zk {

    /* renamed from: a  reason: collision with root package name */
    public volatile long f1319a;
    public C0769zf b;
    public TimeProvider c;

    public static C0774zk c() {
        return AbstractC0748yk.f1298a;
    }

    public final synchronized long a() {
        return (System.currentTimeMillis() / 1000) + this.f1319a;
    }

    public final synchronized void b() {
        this.b.d(false);
    }

    public final synchronized long d() {
        return this.f1319a;
    }

    public final synchronized void e() {
        a(Na.I.y(), new SystemTimeProvider());
    }

    public final synchronized boolean f() {
        return this.b.b(true);
    }

    public final synchronized void a(long j, Long l) {
        this.f1319a = (j - this.c.currentTimeMillis()) / 1000;
        boolean z = true;
        if (this.b.b(true)) {
            if (l != null) {
                long abs = Math.abs(j - this.c.currentTimeMillis());
                C0769zf c0769zf = this.b;
                if (abs <= TimeUnit.SECONDS.toMillis(l.longValue())) {
                    z = false;
                }
                c0769zf.d(z);
            } else {
                this.b.d(false);
            }
        }
        this.b.b(this.f1319a);
    }

    public final void a(C0769zf c0769zf, TimeProvider timeProvider) {
        this.b = c0769zf;
        this.f1319a = c0769zf.a(0);
        this.c = timeProvider;
    }
}
