package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.di  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0212di implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ boolean f807a;
    public final /* synthetic */ C0560ri b;

    public RunnableC0212di(C0560ri c0560ri, boolean z) {
        this.b = c0560ri;
        this.f807a = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0560ri c0560ri = this.b;
        C0560ri.a(c0560ri.f1029a, c0560ri.d, c0560ri.e).setDataSendingEnabled(this.f807a);
    }
}
