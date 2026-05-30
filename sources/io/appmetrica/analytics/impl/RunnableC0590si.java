package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.si  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0590si implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0622to f1200a;
    public final /* synthetic */ Ai b;

    public RunnableC0590si(Ai ai, C0622to c0622to) {
        this.b = ai;
        this.f1200a = c0622to;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Ai ai = this.b;
        Ai.a(ai.f461a, ai.d, ai.e).a(this.f1200a);
    }
}
