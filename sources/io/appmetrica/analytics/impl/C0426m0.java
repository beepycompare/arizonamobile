package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreapi.internal.executors.ICommonExecutor;
import io.appmetrica.analytics.internal.IAppMetricaService;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/* renamed from: io.appmetrica.analytics.impl.m0  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0426m0 {
    public static final long j = TimeUnit.SECONDS.toMillis(10);

    /* renamed from: a  reason: collision with root package name */
    public final Context f929a;
    public final ICommonExecutor b;
    public CountDownLatch e;
    public final N1 g;
    public IAppMetricaService d = null;
    public final Object f = new Object();
    public final RunnableC0376k0 h = new RunnableC0376k0(this);
    public final ServiceConnectionC0401l0 i = new ServiceConnectionC0401l0(this);
    public boolean c = false;

    public C0426m0(Context context, ICommonExecutor iCommonExecutor, N1 n1) {
        this.f929a = context.getApplicationContext();
        this.b = iCommonExecutor;
        this.g = n1;
    }

    public final synchronized boolean a() {
        return this.d != null;
    }

    public final void b() {
        synchronized (this.f) {
            this.b.remove(this.h);
        }
    }

    public final void c() {
        ICommonExecutor iCommonExecutor = this.b;
        synchronized (this.f) {
            iCommonExecutor.remove(this.h);
            if (!this.c) {
                iCommonExecutor.executeDelayed(this.h, j);
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
}
