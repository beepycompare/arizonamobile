package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.ti  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0610ti implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0735yi f1075a;

    public RunnableC0610ti(C0735yi c0735yi) {
        this.f1075a = c0735yi;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0735yi c0735yi = this.f1075a;
        C0735yi.a(c0735yi.f1162a, c0735yi.d, c0735yi.e).sendEventsBuffer();
    }
}
