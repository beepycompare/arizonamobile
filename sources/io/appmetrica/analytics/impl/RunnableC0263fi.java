package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.fi  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0263fi implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ boolean f849a;
    public final /* synthetic */ C0612ti b;

    public RunnableC0263fi(C0612ti c0612ti, boolean z) {
        this.b = c0612ti;
        this.f849a = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0612ti c0612ti = this.b;
        C0612ti.a(c0612ti.f1068a, c0612ti.d, c0612ti.e).setDataSendingEnabled(this.f849a);
    }
}
