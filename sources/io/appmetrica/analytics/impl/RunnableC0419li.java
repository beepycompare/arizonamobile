package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.li  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0419li implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ U f924a;
    public final /* synthetic */ C0568ri b;

    public RunnableC0419li(C0568ri c0568ri, U u) {
        this.b = c0568ri;
        this.f924a = u;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0568ri c0568ri = this.b;
        C0568ri.a(c0568ri.f1028a, c0568ri.d, c0568ri.e).a(this.f924a);
    }
}
