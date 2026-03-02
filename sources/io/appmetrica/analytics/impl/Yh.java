package io.appmetrica.analytics.impl;
/* loaded from: classes5.dex */
public final class Yh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Qn f869a;
    public final /* synthetic */ C0278gi b;

    public Yh(C0278gi c0278gi, Qn qn) {
        this.b = c0278gi;
        this.f869a = qn;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0278gi c0278gi = this.b;
        C0278gi.a(c0278gi.f1015a, c0278gi.d, c0278gi.e).a(this.f869a);
    }
}
