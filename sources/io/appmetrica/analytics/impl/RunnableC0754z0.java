package io.appmetrica.analytics.impl;

import java.util.concurrent.TimeUnit;
/* renamed from: io.appmetrica.analytics.impl.z0  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0754z0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ A0 f1303a;

    public RunnableC0754z0(A0 a0) {
        this.f1303a = a0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0576s4.l().c.a().executeDelayed(new RunnableC0703x1(this.f1303a.f446a), TimeUnit.SECONDS.toMillis(5L));
    }
}
