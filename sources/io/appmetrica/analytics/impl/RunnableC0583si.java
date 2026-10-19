package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.si  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0583si implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0615to f1205a;
    public final /* synthetic */ Ai b;

    public RunnableC0583si(Ai ai, C0615to c0615to) {
        this.b = ai;
        this.f1205a = c0615to;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Ai ai = this.b;
        Ai.a(ai.f466a, ai.d, ai.e).a(this.f1205a);
    }
}
