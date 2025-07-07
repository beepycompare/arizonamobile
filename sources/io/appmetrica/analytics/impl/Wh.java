package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class Wh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0568ri f689a;

    public Wh(C0568ri c0568ri) {
        this.f689a = c0568ri;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0568ri c0568ri = this.f689a;
        C0568ri.a(c0568ri.f1028a, c0568ri.d, c0568ri.e).pauseSession();
    }
}
