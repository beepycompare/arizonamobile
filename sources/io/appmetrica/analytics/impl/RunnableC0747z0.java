package io.appmetrica.analytics.impl;

import java.util.concurrent.TimeUnit;
/* renamed from: io.appmetrica.analytics.impl.z0  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0747z0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ A0 f1309a;

    public RunnableC0747z0(A0 a0) {
        this.f1309a = a0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0569s4.l().c.a().executeDelayed(new RunnableC0696x1(this.f1309a.f452a), TimeUnit.SECONDS.toMillis(5L));
    }
}
