package io.appmetrica.analytics.impl;

import java.util.concurrent.TimeUnit;
/* renamed from: io.appmetrica.analytics.impl.v0  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0635v0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0660w0 f1160a;

    public RunnableC0635v0(C0660w0 c0660w0) {
        this.f1160a = c0660w0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0338j4.l().c.a().executeDelayed(new RunnableC0611u1(this.f1160a.f1177a), TimeUnit.SECONDS.toMillis(5L));
    }
}
