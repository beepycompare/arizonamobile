package io.appmetrica.analytics.impl;

import android.content.Context;
import android.os.Bundle;
/* loaded from: classes4.dex */
public final class Dh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final Context f399a;
    public final C0399l6 b;
    public final Bundle c;
    public final C0671w4 d;

    public Dh(Context context, C0399l6 c0399l6, Bundle bundle, C0671w4 c0671w4) {
        this.f399a = context;
        this.b = c0399l6;
        this.c = bundle;
        this.d = c0671w4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            C0191d4 a2 = C0191d4.a(this.f399a, this.c);
            if (a2 == null) {
                return;
            }
            C0397l4 a3 = C0397l4.a(a2);
            C0686wj u = Ka.F.u();
            u.a(a2.b.getAppVersion(), a2.b.getAppBuildNumber());
            u.a(a2.b.getDeviceType());
            K4 k4 = new K4(new C0234em(a2), new J4(a2.b, Db.c(a2.f823a.f635a.getAsString("PROCESS_CFG_CLIDS"))), a2.f823a.b);
            this.d.a(a3, k4).a(this.b, k4);
        } catch (Throwable th) {
            C0310hk c0310hk = Gj.f460a;
            c0310hk.getClass();
            c0310hk.a(new Hj("Exception during processing event with type: " + this.b.d + " (" + this.b.e + "): " + th.getMessage(), th));
        }
    }
}
