package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.executors.InterruptionSafeThread;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
/* renamed from: io.appmetrica.analytics.impl.jg  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0367jg implements InterfaceC0318hg {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0517pg f892a;

    public C0367jg(C0517pg c0517pg) {
        this.f892a = c0517pg;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0318hg
    public final void a() {
        C0517pg c0517pg = this.f892a;
        Sa sa = c0517pg.b;
        C0342ig c0342ig = new C0342ig(c0517pg);
        sa.getClass();
        try {
            FutureTask futureTask = new FutureTask(new Ra(sa));
            Ga.F.d.f977a.getClass();
            new InterruptionSafeThread(futureTask, "IAA-SHMSR-" + Md.f535a.incrementAndGet()).start();
            C0741yg c0741yg = (C0741yg) futureTask.get(5L, TimeUnit.SECONDS);
            fo.a(sa.b);
            C0517pg.a(c0517pg, c0741yg, C0517pg.a(c0517pg));
        } catch (Throwable th) {
            try {
                c0342ig.a(th);
            } finally {
                fo.a(sa.b);
            }
        }
    }
}
