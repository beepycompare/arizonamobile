package io.appmetrica.analytics.impl;

import android.app.Activity;
/* renamed from: io.appmetrica.analytics.impl.c1  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0169c1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Activity f790a;
    public final /* synthetic */ C0496p1 b;

    public RunnableC0169c1(C0496p1 c0496p1, Activity activity) {
        this.b = c0496p1;
        this.f790a = activity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0496p1 c0496p1 = this.b;
        Xk xk = c0496p1.h;
        Activity activity = this.f790a;
        InterfaceC0205db interfaceC0205db = c0496p1.d().f416a;
        if (activity != null) {
            xk.f.a(activity);
        }
        if (xk.e.a(activity, EnumC0469o.RESUMED)) {
            interfaceC0205db.a(activity);
        }
    }
}
