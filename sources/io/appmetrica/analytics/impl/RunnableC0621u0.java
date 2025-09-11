package io.appmetrica.analytics.impl;

import java.util.concurrent.TimeUnit;
/* renamed from: io.appmetrica.analytics.impl.u0  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0621u0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0646v0 f1101a;

    public RunnableC0621u0(C0646v0 c0646v0) {
        this.f1101a = c0646v0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        A4.l().c.a().executeDelayed(new RunnableC0597t1(this.f1101a.f1117a), TimeUnit.SECONDS.toMillis(5L));
    }
}
