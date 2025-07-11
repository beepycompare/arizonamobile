package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.li  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0411li implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ U f925a;
    public final /* synthetic */ C0560ri b;

    public RunnableC0411li(C0560ri c0560ri, U u) {
        this.b = c0560ri;
        this.f925a = u;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0560ri c0560ri = this.b;
        C0560ri.a(c0560ri.f1029a, c0560ri.d, c0560ri.e).a(this.f925a);
    }
}
