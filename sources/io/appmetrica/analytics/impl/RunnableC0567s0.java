package io.appmetrica.analytics.impl;

import java.util.concurrent.TimeUnit;
/* renamed from: io.appmetrica.analytics.impl.s0  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0567s0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0592t0 f1035a;

    public RunnableC0567s0(C0592t0 c0592t0) {
        this.f1035a = c0592t0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0696x4.l().c.a().executeDelayed(new RunnableC0543r1(this.f1035a.f1053a), TimeUnit.SECONDS.toMillis(5L));
    }
}
