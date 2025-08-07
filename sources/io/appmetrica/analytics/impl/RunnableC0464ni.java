package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.ni  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0464ni implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ U f971a;
    public final /* synthetic */ C0613ti b;

    public RunnableC0464ni(C0613ti c0613ti, U u) {
        this.b = c0613ti;
        this.f971a = u;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0613ti c0613ti = this.b;
        C0613ti.a(c0613ti.f1068a, c0613ti.d, c0613ti.e).a(this.f971a);
    }
}
