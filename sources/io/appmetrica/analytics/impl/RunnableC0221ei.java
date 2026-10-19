package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.ei  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0221ei implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Ai f970a;

    public RunnableC0221ei(Ai ai) {
        this.f970a = ai;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Ai ai = this.f970a;
        Ai.a(ai.f466a, ai.d, ai.e).resumeSession();
    }
}
