package io.appmetrica.analytics.impl;

import android.content.Intent;
import android.os.RemoteException;
import io.appmetrica.analytics.internal.IAppMetricaService;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
/* loaded from: classes4.dex */
public abstract class Ih implements Callable {
    public static final Hh d = new Hh();

    /* renamed from: a  reason: collision with root package name */
    public final C0426m0 f477a;
    public final Wk b;
    public boolean c;

    public Ih(C0426m0 c0426m0, Wk wk) {
        this.f477a = c0426m0;
        this.b = wk;
    }

    public abstract void a(IAppMetricaService iAppMetricaService);

    public void a(Throwable th) {
    }

    public final C0426m0 b() {
        return this.f477a;
    }

    public boolean c() {
        C0426m0 c0426m0 = this.f477a;
        synchronized (c0426m0) {
            if (c0426m0.d == null) {
                c0426m0.e = new CountDownLatch(1);
                Intent a2 = AbstractC0720xk.a(c0426m0.f929a);
                try {
                    c0426m0.g.b(c0426m0.f929a);
                    c0426m0.f929a.bindService(a2, c0426m0.i, 1);
                } catch (Throwable unused) {
                }
            }
        }
        this.f477a.a(5000L);
        return true;
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        a();
        return Unit.INSTANCE;
    }

    public final boolean d() {
        return this.c;
    }

    public final void a(boolean z) {
        this.c = z;
    }

    public void a() {
        IAppMetricaService iAppMetricaService;
        try {
            if (this.c) {
                return;
            }
            this.c = true;
            int i = 0;
            do {
                C0426m0 c0426m0 = this.f477a;
                synchronized (c0426m0) {
                    iAppMetricaService = c0426m0.d;
                }
                if (iAppMetricaService != null) {
                    try {
                        a(iAppMetricaService);
                        Wk wk = this.b;
                        if (wk == null || ((C0618ti) wk).a()) {
                            this.f477a.c();
                            return;
                        }
                        return;
                    } catch (RemoteException unused) {
                    }
                }
                i++;
                if (!c()) {
                    return;
                }
                AtomicBoolean atomicBoolean = U1.e;
                if (U1.e.get()) {
                    return;
                }
            } while (i < 3);
        } catch (Throwable th) {
            a(th);
        }
    }
}
