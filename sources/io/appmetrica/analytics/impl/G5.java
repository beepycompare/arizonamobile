package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class G5 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ InterfaceC0556re f449a;
    public final /* synthetic */ H5 b;

    public G5(H5 h5, InterfaceC0556re interfaceC0556re) {
        this.b = h5;
        this.f449a = interfaceC0556re;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.b) {
            H5 h5 = this.b;
            Object obj = h5.f470a;
            if (obj == null) {
                h5.b.add(this.f449a);
            } else {
                this.f449a.consume(obj);
            }
        }
    }
}
