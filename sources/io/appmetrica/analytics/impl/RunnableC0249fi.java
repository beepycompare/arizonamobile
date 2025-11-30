package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.fi  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0249fi implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f892a;
    public final /* synthetic */ C0301hi b;

    public RunnableC0249fi(C0301hi c0301hi, String str) {
        this.b = c0301hi;
        this.f892a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0301hi c0301hi = this.b;
        C0301hi.a(c0301hi.f926a, c0301hi.d, c0301hi.e).reportEvent(this.f892a);
    }
}
