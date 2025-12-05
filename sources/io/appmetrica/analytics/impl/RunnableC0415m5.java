package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.m5  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0415m5 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ InterfaceC0141be f1087a;
    public final /* synthetic */ C0440n5 b;

    public RunnableC0415m5(C0440n5 c0440n5, InterfaceC0141be interfaceC0141be) {
        this.b = c0440n5;
        this.f1087a = interfaceC0141be;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.b) {
            C0440n5 c0440n5 = this.b;
            Object obj = c0440n5.f1106a;
            if (obj == null) {
                c0440n5.b.add(this.f1087a);
            } else {
                this.f1087a.consume(obj);
            }
        }
    }
}
