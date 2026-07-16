package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.fi  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0254fi implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Ai f983a;

    public RunnableC0254fi(Ai ai) {
        this.f983a = ai;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Ai ai = this.f983a;
        Ai.a(ai.f463a, ai.d, ai.e).pauseSession();
    }
}
