package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.yi  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0745yi implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f1300a;
    public final /* synthetic */ Ai b;

    public RunnableC0745yi(Ai ai, String str) {
        this.b = ai;
        this.f1300a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Ai ai = this.b;
        Ai.a(ai.f463a, ai.d, ai.e).reportEvent(this.f1300a);
    }
}
