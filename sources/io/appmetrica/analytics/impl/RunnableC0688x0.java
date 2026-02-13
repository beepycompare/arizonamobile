package io.appmetrica.analytics.impl;

import java.util.concurrent.TimeUnit;
/* renamed from: io.appmetrica.analytics.impl.x0  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0688x0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0713y0 f1295a;

    public RunnableC0688x0(C0713y0 c0713y0) {
        this.f1295a = c0713y0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0136b4.l().c.a().executeDelayed(new RunnableC0639v1(this.f1295a.f1314a), TimeUnit.SECONDS.toMillis(5L));
    }
}
