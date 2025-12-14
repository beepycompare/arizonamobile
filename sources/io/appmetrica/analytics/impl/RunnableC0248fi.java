package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.fi  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0248fi implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f989a;
    public final /* synthetic */ C0300hi b;

    public RunnableC0248fi(C0300hi c0300hi, String str) {
        this.b = c0300hi;
        this.f989a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0300hi c0300hi = this.b;
        C0300hi.a(c0300hi.f1023a, c0300hi.d, c0300hi.e).reportEvent(this.f989a);
    }
}
