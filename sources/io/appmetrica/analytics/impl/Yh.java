package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class Yh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0612ti f737a;

    public Yh(C0612ti c0612ti) {
        this.f737a = c0612ti;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0612ti c0612ti = this.f737a;
        C0612ti.a(c0612ti.f1069a, c0612ti.d, c0612ti.e).pauseSession();
    }
}
