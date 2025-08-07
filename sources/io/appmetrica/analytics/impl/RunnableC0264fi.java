package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.fi  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0264fi implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ boolean f849a;
    public final /* synthetic */ C0613ti b;

    public RunnableC0264fi(C0613ti c0613ti, boolean z) {
        this.b = c0613ti;
        this.f849a = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0613ti c0613ti = this.b;
        C0613ti.a(c0613ti.f1068a, c0613ti.d, c0613ti.e).setDataSendingEnabled(this.f849a);
    }
}
