package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.qi  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0538qi implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0612ti f1022a;

    public RunnableC0538qi(C0612ti c0612ti) {
        this.f1022a = c0612ti;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0612ti c0612ti = this.f1022a;
        C0612ti.a(c0612ti.f1069a, c0612ti.d, c0612ti.e).clearAppEnvironment();
    }
}
