package io.appmetrica.analytics.impl;

import android.os.Bundle;
import android.os.Looper;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import io.appmetrica.analytics.coreutils.internal.time.TimeProvider;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.yi  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0731yi implements InterfaceC0204dk {
    public static final C0706xi e = new C0706xi();
    public static final long f;
    public static final long g;

    /* renamed from: a  reason: collision with root package name */
    public final C0489p0 f1322a;
    public final Yj b;
    public final TimeProvider c;
    public final ICommonExecutor d;

    static {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        f = timeUnit.toMillis(1L);
        g = timeUnit.toMillis(4L);
    }

    public C0731yi(C0489p0 c0489p0, Yj yj, TimeProvider timeProvider) {
        this.f1322a = c0489p0;
        this.b = yj;
        this.c = timeProvider;
        this.d = C0136b4.l().g().b();
    }

    public final void a(C0655vh c0655vh) {
        Callable pg;
        ICommonExecutor iCommonExecutor = this.d;
        if (c0655vh.b) {
            Yj yj = this.b;
            pg = new C0164c6(yj.f872a, yj.b, yj.c, c0655vh);
        } else {
            Yj yj2 = this.b;
            pg = new Pg(yj2.b, yj2.c, c0655vh);
        }
        iCommonExecutor.submit(pg);
    }

    public final void b(C0655vh c0655vh) {
        long uptimeMillis = this.c.uptimeMillis();
        Yj yj = this.b;
        C0164c6 c0164c6 = new C0164c6(yj.f872a, yj.b, yj.c, c0655vh);
        long j = Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) ? f : g;
        if (this.f1322a.a()) {
            try {
                this.d.submit(c0164c6).get(j, TimeUnit.MILLISECONDS);
            } catch (Throwable unused) {
            }
        }
        if (c0164c6.c) {
            return;
        }
        try {
            c0164c6.a();
            Thread.sleep(Math.max(0L, j - (this.c.uptimeMillis() - uptimeMillis)));
        } catch (Throwable unused2) {
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0204dk
    public final void reportData(int i, Bundle bundle) {
        ICommonExecutor iCommonExecutor = this.d;
        Yj yj = this.b;
        iCommonExecutor.submit(new Nn(yj.b, yj.c, i, bundle));
    }

    public C0731yi(C0489p0 c0489p0, Yj yj) {
        this(c0489p0, yj, new SystemTimeProvider());
    }

    public final void a(Bf bf) {
        ICommonExecutor iCommonExecutor = this.d;
        Yj yj = this.b;
        iCommonExecutor.submit(new C0552re(yj.b, yj.c, bf));
    }

    public final void b(Bf bf) {
        ICommonExecutor iCommonExecutor = this.d;
        Yj yj = this.b;
        iCommonExecutor.submit(new Ei(yj.b, yj.c, bf));
    }
}
