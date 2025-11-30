package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.m5  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0416m5 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ InterfaceC0142be f1004a;
    public final /* synthetic */ C0441n5 b;

    public RunnableC0416m5(C0441n5 c0441n5, InterfaceC0142be interfaceC0142be) {
        this.b = c0441n5;
        this.f1004a = interfaceC0142be;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.b) {
            C0441n5 c0441n5 = this.b;
            Object obj = c0441n5.f1023a;
            if (obj == null) {
                c0441n5.b.add(this.f1004a);
            } else {
                this.f1004a.consume(obj);
            }
        }
    }
}
