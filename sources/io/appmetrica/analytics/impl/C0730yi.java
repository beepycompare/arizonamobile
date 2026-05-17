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
public final class C0730yi implements InterfaceC0203dk {
    public static final C0705xi e = new C0705xi();
    public static final long f;
    public static final long g;

    /* renamed from: a  reason: collision with root package name */
    public final C0488p0 f1326a;
    public final Yj b;
    public final TimeProvider c;
    public final ICommonExecutor d;

    static {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        f = timeUnit.toMillis(1L);
        g = timeUnit.toMillis(4L);
    }

    public C0730yi(C0488p0 c0488p0, Yj yj, TimeProvider timeProvider) {
        this.f1326a = c0488p0;
        this.b = yj;
        this.c = timeProvider;
        this.d = C0135b4.l().g().b();
    }

    public final void a(C0654vh c0654vh) {
        Callable pg;
        ICommonExecutor iCommonExecutor = this.d;
        boolean z = c0654vh.b;
        Yj yj = this.b;
        if (z) {
            pg = new C0163c6(yj.f876a, yj.b, yj.c, c0654vh);
        } else {
            pg = new Pg(yj.b, yj.c, c0654vh);
        }
        iCommonExecutor.submit(pg);
    }

    public final void b(C0654vh c0654vh) {
        long uptimeMillis = this.c.uptimeMillis();
        Yj yj = this.b;
        C0163c6 c0163c6 = new C0163c6(yj.f876a, yj.b, yj.c, c0654vh);
        long j = Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) ? f : g;
        if (this.f1326a.a()) {
            try {
                this.d.submit(c0163c6).get(j, TimeUnit.MILLISECONDS);
            } catch (Throwable unused) {
            }
        }
        if (c0163c6.c) {
            return;
        }
        try {
            c0163c6.a();
            Thread.sleep(Math.max(0L, j - (this.c.uptimeMillis() - uptimeMillis)));
        } catch (Throwable unused2) {
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0203dk
    public final void reportData(int i, Bundle bundle) {
        ICommonExecutor iCommonExecutor = this.d;
        Yj yj = this.b;
        iCommonExecutor.submit(new Nn(yj.b, yj.c, i, bundle));
    }

    public C0730yi(C0488p0 c0488p0, Yj yj) {
        this(c0488p0, yj, new SystemTimeProvider());
    }

    public final void a(Bf bf) {
        ICommonExecutor iCommonExecutor = this.d;
        Yj yj = this.b;
        iCommonExecutor.submit(new C0551re(yj.b, yj.c, bf));
    }

    public final void b(Bf bf) {
        ICommonExecutor iCommonExecutor = this.d;
        Yj yj = this.b;
        iCommonExecutor.submit(new Ei(yj.b, yj.c, bf));
    }
}
