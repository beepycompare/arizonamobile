package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.bi  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0145bi implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ V f902a;
    public final /* synthetic */ C0300hi b;

    public RunnableC0145bi(C0300hi c0300hi, V v) {
        this.b = c0300hi;
        this.f902a = v;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0300hi c0300hi = this.b;
        C0300hi.a(c0300hi.f1009a, c0300hi.d, c0300hi.e).a(this.f902a);
    }
}
