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
    public final C0539r0 f770a;
    public final Ak b;
    public final TimeProvider c;
    public final ICommonExecutor d;

    static {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        f = timeUnit.toMillis(1L);
        g = timeUnit.toMillis(4L);
    }

    public Si(C0539r0 c0539r0, Ak ak, TimeProvider timeProvider) {
        this.f770a = c0539r0;
        this.b = ak;
        this.c = timeProvider;
        this.d = C0569s4.l().g().c();
    }

    public final void a(Ph ph) {
        Rh c0246fh;
        ICommonExecutor iCommonExecutor = this.d;
        boolean z = ph.b;
        Ak ak = this.b;
        if (z) {
            c0246fh = new C0571s6(ak.f467a, ak.b, ak.c, ph, true);
        } else {
            c0246fh = new C0246fh(ak.b, ak.c, ph);
        }
        iCommonExecutor.submit(c0246fh);
    }

    public final void b(Ph ph) {
        long uptimeMillis = this.c.uptimeMillis();
        Ak ak = this.b;
        C0571s6 c0571s6 = new C0571s6(ak.f467a, ak.b, ak.c, ph, false);
        long j = Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) ? f : g;
        if (this.f770a.a()) {
            try {
                this.d.submit(c0571s6).get(j, TimeUnit.MILLISECONDS);
            } catch (Throwable unused) {
            }
        }
        if (c0571s6.c) {
            return;
        }
        try {
            c0571s6.a();
            Thread.sleep(Math.max(0L, j - (this.c.uptimeMillis() - uptimeMillis)));
        } catch (Throwable unused2) {
        }
    }

    @Override // io.appmetrica.analytics.impl.Fk
    public final void reportData(int i, Bundle bundle) {
        ICommonExecutor iCommonExecutor = this.d;
        Ak ak = this.b;
        iCommonExecutor.submit(new C0538qo(ak.b, ak.c, i, bundle));
    }

    public Si(C0539r0 c0539r0, Ak ak) {
        this(c0539r0, ak, new SystemTimeProvider());
    }

    public final void a(C0168cg c0168cg) {
        ICommonExecutor iCommonExecutor = this.d;
        Ak ak = this.b;
        iCommonExecutor.submit(new Se(ak.b, ak.c, c0168cg));
    }

    public final void b(C0168cg c0168cg) {
        ICommonExecutor iCommonExecutor = this.d;
        Ak ak = this.b;
        iCommonExecutor.submit(new Yi(ak.b, ak.c, c0168cg));
    }
}
