package io.appmetrica.analytics.impl;

import android.app.Activity;
/* renamed from: io.appmetrica.analytics.impl.j1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0333j1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Activity f1048a;
    public final /* synthetic */ C0644v1 b;

    public RunnableC0333j1(C0644v1 c0644v1, Activity activity) {
        this.b = c0644v1;
        this.f1048a = activity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0644v1 c0644v1 = this.b;
        Bl bl = c0644v1.h;
        Activity activity = this.f1048a;
        InterfaceC0369kb interfaceC0369kb = c0644v1.c().f650a;
        if (activity != null) {
            bl.f.a(activity);
        }
        if (bl.e.a(activity, EnumC0487p.RESUMED)) {
            interfaceC0369kb.a(activity);
        }
    }
}
