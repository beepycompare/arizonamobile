package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.si  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0588si implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0620to f1202a;
    public final /* synthetic */ Ai b;

    public RunnableC0588si(Ai ai, C0620to c0620to) {
        this.b = ai;
        this.f1202a = c0620to;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Ai ai = this.b;
        Ai.a(ai.f463a, ai.d, ai.e).a(this.f1202a);
    }
}
