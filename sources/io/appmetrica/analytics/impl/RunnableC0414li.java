package io.appmetrica.analytics.impl;
/* renamed from: io.appmetrica.analytics.impl.li  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0414li implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Nn f940a;
    public final /* synthetic */ C0613ti b;

    public RunnableC0414li(C0613ti c0613ti, Nn nn) {
        this.b = c0613ti;
        this.f940a = nn;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0613ti c0613ti = this.b;
        C0613ti.a(c0613ti.f1068a, c0613ti.d, c0613ti.e).a(this.f940a);
    }
}
