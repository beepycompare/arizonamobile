package io.appmetrica.analytics.impl;

import android.content.Intent;
import android.os.RemoteException;
import io.appmetrica.analytics.internal.IAppMetricaService;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
/* renamed from: io.appmetrica.analytics.impl.xh  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public abstract class AbstractCallableC0704xh implements Callable {
    public static final C0679wh d = new C0679wh();

    /* renamed from: a  reason: collision with root package name */
    public final C0488p0 f1308a;
    public final Zk b;
    public boolean c;

    public AbstractCallableC0704xh(C0488p0 c0488p0, Zk zk) {
        this.f1308a = c0488p0;
        this.b = zk;
    }

    public abstract void a(IAppMetricaService iAppMetricaService);

    public void a(Throwable th) {
    }

    public final C0488p0 b() {
        return this.f1308a;
    }

    public boolean c() {
        C0488p0 c0488p0 = this.f1308a;
        synchronized (c0488p0) {
            if (c0488p0.d == null) {
                c0488p0.e = new CountDownLatch(1);
                Intent a2 = c0488p0.h.a(c0488p0.f1164a);
                try {
                    c0488p0.g.b(c0488p0.f1164a);
                    c0488p0.f1164a.bindService(a2, c0488p0.j, 1);
                } catch (Throwable unused) {
                }
            }
        }
        this.f1308a.a(5000L);
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
                C0488p0 c0488p0 = this.f1308a;
                synchronized (c0488p0) {
                    iAppMetricaService = c0488p0.d;
                }
                if (iAppMetricaService != null) {
                    try {
                        a(iAppMetricaService);
                        Zk zk = this.b;
                        if (zk == null || ((C0329ii) zk).a()) {
                            this.f1308a.c();
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
                AtomicBoolean atomicBoolean = O1.e;
                if (O1.e.get()) {
                    return;
                }
            } while (i < 3);
        } catch (Throwable th) {
            a(th);
        }
    }
}
