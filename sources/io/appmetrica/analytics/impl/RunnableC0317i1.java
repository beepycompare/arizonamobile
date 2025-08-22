package io.appmetrica.analytics.impl;

import android.app.Activity;
/* renamed from: io.appmetrica.analytics.impl.i1  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0317i1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Activity f898a;
    public final /* synthetic */ C0494p1 b;

    public RunnableC0317i1(C0494p1 c0494p1, Activity activity) {
        this.b = c0494p1;
        this.f898a = activity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0494p1 c0494p1 = this.b;
        C0182cl c0182cl = c0494p1.h;
        Activity activity = this.f898a;
        InterfaceC0249fb interfaceC0249fb = c0494p1.d().f455a;
        if (activity != null) {
            c0182cl.f.a(activity);
        }
        if (c0182cl.e.a(activity, EnumC0467o.PAUSED)) {
            interfaceC0249fb.b(activity);
        }
    }
}
