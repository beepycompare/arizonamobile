package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.xi  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0719xi implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Ai f1282a;

    public RunnableC0719xi(Ai ai) {
        this.f1282a = ai;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Ai ai = this.f1282a;
        Ai.a(ai.f463a, ai.d, ai.e).clearAppEnvironment();
    }
}
