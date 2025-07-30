package io.appmetrica.analytics.impl;

import android.content.Context;
import android.os.Bundle;
/* renamed from: io.appmetrica.analytics.impl.yh  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0736yh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1157a;
    public final C0401l6 b;
    public final Bundle c;
    public final C0673w4 d;

    public RunnableC0736yh(Context context, C0401l6 c0401l6, Bundle bundle, C0673w4 c0673w4) {
        this.f1157a = context;
        this.b = c0401l6;
        this.c = bundle;
        this.d = c0673w4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            C0198d4 a2 = C0198d4.a(this.f1157a, this.c);
            if (a2 == null) {
                return;
            }
            C0399l4 a3 = C0399l4.a(a2);
            C0563rj u = Ia.F.u();
            u.a(a2.b.getAppVersion(), a2.b.getAppBuildNumber());
            u.a(a2.b.getDeviceType());
            K4 k4 = new K4(new Zl(a2), new J4(a2.b, Bb.c(a2.f812a.f596a.getAsString("PROCESS_CFG_CLIDS"))), a2.f812a.b);
            this.d.a(a3, k4).a(this.b, k4);
        } catch (Throwable th) {
            C0188ck c0188ck = Bj.f362a;
            c0188ck.getClass();
            c0188ck.a(new Cj("Exception during processing event with type: " + this.b.d + " (" + this.b.e + "): " + th.getMessage(), th));
        }
    }
}
