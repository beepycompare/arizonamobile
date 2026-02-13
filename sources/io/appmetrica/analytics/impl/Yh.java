package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class Yh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Qn f869a;
    public final /* synthetic */ C0279gi b;

    public Yh(C0279gi c0279gi, Qn qn) {
        this.b = c0279gi;
        this.f869a = qn;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0279gi c0279gi = this.b;
        C0279gi.a(c0279gi.f1015a, c0279gi.d, c0279gi.e).a(this.f869a);
    }
}
