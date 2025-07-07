package io.appmetrica.analytics.impl;

import android.content.Context;
import android.os.Bundle;
/* renamed from: io.appmetrica.analytics.impl.wh  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0692wh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1107a;
    public final C0333i6 b;
    public final Bundle c;
    public final C0679w4 d;

    public RunnableC0692wh(Context context, C0333i6 c0333i6, Bundle bundle, C0679w4 c0679w4) {
        this.f1107a = context;
        this.b = c0333i6;
        this.c = bundle;
        this.d = c0679w4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            C0206d4 a2 = C0206d4.a(this.f1107a, this.c);
            if (a2 == null) {
                return;
            }
            C0405l4 a3 = C0405l4.a(a2);
            C0495oj u = Ga.F.u();
            u.a(a2.b.getAppVersion(), a2.b.getAppBuildNumber());
            u.a(a2.b.getDeviceType());
            K4 k4 = new K4(new Wl(a2), new J4(a2.b, AbstractC0761zb.c(a2.f796a.f553a.getAsString("PROCESS_CFG_CLIDS"))), a2.f796a.b);
            this.d.a(a3, k4).a(this.b, k4);
        } catch (Throwable th) {
            Zj zj = AbstractC0744yj.f1148a;
            zj.getClass();
            zj.a(new C0769zj("Exception during processing event with type: " + this.b.d + " (" + this.b.e + "): " + th.getMessage(), th));
        }
    }
}
