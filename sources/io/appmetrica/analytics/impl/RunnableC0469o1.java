package io.appmetrica.analytics.impl;

import android.app.Activity;
/* renamed from: io.appmetrica.analytics.impl.o1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0469o1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Activity f1126a;
    public final /* synthetic */ C0650v1 b;

    public RunnableC0469o1(C0650v1 c0650v1, Activity activity) {
        this.b = c0650v1;
        this.f1126a = activity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0650v1 c0650v1 = this.b;
        Bl bl = c0650v1.h;
        Activity activity = this.f1126a;
        InterfaceC0375kb interfaceC0375kb = c0650v1.c().f647a;
        if (activity != null) {
            bl.f.a(activity);
        }
        if (bl.e.a(activity, EnumC0493p.PAUSED)) {
            interfaceC0375kb.b(activity);
        }
    }
}
