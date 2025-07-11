package io.appmetrica.analytics.impl;

import android.app.Activity;
/* renamed from: io.appmetrica.analytics.impl.i1  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0320i1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Activity f872a;
    public final /* synthetic */ C0494p1 b;

    public RunnableC0320i1(C0494p1 c0494p1, Activity activity) {
        this.b = c0494p1;
        this.f872a = activity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0494p1 c0494p1 = this.b;
        Uk uk = c0494p1.h;
        Activity activity = this.f872a;
        InterfaceC0153bb interfaceC0153bb = c0494p1.d().f373a;
        if (activity != null) {
            uk.f.a(activity);
        }
        if (uk.e.a(activity, EnumC0467o.PAUSED)) {
            interfaceC0153bb.b(activity);
        }
    }
}
