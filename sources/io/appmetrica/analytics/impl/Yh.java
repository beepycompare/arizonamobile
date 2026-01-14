package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class Yh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Qn f870a;
    public final /* synthetic */ C0279gi b;

    public Yh(C0279gi c0279gi, Qn qn) {
        this.b = c0279gi;
        this.f870a = qn;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0279gi c0279gi = this.b;
        C0279gi.a(c0279gi.f1016a, c0279gi.d, c0279gi.e).a(this.f870a);
    }
}
