package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.bi  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0149bi implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0278gi f923a;

    public RunnableC0149bi(C0278gi c0278gi) {
        this.f923a = c0278gi;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0278gi c0278gi = this.f923a;
        C0278gi.a(c0278gi.f1015a, c0278gi.d, c0278gi.e).sendEventsBuffer();
    }
}
