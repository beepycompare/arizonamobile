package io.appmetrica.analytics.impl;

import android.content.Intent;
import android.os.RemoteException;
import io.appmetrica.analytics.internal.IAppMetricaService;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
/* renamed from: io.appmetrica.analytics.impl.yh  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractCallableC0727yh implements Callable {
    public static final C0702xh d = new C0702xh();

    /* renamed from: a  reason: collision with root package name */
    public final C0486p0 f1221a;
    public final InterfaceC0123al b;
    public boolean c;

    public AbstractCallableC0727yh(C0486p0 c0486p0, InterfaceC0123al interfaceC0123al) {
        this.f1221a = c0486p0;
        this.b = interfaceC0123al;
    }

    public abstract void a(IAppMetricaService iAppMetricaService);

    public void a(Throwable th) {
    }

    public final C0486p0 b() {
        return this.f1221a;
    }

    public boolean c() {
        C0486p0 c0486p0 = this.f1221a;
        synchronized (c0486p0) {
            if (c0486p0.d == null) {
                c0486p0.e = new CountDownLatch(1);
                Intent a2 = c0486p0.h.a(c0486p0.f1057a);
                try {
                    c0486p0.g.b(c0486p0.f1057a);
                    c0486p0.f1057a.bindService(a2, c0486p0.j, 1);
                } catch (Throwable unused) {
                }
            }
        }
        this.f1221a.a(5000L);
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
                C0486p0 c0486p0 = this.f1221a;
                synchronized (c0486p0) {
                    iAppMetricaService = c0486p0.d;
                }
                if (iAppMetricaService != null) {
                    try {
                        a(iAppMetricaService);
                        InterfaceC0123al interfaceC0123al = this.b;
                        if (interfaceC0123al == null || ((C0352ji) interfaceC0123al).a()) {
                            this.f1221a.c();
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
                AtomicBoolean atomicBoolean = P1.e;
                if (P1.e.get()) {
                    return;
                }
            } while (i < 3);
        } catch (Throwable th) {
            a(th);
        }
    }
}
