package io.appmetrica.analytics.impl;

import android.content.Context;
import android.os.Bundle;
/* loaded from: classes5.dex */
public final class Fh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final Context f548a;
    public final C0242f6 b;
    public final Bundle c;
    public final C0550r4 d;

    public Fh(Context context, C0242f6 c0242f6, Bundle bundle, C0550r4 c0550r4) {
        this.f548a = context;
        this.b = c0242f6;
        this.c = bundle;
        this.d = c0550r4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            Y3 a2 = Y3.a(this.f548a, this.c);
            if (a2 == null) {
                return;
            }
            C0266g4 a3 = C0266g4.a(a2);
            Fj v = Na.I.v();
            v.a(a2.b.getAppVersion(), a2.b.getAppBuildNumber());
            v.a(a2.b.getDeviceType());
            G4 g4 = new G4(new Bm(a2), new F4(a2.b, Ib.c(a2.f850a.f928a.getAsString("PROCESS_CFG_CLIDS"))), a2.f850a.b);
            this.d.a(a3, g4).a(this.b, g4);
        } catch (Throwable th) {
            C0541qk c0541qk = Oj.f706a;
            c0541qk.getClass();
            c0541qk.a(new Pj("Exception during processing event with type: " + this.b.d + " (" + this.b.e + "): " + th.getMessage(), th));
        }
    }
}
