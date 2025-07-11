package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.pi  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0511pi implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f993a;
    public final /* synthetic */ C0560ri b;

    public RunnableC0511pi(C0560ri c0560ri, String str) {
        this.b = c0560ri;
        this.f993a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0560ri c0560ri = this.b;
        C0560ri.a(c0560ri.f1029a, c0560ri.d, c0560ri.e).reportEvent(this.f993a);
    }
}
