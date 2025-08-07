package io.appmetrica.analytics.impl;
/* loaded from: classes4.dex */
public final class Xh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0613ti f720a;

    public Xh(C0613ti c0613ti) {
        this.f720a = c0613ti;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0613ti c0613ti = this.f720a;
        C0613ti.a(c0613ti.f1068a, c0613ti.d, c0613ti.e).resumeSession();
    }
}
