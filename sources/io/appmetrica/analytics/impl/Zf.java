package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.executors.InterruptionSafeThread;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public final class Zf implements Xf {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0246fg f878a;

    public Zf(C0246fg c0246fg) {
        this.f878a = c0246fg;
    }

    @Override // io.appmetrica.analytics.impl.Xf
    public final void a() {
        C0246fg c0246fg = this.f878a;
        Aa aa = c0246fg.b;
        Yf yf = new Yf(c0246fg);
        aa.getClass();
        try {
            FutureTask futureTask = new FutureTask(new CallableC0744za(aa));
            C0470oa.I.d.f1094a.getClass();
            new InterruptionSafeThread(futureTask, "IAA-SHMSR-" + Ad.f493a.incrementAndGet()).start();
            C0476og c0476og = (C0476og) futureTask.get(5L, TimeUnit.SECONDS);
            mo.a(aa.b);
            C0246fg.a(c0246fg, c0476og, C0246fg.a(c0246fg));
        } catch (Throwable th) {
            try {
                yf.a(th);
            } finally {
                mo.a(aa.b);
            }
        }
    }
}
