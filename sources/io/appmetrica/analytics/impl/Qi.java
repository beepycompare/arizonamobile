package io.appmetrica.analytics.impl;

import android.os.Bundle;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import io.appmetrica.analytics.coreutils.internal.time.TimeProvider;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public final class Qi implements InterfaceC0538qk {
    public static final Pi e = new Pi();
    public static final long f = TimeUnit.SECONDS.toMillis(4);

    /* renamed from: a  reason: collision with root package name */
    public final C0418m0 f622a;
    public final C0463nk b;
    public final TimeProvider c;
    public final ICommonExecutor d;

    public Qi(C0418m0 c0418m0, C0463nk c0463nk, TimeProvider timeProvider) {
        this.f622a = c0418m0;
        this.b = c0463nk;
        this.c = timeProvider;
        this.d = C0696x4.l().g().b();
    }

    public final void a(Nh nh) {
        Ph c0307hh;
        ICommonExecutor iCommonExecutor = this.d;
        if (nh.b) {
            C0463nk c0463nk = this.b;
            c0307hh = new C0723y6(c0463nk.f986a, c0463nk.b, c0463nk.c, nh);
        } else {
            C0463nk c0463nk2 = this.b;
            c0307hh = new C0307hh(c0463nk2.b, c0463nk2.c, nh);
        }
        iCommonExecutor.submit(c0307hh);
    }

    public final void b(Nh nh) {
        long uptimeMillis = this.c.uptimeMillis();
        C0463nk c0463nk = this.b;
        C0723y6 c0723y6 = new C0723y6(c0463nk.f986a, c0463nk.b, c0463nk.c, nh);
        if (this.f622a.a()) {
            try {
                this.d.submit(c0723y6).get(f, TimeUnit.MILLISECONDS);
            } catch (Throwable unused) {
            }
        }
        if (!c0723y6.c) {
            try {
                c0723y6.a();
            } catch (Throwable unused2) {
            }
        }
        try {
            Thread.sleep(Math.max(0L, f - (this.c.uptimeMillis() - uptimeMillis)));
        } catch (Throwable unused3) {
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0538qk
    public final void reportData(int i, Bundle bundle) {
        ICommonExecutor iCommonExecutor = this.d;
        C0463nk c0463nk = this.b;
        iCommonExecutor.submit(new Pn(c0463nk.b, c0463nk.c, i, bundle));
    }

    public Qi(C0418m0 c0418m0, C0463nk c0463nk) {
        this(c0418m0, c0463nk, new SystemTimeProvider());
    }

    public final void a(Rf rf) {
        ICommonExecutor iCommonExecutor = this.d;
        C0463nk c0463nk = this.b;
        iCommonExecutor.submit(new He(c0463nk.b, c0463nk.c, rf));
    }

    public final void b(Rf rf) {
        ICommonExecutor iCommonExecutor = this.d;
        C0463nk c0463nk = this.b;
        iCommonExecutor.submit(new Wi(c0463nk.b, c0463nk.c, rf));
    }
}
