package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.bi  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0150bi implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0279gi f924a;

    public RunnableC0150bi(C0279gi c0279gi) {
        this.f924a = c0279gi;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0279gi c0279gi = this.f924a;
        C0279gi.a(c0279gi.f1016a, c0279gi.d, c0279gi.e).sendEventsBuffer();
    }
}
