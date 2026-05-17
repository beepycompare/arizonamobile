package io.appmetrica.analytics.impl;

import java.util.concurrent.TimeUnit;
/* renamed from: io.appmetrica.analytics.impl.x0  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0687x0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0712y0 f1300a;

    public RunnableC0687x0(C0712y0 c0712y0) {
        this.f1300a = c0712y0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0135b4.l().c.a().executeDelayed(new RunnableC0638v1(this.f1300a.f1319a), TimeUnit.SECONDS.toMillis(5L));
    }
}
