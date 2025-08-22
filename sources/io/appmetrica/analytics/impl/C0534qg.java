package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.executors.InterruptionSafeThread;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
/* renamed from: io.appmetrica.analytics.impl.qg  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0534qg implements InterfaceC0484og {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0683wg f1028a;

    public C0534qg(C0683wg c0683wg) {
        this.f1028a = c0683wg;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0484og
    public final void a() {
        C0683wg c0683wg = this.f1028a;
        Wa wa = c0683wg.b;
        C0509pg c0509pg = new C0509pg(c0683wg);
        wa.getClass();
        try {
            FutureTask futureTask = new FutureTask(new Va(wa));
            Ka.F.d.f1126a.getClass();
            new InterruptionSafeThread(futureTask, "IAA-SHMSR-" + Qd.f620a.incrementAndGet()).start();
            Fg fg = (Fg) futureTask.get(5L, TimeUnit.SECONDS);
            no.a(wa.b);
            C0683wg.a(c0683wg, fg, C0683wg.a(c0683wg));
        } catch (Throwable th) {
            try {
                c0509pg.a(th);
            } finally {
                no.a(wa.b);
            }
        }
    }
}
