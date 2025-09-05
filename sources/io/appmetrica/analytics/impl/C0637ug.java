package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.executors.InterruptionSafeThread;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
/* renamed from: io.appmetrica.analytics.impl.ug  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0637ug implements InterfaceC0587sg {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Ag f1108a;

    public C0637ug(Ag ag) {
        this.f1108a = ag;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0587sg
    public final void a() {
        Ag ag = this.f1108a;
        Za za = ag.b;
        C0612tg c0612tg = new C0612tg(ag);
        za.getClass();
        try {
            FutureTask futureTask = new FutureTask(new Ya(za));
            Na.F.d.f349a.getClass();
            new InterruptionSafeThread(futureTask, "IAA-SHMSR-" + Ud.f695a.incrementAndGet()).start();
            Jg jg = (Jg) futureTask.get(5L, TimeUnit.SECONDS);
            ro.a(za.b);
            Ag.a(ag, jg, Ag.a(ag));
        } catch (Throwable th) {
            try {
                c0612tg.a(th);
            } finally {
                ro.a(za.b);
            }
        }
    }
}
