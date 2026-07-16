package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class B5 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Be f470a;
    public final /* synthetic */ C5 b;

    public B5(C5 c5, Be be) {
        this.b = c5;
        this.f470a = be;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.b) {
            C5 c5 = this.b;
            Object obj = c5.f490a;
            if (obj == null) {
                c5.b.add(this.f470a);
            } else {
                this.f470a.consume(obj);
            }
        }
    }
}
