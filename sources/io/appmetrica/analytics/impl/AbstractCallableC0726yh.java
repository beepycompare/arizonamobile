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
public abstract class AbstractCallableC0726yh implements Callable {
    public static final C0701xh d = new C0701xh();

    /* renamed from: a  reason: collision with root package name */
    public final C0485p0 f1318a;
    public final InterfaceC0122al b;
    public boolean c;

    public AbstractCallableC0726yh(C0485p0 c0485p0, InterfaceC0122al interfaceC0122al) {
        this.f1318a = c0485p0;
        this.b = interfaceC0122al;
    }

    public abstract void a(IAppMetricaService iAppMetricaService);

    public void a(Throwable th) {
    }

    public final C0485p0 b() {
        return this.f1318a;
    }

    public boolean c() {
        C0485p0 c0485p0 = this.f1318a;
        synchronized (c0485p0) {
            if (c0485p0.d == null) {
                c0485p0.e = new CountDownLatch(1);
                Intent a2 = c0485p0.h.a(c0485p0.f1154a);
                try {
                    c0485p0.g.b(c0485p0.f1154a);
                    c0485p0.f1154a.bindService(a2, c0485p0.j, 1);
                } catch (Throwable unused) {
                }
            }
        }
        this.f1318a.a(5000L);
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
                C0485p0 c0485p0 = this.f1318a;
                synchronized (c0485p0) {
                    iAppMetricaService = c0485p0.d;
                }
                if (iAppMetricaService != null) {
                    try {
                        a(iAppMetricaService);
                        InterfaceC0122al interfaceC0122al = this.b;
                        if (interfaceC0122al == null || ((C0351ji) interfaceC0122al).a()) {
                            this.f1318a.c();
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
