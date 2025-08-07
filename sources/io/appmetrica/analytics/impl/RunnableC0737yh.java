package io.appmetrica.analytics.impl;

import android.content.Context;
import android.os.Bundle;
/* renamed from: io.appmetrica.analytics.impl.yh  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0737yh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1156a;
    public final C0402l6 b;
    public final Bundle c;
    public final C0674w4 d;

    public RunnableC0737yh(Context context, C0402l6 c0402l6, Bundle bundle, C0674w4 c0674w4) {
        this.f1156a = context;
        this.b = c0402l6;
        this.c = bundle;
        this.d = c0674w4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            C0199d4 a2 = C0199d4.a(this.f1156a, this.c);
            if (a2 == null) {
                return;
            }
            C0400l4 a3 = C0400l4.a(a2);
            C0564rj u = Ia.F.u();
            u.a(a2.b.getAppVersion(), a2.b.getAppBuildNumber());
            u.a(a2.b.getDeviceType());
            K4 k4 = new K4(new Zl(a2), new J4(a2.b, Bb.c(a2.f811a.f595a.getAsString("PROCESS_CFG_CLIDS"))), a2.f811a.b);
            this.d.a(a3, k4).a(this.b, k4);
        } catch (Throwable th) {
            C0189ck c0189ck = Bj.f361a;
            c0189ck.getClass();
            c0189ck.a(new Cj("Exception during processing event with type: " + this.b.d + " (" + this.b.e + "): " + th.getMessage(), th));
        }
    }
}
