package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.coreapi.internal.executors.InterruptionSafeThread;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
/* renamed from: io.appmetrica.analytics.impl.dg  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0196dg implements InterfaceC0144bg {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0350jg f847a;

    public C0196dg(C0350jg c0350jg) {
        this.f847a = c0350jg;
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0144bg
    public final void a() {
        C0350jg c0350jg = this.f847a;
        Ga ga = c0350jg.b;
        C0170cg c0170cg = new C0170cg(c0350jg);
        ga.getClass();
        try {
            FutureTask futureTask = new FutureTask(new Fa(ga));
            C0620ua.H.d.f1044a.getClass();
            new InterruptionSafeThread(futureTask, "IAA-SHMSR-" + Gd.f490a.incrementAndGet()).start();
            C0576sg c0576sg = (C0576sg) futureTask.get(5L, TimeUnit.SECONDS);
            no.a(ga.b);
            C0350jg.a(c0350jg, c0576sg, C0350jg.a(c0350jg));
        } catch (Throwable th) {
            try {
                c0170cg.a(th);
            } finally {
                no.a(ga.b);
            }
        }
    }
}
