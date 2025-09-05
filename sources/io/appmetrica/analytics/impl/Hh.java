package io.appmetrica.analytics.impl;

import android.content.Context;
import android.os.Bundle;
/* loaded from: classes4.dex */
public final class Hh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final Context f476a;
    public final C0477o6 b;
    public final Bundle c;
    public final C0750z4 d;

    public Hh(Context context, C0477o6 c0477o6, Bundle bundle, C0750z4 c0750z4) {
        this.f476a = context;
        this.b = c0477o6;
        this.c = bundle;
        this.d = c0750z4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            C0268g4 a2 = C0268g4.a(this.f476a, this.c);
            if (a2 == null) {
                return;
            }
            C0475o4 a3 = C0475o4.a(a2);
            Aj u = Na.F.u();
            u.a(a2.b.getAppVersion(), a2.b.getAppBuildNumber());
            u.a(a2.b.getDeviceType());
            N4 n4 = new N4(new C0337im(a2), new M4(a2.b, Gb.c(a2.f884a.f708a.getAsString("PROCESS_CFG_CLIDS"))), a2.f884a.b);
            this.d.a(a3, n4).a(this.b, n4);
        } catch (Throwable th) {
            C0413lk c0413lk = Kj.f538a;
            c0413lk.getClass();
            c0413lk.a(new Lj("Exception during processing event with type: " + this.b.d + " (" + this.b.e + "): " + th.getMessage(), th));
        }
    }
}
