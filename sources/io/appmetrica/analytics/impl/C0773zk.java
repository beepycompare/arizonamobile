package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import io.appmetrica.analytics.coreutils.internal.time.TimeProvider;
import java.util.concurrent.TimeUnit;
/* renamed from: io.appmetrica.analytics.impl.zk  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0773zk {

    /* renamed from: a  reason: collision with root package name */
    public volatile long f1322a;
    public C0768zf b;
    public TimeProvider c;

    public static C0773zk c() {
        return AbstractC0747yk.f1301a;
    }

    public final synchronized long a() {
        return (System.currentTimeMillis() / 1000) + this.f1322a;
    }

    public final synchronized void b() {
        this.b.d(false);
    }

    public final synchronized long d() {
        return this.f1322a;
    }

    public final synchronized void e() {
        a(Na.I.y(), new SystemTimeProvider());
    }

    public final synchronized boolean f() {
        return this.b.b(true);
    }

    public final synchronized void a(long j, Long l) {
        this.f1322a = (j - this.c.currentTimeMillis()) / 1000;
        boolean z = true;
        if (this.b.b(true)) {
            if (l != null) {
                long abs = Math.abs(j - this.c.currentTimeMillis());
                C0768zf c0768zf = this.b;
                if (abs <= TimeUnit.SECONDS.toMillis(l.longValue())) {
                    z = false;
                }
                c0768zf.d(z);
            } else {
                this.b.d(false);
            }
        }
        this.b.b(this.f1322a);
    }

    public final void a(C0768zf c0768zf, TimeProvider timeProvider) {
        this.b = c0768zf;
        this.f1322a = c0768zf.a(0);
        this.c = timeProvider;
    }
}
