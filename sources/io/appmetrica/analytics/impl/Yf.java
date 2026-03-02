package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.executors.InterruptionSafeThread;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public final class Yf implements Wf {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0224eg f868a;

    public Yf(C0224eg c0224eg) {
        this.f868a = c0224eg;
    }

    @Override // io.appmetrica.analytics.impl.Wf
    public final void a() {
        C0224eg c0224eg = this.f868a;
        C0747za c0747za = c0224eg.b;
        Xf xf = new Xf(c0224eg);
        c0747za.getClass();
        try {
            FutureTask futureTask = new FutureTask(new CallableC0722ya(c0747za));
            C0448na.I.d.f1084a.getClass();
            new InterruptionSafeThread(futureTask, "IAA-SHMSR-" + ThreadFactoryC0750zd.f1332a.incrementAndGet()).start();
            C0454ng c0454ng = (C0454ng) futureTask.get(5L, TimeUnit.SECONDS);
            lo.a(c0747za.b);
            C0224eg.a(c0224eg, c0454ng, C0224eg.a(c0224eg));
        } catch (Throwable th) {
            try {
                xf.a(th);
            } finally {
                lo.a(c0747za.b);
            }
        }
    }
}
