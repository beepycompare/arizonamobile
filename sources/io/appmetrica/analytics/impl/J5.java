package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class J5 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ InterfaceC0660ve f506a;
    public final /* synthetic */ K5 b;

    public J5(K5 k5, InterfaceC0660ve interfaceC0660ve) {
        this.b = k5;
        this.f506a = interfaceC0660ve;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.b) {
            K5 k5 = this.b;
            Object obj = k5.f528a;
            if (obj == null) {
                k5.b.add(this.f506a);
            } else {
                this.f506a.consume(obj);
            }
        }
    }
}
