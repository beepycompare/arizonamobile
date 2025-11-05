package io.appmetrica.analytics.impl;
/* loaded from: classes3.dex */
public final class Y1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ InterfaceC0297he f763a;
    public final /* synthetic */ G7 b;

    public Y1(C0104a2 c0104a2, G7 g7) {
        this.f763a = c0104a2;
        this.b = g7;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f763a.consume(this.b);
    }
}
