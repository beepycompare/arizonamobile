package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.si  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0589si implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0621to f1202a;
    public final /* synthetic */ Ai b;

    public RunnableC0589si(Ai ai, C0621to c0621to) {
        this.b = ai;
        this.f1202a = c0621to;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Ai ai = this.b;
        Ai.a(ai.f463a, ai.d, ai.e).a(this.f1202a);
    }
}
