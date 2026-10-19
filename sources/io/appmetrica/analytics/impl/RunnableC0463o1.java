package io.appmetrica.analytics.impl;

import android.app.Activity;
/* renamed from: io.appmetrica.analytics.impl.o1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0463o1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Activity f1129a;
    public final /* synthetic */ C0644v1 b;

    public RunnableC0463o1(C0644v1 c0644v1, Activity activity) {
        this.b = c0644v1;
        this.f1129a = activity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0644v1 c0644v1 = this.b;
        Bl bl = c0644v1.h;
        Activity activity = this.f1129a;
        InterfaceC0369kb interfaceC0369kb = c0644v1.c().f650a;
        if (activity != null) {
            bl.f.a(activity);
        }
        if (bl.e.a(activity, EnumC0487p.PAUSED)) {
            interfaceC0369kb.b(activity);
        }
    }
}
