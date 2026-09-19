package io.appmetrica.analytics.impl;

import android.app.Activity;
/* renamed from: io.appmetrica.analytics.impl.j1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0338j1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Activity f1045a;
    public final /* synthetic */ C0649v1 b;

    public RunnableC0338j1(C0649v1 c0649v1, Activity activity) {
        this.b = c0649v1;
        this.f1045a = activity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0649v1 c0649v1 = this.b;
        Bl bl = c0649v1.h;
        Activity activity = this.f1045a;
        InterfaceC0374kb interfaceC0374kb = c0649v1.c().f647a;
        if (activity != null) {
            bl.f.a(activity);
        }
        if (bl.e.a(activity, EnumC0492p.RESUMED)) {
            interfaceC0374kb.a(activity);
        }
    }
}
