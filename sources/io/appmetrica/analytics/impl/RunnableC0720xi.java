package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.xi  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0720xi implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Ai f1279a;

    public RunnableC0720xi(Ai ai) {
        this.f1279a = ai;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Ai ai = this.f1279a;
        Ai.a(ai.f460a, ai.d, ai.e).clearAppEnvironment();
    }
}
