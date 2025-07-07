package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class E5 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ InterfaceC0465ne f401a;
    public final /* synthetic */ F5 b;

    public E5(F5 f5, InterfaceC0465ne interfaceC0465ne) {
        this.b = f5;
        this.f401a = interfaceC0465ne;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.b) {
            F5 f5 = this.b;
            Object obj = f5.f423a;
            if (obj == null) {
                f5.b.add(this.f401a);
            } else {
                this.f401a.consume(obj);
            }
        }
    }
}
