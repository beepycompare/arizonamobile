package io.appmetrica.analytics.impl;

import android.os.Bundle;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import io.appmetrica.analytics.coreutils.internal.time.TimeProvider;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public final class Ui implements InterfaceC0641uk {
    public static final Ti e = new Ti();
    public static final long f = TimeUnit.SECONDS.toMillis(4);

    /* renamed from: a  reason: collision with root package name */
    public final C0471o0 f701a;
    public final C0566rk b;
    public final TimeProvider c;
    public final ICommonExecutor d;

    public Ui(C0471o0 c0471o0, C0566rk c0566rk, TimeProvider timeProvider) {
        this.f701a = c0471o0;
        this.b = c0566rk;
        this.c = timeProvider;
        this.d = A4.l().g().b();
    }

    public final void a(Rh rh) {
        Callable c0410lh;
        ICommonExecutor iCommonExecutor = this.d;
        if (rh.b) {
            C0566rk c0566rk = this.b;
            c0410lh = new B6(c0566rk.f1069a, c0566rk.b, c0566rk.c, rh);
        } else {
            C0566rk c0566rk2 = this.b;
            c0410lh = new C0410lh(c0566rk2.b, c0566rk2.c, rh);
        }
        iCommonExecutor.submit(c0410lh);
    }

    public final void b(Rh rh) {
        long uptimeMillis = this.c.uptimeMillis();
        C0566rk c0566rk = this.b;
        B6 b6 = new B6(c0566rk.f1069a, c0566rk.b, c0566rk.c, rh);
        if (this.f701a.a()) {
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

    @Override // io.appmetrica.analytics.impl.InterfaceC0641uk
    public final void reportData(int i, Bundle bundle) {
        ICommonExecutor iCommonExecutor = this.d;
        C0566rk c0566rk = this.b;
        iCommonExecutor.submit(new Tn(c0566rk.b, c0566rk.c, i, bundle));
    }

    public Ui(C0471o0 c0471o0, C0566rk c0566rk) {
        this(c0471o0, c0566rk, new SystemTimeProvider());
    }

    public final void a(Vf vf) {
        ICommonExecutor iCommonExecutor = this.d;
        C0566rk c0566rk = this.b;
        iCommonExecutor.submit(new Le(c0566rk.b, c0566rk.c, vf));
    }

    public final void b(Vf vf) {
        ICommonExecutor iCommonExecutor = this.d;
        C0566rk c0566rk = this.b;
        iCommonExecutor.submit(new C0128aj(c0566rk.b, c0566rk.c, vf));
    }
}
