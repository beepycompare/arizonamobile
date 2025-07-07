package io.appmetrica.analytics.impl;

import java.util.concurrent.TimeUnit;
/* renamed from: io.appmetrica.analytics.impl.s0  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0575s0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0600t0 f1034a;

    public RunnableC0575s0(C0600t0 c0600t0) {
        this.f1034a = c0600t0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0704x4.l().c.a().executeDelayed(new RunnableC0551r1(this.f1034a.f1052a), TimeUnit.SECONDS.toMillis(5L));
    }
}
