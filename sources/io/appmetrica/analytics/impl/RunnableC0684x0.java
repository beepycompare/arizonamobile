package io.appmetrica.analytics.impl;

import java.util.concurrent.TimeUnit;
/* renamed from: io.appmetrica.analytics.impl.x0  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0684x0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0709y0 f1273a;

    public RunnableC0684x0(C0709y0 c0709y0) {
        this.f1273a = c0709y0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0157c4.l().c.a().executeDelayed(new RunnableC0660w1(this.f1273a.f1291a), TimeUnit.SECONDS.toMillis(5L));
    }
}
