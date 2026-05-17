package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class P1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ InterfaceC0119ae f738a;
    public final /* synthetic */ C0719y7 b;

    public P1(R1 r1, C0719y7 c0719y7) {
        this.f738a = r1;
        this.b = c0719y7;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f738a.consume(this.b);
    }
}
