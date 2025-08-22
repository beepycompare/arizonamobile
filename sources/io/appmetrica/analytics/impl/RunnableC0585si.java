package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.si  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0585si implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ U f1063a;
    public final /* synthetic */ C0735yi b;

    public RunnableC0585si(C0735yi c0735yi, U u) {
        this.b = c0735yi;
        this.f1063a = u;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0735yi c0735yi = this.b;
        C0735yi.a(c0735yi.f1162a, c0735yi.d, c0735yi.e).a(this.f1063a);
    }
}
