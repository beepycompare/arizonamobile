package io.appmetrica.analytics.impl;

import android.os.Bundle;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import io.appmetrica.analytics.coreutils.internal.time.TimeProvider;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
/* loaded from: classes3.dex */
public final class Di implements InterfaceC0328ik {
    public static final Ci e = new Ci();
    public static final long f = TimeUnit.SECONDS.toMillis(4);

    /* renamed from: a  reason: collision with root package name */
    public final C0486p0 f442a;
    public final C0200dk b;
    public final TimeProvider c;
    public final ICommonExecutor d;

    public Di(C0486p0 c0486p0, C0200dk c0200dk, TimeProvider timeProvider) {
        this.f442a = c0486p0;
        this.b = c0200dk;
        this.c = timeProvider;
        this.d = C0338j4.l().g().b();
    }

    public final void a(Ah ah) {
        Callable ug;
        ICommonExecutor iCommonExecutor = this.d;
        if (ah.b) {
            C0200dk c0200dk = this.b;
            ug = new C0340j6(c0200dk.f850a, c0200dk.b, c0200dk.c, ah);
        } else {
            C0200dk c0200dk2 = this.b;
            ug = new Ug(c0200dk2.b, c0200dk2.c, ah);
        }
        iCommonExecutor.submit(ug);
    }

    public final void b(Ah ah) {
        long uptimeMillis = this.c.uptimeMillis();
        C0200dk c0200dk = this.b;
        C0340j6 c0340j6 = new C0340j6(c0200dk.f850a, c0200dk.b, c0200dk.c, ah);
        if (this.f442a.a()) {
            try {
                this.d.submit(c0340j6).get(f, TimeUnit.MILLISECONDS);
            } catch (Throwable unused) {
            }
        }
        if (!c0340j6.c) {
            try {
                c0340j6.a();
            } catch (Throwable unused2) {
            }
        }
        try {
            Thread.sleep(Math.max(0L, f - (this.c.uptimeMillis() - uptimeMillis)));
        } catch (Throwable unused3) {
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0328ik
    public final void reportData(int i, Bundle bundle) {
        ICommonExecutor iCommonExecutor = this.d;
        C0200dk c0200dk = this.b;
        iCommonExecutor.submit(new Pn(c0200dk.b, c0200dk.c, i, bundle));
    }

    public Di(C0486p0 c0486p0, C0200dk c0200dk) {
        this(c0486p0, c0200dk, new SystemTimeProvider());
    }

    public final void a(Gf gf) {
        ICommonExecutor iCommonExecutor = this.d;
        C0200dk c0200dk = this.b;
        iCommonExecutor.submit(new C0699xe(c0200dk.b, c0200dk.c, gf));
    }

    public final void b(Gf gf) {
        ICommonExecutor iCommonExecutor = this.d;
        C0200dk c0200dk = this.b;
        iCommonExecutor.submit(new Ji(c0200dk.b, c0200dk.c, gf));
    }
}
