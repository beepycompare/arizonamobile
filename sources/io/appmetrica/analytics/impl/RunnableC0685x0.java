package io.appmetrica.analytics.impl;

import java.util.concurrent.TimeUnit;
/* renamed from: io.appmetrica.analytics.impl.x0  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0685x0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0710y0 f1190a;

    public RunnableC0685x0(C0710y0 c0710y0) {
        this.f1190a = c0710y0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0158c4.l().c.a().executeDelayed(new RunnableC0661w1(this.f1190a.f1208a), TimeUnit.SECONDS.toMillis(5L));
    }
}
