package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.gi  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0275gi implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0404li f898a;

    public RunnableC0275gi(C0404li c0404li) {
        this.f898a = c0404li;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0404li c0404li = this.f898a;
        C0404li.a(c0404li.f993a, c0404li.d, c0404li.e).sendEventsBuffer();
    }
}
