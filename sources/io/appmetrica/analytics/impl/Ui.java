package io.appmetrica.analytics.impl;

import android.os.Bundle;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import io.appmetrica.analytics.coreutils.internal.time.TimeProvider;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public final class Ui implements InterfaceC0642uk {
    public static final Ti e = new Ti();
    public static final long f = TimeUnit.SECONDS.toMillis(4);

    /* renamed from: a  reason: collision with root package name */
    public final C0472o0 f702a;
    public final C0567rk b;
    public final TimeProvider c;
    public final ICommonExecutor d;

    public Ui(C0472o0 c0472o0, C0567rk c0567rk, TimeProvider timeProvider) {
        this.f702a = c0472o0;
        this.b = c0567rk;
        this.c = timeProvider;
        this.d = A4.l().g().b();
    }

    public final void a(Rh rh) {
        Callable c0411lh;
        ICommonExecutor iCommonExecutor = this.d;
        if (rh.b) {
            C0567rk c0567rk = this.b;
            c0411lh = new B6(c0567rk.f1070a, c0567rk.b, c0567rk.c, rh);
        } else {
            C0567rk c0567rk2 = this.b;
            c0411lh = new C0411lh(c0567rk2.b, c0567rk2.c, rh);
        }
        iCommonExecutor.submit(c0411lh);
    }

    public final void b(Rh rh) {
        long uptimeMillis = this.c.uptimeMillis();
        C0567rk c0567rk = this.b;
        B6 b6 = new B6(c0567rk.f1070a, c0567rk.b, c0567rk.c, rh);
        if (this.f702a.a()) {
            try {
                this.d.submit(b6).get(f, TimeUnit.MILLISECONDS);
            } catch (Throwable unused) {
            }
        }
        if (!b6.c) {
            try {
                b6.a();
            } catch (Throwable unused2) {
            }
        }
        try {
            Thread.sleep(Math.max(0L, f - (this.c.uptimeMillis() - uptimeMillis)));
        } catch (Throwable unused3) {
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0642uk
    public final void reportData(int i, Bundle bundle) {
        ICommonExecutor iCommonExecutor = this.d;
        C0567rk c0567rk = this.b;
        iCommonExecutor.submit(new Tn(c0567rk.b, c0567rk.c, i, bundle));
    }

    public Ui(C0472o0 c0472o0, C0567rk c0567rk) {
        this(c0472o0, c0567rk, new SystemTimeProvider());
    }

    public final void a(Vf vf) {
        ICommonExecutor iCommonExecutor = this.d;
        C0567rk c0567rk = this.b;
        iCommonExecutor.submit(new Le(c0567rk.b, c0567rk.c, vf));
    }

    public final void b(Vf vf) {
        ICommonExecutor iCommonExecutor = this.d;
        C0567rk c0567rk = this.b;
        iCommonExecutor.submit(new C0129aj(c0567rk.b, c0567rk.c, vf));
    }
}
