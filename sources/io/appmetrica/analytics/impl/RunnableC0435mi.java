package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.mi  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0435mi implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ boolean f1097a;
    public final /* synthetic */ Ai b;

    public RunnableC0435mi(Ai ai, boolean z) {
        this.b = ai;
        this.f1097a = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Ai ai = this.b;
        Ai.a(ai.f460a, ai.d, ai.e).setDataSendingEnabled(this.f1097a);
    }
}
