package io.appmetrica.analytics.impl;

import android.os.Bundle;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import io.appmetrica.analytics.coreutils.internal.time.TimeProvider;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public final class Ii implements InterfaceC0338ik {
    public static final Hi e = new Hi();
    public static final long f = TimeUnit.SECONDS.toMillis(4);

    /* renamed from: a  reason: collision with root package name */
    public final C0418m0 f479a;
    public final C0264fk b;
    public final TimeProvider c;
    public final ICommonExecutor d;

    public Ii(C0418m0 c0418m0, C0264fk c0264fk, TimeProvider timeProvider) {
        this.f479a = c0418m0;
        this.b = c0264fk;
        this.c = timeProvider;
        this.d = C0696x4.l().g().b();
    }

    public final void a(Gh gh) {
        Ih c0133ah;
        ICommonExecutor iCommonExecutor = this.d;
        if (gh.b) {
            C0264fk c0264fk = this.b;
            c0133ah = new C0648v6(c0264fk.f842a, c0264fk.b, c0264fk.c, gh);
        } else {
            C0264fk c0264fk2 = this.b;
            c0133ah = new C0133ah(c0264fk2.b, c0264fk2.c, gh);
        }
        iCommonExecutor.submit(c0133ah);
    }

    public final void b(Gh gh) {
        long uptimeMillis = this.c.uptimeMillis();
        C0264fk c0264fk = this.b;
        C0648v6 c0648v6 = new C0648v6(c0264fk.f842a, c0264fk.b, c0264fk.c, gh);
        if (this.f479a.a()) {
            try {
                this.d.submit(c0648v6).get(f, TimeUnit.MILLISECONDS);
            } catch (Throwable unused) {
            }
        }
        if (!c0648v6.c) {
            try {
                c0648v6.a();
            } catch (Throwable unused2) {
            }
        }
        try {
            Thread.sleep(Math.max(0L, f - (this.c.uptimeMillis() - uptimeMillis)));
        } catch (Throwable unused3) {
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0338ik
    public final void reportData(int i, Bundle bundle) {
        ICommonExecutor iCommonExecutor = this.d;
        C0264fk c0264fk = this.b;
        iCommonExecutor.submit(new Hn(c0264fk.b, c0264fk.c, i, bundle));
    }

    public Ii(C0418m0 c0418m0, C0264fk c0264fk) {
        this(c0418m0, c0264fk, new SystemTimeProvider());
    }

    public final void a(Nf nf) {
        ICommonExecutor iCommonExecutor = this.d;
        C0264fk c0264fk = this.b;
        iCommonExecutor.submit(new De(c0264fk.b, c0264fk.c, nf));
    }

    public final void b(Nf nf) {
        ICommonExecutor iCommonExecutor = this.d;
        C0264fk c0264fk = this.b;
        iCommonExecutor.submit(new Oi(c0264fk.b, c0264fk.c, nf));
    }
}
