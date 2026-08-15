package io.appmetrica.analytics.impl;

import java.util.concurrent.TimeUnit;
/* renamed from: io.appmetrica.analytics.impl.z0  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0753z0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ A0 f1306a;

    public RunnableC0753z0(A0 a0) {
        this.f1306a = a0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0575s4.l().c.a().executeDelayed(new RunnableC0702x1(this.f1306a.f449a), TimeUnit.SECONDS.toMillis(5L));
    }
}
