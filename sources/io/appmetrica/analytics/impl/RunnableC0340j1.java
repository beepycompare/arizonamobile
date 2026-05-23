package io.appmetrica.analytics.impl;

import android.app.Activity;
/* renamed from: io.appmetrica.analytics.impl.j1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0340j1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Activity f1042a;
    public final /* synthetic */ C0651v1 b;

    public RunnableC0340j1(C0651v1 c0651v1, Activity activity) {
        this.b = c0651v1;
        this.f1042a = activity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0651v1 c0651v1 = this.b;
        Bl bl = c0651v1.h;
        Activity activity = this.f1042a;
        InterfaceC0376kb interfaceC0376kb = c0651v1.c().f644a;
        if (activity != null) {
            bl.f.a(activity);
        }
        if (bl.e.a(activity, EnumC0494p.RESUMED)) {
            interfaceC0376kb.a(activity);
        }
    }
}
