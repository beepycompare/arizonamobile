package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.di  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0203di implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Throwable f945a;
    public final /* synthetic */ Ai b;

    public RunnableC0203di(Ai ai, Throwable th) {
        this.b = ai;
        this.f945a = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Ai ai = this.b;
        Ai.a(ai.f461a, ai.d, ai.e).reportUnhandledException(this.f945a);
    }
}
