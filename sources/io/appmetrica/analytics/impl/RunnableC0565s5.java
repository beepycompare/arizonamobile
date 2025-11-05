package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.s5  reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class RunnableC0565s5 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ InterfaceC0297he f1106a;
    public final /* synthetic */ C0590t5 b;

    public RunnableC0565s5(C0590t5 c0590t5, InterfaceC0297he interfaceC0297he) {
        this.b = c0590t5;
        this.f1106a = interfaceC0297he;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.b) {
            C0590t5 c0590t5 = this.b;
            Object obj = c0590t5.f1126a;
            if (obj == null) {
                c0590t5.b.add(this.f1106a);
            } else {
                this.f1106a.consume(obj);
            }
        }
    }
}
