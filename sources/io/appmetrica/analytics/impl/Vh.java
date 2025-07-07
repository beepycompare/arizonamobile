package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class Vh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0568ri f675a;

    public Vh(C0568ri c0568ri) {
        this.f675a = c0568ri;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0568ri c0568ri = this.f675a;
        C0568ri.a(c0568ri.f1028a, c0568ri.d, c0568ri.e).resumeSession();
    }
}
