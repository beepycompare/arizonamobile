package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.ji  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0361ji implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Kn f894a;
    public final /* synthetic */ C0560ri b;

    public RunnableC0361ji(C0560ri c0560ri, Kn kn) {
        this.b = c0560ri;
        this.f894a = kn;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0560ri c0560ri = this.b;
        C0560ri.a(c0560ri.f1029a, c0560ri.d, c0560ri.e).a(this.f894a);
    }
}
