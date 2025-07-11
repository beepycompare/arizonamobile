package io.appmetrica.analytics.impl;

import android.content.Context;
import android.os.Bundle;
/* renamed from: io.appmetrica.analytics.impl.wh  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0684wh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1108a;
    public final C0325i6 b;
    public final Bundle c;
    public final C0671w4 d;

    public RunnableC0684wh(Context context, C0325i6 c0325i6, Bundle bundle, C0671w4 c0671w4) {
        this.f1108a = context;
        this.b = c0325i6;
        this.c = bundle;
        this.d = c0671w4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            C0198d4 a2 = C0198d4.a(this.f1108a, this.c);
            if (a2 == null) {
                return;
            }
            C0397l4 a3 = C0397l4.a(a2);
            C0487oj u = Ga.F.u();
            u.a(a2.b.getAppVersion(), a2.b.getAppBuildNumber());
            u.a(a2.b.getDeviceType());
            K4 k4 = new K4(new Wl(a2), new J4(a2.b, AbstractC0753zb.c(a2.f797a.f554a.getAsString("PROCESS_CFG_CLIDS"))), a2.f797a.b);
            this.d.a(a3, k4).a(this.b, k4);
        } catch (Throwable th) {
            Zj zj = AbstractC0736yj.f1149a;
            zj.getClass();
            zj.a(new C0761zj("Exception during processing event with type: " + this.b.d + " (" + this.b.e + "): " + th.getMessage(), th));
        }
    }
}
