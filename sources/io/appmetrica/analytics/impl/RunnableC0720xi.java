package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.xi  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0720xi implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Ai f1280a;

    public RunnableC0720xi(Ai ai) {
        this.f1280a = ai;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Ai ai = this.f1280a;
        Ai.a(ai.f461a, ai.d, ai.e).clearAppEnvironment();
    }
}
