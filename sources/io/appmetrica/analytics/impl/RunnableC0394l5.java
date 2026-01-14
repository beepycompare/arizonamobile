package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.l5  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0394l5 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ InterfaceC0120ae f1092a;
    public final /* synthetic */ C0419m5 b;

    public RunnableC0394l5(C0419m5 c0419m5, InterfaceC0120ae interfaceC0120ae) {
        this.b = c0419m5;
        this.f1092a = interfaceC0120ae;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.b) {
            C0419m5 c0419m5 = this.b;
            Object obj = c0419m5.f1111a;
            if (obj == null) {
                c0419m5.b.add(this.f1092a);
            } else {
                this.f1092a.consume(obj);
            }
        }
    }
}
