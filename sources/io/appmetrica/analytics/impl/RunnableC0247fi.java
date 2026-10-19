package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.fi  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0247fi implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Ai f986a;

    public RunnableC0247fi(Ai ai) {
        this.f986a = ai;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Ai ai = this.f986a;
        Ai.a(ai.f466a, ai.d, ai.e).pauseSession();
    }
}
