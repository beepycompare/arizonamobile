package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.executors.InterruptionSafeThread;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
/* renamed from: io.appmetrica.analytics.impl.lg  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0411lg implements InterfaceC0361jg {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0560rg f939a;

    public C0411lg(C0560rg c0560rg) {
        this.f939a = c0560rg;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0361jg
    public final void a() {
        C0560rg c0560rg = this.f939a;
        Ua ua = c0560rg.b;
        C0386kg c0386kg = new C0386kg(c0560rg);
        ua.getClass();
        try {
            FutureTask futureTask = new FutureTask(new Ta(ua));
            Ia.F.d.f1040a.getClass();
            new InterruptionSafeThread(futureTask, "IAA-SHMSR-" + Od.f578a.incrementAndGet()).start();
            Ag ag = (Ag) futureTask.get(5L, TimeUnit.SECONDS);
            io.a(ua.b);
            C0560rg.a(c0560rg, ag, C0560rg.a(c0560rg));
        } catch (Throwable th) {
            try {
                c0386kg.a(th);
            } finally {
                io.a(ua.b);
            }
        }
    }
}
