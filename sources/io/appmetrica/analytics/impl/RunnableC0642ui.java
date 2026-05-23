package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.ui  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0642ui implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ X f1233a;
    public final /* synthetic */ Ai b;

    public RunnableC0642ui(Ai ai, X x) {
        this.b = ai;
        this.f1233a = x;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Ai ai = this.b;
        Ai.a(ai.f460a, ai.d, ai.e).a(this.f1233a);
    }
}
