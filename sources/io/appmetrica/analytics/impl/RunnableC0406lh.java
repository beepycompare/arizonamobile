package io.appmetrica.analytics.impl;

import android.content.Context;
import android.os.Bundle;
/* renamed from: io.appmetrica.analytics.impl.lh  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0406lh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1100a;
    public final P5 b;
    public final Bundle c;
    public final C0110a4 d;

    public RunnableC0406lh(Context context, P5 p5, Bundle bundle, C0110a4 c0110a4) {
        this.f1100a = context;
        this.b = p5;
        this.c = bundle;
        this.d = c0110a4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            H3 a2 = H3.a(this.f1100a, this.c);
            if (a2 == null) {
                return;
            }
            P3 a3 = P3.a(a2);
            C0228ej v = C0449na.I.v();
            v.a(a2.b.getAppVersion(), a2.b.getAppBuildNumber());
            v.a(a2.b.getDeviceType());
            C0493p4 c0493p4 = new C0493p4(new Zl(a2), new C0468o4(a2.b, AbstractC0272gb.c(a2.f607a.f520a.getAsString("PROCESS_CFG_CLIDS"))), a2.f607a.b);
            this.d.a(a3, c0493p4).a(this.b, c0493p4);
        } catch (Throwable th) {
            Qj qj = AbstractC0483oj.f1158a;
            qj.getClass();
            qj.a(new C0508pj("Exception during processing event with type: " + this.b.d + " (" + this.b.e + "): " + th.getMessage(), th));
        }
    }
}
