package io.appmetrica.analytics.impl;

import java.util.concurrent.TimeUnit;
/* renamed from: io.appmetrica.analytics.impl.s0  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0570s0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0595t0 f1045a;

    public RunnableC0570s0(C0595t0 c0595t0) {
        this.f1045a = c0595t0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0699x4.l().c.a().executeDelayed(new RunnableC0546r1(this.f1045a.f1059a), TimeUnit.SECONDS.toMillis(5L));
    }
}
