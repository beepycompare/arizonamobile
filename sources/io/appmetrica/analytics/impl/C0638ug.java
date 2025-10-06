package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.executors.InterruptionSafeThread;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
/* renamed from: io.appmetrica.analytics.impl.ug  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0638ug implements InterfaceC0588sg {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Ag f1113a;

    public C0638ug(Ag ag) {
        this.f1113a = ag;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0588sg
    public final void a() {
        Ag ag = this.f1113a;
        Za za = ag.b;
        C0613tg c0613tg = new C0613tg(ag);
        za.getClass();
        try {
            FutureTask futureTask = new FutureTask(new Ya(za));
            Na.F.d.f354a.getClass();
            new InterruptionSafeThread(futureTask, "IAA-SHMSR-" + Ud.f700a.incrementAndGet()).start();
            Jg jg = (Jg) futureTask.get(5L, TimeUnit.SECONDS);
            ro.a(za.b);
            Ag.a(ag, jg, Ag.a(ag));
        } catch (Throwable th) {
            try {
                c0613tg.a(th);
            } finally {
                ro.a(za.b);
            }
        }
    }
}
