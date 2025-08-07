package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.qi  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0539qi implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0613ti f1021a;

    public RunnableC0539qi(C0613ti c0613ti) {
        this.f1021a = c0613ti;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0613ti c0613ti = this.f1021a;
        C0613ti.a(c0613ti.f1068a, c0613ti.d, c0613ti.e).clearAppEnvironment();
    }
}
