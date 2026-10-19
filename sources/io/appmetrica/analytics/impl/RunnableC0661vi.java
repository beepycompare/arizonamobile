package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.vi  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0661vi implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Ai f1255a;

    public RunnableC0661vi(Ai ai) {
        this.f1255a = ai;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Ai ai = this.f1255a;
        Ai.a(ai.f466a, ai.d, ai.e).sendEventsBuffer();
    }
}
