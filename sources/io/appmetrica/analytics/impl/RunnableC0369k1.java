package io.appmetrica.analytics.impl;

import android.app.Activity;
/* renamed from: io.appmetrica.analytics.impl.k1  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0369k1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Activity f946a;
    public final /* synthetic */ C0548r1 b;

    public RunnableC0369k1(C0548r1 c0548r1, Activity activity) {
        this.b = c0548r1;
        this.f946a = activity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0548r1 c0548r1 = this.b;
        C0286gl c0286gl = c0548r1.h;
        Activity activity = this.f946a;
        InterfaceC0328ib interfaceC0328ib = c0548r1.d().f517a;
        if (activity != null) {
            c0286gl.f.a(activity);
        }
        if (c0286gl.e.a(activity, EnumC0471o.PAUSED)) {
            interfaceC0328ib.b(activity);
        }
    }
}
