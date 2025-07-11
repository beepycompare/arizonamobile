package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class Wh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0560ri f690a;

    public Wh(C0560ri c0560ri) {
        this.f690a = c0560ri;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0560ri c0560ri = this.f690a;
        C0560ri.a(c0560ri.f1029a, c0560ri.d, c0560ri.e).pauseSession();
    }
}
