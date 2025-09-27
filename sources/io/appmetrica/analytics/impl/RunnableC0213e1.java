package io.appmetrica.analytics.impl;

import android.app.Activity;
/* renamed from: io.appmetrica.analytics.impl.e1  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0213e1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Activity f854a;
    public final /* synthetic */ C0547r1 b;

    public RunnableC0213e1(C0547r1 c0547r1, Activity activity) {
        this.b = c0547r1;
        this.f854a = activity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0547r1 c0547r1 = this.b;
        C0285gl c0285gl = c0547r1.h;
        Activity activity = this.f854a;
        InterfaceC0327ib interfaceC0327ib = c0547r1.d().f517a;
        if (activity != null) {
            c0285gl.f.a(activity);
        }
        if (c0285gl.e.a(activity, EnumC0470o.RESUMED)) {
            interfaceC0327ib.a(activity);
        }
    }
}
