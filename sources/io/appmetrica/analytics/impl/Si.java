package io.appmetrica.analytics.impl;

import android.os.Bundle;
import android.os.Looper;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import io.appmetrica.analytics.coreutils.internal.time.TimeProvider;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class Si implements Fk {
    public static final Ri e = new Ri();
    public static final long f;
    public static final long g;

    /* renamed from: a  reason: collision with root package name */
    public final C0545r0 f767a;
    public final Ak b;
    public final TimeProvider c;
    public final ICommonExecutor d;

    static {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        f = timeUnit.toMillis(1L);
        g = timeUnit.toMillis(4L);
    }

    public Si(C0545r0 c0545r0, Ak ak, TimeProvider timeProvider) {
        this.f767a = c0545r0;
        this.b = ak;
        this.c = timeProvider;
        this.d = C0575s4.l().g().c();
    }

    public final void a(Ph ph) {
        Rh c0252fh;
        ICommonExecutor iCommonExecutor = this.d;
        boolean z = ph.b;
        Ak ak = this.b;
        if (z) {
            c0252fh = new C0577s6(ak.f464a, ak.b, ak.c, ph, true);
        } else {
            c0252fh = new C0252fh(ak.b, ak.c, ph);
        }
        iCommonExecutor.submit(c0252fh);
    }

    public final void b(Ph ph) {
        long uptimeMillis = this.c.uptimeMillis();
        Ak ak = this.b;
        C0577s6 c0577s6 = new C0577s6(ak.f464a, ak.b, ak.c, ph, false);
        long j = Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) ? f : g;
        if (this.f767a.a()) {
            try {
                this.d.submit(c0577s6).get(j, TimeUnit.MILLISECONDS);
            } catch (Throwable unused) {
            }
        }
        if (c0577s6.c) {
            return;
        }
        try {
            c0577s6.a();
            Thread.sleep(Math.max(0L, j - (this.c.uptimeMillis() - uptimeMillis)));
        } catch (Throwable unused2) {
        }
    }

    @Override // io.appmetrica.analytics.impl.Fk
    public final void reportData(int i, Bundle bundle) {
        ICommonExecutor iCommonExecutor = this.d;
        Ak ak = this.b;
        iCommonExecutor.submit(new C0544qo(ak.b, ak.c, i, bundle));
    }

    public Si(C0545r0 c0545r0, Ak ak) {
        this(c0545r0, ak, new SystemTimeProvider());
    }

    public final void a(C0174cg c0174cg) {
        ICommonExecutor iCommonExecutor = this.d;
        Ak ak = this.b;
        iCommonExecutor.submit(new Se(ak.b, ak.c, c0174cg));
    }

    public final void b(C0174cg c0174cg) {
        ICommonExecutor iCommonExecutor = this.d;
        Ak ak = this.b;
        iCommonExecutor.submit(new Yi(ak.b, ak.c, c0174cg));
    }
}
