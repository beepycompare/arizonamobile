package io.appmetrica.analytics.impl;

import android.os.Bundle;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import io.appmetrica.analytics.coreutils.internal.time.TimeProvider;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public final class Li implements InterfaceC0415lk {
    public static final Ki e = new Ki();
    public static final long f = TimeUnit.SECONDS.toMillis(4);

    /* renamed from: a  reason: collision with root package name */
    public final C0420m0 f534a;
    public final C0340ik b;
    public final TimeProvider c;
    public final ICommonExecutor d;

    public Li(C0420m0 c0420m0, C0340ik c0340ik, TimeProvider timeProvider) {
        this.f534a = c0420m0;
        this.b = c0340ik;
        this.c = timeProvider;
        this.d = C0698x4.l().g().b();
    }

    public final void a(Ih ih) {
        Kh c0185ch;
        ICommonExecutor iCommonExecutor = this.d;
        if (ih.b) {
            C0340ik c0340ik = this.b;
            c0185ch = new C0725y6(c0340ik.f903a, c0340ik.b, c0340ik.c, ih);
        } else {
            C0340ik c0340ik2 = this.b;
            c0185ch = new C0185ch(c0340ik2.b, c0340ik2.c, ih);
        }
        iCommonExecutor.submit(c0185ch);
    }

    public final void b(Ih ih) {
        long uptimeMillis = this.c.uptimeMillis();
        C0340ik c0340ik = this.b;
        C0725y6 c0725y6 = new C0725y6(c0340ik.f903a, c0340ik.b, c0340ik.c, ih);
        if (this.f534a.a()) {
            try {
                this.d.submit(c0725y6).get(f, TimeUnit.MILLISECONDS);
            } catch (Throwable unused) {
            }
        }
        if (!c0725y6.c) {
            try {
                c0725y6.a();
            } catch (Throwable unused2) {
            }
        }
        try {
            Thread.sleep(Math.max(0L, f - (this.c.uptimeMillis() - uptimeMillis)));
        } catch (Throwable unused3) {
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0415lk
    public final void reportData(int i, Bundle bundle) {
        ICommonExecutor iCommonExecutor = this.d;
        C0340ik c0340ik = this.b;
        iCommonExecutor.submit(new Kn(c0340ik.b, c0340ik.c, i, bundle));
    }

    public Li(C0420m0 c0420m0, C0340ik c0340ik) {
        this(c0420m0, c0340ik, new SystemTimeProvider());
    }

    public final void a(Pf pf) {
        ICommonExecutor iCommonExecutor = this.d;
        C0340ik c0340ik = this.b;
        iCommonExecutor.submit(new Fe(c0340ik.b, c0340ik.c, pf));
    }

    public final void b(Pf pf) {
        ICommonExecutor iCommonExecutor = this.d;
        C0340ik c0340ik = this.b;
        iCommonExecutor.submit(new Ri(c0340ik.b, c0340ik.c, pf));
    }
}
