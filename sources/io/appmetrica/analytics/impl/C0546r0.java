package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import io.appmetrica.analytics.internal.IAppMetricaService;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/* renamed from: io.appmetrica.analytics.impl.r0  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0546r0 {
    public static final long k = TimeUnit.SECONDS.toMillis(10);

    /* renamed from: a  reason: collision with root package name */
    public final Context f1175a;
    public final ICommonExecutor b;
    public boolean c;
    public IAppMetricaService d;
    public CountDownLatch e;
    public final Object f;
    public final S1 g;
    public final T1 h;
    public final RunnableC0495p0 i;
    public final ServiceConnectionC0521q0 j;

    public C0546r0(Context context, ICommonExecutor iCommonExecutor) {
        this(context, iCommonExecutor, C0576s4.l().e(), new T1());
    }

    public final synchronized boolean a() {
        return this.d != null;
    }

    public final void b() {
        synchronized (this.f) {
            this.b.remove(this.i);
        }
    }

    public final void c() {
        ICommonExecutor iCommonExecutor = this.b;
        synchronized (this.f) {
            iCommonExecutor.remove(this.i);
            if (!this.c) {
                iCommonExecutor.executeDelayed(this.i, k);
            }
        }
    }

    public final void a(Long l) {
        try {
            synchronized (this) {
                CountDownLatch countDownLatch = this.e;
                if (countDownLatch == null) {
                    return;
                }
                countDownLatch.await(l.longValue(), TimeUnit.MILLISECONDS);
            }
        } catch (InterruptedException unused) {
        }
    }

    public C0546r0(Context context, ICommonExecutor iCommonExecutor, S1 s1, T1 t1) {
        this.d = null;
        this.f = new Object();
        this.i = new RunnableC0495p0(this);
        this.j = new ServiceConnectionC0521q0(this);
        this.f1175a = context.getApplicationContext();
        this.b = iCommonExecutor;
        this.c = false;
        this.g = s1;
        this.h = t1;
    }
}
