package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class Vh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0560ri f676a;

    public Vh(C0560ri c0560ri) {
        this.f676a = c0560ri;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0560ri c0560ri = this.f676a;
        C0560ri.a(c0560ri.f1029a, c0560ri.d, c0560ri.e).resumeSession();
    }
}
