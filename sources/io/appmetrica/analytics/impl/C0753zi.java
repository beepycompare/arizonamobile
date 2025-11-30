package io.appmetrica.analytics.impl;

import android.os.Bundle;
import android.os.Looper;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import io.appmetrica.analytics.coreutils.internal.time.SystemTimeProvider;
import io.appmetrica.analytics.coreutils.internal.time.TimeProvider;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
/* renamed from: io.appmetrica.analytics.impl.zi  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0753zi implements InterfaceC0225ek {
    public static final C0728yi e = new C0728yi();
    public static final long f;
    public static final long g;

    /* renamed from: a  reason: collision with root package name */
    public final C0486p0 f1233a;
    public final Zj b;
    public final TimeProvider c;
    public final ICommonExecutor d;

    static {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        f = timeUnit.toMillis(1L);
        g = timeUnit.toMillis(4L);
    }

    public C0753zi(C0486p0 c0486p0, Zj zj, TimeProvider timeProvider) {
        this.f1233a = c0486p0;
        this.b = zj;
        this.c = timeProvider;
        this.d = C0158c4.l().g().b();
    }

    public final void a(C0677wh c0677wh) {
        AbstractCallableC0727yh qg;
        ICommonExecutor iCommonExecutor = this.d;
        if (c0677wh.b) {
            Zj zj = this.b;
            qg = new C0186d6(zj.f783a, zj.b, zj.c, c0677wh);
        } else {
            Zj zj2 = this.b;
            qg = new Qg(zj2.b, zj2.c, c0677wh);
        }
        iCommonExecutor.submit(qg);
    }

    public final void b(C0677wh c0677wh) {
        long uptimeMillis = this.c.uptimeMillis();
        Zj zj = this.b;
        C0186d6 c0186d6 = new C0186d6(zj.f783a, zj.b, zj.c, c0677wh);
        long j = Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) ? f : g;
        if (this.f1233a.a()) {
            try {
                this.d.submit(c0186d6).get(j, TimeUnit.MILLISECONDS);
            } catch (Throwable unused) {
            }
        }
        if (c0186d6.c) {
            return;
        }
        try {
            c0186d6.a();
            Thread.sleep(Math.max(0L, j - (this.c.uptimeMillis() - uptimeMillis)));
        } catch (Throwable unused2) {
        }
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0225ek
    public final void reportData(int i, Bundle bundle) {
        ICommonExecutor iCommonExecutor = this.d;
        Zj zj = this.b;
        iCommonExecutor.submit(new On(zj.b, zj.c, i, bundle));
    }

    public C0753zi(C0486p0 c0486p0, Zj zj) {
        this(c0486p0, zj, new SystemTimeProvider());
    }

    public final void a(Cf cf) {
        ICommonExecutor iCommonExecutor = this.d;
        Zj zj = this.b;
        iCommonExecutor.submit(new C0574se(zj.b, zj.c, cf));
    }

    public final void b(Cf cf) {
        ICommonExecutor iCommonExecutor = this.d;
        Zj zj = this.b;
        iCommonExecutor.submit(new Fi(zj.b, zj.c, cf));
    }
}
