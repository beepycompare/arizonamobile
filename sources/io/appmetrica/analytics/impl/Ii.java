package io.appmetrica.analytics.impl;

import android.os.Bundle;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import io.appmetrica.analytics.coreutils.internal.time.TimeProvider;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public final class Ii implements InterfaceC0346ik {
    public static final Hi e = new Hi();
    public static final long f = TimeUnit.SECONDS.toMillis(4);

    /* renamed from: a  reason: collision with root package name */
    public final C0426m0 f478a;
    public final C0272fk b;
    public final TimeProvider c;
    public final ICommonExecutor d;

    public Ii(C0426m0 c0426m0, C0272fk c0272fk, TimeProvider timeProvider) {
        this.f478a = c0426m0;
        this.b = c0272fk;
        this.c = timeProvider;
        this.d = C0704x4.l().g().b();
    }

    public final void a(Gh gh) {
        Ih c0141ah;
        ICommonExecutor iCommonExecutor = this.d;
        if (gh.b) {
            C0272fk c0272fk = this.b;
            c0141ah = new C0656v6(c0272fk.f841a, c0272fk.b, c0272fk.c, gh);
        } else {
            C0272fk c0272fk2 = this.b;
            c0141ah = new C0141ah(c0272fk2.b, c0272fk2.c, gh);
        }
        iCommonExecutor.submit(c0141ah);
    }

    public final void b(Gh gh) {
        long uptimeMillis = this.c.uptimeMillis();
        C0272fk c0272fk = this.b;
        C0656v6 c0656v6 = new C0656v6(c0272fk.f841a, c0272fk.b, c0272fk.c, gh);
        if (this.f478a.a()) {
            try {
                this.d.submit(c0656v6).get(f, TimeUnit.MILLISECONDS);
            } catch (Throwable unused) {
            }
        }
        if (!c0656v6.c) {
            try {
                c0656v6.a();
            } catch (Throwable unused2) {
            }
        }
        try {
            Thread.sleep(Math.max(0L, f - (this.c.uptimeMillis() - uptimeMillis)));
        } catch (Throwable unused3) {
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0346ik
    public final void reportData(int i, Bundle bundle) {
        ICommonExecutor iCommonExecutor = this.d;
        C0272fk c0272fk = this.b;
        iCommonExecutor.submit(new Hn(c0272fk.b, c0272fk.c, i, bundle));
    }

    public Ii(C0426m0 c0426m0, C0272fk c0272fk) {
        this(c0426m0, c0272fk, new SystemTimeProvider());
    }

    public final void a(Nf nf) {
        ICommonExecutor iCommonExecutor = this.d;
        C0272fk c0272fk = this.b;
        iCommonExecutor.submit(new De(c0272fk.b, c0272fk.c, nf));
    }

    public final void b(Nf nf) {
        ICommonExecutor iCommonExecutor = this.d;
        C0272fk c0272fk = this.b;
        iCommonExecutor.submit(new Oi(c0272fk.b, c0272fk.c, nf));
    }
}
