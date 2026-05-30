package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class B5 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Be f468a;
    public final /* synthetic */ C5 b;

    public B5(C5 c5, Be be) {
        this.b = c5;
        this.f468a = be;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.b) {
            C5 c5 = this.b;
            Object obj = c5.f488a;
            if (obj == null) {
                c5.b.add(this.f468a);
            } else {
                this.f468a.consume(obj);
            }
        }
    }
}
