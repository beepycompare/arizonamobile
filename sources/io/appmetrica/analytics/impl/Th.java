package io.appmetrica.analytics.impl;

import android.content.Intent;
import android.os.RemoteException;
import io.appmetrica.analytics.internal.IAppMetricaService;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
/* loaded from: classes4.dex */
public abstract class Th implements Callable {
    public static final Sh d = new Sh();

    /* renamed from: a  reason: collision with root package name */
    public final C0471o0 f683a;
    public final InterfaceC0336il b;
    public boolean c;

    public Th(C0471o0 c0471o0, InterfaceC0336il interfaceC0336il) {
        this.f683a = c0471o0;
        this.b = interfaceC0336il;
    }

    public abstract void a(IAppMetricaService iAppMetricaService);

    public void a(Throwable th) {
    }

    public final C0471o0 b() {
        return this.f683a;
    }

    public boolean c() {
        C0471o0 c0471o0 = this.f683a;
        synchronized (c0471o0) {
            if (c0471o0.d == null) {
                c0471o0.e = new CountDownLatch(1);
                Intent a2 = Jk.a(c0471o0.f1008a);
                try {
                    c0471o0.g.b(c0471o0.f1008a);
                    c0471o0.f1008a.bindService(a2, c0471o0.i, 1);
                } catch (Throwable unused) {
                }
            }
        }
        this.f683a.a(5000L);
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
                C0471o0 c0471o0 = this.f683a;
                synchronized (c0471o0) {
                    iAppMetricaService = c0471o0.d;
                }
                if (iAppMetricaService != null) {
                    try {
                        a(iAppMetricaService);
                        InterfaceC0336il interfaceC0336il = this.b;
                        if (interfaceC0336il == null || ((Ei) interfaceC0336il).a()) {
                            this.f683a.c();
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
                AtomicBoolean atomicBoolean = W1.e;
                if (W1.e.get()) {
                    return;
                }
            } while (i < 3);
        } catch (Throwable th) {
            a(th);
        }
    }
}
