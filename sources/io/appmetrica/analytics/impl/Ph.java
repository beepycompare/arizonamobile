package io.appmetrica.analytics.impl;

import android.content.Intent;
import android.os.RemoteException;
import io.appmetrica.analytics.internal.IAppMetricaService;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
/* loaded from: classes4.dex */
public abstract class Ph implements Callable {
    public static final Oh d = new Oh();

    /* renamed from: a  reason: collision with root package name */
    public final C0418m0 f607a;
    public final InterfaceC0233el b;
    public boolean c;

    public Ph(C0418m0 c0418m0, InterfaceC0233el interfaceC0233el) {
        this.f607a = c0418m0;
        this.b = interfaceC0233el;
    }

    public abstract void a(IAppMetricaService iAppMetricaService);

    public void a(Throwable th) {
    }

    public final C0418m0 b() {
        return this.f607a;
    }

    public boolean c() {
        C0418m0 c0418m0 = this.f607a;
        synchronized (c0418m0) {
            if (c0418m0.d == null) {
                c0418m0.e = new CountDownLatch(1);
                Intent a2 = Fk.a(c0418m0.f960a);
                try {
                    c0418m0.g.b(c0418m0.f960a);
                    c0418m0.f960a.bindService(a2, c0418m0.i, 1);
                } catch (Throwable unused) {
                }
            }
        }
        this.f607a.a(5000L);
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
                C0418m0 c0418m0 = this.f607a;
                synchronized (c0418m0) {
                    iAppMetricaService = c0418m0.d;
                }
                if (iAppMetricaService != null) {
                    try {
                        a(iAppMetricaService);
                        InterfaceC0233el interfaceC0233el = this.b;
                        if (interfaceC0233el == null || ((Ai) interfaceC0233el).a()) {
                            this.f607a.c();
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
