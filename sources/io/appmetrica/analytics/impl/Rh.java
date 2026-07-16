package io.appmetrica.analytics.impl;

import android.content.Context;
import android.content.Intent;
import android.os.RemoteException;
import io.appmetrica.analytics.internal.IAppMetricaService;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
/* loaded from: classes5.dex */
public abstract class Rh implements Callable {
    public static final Qh d = new Qh();

    /* renamed from: a  reason: collision with root package name */
    public final C0546r0 f751a;
    public final El b;
    public boolean c;

    public Rh(C0546r0 c0546r0, El el) {
        this.f751a = c0546r0;
        this.b = el;
    }

    public abstract void a(IAppMetricaService iAppMetricaService);

    public void a(Throwable th) {
    }

    public final C0546r0 b() {
        return this.f751a;
    }

    public boolean c() {
        C0546r0 c0546r0 = this.f751a;
        synchronized (c0546r0) {
            if (c0546r0.d == null) {
                c0546r0.e = new CountDownLatch(1);
                T1 t1 = c0546r0.h;
                Context context = c0546r0.f1175a;
                t1.getClass();
                Intent a2 = T1.a(context);
                try {
                    c0546r0.g.b(c0546r0.f1175a);
                    c0546r0.f1175a.bindService(a2, c0546r0.j, 1);
                } catch (Throwable unused) {
                }
            }
        }
        this.f751a.a(5000L);
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
                C0546r0 c0546r0 = this.f751a;
                synchronized (c0546r0) {
                    iAppMetricaService = c0546r0.d;
                }
                if (iAppMetricaService != null) {
                    try {
                        a(iAppMetricaService);
                        El el = this.b;
                        if (el == null || ((Ci) el).a()) {
                            this.f751a.c();
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
                AtomicBoolean atomicBoolean = C0135b2.e;
                if (C0135b2.e.get()) {
                    return;
                }
            } while (i < 3);
        } catch (Throwable th) {
            a(th);
        }
    }
}
