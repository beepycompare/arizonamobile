package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.fi  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0254fi implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Ai f981a;

    public RunnableC0254fi(Ai ai) {
        this.f981a = ai;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Ai ai = this.f981a;
        Ai.a(ai.f461a, ai.d, ai.e).pauseSession();
    }
}
