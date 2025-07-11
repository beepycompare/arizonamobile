package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class E5 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ InterfaceC0457ne f402a;
    public final /* synthetic */ F5 b;

    public E5(F5 f5, InterfaceC0457ne interfaceC0457ne) {
        this.b = f5;
        this.f402a = interfaceC0457ne;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.b) {
            F5 f5 = this.b;
            Object obj = f5.f424a;
            if (obj == null) {
                f5.b.add(this.f402a);
            } else {
                this.f402a.consume(obj);
            }
        }
    }
}
