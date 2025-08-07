package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class G5 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ InterfaceC0510pe f447a;
    public final /* synthetic */ H5 b;

    public G5(H5 h5, InterfaceC0510pe interfaceC0510pe) {
        this.b = h5;
        this.f447a = interfaceC0510pe;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.b) {
            H5 h5 = this.b;
            Object obj = h5.f465a;
            if (obj == null) {
                h5.b.add(this.f447a);
            } else {
                this.f447a.consume(obj);
            }
        }
    }
}
