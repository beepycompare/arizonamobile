package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class V1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ InterfaceC0457ne f667a;
    public final /* synthetic */ R7 b;

    public V1(X1 x1, R7 r7) {
        this.f667a = x1;
        this.b = r7;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f667a.consume(this.b);
    }
}
