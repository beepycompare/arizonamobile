package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.executors.InterruptionSafeThread;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public final class Yf implements Wf {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0225eg f868a;

    public Yf(C0225eg c0225eg) {
        this.f868a = c0225eg;
    }

    @Override // io.appmetrica.analytics.impl.Wf
    public final void a() {
        C0225eg c0225eg = this.f868a;
        C0748za c0748za = c0225eg.b;
        Xf xf = new Xf(c0225eg);
        c0748za.getClass();
        try {
            FutureTask futureTask = new FutureTask(new CallableC0723ya(c0748za));
            C0449na.I.d.f1084a.getClass();
            new InterruptionSafeThread(futureTask, "IAA-SHMSR-" + ThreadFactoryC0751zd.f1332a.incrementAndGet()).start();
            C0455ng c0455ng = (C0455ng) futureTask.get(5L, TimeUnit.SECONDS);
            lo.a(c0748za.b);
            C0225eg.a(c0225eg, c0455ng, C0225eg.a(c0225eg));
        } catch (Throwable th) {
            try {
                xf.a(th);
            } finally {
                lo.a(c0748za.b);
            }
        }
    }
}
