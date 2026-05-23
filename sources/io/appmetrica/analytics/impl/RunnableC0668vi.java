package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.vi  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0668vi implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Ai f1249a;

    public RunnableC0668vi(Ai ai) {
        this.f1249a = ai;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Ai ai = this.f1249a;
        Ai.a(ai.f460a, ai.d, ai.e).sendEventsBuffer();
    }
}
