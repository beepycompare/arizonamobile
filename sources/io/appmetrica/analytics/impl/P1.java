package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class P1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ InterfaceC0120ae f734a;
    public final /* synthetic */ C0720y7 b;

    public P1(R1 r1, C0720y7 c0720y7) {
        this.f734a = r1;
        this.b = c0720y7;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f734a.consume(this.b);
    }
}
