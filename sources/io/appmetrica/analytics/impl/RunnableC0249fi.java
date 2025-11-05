package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.fi  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class RunnableC0249fi implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ V f879a;
    public final /* synthetic */ C0404li b;

    public RunnableC0249fi(C0404li c0404li, V v) {
        this.b = c0404li;
        this.f879a = v;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0404li c0404li = this.b;
        C0404li.a(c0404li.f993a, c0404li.d, c0404li.e).a(this.f879a);
    }
}
