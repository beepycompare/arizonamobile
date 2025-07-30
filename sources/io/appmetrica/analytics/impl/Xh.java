package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class Xh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0612ti f721a;

    public Xh(C0612ti c0612ti) {
        this.f721a = c0612ti;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0612ti c0612ti = this.f721a;
        C0612ti.a(c0612ti.f1069a, c0612ti.d, c0612ti.e).resumeSession();
    }
}
