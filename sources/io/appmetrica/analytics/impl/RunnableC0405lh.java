package io.appmetrica.analytics.impl;

import android.content.Context;
import android.os.Bundle;
/* renamed from: io.appmetrica.analytics.impl.lh  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0405lh implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final Context f1100a;
    public final P5 b;
    public final Bundle c;
    public final C0109a4 d;

    public RunnableC0405lh(Context context, P5 p5, Bundle bundle, C0109a4 c0109a4) {
        this.f1100a = context;
        this.b = p5;
        this.c = bundle;
        this.d = c0109a4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            H3 a2 = H3.a(this.f1100a, this.c);
            if (a2 == null) {
                return;
            }
            P3 a3 = P3.a(a2);
            C0227ej v = C0448na.I.v();
            v.a(a2.b.getAppVersion(), a2.b.getAppBuildNumber());
            v.a(a2.b.getDeviceType());
            C0492p4 c0492p4 = new C0492p4(new Zl(a2), new C0467o4(a2.b, AbstractC0271gb.c(a2.f607a.f520a.getAsString("PROCESS_CFG_CLIDS"))), a2.f607a.b);
            this.d.a(a3, c0492p4).a(this.b, c0492p4);
        } catch (Throwable th) {
            Qj qj = AbstractC0482oj.f1158a;
            qj.getClass();
            qj.a(new C0507pj("Exception during processing event with type: " + this.b.d + " (" + this.b.e + "): " + th.getMessage(), th));
        }
    }
}
