package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.executors.InterruptionSafeThread;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
/* renamed from: io.appmetrica.analytics.impl.lg  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0412lg implements InterfaceC0362jg {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0561rg f939a;

    public C0412lg(C0561rg c0561rg) {
        this.f939a = c0561rg;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0362jg
    public final void a() {
        C0561rg c0561rg = this.f939a;
        Ua ua = c0561rg.b;
        C0387kg c0387kg = new C0387kg(c0561rg);
        ua.getClass();
        try {
            FutureTask futureTask = new FutureTask(new Ta(ua));
            Ia.F.d.f1040a.getClass();
            new InterruptionSafeThread(futureTask, "IAA-SHMSR-" + Od.f578a.incrementAndGet()).start();
            Ag ag = (Ag) futureTask.get(5L, TimeUnit.SECONDS);
            io.a(ua.b);
            C0561rg.a(c0561rg, ag, C0561rg.a(c0561rg));
        } catch (Throwable th) {
            try {
                c0387kg.a(th);
            } finally {
                io.a(ua.b);
            }
        }
    }
}
