package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.qi  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0536qi implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Sn f1029a;
    public final /* synthetic */ C0735yi b;

    public RunnableC0536qi(C0735yi c0735yi, Sn sn) {
        this.b = c0735yi;
        this.f1029a = sn;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0735yi c0735yi = this.b;
        C0735yi.a(c0735yi.f1162a, c0735yi.d, c0735yi.e).a(this.f1029a);
    }
}
