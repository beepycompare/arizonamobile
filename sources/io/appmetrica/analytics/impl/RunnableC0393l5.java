package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.l5  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0393l5 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ InterfaceC0119ae f1096a;
    public final /* synthetic */ C0418m5 b;

    public RunnableC0393l5(C0418m5 c0418m5, InterfaceC0119ae interfaceC0119ae) {
        this.b = c0418m5;
        this.f1096a = interfaceC0119ae;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.b) {
            C0418m5 c0418m5 = this.b;
            Object obj = c0418m5.f1115a;
            if (obj == null) {
                c0418m5.b.add(this.f1096a);
            } else {
                this.f1096a.consume(obj);
            }
        }
    }
}
