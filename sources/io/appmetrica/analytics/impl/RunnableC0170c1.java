package io.appmetrica.analytics.impl;

import android.app.Activity;
/* renamed from: io.appmetrica.analytics.impl.c1  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0170c1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Activity f790a;
    public final /* synthetic */ C0497p1 b;

    public RunnableC0170c1(C0497p1 c0497p1, Activity activity) {
        this.b = c0497p1;
        this.f790a = activity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0497p1 c0497p1 = this.b;
        Xk xk = c0497p1.h;
        Activity activity = this.f790a;
        InterfaceC0206db interfaceC0206db = c0497p1.d().f416a;
        if (activity != null) {
            xk.f.a(activity);
        }
        if (xk.e.a(activity, EnumC0470o.RESUMED)) {
            interfaceC0206db.a(activity);
        }
    }
}
