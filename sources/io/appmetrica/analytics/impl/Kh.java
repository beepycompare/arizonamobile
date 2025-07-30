package io.appmetrica.analytics.impl;

import android.content.Intent;
import android.os.RemoteException;
import io.appmetrica.analytics.internal.IAppMetricaService;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
/* loaded from: classes4.dex */
public abstract class Kh implements Callable {
    public static final Jh d = new Jh();

    /* renamed from: a  reason: collision with root package name */
    public final C0420m0 f524a;
    public final Zk b;
    public boolean c;

    public Kh(C0420m0 c0420m0, Zk zk) {
        this.f524a = c0420m0;
        this.b = zk;
    }

    public abstract void a(IAppMetricaService iAppMetricaService);

    public void a(Throwable th) {
    }

    public final C0420m0 b() {
        return this.f524a;
    }

    public boolean c() {
        C0420m0 c0420m0 = this.f524a;
        synchronized (c0420m0) {
            if (c0420m0.d == null) {
                c0420m0.e = new CountDownLatch(1);
                Intent a2 = Ak.a(c0420m0.f946a);
                try {
                    c0420m0.g.b(c0420m0.f946a);
                    c0420m0.f946a.bindService(a2, c0420m0.i, 1);
                } catch (Throwable unused) {
                }
            }
        }
        this.f524a.a(5000L);
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
                C0420m0 c0420m0 = this.f524a;
                synchronized (c0420m0) {
                    iAppMetricaService = c0420m0.d;
                }
                if (iAppMetricaService != null) {
                    try {
                        a(iAppMetricaService);
                        Zk zk = this.b;
                        if (zk == null || ((C0662vi) zk).a()) {
                            this.f524a.c();
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
