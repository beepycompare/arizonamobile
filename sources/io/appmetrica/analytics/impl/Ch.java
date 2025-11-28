package io.appmetrica.analytics.impl;

import android.content.Intent;
import android.os.RemoteException;
import io.appmetrica.analytics.internal.IAppMetricaService;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
/* loaded from: classes5.dex */
public abstract class Ch implements Callable {
    public static final Bh d = new Bh();

    /* renamed from: a  reason: collision with root package name */
    public final C0486p0 f427a;
    public final InterfaceC0201dl b;
    public boolean c;

    public Ch(C0486p0 c0486p0, InterfaceC0201dl interfaceC0201dl) {
        this.f427a = c0486p0;
        this.b = interfaceC0201dl;
    }

    public abstract void a(IAppMetricaService iAppMetricaService);

    public void a(Throwable th) {
    }

    public final C0486p0 b() {
        return this.f427a;
    }

    public boolean c() {
        C0486p0 c0486p0 = this.f427a;
        synchronized (c0486p0) {
            if (c0486p0.d == null) {
                c0486p0.e = new CountDownLatch(1);
                Intent a2 = Ek.a(c0486p0.f1047a);
                try {
                    c0486p0.g.b(c0486p0.f1047a);
                    c0486p0.f1047a.bindService(a2, c0486p0.i, 1);
                } catch (Throwable unused) {
                }
            }
        }
        this.f427a.a(5000L);
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
                C0486p0 c0486p0 = this.f427a;
                synchronized (c0486p0) {
                    iAppMetricaService = c0486p0.d;
                }
                if (iAppMetricaService != null) {
                    try {
                        a(iAppMetricaService);
                        InterfaceC0201dl interfaceC0201dl = this.b;
                        if (interfaceC0201dl == null || ((C0454ni) interfaceC0201dl).a()) {
                            this.f427a.c();
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
                AtomicBoolean atomicBoolean = X1.e;
                if (X1.e.get()) {
                    return;
                }
            } while (i < 3);
        } catch (Throwable th) {
            a(th);
        }
    }
}
