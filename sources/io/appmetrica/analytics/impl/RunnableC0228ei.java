package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.ei  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0228ei implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Ai f964a;

    public RunnableC0228ei(Ai ai) {
        this.f964a = ai;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Ai ai = this.f964a;
        Ai.a(ai.f460a, ai.d, ai.e).resumeSession();
    }
}
