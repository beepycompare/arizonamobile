package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.executors.InterruptionSafeThread;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public final class Zf implements Xf {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0247fg f780a;

    public Zf(C0247fg c0247fg) {
        this.f780a = c0247fg;
    }

    @Override // io.appmetrica.analytics.impl.Xf
    public final void a() {
        C0247fg c0247fg = this.f780a;
        Aa aa = c0247fg.b;
        Yf yf = new Yf(c0247fg);
        aa.getClass();
        try {
            FutureTask futureTask = new FutureTask(new CallableC0745za(aa));
            C0471oa.I.d.f996a.getClass();
            new InterruptionSafeThread(futureTask, "IAA-SHMSR-" + Ad.f395a.incrementAndGet()).start();
            C0477og c0477og = (C0477og) futureTask.get(5L, TimeUnit.SECONDS);
            mo.a(aa.b);
            C0247fg.a(c0247fg, c0477og, C0247fg.a(c0247fg));
        } catch (Throwable th) {
            try {
                yf.a(th);
            } finally {
                mo.a(aa.b);
            }
        }
    }
}
