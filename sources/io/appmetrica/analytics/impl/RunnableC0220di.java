package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.di  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0220di implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ boolean f806a;
    public final /* synthetic */ C0568ri b;

    public RunnableC0220di(C0568ri c0568ri, boolean z) {
        this.b = c0568ri;
        this.f806a = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0568ri c0568ri = this.b;
        C0568ri.a(c0568ri.f1028a, c0568ri.d, c0568ri.e).setDataSendingEnabled(this.f806a);
    }
}
