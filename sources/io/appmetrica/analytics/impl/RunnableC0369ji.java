package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.ji  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0369ji implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Kn f893a;
    public final /* synthetic */ C0568ri b;

    public RunnableC0369ji(C0568ri c0568ri, Kn kn) {
        this.b = c0568ri;
        this.f893a = kn;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0568ri c0568ri = this.b;
        C0568ri.a(c0568ri.f1028a, c0568ri.d, c0568ri.e).a(this.f893a);
    }
}
