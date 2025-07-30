package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class G5 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ InterfaceC0509pe f448a;
    public final /* synthetic */ H5 b;

    public G5(H5 h5, InterfaceC0509pe interfaceC0509pe) {
        this.b = h5;
        this.f448a = interfaceC0509pe;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.b) {
            H5 h5 = this.b;
            Object obj = h5.f466a;
            if (obj == null) {
                h5.b.add(this.f448a);
            } else {
                this.f448a.consume(obj);
            }
        }
    }
}
