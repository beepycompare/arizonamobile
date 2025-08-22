package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.bi  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0153bi implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Throwable f796a;
    public final /* synthetic */ C0735yi b;

    public RunnableC0153bi(C0735yi c0735yi, Throwable th) {
        this.b = c0735yi;
        this.f796a = th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0735yi c0735yi = this.b;
        C0735yi.a(c0735yi.f1162a, c0735yi.d, c0735yi.e).reportUnhandledException(this.f796a);
    }
}
