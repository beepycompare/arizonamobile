package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.oi  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0489oi implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ boolean f1018a;
    public final /* synthetic */ Ci b;

    public RunnableC0489oi(Ci ci, boolean z) {
        this.b = ci;
        this.f1018a = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Ci ci = this.b;
        Ci.a(ci.f388a, ci.d, ci.e).setDataSendingEnabled(this.f1018a);
    }
}
