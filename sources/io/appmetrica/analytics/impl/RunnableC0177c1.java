package io.appmetrica.analytics.impl;

import android.app.Activity;
/* renamed from: io.appmetrica.analytics.impl.c1  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0177c1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Activity f776a;
    public final /* synthetic */ C0502p1 b;

    public RunnableC0177c1(C0502p1 c0502p1, Activity activity) {
        this.b = c0502p1;
        this.f776a = activity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0502p1 c0502p1 = this.b;
        Uk uk = c0502p1.h;
        Activity activity = this.f776a;
        InterfaceC0161bb interfaceC0161bb = c0502p1.d().f372a;
        if (activity != null) {
            uk.f.a(activity);
        }
        if (uk.e.a(activity, EnumC0475o.RESUMED)) {
            interfaceC0161bb.a(activity);
        }
    }
}
