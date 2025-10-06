package io.appmetrica.analytics.impl;

import android.app.Activity;
/* renamed from: io.appmetrica.analytics.impl.e1  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0214e1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Activity f854a;
    public final /* synthetic */ C0548r1 b;

    public RunnableC0214e1(C0548r1 c0548r1, Activity activity) {
        this.b = c0548r1;
        this.f854a = activity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0548r1 c0548r1 = this.b;
        C0286gl c0286gl = c0548r1.h;
        Activity activity = this.f854a;
        InterfaceC0328ib interfaceC0328ib = c0548r1.d().f517a;
        if (activity != null) {
            c0286gl.f.a(activity);
        }
        if (c0286gl.e.a(activity, EnumC0471o.RESUMED)) {
            interfaceC0328ib.a(activity);
        }
    }
}
