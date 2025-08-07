package io.appmetrica.analytics.impl;

import android.os.Bundle;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import io.appmetrica.analytics.coreutils.internal.time.TimeProvider;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public final class Li implements InterfaceC0416lk {
    public static final Ki e = new Ki();
    public static final long f = TimeUnit.SECONDS.toMillis(4);

    /* renamed from: a  reason: collision with root package name */
    public final C0421m0 f534a;
    public final C0341ik b;
    public final TimeProvider c;
    public final ICommonExecutor d;

    public Li(C0421m0 c0421m0, C0341ik c0341ik, TimeProvider timeProvider) {
        this.f534a = c0421m0;
        this.b = c0341ik;
        this.c = timeProvider;
        this.d = C0699x4.l().g().b();
    }

    public final void a(Ih ih) {
        Kh c0186ch;
        ICommonExecutor iCommonExecutor = this.d;
        if (ih.b) {
            C0341ik c0341ik = this.b;
            c0186ch = new C0726y6(c0341ik.f903a, c0341ik.b, c0341ik.c, ih);
        } else {
            C0341ik c0341ik2 = this.b;
            c0186ch = new C0186ch(c0341ik2.b, c0341ik2.c, ih);
        }
        iCommonExecutor.submit(c0186ch);
    }

    public final void b(Ih ih) {
        long uptimeMillis = this.c.uptimeMillis();
        C0341ik c0341ik = this.b;
        C0726y6 c0726y6 = new C0726y6(c0341ik.f903a, c0341ik.b, c0341ik.c, ih);
        if (this.f534a.a()) {
            try {
                this.d.submit(c0726y6).get(f, TimeUnit.MILLISECONDS);
            } catch (Throwable unused) {
            }
        }
        if (!c0726y6.c) {
            try {
                c0726y6.a();
            } catch (Throwable unused2) {
            }
        }
        try {
            Thread.sleep(Math.max(0L, f - (this.c.uptimeMillis() - uptimeMillis)));
        } catch (Throwable unused3) {
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0416lk
    public final void reportData(int i, Bundle bundle) {
        ICommonExecutor iCommonExecutor = this.d;
        C0341ik c0341ik = this.b;
        iCommonExecutor.submit(new Kn(c0341ik.b, c0341ik.c, i, bundle));
    }

    public Li(C0421m0 c0421m0, C0341ik c0341ik) {
        this(c0421m0, c0341ik, new SystemTimeProvider());
    }

    public final void a(Pf pf) {
        ICommonExecutor iCommonExecutor = this.d;
        C0341ik c0341ik = this.b;
        iCommonExecutor.submit(new Fe(c0341ik.b, c0341ik.c, pf));
    }

    public final void b(Pf pf) {
        ICommonExecutor iCommonExecutor = this.d;
        C0341ik c0341ik = this.b;
        iCommonExecutor.submit(new Ri(c0341ik.b, c0341ik.c, pf));
    }
}
