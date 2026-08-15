package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.vi  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0667vi implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Ai f1252a;

    public RunnableC0667vi(Ai ai) {
        this.f1252a = ai;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Ai ai = this.f1252a;
        Ai.a(ai.f463a, ai.d, ai.e).sendEventsBuffer();
    }
}
