package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.executors.InterruptionSafeThread;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
/* renamed from: io.appmetrica.analytics.impl.jg  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0359jg implements InterfaceC0310hg {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0509pg f893a;

    public C0359jg(C0509pg c0509pg) {
        this.f893a = c0509pg;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0310hg
    public final void a() {
        C0509pg c0509pg = this.f893a;
        Sa sa = c0509pg.b;
        C0334ig c0334ig = new C0334ig(c0509pg);
        sa.getClass();
        try {
            FutureTask futureTask = new FutureTask(new Ra(sa));
            Ga.F.d.f978a.getClass();
            new InterruptionSafeThread(futureTask, "IAA-SHMSR-" + Md.f536a.incrementAndGet()).start();
            C0733yg c0733yg = (C0733yg) futureTask.get(5L, TimeUnit.SECONDS);
            fo.a(sa.b);
            C0509pg.a(c0509pg, c0733yg, C0509pg.a(c0509pg));
        } catch (Throwable th) {
            try {
                c0334ig.a(th);
            } finally {
                fo.a(sa.b);
            }
        }
    }
}
