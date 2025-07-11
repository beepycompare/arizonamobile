package io.appmetrica.analytics.impl;

import android.app.Activity;
/* renamed from: io.appmetrica.analytics.impl.c1  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0169c1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Activity f777a;
    public final /* synthetic */ C0494p1 b;

    public RunnableC0169c1(C0494p1 c0494p1, Activity activity) {
        this.b = c0494p1;
        this.f777a = activity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0494p1 c0494p1 = this.b;
        Uk uk = c0494p1.h;
        Activity activity = this.f777a;
        InterfaceC0153bb interfaceC0153bb = c0494p1.d().f373a;
        if (activity != null) {
            uk.f.a(activity);
        }
        if (uk.e.a(activity, EnumC0467o.RESUMED)) {
            interfaceC0153bb.a(activity);
        }
    }
}
